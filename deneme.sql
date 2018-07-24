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
INSERT INTO `contact` VALUES (1101,'Yusuf Can','yusufcancelik@hotmail.com','deneme mesajƒ±'),(1252,'Yusuf Can','yusufcancelik@hotmail.com','deneme2'),(1352,'Yusuf Can','yusufcancelik@hotmail.com','deneme3');
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
INSERT INTO `pricing` VALUES (1,250,20,'Arama Ba≈üƒ±na 1 Kredi','Rapor Kaydetme','Toplu Kontrol','Dosyadan Y√ºkleme'),(2,500,20,'Arama Ba≈üƒ±na 1 Kredi','Rapor Kaydetme','Toplu Kontrol','Dosyadan Y√ºkleme'),(3,750,30,'Arama Ba≈üƒ±na 1 Kredi','Rapor Kaydetme','Toplu Kontrol','Dosyadan Y√ºkleme'),(951,1000,50,'Deneme','Deneme','Deneme','Deneme'),(1502,1250,100,'Deneme','deneme','dneme','demene');
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
INSERT INTO `settings` VALUES (1,'PlagChecker','deneme,deneme2','deneme3','deneme2','deneme2','deneme2','AIzaSyA_x78ATHfpujhwuAcSlDEB-JiXFp8wIy0','âPNG\r\n\Z\n\0\0\0\rIHDR\0\0\0†\0\0\0\0\0\0´(\0\0\0sRGB\Ÿ\…,\0\0^IDATxú\Ìö	tU\≈\«%»æ∫ÄT$ö∞DñÉ@\—C\À\·\0*T\ŸZPñä\ÿZ=,¡íºÑ5@Y\ n	KãA\¬\Œ!\Ô%êÖ-ÅBX¢ÄÄÅ»í\‹˛ø\‹ˇ%\√ÛA7k\ﬁw\Œˇº7Àù;3˜wgæôπè<Ú\0≠\Î\‹COéﬂñ\\˘A\ﬁ\√k^ÛhjRB≥\◊%çú∏Ò»ëhg∫*\Ó˙x≠Y¿åÿ™uCúo˜Zö|\‹sdˆñ\‰åˆ\≈]\'Øï Ûv\rh8≈µ≤oxäs\Í∂ÙA€∂èwùºVB\Ã\œ\ﬂY9úcõLK\»z{E\Í_\¬vØ[\‹uÚZ	±:é}˛æAÆwT∞ÛJÀ∞ÑO\ﬁ]ï\⁄\ÈNyëß\‘\›\ Bz=h5¥¢†º%\’\–/\œ˙9úÛB\\±\r&ª\⁄EôÉ\"S´ºªÚ\‡Ñ!´FΩø\Ê`ì¢(Û°Xãπ˚\ ¯«øÖNIvFµùù8@Oà†æ\–N\ËÇ@\nπ†˘êØ[\ﬁ:–∑êA5~∏≠)~Cõ†œ†ı|\ﬂ\‘_D¸˜á\Œ¿´\0\–\0Äëv\Ô˘÷ä\‘r\0p/\04\0†\0ó\€-Û°ô_ê≥7|øπ\Ëîc\ \·\ZÙ\€Y˘\€/à´J,†~ÑÆk\·´PO-ˇ&(Z\ÀÙˇü7—¶°≠e†0\Ë¶\÷?ñ¶h˘æê8\0\ÿ\0^\0Äü€Ω7\0\0\r\0\ÿ\0^Ä´\Ìñi\À\–¿P\≈ÛÖ8€® \Á0‰Ω°Ç\‚á\‘\rr>ØïQ\⁄\≈LÑ\⁄@èB•˘\œa\⁄e®.Ù;Ü{C°® Ém\È\œ\√\–\Œ\n\–∂ˇ4\‘Of®3t ÖjCı˘\0¨¡p¥ù{˜ãHÒÄ\0p\0l\Œ0¥®\⁄v_Ü¶BK\Ôñ\«?$±&ë\Ôú\néw\‡∑2∆∞CS,ò	†üñ\Ás\Êà\◊A\'	\Ëa(\Œf\‰°~MÜj\⁄)ã\Â\rÇfA\œ\Ÿ-\ÀC\Ÿ\·\Ïác–Ø\‹\“f0≠4Çˇ˚\0¿Å∞ôù{¿v\0\–\0Ä}`(\ÏjØE6L:Ä”Äºi\Õ=f2åRægÄ∑y∂àßïQ˙Åù’äqï°Éå{öq}^»©Yåa≥\ÔiS\ÿG6\Àj≠ïeß,e˜gπ\◊=πà[\∆tôA¢˘l™¿Ø\0`≤\›˚¿âP¿o`\0¨d∑\\[Ü.g£\◊zJ˜\rä«¢\"~ûL≤˙ıs|S\À\Ì˙øÚ˙Øµ∏~åì)•\„&2\Œ\Í\‰\–e˙Üè\€lCK(:nw\‘\¬ıèA\…\–˜Pw;eπï[ôSÆ¥˝3\È5\Õ&/OYe˙\«˚eÄ9\0=ªu\0Ä[`&\0\Ï¿E\»bªe\⁄64∞!;\ÂÙ\‘O\“1\›\¬˜ì©arG¸KÆ\ﬂ¿\Îe\n_\–ö¬∏ı\Ã\”\ \ÊC]Õ¥ó†kR\Ó\√hgq\⁄9ò\Ìæ$ê3ÆõB{ô.ªU˘?\nÄ\ﬂ¿äòÇK€©\0<\r\0w\0¿π∞EQ¥Õ∂\ÂM≠fÉá\ÎÒæA	Å\"åÄç|µ¨€µgxm˙-2ı`\‹Q\  Ä=ï\ÈÛIXV”≤(©¡rdÑ\Ê\Ë3j\·v\‘√πFô\€:›¨©ùi≥yü*Zú?G˜$\Ë\Ívt%4A‚îπx\n\”“ÜBi\–n˜ı_P∫¢ªÇ\ﬂ.\–)e.\‰\«AÚäœªRª>ëÌûß\≈R˘\Óã(òÒ\ÕûùÄ£\‡\0\0x>pJ\¬-£eXbØ÷≥˜∂ùΩ?π›ú˝\ÔXÒ//H\n\Ë≤0\Èã\◊\'•ıXöºÙèÀí+æûR	\0\Z\00\0ûÄõ\0`GL¡q\√˛shœàµá*ç^w∏Ù\ÿ\Ë\√\„\∆}y$e\¬\∆#{˛Ò\’\—[˚é”∑¶Õõπ=-l\Œ\ŒÙß\Ê\ÔJèY∏˚ò\Ìπﬁπñ\Êº=\ﬁ5£\ﬂ*øê}≠\Ópù\Ï˚Y[	\œ ÉQ\Ê˛üæ≠ #\Îf\Ë9®ú2Wº9˝∆≥y\„˜1ø\Ôi\Ì>2Z^eY©Lü ¥\0ÜeO—ö\Óõr¥\Õ!–íæÑiO0^^ÄX¶≠cöèV?∑∂1˛;≈ôøå{\⁄\Õˇ”†QVùòØé\÷µ2e\—t\⁄u\’\‚;Y\œC\ \0ÄrbX\06õë{\0ò\0\œ\0¿\0ò\€~ﬁÅÄéÛ<\0O¿\\\0\0\r\08\0@∑aF\0¿l\0h\0@\0∂Ä°\0\–\0ÄI\00\0ûî{MŸíV\0f¿(\0¯%\04\0\‡\Ó˚£\Õ3H\Âÿ±\“\Ëº\r\„ê\ÕG\Àˆ^ñ\‹5p|rŸª\\W]\ÎX_\∆US˘”¨¯{’µ¸˙Éê˚Ua¸\"\∆\…\ﬁX†˛2gïÈ∏∑á>e˙8¶d8Çaqd4îÖïåî∏ç.Ø2,ef)m\Ô\rø\œ3|ÿ≠ù]X^\ﬁ©≈ß´|˜\√jó¯∫\Ÿ¸\œ|\÷./kÅüÆ)s3\ﬂ*o3\0\ÃÄ)∞µ\‰Ä˚\‡\r\0X\0æ\0\r\0\ÿ\0@\0NÄ˛p\0\Ï@\0o¿h\0ò	\0g¿Û\0∞>\0º\0ì\0`i\08\0^r\ƒ-\0\€\0@\0ûÄYp±U\ﬂ\»oéW+®M\Z\Z\Z*\rúö0T\¬sw¶;∂%ù|≤Äk*jUOãw0n¨[~-ˇ0\∆5b8É/ÇT8\”\«[p2ºâ\·˛/d¯Ourπ[˙H≠,Å^\·à#Ò3µ:7P\Ê®hA5äÒUñ\—ÙÀê∞L\…{	[$ÛZÄfÚY\÷\Í(—É\‡%\0x\n\0ñj2-\·\0h\0¿Ω\0P¿x\0\0}\0`|\0ñÄC\0`e\0¯îUi\0	\0¿\\\0\ÿ\0ˆÄ\0Ä\Ì\0\‡y\0ò∑G\0@\0~\n\0≥†k\Èûcù\√cè/Ä\√jSa\Z-m¥ôïÛ¡øµéà=æ∏ê\◊Y£àæ1=[y)Uæs-zÜq°\Íˆ)\’⁄¥\√ñ-}ä¥∂|N1‹êakZ}Ö\·4Ü[2l˘ª2ù◊Ä6ju\ \·o_\Ê\ﬂNV£G†\ﬂ(m∑@ô”Æuù¨^?\‘\¬s{i¨ó\ËT!˙S\\óVV\0\Ï\≈)xÖ\‰Ä	\‡5\0ò\0w\0¿º\›	\0xï\0\÷\”\ÀÄ[4\0≥\‡0\ÓNìt\0∏à\0f@\0\ŒÄe0V\0Ä{4\0\0`\04\0†\0s\0`ó¬∞R†°±ª—Ä+üDﬁµ\ﬁu¢PÖjù\’Iããf‹õÚ[\”V[ïîydó∑®ÃÖàu>,{{\ÕT˛\‘\'\”˜k⁄É©\Óñk\ÂD¡:˛k\Íâº`µÚ¢Y\Ÿ˛ê\…$e.\n$≠ù2]ÅT\\9ô(\œ4Y‘åU\Ê\ *[\¬\÷\ _Vπ\÷H/£oC≠Õ¢;\Œ*H{Y\Â/\ÍD%?\0eùcl\0@\0\Ê\n\0¿F£Ò¸\ÿM\‚1V\¬∏\0~Ø8	\0n\'Äı1∂Ä\Ÿ0\0 µ\0∞#\0LÄ\Ã\€jÄ\’\0\‡8\0\0ãn≥^zO¯!1G≥1˝x<\«k¶≥≥F3\Ï£AT\œC˛ ≠ÉE\◊¯+\Œx<;] í\’\·Mïø\»\Ÿ…ë\∆Úﬂ∫hä6äK\«ÚaZæ\ÌE˛Z#hu;\∆4YPúf^Åp¥\ ?•\–}XÉ˜îΩ\√%ˇì∞\ÍÁºô\⁄˝C•\›\Ó+_≠`∫º \÷ú∑A\0_\’!Ü|\0]F¿T.Br\‡xSr\0ò\0\œ@<ÀØa\“\‡>\0¯#\0\ÃÄ∏9Ä0\0\Z\0\n\0å#ÄCÓè¨B\Z\Z o¸ø\rÖΩÜ£Ötñ¨Ne\’r†\„Ôêø™ˆÄg*sıºô\–\≈0<úv\À;A\Ë\Êj\– ÉäR\ÊÇ\'ãe\ IC+eNôW\√\„\ ‹æπÃ∞¯c2“ï˜P∑1,KV\‚\‚+\ _ò∫Ä¥Jôg\ÿ˛\ƒk\ﬂgõ\Z0ºÜê\nòµ\‘\Ìß5≤¡,n\ ï\Ô2à‰•ì=SYlâ\ÎêwJ\0K¿(\0x\œh9\0ÙÄè¿p\0x\0f¿H\0\ÿ\n\0˙\0¿±\0\0º\0¿Z\0∞%\0ºÄ\Á\€[\ ÄÉ\0`&\0º\0£∏i\0∑¿\0`:\0ú\0\Î\–<\0´ª˜Yë¸øP¯≠\Ô\Â\Zt\‘\◊\Ï@\Î0]Fç{˙D_¸\Ì\‡ØU˛Òû¿Ùg;\Â\›c\›dT/W\ÂåPûøÄë8\Ÿ7Ù-∏Ø˝\ƒ\–qOC{ü,\Zä\∆)\Õ/ø±∫\›7≤},U\\¶\Ã}K˘†w*Ùwen\—\‘(\Óz˝\"LÒh©à\ÀÙ\„T\'\'	\÷q\’\œ\„\…kølS¶3üHˇRæ‹πƒë–ß∏\Î\Êµ`\ ¸\\]Åú∂nùZx\Õk‘îy†â+\›f\\Q\ \nµvq\◊\Õk%¿†lKXß≤“≠∏\Î\Â5Øy\Õk^ÛZ\·\Ì\\Ém\›?q7\0\0\0\0IENDÆB`Ç');
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
INSERT INTO `user` VALUES (1,'yusufcancelik@hotmaiasdl.com','zblash','Yusuf Can','Celik','827ccb0eea8a706c4c34a16891f84e7b',86,1,''),(802,'yusufcancelik@hotmail.comq','kemall','Kemal','Ozvarol','827ccb0eea8a706c4c34a16891f84e7b',6,1,'123124123123'),(851,'manga_mangamanga@hotmail.com','manga','Manganƒ±n','Solisti','827ccb0eea8a706c4c34a16891f84e7b',10,1,'d4cb32b8-4963-4f7c-b928-424dd5d9ce20'),(902,'manga_mangamangaaa@hotmail.com','mangass','Manganƒ±n','asdad','827ccb0eea8a706c4c34a16891f84e7b',5,0,'cc6b9107-fc47-495d-8cc6-13ba94c87667'),(1001,'yusufcancelik2@hotmail.com','zblash2','Yusuf Can','√áelik','827ccb0eea8a706c4c34a16891f84e7b',5,1,'38795ed9-6117-4895-a0e0-cbcce0bd88ed'),(1901,'yusufcancelik@hotmail.com','test','Test','Test1','35b3232542457465a70ad24a81eb126a',5,0,'e5aa78ff-0a1b-452c-8c3d-eb90b79e10cf');
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
