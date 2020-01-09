package com.xy.api;


import com.xy.api.init.GatewayExecutor;
import com.xy.api.init.NettyInitialServer;
import com.xy.api.model.FieldDTO;
import com.xy.api.utils.AssemblyTitle;
import com.xy.api.utils.RedisUtil;
import com.xy.api.utils.StringSymbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * GatewayCoreApplication
 *
 * @Description 网关核心启动类
 * @Author Bernie【xiongyun100@163.com】
 * @Date 2019/6/9
 */
@EnableAsync
@ServletComponentScan
@SpringBootApplication
public class GatewayCoreApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private static final Logger log = LogManager.getLogger(GatewayCoreApplication.class);
    @Resource
    private NettyInitialServer nettyInitialServer;
    //@Autowired
    //private RedisUtil redisUtil;



    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GatewayCoreApplication.class);
        application.run(args);
        log.info("api-core Service startup complete. (网关核心模块启动完成。)");

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    /**
     * 跨域过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        //这两句不加不能跨域上传文件
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("api-core netty init startup . (网关核心netty组件启动。)");
        nettyInitialServer.run();
//        Map<String,FieldDTO> params = new HashMap<>(16);
//        FieldDTO fieldDTO = new FieldDTO();
//        fieldDTO.setTitle(AssemblyTitle.AUTHEN.getTitle() + StringSymbol.SEPARATOR + "expire");
//        String fieldName = "expire";
//        fieldDTO.setName(fieldName);
//        fieldDTO.setDefaultValue("86400");
//        fieldDTO.setRequired(true);
//        fieldDTO.setDescription("认证鉴权过期时间定义");
//            params.put("expire",fieldDTO);
//        redisUtil.set(AssemblyTitle.AUTHEN.getTitle(),params);

        //authentication cache flowControl log router
//        Set<String> params = new HashSet<>(16);
//        params.add("authentication");
//        params.add("cache");
//        params.add("flowControl");
//        params.add("log");
//        params.add("router");
//        redisUtil.set("assembly",params);

    }


}
