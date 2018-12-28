# Host: 127.0.0.1  (Version: 5.5.20)
# Date: 2014-09-24 22:59:47
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "stu_info"
#

DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `Id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `hight` float DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "stu_info"
#

INSERT INTO `stu_info` VALUES (10,'aa','aa',10,10,10);
