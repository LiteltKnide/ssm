/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-03-16 11:49:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bag
-- ----------------------------
DROP TABLE IF EXISTS `bag`;
CREATE TABLE `bag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bag_name` varchar(255) DEFAULT '',
  `bag_seq` varchar(255) DEFAULT '',
  `survey_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bag` (`survey_id`),
  CONSTRAINT `fk_bag` FOREIGN KEY (`survey_id`) REFERENCES `survey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
