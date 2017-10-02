-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 29, 2017 at 06:51 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farms`
--
CREATE DATABASE IF NOT EXISTS `farms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `farms`;

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `foodEated` int(11) NOT NULL,
  `farm_address` varchar(50) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `animal_farm_address` (`farm_address`),
  KEY `animal_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`id_animal`, `foodEated`, `farm_address`, `type`) VALUES
(1, 22, '650 rue guyart', 'type2'),
(2, 33, 'aaaaaaaa33321323', 'type1'),
(3, 0, 'test11', 'type1');

-- --------------------------------------------------------

--
-- Table structure for table `animal_type`
--

DROP TABLE IF EXISTS `animal_type`;
CREATE TABLE IF NOT EXISTS `animal_type` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `animal_type`
--

INSERT INTO `animal_type` (`name`) VALUES
('type1'),
('type2');

-- --------------------------------------------------------

--
-- Table structure for table `farm`
--

DROP TABLE IF EXISTS `farm`;
CREATE TABLE IF NOT EXISTS `farm` (
  `address` varchar(50) NOT NULL,
  `farmer_name` varchar(30) NOT NULL,
  PRIMARY KEY (`address`),
  UNIQUE KEY `farm_farmer_name` (`farmer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farm`
--

INSERT INTO `farm` (`address`, `farmer_name`) VALUES
('atest3', 'atesttt3'),
('650 rue guyart', 'dfsf'),
('fret', 'erter'),
('rwerwer ', 'fsdfsf'),
('sdf', 'sdf'),
('test11', 'test11'),
('sdfs', 'Test3'),
('aaaaaaaa33321323', 'Test4'),
('aaaa', 'Test5'),
('test5', 'test55'),
('TESTSAVE', 'TESTSAVE'),
('TESTSAVE2', 'TESTSAVE2');

-- --------------------------------------------------------

--
-- Table structure for table `farmer`
--

DROP TABLE IF EXISTS `farmer`;
CREATE TABLE IF NOT EXISTS `farmer` (
  `name` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmer`
--

INSERT INTO `farmer` (`name`, `age`) VALUES
('atesttt3', 3),
('dfsf', 32),
('erter', 55),
('fsdfsf', 2),
('sdf', 3),
('Tes2', 2),
('Test1', 1),
('test11', 11),
('Test3', 3),
('Test4', 4),
('Test5', 5),
('test55', 5),
('Test6', 7),
('TESTSAVE', 100),
('TESTSAVE2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
CREATE TABLE IF NOT EXISTS `food` (
  `id_food` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `food_type_name` varchar(30) NOT NULL,
  `id_animal` int(11) NOT NULL,
  PRIMARY KEY (`id_food`),
  KEY `food_food_type` (`food_type_name`),
  KEY `food_animal` (`id_animal`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id_food`, `quantity`, `food_type_name`, `id_animal`) VALUES
(1, 22, 'typeA', 2),
(2, 33, 'typeB', 2),
(3, 11, 'typeA', 3);

-- --------------------------------------------------------

--
-- Table structure for table `food_type`
--

DROP TABLE IF EXISTS `food_type`;
CREATE TABLE IF NOT EXISTS `food_type` (
  `name` varchar(30) NOT NULL,
  `nutritionalValue` varchar(30) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_type`
--

INSERT INTO `food_type` (`name`, `nutritionalValue`) VALUES
('typeA', '666'),
('typeB', '999');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `fk_animal_farm_address` FOREIGN KEY (`farm_address`) REFERENCES `farm` (`address`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_animal_type` FOREIGN KEY (`type`) REFERENCES `animal_type` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `farm`
--
ALTER TABLE `farm`
  ADD CONSTRAINT `fk_farm_farmer_name` FOREIGN KEY (`farmer_name`) REFERENCES `farmer` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `fk_food_animal` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_food_food_type` FOREIGN KEY (`food_type_name`) REFERENCES `food_type` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
