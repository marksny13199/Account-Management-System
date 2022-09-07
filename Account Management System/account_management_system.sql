-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2020 at 05:34 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `account_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `test_database`
--

CREATE TABLE `test_database` (
  `Entry number` int(11) NOT NULL,
  `field 1` varchar(50) NOT NULL,
  `field 2` varchar(50) NOT NULL,
  `field 3` varchar(50) NOT NULL,
  `field 4` varchar(50) NOT NULL,
  `field 5` varchar(50) NOT NULL,
  `field 6` varchar(50) NOT NULL,
  `field 7` varchar(50) NOT NULL,
  `field 8` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_database`
--

INSERT INTO `test_database` (`Entry number`, `field 1`, `field 2`, `field 3`, `field 4`, `field 5`, `field 6`, `field 7`, `field 8`) VALUES
(1, 'data1', 'data2', 'data3', 'data4', 'data5', 'data6', 'data7', 'data8');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `test_database`
--
ALTER TABLE `test_database`
  ADD PRIMARY KEY (`Entry number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `test_database`
--
ALTER TABLE `test_database`
  MODIFY `Entry number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
