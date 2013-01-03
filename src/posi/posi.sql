-- MySQL dump 10.13  Distrib 5.5.25a, for Win32 (x86)
--
-- Host: localhost    Database: posi
-- ------------------------------------------------------
-- Server version	6.0.0-alpha-community-nt-debug

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
-- Table structure for table `audit_trails`
--

DROP TABLE IF EXISTS `audit_trails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit_trails` (
  `audit_trail_id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_trail_user_id` int(11) NOT NULL,
  `audit_trail_time_in` varchar(254) DEFAULT NULL,
  `audit_trail_time_out` varchar(254) DEFAULT NULL,
  `audit_trail_action` varchar(254) DEFAULT NULL,
  `audit_trail_sql` text,
  PRIMARY KEY (`audit_trail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit_trails`
--

LOCK TABLES `audit_trails` WRITE;
/*!40000 ALTER TABLE `audit_trails` DISABLE KEYS */;
INSERT INTO `audit_trails` VALUES (1,1,'2013:01:02 20:08:37','2013:01:02 20:08:37','LOGIN',''),(2,1,'2013:01:02 20:09:49','2013:01:02 20:09:49','LOGIN',''),(3,1,'2013:01:02 20:10:09','2013:01:02 20:10:09','LOGIN',''),(4,1,'2013:01:02 20:10:39','2013:01:02 20:10:39','LOGIN',''),(5,1,'2013:01:02 20:10:45','2013:01:02 20:10:45','LOGIN',''),(6,1,'2013:01:02 20:17:36','2013:01:02 20:17:36','LOGIN',''),(7,1,'2013:01:02 20:17:43','2013:01:02 20:17:43','LOGIN',''),(8,1,'2013:01:02 20:18:57','2013:01:02 20:18:57','LOGIN',''),(9,1,'2013:01:02 20:19:04','2013:01:02 20:19:04','LOGIN',''),(10,1,'2013:01:02 20:19:43','2013:01:02 20:19:43','LOGIN',''),(11,1,'2013:01:02 20:19:48','2013:01:02 20:19:48','LOGIN',''),(12,1,'2013:01:02 20:20:44','2013:01:02 20:20:44','LOGIN',''),(13,1,'2013:01:02 20:20:54','2013:01:02 20:20:54','LOGIN',''),(14,1,'2013:01:02 20:24:30','2013:01:02 20:24:30','LOGIN',''),(15,1,'2013:01:03 00:31:23','2013:01:03 00:31:23','LOGIN',''),(16,1,'2013:01:03 00:32:16','2013:01:03 00:32:16','LOGIN',''),(17,1,'2013:01:03 00:43:37','2013:01:03 00:43:37','LOGIN',''),(18,1,'2013:01:03 00:47:14','2013:01:03 00:47:14','LOGIN',''),(19,1,'2013:01:03 00:51:20','2013:01:03 00:51:20','LOGIN',''),(20,1,'2013:01:03 00:51:57','2013:01:03 00:51:57','LOGIN',''),(21,1,'2013:01:03 00:52:58','2013:01:03 00:52:58','LOGIN',''),(22,1,'2013:01:03 00:54:17','2013:01:03 00:54:17','LOGIN',''),(23,1,'2013:01:03 00:56:38','2013:01:03 00:56:38','LOGIN',''),(24,1,'2013:01:03 00:57:44','2013:01:03 00:57:44','LOGIN',''),(25,1,'2013:01:03 01:10:13','2013:01:03 01:10:13','LOGIN',''),(26,1,'2013:01:03 01:12:35','2013:01:03 01:12:35','LOGIN',''),(27,1,'2013:01:03 01:14:07','2013:01:03 01:14:07','LOGIN',''),(28,1,'2013:01:03 01:14:47','2013:01:03 01:14:47','LOGIN',''),(29,1,'2013:01:03 01:16:15','2013:01:03 01:16:15','LOGIN',''),(30,1,'2013:01:03 01:20:48','2013:01:03 01:20:48','LOGIN',''),(31,1,'2013:01:03 01:20:55','2013:01:03 01:20:55','LOGIN',''),(32,1,'2013:01:03 01:21:03','2013:01:03 01:21:03','LOGIN',''),(33,2,'2013:01:03 01:21:15','2013:01:03 01:21:15','LOGIN',''),(34,1,'2013:01:03 07:54:58','2013:01:03 07:54:58','LOGIN',''),(35,1,'2013:01:03 08:18:43','2013:01:03 08:18:43','LOGIN',''),(36,1,'2013:01:03 08:20:15','2013:01:03 08:20:15','LOGIN',''),(37,1,'2013:01:03 08:22:03','2013:01:03 08:22:03','LOGIN',''),(38,1,'2013:01:03 08:25:31','2013:01:03 08:25:31','LOGIN',''),(39,1,'2013:01:03 08:26:43','2013:01:03 08:26:43','LOGIN',''),(40,1,'2013:01:03 08:35:05','2013:01:03 08:35:05','LOGIN',''),(41,1,'2013:01:03 08:38:03','2013:01:03 08:38:03','LOGIN',''),(42,1,'2013:01:03 08:39:01','2013:01:03 08:39:01','LOGIN',''),(43,1,'2013:01:03 08:39:37','2013:01:03 08:39:37','LOGIN',''),(44,1,'2013:01:03 08:45:56','2013:01:03 08:45:56','LOGIN',''),(45,1,'2013:01:03 08:52:59','2013:01:03 08:52:59','LOGIN',''),(46,1,'2013:01:03 08:55:47','2013:01:03 08:55:47','LOGIN',''),(47,1,'2013:01:03 09:00:07','2013:01:03 09:00:07','LOGIN',''),(48,1,'2013:01:03 09:54:43','2013:01:03 09:54:43','LOGIN',''),(49,1,'2013:01:03 09:55:08','2013:01:03 09:55:08','LOGIN',''),(50,1,'2013:01:03 09:55:27','2013:01:03 09:55:27','LOGIN',''),(51,1,'2013:01:03 09:56:55','2013:01:03 09:56:55','LOGIN','');
/*!40000 ALTER TABLE `audit_trails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_preference`
--

DROP TABLE IF EXISTS `customer_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_preference` (
  `preference_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `preference_item_id` int(11) NOT NULL,
  `preference_item_qty` int(15) NOT NULL,
  `preference_item_price` double NOT NULL,
  PRIMARY KEY (`preference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_preference`
--

LOCK TABLES `customer_preference` WRITE;
/*!40000 ALTER TABLE `customer_preference` DISABLE KEYS */;
INSERT INTO `customer_preference` VALUES (1,1,2,11,100),(2,1,14,10,300),(3,1,16,1,340),(4,1,11,2,20),(5,1,15,1,320);
/*!40000 ALTER TABLE `customer_preference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_status`
--

DROP TABLE IF EXISTS `customer_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_status` (
  `customer_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_status_name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`customer_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_status`
--

LOCK TABLES `customer_status` WRITE;
/*!40000 ALTER TABLE `customer_status` DISABLE KEYS */;
INSERT INTO `customer_status` VALUES (1,'Active');
/*!40000 ALTER TABLE `customer_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_fname` varchar(254) NOT NULL,
  `customer_lname` varchar(254) NOT NULL,
  `customer_idnum` int(15) NOT NULL,
  `customer_passportNum` int(20) NOT NULL,
  `customer_preference_id` int(11) DEFAULT NULL,
  `customer_subscriber_id` int(11) DEFAULT NULL,
  `customer_points` int(11) DEFAULT NULL,
  `customer_addded_date` datetime DEFAULT NULL,
  `customer_updated_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customer_status` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Stanley','Kariuki',27513911,23432,1,1,0,'2012-12-10 10:10:10','2012-12-22 10:02:41',1),(2,'Stan','Njiru',27513911,23432,1,1,0,'2012-12-10 10:10:10','2012-12-22 10:17:03',1);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diminate_details`
--

DROP TABLE IF EXISTS `diminate_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diminate_details` (
  `diminate_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `diminate_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_qty` int(11) DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  `item_bar_code` varchar(254) DEFAULT NULL,
  `item_warehouse_places_id` int(11) DEFAULT NULL,
  `item_status` int(11) NOT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`diminate_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diminate_details`
--

LOCK TABLES `diminate_details` WRITE;
/*!40000 ALTER TABLE `diminate_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `diminate_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diminate_types`
--

DROP TABLE IF EXISTS `diminate_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diminate_types` (
  `diminate_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `diminate_type_name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`diminate_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diminate_types`
--

LOCK TABLES `diminate_types` WRITE;
/*!40000 ALTER TABLE `diminate_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `diminate_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diminates`
--

DROP TABLE IF EXISTS `diminates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diminates` (
  `diminate_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` varchar(254) DEFAULT NULL,
  `diminate_type` int(11) DEFAULT NULL,
  `diminate_description` text,
  `user_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `user_session_id` int(11) DEFAULT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`diminate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diminates`
--

LOCK TABLES `diminates` WRITE;
/*!40000 ALTER TABLE `diminates` DISABLE KEYS */;
/*!40000 ALTER TABLE `diminates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_roles`
--

DROP TABLE IF EXISTS `employee_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_roles` (
  `employee_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_role_name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`employee_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_roles`
--

LOCK TABLES `employee_roles` WRITE;
/*!40000 ALTER TABLE `employee_roles` DISABLE KEYS */;
INSERT INTO `employee_roles` VALUES (1,'Administrator'),(2,'Cashier');
/*!40000 ALTER TABLE `employee_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_fname` varchar(254) DEFAULT NULL,
  `employee_mname` varchar(254) DEFAULT NULL,
  `employee_lname` varchar(254) DEFAULT NULL,
  `employee_dob` date DEFAULT NULL,
  `employee_idnum` int(11) DEFAULT NULL,
  `employee_serial_num` varchar(254) NOT NULL,
  `employee_kra_pin` varchar(254) NOT NULL,
  `employee_nssf_num` varchar(254) DEFAULT NULL,
  `employee_date_enrolled` varchar(254) DEFAULT NULL,
  `employee_rank` varchar(254) DEFAULT NULL,
  `employee_salary` varchar(254) DEFAULT NULL,
  `employee_password` varchar(254) DEFAULT NULL,
  `employee_role_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'stanley','Njiru','Kariuki','2012-12-12',27513911,'1233334','232','4232','2012-12-12','1','20000','stan',1),(2,'Lisa','William','Lobulu','1993-10-18',21345,'45654','343','23543','2012-12-20','2','250000','lisa',1),(3,'Wambui','Ole Ole','Kariuki','1982-12-31',234543,'23456','23456','3456','2012-12-12','1','10000','stanley',0);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_conversions`
--

DROP TABLE IF EXISTS `item_conversions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_conversions` (
  `item_conversion_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_conversion_name` varchar(254) DEFAULT NULL,
  `item_conversion_qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_conversion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_conversions`
--

LOCK TABLES `item_conversions` WRITE;
/*!40000 ALTER TABLE `item_conversions` DISABLE KEYS */;
INSERT INTO `item_conversions` VALUES (1,'Dozen',12),(2,'Pkt',6);
/*!40000 ALTER TABLE `item_conversions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_manuf_goods_types`
--

DROP TABLE IF EXISTS `item_manuf_goods_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_manuf_goods_types` (
  `item_manuf_goods_types` int(11) NOT NULL AUTO_INCREMENT,
  `item_manuf_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`item_manuf_goods_types`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_manuf_goods_types`
--

LOCK TABLES `item_manuf_goods_types` WRITE;
/*!40000 ALTER TABLE `item_manuf_goods_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_manuf_goods_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_manufacturer`
--

DROP TABLE IF EXISTS `item_manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_manufacturer` (
  `item_manuf_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_manuf_name` varchar(254) DEFAULT NULL,
  `item_manuf_location` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`item_manuf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_manufacturer`
--

LOCK TABLES `item_manufacturer` WRITE;
/*!40000 ALTER TABLE `item_manufacturer` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_quality`
--

DROP TABLE IF EXISTS `item_quality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_quality` (
  `item_quality_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_quality_value` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`item_quality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_quality`
--

LOCK TABLES `item_quality` WRITE;
/*!40000 ALTER TABLE `item_quality` DISABLE KEYS */;
INSERT INTO `item_quality` VALUES (1,'Good'),(2,'Worn out'),(3,'Expired');
/*!40000 ALTER TABLE `item_quality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_status`
--

DROP TABLE IF EXISTS `item_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_status` (
  `item_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_status_name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`item_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_status`
--

LOCK TABLES `item_status` WRITE;
/*!40000 ALTER TABLE `item_status` DISABLE KEYS */;
INSERT INTO `item_status` VALUES (1,'Active'),(2,'Inactive');
/*!40000 ALTER TABLE `item_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_supp_goods_types`
--

DROP TABLE IF EXISTS `item_supp_goods_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_supp_goods_types` (
  `item_supp_goods_types` int(11) NOT NULL AUTO_INCREMENT,
  `item_supp_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`item_supp_goods_types`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_supp_goods_types`
--

LOCK TABLES `item_supp_goods_types` WRITE;
/*!40000 ALTER TABLE `item_supp_goods_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_supp_goods_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_supplier`
--

DROP TABLE IF EXISTS `item_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_supplier` (
  `item_supp_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_supp_name` varchar(254) DEFAULT NULL,
  `supplier_fax` varchar(254) DEFAULT NULL,
  `supplier_phone_num` int(11) DEFAULT NULL,
  `item_supp_location` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`item_supp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_supplier`
--

LOCK TABLES `item_supplier` WRITE;
/*!40000 ALTER TABLE `item_supplier` DISABLE KEYS */;
INSERT INTO `item_supplier` VALUES (1,'Ngama wholesalers',NULL,NULL,'Nairobi');
/*!40000 ALTER TABLE `item_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_supplier_agent`
--

DROP TABLE IF EXISTS `item_supplier_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_supplier_agent` (
  `item_supplier_agent_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_supplier_id` int(11) NOT NULL,
  `item_supplier_agent_fname` varchar(254) DEFAULT NULL,
  `item_supplier_agent_mname` varchar(254) DEFAULT NULL,
  `item_supplier_agent_lname` varchar(254) DEFAULT NULL,
  `item_supplier_agent_nationalid` int(11) DEFAULT NULL,
  `item_supplier_agent_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`item_supplier_agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_supplier_agent`
--

LOCK TABLES `item_supplier_agent` WRITE;
/*!40000 ALTER TABLE `item_supplier_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_supplier_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(254) DEFAULT NULL,
  `item_description` text,
  `item_default_bar_code` varchar(254) DEFAULT NULL,
  `item_default_loc` varchar(254) DEFAULT NULL,
  `item_default_price` double DEFAULT NULL,
  `item_default_min_price` double DEFAULT '0',
  `item_default_per_disc` int(11) DEFAULT NULL,
  `item_qty` int(11) DEFAULT NULL,
  `item_min_qty` int(11) DEFAULT '0',
  `item_category` int(11) NOT NULL,
  `item_conversion_id` int(11) DEFAULT NULL,
  `item_pic` varchar(254) DEFAULT NULL,
  `item_manuf` int(11) DEFAULT NULL,
  `item_warehouse_location` int(11) DEFAULT NULL,
  `item_weight` varchar(200) DEFAULT NULL,
  `item_quality` int(11) DEFAULT NULL,
  `item_make` varchar(254) DEFAULT NULL,
  `item_color` varchar(254) DEFAULT NULL,
  `item_size` varchar(200) DEFAULT NULL,
  `item_points` int(11) DEFAULT NULL,
  `item_status` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Dewormers Minyoo enda','Minyoo killer','324523','',45,40.5,10,10,0,0,1,NULL,-1,1,'null',0,'Make','null','null',NULL,0,'2012-10-10 00:00:00','2012-11-18 18:30:30'),(2,'Panadol Extra Extra','Headache reliever medicine medication','3432344','',41.08,36.972,10,41,0,0,1,'default.gif',-1,1,'0',1,'','','0',NULL,1,NULL,'2012-11-23 22:55:33'),(3,'Panadol Meno','Headache reliever medicine','343234','',40.9,36.81,10,10,0,1,1,'default.gif',1,1,'',1,'','','',NULL,1,NULL,'2012-11-23 23:01:20'),(4,'Paracetamol Mango flavor mine','Dar mpaka Arusha','45654',NULL,200,180,10,20,0,0,1,NULL,-1,1,'',0,'','','',NULL,1,'2012-11-25 00:00:00','2012-11-25 19:59:22'),(5,'Maziwa mala mala lala','Iko nini kijana, iko maneno','234543',NULL,200,180,10,20,0,0,1,NULL,-1,1,'',0,'','','',NULL,1,'2012-11-25 23:05:43','2012-11-25 20:05:43'),(6,'Another one','Leta maneno hapa','2343',NULL,200,180,10,230,0,0,1,NULL,-1,1,'',0,'','','',NULL,1,'2012-11-25 23:08:35','2012-11-25 20:08:35'),(7,'Kichwa head','Fela kuti nini','243532',NULL,432,388.8,10,122,0,0,1,NULL,-1,1,'',0,'','','',NULL,1,'2012-11-25 23:14:23','2012-11-25 20:14:23'),(8,'Jina langu ni....','haloo','2345',NULL,200,180,10,20,0,0,1,NULL,-1,1,'',0,'','','',NULL,1,'2012-11-25 23:15:34','2012-11-25 20:15:34'),(9,'stan','pata chapaa','567890',NULL,100,90,10,10,0,0,0,NULL,-1,2,'',0,'','','',NULL,0,'2012-11-26 23:29:18','2012-11-26 20:29:18'),(10,'Testing testing','Melembe','2343',NULL,200,180,10,10,0,1,1,NULL,-1,3,'',0,'','','',NULL,1,'2012-11-26 23:31:44','2012-11-26 20:31:44'),(11,'Testing 2','Iko nini','23432',NULL,20,18,10,10,0,0,0,NULL,-1,2,'',0,'','','',NULL,1,'2012-11-26 23:35:55','2012-11-26 20:35:55'),(12,'Testing 3','here there','8790',NULL,102,91.8,10,10,0,1,1,NULL,-1,3,'',1,'','','',NULL,1,'2012-11-26 23:47:19','2012-11-26 20:47:19'),(13,'Kuja hapa hapa','haiya','98789',NULL,200,180,10,10,0,1,1,NULL,0,2,'',1,'','','',NULL,1,'2012-12-01 14:39:00','2012-12-01 11:39:00'),(14,'Hapana sana','Bad boy wewe','2333339',NULL,300,270,10,20,0,1,1,NULL,0,2,'',1,'','','',NULL,1,'2012-12-01 14:43:10','2012-12-01 11:43:10'),(15,'Ras kinyua','Ras','3212',NULL,320,288,10,20,0,1,1,NULL,0,2,'',1,'','','',NULL,1,'2012-12-01 14:45:01','2012-12-01 11:45:01'),(16,'Ya Mwisho','dsrfvc','6767876',NULL,340,306,10,20,0,1,1,NULL,0,3,'',1,'','','',NULL,1,'2012-12-01 14:46:51','2012-12-01 11:46:51');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_categories`
--

DROP TABLE IF EXISTS `items_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items_categories` (
  `item_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_category_name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`item_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_categories`
--

LOCK TABLES `items_categories` WRITE;
/*!40000 ALTER TABLE `items_categories` DISABLE KEYS */;
INSERT INTO `items_categories` VALUES (1,'Vegetables'),(2,'Cereals');
/*!40000 ALTER TABLE `items_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_warehouses`
--

DROP TABLE IF EXISTS `items_warehouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items_warehouses` (
  `items_warehouses_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL,
  `item_min_qty` int(11) DEFAULT NULL,
  `item_qty` int(11) DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  PRIMARY KEY (`items_warehouses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_warehouses`
--

LOCK TABLES `items_warehouses` WRITE;
/*!40000 ALTER TABLE `items_warehouses` DISABLE KEYS */;
/*!40000 ALTER TABLE `items_warehouses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proliferate_details`
--

DROP TABLE IF EXISTS `proliferate_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proliferate_details` (
  `proliferate_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `proliferate_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_qty` int(11) DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  `item_expiry_date` date DEFAULT NULL,
  `item_bar_code` varchar(254) DEFAULT NULL,
  `item_warehouse_places_id` int(11) DEFAULT NULL,
  `item_status` int(11) NOT NULL,
  `description` text,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`proliferate_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proliferate_details`
--

LOCK TABLES `proliferate_details` WRITE;
/*!40000 ALTER TABLE `proliferate_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `proliferate_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proliferate_types`
--

DROP TABLE IF EXISTS `proliferate_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proliferate_types` (
  `proliferate_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `proliferate_type_name` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`proliferate_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proliferate_types`
--

LOCK TABLES `proliferate_types` WRITE;
/*!40000 ALTER TABLE `proliferate_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `proliferate_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proliferates`
--

DROP TABLE IF EXISTS `proliferates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proliferates` (
  `proliferate_id` int(11) NOT NULL AUTO_INCREMENT,
  `proliferate_type` int(11) NOT NULL,
  `proliferate_description` text,
  `reception_user_id` int(11) DEFAULT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`proliferate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proliferates`
--

LOCK TABLES `proliferates` WRITE;
/*!40000 ALTER TABLE `proliferates` DISABLE KEYS */;
/*!40000 ALTER TABLE `proliferates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `sessions_id` int(11) NOT NULL AUTO_INCREMENT,
  `sessions_user_id` int(11) NOT NULL,
  `session_time_in` varchar(254) DEFAULT NULL,
  `session_time_out` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`sessions_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,1,'2013:01:02 20:08:37',''),(2,1,'2013:01:02 20:09:49',''),(3,1,'2013:01:02 20:10:09',''),(4,1,'2013:01:02 20:10:39',''),(5,1,'2013:01:02 20:10:45',''),(6,1,'2013:01:02 20:17:36',''),(7,1,'2013:01:02 20:17:43',''),(8,1,'2013:01:02 20:18:57',''),(9,1,'2013:01:02 20:19:04',''),(10,1,'2013:01:02 20:19:43',''),(11,1,'2013:01:02 20:19:48',''),(12,1,'2013:01:02 20:20:44','2013:01:02 20:20:46'),(13,1,'2013:01:02 20:20:54','2013:01:02 20:20:59'),(14,1,'2013:01:02 20:24:30',''),(15,1,'2013:01:03 00:31:23','2013:01:03 00:33:43'),(16,1,'2013:01:03 00:32:16','2013:01:03 00:33:37'),(17,1,'2013:01:03 00:43:37','2013:01:03 00:53:51'),(18,1,'2013:01:03 00:47:14','2013:01:03 00:53:42'),(19,1,'2013:01:03 00:51:20','2013:01:03 00:53:30'),(20,1,'2013:01:03 00:51:57','2013:01:03 00:53:19'),(21,1,'2013:01:03 00:52:58','2013:01:03 00:53:09'),(22,1,'2013:01:03 00:54:17',''),(23,1,'2013:01:03 00:56:38',''),(24,1,'2013:01:03 00:57:44',''),(25,1,'2013:01:03 01:10:13',''),(26,1,'2013:01:03 01:12:35',''),(27,1,'2013:01:03 01:14:07',''),(28,1,'2013:01:03 01:14:47',''),(29,1,'2013:01:03 01:16:15',''),(30,1,'2013:01:03 01:20:48','2013:01:03 01:20:51'),(31,1,'2013:01:03 01:20:55','2013:01:03 01:20:58'),(32,1,'2013:01:03 01:21:03','2013:01:03 01:21:10'),(33,2,'2013:01:03 01:21:15','2013:01:03 01:22:51'),(34,1,'2013:01:03 07:54:58','2013:01:03 08:28:35'),(35,1,'2013:01:03 08:18:43','2013:01:03 08:28:41'),(36,1,'2013:01:03 08:20:15','2013:01:03 08:28:48'),(37,1,'2013:01:03 08:22:03','2013:01:03 08:28:53'),(38,1,'2013:01:03 08:25:31','2013:01:03 08:29:01'),(39,1,'2013:01:03 08:26:43','2013:01:03 08:29:08'),(40,1,'2013:01:03 08:35:05',''),(41,1,'2013:01:03 08:38:03',''),(42,1,'2013:01:03 08:39:01',''),(43,1,'2013:01:03 08:39:37',''),(44,1,'2013:01:03 08:45:55',''),(45,1,'2013:01:03 08:52:59',''),(46,1,'2013:01:03 08:55:47',''),(47,1,'2013:01:03 09:00:07',''),(48,1,'2013:01:03 09:54:43',''),(49,1,'2013:01:03 09:55:08',''),(50,1,'2013:01:03 09:55:27','2013:01:03 09:55:43'),(51,1,'2013:01:03 09:56:55','');
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_places`
--

DROP TABLE IF EXISTS `warehouse_places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse_places` (
  `warehouse_place_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) NOT NULL,
  `warehouse_place_name` varchar(254) DEFAULT NULL,
  `warehouse_place_loc` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`warehouse_place_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_places`
--

LOCK TABLES `warehouse_places` WRITE;
/*!40000 ALTER TABLE `warehouse_places` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouse_places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_places_default_items`
--

DROP TABLE IF EXISTS `warehouse_places_default_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse_places_default_items` (
  `warehouse_places_default_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_places_id` int(11) NOT NULL,
  `warehouse_places_item_id` int(11) NOT NULL,
  PRIMARY KEY (`warehouse_places_default_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_places_default_items`
--

LOCK TABLES `warehouse_places_default_items` WRITE;
/*!40000 ALTER TABLE `warehouse_places_default_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouse_places_default_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_places_transfers`
--

DROP TABLE IF EXISTS `warehouse_places_transfers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse_places_transfers` (
  `warehouse_places_transfer_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_place` int(11) NOT NULL,
  `to_place` int(11) NOT NULL,
  `trasaction_user` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_qty` int(11) DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  `item_default_bar_code` varchar(254) DEFAULT NULL,
  `item_bar_code` varchar(254) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  `item_status` int(11) NOT NULL,
  `responsible_user` int(11) NOT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`warehouse_places_transfer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_places_transfers`
--

LOCK TABLES `warehouse_places_transfers` WRITE;
/*!40000 ALTER TABLE `warehouse_places_transfers` DISABLE KEYS */;
/*!40000 ALTER TABLE `warehouse_places_transfers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouses`
--

DROP TABLE IF EXISTS `warehouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouses` (
  `warehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_name` varchar(250) DEFAULT NULL,
  `warehouse_location` varchar(200) DEFAULT NULL,
  `warehouse_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`warehouse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouses`
--

LOCK TABLES `warehouses` WRITE;
/*!40000 ALTER TABLE `warehouses` DISABLE KEYS */;
INSERT INTO `warehouses` VALUES (1,'Main','Nairobi','Active'),(2,'Sub Area Njish','Nairobi Area','Active'),(3,'Sub Nai Area Group','Nairobi Area - Industrial area','Active');
/*!40000 ALTER TABLE `warehouses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-03 11:58:47
