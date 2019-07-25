/*
Navicat MySQL Data Transfer

Source Server         : root-local
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-07-24 17:05:32
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of bt_menu
-- ----------------------------
INSERT INTO `bt_menu` VALUES ('1', '工作台', '0', '1', '/dashboard/init', 'M', '0', '', 'layui-icon-home', '1', '0', 'admin', '2019-07-17 20:59:53', 'admin', '2019-07-23 12:31:46', '工作台就一个目录');
INSERT INTO `bt_menu` VALUES ('2', '用户中心', '0', '2', '#', 'M', '0', '', 'layui-icon-user', '0', '0', 'admin', '2019-07-17 21:01:17', 'admin', '2019-07-24 14:34:35', '');
INSERT INTO `bt_menu` VALUES ('3', '系统管理', '0', '3', '#', 'M', '0', '', 'layui-icon-set', '0', '0', 'admin', '2019-07-19 11:21:33', 'admin', '2019-07-24 14:34:34', '');
INSERT INTO `bt_menu` VALUES ('4', '菜单管理', '3', '1', '/system/menu/init', 'C', '0', '', '#', '0', '0', 'admin', '2019-07-19 11:26:16', 'admin', '2019-07-24 14:35:13', '');
INSERT INTO `bt_menu` VALUES ('5', '菜单列表查询', '4', '1', '#', 'F', '0', 'business:menu:list', '#', '0', '0', 'admin', '2019-07-24 14:44:26', 'admin', '2019-07-24 14:46:48', '');
INSERT INTO `bt_menu` VALUES ('6', '菜单修改', '4', '2', '#', 'F', '0', 'business:menu:edit', '#', '0', '0', 'admin', '2019-07-24 14:45:11', 'admin', '2019-07-24 14:50:10', '');
INSERT INTO `bt_menu` VALUES ('7', '删除菜单', '4', '3', '#', 'F', '0', 'business:menu:del', '#', '0', '0', 'admin', '2019-07-24 14:45:50', 'admin', '2019-07-24 14:46:46', '');
INSERT INTO `bt_menu` VALUES ('8', '添加菜单', '4', '4', '#', 'F', '0', 'business:menu:add', '#', '0', '0', 'admin', '2019-07-24 14:48:02', 'admin', '2019-07-24 14:48:02', '');
INSERT INTO `bt_menu` VALUES ('9', '用户管理', '2', '1', '/user/init', 'C', '0', '', '#', '0', '0', 'admin', '2019-07-24 14:48:57', 'admin', '2019-07-24 14:48:57', '');
INSERT INTO `bt_menu` VALUES ('10', '用户列表查询', '9', '1', '#', 'F', '0', 'business:user:list', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:49:39', '');
INSERT INTO `bt_menu` VALUES ('11', '用户修改', '9', '2', '#', 'F', '0', 'business:user:edit', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES ('12', '用户删除', '9', '3', '#', 'F', '0', 'business:user:del', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');
INSERT INTO `bt_menu` VALUES ('13', '添加用户', '9', '4', '#', 'F', '0', 'business:user:add', '#', '0', '0', 'admin', '2019-07-24 14:49:39', 'admin', '2019-07-24 14:50:24', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of bt_user
-- ----------------------------
INSERT INTO `bt_user` VALUES ('1', 'admin', 'c39016fa679e704102bd8ac0e16a4a20', '2rKtmiTD', '管理员', '00', '929525390@qq.com', '15866668888', '1', '/images/avatar.jpg', '25', '0', '127.0.0.1', '2019-07-24 09:00:59', '0', '2019-06-28 02:42:49', '2019-07-11 20:19:30');

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户和菜单关联表';

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
