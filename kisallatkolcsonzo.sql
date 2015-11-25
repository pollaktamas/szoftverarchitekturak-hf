-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: kisallatkolcsonzo
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `species` varchar(45) DEFAULT 'N/A',
  `breed` varchar(45) DEFAULT 'N/A',
  `sex` varchar(20) DEFAULT 'N/A',
  `age` int(11) DEFAULT NULL,
  `color` varchar(20) DEFAULT 'N/A',
  `volume` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `favourite_meal` varchar(45) DEFAULT 'N/A',
  `hobby` varchar(45) DEFAULT 'N/A',
  `is_available` varchar(1) DEFAULT NULL,
  `is_broken` varchar(1) DEFAULT NULL,
  `picture` varchar(90) DEFAULT 'N/A',
  `owner` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_owner_userid_idx` (`owner`),
  CONSTRAINT `fk_owner_userid` FOREIGN KEY (`owner`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'elephant','african elephant','male',5,'grey',100,3000,'ice-cream','sleeping','N','N','elephant.jpg',4),(2,'tiger','siberian tiger','male',6,'orange',30,400,'meat','running','N','N','tiger.jpg',2),(3,'bear','grizzly bear','female',10,'black',40,500,'chocolate ice cake','lot of video games','N','N','bear.jpg',9),(8,'dog','dog','male',1,'1',1,1,'1','1','Y','N','dog.jpg',NULL);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `is_admin` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','Y'),(2,'aladar','aladar1','N'),(3,'bela','bela123','N'),(4,'Jani','12345','N'),(5,'Laci','laci','N'),(6,'vki','valaki','N'),(7,'zoltan','zoltan1','N'),(8,'zoltan2','zoltan','N'),(9,'zoltan3','zoltan','N');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-25 20:53:07
