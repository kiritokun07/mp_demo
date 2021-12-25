/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3307
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/12/2021 08:34:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mp_demo
-- ----------------------------
DROP TABLE IF EXISTS `mp_demo`;
CREATE TABLE `mp_demo`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `age` tinyint(4) UNSIGNED NOT NULL COMMENT '年龄',
  `data_status` tinyint(255) NOT NULL COMMENT '状态 0正常 -1删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'mybatis plus demo 表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
