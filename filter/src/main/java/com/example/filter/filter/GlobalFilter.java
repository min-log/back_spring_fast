package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //전처리
            //Filter에서는 전달 받은 값을 변형 가능하다.
            //HttpServletRequest = ServletRequest를 상속 받은
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper ((HttpServletResponse) response);
        String url = httpServletRequest.getRequestURI(); //어떤 주소로 요청했는지
        // BufferedReader 로 서버에서 요청온 내용을 읽음.
        BufferedReader br = httpServletRequest.getReader();
        br.lines().forEach(line->{
            log.info("url:{},line : {}",url,line);
        });



        chain.doFilter(httpServletRequest,httpServletResponse);
        //후처리


        //req
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}",url,reqContent);
        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();

        log.info("response status : {}, response body : {}",httpStatus,resContent);
    }
}
