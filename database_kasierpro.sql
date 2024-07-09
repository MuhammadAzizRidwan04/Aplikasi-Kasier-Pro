-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ambyar
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `makanan`
--

DROP TABLE IF EXISTS `makanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `makanan` (
  `ID_Makanan` varchar(10) NOT NULL,
  `Nama_Makanan` varchar(60) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Makanan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makanan`
--

LOCK TABLES `makanan` WRITE;
/*!40000 ALTER TABLE `makanan` DISABLE KEYS */;
INSERT INTO `makanan` VALUES ('MK001','Mie Ayam Pangsit',7000),('MK002','Mie Ayam Bakso',9000),('MK003','Mie Ayam Ceker',10000),('MK004','Bakso Biasa',8000),('MK005','Bakso Ambyar',10000),('MK006','Nasi Goreng level 0-2',10000),('MK007','Nasi Goreng level 3-5',12000),('MK008','Mie Ambyar level 0-2',8000),('MK009','Mie Ambyar level 3-5',9000),('MK010','Mie Geprek Ambyar level 0-2',14000),('MK011','Mie Geprek Ambyar level 3-5',15000),('MK012','Mie Bakar Ambyar level 0-2',10000),('MK013','Mie Bakar Ambyar level 3-5',12000),('MK014','Seblak Ori level 0-5',8000),('MK015','Ayam Ori',6000),('MK016','Nasi Ayam Crispy',8000),('MK017','Nasi Ayam Geprek',8000),('MK018','Nasi Saos Ambyar',10000),('MK019','Nasi Bakso Geprek',10000),('MK020','Nasi Telur Geprek',8000),('MK021','Nasi Ayam Geprek Bakar',10000),('MK022','Nasi Putih',3000),('MK023','Nasi Ayam Bakar Sayap',10000),('MK024','Nasi Ayam Bakar Tanggung',13000),('MK025','Nasi Ayam Bakar Jumbo',17000),('MK026','lontong kecap',5000);
/*!40000 ALTER TABLE `makanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `minuman`
--

DROP TABLE IF EXISTS `minuman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `minuman` (
  `ID_Minuman` varchar(10) NOT NULL,
  `Nama_Minuman` varchar(60) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Minuman`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minuman`
--

LOCK TABLES `minuman` WRITE;
/*!40000 ALTER TABLE `minuman` DISABLE KEYS */;
INSERT INTO `minuman` VALUES ('MN001','Es Teh/Anget',3000),('MN002','Es Jeruk/Anget',4000),('MN003','Lemon Tea',5000),('MN004','Leci Tea',5000),('MN005','Milk Tea',6000),('MN006','Milo',6000),('MN007','Chocolate',7000),('MN008','Green Tea',7000),('MN009','Cappucino',7000),('MN010','Yakult Tea',7000),('MN011','Air Mineral',4000);
/*!40000 ALTER TABLE `minuman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paket`
--

DROP TABLE IF EXISTS `paket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paket` (
  `ID_Paket` varchar(10) NOT NULL,
  `Nama_Paket` varchar(60) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Paket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paket`
--

LOCK TABLES `paket` WRITE;
/*!40000 ALTER TABLE `paket` DISABLE KEYS */;
INSERT INTO `paket` VALUES ('PK001','Paket 1 (Nasi Ayam Crispy + Es Kopi)',12000),('PK002','Paket 2 (Nasi Ayam Geprek + Es Teh)',10000),('PK003','Paket 3 (Nasi Ayam Saos Ambyar + Es Teh)',12000),('PK004','Paket 4 (Nasi Bakso Geprek + Es Teh)',12000),('PK005','Paket 5 (Nasi Telur Geprek + Es Teh)',10000),('PK006','Paket 6 (Nasi Ayam Geprek Bakar + Es Teh)',12000),('PK007','Paket 7 (Nasi Ayam Bakar Sayap + Es Teh)',12000),('PK008','Paket 8 (Nasi Ayam Bakar Tanggung + Es Teh)',15000),('PK009','Paket 9 (Nasi Ayam Bakar Jumbo + Es Teh)',19000);
/*!40000 ALTER TABLE `paket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penjualan`
--

DROP TABLE IF EXISTS `penjualan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penjualan` (
  `NoFaktur` varchar(20) NOT NULL,
  `Tanggal` varchar(20) DEFAULT NULL,
  `ID_Customer` varchar(10) DEFAULT NULL,
  `TotalBeli` int(11) DEFAULT NULL,
  `ID_Makanan` varchar(10) DEFAULT NULL,
  `ID_Minuman` varchar(10) DEFAULT NULL,
  `ID_Paket` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`NoFaktur`),
  KEY `FK_ID_Makanan` (`ID_Makanan`),
  KEY `FK_ID_Minuman` (`ID_Minuman`),
  KEY `FK_ID_Paket` (`ID_Paket`),
  CONSTRAINT `FK_ID_Makanan` FOREIGN KEY (`ID_Makanan`) REFERENCES `makanan` (`ID_Makanan`),
  CONSTRAINT `FK_ID_Minuman` FOREIGN KEY (`ID_Minuman`) REFERENCES `minuman` (`ID_Minuman`),
  CONSTRAINT `FK_ID_Paket` FOREIGN KEY (`ID_Paket`) REFERENCES `paket` (`ID_Paket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penjualan`
--

LOCK TABLES `penjualan` WRITE;
/*!40000 ALTER TABLE `penjualan` DISABLE KEYS */;
INSERT INTO `penjualan` VALUES ('TR0001','05-07-2024','CS0001',17000,NULL,NULL,NULL),('TR0002','07-07-2024','CS0002',53000,NULL,NULL,NULL);
/*!40000 ALTER TABLE `penjualan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penjualan_rinci`
--

DROP TABLE IF EXISTS `penjualan_rinci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penjualan_rinci` (
  `nof` varchar(20) NOT NULL,
  `ID_Barang` varchar(10) NOT NULL,
  `Nama_Barang` varchar(60) DEFAULT NULL,
  `Jumlah` int(11) DEFAULT NULL,
  `Harga` int(11) DEFAULT NULL,
  `Total` int(11) DEFAULT NULL,
  PRIMARY KEY (`nof`,`ID_Barang`),
  CONSTRAINT `penjualan_rinci_ibfk_1` FOREIGN KEY (`nof`) REFERENCES `penjualan` (`NoFaktur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penjualan_rinci`
--

LOCK TABLES `penjualan_rinci` WRITE;
/*!40000 ALTER TABLE `penjualan_rinci` DISABLE KEYS */;
INSERT INTO `penjualan_rinci` VALUES ('TR0002','MK018','Nasi Saos Ambyar',1,10000,10000),('TR0002','MN007','Chocolate',1,7000,7000),('TR0002','PK006','Paket 6 (Nasi Ayam Geprek Bakar + Es Teh)',3,12000,36000);
/*!40000 ALTER TABLE `penjualan_rinci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(60) NOT NULL,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('kasierpro','21232f297a57a5a743894a0e4a801fc3','kelompok4');
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

-- Dump completed on 2024-07-08  7:37:10
