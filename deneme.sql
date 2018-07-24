CREATE DATABASE  IF NOT EXISTS `deneme` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `deneme`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: deneme
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(45) NOT NULL,
  `bankname` varchar(45) NOT NULL,
  `branchcode` varchar(45) NOT NULL,
  `accnumber` varchar(45) NOT NULL,
  `iban` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1852 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (1801,'','enpara','7171','56874547','TR520011100000000061121309'),(1851,'yusuf','enene','18181','21812','3059235');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `message` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1353 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1101,'Yusuf Can','yusufcancelik@hotmail.com','deneme mesajı'),(1252,'Yusuf Can','yusufcancelik@hotmail.com','deneme2'),(1352,'Yusuf Can','yusufcancelik@hotmail.com','deneme3');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit_pricing` int(11) NOT NULL,
  `userr_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricing`
--

DROP TABLE IF EXISTS `pricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pricing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `firsttab` varchar(45) NOT NULL,
  `secondtab` varchar(45) NOT NULL,
  `thirdtab` varchar(45) NOT NULL,
  `fourthtab` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1503 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricing`
--

LOCK TABLES `pricing` WRITE;
/*!40000 ALTER TABLE `pricing` DISABLE KEYS */;
INSERT INTO `pricing` VALUES (1,250,20,'Arama Başına 1 Kredi','Rapor Kaydetme','Toplu Kontrol','Dosyadan Yükleme'),(2,500,20,'Arama Başına 1 Kredi','Rapor Kaydetme','Toplu Kontrol','Dosyadan Yükleme'),(3,750,30,'Arama Başına 1 Kredi','Rapor Kaydetme','Toplu Kontrol','Dosyadan Yükleme'),(951,1000,50,'Deneme','Deneme','Deneme','Deneme'),(1502,1250,100,'Deneme','deneme','dneme','demene');
/*!40000 ALTER TABLE `pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `plagiarism` int(11) NOT NULL,
  `words` int(11) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,'Deneme','Population biology has developed largely as a zoological discipline, and for this reason a book such as this which defines a science appropriate for plants is very welcome. In this comprehensive and well-written book the author has successfully attempted to collate such present knowledge concerning plants as may be relevant to the understanding of their population biology.The first of the 24 chapters provide a brief history of the development of population theory and experimental models, and introduces a diagrammatic model of population behaviour, which thereafter appears throughout the book in slightly modified forms',100,1,'2018-04-19',802),(2,'qwe','qwe',90,2,'2018-04-19',802),(1051,'deneme','Population biology has developed largely as a zoological discipline, and for this reason a book such as this which defines a science appropriate for plants is very welcome. In this comprehensive and well-written book the author has successfully attempted to collate such present knowledge concerning plants as may be relevant to the understanding of their population biology.The first of the 24 chapters provide a brief history of the development of population theory and experimental models, and introduces a diagrammatic model of population behaviour, which thereafter appears throughout the book in slightly modified forms. The remaining chapters are grouped into five sections, the first of which includes a detailed description of seed dispersal, dormancy, the seed bank and the nature of the environmental sieve determining the recruitment of seedling populations. The second and third sections concern the effects of neighbours and predators',4938233,948,'2018-04-23',1),(1151,'denemr',' Population biology has developed largely as a zoological discipline, and for this reason a book such as this which defines a science appropriate for plants is very welcome. In this comprehensive and well-written book the author has successfully attempted to collate such present knowledge concerning plants as may be relevant to the understanding of their population biology.The first of the 24 chapters provide a brief history of the development of population theory and experimental models, and introduces a diagrammatic model of population behaviour, which thereafter appears throughout the book in slightly modified ',100,621,'2018-04-24',1);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `permission` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin',1),(2,'user',0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',1950);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `keywords` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `author` varchar(45) NOT NULL,
  `facebook` varchar(45) NOT NULL,
  `twitter` varchar(45) NOT NULL,
  `googlekey` varchar(255) NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (1,'PlagChecker','deneme,deneme2','deneme3','deneme2','deneme2','deneme2','AIzaSyA_x78ATHfpujhwuAcSlDEB-JiXFp8wIy0','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0�\0\0\0\0\0\0�(\0\0\0sRGB\�\�,\0\0^IDATx�\�	tU\�\�%Ⱦ��T$��D��@\�C\�\�\0*T\�ZP��\�Z=,����5@Y\�n	K�A\�\�!\�%��-�BX����Ȓ\���\��%\��A7k\�w\���7˝;3�wg����<�\0�\�\�CO�ߖ\\�A\�\�k^�hjRB�\�%����ȑhg�*\��x�Y��تuC�o�Z�|\�sd��\��\�]\'�� �v\rh8ŵ�ox�s\��A۶�w��VB\�\�\�Y9�c�LK\�z{E\�_\�v�[\�u�Z	�:�}��A�wT��J˰�O\�]�\�\�Ny��\�\�\�Bz=h5����%\�\�/\��9��B\\�\r&�\�E��\"S����\��!�F��\�`��(�X���\��ǿ�NI�vF���8@O���\�N\�@\n�����[\�:з�A5~��)~C��Ϡ�|\�\�_D���\���\0\�\0��v\��֊\�r\0p/\04\0�\0�\�-�_��7|��\�c\�\�\Z�\�Y�\�/��J�,�~��k\�PO-�&(Z\����7Ѧ��e�0\�\�?��h���8\0\�\0^\0��۽7\0\0\r\0\�\0^��\�i\�\��P\��8ۨ \�0佡�\�\�\rr>��Q\�\�L�\�@�B��\�a\�e�.�;�{C��ʃm\�\�\�\�\�\n\���4\�Of�3tʅjC��\0��p��{��H��\0p\0l\�0��\�v_��BK\�\�?$�&�\�\n�w\��2ưCS,�	���\�s\��\�A\'	\�a(\�f\�~M�j\�)�\�\r�fA\�\�-\�C\�\�\�cЯ\�\�f0�4���\0�����{�v\0\�\0�}`(\�j�E6L:�Ӏ�i\�=f2�R�g��y����Q���Պq����{�q}^ȩY��a�\�iS\�G6\�j��e�,e�g�\�=��[\�t�A��l���\0`�\����P�o`\0�d�\\[�.g�\�zJ�\r�Ǣ\"~�L���s|S\�\��������~��)�\�&2\�\�\�\�e���\�lCK(:nw\�\���A\�\��Pw;e��[�S���3\�5\�&/OYe�\��e�9\0�=�u\0�[`&\0\��E\�b�e\�64�!;\��\�O\�1\�\����arG�K�\��\�e\n_\��¸�\�\�\�\�C]ʹ��kR\�\�hgq\�9�\�$�3��B{�.�U�?\n�\�����K۩\0<\r\0w\0���EQ�Ͷ\�M�f��\��A	�\"���|��۵gxm�-2�`\�Q\� �=�\��IXVӲ(��rd�\�\�3j\�v\�ùF�\�:ݬ��i�y�*Z�?G�$\�\�vt%4A┹x\n\�҆Bi\�n��_P����\�.\�)e.\�\�A�ϻR�>�힧\�R�\�(��\�����\�\0\0x>pJ\�-�eXb�ֳ����?�ݜ�\�X�//H\n\�0\�\�\'��X���˒+��R	\0\Z\00\0���\0`GL�q\��shψ��*�^w��\�\�\�\�\�}y$e\�\�#{��\�\�[��ӷ�͛�=-l\�\���\�\�J�Y���\��޹�\�=\�5�\�*��}�\�p�\��Y[	\�ʃQ\����� #\�f\�9��2W�9�Ƴy\��1�\�i\�>2Z^eY�L�ʴ\0�eOњ\�r�\�!В��iO0^^�X��c��V?��1�;ř��{\�\��ӠQV����\��2e\�t\�u\�\�;Y\�C\�\0�rbX\06���{\0�\0\�\0�\0�\�~ށ���<\0O�\\\0\0\r\08\0@�aF\0�l\0h\0@\0���\0\�\0�I\00\0��{MْV\0f�(\0�%\04\0\�\���\�3H\�ر\�\�\r\�\�G\��^�\�5p|rٻ\\W]\�X_\�US�Ӭ�{յ�����Ua�\"\�\�\�X��2�g�鸷�>e�8�d8�aqd4�������.�2,ef)m\�\r�\�3|ح�]X^\��ŧ�|�\�j���\��\�|\�./k���)s3\�*o3\0\��)��\���\�\r\0X\0�\0\r\0\�\0@\0N��p\0\�@\0o�h\0�	\0g��\0�>\0�\0�\0`i\08\0^r\�-\0\�\0@\0��Yp�U\�\�o�W+�M\Z\Z\Z*\r��0T\�sw�;�%�|��k*jUO�w0n�[~-�0\�5b8�/�T8\�\�[p2��\��/d�Our�[�H�,�^\�#�3�:7P\�hA5��U�\��ː�L\�{	[$�Z�f�Y\�\�(у\�%\0x\n\0�j2-\�\0h\0��\0P�x\0\0}\0`|\0��C\0`e\0��U�i\0	\0�\\\0\�\0��\0�\�\0\�y\0��G\0@\0~\n\0��k\�c�\�c�/�\�jSa\Z-m���������=���\�Y���1=[y�)U�s-z�q�\��)\�ڴ\���-}���|N1ܐakZ}�\�4�[2l��2�׀6ju\�\�o_\�\�NV�G�\�(m�@�Ӯu��^?\�\�s{i��\�T!�S\\�VV\0\�\�)x�\��	\�5\0�\0w\0��\�	\0x�\0\�\�\��[4\0�\�0\�N�t\0��\0f@\0\��e0V\0�{4\0\0`\04\0�\0s\0`�°R����р+�D޵\�u�P�j�\�I��fܛ�[\�V[��yd���̅�u>,{{\�T�\�\'\��kڃ�\��k\�D�:�k\���`��Y\���\�$e.\n$��2]�T\\9�(\�4YԌU\�\�*[\�\�\�_V�\�H/�oC�͢;\�*H{Y\�/\�D%?\0e�cl\0@\0\�\n\0�F���\�M\�1V\��\0~�8	\0n\'��1��\�0\0ʵ\0�#\0L�\�\�j�\�\0\�8\0\0�n�^zO�!1G�1�x<\�k���F3\�AT\�C� ��E\��+\�x<;] �\�\�M��\�\�ɑ\��ߺh��6�K\��aZ�\�E�Z#hu;\�4YP�f^�p�\�?�\�}X����\�%���\�缙\��C�\�\�+_�`�� \���A\0_\�!�|\0]�F�T.Br\�xS�r\0�\0\�@<˯a\�\�>\0�#\0\���9�0\0\Z\0�\n\0�#�CB\Z\Z o��\r�����t��Ne\�r�\����g*s���\�\�0<�v\�;A\�\�j\�ʃ�R\�\'�e\�IC+eN�W\�\�\�ܾ�̰�c2ҕ�P�1,KV\�\�+\�_����J�g\��\�k\�g�\Z0���\n��\�\�5��,n\��\�2�䥓=SYl�\�wJ\0K�(\0x\�h9\0����p\0x\0f�H\0\�\n\0�\0��\0�\0�\0�Z\0�%\0��\�\�[\���\0`&\0�\0��i\0��\0`:\0�\0\�\�<\0���Y���P��\�\�\Zt\�\�\�@\�0]F�{�D_�\�\�U����g;\�\�c\�dT/W\�P����8\�7�-���\�\�qOC{�,\Z�\�)\�/���\�7�},U\\�\�}K��w*�wen\�\�(\�z�\"L�h��\��\�T\'\'	\�q\�\�\�\�k�lS�3�H�R�ܹđЧ�\�\�`\��\\]���n�Zx\�kԔy��+\�f\\Q\�\n�vq\�\�k%��lKX��ҭ�\�\�5�y\�k^�Z\�\�\\�m\�?q7\0\0\0\0IEND�B`�');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `credit_limit` int(11) NOT NULL,
  `isenabled` tinyint(4) NOT NULL,
  `temporaryuuid` varchar(155) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1902 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'yusufcancelik@hotmaiasdl.com','zblash','Yusuf Can','Celik','827ccb0eea8a706c4c34a16891f84e7b',86,1,''),(802,'yusufcancelik@hotmail.comq','kemall','Kemal','Ozvarol','827ccb0eea8a706c4c34a16891f84e7b',6,1,'123124123123'),(851,'manga_mangamanga@hotmail.com','manga','Manganın','Solisti','827ccb0eea8a706c4c34a16891f84e7b',10,1,'d4cb32b8-4963-4f7c-b928-424dd5d9ce20'),(902,'manga_mangamangaaa@hotmail.com','mangass','Manganın','asdad','827ccb0eea8a706c4c34a16891f84e7b',5,0,'cc6b9107-fc47-495d-8cc6-13ba94c87667'),(1001,'yusufcancelik2@hotmail.com','zblash2','Yusuf Can','Çelik','827ccb0eea8a706c4c34a16891f84e7b',5,1,'38795ed9-6117-4895-a0e0-cbcce0bd88ed'),(1901,'yusufcancelik@hotmail.com','test','Test','Test1','35b3232542457465a70ad24a81eb126a',5,0,'e5aa78ff-0a1b-452c-8c3d-eb90b79e10cf');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(802,2),(851,2),(902,2),(1001,1),(1901,2);
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

-- Dump completed on 2018-07-24 18:17:25
