/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.5-10.6.5-MariaDB-1:10.6.5+maria~focal : Database - bangbangla
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bangbangla` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bangbangla`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `admins` */

insert  into `admins`(`id`,`user_name`,`password`,`salt`) values (1,'sallee','a4579eb20bd7f14f6bf3a1015121974b1f1a1b5566a267a9de729d242a69b18a','uBiBZyeE');

/*Table structure for table `ban_list` */

DROP TABLE IF EXISTS `ban_list`;

CREATE TABLE `ban_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ban_id` int(11) NOT NULL,
  `ban_type` int(11) NOT NULL,
  `result` varchar(300) NOT NULL,
  `op_id` int(11) NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=874328068 DEFAULT CHARSET=utf8mb4;

/*Data for the table `ban_list` */

insert  into `ban_list`(`id`,`ban_id`,`ban_type`,`result`,`op_id`,`start_time`,`end_time`) values (874328066,1,0,'没事，就是封着玩而已',1,'2022-07-08 04:54:05','2022-07-11 04:54:05'),(874328067,2,0,'没事，就是封着玩而已',1,'2022-07-08 04:54:10','2022-07-11 04:54:10');

/*Table structure for table `chat_list` */

DROP TABLE IF EXISTS `chat_list`;

CREATE TABLE `chat_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `send_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `data` varchar(1000) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `chat_list` */

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `finish_time` timestamp NULL DEFAULT NULL,
  `deal_time` timestamp NULL DEFAULT NULL,
  `state` int(11) NOT NULL,
  `pay_state` int(11) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `introduce` varchar(3000) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `image_paths` varchar(1000) DEFAULT NULL,
  `main_label` int(20) NOT NULL,
  `sub_label` varchar(200) DEFAULT NULL,
  `want_count` int(11) NOT NULL,
  `view_count` int(11) NOT NULL,
  `commit` varchar(300) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `items` */

insert  into `items`(`id`,`seller_id`,`buyer_id`,`create_time`,`finish_time`,`deal_time`,`state`,`pay_state`,`title`,`introduce`,`price`,`image_paths`,`main_label`,`sub_label`,`want_count`,`view_count`,`commit`,`credit`) values (1,1,NULL,'2022-07-08 02:01:58',NULL,NULL,2,NULL,'aaa',NULL,1000,NULL,0,NULL,10,200,NULL,NULL),(2,2,NULL,'2022-07-07 19:07:36',NULL,NULL,0,NULL,'ddd',NULL,200,NULL,0,NULL,30,50,NULL,NULL);

/*Table structure for table `items_history` */

DROP TABLE IF EXISTS `items_history`;

CREATE TABLE `items_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deal_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `finish_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `state` int(11) DEFAULT NULL,
  `pay_state` int(11) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `introduce` varchar(3000) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `image_paths` varchar(1000) DEFAULT NULL,
  `main_label` varchar(20) NOT NULL,
  `sub_label` varchar(200) DEFAULT NULL,
  `commit` varchar(300) DEFAULT NULL,
  `credit` int(11) NOT NULL DEFAULT 5,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `items_history` */

insert  into `items_history`(`id`,`seller_id`,`buyer_id`,`create_time`,`deal_time`,`finish_time`,`state`,`pay_state`,`title`,`introduce`,`price`,`image_paths`,`main_label`,`sub_label`,`commit`,`credit`) values (3,1,3,'2022-07-07 19:04:23','2022-07-01 00:00:00','2022-07-02 00:00:00',3,1,'3ds',NULL,100,NULL,'0',NULL,NULL,5),(4,3,2,'2022-07-07 19:04:33','2022-07-01 00:00:00','2022-07-03 00:00:00',3,0,'声',NULL,200,NULL,'0',NULL,NULL,5);

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `order` */

/*Table structure for table `order_history` */

DROP TABLE IF EXISTS `order_history`;

CREATE TABLE `order_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `order_history` */

/*Table structure for table `report_list` */

DROP TABLE IF EXISTS `report_list`;

CREATE TABLE `report_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_id` int(11) NOT NULL,
  `be_report_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `report_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `result` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `report_list` */

insert  into `report_list`(`id`,`report_id`,`be_report_id`,`item_id`,`report_time`,`result`) values (1,1,2,1,'2022-07-08 04:42:42','弄坏了天空之琴');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `register_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `unban_time` timestamp NULL DEFAULT NULL,
  `sex` int(10) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `introduction` varchar(256) DEFAULT NULL,
  `real_name` varchar(50) NOT NULL,
  `id_card` char(18) NOT NULL,
  `real_tel` varchar(20) NOT NULL,
  `university_pos` varchar(45) NOT NULL,
  `university_name` varchar(45) NOT NULL,
  `student_id` varchar(45) NOT NULL,
  `score` int(10) unsigned NOT NULL DEFAULT 0,
  `total_credit` int(10) unsigned NOT NULL DEFAULT 0,
  `credit_count` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`id`,`user_name`,`password`,`salt`,`register_time`,`unban_time`,`sex`,`nick_name`,`introduction`,`real_name`,`id_card`,`real_tel`,`university_pos`,`university_name`,`student_id`,`score`,`total_credit`,`credit_count`) values (1,'babara_0506','bababa','000000000','2022-07-07 17:59:30','2022-07-11 04:54:05',1,'老八',NULL,'芭芭拉','11511','1513156','蒙德城','西风学院','1213111',0,0,0),(2,'aaa001','aaa','0000','2022-07-07 18:02:14','2022-07-11 04:54:10',1,'张三',NULL,'诺艾尔','151631','1315131','蒙德城','西风学院','1315431',0,0,0),(3,'12115','ddd','0000','2022-07-07 18:02:25',NULL,0,'王五',NULL,'温迪','12131','131316','蒙德城','西风学院','12153166',0,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
