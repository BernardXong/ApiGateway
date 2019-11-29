package com.xy.api;


import com.xy.api.init.NettyInitialServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

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
    }
}
