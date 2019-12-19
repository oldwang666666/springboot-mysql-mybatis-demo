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

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/getUserInfoById")
    public UserInfo getUserInfoById(Long id) throws Exception {

        return userInfoService.getUserInfoById(id);
    }

    /**
     * 查询用户列表
     * @param userInfo
     * @return
     */
    @RequestMapping("/getUserInfoList")
    public List<UserInfo> getUserInfoById(UserInfo userInfo) {

        return userInfoService.getUserInfoList(userInfo);
    }

    /**
     * 插入用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping("/insertUserInfo")
    public Long insertUserInfo(UserInfo userInfo){
        Long result = userInfoService.insertUserInfo(userInfo);
        return result;
    }

    /**
     * 动态插入用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping("/insertUserInfoCondition")
    public Long insertUserInfoCondition(UserInfo userInfo){

        return userInfoService.insertUserInfoCondition(userInfo);
    }

    /**
     * 插入用户信息，异常回滚测试方法
     * @param userInfo
     * @return
     */
    @RequestMapping("/insertUserInfoExceptionRollBack")
    public Long insertUserInfoExceptionRollBack(UserInfo userInfo){

        return userInfoService.insertUserInfoExceptionRollBack(userInfo);
    }

    /**
     * 插入用户信息，异常不回滚测试方法
     * @param userInfo
     * @return
     */
    @RequestMapping("/insertUserInfoExceptionNoRollBack")
    public Long insertUserInfoExceptionNoRollBack(UserInfo userInfo) {

        return userInfoService.insertUserInfoExceptionNoRollBack(userInfo);
    }

    /**
     * 查询用户 - ReTry测试方法
     * @return
     */
    @RequestMapping("/getHttpReTryTest")
    public UserInfo getHttpReTryTest(Integer num) throws Exception {
        UserInfo userInfo = userInfoService.getHttpReTryTest(num);
        return userInfo;
    }

    /**
     * 插入用户 - ReTry测试方法
     * @return
     */
    @RequestMapping("/insertHttpReTryTest")
    public Long insertHttpReTryTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("insertHttpReTryTest");
        return userInfoService.insertHttpReTryTest(userInfo);
    }
}
