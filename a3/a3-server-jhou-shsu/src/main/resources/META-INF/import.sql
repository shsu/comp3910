LOCK TABLES `Questions` WRITE;
/*!40000 ALTER TABLE `Questions` DISABLE KEYS */;
INSERT INTO `Questions` VALUES (1,'D','interpersonal','individual','psychosocial','group','Which of the following best identifies the type of dynamics studied in organizational behaviour?',1,1),(2,'B','theology','sociology','astrology','physics','Which of the following disciplines listed contributes directly to organizational behaviour?',2,1),(3,'A','values','products','goals','job descriptions','Which of the following elements is characteristic to an informal organization?',3,1),(4,'D','General Electric','Malcolm Baldridge','Ford Motors','Motorola','Which of the following companies developed Six Sigma?',4,1),(5,'C','control','measure','analyze','improve','Which best identifies the second phase in the Six Sigma process?',5,1),(6,'B','12','9','8','5','According to HRSDC, how many essential skills are there?',1,2),(7,'B','protective gear','pistols','riot gear','face masks','According to the text, during the 1920’s, supervisors at the Homestead Works were issued which of the following?',2,2),(8,'B','Kurt Lewin','William James','Eric Brown','Katz and Kahn','Which of the following people established the Open System Framework?',3,2),(9,'B','attitudes and cognitions','attitudes and behaviour','affects and cognitions','behaviours and cognitions','Which is the most common cause of cognitive dissonance?',4,2),(10,'C','organizational commitment','normative commitment','continuance commitment','affective commitment','Which best defines an employee who remains in an organization because they cannot afford to leave?',1,3),(11,'A','intrinsic','extrinsic','internal','external','More educated workers are more likely to emphasize which of the following job content?',2,3),(12,'C','emotional intelligence','emotional labour','emotional dissonance','emotional display rules','Which is synonymous with a firefighter who is expected to hide his/her anxiety in a dangerous situation?',3,3),(13,'C','internal locus of control','external locus of control','high-mach','low-mach','Which best defines “if a person believes that the desired ends justify any means”?',4,3),(14,'A','attitude scales','observed behaviour','physiological indicators','beliefs','What distinguishes the A from the B in the ABC Model?',5,3),(15,'C','OCB','continuous commitment','unfairness','values','Which is the most common cause of WDB?',6,3),(16,'B','higher profit','higher quality applicants','lower job satisfaction','higher turnover','Firms with ethical reputations are synonymous with?',1,4),(17,'C','career','profession','job','reporting relationship','Which best defines specific work and task activities in an organization?',2,4),(18,'B','job enrichment','work simplification','job enlargement','human capacity for thought','Which is characteristic of scientific management?',3,4),(19,'D','skill variety','autonomy','task identity','task significance','Which of the following best identifies with a job that has an impact on others?',4,4),(20,'B','less physical','less physical effort','lower chance of mental overload','higher job satisfaction','Which is characteristic to the mechanistic approach to job design?',5,4);
/*!40000 ALTER TABLE `Questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Results`
--

LOCK TABLES `Results` WRITE;
/*!40000 ALTER TABLE `Results` DISABLE KEYS */;
INSERT INTO `Results` VALUES (1,4,5,1,1),(2,4,4,1,2),(3,4,6,1,3);
/*!40000 ALTER TABLE `Results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'admin','admin','admin','a00000000','admin');
INSERT INTO `Users` VALUES (2,'user','user','user','a00000001','user');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--
TRUNCATE `hibernate_sequence`
LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (101);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-28 16:14:00
