CREATE DATABASE `whtsondb` /*!40100 DEFAULT CHARACTER SET utf8 */;
use `whtsondb`
CREATE TABLE `employee` (
  `personnumber` varchar(20) DEFAULT NULL,
  `forename` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  UNIQUE KEY `personnumber_UNIQUE` (`personnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `log` (
  `personnumber` varchar(20) DEFAULT NULL,
  `visitorname` varchar(45) DEFAULT NULL,
  `hostID` varchar(20) DEFAULT NULL,
  `entrytime` varchar(255) DEFAULT NULL,
  `exittime` varchar(255) NOT NULL DEFAULT '0',
  UNIQUE KEY `index` (`personnumber`,`exittime`),
  UNIQUE KEY `index2` (`visitorname`,`hostID`,`exittime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `whtsondb`.`employee`
(`personnumber`,`forename`,`lastname`)
VALUES
("9401202495","lohith","gogineni");
INSERT INTO `whtsondb`.`employee`
(`personnumber`,`forename`,`lastname`)
VALUES
("1234567890","tim","tim");