CREATE DATABASE  IF NOT EXISTS `fog` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fog`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fog
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `width` double DEFAULT NULL,
                          `length` double DEFAULT NULL,
                          `status` enum('pending','confirmed','delivered') NOT NULL,
                          `user_id` int DEFAULT NULL,
                          `timestamp` timestamp NULL DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_orders_users1_idx` (`user_id`),
                          CONSTRAINT `fk_orders_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,500,800,'confirmed',2,'2021-05-05 13:15:55'),(5,2,2,'confirmed',NULL,NULL),(6,3,4,'pending',NULL,NULL),(7,6,6,'confirmed',NULL,NULL),(8,5,5,'confirmed',NULL,NULL),(9,3,4,'confirmed',NULL,NULL),(10,3,4,'pending',NULL,NULL),(11,200,450,'pending',NULL,NULL),(12,600,300,'pending',2,NULL),(13,300,300,'confirmed',2,NULL),(14,280,200,'pending',2,NULL),(15,300,300,'pending',2,NULL),(16,300,300,'pending',2,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partlistitem`
--

DROP TABLE IF EXISTS `partlistitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partlistitem` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `order_id` int DEFAULT NULL,
                                `parts_id` int DEFAULT NULL,
                                `name` varchar(255) DEFAULT NULL,
                                `quantity` int DEFAULT NULL,
                                `length` double DEFAULT NULL,
                                `unit` varchar(10) DEFAULT NULL,
                                `description` varchar(255) DEFAULT NULL,
                                `price` int DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `fk_partlists_parts1_idx` (`parts_id`),
                                KEY `fk_order_id_idx` (`order_id`),
                                CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
                                CONSTRAINT `fk_partlists_parts1` FOREIGN KEY (`parts_id`) REFERENCES `parts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partlistitem`
--

LOCK TABLES `partlistitem` WRITE;
/*!40000 ALTER TABLE `partlistitem` DISABLE KEYS */;
INSERT INTO `partlistitem` VALUES (3,14,1,NULL,NULL,300,NULL,NULL,NULL),(4,14,3,NULL,NULL,280,NULL,NULL,NULL),(5,14,2,NULL,NULL,280,NULL,NULL,NULL),(6,15,1,NULL,NULL,300,NULL,NULL,NULL),(7,15,3,NULL,NULL,300,NULL,NULL,NULL),(8,15,2,NULL,NULL,300,NULL,NULL,NULL),(9,16,1,NULL,NULL,300,NULL,NULL,120),(10,16,3,NULL,NULL,300,NULL,NULL,151),(11,16,2,NULL,NULL,300,NULL,NULL,111);
/*!40000 ALTER TABLE `partlistitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parts`
--

DROP TABLE IF EXISTS `parts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parts` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) DEFAULT NULL,
                         `unit` varchar(10) DEFAULT NULL,
                         `price_per_unit` double DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parts`
--

LOCK TABLES `parts` WRITE;
/*!40000 ALTER TABLE `parts` DISABLE KEYS */;
INSERT INTO `parts` VALUES (1,'25x200	mm.	trykimp. Brædt','stk',100),(2,'25x125 mm. trykimp. Brædt','stk',75),(3,'38x73	mm.	Lægte	ubh.','stk',115),(4,'45x95	mm.	Reglar	ub.','stk',105),(5,'45x95	mm.	Reglar	ub.','stk',100),(6,'45x195	mm.	spærtræ	ubh.','stk',100),(7,'45x195	mm.	spærtræ	ubh.','stk',125),(8,'45x195	mm.	spærtræ	ubh.','stk',145),(9,'97x97	mm.	trykimp.	Stolpe','stk',75),(10,'19x100	mm.	trykimp.	Brædt		','stk',50),(11,'19x100	mm.	trykimp.	Brædt		','stk',30),(12,'19x100	mm.	trykimp.	Brædt		','stk',50),(13,'Plastmo	Ecolite	blåtonet','stk',30),(14,'Plastmo	Ecolite	blåtonet','stk',30),(15,'plastmo	bundskruer	200	stk.','pakke',75),(16,'hulbånd	1x20	mm.	10	mtr.','rulle',50),(17,'universal	190	mm	højre','stk',30),(18,'universal	190	mm	venstre','stk',30),(19,'4,5	x	60	mm.	skruer	200	stk.','pakke',75),(20,'4,0	x	50	mm.	beslagskruer	250	','pakke',55),(21,'bræddebolt	10	x	120	mm.','stk',40),(22,'firkantskiver	40x40x11mm ','stk',20),(23,'4,5	x	70	mm.	Skruer	400	stk.','pakke',7),(24,'4,5	x	50	mm.	Skruer	300	stk.	','pakke',10),(25,'stalddørsgreb	50x75','stk',10),(26,'t	hængsel	390	mm','stk',20),(27,'vinkelbeslag	35','stk',20);
/*!40000 ALTER TABLE `parts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shed`
--

DROP TABLE IF EXISTS `shed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shed` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `length` int DEFAULT NULL,
                        `width` int DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shed`
--

LOCK TABLES `shed` WRITE;
/*!40000 ALTER TABLE `shed` DISABLE KEYS */;
INSERT INTO `shed` VALUES (1,200,200);
/*!40000 ALTER TABLE `shed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `email` varchar(45) NOT NULL,
                         `password` varchar(45) NOT NULL,
                         `role` enum('customer','admin') NOT NULL,
                         `name` varchar(45) DEFAULT NULL,
                         `address` varchar(45) DEFAULT NULL,
                         `postal` int DEFAULT NULL,
                         `city` varchar(45) DEFAULT NULL,
                         `phone` int DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mail@mail.dk','pass123','admin','julius','paltholmpark',3520,'farum',28299825),(2,'test@mail.dk','test123','customer','hans','rababervej',2300,'amager',11223344),(3,'alex@hej.dk','alex','customer',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19 13:56:24
