CREATE DATABASE  IF NOT EXISTS `rogercard` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rogercard`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rogercard
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `creditcarddb`
--

DROP TABLE IF EXISTS `creditcarddb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcarddb` (
  `creditcardnumber` varchar(50) NOT NULL,
  `creditcardlimit` double DEFAULT NULL,
  `creditcardduedate` date DEFAULT NULL,
  `creditcardinvoicevalue` double DEFAULT NULL,
  `useremailfk` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`creditcardnumber`),
  KEY `fk_useremail` (`useremailfk`),
  CONSTRAINT `fk_useremail` FOREIGN KEY (`useremailfk`) REFERENCES `userdb` (`useremail`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcarddb`
--

LOCK TABLES `creditcarddb` WRITE;
/*!40000 ALTER TABLE `creditcarddb` DISABLE KEYS */;
INSERT INTO `creditcarddb` VALUES ('2395747199482043',1000,'2029-12-01',0,'testando123'),('7030168828506644',1000,'2029-12-01',0,'teste123');
/*!40000 ALTER TABLE `creditcarddb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoicedb`
--

DROP TABLE IF EXISTS `invoicedb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoicedb` (
  `invoicenumber` varchar(50) DEFAULT NULL,
  `invoicevalue` double DEFAULT NULL,
  `invoiceduedate` date DEFAULT NULL,
  `invoicepayment` date DEFAULT NULL,
  `creditnumberfk` varchar(50) DEFAULT NULL,
  `invoicestatus` varchar(20) DEFAULT NULL,
  KEY `fk_creditnumber` (`creditnumberfk`),
  CONSTRAINT `fk_creditnumber` FOREIGN KEY (`creditnumberfk`) REFERENCES `creditcarddb` (`creditcardnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoicedb`
--

LOCK TABLES `invoicedb` WRITE;
/*!40000 ALTER TABLE `invoicedb` DISABLE KEYS */;
INSERT INTO `invoicedb` VALUES ('202020',1200,'2001-01-01',NULL,'7030168828506644',NULL),('1222',200,'1992-01-01',NULL,'7030168828506644','Nao Pago'),('202020',100,'2201-01-01',NULL,'7030168828506644','ABERTA'),('1111',10011,'1993-01-01',NULL,'7030168828506644','ABERTA');
/*!40000 ALTER TABLE `invoicedb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdb`
--

DROP TABLE IF EXISTS `userdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdb` (
  `username` varchar(50) DEFAULT NULL,
  `useremail` varchar(50) NOT NULL,
  `userpassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`useremail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdb`
--

LOCK TABLES `userdb` WRITE;
/*!40000 ALTER TABLE `userdb` DISABLE KEYS */;
INSERT INTO `userdb` VALUES ('arroz','feijao','farinha'),('mingas','testando123','fodademais'),('teste123','teste123','teste123');
/*!40000 ALTER TABLE `userdb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-01 19:13:16
