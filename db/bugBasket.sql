-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.23-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bugbasket
--

CREATE DATABASE IF NOT EXISTS bugbasket;
USE bugbasket;

--
-- Definition of table `bugd`
--

DROP TABLE IF EXISTS `bugd`;
CREATE TABLE `bugd` (
  `bugid` varchar(10) NOT NULL,
  `Title` varchar(300) NOT NULL,
  `bugdate` datetime NOT NULL,
  `lastmodified` datetime DEFAULT NULL,
  `creator` varchar(45) NOT NULL,
  `priority` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `actionby` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`bugid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bugd`
--

/*!40000 ALTER TABLE `bugd` DISABLE KEYS */;
INSERT INTO `bugd` (`bugid`,`Title`,`bugdate`,`lastmodified`,`creator`,`priority`,`status`,`actionby`) VALUES 
 ('Bug460008','[CZ][UART][WHCK] “DF - PNP Rebalance Request New Resources Device Test” Fails','2015-03-15 11:20:59',NULL,'Darshan UB','P0','closed',NULL),
 ('Bug460118','[Godavari] USB3.0 is not functioning when xHCI controller is set to AUTO in BIOS','2015-03-15 16:10:25',NULL,'Darshan UB','P1','Triaged','anamdev'),
 ('Bug460198','[CZ][WHCK][Win7] System goes to Non Responsive state while running PCIHCT test','2015-03-17 18:40:35',NULL,'Darshan UB','P2','implemented','Darshan UB'),
 ('Bug460294','[CZ][NXP NFC][Win7x64] \"System Sleep & PNP with I/O\" test fails','2015-03-17 22:45:55',NULL,'Darshan UB','P0','Closed',NULL),
 ('Bug460720','[CZ]SLED11 SP3 Chipset Drivers v4.5.1.001:Install script installs packages twice ','2015-03-17 10:45:55',NULL,'Darshan UB','P0','Need More Info - QA','Darshan UB'),
 ('Bug460768 ','[CZ]SLED11SP3:Hot-unplug of any USB speaker from 2.0 port results in system hang','2015-03-20 11:35:55',NULL,'Darshan UB','P0','Analyzed','anamdev'),
 ('Bug460881','[Automation]: CIM package needs modification for handling window title','2015-03-30 12:33:45',NULL,'anamdev','P1','open','Ritesh'),
 ('Bug460882','[Automation]: PSP Automation needs update for summary in notification email','2015-03-30 12:33:45',NULL,'anamdev','P1','open','Ritesh'),
 ('Bug460891','TestBug','2015-03-30 00:00:00',NULL,'anamdev','p0','open','anamdev'),
 ('Bug460892','[CZ] SLED 11SP3: Unable to trigger system wakeup from S4 via USB KB/Mice ','2015-03-21 10:45:55',NULL,'Darshan UB','P0','Implemented','Arul D'),
 ('Bug460899','[CZ]:SLED11SP3:ODD failsto automatically enter Zeropower mode after resume from S3','2015-03-22 23:45:55',NULL,'Darshan UB','P0','Analyzed','anamdev'),
 ('Bug462492','[CZ]:Unable to install SLED11SP3 OS when SATA Mode is set to \"Native IDE\"','2015-03-23 11:15:25',NULL,'Darshan UB','P1','implemented','Darshan UB'),
 ('Bug462858 ','[CZ] SLED 11 SP3 - Kernel panic message observed during system reboot','2015-03-24 11:15:25',NULL,'Darshan UB','P0','open','Arul D'),
 ('Bug469308','[CZ]:Ubuntu14.04/SLED11SP3:OS Resume from S3 takes longer duration than usual','2015-03-24 00:00:00',NULL,'Darshan UB','P1','Analyzed','anamdev'),
 ('Bug475315','[CZ]4 core operation requires disabling Speculative NB requests(c001_102a[8])','2015-03-24 00:00:00',NULL,'Darshan UB','P2','Need More Info - QA','Darshan UB'),
 ('Bug488710','[CZ]RedFlag/SLED reboots after Kernel Unpacking (Inactive)','2015-03-27 00:00:00',NULL,'Darshan UB','P0','Triaged','anamdev'),
 ('Bug488790','[CZ]TPM module is un-accessible from BIOS','2015-03-27 00:00:00',NULL,'Darshan UB','P1','open','Arul D');
/*!40000 ALTER TABLE `bugd` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
