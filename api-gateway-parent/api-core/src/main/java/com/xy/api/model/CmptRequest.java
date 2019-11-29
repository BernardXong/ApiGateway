package com.xy.api.model;


import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpVersion;

/**
 * @Author: Bernie
 * @CreateTime: 2019-11-28 14:41
 * @Description: httpRequest封装类
 * @Company: Bernie House
 * @Email: xiongyun100@163.com
 */

public class CmptRequest implements HttpRequest {

    private String cmptUri;
    private HttpMethod cmptHttpMethod;
    private HttpVersion cmptHttpVersion;
    private DecoderResult cmptDecoderResult;

    public CmptRequest(HttpMethod method){
        this.cmptHttpMethod = method;
    }
    @Override
    public HttpMethod method() {
        return this.cmptHttpMethod;
    }

    @Override
    public HttpRequest setMethod(HttpMethod httpMethod) {
        this.cmptHttpMethod = httpMethod;
        return this;
    }

    @Override
    public String uri() {
        return this.cmptUri;
    }

    @Override
    public HttpRequest setUri(String s) {
        this.cmptUri = s;
        return this;
    }

    @Override
    public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
        this.cmptHttpVersion = httpVersion;
        return this;
    }

    @Override
    public HttpVersion protocolVersion() {
        return this.cmptHttpVersion;
    }

    @Override
    public HttpHeaders headers() {
        return this.headers();
    }

    @Override
    public DecoderResult decoderResult() {
        return this.cmptDecoderResult;
    }

    @Override
    public void setDecoderResult(DecoderResult decoderResult) {
        this.cmptDecoderResult = decoderResult;
    }

    @Override
    public HttpMethod getMethod() {
        return null;
    }

    @Override
    public String getUri() {
        return null;
    }

    @Override
    public HttpVersion getProtocolVersion() {
        return null;
    }

    @Override
    public DecoderResult getDecoderResult() {
        return null;
    }
}
