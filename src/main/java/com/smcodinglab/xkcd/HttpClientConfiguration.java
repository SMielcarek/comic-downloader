package com.smcodinglab.xkcd;

import com.smcodinglab.xkcd.properties.XKCDProperties;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class HttpClientConfiguration {

    private final XKCDProperties xkcdProperties;

    @Autowired
    public HttpClientConfiguration(XKCDProperties xkcdProperties) {
        this.xkcdProperties = xkcdProperties;
    }

    @Bean
    public OkHttpClient getHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (xkcdProperties.isProxyRequired()) {
            builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(xkcdProperties.getProxyUrl(), xkcdProperties.getProxyPort())));
        }
        return builder.build();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
