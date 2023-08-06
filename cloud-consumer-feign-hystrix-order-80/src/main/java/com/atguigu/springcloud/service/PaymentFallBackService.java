package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentFallBackService fall back paymentInfo_OK ,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentTimeout_OK(Integer id) {
        return "-------PaymentFallBackService fall back paymentTimeout_OK ,/(ㄒoㄒ)/~~";

    }
}
