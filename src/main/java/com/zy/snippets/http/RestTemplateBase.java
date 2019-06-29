package com.zy.snippets.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zy
 * @Date: 2018/12/8 15:53
 */
@Slf4j
public class RestTemplateBase {

    private RestTemplate restTemplate;

    public RestTemplate getRestTemplate() {
        if (restTemplate != null) {
            return restTemplate;
        }
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(10000);
        requestFactory.setConnectTimeout(10000);
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        log.info("SimpleRestClient初始化完成");
        return restTemplate;
    }
}
