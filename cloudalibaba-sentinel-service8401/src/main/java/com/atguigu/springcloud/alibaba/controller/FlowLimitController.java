package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/testA")
    public String testA()
    {
        /*try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
//        log.info(Thread.currentThread().getName()+"\t"+"....testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"....testB");
        return "------testB";
    }

    @GetMapping("/order/query")
    public String query()
    {
        return orderService.queryGoods();
    }

    @GetMapping("/order/save")
    public String save()
    {
        return orderService.queryGoods();
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");

        int age = 10/0;
        log.info("testD 异常比例");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试数比例");
        int age = 10/0;
        return "------testE 测试数比例";
    }

    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "deal_testHostKey")
//    @SentinelResource(value = "testHostKey") 将会报错 error page
    public String testHostKey(@RequestParam(value = "p1",required = false)String p1,
                              @RequestParam(value = "p2",required = false)String p2){
        int age = 10/0;
        return "-----------testHostKey";
    }

    public String deal_testHostKey(String p1, String p2, BlockException exception){
        return "-----------deal_testHostKey,/(ㄒoㄒ)/~~";
    }
}
