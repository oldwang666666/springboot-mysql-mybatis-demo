package com.example.demo.smm.service.impl;

import com.example.demo.smm.mapper.dao.UserInfoDao;
import com.example.demo.smm.mapper.entity.UserInfo;
import com.example.demo.smm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户信息业务实现类
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfoById(Long id) throws Exception {
        UserInfo userInfo = userInfoDao.getUserInfoById(id);
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
        List<UserInfo> list = userInfoDao.getUserInfoList(userInfo);
        list.forEach(u -> u.setCreateDateStr(sdf.format(u.getCreateDate())));
        return list;
    }

    @Transactional
    @Override
    public Long insertUserInfo(UserInfo userInfo){
        int result = userInfoDao.insertUserInfo(userInfo);
        if(result < 1) {
            throw new RuntimeException("插入失败");
        }
        return userInfo.getId();
    }

    @Transactional
    @Override
    public Long insertUserInfoCondition(UserInfo userInfo){
        int result = userInfoDao.insertUserInfoCondition(userInfo);
        if(result < 1) {
            throw new RuntimeException("插入失败");
        }
        return userInfo.getId();
    }

    @Transactional
    @Override
    public Long insertUserInfoExceptionRollBack(UserInfo userInfo){
        int result = userInfoDao.insertUserInfo(userInfo);
        throw new RuntimeException("强制抛出异常，insertUserInfoExceptionRollBack回滚");
    }

    @Override
    public Long insertUserInfoExceptionNoRollBack(UserInfo userInfo){
        int result = userInfoDao.insertUserInfo(userInfo);
        throw new RuntimeException("强制抛出异常，insertUserInfoExceptionNoRollBack不回滚");
    }

    //最大重试3次，每次重试延迟2s->3s->4.5s
    @Retryable(include = RuntimeException.class, maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    @Override
    public UserInfo getHttpReTryTest(Integer num) throws Exception {
        num ++;
        if(num > 1) {
            System.out.println("运行getHttpReTryTest方法--------------------");
            throw new RuntimeException("强制抛出异常，getUserInfoByIdReTryTest  num:" + num);
        } else {
            System.out.println("运行getHttpReTryTest方法********************");
            throw new IOException("强制抛出异常，getUserInfoByIdReTryTest  num:" + num);
        }

    }

    //最大重试3次，每次重试延迟2s->3s->4.5s
    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 20000,maxDelay = 80000, multiplier = 2))
    @Override
    public Long insertHttpReTryTest(UserInfo userInfo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
        System.out.println("调用http方法：" + simpleDateFormat.format(new Date()));
        throw new RuntimeException("强制抛出异常，insertHttpReTryTest  result:" + userInfo.toString());
    }

    @Recover
    public UserInfo getHttpReTryTestRuntimeException(RuntimeException e) {
        System.out.println("调用getHttpReTryTestRuntimeException方法  e:" + e.getMessage());
        return new UserInfo();
    }

    @Recover
    public UserInfo getHttpReTryTestIOException(IOException e) {
        System.out.println("getHttpReTryTestIOException  e:" + e.getMessage());
        return new UserInfo();
    }

    @Recover
    public Long insertHttpReTryTestException(RuntimeException e) {
        System.out.println("调用insertHttpReTryTestException方法 e:" + e.getMessage());
        return 0L;
    }

}
