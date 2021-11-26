package com.example.demo.interceptor;

import com.example.demo.annotation.JohnDataResponse;
import com.example.demo.dto.JohnCustomResponse;
import com.example.demo.dto.JohnStatus;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class JohnResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getContainingClass().isAnnotationPresent(RestController.class);
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        var method = returnType.getMethod();

        if (method != null) {
            if (method.isAnnotationPresent(JohnDataResponse.class)) {
                var johnResponse = new JohnCustomResponse();
                johnResponse.setJohn(body);
                johnResponse.setStatus(JohnStatus.builder().code("john").desc("spring").build());
                return johnResponse;
            }
        }
        return body;
    }
}
