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
  `last_reset_date` date DEFAULT NULL,
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
INSERT INTO `creditcarddb` VALUES ('2395747199482043',1000,'2029-12-01',0,'testando123',NULL),('3121005503293014',1000,'2029-12-03',0,'2222',NULL),('3663060292448814',0,'2029-12-03',0,'davi',NULL),('5110847804126897',1000,'2029-12-03',0,'teste234',NULL),('7030168828506644',0,'2029-12-01',0,'teste123',NULL),('7412954978845896',-900,'2029-12-03',0,'teodoro',NULL),('8191351795435488',1000,'2029-12-03',0,'222',NULL),('9208121440652557',1000,'2029-12-03',0,'1111',NULL);
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
INSERT INTO `invoicedb` VALUES ('202020',1200,'2001-01-01',NULL,'7030168828506644','FECHADA'),('1222',200,'1992-01-01',NULL,'7030168828506644','Nao Pago'),('202020',100,'2201-01-01',NULL,'7030168828506644','FECHADA'),('1111',10011,'1993-01-01',NULL,'7030168828506644','FECHADA'),('1',200,'1992-05-28',NULL,'7030168828506644','FECHADA'),('2',300,'1992-05-28',NULL,'7030168828506644','FECHADA'),('2',300,'1992-05-28',NULL,'7030168828506644','FECHADA'),('5',200,'1111-02-28',NULL,'7030168828506644','FECHADA'),('66',66,'1992-01-01',NULL,'7030168828506644','FECHADA'),('111',1,'1999-01-01',NULL,'5110847804126897','FECHADA'),('1115',15,'1999-01-01',NULL,'5110847804126897','FECHADA'),('11155',155,'1999-01-01',NULL,'5110847804126897','FECHADA'),('100',100,'1992-01-11',NULL,'7030168828506644','FECHADA'),('200',200,'1992-01-11',NULL,'7030168828506644','FECHADA'),('800',100,'1992-01-11',NULL,'7030168828506644','FECHADA'),('2131',100,'1992-01-01',NULL,'7030168828506644','FECHADA'),('1111222',244,'1992-01-01',NULL,'7030168828506644','FECHADA'),('123412124',100,'2001-10-10',NULL,'7030168828506644','FECHADA'),('1000',1000,'1992-01-01',NULL,'3663060292448814','FECHADA'),('10001',1000,'1992-01-01',NULL,'3663060292448814','FECHADA'),('10002222',200,'1999-01-01',NULL,'3663060292448814','ABERTA'),('555',100,'2200-01-27',NULL,'7412954978845896','FECHADA'),('5555',105,'2200-01-27',NULL,'7412954978845896','ABERTA'),('5553',1006,'2200-01-27',NULL,'7412954978845896','ABERTA'),('300',2300,'2001-01-01',NULL,'7030168828506644','ABERTA'),('300',2300,'2001-01-01',NULL,'7030168828506644','ABERTA');
/*!40000 ALTER TABLE `invoicedb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pointsdb`
--

DROP TABLE IF EXISTS `pointsdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pointsdb` (
  `pointsbalance` double NOT NULL,
  `pointsdate` date NOT NULL,
  `useremailfk` varchar(50) DEFAULT NULL,
  `pointsstatus` enum('disponivel','usado') NOT NULL,
  KEY `fk_useremailpoint` (`useremailfk`),
  CONSTRAINT `fk_useremailpoint` FOREIGN KEY (`useremailfk`) REFERENCES `userdb` (`useremail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pointsdb`
--

LOCK TABLES `pointsdb` WRITE;
/*!40000 ALTER TABLE `pointsdb` DISABLE KEYS */;
INSERT INTO `pointsdb` VALUES (100,'2001-01-01','teste123','usado'),(100,'2001-01-01','2222','disponivel'),(10000,'2024-12-03','teste123','usado'),(10000,'2024-12-03','teste123','usado'),(10000,'2024-12-03','davi','usado'),(10000,'2024-12-03','davi','usado'),(10000,'2024-12-03','davi','usado'),(0,'2024-12-03','davi','usado'),(0,'2024-12-03','davi','disponivel'),(1000,'2024-12-03','teodoro','disponivel'),(10000,'2024-12-04','teste123','usado'),(0,'2024-12-04','teste123','disponivel');
/*!40000 ALTER TABLE `pointsdb` ENABLE KEYS */;
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
INSERT INTO `userdb` VALUES ('111','1111','[C@5dbfe692'),('222','222','2222'),('teste123','2222','2222'),('davi','davi','davi'),('arroz','feijao','farinha'),('teodoro','teodoro','teodoro'),('mingas','testando123','fodademais'),('teste123','teste123','teste123'),('teste234','teste234','teste234');
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

-- Dump completed on 2024-12-08 16:06:08
