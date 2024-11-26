CREATE DATABASE  IF NOT EXISTS `rogercard` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rogercard`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rogercard
-- ------------------------------------------------------
-- Server version	8.0.36

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
  `creditcardid` int NOT NULL AUTO_INCREMENT,
  `creditcardnumber` varchar(20) DEFAULT NULL,
  `creditcardlimit` double DEFAULT NULL,
  `creditcardduedate` date DEFAULT NULL,
  `creditcardinvoicevalue` double DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`creditcardid`),
  KEY `fk_user_creditcard` (`userid`),
  CONSTRAINT `fk_user_creditcard` FOREIGN KEY (`userid`) REFERENCES `userdb` (`userID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcarddb`
--

LOCK TABLES `creditcarddb` WRITE;
/*!40000 ALTER TABLE `creditcarddb` DISABLE KEYS */;
INSERT INTO `creditcarddb` VALUES (1,'1713152885361787',500,'2029-11-25',0,6),(3,'5825971313424390',500,'2029-11-25',0,8),(4,'8754913037155915',500,'2029-11-25',0,9);
/*!40000 ALTER TABLE `creditcarddb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faturadb`
--

DROP TABLE IF EXISTS `faturadb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faturadb` (
  `faturacod` varchar(30) DEFAULT NULL,
  `faturavalor` double DEFAULT NULL,
  `creditcardid` int NOT NULL,
  KEY `fk_cartao` (`creditcardid`),
  CONSTRAINT `fk_cartao` FOREIGN KEY (`creditcardid`) REFERENCES `creditcarddb` (`creditcardid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faturadb`
--

LOCK TABLES `faturadb` WRITE;
/*!40000 ALTER TABLE `faturadb` DISABLE KEYS */;
/*!40000 ALTER TABLE `faturadb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdb`
--

DROP TABLE IF EXISTS `userdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdb` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `useremail` varchar(50) DEFAULT NULL,
  `userpassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdb`
--

LOCK TABLES `userdb` WRITE;
/*!40000 ALTER TABLE `userdb` DISABLE KEYS */;
INSERT INTO `userdb` VALUES (1,'Nome: ','Email: ','Senha: '),(2,'GER','GER','GERSS'),(3,'test','test','test'),(4,'henrique','h@gmail.com','123 '),(5,'tttttt','tttttt','tttttttt'),(6,'tytyaysyd','ahsudhaush','asudausidw'),(8,'teste','teste@','111'),(9,'thiago','thiago@ej','thiago123');
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

-- Dump completed on 2024-11-25 19:29:19
