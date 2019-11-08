package com.example.demo.smm.mapper.dao;

import com.example.demo.smm.mapper.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息mapper映射
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
@Repository
public interface UserInfoDao {

    UserInfo getUserInfoById(Long id);

    List<UserInfo> getUserInfoList(UserInfo userInfo);

    int insertUserInfo(UserInfo userInfo);

    int insertUserInfoCondition(UserInfo userInfo);
}
