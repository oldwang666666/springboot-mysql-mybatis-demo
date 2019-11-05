package com.example.demo.smm.controller;

import com.example.demo.smm.mapper.entity.UserInfo;
import com.example.demo.smm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息控制层
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
@RequestMapping("/user")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/getUserInfoById")
    public UserInfo getUserInfoById(Long id) throws Exception {

        return userInfoService.getUserInfoById(id);
    }

    @RequestMapping("/getUserInfoList")
    public List<UserInfo> getUserInfoById(UserInfo userInfo) {

        return userInfoService.getUserInfoList(userInfo);
    }

}
