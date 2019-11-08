package com.example.demo.smm.controller;

import com.example.demo.smm.mapper.entity.UserInfo;
import com.example.demo.smm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * 多线程测试
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
@RequestMapping("/threadTest")
@RestController
public class ThreadTestController {

    @Autowired
    private UserInfoService userInfoService;
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20
            , 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1));

    @RequestMapping("/test")
    public String test() {

        for (int i = 0 ; i< 20 ; i++) {
            Mytask mytask = new Mytask("客人" + i);
            threadPoolExecutor.execute(mytask);
        }
        return "执行完成";
    }

    class Mytask implements Runnable {

        private String userName = "";

        public Mytask(String userName) {
            this.userName = userName;
        }
        @Override
        public void run() {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userName);
            userInfoService.insertUserInfo(userInfo);
        }
    }

}

