package com.example.demo.smm.service;

import com.example.demo.smm.mapper.entity.UserInfo;

import java.util.List;

/**
 * 用户信息接口
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
public interface UserInfoService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    UserInfo getUserInfoById(Long id) throws Exception;

    /**
     * 查询用户列表
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserInfoList(UserInfo userInfo);

    /**
     * 插入用户信息
     * @param userInfo
     * @return
     */
    Long insertUserInfo(UserInfo userInfo);

    /**
     * 动态插入用户信息
     * @param userInfo
     * @return
     */
    Long insertUserInfoCondition(UserInfo userInfo);

    /**
     * 插入用户信息，异常回滚测试方法
     * @param userInfo
     * @return
     */
    Long insertUserInfoExceptionRollBack(UserInfo userInfo);

    /**
     * 插入用户信息，异常不回滚测试方法
     * @param userInfo
     * @return
     */
    Long insertUserInfoExceptionNoRollBack(UserInfo userInfo);

    /**
     * 查询用户 - ReTry测试方法
     * @param num
     * @return
     * @throws Exception
     */
    UserInfo getHttpReTryTest(Integer num) throws Exception;

    /**
     * 插入用户 - ReTry测试方法
     * @param userInfo
     * @return
     */
    Long insertHttpReTryTest(UserInfo userInfo);
}
