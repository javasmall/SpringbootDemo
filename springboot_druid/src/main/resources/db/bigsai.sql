/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50716
Source Host           : biggsai.com:3306
Source Database       : bigsai

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-05-16 00:01:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dog
-- ----------------------------
DROP TABLE IF EXISTS `dog`;
CREATE TABLE `dog` (
  `dogname` varchar(255) DEFAULT NULL,
  `dogtype` varchar(255) DEFAULT NULL,
  `master_name` varchar(255) DEFAULT NULL,
  KEY `master` (`master_name`),
  CONSTRAINT `master` FOREIGN KEY (`master_name`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dog
-- ----------------------------
INSERT INTO `dog` VALUES ('舔狗我儿', '舔狗', 'bigsai');
INSERT INTO `dog` VALUES ('只舔富婆', '舔狗', 'bigsai');
INSERT INTO `dog` VALUES ('花花', '藏獒', 'javasmall');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('bigsai', '123456');
INSERT INTO `user` VALUES ('javasmall', '12345');
