/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.50 : Database - swim
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`swim` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `swim`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `photo` varchar(40) DEFAULT NULL,
  `subject` varchar(20) DEFAULT NULL COMMENT '培训课程',
  `description` varchar(100) DEFAULT NULL COMMENT '简介',
  `type` tinyint(4) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`sex`,`password`,`photo`,`subject`,`description`,`type`) values (1,'admin',NULL,'admin',NULL,NULL,NULL,NULL),(2,'test0','女','test0',NULL,'少儿私教课程',NULL,0),(3,'test1','女','test1',NULL,NULL,'aaa',1),(4,'test2','男','test2',NULL,'冠军私教课程',NULL,0),(5,'test3','女','test3',NULL,NULL,NULL,0),(6,'test4','男','test4',NULL,NULL,NULL,0),(7,'test5','女','test5',NULL,NULL,NULL,1),(8,'test6','男','test6',NULL,NULL,NULL,0),(9,'test7','女','test7',NULL,NULL,NULL,1),(10,'test8','男','test8',NULL,NULL,NULL,1),(11,'test9','男','test9',NULL,NULL,NULL,1),(12,'test10','男','test10',NULL,NULL,NULL,0),(13,'test11','女','test11',NULL,NULL,NULL,0),(14,'test12','女','test12',NULL,NULL,NULL,1),(15,'test13','女','test13',NULL,NULL,NULL,1),(16,'test14','男','test14',NULL,NULL,NULL,0),(17,'test15','女','test15',NULL,NULL,NULL,1),(18,'test16','女','test16',NULL,NULL,NULL,1),(19,'test17','男','test17',NULL,NULL,NULL,0),(20,'test18','男','test18',NULL,NULL,NULL,0),(21,'test19','男','test19',NULL,NULL,NULL,0),(22,'aaaaa',NULL,'aaaaaaaa','ca97711e-cb34-40f4-a4ba-4167e34bc8a9.jpg',NULL,'aaaaaaaaa',1),(23,'aaaaaa',NULL,'aaaaaaa','5d16a19a-7ce8-4767-9d7a-3b9ae96942d5.jpg',NULL,'aaaaaaaaaaa',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
