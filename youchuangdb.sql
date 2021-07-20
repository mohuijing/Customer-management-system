-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: youchuangdb
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint unsigned DEFAULT NULL COMMENT '角色id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '加密盐',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_account_id` bigint unsigned DEFAULT NULL COMMENT '创建人',
  `modified_account_id` bigint unsigned DEFAULT NULL COMMENT '修改人',
  `deleted` tinyint unsigned DEFAULT '0' COMMENT '逻辑删除标识(0、否 1、是)',
  PRIMARY KEY (`account_id`) USING BTREE,
  KEY `FK_account_role_id` (`role_id`),
  CONSTRAINT `FK_account_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账号表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1,'admin','17a1640916cfa8356adc4336a72ac75d','ecbe5fac60d1499595fbb98dfa854501','超级管理员','男','daniu@126.com','2020-11-10 13:46:32','2020-11-15 17:09:28',NULL,1,0),(2,2,'客户经理','0f93bf3bc6742828d929fe4a2aa67e0e','e9a9d3a059a84a639cbe79af5628f7c7','马经理','男','mjl@123.com','2021-06-22 21:33:35',NULL,1,NULL,0),(3,3,'产品经理','288a3e5ae6534872548e06619ada9169','c056b7303bcb46f1bbbe4dd291671144','肖经理','男','xjl@123.com','2021-06-22 21:34:34','2021-06-29 10:17:24',1,1,0),(4,3,'产品经理','70222488fd2b928e09eb9b09ede302f5','5523be39cc654df7bb1feba5a6d7b2b5','小星星','男','xxxx@132.com','2021-07-07 01:06:56',NULL,NULL,NULL,1),(5,2,'xss','c3d58e21ea558d35f10d0a93295ff791','1fb87c352f4548fdaa1128bc3fbafa09','小星星','男','xxx@123.com','2021-07-07 01:07:25',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '真实姓名',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `age` tinyint unsigned DEFAULT NULL COMMENT '年龄',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机号码',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_account_id` bigint unsigned DEFAULT NULL COMMENT '创建人',
  `modified_account_id` bigint unsigned DEFAULT NULL COMMENT '修改人',
  `deleted` tinyint unsigned DEFAULT '0' COMMENT '逻辑删除标识(0、否 1、是)',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'派大星','男',30,'paidaxing@123.com','12302183724','菠萝','2021-06-24 20:06:07',NULL,1,NULL,0),(2,'珊珊','女',24,'shanshan@123.com','12301247698','蟹皇堡','2021-06-24 20:07:03',NULL,1,NULL,0),(3,'珊迪','女',26,'shandi@123.com','15563098457','松树','2021-06-24 20:07:43',NULL,1,NULL,0),(4,'米奇','男',20,'miqi@123.com','12084972619','米奇妙妙屋','2021-06-28 23:54:12',NULL,1,NULL,0),(5,'米妮','女',19,'mini@123.com','19889786754','米奇妙妙屋','2021-06-28 23:57:04',NULL,1,NULL,0),(6,'皮特','男',30,'pite@123.com','18976543234','米奇妙妙屋','2021-06-29 00:07:15',NULL,1,NULL,0),(7,'奇奇','男',28,'qingqing@123.com','13890143321','米奇妙妙屋','2021-06-29 00:08:20',NULL,1,NULL,0),(8,'蒂蒂','女',25,'didi@123.com','13578987654','米奇妙妙屋','2021-06-29 00:12:43',NULL,1,NULL,0),(9,'黛丝','女',23,'daisi@123.com','19808765427','米奇妙妙屋','2021-06-29 00:22:41',NULL,1,NULL,0),(10,'高飞','男',27,'gaofei@123.com','19098654321','米奇妙妙屋','2021-06-29 00:23:29',NULL,1,NULL,0),(11,'星黛露','女',25,'xingdailu@123.com','16209876432','百老汇','2021-06-29 00:26:16',NULL,1,NULL,0),(12,'达菲','男',22,'dafei@123.com','19078765434','迪士尼','2021-06-29 00:28:44',NULL,1,NULL,0),(13,'雪莉枚','女',21,'xuelim@123.com','16779093082','迪士尼','2021-06-29 00:30:45',NULL,1,NULL,0),(14,'爱洛','女',28,'ailuo@123.com','12309876543','迪士尼','2021-06-29 00:33:03',NULL,1,NULL,0),(15,'艾莉儿','女',26,'ailier@123.com','18038736478','迪士尼','2021-06-29 00:34:51','2021-06-29 00:36:37',1,1,0),(16,'蒂安娜','女',26,'dianna@123.com','19087263521','迪士尼','2021-06-29 00:36:24',NULL,1,NULL,0),(17,'唐纳德','男',29,'tangnade@123.com','18909398462','迪士尼','2021-06-29 00:39:03',NULL,1,NULL,0),(18,'史迪奇','男',26,'shidiqi@123.com','19203897265','迪士尼','2021-06-29 00:40:11',NULL,1,NULL,0),(19,'胡迪','男',33,'hudi@123.com','10219382754','迪士尼','2021-06-29 00:41:01',NULL,1,NULL,0),(20,'黛西','女',28,'daixi@123.com','13212987656','意大利','2021-06-29 00:41:32',NULL,1,NULL,0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `resource_id` bigint unsigned NOT NULL COMMENT '主键',
  `parent_id` bigint unsigned DEFAULT NULL COMMENT '父id',
  `resource_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '资源名称',
  `resource_type` tinyint DEFAULT NULL COMMENT '资源类型(0、目录 1、菜单 2、按钮)',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '请求地址',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限标识码',
  `sort` int unsigned DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,NULL,'系统管理',0,NULL,NULL,1),(2,NULL,'客户管理',0,NULL,NULL,2),(11,1,'角色管理',1,'role/toList',NULL,1),(12,1,'账号管理',1,'account/toList',NULL,2),(21,2,'客户管理',1,'customer/toList','customer',1);
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_account_id` bigint unsigned DEFAULT NULL COMMENT '创建人',
  `modified_account_id` bigint unsigned DEFAULT NULL COMMENT '修改人',
  `deleted` tinyint unsigned DEFAULT '0' COMMENT '逻辑删除标识(0、否 1、是)',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'超级管理员','超级管理员',NULL,NULL,NULL,NULL,0),(2,'客户经理','客户经理','2021-06-22 21:26:22',NULL,1,NULL,0),(3,'产品经理','产品经理','2021-06-22 21:32:05',NULL,1,NULL,0),(4,'普通管理员','普通','2021-06-29 10:15:56','2021-06-29 10:16:22',1,1,1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_resource`
--

DROP TABLE IF EXISTS `role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_resource` (
  `role_resource_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint unsigned DEFAULT NULL COMMENT '角色id',
  `resource_id` bigint unsigned DEFAULT NULL COMMENT '资源id',
  PRIMARY KEY (`role_resource_id`) USING BTREE,
  KEY `FK_role_resource_role_id` (`role_id`),
  KEY `FK_role_rerce_resourc_idD2D9` (`resource_id`),
  CONSTRAINT `FK_role_rerce_resourc_idD2D9` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`resource_id`),
  CONSTRAINT `FK_role_resource_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_resource`
--

LOCK TABLES `role_resource` WRITE;
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
INSERT INTO `role_resource` VALUES (1,1,1),(2,1,2),(3,1,11),(4,1,12),(5,1,21),(6,2,1),(7,2,12),(8,2,2),(9,2,21),(10,3,1),(11,3,12),(12,3,2),(13,3,21),(18,4,1),(19,4,11),(20,4,12),(21,4,2),(22,4,21);
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 17:21:29
