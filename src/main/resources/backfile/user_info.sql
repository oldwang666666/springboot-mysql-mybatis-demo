
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


