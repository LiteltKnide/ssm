/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-16 11:51:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quetion_name` varchar(255) DEFAULT '',
  `type` varchar(1) DEFAULT NULL,
  `options` varchar(255) DEFAULT '',
  `bag_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question` (`bag_id`),
  CONSTRAINT `fk_question` FOREIGN KEY (`bag_id`) REFERENCES `bag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
