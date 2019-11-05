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
}
