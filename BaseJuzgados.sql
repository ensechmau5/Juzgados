-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: juzgados
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `tinfexpediente`
--

DROP TABLE IF EXISTS `tinfexpediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tinfexpediente` (
  `CidExp` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Folio correspondiente del expediente.',
  `CnumExp` int(11) NOT NULL 'Folio correspondiente del expediente.',
  `CfechaExp` varchar(45) NOT NULL COMMENT 'Fecha correspondiente a la creación del expediente',
  `CtipoCaso_idCaso` int(11) NOT NULL COMMENT 'Clave que nos identifica qué tipo de caso se trata en el expediente, enlazada con la tabla tipoCaso.',
  `CestadoExp` varchar(45) NOT NULL,
  PRIMARY KEY (`CidExp`),
  KEY `fk_infExpediente_tipoCaso1_idx` (`CtipoCaso_idCaso`),
  CONSTRAINT `fk_infExpediente_tipoCaso1` FOREIGN KEY (`CtipoCaso_idCaso`) REFERENCES `ttipocaso` (`CidCaso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabla donde muetra la información necesaria de cada expediente.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tinfexpediente`
--

LOCK TABLES `tinfexpediente` WRITE;
/*!40000 ALTER TABLE `tinfexpediente` DISABLE KEYS */;
INSERT INTO `tinfexpediente` VALUES (1,'04/06/2018',1,'Almacen');
/*!40000 ALTER TABLE `tinfexpediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttipocaso`
--

DROP TABLE IF EXISTS `ttipocaso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ttipocaso` (
  `CidCaso` int(11) NOT NULL COMMENT 'Clave que identifica al caso.',
  `CtipoCaso` varchar(45) NOT NULL COMMENT 'Nombre del tipo de caso.',
  PRIMARY KEY (`CidCaso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla donde se registran los tipos de casos que se pueden tratar en el juzgado.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttipocaso`
--

LOCK TABLES `ttipocaso` WRITE;
/*!40000 ALTER TABLE `ttipocaso` DISABLE KEYS */;
INSERT INTO `ttipocaso` VALUES (1,'Divorcio'),(2,'Custodia'),(3,'Alimentos');
/*!40000 ALTER TABLE `ttipocaso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tusuariosistema`
--

DROP TABLE IF EXISTS `tusuariosistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tusuariosistema` (
  `CidUsuSist` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Clave identificadora del usuario del sistema.',
  `CnomUsuSist` varchar(45) NOT NULL COMMENT 'Nombre del usuario del sistema.',
  `CcontraseñaUsuSist` varchar(45) NOT NULL COMMENT 'Contraseña del usuario del sistema.',
  PRIMARY KEY (`CidUsuSist`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Tabla para almacenar las cuentas de usuario que tiene acceso al sistema.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tusuariosistema`
--

LOCK TABLES `tusuariosistema` WRITE;
/*!40000 ALTER TABLE `tusuariosistema` DISABLE KEYS */;
INSERT INTO `tusuariosistema` VALUES (1,'Juanda','123');
/*!40000 ALTER TABLE `tusuariosistema` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-04 14:54:50
