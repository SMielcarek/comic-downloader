package com.smcodinglab.xkcd;

import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class HttpClientConfiguration {

    @Bean
    public OkHttpClient getHttpClient() {
        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("http.proxy.fmr.com", 8000));
        return new OkHttpClient.Builder().build();
    }

}
