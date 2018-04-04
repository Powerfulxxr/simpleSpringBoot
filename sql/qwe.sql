/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50521
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2018-04-04 13:47:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qwe
-- ----------------------------
DROP TABLE IF EXISTS `qwe`;
CREATE TABLE `qwe` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `su` varchar(255) DEFAULT NULL,
  `sc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qwe
-- ----------------------------
INSERT INTO `qwe` VALUES ('1', '张三', '语文', '100');
INSERT INTO `qwe` VALUES ('2', '张三', '数学', '90');
INSERT INTO `qwe` VALUES ('3', '张三', '外语', '80');
INSERT INTO `qwe` VALUES ('4', '李四', '语文', '70');
INSERT INTO `qwe` VALUES ('5', '李四', '数学', '60');
INSERT INTO `qwe` VALUES ('6', '李四', '外语', '50');
