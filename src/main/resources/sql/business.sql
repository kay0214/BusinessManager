/*
Navicat MySQL Data Transfer

Source Server         : root-local
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-08-09 16:45:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bt_company
-- ----------------------------
DROP TABLE IF EXISTS `bt_company`;
CREATE TABLE `bt_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_code` varchar(255) NOT NULL DEFAULT '#' COMMENT '公司助记代码',
  `account_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '财务系统代码',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型-从数据字典录入',
  `credit_code` varchar(255) NOT NULL DEFAULT '#' COMMENT '公司信用代码/个人身份证号码',
  `full_name` varchar(255) NOT NULL COMMENT '公司全称/个人姓名',
  `short_name` varchar(255) DEFAULT '#' COMMENT '公司简称',
  `status` int(11) NOT NULL COMMENT '启用',
  `used` int(11) NOT NULL COMMENT '已被使用(0：否，1：是)',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_company_code` (`company_code`),
  UNIQUE KEY `idx_credit_code` (`credit_code`),
  KEY `idx_full_name` (`full_name`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bt_company
-- ----------------------------
INSERT INTO `bt_company` VALUES ('4', 'P_001', '', '12', '370222122102141231', '张三', '小三', '3', '0', '员工小三', '0', '2019-08-08 08:41:47', '2019-08-08 08:41:47');
INSERT INTO `bt_company` VALUES ('5', 'P_002', '', '12', '370811199406011234', '李四', '小四', '3', '0', '员工小四', '0', '2019-08-08 08:42:33', '2019-08-08 08:42:33');

-- ----------------------------
-- Table structure for bt_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `bt_dictionary`;
CREATE TABLE `bt_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '#' COMMENT '字典区分,用来区分某一类字典',
  `value` int(11) DEFAULT '1' COMMENT '字典值',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点id',
  `self_id` int(11) DEFAULT NULL COMMENT '自身id',
  `freeze` int(11) NOT NULL DEFAULT '0' COMMENT '冻结（0：未冻结，1：冻结）',
  `used` int(11) NOT NULL DEFAULT '0' COMMENT '是否已用（0：未用，1：已用）',
  `built_in` int(11) NOT NULL DEFAULT '0' COMMENT '是否内置（0：否，1：是）',
  `node_type_id` int(11) DEFAULT NULL COMMENT '暂时保留吧',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_type` (`type`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bt_dictionary
-- ----------------------------
INSERT INTO `bt_dictionary` VALUES ('1', 'base', '1', '基础设置', '1', '0', '1', '0', '1', '1', null, '', '0', '2019-08-02 05:52:26', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('2', '#', '0', '启用类型', '1', '1', '1001', '0', '1', '1', null, '启用类型', '0', '2019-08-02 05:54:36', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('3', 'status', '1', '启用', '1', '1001', '100101', '0', '1', '1', null, '', '0', '2019-08-01 21:55:21', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('4', 'status', '2', '停用', '2', '1001', '100102', '0', '1', '1', null, '', '0', '2019-08-01 21:55:35', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('5', '#', '0', '往来公司/个人关系类型', '2', '1', '1002', '0', '1', '1', null, '', '0', '2019-08-02 05:57:53', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('6', 'relationship', '1', '本公司', '1', '1002', '100201', '0', '0', '1', null, '', '0', '2019-08-02 05:58:18', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('7', 'relationship', '2', '东风公司', '2', '1002', '100202', '0', '0', '1', null, '', '0', '2019-08-02 05:58:37', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('8', 'relationship', '3', '业务公司', '3', '1002', '100203', '0', '0', '1', null, '', '0', '2019-08-02 05:58:51', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('9', 'relationship', '4', '代理商', '4', '1002', '100204', '0', '1', '1', null, '', '0', '2019-08-02 05:59:08', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('10', 'relationship', '5', '关联公司', '5', '1002', '100205', '0', '1', '1', null, '', '0', '2019-08-02 05:59:48', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('11', 'relationship', '6', '外部个人', '6', '1002', '100206', '0', '0', '1', null, '', '0', '2019-08-02 06:00:05', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('12', 'relationship', '7', '员工', '7', '1002', '100207', '0', '1', '1', null, '', '0', '2019-08-02 06:00:32', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('13', '#', '0', '职位类型', '3', '1', '1003', '0', '1', '1', null, '', '0', '2019-08-08 02:42:22', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('14', 'position', '1', '部门', '1', '1003', '100301', '0', '1', '1', null, '', '0', '2019-08-08 02:43:36', '2019-08-09 16:44:57');
INSERT INTO `bt_dictionary` VALUES ('15', 'position', '2', '岗位', '2', '1003', '100302', '0', '1', '1', null, '', '0', '2019-08-08 02:44:33', '2019-08-09 16:44:57');

-- ----------------------------
-- Table structure for bt_menu
-- ----------------------------
DROP TABLE IF EXISTS `bt_menu`;
CREATE TABLE `bt_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F权限）',
  `visible` tinyint(2) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `is_default` tinyint(2) DEFAULT '0' COMMENT '是否默认赋予权限[0:否 ; 1:是]',
  `del_flag` tinyint(2) DEFAULT '0' COMMENT '删除标志 [0:有效 ;1:删除]',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'admin' COMMENT '创建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'admin' COMMENT '更新者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of bt_menu
-- ----------------------------
INSERT INTO `bt_menu` VALUES ('1', '工作台', '0', '1', '/dashboard/init', 'M', '0', '#', 'layui-icon-home', '1', '0', 'admin', '2019-07-17 20:59:53', 'admin', '2019-07-30 16:51:16', '工作台就一个目录');
INSERT INTO `bt_menu` VALUES ('2', '用户中心', '0', '3', '#', 'M', '0', '#', 'layui-icon-user', '0', '0', 'admin', '2019-07-17 21:01:17', 'admin', '2019-08-02 16:43:18', '');
INSERT INTO `bt_menu` VALUES ('3', '系统管理', '0', '4', '#', 'M', '0', '#', 'layui-icon-set', '0', '0', 'admin', '2019-07-19 11:21:33', 'admin', '2019-08-02 16:43:27', '');
INSERT INTO `bt_menu` VALUES ('4', '用户管理', '2', '1', '/user/init', 'C', '0', '#', '#', '0', '0', 'admin', '2019-07-24 14:48:57', 'admin', '2019-07-30 16:51:20', '');
INSERT INTO `bt_menu` VALUES ('5', '菜单管理', '3', '1', '/system/menu/init', 'C', '0', '#', '#', '0', '0', 'admin', '2019-07-19 11:26:16', 'admin', '2019-07-30 16:51:19', '');
INSERT INTO `bt_menu` VALUES ('6', '数据字典', '3', '2', '/system/dictionary/init', 'C', '0', '#', '#', '0', '0', 'admin', '2019-07-30 06:40:27', 'admin', '2019-08-02 15:31:58', '数据字典的菜单');
INSERT INTO `bt_menu` VALUES ('7', '菜单列表查询', '5', '1', '#', 'F', '0', 'business:menu:list', '#', '0', '0', 'admin', '2019-07-24 14:44:26', 'admin', '2019-07-24 14:46:48', '');
INSERT INTO `bt_menu` VALUES ('8', '菜单修改', '5', '2', '#', 'F', '0', 'business:menu:edit', '#', '0', '0', 'admin', '2019-07-24 14:45:11', 'admin', '2019-07-24 14:50:10', '');
INSERT INTO `bt_menu` VALUES ('9', '删除菜单', '5', '3', '#', 'F', '0', 'business:menu:del', '#', '0', '0', 'admin', '2019-07-24 14:45:50', 'admin', '2019-07-24 14:46:46', '');
INSERT INTO `bt_menu` VALUES ('10', '添加菜单', '5', '4', '#', 'F', '0', 'business:menu:add', '#', '0', '0', 'admin', '2019-07-24 14:48:02', 'admin', '2019-07-24 14:48:02', '');
INSERT INTO `bt_menu` VALUES ('11', '用户列表查询', '4', '1', '#', 'F', '0', 'business:user:list', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:49:39', '');
INSERT INTO `bt_menu` VALUES ('12', '用户修改', '4', '2', '#', 'F', '0', 'business:user:edit', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES ('13', '用户删除', '4', '3', '#', 'F', '0', 'business:user:del', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES ('14', '添加用户', '4', '4', '#', 'F', '0', 'business:user:add', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES ('15', '用户授权', '4', '0', '#', 'F', '0', 'business:menu:auth', '#', '0', '0', 'admin', '2019-07-30 07:21:36', 'admin', '2019-07-30 16:51:21', '');
INSERT INTO `bt_menu` VALUES ('16', '取消授权', '4', '5', '#', 'F', '0', 'business:menu:unauth', '#', '0', '0', 'admin', '2019-07-30 07:22:04', 'admin', '2019-07-30 16:51:21', '');
INSERT INTO `bt_menu` VALUES ('17', '查询数据字典', '6', '1', '#', 'F', '0', 'business:dic:list', '#', '0', '0', 'admin', '2019-07-30 08:07:01', 'admin', '2019-07-30 16:51:22', '');
INSERT INTO `bt_menu` VALUES ('18', '修改数据字典', '6', '2', '#', 'F', '0', 'business:dic:edit', '#', '0', '0', 'admin', '2019-07-30 08:07:30', 'admin', '2019-07-30 16:51:23', '');
INSERT INTO `bt_menu` VALUES ('19', '删除数据字典', '6', '3', '#', 'F', '0', 'business:dic:del', '#', '0', '0', 'admin', '2019-07-30 08:07:59', 'admin', '2019-07-30 16:51:24', '');
INSERT INTO `bt_menu` VALUES ('20', '新增数据字典', '6', '4', '#', 'F', '0', 'business:dic:add', '#', '0', '0', 'admin', '2019-07-30 08:08:31', 'admin', '2019-07-30 16:51:24', '');
INSERT INTO `bt_menu` VALUES ('21', '导出数据字典', '6', '5', '#', 'F', '0', 'business:dic:export', '#', '0', '0', 'admin', '2019-07-30 08:09:05', 'admin', '2019-07-30 16:51:26', '');
INSERT INTO `bt_menu` VALUES ('22', '组织架构', '0', '2', '#', 'M', '0', '#', 'layui-icon-group', '0', '0', 'admin', '2019-08-02 08:44:00', 'admin', '2019-08-02 16:50:54', '');
INSERT INTO `bt_menu` VALUES ('23', '单位及个人管理', '22', '2', '/company/init', 'C', '0', '#', '#', '0', '0', 'admin', '2019-08-02 08:45:02', 'admin', '2019-08-02 08:45:02', '');
INSERT INTO `bt_menu` VALUES ('24', '列表查询', '23', '1', '#', 'F', '0', 'business:company:list', '#', '0', '0', 'admin', '2019-08-02 08:46:39', 'admin', '2019-08-02 08:46:39', '');
INSERT INTO `bt_menu` VALUES ('25', '信息修改', '23', '2', '#', 'F', '0', 'business:company:edit', '#', '0', '0', 'admin', '2019-08-02 08:47:37', 'admin', '2019-08-02 08:47:37', '');
INSERT INTO `bt_menu` VALUES ('26', '添加公司或个人', '23', '3', '#', 'F', '0', 'business:company:add', '#', '0', '0', 'admin', '2019-08-02 08:48:16', 'admin', '2019-08-02 08:48:16', '');
INSERT INTO `bt_menu` VALUES ('27', '删除公司或个人', '23', '4', '#', 'F', '0', 'business:company:del', '#', '0', '0', 'admin', '2019-08-02 08:48:45', 'admin', '2019-08-02 08:48:45', '');
INSERT INTO `bt_menu` VALUES ('28', '岗位管理', '22', '1', '/position/init', 'C', '0', '#', '#', '0', '0', 'admin', '2019-08-09 07:13:51', 'admin', '2019-08-09 07:13:51', '');
INSERT INTO `bt_menu` VALUES ('29', '岗位查询', '28', '1', '#', 'F', '0', 'business:position:list', '#', '0', '0', 'admin', '2019-08-09 07:15:51', 'admin', '2019-08-09 07:15:51', '');
INSERT INTO `bt_menu` VALUES ('30', '岗位添加', '28', '2', '#', 'F', '0', 'business:position:add', '#', '0', '0', 'admin', '2019-08-09 07:16:35', 'admin', '2019-08-09 07:16:35', '');
INSERT INTO `bt_menu` VALUES ('31', '岗位修改', '28', '3', '#', 'F', '0', 'business:position:edit', '#', '0', '0', 'admin', '2019-08-09 07:16:55', 'admin', '2019-08-09 07:16:55', '');
INSERT INTO `bt_menu` VALUES ('32', '岗位删除', '28', '4', '#', 'F', '0', 'business:position:del', '#', '0', '0', 'admin', '2019-08-09 07:17:12', 'admin', '2019-08-09 07:17:12', '');
INSERT INTO `bt_menu` VALUES ('33', '岗位人员查询', '28', '5', '#', 'F', '0', 'business:position:info:list', '#', '0', '0', 'admin', '2019-08-09 07:18:20', 'admin', '2019-08-09 07:18:20', '');
INSERT INTO `bt_menu` VALUES ('34', '岗位人员添加', '28', '6', '#', 'F', '0', 'business:position:info:add', '#', '0', '0', 'admin', '2019-08-09 07:18:42', 'admin', '2019-08-09 15:18:55', '');
INSERT INTO `bt_menu` VALUES ('35', '岗位人员删除', '28', '7', '#', 'F', '0', 'business:position:info:del', '#', '0', '0', 'admin', '2019-08-09 07:19:16', 'admin', '2019-08-09 07:19:16', '');
INSERT INTO `bt_menu` VALUES ('36', '信息导出', '23', '5', '#', 'F', '0', 'business:company:export', '#', '0', '0', 'admin', '2019-08-09 07:52:34', 'admin', '2019-08-09 07:52:34', '');

-- ----------------------------
-- Table structure for bt_position
-- ----------------------------
DROP TABLE IF EXISTS `bt_position`;
CREATE TABLE `bt_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '岗位名称',
  `parent_id` int(11) NOT NULL COMMENT '父节点id',
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序字典',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '区分部门还是岗位，从数据字典中取得',
  `status` int(11) NOT NULL,
  `used` int(11) NOT NULL DEFAULT '0' COMMENT '是否已用（0：未用，1：已用）',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bt_position
-- ----------------------------
INSERT INTO `bt_position` VALUES ('1', '总经理办公室', '0', '0', '14', '3', '1', '总经理办公室', '0', '2019-08-06 15:06:06', '2019-08-08 10:48:41');
INSERT INTO `bt_position` VALUES ('2', '总经理本人', '1', '1', '15', '4', '0', '李沅燊', '0', '2019-08-06 15:15:29', '2019-08-08 10:48:53');
INSERT INTO `bt_position` VALUES ('3', '财务部', '0', '1', '14', '3', '0', '', '0', '2019-08-08 01:34:51', '2019-08-08 10:48:56');
INSERT INTO `bt_position` VALUES ('4', '经理岗', '3', '1', '15', '3', '0', '', '0', '2019-08-08 01:38:29', '2019-08-09 01:26:09');
INSERT INTO `bt_position` VALUES ('5', '副经理岗', '3', '2', '15', '3', '0', '', '0', '2019-08-08 01:39:11', '2019-08-09 01:26:14');

-- ----------------------------
-- Table structure for bt_position_company
-- ----------------------------
DROP TABLE IF EXISTS `bt_position_company`;
CREATE TABLE `bt_position_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL,
  `position_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_position_id` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bt_position_company
-- ----------------------------
INSERT INTO `bt_position_company` VALUES ('1', '4', '2', '2019-08-08 16:43:10');
INSERT INTO `bt_position_company` VALUES ('2', '5', '4', '2019-08-08 16:43:23');
INSERT INTO `bt_position_company` VALUES ('14', '4', '5', '2019-08-09 06:58:16');

-- ----------------------------
-- Table structure for bt_user
-- ----------------------------
DROP TABLE IF EXISTS `bt_user`;
CREATE TABLE `bt_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(30) NOT NULL COMMENT '登录账号',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `true_name` varchar(30) NOT NULL DEFAULT '' COMMENT '用户真实姓名',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号码',
  `gender` tinyint(2) DEFAULT '0' COMMENT '用户性别（1男 2女 0未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `status` tinyint(2) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `login_ip` varchar(20) DEFAULT '' COMMENT '最后登陆ip',
  `login_date` timestamp NULL DEFAULT NULL COMMENT '最后登陆时间',
  `del_flag` tinyint(2) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of bt_user
-- ----------------------------
INSERT INTO `bt_user` VALUES ('1', 'admin', 'c39016fa679e704102bd8ac0e16a4a20', '2rKtmiTD', '管理员', '00', '929525390@qq.com', '15866668888', '1', '/images/avatar.jpg', '25', '0', '127.0.0.1', '2019-08-09 08:38:20', '0', '2019-04-22 18:42:49', '2019-05-20 12:14:38');
INSERT INTO `bt_user` VALUES ('4', 'qweert', '16efca7001015201498952e8b5c37cc6', 'VIeCPpdB', '123qwed', '00', '166@qq.com', '13333333333', '2', '/images/avatar.jpg', '25', '0', '127.0.0.1', '2019-07-26 13:35:27', '0', '2019-07-24 12:29:46', '2019-07-24 20:30:11');

-- ----------------------------
-- Table structure for bt_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `bt_user_menu`;
CREATE TABLE `bt_user_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_menu_index` (`user_id`,`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='用户和菜单关联表';

-- ----------------------------
-- Records of bt_user_menu
-- ----------------------------
INSERT INTO `bt_user_menu` VALUES ('1', '1', '1');
INSERT INTO `bt_user_menu` VALUES ('2', '1', '2');
INSERT INTO `bt_user_menu` VALUES ('16', '1', '3');
INSERT INTO `bt_user_menu` VALUES ('15', '1', '4');
INSERT INTO `bt_user_menu` VALUES ('14', '1', '5');
INSERT INTO `bt_user_menu` VALUES ('6', '1', '6');
INSERT INTO `bt_user_menu` VALUES ('7', '1', '7');
INSERT INTO `bt_user_menu` VALUES ('8', '1', '8');
INSERT INTO `bt_user_menu` VALUES ('9', '1', '9');
INSERT INTO `bt_user_menu` VALUES ('10', '1', '10');
INSERT INTO `bt_user_menu` VALUES ('11', '1', '11');
INSERT INTO `bt_user_menu` VALUES ('12', '1', '12');
INSERT INTO `bt_user_menu` VALUES ('13', '1', '13');
INSERT INTO `bt_user_menu` VALUES ('65', '1', '14');
INSERT INTO `bt_user_menu` VALUES ('63', '1', '15');
INSERT INTO `bt_user_menu` VALUES ('64', '1', '16');
INSERT INTO `bt_user_menu` VALUES ('71', '1', '17');
INSERT INTO `bt_user_menu` VALUES ('74', '1', '18');
INSERT INTO `bt_user_menu` VALUES ('75', '1', '19');
INSERT INTO `bt_user_menu` VALUES ('76', '1', '20');
INSERT INTO `bt_user_menu` VALUES ('77', '1', '21');
INSERT INTO `bt_user_menu` VALUES ('91', '1', '24');
INSERT INTO `bt_user_menu` VALUES ('99', '1', '25');
INSERT INTO `bt_user_menu` VALUES ('100', '1', '26');
INSERT INTO `bt_user_menu` VALUES ('101', '1', '27');
INSERT INTO `bt_user_menu` VALUES ('89', '1', '28');
INSERT INTO `bt_user_menu` VALUES ('92', '1', '29');
INSERT INTO `bt_user_menu` VALUES ('94', '1', '30');
INSERT INTO `bt_user_menu` VALUES ('93', '1', '31');
INSERT INTO `bt_user_menu` VALUES ('95', '1', '32');
INSERT INTO `bt_user_menu` VALUES ('96', '1', '33');
INSERT INTO `bt_user_menu` VALUES ('97', '1', '34');
INSERT INTO `bt_user_menu` VALUES ('98', '1', '35');
INSERT INTO `bt_user_menu` VALUES ('102', '1', '36');
INSERT INTO `bt_user_menu` VALUES ('62', '4', '5');
INSERT INTO `bt_user_menu` VALUES ('61', '4', '10');
