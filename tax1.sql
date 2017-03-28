-- MySQL dump 10.13  Distrib 5.7.11, for osx10.9 (x86_64)
--
-- Host: localhost    Database: Tax_learn
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `complain`
--

DROP TABLE IF EXISTS `complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complain` (
  `comp_id` varchar(32) NOT NULL,
  `comp_company` varchar(100) DEFAULT NULL,
  `comp_name` varchar(20) DEFAULT NULL,
  `comp_mobile` varchar(20) DEFAULT NULL,
  `is_NM` tinyint(1) DEFAULT NULL,
  `comp_time` datetime DEFAULT NULL,
  `comp_title` varchar(200) NOT NULL,
  `to_comp_name` varchar(20) DEFAULT NULL,
  `to_comp_dept` varchar(100) DEFAULT NULL,
  `comp_content` text,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complain`
--

LOCK TABLES `complain` WRITE;
/*!40000 ALTER TABLE `complain` DISABLE KEYS */;
INSERT INTO `complain` VALUES ('1','部门A','用户1','12222222222',0,'2016-07-07 00:00:00','标题','管理员','部门A','内容','1'),('2','部门A','用户1','12222222222',1,'2016-07-09 00:00:00','标题2','管理员','部门A','内容','1'),('ff80808156832ff8015683307d310000','部门A','管理员','18363994095',1,'2016-08-13 17:16:48','complainService','test','部门A','<img src=\"http://localhost:8080/Tax_learn/upload/ueditor/image/20160813/1471079803219054880.png\" title=\"1471079803219054880.png\" alt=\"屏幕快照 2016-07-30 上午8.11.29.png\"/><embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>tai shuai le&nbsp;','2'),('ff80808156832ff801568331547f0001','部门A','管理员','18363994095',0,'2016-08-13 17:17:43','投诉','11','部门B','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：<span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉内容：</span></span></span></span></span></span></span></span></span></span>','2'),('ff80808156832ff801568331d5fd0002','部门A','管理员','18363994095',0,'2016-08-13 17:18:17','投诉',NULL,'','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/><span style=\"color: rgb(0, 102, 153); font-family: -webkit-standard; font-size: 12px; text-align: right; background-color: rgb(240, 249, 255);\">投诉</span>','2'),('ff8080815683486201568349b97b0000','部门A','管理员','18363994095',0,'2016-08-13 17:44:22','非匿名','user1','部门A','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>wef','2'),('ff8080815697878a0156978a92d20000','部门A','管理员','18363994095',1,'2016-08-17 16:07:36','2 标题','test','部门A','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>uuuuu','1');
/*!40000 ALTER TABLE `complain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complain_reply`
--

DROP TABLE IF EXISTS `complain_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complain_reply` (
  `reply_id` varchar(32) NOT NULL,
  `comp_id` varchar(32) NOT NULL,
  `replyer` varchar(30) DEFAULT NULL,
  `reply_dept` varchar(100) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `reply_content` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `FK_comp_reply` (`comp_id`),
  CONSTRAINT `FK_comp_reply` FOREIGN KEY (`comp_id`) REFERENCES `complain` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complain_reply`
--

LOCK TABLES `complain_reply` WRITE;
/*!40000 ALTER TABLE `complain_reply` DISABLE KEYS */;
INSERT INTO `complain_reply` VALUES ('ff808081567dfb4d01567dff171e0001','1','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 17:04:45','1'),('ff808081567dfb4d01567dff569b0002','1','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 17:05:01','111'),('ff808081567dfb4d01567e00487e0003','1','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 17:06:03','11'),('ff808081567dfb4d01567e0082ef0004','1','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 17:06:18','11'),('ff808081567e303701567e308ef10000','2','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 17:58:47','1'),('ff808081567e3e9201567e3fcd7a0000','2','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 18:15:10','123'),('ff808081567e5fa201567e9095430000','2','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 19:43:40','1111'),('ff808081567e5fa201567e90be060001','2','#session.SYS_USER.name','#session.SYS_USER.dept','2016-08-12 19:43:50','222222'),('ff808081567e951c01567e9ac3e70000','2','管理员','部门A','2016-08-12 19:54:47','2122121'),('ff808081567e951c01567e9f10260001','2','管理员','部门A','2016-08-12 19:59:29','挂历元'),('ff808081567e951c01567ea581fc0002','1','管理员','部门A','2016-08-12 20:06:31','123'),('ff80808156978d550156978df0540000','ff8080815697878a0156978a92d20000','管理员','部门A','2016-08-17 16:11:17','niubib');
/*!40000 ALTER TABLE `complain_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imonth`
--

DROP TABLE IF EXISTS `imonth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imonth` (
  `month` int(11) NOT NULL,
  PRIMARY KEY (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imonth`
--

LOCK TABLES `imonth` WRITE;
/*!40000 ALTER TABLE `imonth` DISABLE KEYS */;
INSERT INTO `imonth` VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);
/*!40000 ALTER TABLE `imonth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `info` (
  `info_id` varchar(32) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` longtext,
  `memo` varchar(200) DEFAULT NULL,
  `creator` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES ('4028474e566959b701566961ff4f0000','zcsd','1','信息白哦题1','','','管理员','2016-08-08 17:00:32','1'),('4028474e566959b7015669621c5b0001','tzgg','','			strTitle=info.getTitle();','','','管理员','2016-08-08 17:00:48','1'),('4028474e566959b7015669622db40002','tzgg','','12','','','管理员','2016-08-08 17:00:54','1'),('ff808081565a9b7a01565a9c18c10000','tzgg','q3r','3223','<p><embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/><img src=\"http://localhost:8080/Tax_learn/upload/ueditor/image/20160805/1470398983787033404.png\" title=\"1470398983787033404.png\" alt=\"屏幕快照 2016-07-30 上午8.11.29.png\"/></p><p>真帅！！！</p>','','管理员','2016-08-05 20:09:34','1'),('ff808081565efc7501565f261d810004','tzgg','11','信息标题12','<p><embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>11</p>','','管理员','2016-08-06 17:19:00','1'),('ff808081566a3a6a01566a3b0b910000','tzgg','111','1111','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>11','','管理员','2016-08-08 20:57:43','1'),('ff808081566a3e8301566a3ef1160000','tzgg','ceshi','ceshi','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>ceshi','','管理员','2016-08-08 21:01:57','1'),('ff808081566a3e8301566a3f02930001','tzgg','','ceshi','','','管理员','2016-08-08 21:02:07','1'),('ff808081566a3e8301566a3f169a0002','tzgg','','ceshi','','','管理员','2016-08-08 21:02:11','1'),('ff808081566a3e8301566a3f29330003','tzgg','','ceshi','','','管理员','2016-08-08 21:02:16','1'),('ff808081566a3e8301566a3f3dc60004','tzgg','','ceshi','','','管理员','2016-08-08 21:02:22','1'),('ff808081566a3e8301566a3f54b10005','tzgg','','ceshi','','','管理员','2016-08-08 21:02:28','1'),('ff808081566e2e9001566e2f9bef0000','tzgg','','ceshi111','','','管理员','2016-08-09 15:23:43','1'),('ff808081566e2e9001566e2f9c5a0001','tzgg','','ceshi111','','','管理员','2016-08-09 15:23:43','1'),('ff808081566e2e9001566e2fc3bb0002','tzgg','','ceshi222','','','管理员','2016-08-09 15:23:54','1'),('ff808081566e2e9001566e2feef40003','tzgg','','ceshi3333','','','管理员','2016-08-09 15:24:03','1'),('ff808081566e2e9001566e3033d20004','tzgg','','ceshishua','','','管理员','2016-08-09 15:24:15','1'),('ff808081566e2e9001566e30341a0005','tzgg','','ceshishua','','','管理员','2016-08-09 15:24:15','1'),('ff808081566e2e9001566e30855a0006','tzgg','','ceshi123','','','管理员','2016-08-09 15:24:33','1'),('ff808081566e2e9001566e30ab500007','tzgg','','123','','','管理员','2016-08-09 15:24:55','1'),('ff808081566e2e9001566e30c1330008','tzgg','','12','<embed id=\"xunlei_com_thunder_helper_plugin_d462f475-c18e-46be-bd10-327458d045bd\" type=\"application/thunder_download_plugin\" height=\"0\" width=\"0\"/>1231231231231231','','管理员','2016-08-09 15:25:01','1');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('4028474e5601fbdf015601fbe1160000','person1'),('4028474e5602333f0156023340c60000','person2'),('4028474e56025f950156025f96bb0000','test'),('4028474e560263e301560263e4440000','人员1'),('4028474e5602661c015602661e480000','人员1'),('4028474e560266fe0156026700080000','人员1'),('4028474e56026ab90156026abaa10000','人员1'),('4028474e560761ab01560761ad340000','person1');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('8a7c458a56453d800156454318b30000','管理人员','1'),('8a7c458a56453d800156454346ea0001','一般人员','1');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_privilege`
--

DROP TABLE IF EXISTS `role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_privilege` (
  `role_id` varchar(32) NOT NULL,
  `code` varchar(10) NOT NULL,
  PRIMARY KEY (`role_id`,`code`),
  KEY `FK45FBD628926495C0` (`role_id`),
  CONSTRAINT `FK45FBD628926495C0` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_privilege`
--

LOCK TABLES `role_privilege` WRITE;
/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
INSERT INTO `role_privilege` VALUES ('8a7c458a56453d800156454318b30000','hqfw'),('8a7c458a56453d800156454318b30000','nsfw'),('8a7c458a56453d800156454318b30000','spaces'),('8a7c458a56453d800156454318b30000','xzgl'),('8a7c458a56453d800156454318b30000','zxxx'),('8a7c458a56453d800156454346ea0001','spaces');
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `dept` varchar(20) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `headImg` varchar(100) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('8a7c414b5635e5880156360923fd0019','test','部门A','test','123456','','\0','','18363994095','1990-10-10 00:00:00','1',''),('8a7c41c6562b22fa01562b262b8e0000','aa','部门A','123','hj','','\0','gugiku@qq.com','',NULL,'1',''),('8a7c41c6562b318f01562b3239510000','11','部门b','121','121','user/1ef7aa35-8651-4650-9d46-8bde31223575.jpg','','2342@qq.com','12593120412',NULL,'1',''),('8a7c41c6562b33dd01562b34359f0000','234','部门b','234','234',NULL,'','uyfu@fd.yt','',NULL,'1',''),('8a7c41fe56599cdb0156599dab000000','user1','部门A','user1','user','','','234234@wwr.com','2342351941123','2016-08-23 00:00:00','1',''),('ff80808156459bf30156459cf5050000','test11','部门A','test11','213123','','','123@12.csd','',NULL,'1',''),('ff8080815645b25f015645b4eb8d0000','管理员','部门A','root','root','user/48b25f26-5d17-43f1-8b86-281bcd3138c2.png','','root@r.t','18363994095','2016-08-03 00:00:00','1',''),('ff808081566e7ba501566e7c751f0000','e','部门A','e','e',NULL,'\0','','',NULL,'1',''),('ff808081566e7ba501566e7ca74a0001','w','部门A','w','w',NULL,'\0','','',NULL,'1',''),('ff808081566e7ba501566e7cc8690002','q','部门A','q','qq',NULL,'\0','','',NULL,'1',''),('ff808081566e7ba501566e7cf7e00003','q','部门A','r','r',NULL,'\0','','',NULL,'1','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK143BF46A926495C0` (`role_id`),
  CONSTRAINT `FK143BF46A926495C0` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('8a7c458a56453d800156454318b30000','8a7c41fe56599cdb0156599dab000000'),('8a7c458a56453d800156454318b30000','ff80808156459bf30156459cf5050000'),('8a7c458a56453d800156454318b30000','ff8080815645b25f015645b4eb8d0000'),('8a7c458a56453d800156454346ea0001','8a7c414b5635e5880156360923fd0019'),('8a7c458a56453d800156454346ea0001','8a7c41c6562b22fa01562b262b8e0000'),('8a7c458a56453d800156454346ea0001','8a7c41fe56599cdb0156599dab000000'),('8a7c458a56453d800156454346ea0001','ff80808156459bf30156459cf5050000'),('8a7c458a56453d800156454346ea0001','ff8080815645b25f015645b4eb8d0000');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-18 20:25:12
