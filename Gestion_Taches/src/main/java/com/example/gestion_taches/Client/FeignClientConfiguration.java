
package com.example.gestion_taches.Client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

    }
}

