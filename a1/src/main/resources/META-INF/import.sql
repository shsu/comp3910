TRUNCATE TABLE hibernate_sequence;
TRUNCATE TABLE Users;
TRUNCATE TABLE TimeSheets;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (361);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'admin',1,'admin'),(2,'regular',0,'regular'),(3,'1234',1,'shsu'),(4,'1234',1,'jhou');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `TimeSheets`
--

LOCK TABLES `TimeSheets` WRITE;
/*!40000 ALTER TABLE `TimeSheets` DISABLE KEYS */;
INSERT INTO `TimeSheets` VALUES (1,1,1,1,NULL,57,0,0,1,1,1,43,'A3825',2013),(2,2,2,2,NULL,43,0,0,2,2,2,43,'A7882',2013),(3,3,2,2,NULL,37,0,0,2,2,2,43,'A9811',2013),(4,4,0,0,NULL,42,0,0,0,0,0,43,'A2869',2013),(5,1,2,2,NULL,39,0,0,2,2,2,43,'A6473',2013),(6,2,2,2,NULL,46,0,0,2,2,2,43,'A8610',2013),(7,3,2,2,NULL,49,0,0,2,2,2,43,'A9591',2013),(8,4,0,0,NULL,90,0,0,0,0,0,43,'A4564',2013),(9,1,2,2,NULL,53,0,0,2,2,2,43,'A5747',2013),(10,2,0,0,NULL,14,0,0,0,0,0,43,'A4097',2013),(11,3,1,1,NULL,2,0,0,1,1,1,43,'A3975',2013),(12,4,2,2,NULL,3,0,0,2,2,2,43,'A8307',2013),(13,1,2,2,NULL,9,0,0,2,2,2,43,'A1136',2013),(14,2,0,0,NULL,84,0,0,0,0,0,43,'A6416',2013),(15,3,1,1,NULL,72,0,0,1,1,1,43,'A3393',2013),(16,4,2,2,NULL,69,0,0,2,2,2,43,'A8563',2013),(17,1,0,0,NULL,77,0,0,0,0,0,43,'A5719',2013),(18,2,1,1,NULL,70,0,0,1,1,1,43,'A7772',2013),(19,3,0,0,NULL,33,0,0,0,0,0,43,'A8840',2013),(20,4,2,2,NULL,88,0,0,2,2,2,43,'A3991',2013),(21,1,1,1,NULL,66,0,0,1,1,1,42,'A5910',2013),(22,2,2,2,NULL,17,0,0,2,2,2,42,'A7077',2013),(23,3,0,0,NULL,87,0,0,0,0,0,42,'A7737',2013),(24,4,2,2,NULL,15,0,0,2,2,2,42,'A6525',2013),(25,1,2,2,NULL,5,0,0,2,2,2,42,'A2476',2013),(26,2,2,2,NULL,64,0,0,2,2,2,42,'A7949',2013),(27,3,1,1,NULL,87,0,0,1,1,1,42,'A363',2013),(28,4,0,0,NULL,38,0,0,0,0,0,42,'A8931',2013),(29,1,2,2,NULL,29,0,0,2,2,2,42,'A4286',2013),(30,2,2,2,NULL,41,0,0,2,2,2,42,'A1274',2013),(31,3,2,2,NULL,92,0,0,2,2,2,42,'A7479',2013),(32,4,2,2,NULL,53,0,0,2,2,2,42,'A6443',2013),(33,1,0,0,NULL,10,0,0,0,0,0,42,'A4338',2013),(34,2,0,0,NULL,2,0,0,0,0,0,42,'A3676',2013),(35,3,1,1,NULL,59,0,0,1,1,1,42,'A3355',2013),(36,4,1,1,NULL,83,0,0,1,1,1,42,'A3461',2013),(37,1,2,2,NULL,8,0,0,2,2,2,42,'A4604',2013),(38,2,2,2,NULL,83,0,0,2,2,2,42,'A3730',2013),(39,3,1,1,NULL,75,0,0,1,1,1,42,'A2096',2013),(40,4,0,0,NULL,20,0,0,0,0,0,42,'A5164',2013),(41,1,2,2,NULL,86,0,0,2,2,2,41,'A3042',2013),(42,2,2,2,NULL,35,0,0,2,2,2,41,'A868',2013),(43,3,1,1,NULL,38,0,0,1,1,1,41,'A1653',2013),(44,4,2,2,NULL,20,0,0,2,2,2,41,'A2673',2013),(45,1,2,2,NULL,42,0,0,2,2,2,41,'A8474',2013),(46,2,0,0,NULL,84,0,0,0,0,0,41,'A6737',2013),(47,3,0,0,NULL,18,0,0,0,0,0,41,'A7195',2013),(48,4,1,1,NULL,32,0,0,1,1,1,41,'A1356',2013),(49,1,0,0,NULL,85,0,0,0,0,0,41,'A8449',2013),(50,2,2,2,NULL,46,0,0,2,2,2,41,'A4711',2013),(51,3,2,2,NULL,26,0,0,2,2,2,41,'A2934',2013),(52,4,1,1,NULL,46,0,0,1,1,1,41,'A5433',2013),(53,1,1,1,NULL,4,0,0,1,1,1,41,'A8524',2013),(54,2,1,1,NULL,36,0,0,1,1,1,41,'A7881',2013),(55,3,1,1,NULL,84,0,0,1,1,1,41,'A3655',2013),(56,4,2,2,NULL,73,0,0,2,2,2,41,'A6338',2013),(57,1,0,0,NULL,30,0,0,0,0,0,41,'A7122',2013),(58,2,0,0,NULL,58,0,0,0,0,0,41,'A8278',2013),(59,3,0,0,NULL,11,0,0,0,0,0,41,'A5297',2013),(60,4,2,2,NULL,31,0,0,2,2,2,41,'A9921',2013),(61,1,1,1,NULL,62,0,0,1,1,1,40,'A654',2013),(62,2,2,2,NULL,71,0,0,2,2,2,40,'A9438',2013),(63,3,2,2,NULL,51,0,0,2,2,2,40,'A2655',2013),(64,4,1,1,NULL,28,0,0,1,1,1,40,'A8924',2013),(65,1,0,0,NULL,92,0,0,0,0,0,40,'A4121',2013),(66,2,0,0,NULL,73,0,0,0,0,0,40,'A5155',2013),(67,3,2,2,NULL,49,0,0,2,2,2,40,'A2255',2013),(68,4,0,0,NULL,77,0,0,0,0,0,40,'A6297',2013),(69,1,1,1,NULL,80,0,0,1,1,1,40,'A5597',2013),(70,2,2,2,NULL,51,0,0,2,2,2,40,'A1549',2013),(71,3,2,2,NULL,50,0,0,2,2,2,40,'A9837',2013),(72,4,1,1,NULL,94,0,0,1,1,1,40,'A3515',2013),(73,1,2,2,NULL,15,0,0,2,2,2,40,'A6466',2013),(74,2,1,1,NULL,31,0,0,1,1,1,40,'A444',2013),(75,3,0,0,NULL,88,0,0,0,0,0,40,'A4328',2013),(76,4,0,0,NULL,80,0,0,0,0,0,40,'A9073',2013),(77,1,2,2,NULL,21,0,0,2,2,2,40,'A5326',2013),(78,2,2,2,NULL,11,0,0,2,2,2,40,'A2579',2013),(79,3,1,1,NULL,52,0,0,1,1,1,40,'A2663',2013),(80,4,2,2,NULL,54,0,0,2,2,2,40,'A734',2013),(81,1,0,0,NULL,41,0,0,0,0,0,39,'A1968',2013),(82,2,1,1,NULL,83,0,0,1,1,1,39,'A31',2013),(83,3,0,0,NULL,67,0,0,0,0,0,39,'A5709',2013),(84,4,2,2,NULL,67,0,0,2,2,2,39,'A1672',2013),(85,1,2,2,NULL,40,0,0,2,2,2,39,'A2472',2013),(86,2,1,1,NULL,97,0,0,1,1,1,39,'A8454',2013),(87,3,2,2,NULL,23,0,0,2,2,2,39,'A4344',2013),(88,4,1,1,NULL,61,0,0,1,1,1,39,'A2234',2013),(89,1,0,0,NULL,69,0,0,0,0,0,39,'A1377',2013),(90,2,1,1,NULL,0,0,0,1,1,1,39,'A3709',2013),(91,3,2,2,NULL,79,0,0,2,2,2,39,'A1336',2013),(92,4,2,2,NULL,50,0,0,2,2,2,39,'A990',2013),(93,1,0,0,NULL,86,0,0,0,0,0,39,'A3064',2013),(94,2,2,2,NULL,25,0,0,2,2,2,39,'A1920',2013),(95,3,0,0,NULL,71,0,0,0,0,0,39,'A9253',2013),(96,4,2,2,NULL,77,0,0,2,2,2,39,'A2736',2013),(97,1,0,0,NULL,20,0,0,0,0,0,39,'A8503',2013),(98,2,2,2,NULL,88,0,0,2,2,2,39,'A5163',2013),(99,3,1,1,NULL,10,0,0,1,1,1,39,'A8120',2013),(100,4,2,2,NULL,84,0,0,2,2,2,39,'A1118',2013),(101,1,2,2,NULL,18,0,0,2,2,2,38,'A2972',2013),(102,2,1,1,NULL,71,0,0,1,1,1,38,'A6427',2013),(103,3,2,2,NULL,9,0,0,2,2,2,38,'A6846',2013),(104,4,2,2,NULL,48,0,0,2,2,2,38,'A4920',2013),(105,1,0,0,NULL,36,0,0,0,0,0,38,'A7698',2013),(106,2,2,2,NULL,50,0,0,2,2,2,38,'A454',2013),(107,3,2,2,NULL,89,0,0,2,2,2,38,'A4812',2013),(108,4,0,0,NULL,8,0,0,0,0,0,38,'A7873',2013),(109,1,2,2,NULL,26,0,0,2,2,2,38,'A7662',2013),(110,2,1,1,NULL,28,0,0,1,1,1,38,'A107',2013),(111,3,0,0,NULL,45,0,0,0,0,0,38,'A7976',2013),(112,4,0,0,NULL,0,0,0,0,0,0,38,'A3056',2013),(113,1,1,1,NULL,72,0,0,1,1,1,38,'A951',2013),(114,2,2,2,NULL,10,0,0,2,2,2,38,'A7083',2013),(115,3,1,1,NULL,62,0,0,1,1,1,38,'A5572',2013),(116,4,1,1,NULL,66,0,0,1,1,1,38,'A7356',2013),(117,1,2,2,NULL,84,0,0,2,2,2,38,'A9163',2013),(118,2,2,2,NULL,67,0,0,2,2,2,38,'A2141',2013),(119,3,2,2,NULL,81,0,0,2,2,2,38,'A3144',2013),(120,4,2,2,NULL,80,0,0,2,2,2,38,'A8731',2013),(121,1,1,1,NULL,99,0,0,1,1,1,37,'A9934',2013),(122,2,2,2,NULL,15,0,0,2,2,2,37,'A2273',2013),(123,3,1,1,NULL,95,0,0,1,1,1,37,'A8588',2013),(124,4,1,1,NULL,62,0,0,1,1,1,37,'A1925',2013),(125,1,2,2,NULL,35,0,0,2,2,2,37,'A2222',2013),(126,2,1,1,NULL,52,0,0,1,1,1,37,'A2704',2013),(127,3,1,1,NULL,84,0,0,1,1,1,37,'A4312',2013),(128,4,1,1,NULL,50,0,0,1,1,1,37,'A7399',2013),(129,1,0,0,NULL,9,0,0,0,0,0,37,'A8463',2013),(130,2,1,1,NULL,66,0,0,1,1,1,37,'A7588',2013),(131,3,1,1,NULL,42,0,0,1,1,1,37,'A5463',2013),(132,4,2,2,NULL,87,0,0,2,2,2,37,'A8879',2013),(133,1,2,2,NULL,39,0,0,2,2,2,37,'A9969',2013),(134,2,2,2,NULL,83,0,0,2,2,2,37,'A666',2013),(135,3,1,1,NULL,33,0,0,1,1,1,37,'A5633',2013),(136,4,1,1,NULL,62,0,0,1,1,1,37,'A3295',2013),(137,1,2,2,NULL,89,0,0,2,2,2,37,'A2803',2013),(138,2,0,0,NULL,36,0,0,0,0,0,37,'A4001',2013),(139,3,0,0,NULL,3,0,0,0,0,0,37,'A3468',2013),(140,4,1,1,NULL,8,0,0,1,1,1,37,'A1283',2013),(141,1,0,0,NULL,37,0,0,0,0,0,36,'A1142',2013),(142,2,0,0,NULL,52,0,0,0,0,0,36,'A5417',2013),(143,3,2,2,NULL,90,0,0,2,2,2,36,'A6151',2013),(144,4,1,1,NULL,32,0,0,1,1,1,36,'A108',2013),(145,1,0,0,NULL,90,0,0,0,0,0,36,'A2459',2013),(146,2,0,0,NULL,75,0,0,0,0,0,36,'A670',2013),(147,3,2,2,NULL,86,0,0,2,2,2,36,'A5893',2013),(148,4,2,2,NULL,44,0,0,2,2,2,36,'A8283',2013),(149,1,1,1,NULL,17,0,0,1,1,1,36,'A6446',2013),(150,2,2,2,NULL,14,0,0,2,2,2,36,'A1673',2013),(151,3,0,0,NULL,34,0,0,0,0,0,36,'A5420',2013),(152,4,0,0,NULL,77,0,0,0,0,0,36,'A7088',2013),(153,1,1,1,NULL,63,0,0,1,1,1,36,'A4991',2013),(154,2,2,2,NULL,43,0,0,2,2,2,36,'A3912',2013),(155,3,2,2,NULL,23,0,0,2,2,2,36,'A5777',2013),(156,4,0,0,NULL,40,0,0,0,0,0,36,'A7895',2013),(157,1,2,2,NULL,11,0,0,2,2,2,36,'A8123',2013),(158,2,1,1,NULL,71,0,0,1,1,1,36,'A8785',2013),(159,3,0,0,NULL,3,0,0,0,0,0,36,'A7749',2013),(160,4,1,1,NULL,17,0,0,1,1,1,36,'A940',2013),(161,1,0,0,NULL,4,0,0,0,0,0,35,'A866',2013),(162,2,0,0,NULL,57,0,0,0,0,0,35,'A573',2013),(163,3,1,1,NULL,80,0,0,1,1,1,35,'A3231',2013),(164,4,0,0,NULL,87,0,0,0,0,0,35,'A2255',2013),(165,1,0,0,NULL,55,0,0,0,0,0,35,'A7870',2013),(166,2,0,0,NULL,9,0,0,0,0,0,35,'A5043',2013),(167,3,1,1,NULL,57,0,0,1,1,1,35,'A2106',2013),(168,4,2,2,NULL,24,0,0,2,2,2,35,'A6943',2013),(169,1,0,0,NULL,62,0,0,0,0,0,35,'A5049',2013),(170,2,1,1,NULL,13,0,0,1,1,1,35,'A5837',2013),(171,3,2,2,NULL,43,0,0,2,2,2,35,'A588',2013),(172,4,0,0,NULL,23,0,0,0,0,0,35,'A3969',2013),(173,1,1,1,NULL,57,0,0,1,1,1,35,'A6880',2013),(174,2,0,0,NULL,82,0,0,0,0,0,35,'A2182',2013),(175,3,0,0,NULL,38,0,0,0,0,0,35,'A7909',2013),(176,4,0,0,NULL,20,0,0,0,0,0,35,'A3746',2013),(177,1,1,1,NULL,20,0,0,1,1,1,35,'A3527',2013),(178,2,1,1,NULL,58,0,0,1,1,1,35,'A7948',2013),(179,3,0,0,NULL,67,0,0,0,0,0,35,'A5524',2013),(180,4,2,2,NULL,33,0,0,2,2,2,35,'A580',2013),(181,1,1,1,NULL,43,0,0,1,1,1,43,'A628',2013),(182,2,2,2,NULL,20,0,0,2,2,2,43,'A9908',2013),(183,3,2,2,NULL,17,0,0,2,2,2,43,'A8412',2013),(184,4,2,2,NULL,9,0,0,2,2,2,43,'A8398',2013),(185,1,1,1,NULL,68,0,0,1,1,1,43,'A3904',2013),(186,2,2,2,NULL,94,0,0,2,2,2,43,'A8782',2013),(187,3,0,0,NULL,54,0,0,0,0,0,43,'A582',2013),(188,4,1,1,NULL,94,0,0,1,1,1,43,'A5630',2013),(189,1,2,2,NULL,3,0,0,2,2,2,43,'A9304',2013),(190,2,1,1,NULL,33,0,0,1,1,1,43,'A6057',2013),(191,3,2,2,NULL,65,0,0,2,2,2,43,'A4447',2013),(192,4,0,0,NULL,54,0,0,0,0,0,43,'A4419',2013),(193,1,0,0,NULL,76,0,0,0,0,0,43,'A6180',2013),(194,2,0,0,NULL,29,0,0,0,0,0,43,'A2640',2013),(195,3,2,2,NULL,6,0,0,2,2,2,43,'A5038',2013),(196,4,1,1,NULL,43,0,0,1,1,1,43,'A34',2013),(197,1,1,1,NULL,3,0,0,1,1,1,43,'A2235',2013),(198,2,0,0,NULL,2,0,0,0,0,0,43,'A5787',2013),(199,3,0,0,NULL,68,0,0,0,0,0,43,'A7593',2013),(200,4,0,0,NULL,73,0,0,0,0,0,43,'A3479',2013),(201,1,0,0,NULL,53,0,0,0,0,0,42,'A9742',2013),(202,2,1,1,NULL,41,0,0,1,1,1,42,'A8407',2013),(203,3,2,2,NULL,13,0,0,2,2,2,42,'A3468',2013),(204,4,0,0,NULL,98,0,0,0,0,0,42,'A9040',2013),(205,1,0,0,NULL,70,0,0,0,0,0,42,'A9043',2013),(206,2,2,2,NULL,98,0,0,2,2,2,42,'A361',2013),(207,3,0,0,NULL,13,0,0,0,0,0,42,'A2561',2013),(208,4,0,0,NULL,87,0,0,0,0,0,42,'A1413',2013),(209,1,2,2,NULL,70,0,0,2,2,2,42,'A1021',2013),(210,2,2,2,NULL,63,0,0,2,2,2,42,'A3623',2013),(211,3,0,0,NULL,40,0,0,0,0,0,42,'A985',2013),(212,4,0,0,NULL,51,0,0,0,0,0,42,'A4833',2013),(213,1,0,0,NULL,40,0,0,0,0,0,42,'A4516',2013),(214,2,2,2,NULL,72,0,0,2,2,2,42,'A9954',2013),(215,3,1,1,NULL,70,0,0,1,1,1,42,'A5664',2013),(216,4,1,1,NULL,70,0,0,1,1,1,42,'A4818',2013),(217,1,2,2,NULL,49,0,0,2,2,2,42,'A6150',2013),(218,2,2,2,NULL,24,0,0,2,2,2,42,'A8164',2013),(219,3,1,1,NULL,39,0,0,1,1,1,42,'A2023',2013),(220,4,2,2,NULL,71,0,0,2,2,2,42,'A303',2013),(221,1,2,2,NULL,79,0,0,2,2,2,41,'A2809',2013),(222,2,0,0,NULL,91,0,0,0,0,0,41,'A902',2013),(223,3,2,2,NULL,23,0,0,2,2,2,41,'A4568',2013),(224,4,0,0,NULL,42,0,0,0,0,0,41,'A7030',2013),(225,1,0,0,NULL,74,0,0,0,0,0,41,'A1173',2013),(226,2,2,2,NULL,3,0,0,2,2,2,41,'A5057',2013),(227,3,1,1,NULL,83,0,0,1,1,1,41,'A4039',2013),(228,4,2,2,NULL,1,0,0,2,2,2,41,'A4424',2013),(229,1,2,2,NULL,44,0,0,2,2,2,41,'A1518',2013),(230,2,0,0,NULL,26,0,0,0,0,0,41,'A466',2013),(231,3,1,1,NULL,83,0,0,1,1,1,41,'A7186',2013),(232,4,1,1,NULL,15,0,0,1,1,1,41,'A8372',2013),(233,1,2,2,NULL,84,0,0,2,2,2,41,'A9471',2013),(234,2,1,1,NULL,86,0,0,1,1,1,41,'A8741',2013),(235,3,1,1,NULL,52,0,0,1,1,1,41,'A690',2013),(236,4,0,0,NULL,43,0,0,0,0,0,41,'A4784',2013),(237,1,2,2,NULL,0,0,0,2,2,2,41,'A1737',2013),(238,2,0,0,NULL,36,0,0,0,0,0,41,'A3701',2013),(239,3,2,2,NULL,39,0,0,2,2,2,41,'A3290',2013),(240,4,2,2,NULL,23,0,0,2,2,2,41,'A6647',2013),(241,1,2,2,NULL,51,0,0,2,2,2,40,'A3859',2013),(242,2,1,1,NULL,74,0,0,1,1,1,40,'A2529',2013),(243,3,0,0,NULL,93,0,0,0,0,0,40,'A1582',2013),(244,4,0,0,NULL,18,0,0,0,0,0,40,'A5109',2013),(245,1,2,2,NULL,55,0,0,2,2,2,40,'A258',2013),(246,2,2,2,NULL,0,0,0,2,2,2,40,'A5597',2013),(247,3,2,2,NULL,50,0,0,2,2,2,40,'A2967',2013),(248,4,0,0,NULL,3,0,0,0,0,0,40,'A1494',2013),(249,1,2,2,NULL,33,0,0,2,2,2,40,'A4795',2013),(250,2,2,2,NULL,34,0,0,2,2,2,40,'A9279',2013),(251,3,0,0,NULL,83,0,0,0,0,0,40,'A8027',2013),(252,4,0,0,NULL,20,0,0,0,0,0,40,'A9093',2013),(253,1,0,0,NULL,4,0,0,0,0,0,40,'A8708',2013),(254,2,0,0,NULL,25,0,0,0,0,0,40,'A477',2013),(255,3,1,1,NULL,32,0,0,1,1,1,40,'A7605',2013),(256,4,2,2,NULL,78,0,0,2,2,2,40,'A2255',2013),(257,1,1,1,NULL,57,0,0,1,1,1,40,'A3588',2013),(258,2,0,0,NULL,67,0,0,0,0,0,40,'A809',2013),(259,3,0,0,NULL,15,0,0,0,0,0,40,'A235',2013),(260,4,1,1,NULL,87,0,0,1,1,1,40,'A9404',2013),(261,1,2,2,NULL,44,0,0,2,2,2,39,'A3810',2013),(262,2,2,2,NULL,29,0,0,2,2,2,39,'A2884',2013),(263,3,1,1,NULL,79,0,0,1,1,1,39,'A8269',2013),(264,4,0,0,NULL,43,0,0,0,0,0,39,'A1164',2013),(265,1,0,0,NULL,71,0,0,0,0,0,39,'A1127',2013),(266,2,2,2,NULL,20,0,0,2,2,2,39,'A6066',2013),(267,3,1,1,NULL,6,0,0,1,1,1,39,'A6590',2013),(268,4,2,2,NULL,35,0,0,2,2,2,39,'A6697',2013),(269,1,0,0,NULL,79,0,0,0,0,0,39,'A3514',2013),(270,2,0,0,NULL,28,0,0,0,0,0,39,'A993',2013),(271,3,0,0,NULL,74,0,0,0,0,0,39,'A8033',2013),(272,4,1,1,NULL,21,0,0,1,1,1,39,'A3075',2013),(273,1,0,0,NULL,60,0,0,0,0,0,39,'A3798',2013),(274,2,0,0,NULL,89,0,0,0,0,0,39,'A1151',2013),(275,3,1,1,NULL,15,0,0,1,1,1,39,'A1346',2013),(276,4,2,2,NULL,5,0,0,2,2,2,39,'A9094',2013),(277,1,1,1,NULL,7,0,0,1,1,1,39,'A1077',2013),(278,2,1,1,NULL,12,0,0,1,1,1,39,'A2109',2013),(279,3,0,0,NULL,25,0,0,0,0,0,39,'A1007',2013),(280,4,2,2,NULL,9,0,0,2,2,2,39,'A6560',2013),(281,1,0,0,NULL,36,0,0,0,0,0,38,'A8164',2013),(282,2,0,0,NULL,47,0,0,0,0,0,38,'A3606',2013),(283,3,2,2,NULL,5,0,0,2,2,2,38,'A5985',2013),(284,4,1,1,NULL,37,0,0,1,1,1,38,'A3082',2013),(285,1,0,0,NULL,58,0,0,0,0,0,38,'A9007',2013),(286,2,1,1,NULL,81,0,0,1,1,1,38,'A3039',2013),(287,3,2,2,NULL,10,0,0,2,2,2,38,'A8506',2013),(288,4,1,1,NULL,73,0,0,1,1,1,38,'A8737',2013),(289,1,2,2,NULL,94,0,0,2,2,2,38,'A4382',2013),(290,2,1,1,NULL,85,0,0,1,1,1,38,'A3244',2013),(291,3,2,2,NULL,70,0,0,2,2,2,38,'A3368',2013),(292,4,0,0,NULL,8,0,0,0,0,0,38,'A7524',2013),(293,1,0,0,NULL,39,0,0,0,0,0,38,'A5186',2013),(294,2,0,0,NULL,97,0,0,0,0,0,38,'A3970',2013),(295,3,2,2,NULL,64,0,0,2,2,2,38,'A689',2013),(296,4,2,2,NULL,93,0,0,2,2,2,38,'A2756',2013),(297,1,1,1,NULL,68,0,0,1,1,1,38,'A308',2013),(298,2,0,0,NULL,99,0,0,0,0,0,38,'A5949',2013),(299,3,1,1,NULL,98,0,0,1,1,1,38,'A8105',2013),(300,4,0,0,NULL,61,0,0,0,0,0,38,'A578',2013),(301,1,0,0,NULL,69,0,0,0,0,0,37,'A9590',2013),(302,2,2,2,NULL,64,0,0,2,2,2,37,'A3615',2013),(303,3,0,0,NULL,80,0,0,0,0,0,37,'A5614',2013),(304,4,0,0,NULL,1,0,0,0,0,0,37,'A6256',2013),(305,1,1,1,NULL,45,0,0,1,1,1,37,'A667',2013),(306,2,0,0,NULL,98,0,0,0,0,0,37,'A6791',2013),(307,3,2,2,NULL,86,0,0,2,2,2,37,'A2681',2013),(308,4,2,2,NULL,30,0,0,2,2,2,37,'A5543',2013),(309,1,0,0,NULL,40,0,0,0,0,0,37,'A1848',2013),(310,2,2,2,NULL,40,0,0,2,2,2,37,'A6575',2013),(311,3,0,0,NULL,79,0,0,0,0,0,37,'A6307',2013),(312,4,1,1,NULL,91,0,0,1,1,1,37,'A1252',2013),(313,1,1,1,NULL,37,0,0,1,1,1,37,'A3946',2013),(314,2,2,2,NULL,96,0,0,2,2,2,37,'A3408',2013),(315,3,0,0,NULL,35,0,0,0,0,0,37,'A8655',2013),(316,4,0,0,NULL,38,0,0,0,0,0,37,'A2858',2013),(317,1,1,1,NULL,19,0,0,1,1,1,37,'A136',2013),(318,2,0,0,NULL,92,0,0,0,0,0,37,'A7805',2013),(319,3,1,1,NULL,79,0,0,1,1,1,37,'A9690',2013),(320,4,1,1,NULL,20,0,0,1,1,1,37,'A5087',2013),(321,1,1,1,NULL,61,0,0,1,1,1,36,'A9813',2013),(322,2,0,0,NULL,6,0,0,0,0,0,36,'A4356',2013),(323,3,0,0,NULL,29,0,0,0,0,0,36,'A6931',2013),(324,4,1,1,NULL,16,0,0,1,1,1,36,'A7630',2013),(325,1,0,0,NULL,69,0,0,0,0,0,36,'A7810',2013),(326,2,1,1,NULL,31,0,0,1,1,1,36,'A5952',2013),(327,3,2,2,NULL,82,0,0,2,2,2,36,'A2056',2013),(328,4,2,2,NULL,94,0,0,2,2,2,36,'A6529',2013),(329,1,2,2,NULL,37,0,0,2,2,2,36,'A7049',2013),(330,2,0,0,NULL,16,0,0,0,0,0,36,'A6998',2013),(331,3,1,1,NULL,89,0,0,1,1,1,36,'A9453',2013),(332,4,0,0,NULL,53,0,0,0,0,0,36,'A9945',2013),(333,1,2,2,NULL,73,0,0,2,2,2,36,'A9640',2013),(334,2,2,2,NULL,73,0,0,2,2,2,36,'A7056',2013),(335,3,2,2,NULL,14,0,0,2,2,2,36,'A4549',2013),(336,4,2,2,NULL,98,0,0,2,2,2,36,'A735',2013),(337,1,2,2,NULL,77,0,0,2,2,2,36,'A8341',2013),(338,2,2,2,NULL,74,0,0,2,2,2,36,'A3748',2013),(339,3,2,2,NULL,68,0,0,2,2,2,36,'A4768',2013),(340,4,2,2,NULL,12,0,0,2,2,2,36,'A2958',2013),(341,1,2,2,NULL,39,0,0,2,2,2,35,'A7344',2013),(342,2,2,2,NULL,36,0,0,2,2,2,35,'A9272',2013),(343,3,1,1,NULL,76,0,0,1,1,1,35,'A4087',2013),(344,4,0,0,NULL,70,0,0,0,0,0,35,'A6124',2013),(345,1,0,0,NULL,25,0,0,0,0,0,35,'A553',2013),(346,2,1,1,NULL,24,0,0,1,1,1,35,'A215',2013),(347,3,2,2,NULL,41,0,0,2,2,2,35,'A1140',2013),(348,4,0,0,NULL,68,0,0,0,0,0,35,'A3978',2013),(349,1,2,2,NULL,5,0,0,2,2,2,35,'A6941',2013),(350,2,1,1,NULL,30,0,0,1,1,1,35,'A8296',2013),(351,3,0,0,NULL,50,0,0,0,0,0,35,'A5762',2013),(352,4,1,1,NULL,15,0,0,1,1,1,35,'A1459',2013),(353,1,1,1,NULL,30,0,0,1,1,1,35,'A9687',2013),(354,2,0,0,NULL,53,0,0,0,0,0,35,'A2466',2013),(355,3,1,1,NULL,84,0,0,1,1,1,35,'A5748',2013),(356,4,0,0,NULL,99,0,0,0,0,0,35,'A9196',2013),(357,1,2,2,NULL,95,0,0,2,2,2,35,'A4477',2013),(358,2,1,1,NULL,16,0,0,1,1,1,35,'A7257',2013),(359,3,0,0,NULL,5,0,0,0,0,0,35,'A3777',2013),(360,4,1,1,NULL,30,0,0,1,1,1,35,'A8998',2013);
/*!40000 ALTER TABLE `TimeSheets` ENABLE KEYS */;
UNLOCK TABLES;