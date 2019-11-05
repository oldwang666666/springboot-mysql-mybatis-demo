# springboot-mysql-mybatis-demo
## 项目介绍  
springboot整合mysql + mybatis的demo

## 前言  
如果你还没安装mysql，可以看我之前写的docker部署mysql的文章，安装起来简单快捷。  
文章地址：https://blog.csdn.net/weixin_43841693/article/details/102862938  
  
## demo准备工作  
1、首先我们执行sql脚本，在mysql中创建user_info表，根据自己需要新增修改数据
``` 
-- ----------------------------
-- Table structure for user_info 是否使用utf8mb4自己决定
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别',
  `create_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '小王', 0, '2019-11-05 10:06:36');
INSERT INTO `user_info` VALUES (2, '小明', 0, '2019-11-05 10:06:36');
INSERT INTO `user_info` VALUES (4, '小红', 1, '2019-11-05 10:06:36');
INSERT INTO `user_info` VALUES (8, '小孙', 0, '2019-11-05 10:02:20');
INSERT INTO `user_info` VALUES (9, '三叶', 1, '2019-11-05 10:06:36');
INSERT INTO `user_info` VALUES (10, '梨花', 1, '2019-11-05 10:47:52');
```
2、要注意mysql 5.X版本使用com.mysql.jdbc.Driver，6以后使用com.mysql.cj.jdbc.Driver  
3、执行SpringbootMysqlMybatisDemoApplication，调用demo用例,看是否可以获取数据库值，如下列用例  
``` 
1、执行：http://localhost:8066/user/getUserInfoById?id=2

返回：
{
    "id":2,
    "userName":"小明",
    "sex":0,
    "createDate":"2019-11-05T02:06:36.000+0000",
    "createDateStr":"2019-11-05 10:06:36"
}

2、执行：http://localhost:8066/user/getUserInfoList?userName=%E5%B0%8F&sex=0

返回：
[
    {
        "id":1,
        "userName":"小王",
        "sex":0,
        "createDate":"2019-11-05T02:06:36.000+0000",
        "createDateStr":"2019-11-05 10:06:36"
    },
    {
        "id":2,
        "userName":"小明",
        "sex":0,
        "createDate":"2019-11-05T02:06:36.000+0000",
        "createDateStr":"2019-11-05 10:06:36"
    },
    {
        "id":8,
        "userName":"小孙",
        "sex":0,
        "createDate":"2019-11-05T02:02:20.000+0000",
        "createDateStr":"2019-11-05 10:02:20"
    }
]
``` 
4、以上为springboot整合mysql+mybatis的demo项目，小伙伴们可以根据自己的需要，参考对自己的工程进行整合。  
5、如果需要整合druid，可以参考：https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter  
