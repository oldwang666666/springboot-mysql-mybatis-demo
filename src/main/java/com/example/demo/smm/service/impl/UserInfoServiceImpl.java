package com.example.demo.smm.service.impl;

import com.example.demo.smm.mapper.dao.UserInfoMapper;
import com.example.demo.smm.mapper.entity.UserInfo;
import com.example.demo.smm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 用户信息业务实现类
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoById(Long id) throws Exception {
        UserInfo userInfo = userInfoMapper.getUserInfoById(id);
        if(null == userInfo) {
            throw new Exception("没有查询到数据");
        }
        //此处简单做下转换验证时间格式是否正常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userInfo.setCreateDateStr(sdf.format(userInfo.getCreateDate()));
        return userInfo;
    }

    @Override
    public List<UserInfo> getUserInfoList(UserInfo userInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<UserInfo> list = userInfoMapper.getUserInfoList(userInfo);
        list.forEach(u -> u.setCreateDateStr(sdf.format(u.getCreateDate())));
        return list;
    }
}
