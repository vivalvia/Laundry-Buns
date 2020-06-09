-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2020 at 04:18 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `laundry`
--

CREATE TABLE `laundry` (
  `Nama Pelanggan` varchar(50) NOT NULL,
  `Tgl Masuk Laundry` varchar(50) NOT NULL,
  `Jenis Laundry` varchar(50) NOT NULL,
  `Berat` varchar(50) NOT NULL,
  `Jenis Parfum` varchar(50) NOT NULL,
  `Tgl Pengembalian` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laundry`
--

INSERT INTO `laundry` (`Nama Pelanggan`, `Tgl Masuk Laundry`, `Jenis Laundry`, `Berat`, `Jenis Parfum`, `Tgl Pengembalian`) VALUES
('Raden', '11 Juni 2020', 'Sprei', '4kg', 'Soft', '15 Juni 2020'),
('vival', '10 Juni 2020', 'Cuci Kering', '1kg', 'Soft', '12 Juni 2020');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
