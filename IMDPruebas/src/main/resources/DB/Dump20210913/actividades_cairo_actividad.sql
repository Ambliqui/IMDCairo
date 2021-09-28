CREATE DATABASE  IF NOT EXISTS `actividades_cairo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `actividades_cairo`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: actividades_cairo
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `id_actividad` int NOT NULL AUTO_INCREMENT COMMENT 'fk_actividad_entrenador',
  `nombre_actividad` varchar(45) DEFAULT NULL,
  `precio_actividad` double DEFAULT NULL,
  `lugar_actividad` varchar(45) DEFAULT NULL,
  `id_entrenador_actividad` int NOT NULL,
  `descripcion_actividad` varchar(10000) DEFAULT NULL,
  `calendario_actividad` varchar(45) DEFAULT NULL,
  `hora_comienzo_actividad` time DEFAULT NULL,
  `hora_fin_actividad` time DEFAULT NULL,
  PRIMARY KEY (`id_actividad`),
  KEY `fk_actividad_entrenador_idx` (`id_entrenador_actividad`),
  CONSTRAINT `fk_actividad_entrenador` FOREIGN KEY (`id_entrenador_actividad`) REFERENCES `entrenador` (`id_entrenador`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (13,'Baloncesto',15,'Mairena',4,'Concentrate en pasar la pelota por el aro, como en la vida real','L,X,V','17:00:00','16:00:00'),(14,'Tenis',10,'Tiro de linea',5,'Hoy por hoy todo el mundo se cree que puede ser Rafa Nadal','M,J','18:00:00','19:00:00'),(15,'Atletismo',5,'Estadio olimpico',4,'Lo mejor si te queires presentar a unas olimpiadas','J,S','20:00:00','21:00:00');
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-13  1:44:25
