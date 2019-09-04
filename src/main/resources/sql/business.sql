/*
 Navicat Premium Data Transfer

 Source Server         : root-local
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : business

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 04/09/2019 10:30:24
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
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_company
-- ----------------------------
INSERT INTO `bt_company` VALUES (1, 'P_001', '', 12, '370222122102141231', '张三', '小三', 0, 4, 3, 0, '员工小三', 0, '2019-08-08 08:41:47', '2019-08-14 18:11:14');
INSERT INTO `bt_company` VALUES (6, 'C_001', '', 6, '123456789', '汇盈金服', '汇盈', 0, 1001, 3, 0, '', 0, '2019-08-15 06:14:38', '2019-08-15 06:14:38');
INSERT INTO `bt_company` VALUES (7, 'C_00101', '', 6, '123456789', '汇盈金服-本部', '本部', 1001, 100102, 3, 0, '', 0, '2019-08-15 14:15:27', '2019-08-15 14:15:59');
INSERT INTO `bt_company` VALUES (8, 'C_00101', '', 6, '123456789', '汇盈客服部门', '客服', 1001, 100101, 3, 0, '', 0, '2019-08-15 06:15:28', '2019-08-15 06:15:28');
INSERT INTO `bt_company` VALUES (9, 'C_100103', '', 6, '123456789', '汇盈金服-风控部', '风控', 1001, 100103, 3, 0, '', 0, '2019-08-15 06:18:02', '2019-08-15 06:18:02');
INSERT INTO `bt_company` VALUES (10, 'C_1002', '', 8, '1234567890', '青岛理工大学', '理工大学', 0, 1002, 3, 0, '', 0, '2019-08-15 06:18:36', '2019-08-15 06:18:36');
INSERT INTO `bt_company` VALUES (11, 'C_100202', '', 8, '1234567890', '青岛理工大学-本部', '本部', 1002, 11, 3, 0, '', 0, '2019-08-15 14:19:26', '2019-08-15 14:19:26');
INSERT INTO `bt_company` VALUES (12, 'C_100202', '', 8, '1234567890', '青岛理工大学-学生处', '学生处', 1002, 100202, 3, 0, '', 0, '2019-08-15 06:19:27', '2019-08-15 06:19:27');
INSERT INTO `bt_company` VALUES (13, 'P_1002', '', 12, '321123321456', '李四', '小四', 0, 13, 3, 0, '', 0, '2019-08-15 06:20:58', '2019-08-15 06:20:58');
INSERT INTO `bt_company` VALUES (26, '', '02040', 11, '12', '史存勇', '史存勇', 0, 26, 3, 0, 'null', 0, '2019-08-15 09:27:45', '2019-08-16 01:00:58');
INSERT INTO `bt_company` VALUES (28, '', '02082', 11, '14', '赵合丽', '赵合丽', 0, 28, 3, 0, 'null', 0, '2019-08-15 09:27:45', '2019-08-16 01:01:05');
INSERT INTO `bt_company` VALUES (29, '', '022-0009', 11, '15', '吕庆东', '吕庆东', 0, 29, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:11');
INSERT INTO `bt_company` VALUES (30, '', '022-0034', 11, '16', '李明', '李明', 0, 30, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:15');
INSERT INTO `bt_company` VALUES (31, '', '02211', 11, '17', '贾明水', '贾明水', 0, 31, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:17');
INSERT INTO `bt_company` VALUES (32, '', '02227', 11, '18', '丁洪洁', '丁洪洁', 0, 32, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:20');
INSERT INTO `bt_company` VALUES (33, '', '02251', 11, '19', '冯万良', '冯万良', 0, 33, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:23');
INSERT INTO `bt_company` VALUES (35, '', '02282', 11, '21', '顾业青', '顾业青', 0, 35, NULL, 0, NULL, 0, '2019-08-15 09:27:45', '2019-08-16 09:00:26');

-- ----------------------------
-- Table structure for bt_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `bt_dictionary`;
CREATE TABLE `bt_dictionary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '#' COMMENT '字典区分,用来区分某一类字典',
  `value` int(11) DEFAULT 1 COMMENT '字典值',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序字段',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点id',
  `self_id` int(11) DEFAULT NULL COMMENT '自身id',
  `freeze` int(11) NOT NULL DEFAULT 0 COMMENT '冻结（0：未冻结，1：冻结）',
  `used` int(11) NOT NULL DEFAULT 0 COMMENT '是否已用（0：未用，1：已用）',
  `built_in` int(11) NOT NULL DEFAULT 0 COMMENT '是否内置（0：否，1：是）',
  `node_type_id` int(11) DEFAULT NULL COMMENT '暂时保留吧',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_type`(`type`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE,
  INDEX `idx_self_id`(`self_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 146 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_dictionary
-- ----------------------------
INSERT INTO `bt_dictionary` VALUES (1, 'base', 1, '基础设置', 1, 0, 1, 0, 1, 1, NULL, '', 0, '2019-08-02 05:52:26', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES (2, '#', 0, '启用状态', 1, 1, 101, 0, 1, 0, NULL, '启用类型', 0, '2019-08-02 05:54:36', '2019-08-11 11:28:16');
INSERT INTO `bt_dictionary` VALUES (3, 'status', 1, '启用', 1, 101, 10101, 0, 1, 0, NULL, '', 0, '2019-08-01 21:55:21', '2019-08-10 21:52:40');
INSERT INTO `bt_dictionary` VALUES (4, 'status', 2, '停用', 2, 101, 10102, 0, 1, 0, NULL, '', 0, '2019-08-01 21:55:35', '2019-08-10 21:52:38');
INSERT INTO `bt_dictionary` VALUES (5, '#', 0, '往来单位及个人关系类型', 2, 4, 102, 0, 1, 0, NULL, '', 0, '2019-08-02 05:57:53', '2019-08-10 22:07:57');
INSERT INTO `bt_dictionary` VALUES (6, 'relationship', 1, '本公司', 1, 102, 10201, 0, 0, 0, NULL, '', 0, '2019-08-02 05:58:18', '2019-08-10 21:05:15');
INSERT INTO `bt_dictionary` VALUES (7, 'relationship', 2, '东风公司', 2, 102, 10202, 0, 0, 0, NULL, '', 0, '2019-08-02 05:58:37', '2019-08-10 21:05:58');
INSERT INTO `bt_dictionary` VALUES (8, 'relationship', 3, '业务公司', 3, 102, 10203, 0, 0, 0, NULL, '', 0, '2019-08-02 05:58:51', '2019-08-10 21:05:54');
INSERT INTO `bt_dictionary` VALUES (9, 'relationship', 4, '代理商', 4, 102, 10204, 0, 1, 0, NULL, '', 0, '2019-08-02 05:59:08', '2019-08-10 21:06:02');
INSERT INTO `bt_dictionary` VALUES (10, 'relationship', 5, '关联公司', 5, 102, 10205, 0, 1, 0, NULL, '', 0, '2019-08-02 05:59:48', '2019-08-10 21:06:04');
INSERT INTO `bt_dictionary` VALUES (11, 'relationship', 6, '外部个人', 6, 102, 10206, 0, 0, 0, NULL, '', 0, '2019-08-02 06:00:05', '2019-08-10 21:06:07');
INSERT INTO `bt_dictionary` VALUES (12, 'relationship', 7, '员工', 7, 102, 10207, 0, 1, 0, NULL, '', 0, '2019-08-02 06:00:32', '2019-08-10 21:06:09');
INSERT INTO `bt_dictionary` VALUES (13, '#', 0, '职位类型', 3, 1, 103, 0, 1, 0, NULL, '', 0, '2019-08-08 02:42:22', '2019-08-10 21:52:44');
INSERT INTO `bt_dictionary` VALUES (14, 'position', 1, '部门', 1, 103, 10301, 0, 1, 0, NULL, '', 0, '2019-08-08 02:43:36', '2019-08-10 21:52:46');
INSERT INTO `bt_dictionary` VALUES (15, 'position', 2, '岗位', 2, 103, 10302, 0, 1, 0, NULL, '', 0, '2019-08-08 02:44:33', '2019-08-10 21:52:47');
INSERT INTO `bt_dictionary` VALUES (17, '#', 1, '商品核算', 0, 0, 2, 0, 0, 0, NULL, '', 0, '2019-08-10 12:48:51', '2019-08-10 22:29:37');
INSERT INTO `bt_dictionary` VALUES (18, '', 1, '使用状态', 0, 1, 121, 0, 0, 0, NULL, '', 0, '2019-08-10 13:07:51', '2019-08-10 21:14:04');
INSERT INTO `bt_dictionary` VALUES (19, '', 1, '已用', 0, 121, 12101, 0, 0, 0, NULL, '', 0, '2019-08-09 21:08:44', '2019-08-10 23:51:57');
INSERT INTO `bt_dictionary` VALUES (20, '', 1, '未用', 0, 121, 12202, 0, 0, 0, NULL, '', 0, '2019-08-09 21:08:57', '2019-08-10 23:52:07');
INSERT INTO `bt_dictionary` VALUES (21, '', 1, '数据输入方式', 0, 1, 115, 0, 0, 0, NULL, '', 0, '2019-08-10 13:10:02', '2019-08-10 22:00:25');
INSERT INTO `bt_dictionary` VALUES (22, '', 1, '用户手工输入', 0, 115, 11501, 0, 0, 0, NULL, '', 0, '2019-08-10 13:10:26', '2019-08-10 21:11:02');
INSERT INTO `bt_dictionary` VALUES (23, '', 1, '数据字典选择输入', 0, 115, 11502, 0, 0, 0, NULL, '', 0, '2019-08-10 13:11:20', '2019-08-10 21:11:35');
INSERT INTO `bt_dictionary` VALUES (24, '', 1, '商品颜色', 0, 2, 202, 0, 0, 0, NULL, '', 0, '2019-08-10 13:12:26', '2019-08-10 22:32:05');
INSERT INTO `bt_dictionary` VALUES (25, '', 1, '计量单位', 0, 2, 204, 0, 0, 0, NULL, '', 0, '2019-08-10 13:13:00', '2019-08-10 22:05:43');
INSERT INTO `bt_dictionary` VALUES (26, '', 1, '资金用途', 0, 3, 301, 0, 0, 0, NULL, '', 0, '2019-08-10 13:14:33', '2019-08-10 23:24:43');
INSERT INTO `bt_dictionary` VALUES (27, '', 1, '财务科目', 0, 0, 25, 0, 0, 0, NULL, '', 0, '2019-08-10 13:14:54', '2019-08-10 21:56:02');
INSERT INTO `bt_dictionary` VALUES (28, '', 1, '联系方式类型', 0, 4, 130, 0, 0, 0, NULL, '', 0, '2019-08-10 13:15:21', '2019-08-10 21:53:17');
INSERT INTO `bt_dictionary` VALUES (29, '', 1, '资金账户类型', 0, 3, 305, 0, 0, 0, NULL, '', 0, '2019-08-10 13:16:05', '2019-08-10 23:25:15');
INSERT INTO `bt_dictionary` VALUES (30, '', 1, '主营业务相关设置', 0, 0, 5, 0, 0, 0, NULL, '', 0, '2019-08-10 13:17:21', '2019-08-10 23:03:43');
INSERT INTO `bt_dictionary` VALUES (31, '', 1, '采购业务相关设置', 0, 0, 6, 0, 0, 0, NULL, '', 0, '2019-08-10 13:18:26', '2019-08-10 22:06:45');
INSERT INTO `bt_dictionary` VALUES (32, '', 1, '营业款', 0, 301, 30101, 0, 0, 0, NULL, '', 0, '2019-08-10 05:19:15', '2019-08-10 23:25:24');
INSERT INTO `bt_dictionary` VALUES (33, '', 1, '采购款', 0, 301, 30101, 0, 0, 0, NULL, '', 0, '2019-08-10 05:20:00', '2019-08-10 23:25:01');
INSERT INTO `bt_dictionary` VALUES (34, '', 1, '借款及备用金', 0, 301, 30125, 0, 0, 0, NULL, '', 0, '2019-08-10 05:20:21', '2019-08-10 23:26:29');
INSERT INTO `bt_dictionary` VALUES (35, '', 1, '代收代付', 0, 301, 30110, 0, 0, 0, NULL, '', 0, '2019-08-10 05:20:41', '2019-08-10 23:25:58');
INSERT INTO `bt_dictionary` VALUES (36, '', 1, '税款', 0, 301, 30128, 0, 0, 0, NULL, '', 0, '2019-08-10 05:21:04', '2019-08-10 23:26:42');
INSERT INTO `bt_dictionary` VALUES (37, '', 1, '工资及社保', 0, 301, 30111, 0, 0, 0, NULL, '', 0, '2019-08-10 05:21:26', '2019-08-10 23:26:05');
INSERT INTO `bt_dictionary` VALUES (38, '', 1, '襄阳志达往来款', 0, 301, 30113, 0, 0, 0, NULL, '', 0, '2019-08-10 05:22:12', '2019-08-10 23:26:12');
INSERT INTO `bt_dictionary` VALUES (39, '', 1, '代垫款', 0, 301, 30118, 0, 0, 0, NULL, '', 0, '2019-08-10 05:22:42', '2019-08-10 23:26:24');
INSERT INTO `bt_dictionary` VALUES (40, '', 1, '手续费', 0, 301, 30126, 0, 0, 0, NULL, '', 0, '2019-08-10 05:23:07', '2019-08-10 23:26:35');
INSERT INTO `bt_dictionary` VALUES (41, '', 1, '业务部日常费用', 0, 301, 30103, 0, 0, 0, NULL, '', 0, '2019-08-10 05:24:47', '2019-08-10 23:25:38');
INSERT INTO `bt_dictionary` VALUES (42, '', 1, '待分类', 0, 301, 30199, 0, 0, 0, NULL, '', 0, '2019-08-10 05:25:46', '2019-08-10 23:26:48');
INSERT INTO `bt_dictionary` VALUES (43, '', 1, '押金及保证金', 0, 301, 30117, 0, 0, 0, NULL, '', 0, '2019-08-10 05:27:11', '2019-08-10 23:26:18');
INSERT INTO `bt_dictionary` VALUES (46, '', 1, '营销专项费用', 0, 301, 30106, 0, 0, 0, NULL, '', 0, '2019-08-10 05:38:47', '2019-08-10 23:25:51');
INSERT INTO `bt_dictionary` VALUES (47, '', 1, '维修站日常费用', 0, 301, 30104, 0, 0, 0, NULL, '', 0, '2019-08-10 05:39:44', '2019-08-10 23:25:45');
INSERT INTO `bt_dictionary` VALUES (48, '', 1, '银行账户', 0, 305, 30501, 0, 0, 0, NULL, '', 0, '2019-08-10 05:41:07', '2019-08-10 23:27:04');
INSERT INTO `bt_dictionary` VALUES (49, '', 1, '微信账户', 0, 305, 30502, 0, 0, 0, NULL, '', 0, '2019-08-10 05:41:37', '2019-08-10 23:27:11');
INSERT INTO `bt_dictionary` VALUES (50, '', 1, '支付宝账户', 0, 305, 30503, 0, 0, 0, NULL, '', 0, '2019-08-10 05:41:54', '2019-08-10 23:27:19');
INSERT INTO `bt_dictionary` VALUES (51, '', 1, '现金账户', 0, 305, 30504, 0, 0, 0, NULL, '', 0, '2019-08-10 05:42:18', '2019-08-10 23:27:27');
INSERT INTO `bt_dictionary` VALUES (52, '', 1, '手机', 0, 130, 13001, 0, 0, 0, NULL, '', 0, '2019-08-10 13:44:00', '2019-08-10 13:44:00');
INSERT INTO `bt_dictionary` VALUES (53, '', 1, '固定电话', 0, 130, 13002, 0, 0, 0, NULL, '', 0, '2019-08-10 13:44:28', '2019-08-10 13:44:28');
INSERT INTO `bt_dictionary` VALUES (54, '', 1, 'QQ', 0, 130, 13003, 0, 0, 0, NULL, '', 0, '2019-08-10 13:44:54', '2019-08-10 13:44:54');
INSERT INTO `bt_dictionary` VALUES (56, '', 1, 'qq群', 0, 130, 13009, 0, 0, 0, NULL, '', 0, '2019-08-10 13:45:39', '2019-08-10 13:45:39');
INSERT INTO `bt_dictionary` VALUES (57, '', 1, '微信群', 0, 130, 13008, 0, 0, 0, NULL, '', 0, '2019-08-10 13:46:00', '2019-08-10 13:46:00');
INSERT INTO `bt_dictionary` VALUES (58, '', 1, '电子邮箱', 0, 130, 13005, 0, 0, 0, NULL, '', 0, '2019-08-10 13:46:24', '2019-08-10 13:46:24');
INSERT INTO `bt_dictionary` VALUES (59, '#', 1, '资金收支相关设置', 0, 0, 3, 0, 0, 0, NULL, '', 0, '2019-08-10 13:48:05', '2019-08-10 23:33:12');
INSERT INTO `bt_dictionary` VALUES (60, '#', 1, '往来相关设置', 0, 0, 4, 0, 0, 0, NULL, '', 0, '2019-08-10 13:49:59', '2019-08-10 22:07:38');
INSERT INTO `bt_dictionary` VALUES (61, '', 1, '商品分类', 0, 2, 201, 0, 0, 0, NULL, '', 0, '2019-08-10 14:06:09', '2019-08-10 22:29:48');
INSERT INTO `bt_dictionary` VALUES (62, '#', 1, '出入库相关设置', 0, 0, 7, 0, 0, 0, NULL, '', 0, '2019-08-10 14:08:34', '2019-08-10 22:09:13');
INSERT INTO `bt_dictionary` VALUES (63, '', 1, '入库类型', 0, 7, 701, 0, 0, 0, NULL, '', 0, '2019-08-10 14:09:41', '2019-08-10 22:09:54');
INSERT INTO `bt_dictionary` VALUES (64, '', 1, '出库类型', 0, 7, 702, 0, 0, 0, NULL, '', 0, '2019-08-10 14:10:08', '2019-08-10 14:10:08');
INSERT INTO `bt_dictionary` VALUES (65, '', 1, '商品入库', 0, 701, 70101, 0, 0, 0, NULL, '', 0, '2019-08-10 14:10:40', '2019-08-10 14:10:40');
INSERT INTO `bt_dictionary` VALUES (66, '', 1, '商品退回', 0, 701, 70103, 0, 0, 0, NULL, '', 0, '2019-08-10 14:10:54', '2019-08-10 22:12:18');
INSERT INTO `bt_dictionary` VALUES (68, '', 1, '销售出库', 0, 702, 70201, 0, 0, 0, NULL, '', 0, '2019-08-10 14:12:45', '2019-08-10 14:12:45');
INSERT INTO `bt_dictionary` VALUES (69, '', 1, '退回供货商', 0, 702, 70203, 0, 0, 0, NULL, '', 0, '2019-08-10 14:13:02', '2019-08-10 22:13:11');
INSERT INTO `bt_dictionary` VALUES (71, '', 1, '仓库地点', 0, 7, 705, 0, 0, 0, NULL, '', 0, '2019-08-10 14:13:53', '2019-08-10 23:18:35');
INSERT INTO `bt_dictionary` VALUES (72, '', 1, '东风库', 0, 705, 70501, 0, 0, 0, NULL, '', 0, '2019-08-10 14:14:14', '2019-08-10 14:14:14');
INSERT INTO `bt_dictionary` VALUES (73, '', 1, '吴家堡', 0, 705, 70503, 0, 0, 0, NULL, '', 0, '2019-08-10 14:14:41', '2019-08-10 22:14:50');
INSERT INTO `bt_dictionary` VALUES (74, '', 1, '钢材市场', 0, 705, 70505, 0, 0, 0, NULL, '', 0, '2019-08-10 14:15:40', '2019-08-11 10:17:39');
INSERT INTO `bt_dictionary` VALUES (75, '', 1, '济宁暂存库', 0, 705, 70506, 0, 0, 0, NULL, '', 0, '2019-08-10 14:16:29', '2019-08-10 22:17:26');
INSERT INTO `bt_dictionary` VALUES (76, '', 1, '直发客户库', 0, 705, 70509, 0, 0, 0, NULL, '', 0, '2019-08-10 14:17:17', '2019-08-10 22:18:09');
INSERT INTO `bt_dictionary` VALUES (77, '', 1, '预留核算维度1', 0, 2, 208, 0, 0, 0, NULL, '', 0, '2019-08-10 14:19:59', '2019-08-10 22:29:05');
INSERT INTO `bt_dictionary` VALUES (78, '', 1, '商品规格型号', 0, 2, 203, 0, 0, 0, NULL, '', 0, '2019-08-10 14:30:08', '2019-08-10 22:30:44');
INSERT INTO `bt_dictionary` VALUES (79, '', 1, '预留核算维度2', 0, 2, 209, 0, 0, 0, NULL, '', 0, '2019-08-10 14:31:41', '2019-08-10 14:31:41');
INSERT INTO `bt_dictionary` VALUES (80, '', 1, '温莎白', 0, 202, 20202, 0, 0, 0, NULL, '', 0, '2019-08-10 14:33:04', '2019-08-10 22:34:00');
INSERT INTO `bt_dictionary` VALUES (81, '', 1, '羊脂白', 0, 202, 20201, 0, 0, 0, NULL, '', 0, '2019-08-10 14:33:18', '2019-08-10 22:54:14');
INSERT INTO `bt_dictionary` VALUES (82, '', 1, '脂玉白', 0, 202, 20204, 0, 0, 0, NULL, '', 0, '2019-08-10 14:33:38', '2019-08-10 14:33:38');
INSERT INTO `bt_dictionary` VALUES (83, '', 1, '悦动红', 0, 202, 20206, 0, 0, 0, NULL, '', 0, '2019-08-10 14:34:25', '2019-08-10 14:34:25');
INSERT INTO `bt_dictionary` VALUES (84, '', 1, '工程黄', 0, 202, 20207, 0, 0, 0, NULL, '', 0, '2019-08-10 14:34:43', '2019-08-10 14:34:43');
INSERT INTO `bt_dictionary` VALUES (85, '', 1, '青闪银', 0, 202, 20208, 0, 0, 0, NULL, '', 0, '2019-08-10 14:35:01', '2019-08-10 14:35:01');
INSERT INTO `bt_dictionary` VALUES (86, '', 1, '炫目蓝', 0, 202, 20209, 0, 0, 0, NULL, '', 0, '2019-08-10 14:35:16', '2019-08-10 22:35:33');
INSERT INTO `bt_dictionary` VALUES (87, '', 1, '台', 0, 204, 20401, 0, 0, 0, NULL, '', 0, '2019-08-10 14:36:03', '2019-08-10 14:36:03');
INSERT INTO `bt_dictionary` VALUES (88, '', 1, '个', 0, 204, 20402, 0, 0, 0, NULL, '', 0, '2019-08-10 14:36:22', '2019-08-10 14:36:22');
INSERT INTO `bt_dictionary` VALUES (89, '', 1, '次', 0, 204, 20403, 0, 0, 0, NULL, '', 0, '2019-08-10 14:36:48', '2019-08-10 14:36:48');
INSERT INTO `bt_dictionary` VALUES (90, '', 1, '套', 0, 204, 20404, 0, 0, 0, NULL, '', 0, '2019-08-10 14:37:06', '2019-08-10 14:37:06');
INSERT INTO `bt_dictionary` VALUES (91, '', 1, '整车', 0, 201, 20101, 0, 0, 0, NULL, '', 0, '2019-08-10 14:37:35', '2019-08-10 14:37:35');
INSERT INTO `bt_dictionary` VALUES (92, '', 1, '车辆加、改装件', 0, 201, 20103, 0, 0, 0, NULL, '', 0, '2019-08-10 14:37:48', '2019-08-10 22:38:46');
INSERT INTO `bt_dictionary` VALUES (93, '', 1, '冷藏空调', 0, 20103, 2010303, 0, 0, 0, NULL, '', 0, '2019-08-10 06:39:43', '2019-08-10 22:58:17');
INSERT INTO `bt_dictionary` VALUES (94, '', 1, '厢体', 0, 20103, 2010302, 0, 0, 0, NULL, '', 0, '2019-08-10 06:40:11', '2019-08-10 22:57:57');
INSERT INTO `bt_dictionary` VALUES (95, '', 1, '底盘', 0, 20101, 2010101, 0, 0, 0, NULL, '', 0, '2019-08-10 06:51:28', '2019-08-10 22:59:05');
INSERT INTO `bt_dictionary` VALUES (99, '', 1, '导流罩', 0, 20103, 2010301, 0, 0, 0, NULL, '', 0, '2019-08-10 14:59:59', '2019-08-10 14:59:59');
INSERT INTO `bt_dictionary` VALUES (100, '', 1, '平板', 0, 20101, 2010102, 0, 0, 0, NULL, '', 0, '2019-08-10 15:00:31', '2019-08-10 15:00:31');
INSERT INTO `bt_dictionary` VALUES (101, '', 1, '高栏', 0, 20101, 2010103, 0, 0, 0, NULL, '', 0, '2019-08-10 15:00:49', '2019-08-10 15:00:49');
INSERT INTO `bt_dictionary` VALUES (102, '', 1, '高栏', 0, 20101, 2010104, 0, 0, 0, NULL, '', 0, '2019-08-10 15:01:14', '2019-08-10 15:01:14');
INSERT INTO `bt_dictionary` VALUES (103, '', 1, '主营业务类型', 0, 5, 501, 0, 0, 0, NULL, '', 0, '2019-08-10 15:04:13', '2019-08-10 15:04:13');
INSERT INTO `bt_dictionary` VALUES (104, '', 1, '维修', 0, 501, 50102, 0, 0, 0, NULL, '', 0, '2019-08-10 15:04:29', '2019-08-10 23:11:17');
INSERT INTO `bt_dictionary` VALUES (105, '', 1, '销售', 0, 501, 50101, 0, 0, 0, NULL, '', 0, '2019-08-10 15:05:43', '2019-08-10 23:11:33');
INSERT INTO `bt_dictionary` VALUES (106, '', 1, '服务', 0, 501, 50103, 0, 0, 0, NULL, '', 0, '2019-08-10 15:05:58', '2019-08-10 23:11:48');
INSERT INTO `bt_dictionary` VALUES (107, '', 1, '代办保险', 0, 50103, 5010101, 0, 0, 0, NULL, '', 0, '2019-08-10 07:08:14', '2019-08-10 23:12:09');
INSERT INTO `bt_dictionary` VALUES (108, '', 1, '代办贷款', 0, 50103, 5010302, 0, 0, 0, NULL, '', 0, '2019-08-10 07:08:45', '2019-08-10 07:08:45');
INSERT INTO `bt_dictionary` VALUES (109, '', 1, '代办挂牌', 0, 50103, 5010303, 0, 0, 0, NULL, '', 0, '2019-08-10 07:09:23', '2019-08-10 07:09:23');
INSERT INTO `bt_dictionary` VALUES (110, '', 1, '代办其他业务', 0, 50103, 5010310, 0, 0, 0, NULL, '', 0, '2019-08-10 07:09:59', '2019-08-10 23:12:28');
INSERT INTO `bt_dictionary` VALUES (111, '', 1, '资金收支方向', 0, 3, 306, 0, 0, 0, NULL, '', 0, '2019-08-10 15:23:30', '2019-08-12 23:24:02');
INSERT INTO `bt_dictionary` VALUES (112, '', 1, '收入', 0, 306, 30601, 0, 0, 0, NULL, '', 0, '2019-08-10 15:23:47', '2019-08-10 23:28:19');
INSERT INTO `bt_dictionary` VALUES (113, '', 1, '支出', 0, 306, 30602, 0, 0, 0, NULL, '', 0, '2019-08-10 15:28:55', '2019-08-10 15:28:55');
INSERT INTO `bt_dictionary` VALUES (114, '', 1, '计价方式', 0, 2, 205, 0, 0, 0, NULL, '', 0, '2019-08-11 01:35:33', '2019-08-11 09:48:22');
INSERT INTO `bt_dictionary` VALUES (115, '', 1, '计价', 0, 205, 20501, 0, 0, 0, NULL, '', 0, '2019-08-10 09:36:53', '2019-08-11 09:48:34');
INSERT INTO `bt_dictionary` VALUES (116, '', 1, '赠品', 0, 205, 20503, 0, 0, 0, NULL, '', 0, '2019-08-10 09:37:15', '2019-08-11 09:48:46');
INSERT INTO `bt_dictionary` VALUES (117, '', 1, '免费', 0, 205, 20502, 0, 0, 0, NULL, '', 0, '2019-08-10 09:37:35', '2019-08-11 09:49:01');
INSERT INTO `bt_dictionary` VALUES (121, '', 1, '订单类型', 0, 1, 123, 0, 0, 0, NULL, '', 0, '2019-08-11 03:06:51', '2019-08-11 16:28:07');
INSERT INTO `bt_dictionary` VALUES (122, '', 1, '采购订单', 0, 123, 12301, 0, 0, 0, NULL, '', 0, '2019-08-11 03:07:08', '2019-08-11 03:07:08');
INSERT INTO `bt_dictionary` VALUES (123, '', 1, '销售订单', 0, 123, 12302, 0, 0, 0, NULL, '', 0, '2019-08-11 03:07:22', '2019-08-11 03:07:22');
INSERT INTO `bt_dictionary` VALUES (124, '', 1, '委托代销订单', 0, 123, 12305, 0, 0, 0, NULL, '', 0, '2019-08-11 03:25:40', '2019-08-11 11:26:43');
INSERT INTO `bt_dictionary` VALUES (125, '', 1, '受托代销订单', 0, 123, 12306, 0, 0, 0, NULL, '', 0, '2019-08-11 03:26:01', '2019-08-11 11:26:54');
INSERT INTO `bt_dictionary` VALUES (126, '', 1, '订单状态', 0, 1, 124, 0, 0, 0, NULL, '', 0, '2019-08-11 08:10:10', '2019-08-11 16:28:14');
INSERT INTO `bt_dictionary` VALUES (127, '', 1, '执行中', 0, 124, 12402, 0, 0, 0, NULL, '', 0, '2019-08-11 08:11:38', '2019-08-12 23:18:37');
INSERT INTO `bt_dictionary` VALUES (128, '', 1, '作废', 0, 124, 12409, 0, 0, 0, NULL, '', 0, '2019-08-11 08:12:07', '2019-08-12 23:20:30');
INSERT INTO `bt_dictionary` VALUES (129, '', 1, '完结', 0, 124, 12407, 0, 0, 0, NULL, '', 0, '2019-08-11 08:13:25', '2019-08-12 23:20:43');
INSERT INTO `bt_dictionary` VALUES (130, '', 1, '其他订单', 0, 123, 12320, 0, 0, 0, NULL, '', 0, '2019-08-11 08:20:48', '2019-08-11 17:35:58');
INSERT INTO `bt_dictionary` VALUES (131, '', 1, '出入库单完结状态', 0, 7, 706, 0, 0, 0, NULL, '', 0, '2019-08-11 08:24:53', '2019-08-11 16:25:11');
INSERT INTO `bt_dictionary` VALUES (132, '', 1, '未完结', 0, 706, 70601, 0, 0, 0, NULL, '', 0, '2019-08-11 08:25:28', '2019-08-11 17:36:05');
INSERT INTO `bt_dictionary` VALUES (133, '', 1, '已完结', 0, 706, 70602, 0, 0, 0, NULL, '', 0, '2019-08-11 08:25:47', '2019-08-11 16:26:00');
INSERT INTO `bt_dictionary` VALUES (134, '', 1, '财务完结标志', 0, 1, 128, 0, 0, 0, NULL, '', 0, '2019-08-11 08:29:38', '2019-08-11 08:29:38');
INSERT INTO `bt_dictionary` VALUES (135, '', 1, '业务完结标志', 0, 1, 129, 0, 0, 0, NULL, '', 0, '2019-08-11 08:29:56', '2019-08-11 16:30:09');
INSERT INTO `bt_dictionary` VALUES (136, '', 1, '财务已完结', 0, 128, 12801, 0, 0, 0, NULL, '', 0, '2019-08-11 08:30:41', '2019-08-11 08:30:41');
INSERT INTO `bt_dictionary` VALUES (137, '', 1, '财务未完结', 0, 128, 12803, 0, 0, 0, NULL, '', 0, '2019-08-11 08:31:15', '2019-08-11 08:31:15');
INSERT INTO `bt_dictionary` VALUES (138, '', 1, '业务已完结', 0, 129, 12901, 0, 0, 0, NULL, '', 0, '2019-08-11 08:31:35', '2019-08-11 08:31:35');
INSERT INTO `bt_dictionary` VALUES (139, '', 1, '业务未完结', 0, 129, 12902, 0, 0, 0, NULL, '', 0, '2019-08-11 08:31:53', '2019-08-11 08:31:53');
INSERT INTO `bt_dictionary` VALUES (141, '', 1, '收回委托代销商品', 0, 701, 70105, 0, 0, 0, NULL, '', 0, '2019-08-11 09:37:14', '2019-08-11 17:37:26');
INSERT INTO `bt_dictionary` VALUES (142, '', 1, '发出委托代销商品', 0, 702, 70206, 0, 0, 0, NULL, '', 0, '2019-08-11 09:37:44', '2019-08-11 17:37:56');
INSERT INTO `bt_dictionary` VALUES (143, '', 1, '未执行', 0, 124, 12401, 0, 0, 0, NULL, '', 0, '2019-08-12 15:18:17', '2019-08-12 23:19:30');
INSERT INTO `bt_dictionary` VALUES (144, '', 1, '冻结', 0, 124, 12405, 0, 0, 0, NULL, '', 0, '2019-08-12 15:21:09', '2019-08-12 15:21:09');
INSERT INTO `bt_dictionary` VALUES (145, 'relationship', 8, '待分类', 8, 102, 100208, 0, 0, 1, NULL, '', 0, '2019-08-13 02:06:45', '2019-08-15 09:32:10');

-- ----------------------------
-- Table structure for bt_in_out_details
-- ----------------------------
DROP TABLE IF EXISTS `bt_in_out_details`;
CREATE TABLE `bt_in_out_details`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '核销码',
  `in_out` tinyint(5) DEFAULT NULL COMMENT '出库or入库',
  `in_out_date` timestamp(0) DEFAULT NULL COMMENT '出/入库时间',
  `in_out_type` tinyint(5) DEFAULT NULL COMMENT '出/入库类型',
  `in_out_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出/入库订单号',
  `company_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '供应商名称--冗余',
  `good_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '-' COMMENT '商品唯一编码',
  `good_type` tinyint(5) DEFAULT NULL COMMENT '商品分类',
  `good_color` tinyint(5) DEFAULT NULL COMMENT '商品颜色',
  `good_model` tinyint(5) DEFAULT NULL COMMENT '商品型号',
  `good_strain` tinyint(5) DEFAULT NULL COMMENT '商品品系',
  `good_reserve1` tinyint(5) DEFAULT NULL COMMENT '商品预留核算维度1',
  `good_reserve2` tinyint(5) DEFAULT NULL COMMENT '商品预留核算维度2',
  `push_count` int(11) DEFAULT NULL COMMENT '入库数量',
  `pull_count` int(11) DEFAULT NULL COMMENT '出库数量',
  `unit` tinyint(5) DEFAULT NULL COMMENT '计量单位',
  `pricing_methods` tinyint(5) DEFAULT NULL COMMENT '计价方式',
  `unit_price` decimal(10, 2) DEFAULT NULL COMMENT '单价',
  `push_total_price` decimal(10, 2) DEFAULT NULL COMMENT '入库总价',
  `pull_total_price` decimal(10, 2) DEFAULT NULL COMMENT '出库总价',
  `verified_count` int(11) DEFAULT NULL COMMENT '出入库核销数量',
  `unverified_count` int(11) DEFAULT NULL COMMENT '出入库未核销数量',
  `order_verified_count` int(11) DEFAULT NULL COMMENT '采购/销售订单核销',
  `order_unverified_count` int(11) DEFAULT NULL COMMENT '采购/销售订单未核销',
  `finance_finish` tinyint(2) DEFAULT NULL COMMENT '财务完结。0否，1是',
  `business_finish` tinyint(2) DEFAULT NULL COMMENT '业务完结。0否，1是',
  `del_flag` tinyint(2) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bt_in_out_general
-- ----------------------------
DROP TABLE IF EXISTS `bt_in_out_general`;
CREATE TABLE `bt_in_out_general`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '核销码',
  `in_out` tinyint(5) DEFAULT NULL COMMENT '出库or入库',
  `in_out_date` timestamp(0) DEFAULT NULL COMMENT '出/入库时间',
  `in_out_type` tinyint(5) DEFAULT NULL COMMENT '出/入库类型',
  `in_out_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '出/入库订单号',
  `warehouse` tinyint(5) DEFAULT NULL COMMENT '当前仓库',
  `company_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '供应商名称--冗余',
  `in_out_finish` tinyint(2) DEFAULT NULL COMMENT '出入库是否核销完。0否，1是',
  `order_finish` tinyint(2) DEFAULT NULL COMMENT '订单核销完。0否，1是',
  `finance_finish` tinyint(2) DEFAULT NULL COMMENT '财务完结。0否，1是',
  `business_finish` tinyint(2) DEFAULT NULL COMMENT '业务完结。0否，1是',
  `del_flag` tinyint(2) DEFAULT NULL COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bt_menu
-- ----------------------------
DROP TABLE IF EXISTS `bt_menu`;
CREATE TABLE `bt_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F权限）',
  `visible` tinyint(2) DEFAULT 0 COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '#' COMMENT '菜单图标',
  `is_default` tinyint(2) DEFAULT 0 COMMENT '是否默认赋予权限[0:否 ; 1:是]',
  `del_flag` tinyint(2) DEFAULT 0 COMMENT '删除标志 [0:有效 ;1:删除]',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'admin' COMMENT '创建者',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'admin' COMMENT '更新者',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_menu
-- ----------------------------
INSERT INTO `bt_menu` VALUES (1, '工作台', 0, 1, '/dashboard/init', 'M', 0, '#', 'layui-icon-home', 1, 0, 'admin', '2019-07-17 20:59:53', 'admin', '2019-07-30 16:51:16', '工作台就一个目录');
INSERT INTO `bt_menu` VALUES (2, '用户中心', 0, 3, '#', 'M', 0, '#', 'layui-icon-user', 0, 0, 'admin', '2019-07-17 21:01:17', 'admin', '2019-08-02 16:43:18', '');
INSERT INTO `bt_menu` VALUES (3, '系统管理', 0, 4, '#', 'M', 0, '#', 'layui-icon-set', 0, 0, 'admin', '2019-07-19 11:21:33', 'admin', '2019-08-02 16:43:27', '');
INSERT INTO `bt_menu` VALUES (4, '用户管理', 2, 1, '/user/init', 'C', 0, '#', '#', 0, 0, 'admin', '2019-07-24 14:48:57', 'admin', '2019-07-30 16:51:20', '');
INSERT INTO `bt_menu` VALUES (5, '菜单管理', 3, 1, '/system/menu/init', 'C', 0, '#', '#', 0, 0, 'admin', '2019-07-19 11:26:16', 'admin', '2019-07-30 16:51:19', '');
INSERT INTO `bt_menu` VALUES (6, '数据字典', 3, 2, '/system/dictionary/init', 'C', 0, '#', '#', 0, 0, 'admin', '2019-07-30 06:40:27', 'admin', '2019-08-02 15:31:58', '数据字典的菜单');
INSERT INTO `bt_menu` VALUES (7, '菜单列表查询', 5, 1, '#', 'F', 0, 'business:menu:list', '#', 0, 0, 'admin', '2019-07-24 14:44:26', 'admin', '2019-07-24 14:46:48', '');
INSERT INTO `bt_menu` VALUES (8, '菜单修改', 5, 2, '#', 'F', 0, 'business:menu:edit', '#', 0, 0, 'admin', '2019-07-24 14:45:11', 'admin', '2019-07-24 14:50:10', '');
INSERT INTO `bt_menu` VALUES (9, '删除菜单', 5, 3, '#', 'F', 0, 'business:menu:del', '#', 0, 0, 'admin', '2019-07-24 14:45:50', 'admin', '2019-07-24 14:46:46', '');
INSERT INTO `bt_menu` VALUES (10, '添加菜单', 5, 4, '#', 'F', 0, 'business:menu:add', '#', 0, 0, 'admin', '2019-07-24 14:48:02', 'admin', '2019-07-24 14:48:02', '');
INSERT INTO `bt_menu` VALUES (11, '用户列表查询', 4, 1, '#', 'F', 0, 'business:user:list', '#', 0, 0, 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:49:39', '');
INSERT INTO `bt_menu` VALUES (12, '用户修改', 4, 2, '#', 'F', 0, 'business:user:edit', '#', 0, 0, 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES (13, '用户删除', 4, 3, '#', 'F', 0, 'business:user:del', '#', 0, 0, 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES (14, '添加用户', 4, 4, '#', 'F', 0, 'business:user:add', '#', 0, 0, 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES (15, '用户授权', 4, 0, '#', 'F', 0, 'business:menu:auth', '#', 0, 0, 'admin', '2019-07-30 07:21:36', 'admin', '2019-07-30 16:51:21', '');
INSERT INTO `bt_menu` VALUES (16, '取消授权', 4, 5, '#', 'F', 0, 'business:menu:unauth', '#', 0, 0, 'admin', '2019-07-30 07:22:04', 'admin', '2019-07-30 16:51:21', '');
INSERT INTO `bt_menu` VALUES (17, '查询数据字典', 6, 1, '#', 'F', 0, 'business:dic:list', '#', 0, 0, 'admin', '2019-07-30 08:07:01', 'admin', '2019-07-30 16:51:22', '');
INSERT INTO `bt_menu` VALUES (18, '修改数据字典', 6, 2, '#', 'F', 0, 'business:dic:edit', '#', 0, 0, 'admin', '2019-07-30 08:07:30', 'admin', '2019-07-30 16:51:23', '');
INSERT INTO `bt_menu` VALUES (19, '删除数据字典', 6, 3, '#', 'F', 0, 'business:dic:del', '#', 0, 0, 'admin', '2019-07-30 08:07:59', 'admin', '2019-07-30 16:51:24', '');
INSERT INTO `bt_menu` VALUES (20, '新增数据字典', 6, 4, '#', 'F', 0, 'business:dic:add', '#', 0, 0, 'admin', '2019-07-30 08:08:31', 'admin', '2019-07-30 16:51:24', '');
INSERT INTO `bt_menu` VALUES (21, '导出数据字典', 6, 5, '#', 'F', 0, 'business:dic:export', '#', 0, 0, 'admin', '2019-07-30 08:09:05', 'admin', '2019-07-30 16:51:26', '');
INSERT INTO `bt_menu` VALUES (22, '组织架构', 0, 2, '#', 'M', 0, '#', 'layui-icon-group', 0, 0, 'admin', '2019-08-02 08:44:00', 'admin', '2019-08-02 16:50:54', '');
INSERT INTO `bt_menu` VALUES (23, '单位及个人管理', 22, 2, '/company/init', 'C', 0, '#', '#', 0, 0, 'admin', '2019-08-02 08:45:02', 'admin', '2019-08-02 08:45:02', '');
INSERT INTO `bt_menu` VALUES (24, '列表查询', 23, 1, '#', 'F', 0, 'business:company:list', '#', 0, 0, 'admin', '2019-08-02 08:46:39', 'admin', '2019-08-02 08:46:39', '');
INSERT INTO `bt_menu` VALUES (25, '信息修改', 23, 2, '#', 'F', 0, 'business:company:edit', '#', 0, 0, 'admin', '2019-08-02 08:47:37', 'admin', '2019-08-02 08:47:37', '');
INSERT INTO `bt_menu` VALUES (26, '添加公司或个人', 23, 3, '#', 'F', 0, 'business:company:add', '#', 0, 0, 'admin', '2019-08-02 08:48:16', 'admin', '2019-08-02 08:48:16', '');
INSERT INTO `bt_menu` VALUES (27, '删除公司或个人', 23, 4, '#', 'F', 0, 'business:company:del', '#', 0, 0, 'admin', '2019-08-02 08:48:45', 'admin', '2019-08-02 08:48:45', '');
INSERT INTO `bt_menu` VALUES (28, '岗位管理', 22, 1, '/position/init', 'C', 0, '#', '#', 0, 0, 'admin', '2019-08-09 07:13:51', 'admin', '2019-08-09 07:13:51', '');
INSERT INTO `bt_menu` VALUES (29, '岗位查询', 28, 1, '#', 'F', 0, 'business:position:list', '#', 0, 0, 'admin', '2019-08-09 07:15:51', 'admin', '2019-08-09 07:15:51', '');
INSERT INTO `bt_menu` VALUES (30, '岗位添加', 28, 2, '#', 'F', 0, 'business:position:add', '#', 0, 0, 'admin', '2019-08-09 07:16:35', 'admin', '2019-08-09 07:16:35', '');
INSERT INTO `bt_menu` VALUES (31, '岗位修改', 28, 3, '#', 'F', 0, 'business:position:edit', '#', 0, 0, 'admin', '2019-08-09 07:16:55', 'admin', '2019-08-09 07:16:55', '');
INSERT INTO `bt_menu` VALUES (32, '岗位删除', 28, 4, '#', 'F', 0, 'business:position:del', '#', 0, 0, 'admin', '2019-08-09 07:17:12', 'admin', '2019-08-09 07:17:12', '');
INSERT INTO `bt_menu` VALUES (33, '岗位人员查询', 28, 5, '#', 'F', 0, 'business:position:info:list', '#', 0, 0, 'admin', '2019-08-09 07:18:20', 'admin', '2019-08-09 07:18:20', '');
INSERT INTO `bt_menu` VALUES (34, '岗位人员添加', 28, 6, '#', 'F', 0, 'business:position:info:add', '#', 0, 0, 'admin', '2019-08-09 07:18:42', 'admin', '2019-08-09 15:18:55', '');
INSERT INTO `bt_menu` VALUES (35, '岗位人员删除', 28, 7, '#', 'F', 0, 'business:position:info:del', '#', 0, 0, 'admin', '2019-08-09 07:19:16', 'admin', '2019-08-09 07:19:16', '');
INSERT INTO `bt_menu` VALUES (36, '信息导出', 23, 5, '#', 'F', 0, 'business:company:export', '#', 0, 0, 'admin', '2019-08-09 07:52:34', 'admin', '2019-08-09 07:52:34', '');

-- ----------------------------
-- Table structure for bt_position
-- ----------------------------
DROP TABLE IF EXISTS `bt_position`;
CREATE TABLE `bt_position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `parent_id` int(11) NOT NULL COMMENT '父节点id',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序字典',
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '区分部门还是岗位，从数据字典中取得',
  `status` int(11) NOT NULL,
  `used` int(11) NOT NULL DEFAULT 0 COMMENT '是否已用（0：未用，1：已用）',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_position
-- ----------------------------
INSERT INTO `bt_position` VALUES (1, '总经理办公室', 0, 0, 14, 3, 1, '总经理办公室', 0, '2019-08-06 15:06:06', '2019-08-08 10:48:41');
INSERT INTO `bt_position` VALUES (2, '总经理本人', 1, 1, 15, 4, 0, '李沅燊', 0, '2019-08-06 15:15:29', '2019-08-08 10:48:53');
INSERT INTO `bt_position` VALUES (3, '财务部', 0, 1, 14, 3, 0, '', 0, '2019-08-08 01:34:51', '2019-08-08 10:48:56');
INSERT INTO `bt_position` VALUES (4, '经理岗', 3, 1, 15, 3, 0, '', 0, '2019-08-08 01:38:29', '2019-08-09 01:26:09');
INSERT INTO `bt_position` VALUES (5, '副经理岗', 3, 2, 15, 3, 0, '', 0, '2019-08-08 01:39:11', '2019-08-09 01:26:14');

-- ----------------------------
-- Table structure for bt_position_company
-- ----------------------------
DROP TABLE IF EXISTS `bt_position_company`;
CREATE TABLE `bt_position_company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL,
  `position_id` int(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_position_id`(`position_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_position_company
-- ----------------------------
INSERT INTO `bt_position_company` VALUES (16, 1, 4, '2019-08-15 06:38:03');
INSERT INTO `bt_position_company` VALUES (17, 13, 4, '2019-08-15 06:38:03');
INSERT INTO `bt_position_company` VALUES (18, 1, 5, '2019-08-15 06:38:13');
INSERT INTO `bt_position_company` VALUES (19, 13, 2, '2019-08-15 06:38:29');

-- ----------------------------
-- Table structure for bt_user
-- ----------------------------
DROP TABLE IF EXISTS `bt_user`;
CREATE TABLE `bt_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '盐加密',
  `true_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '用户邮箱',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '手机号码',
  `gender` tinyint(2) DEFAULT 0 COMMENT '用户性别（1男 2女 0未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '头像路径',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `status` tinyint(2) DEFAULT 0 COMMENT '帐号状态（0正常 1停用）',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '最后登陆ip',
  `login_date` timestamp(0) DEFAULT NULL COMMENT '最后登陆时间',
  `del_flag` tinyint(2) DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_user
-- ----------------------------
INSERT INTO `bt_user` VALUES (1, 'admin', 'c39016fa679e704102bd8ac0e16a4a20', '2rKtmiTD', '管理员', '00', '929525390@qq.com', '15866668888', 1, '/images/avatar.jpg', 25, 0, '127.0.0.1', '2019-09-02 06:56:17', 0, '2019-03-17 18:42:49', '2019-04-14 12:14:38');
INSERT INTO `bt_user` VALUES (4, 'qweert', '16efca7001015201498952e8b5c37cc6', 'VIeCPpdB', '123qwed', '00', '166@qq.com', '13333333333', 2, '/images/avatar.jpg', 25, 0, '127.0.0.1', '2019-08-16 06:03:36', 0, '2019-07-23 04:29:46', '2019-07-23 12:30:11');

-- ----------------------------
-- Table structure for bt_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `bt_user_menu`;
CREATE TABLE `bt_user_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_menu_index`(`user_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bt_user_menu
-- ----------------------------
INSERT INTO `bt_user_menu` VALUES (1, 1, 1);
INSERT INTO `bt_user_menu` VALUES (2, 1, 2);
INSERT INTO `bt_user_menu` VALUES (16, 1, 3);
INSERT INTO `bt_user_menu` VALUES (15, 1, 4);
INSERT INTO `bt_user_menu` VALUES (14, 1, 5);
INSERT INTO `bt_user_menu` VALUES (6, 1, 6);
INSERT INTO `bt_user_menu` VALUES (7, 1, 7);
INSERT INTO `bt_user_menu` VALUES (8, 1, 8);
INSERT INTO `bt_user_menu` VALUES (9, 1, 9);
INSERT INTO `bt_user_menu` VALUES (10, 1, 10);
INSERT INTO `bt_user_menu` VALUES (11, 1, 11);
INSERT INTO `bt_user_menu` VALUES (12, 1, 12);
INSERT INTO `bt_user_menu` VALUES (13, 1, 13);
INSERT INTO `bt_user_menu` VALUES (65, 1, 14);
INSERT INTO `bt_user_menu` VALUES (63, 1, 15);
INSERT INTO `bt_user_menu` VALUES (64, 1, 16);
INSERT INTO `bt_user_menu` VALUES (71, 1, 17);
INSERT INTO `bt_user_menu` VALUES (74, 1, 18);
INSERT INTO `bt_user_menu` VALUES (75, 1, 19);
INSERT INTO `bt_user_menu` VALUES (76, 1, 20);
INSERT INTO `bt_user_menu` VALUES (77, 1, 21);
INSERT INTO `bt_user_menu` VALUES (91, 1, 24);
INSERT INTO `bt_user_menu` VALUES (99, 1, 25);
INSERT INTO `bt_user_menu` VALUES (100, 1, 26);
INSERT INTO `bt_user_menu` VALUES (101, 1, 27);
INSERT INTO `bt_user_menu` VALUES (89, 1, 28);
INSERT INTO `bt_user_menu` VALUES (92, 1, 29);
INSERT INTO `bt_user_menu` VALUES (94, 1, 30);
INSERT INTO `bt_user_menu` VALUES (93, 1, 31);
INSERT INTO `bt_user_menu` VALUES (95, 1, 32);
INSERT INTO `bt_user_menu` VALUES (96, 1, 33);
INSERT INTO `bt_user_menu` VALUES (97, 1, 34);
INSERT INTO `bt_user_menu` VALUES (98, 1, 35);
INSERT INTO `bt_user_menu` VALUES (102, 1, 36);
INSERT INTO `bt_user_menu` VALUES (62, 4, 5);
INSERT INTO `bt_user_menu` VALUES (61, 4, 10);
INSERT INTO `bt_user_menu` VALUES (103, 4, 11);

SET FOREIGN_KEY_CHECKS = 1;
