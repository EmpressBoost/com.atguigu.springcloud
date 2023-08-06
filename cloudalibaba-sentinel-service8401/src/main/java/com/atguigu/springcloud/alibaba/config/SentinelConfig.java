package com.atguigu.springcloud.alibaba.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SentinelConfig {
//    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        // 入口资源关闭聚合   解决流控链路不生效的问题
//        registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
        registration.addInitParameter("WEB_CONTEXT_UNIFY", "false");
        registration.setName("sentinelFilter");
        registration.setOrder(1);
        return registration;

//        Registration.setfilter(new commonfilter());
//        Registration.addurlpatterns(“/*”);
//        //入口资源关闭聚合Registration.addinitparameter(commonfilter.WEB_CONTEXT_UNIFY;VALUE”false”);
//        Registration.setname(“sentinelfilter”);
//        Registration.setorder(1);
//        Return registration
    }
}