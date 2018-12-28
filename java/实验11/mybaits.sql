/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.27 : Database - mybatis
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis`;

/*Table structure for table `people` */

DROP TABLE IF EXISTS `people`;

CREATE TABLE `people` (
  `itenantid` int(11) NOT NULL,
  `updatetime` date DEFAULT NULL,
  `extnumber` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `cusid` varchar(30) DEFAULT NULL,
  `bigbyte` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `people` */

insert  into `people`(`itenantid`,`updatetime`,`extnumber`,`telephone`,`cusid`,`bigbyte`) values (8888,'2018-12-05','888888','888888','8888','aaaaa'),(7777,'2018-11-28','77777','777777','7777','bbbbbb'),(66666,'2018-12-12','666666','6666666','666666','cccccc');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`birthday`,`address`) values (1,'zhangsan','2018-12-10','huizhou'),(2,'lisi','2018-12-03','huizhou'),(3,'wangwu','2018-12-05','huizhou'),(4,'zhaoliu','2018-12-06','huizhou');


DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `last` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'bbb','bbb',NULL,'2018-12-24 07:56:07',NULL),(2,'ccc','ccccupdate','aaa','2018-12-24 08:28:46',NULL),(3,'hhh','hhh','ggg','2018-12-24 14:08:51',NULL),(4,'kkk','kkk','aaa','2018-12-24 14:54:02',NULL),(5,'jgk','akfjhajkf','aaa','2018-12-25 10:22:14',NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
