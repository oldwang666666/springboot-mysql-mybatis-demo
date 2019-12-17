package com.example.demo.smm.mapper.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表entity
 *
 * @author longzhang.wang
 * @Date 2019年11月5日
 */
public class UserInfo implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer sex;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建时间字符串，用来做简单的时间转换测试，demo暂不新建其他vo
     */
    private String createDateStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", createDate=" + createDate +
                ", createDateStr='" + createDateStr + '\'' +
                '}';
    }
}
