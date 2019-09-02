/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : business

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 16/08/2019 10:37:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bt_company
-- ----------------------------
DROP TABLE IF EXISTS `bt_company`;
CREATE TABLE `bt_company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '公司助记代码',
  `account_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '财务系统代码',
  `type` int(11) DEFAULT 0 COMMENT '类型-从数据字典录入',
  `credit_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '公司信用代码/个人身份证号码',
  `full_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司全称/个人姓名',
  `short_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '公司简称',
  `parent_id` int(11) DEFAULT 0,
  `self_id` int(11) DEFAULT 0,
  `status` int(11) DEFAULT NULL COMMENT '启用',
  `used` int(11) DEFAULT 0 COMMENT '已被使用(0：否，1：是)',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_full_name`(`full_name`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_company_code`(`company_code`) USING BTREE,
  INDEX `idx_credit_code`(`credit_code`) USING BTREE,
  INDEX `idx_self_id`(`self_id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_company
-- ----------------------------
INSERT INTO `bt_company` VALUES (1, 'P_001', '', 12, '370222122102141231', '张三', '小三', 0, 4, 3, 0, '员工小三', 0, '2019-08-08 08:41:47', '2019-08-14 18:11:14');
INSERT INTO `bt_company` VALUES (6, 'C_001', '', 6, '123456789', '汇盈金服', '汇盈', 0, 1001, 3, 0, '', 0, '2019-08-15 06:14:38', '2019-08-15 06:14:38');
INSERT INTO `bt_company` VALUES (7, 'C_00101', '', 6, '123456789', '汇盈金服-本部', '本部', 1001, 100102, 3, 0, '', 0, '2019-08-15 14:15:27', '2019-08-15 14:15:59');
INSERT INTO `bt_company` VALUES (8, 'C_00101', '', 6, '123456789', '汇盈客服部门', '客服', 1001, 100101, 3, 0, '', 0, '2019-08-15 06:15:28', '2019-08-15 06:15:28');
INSERT INTO `bt_company` VALUES (9, 'C_100103', '', 6, '123456789', '汇盈金服-风控部', '风控', 1001, 100103, 3, 0, '', 0, '2019-08-15 06:18:02', '2019-08-15 06:18:02');
INSERT INTO `bt_company` VALUES (26, '', '02040', 11, '12', '史存勇', '史存勇', 0, 26, 3, 0, 'null', 0, '2019-08-15 09:27:45', '2019-08-16 01:00:58');
INSERT INTO `bt_company` VALUES (28, '', '02082', 11, '14', '赵合丽', '赵合丽', 0, 28, 3, 0, 'null', 0, '2019-08-15 09:27:45', '2019-08-16 01:01:05');
INSERT INTO `bt_company` VALUES (29, '', '022-0009', 11, '15', '吕庆东', '吕庆东', 0, 29, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:11');
INSERT INTO `bt_company` VALUES (30, '', '022-0034', 11, '16', '李明', '李明', 0, 30, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:15');
INSERT INTO `bt_company` VALUES (31, '', '02211', 11, '17', '贾明水', '贾明水', 0, 31, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:17');
INSERT INTO `bt_company` VALUES (32, '', '02227', 11, '18', '丁洪洁', '丁洪洁', 0, 32, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:20');
INSERT INTO `bt_company` VALUES (33, '', '02251', 11, '19', '冯万良', '冯万良', 0, 33, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:23');
INSERT INTO `bt_company` VALUES (35, '', '02282', 11, '21', '顾业青', '顾业青', 0, 35, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:26');

SET FOREIGN_KEY_CHECKS = 1;
