-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2020 at 03:36 PM
-- Server version: 10.1.25-MariaDB
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
-- Database: `sispakar`
--

-- --------------------------------------------------------

--
-- Table structure for table `isi`
--

CREATE TABLE `isi` (
  `id` int(10) NOT NULL,
  `gejala` char(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isi`
--

INSERT INTO `isi` (`id`, `gejala`) VALUES
(1, 'kabel belum terpasang'),
(2, 'UPS atau stabilizer belum dihidupkan'),
(3, 'Kabel power putus'),
(4, 'Power suplay rusak'),
(5, 'Kabel VGA atau kendor pemasangannya'),
(6, 'Memori rusak'),
(7, 'Arus pada power suplay tidak memadai'),
(8, 'CPU terlalu panas'),
(9, 'Kapasitas memori tidak memadai'),
(10, 'Memori rusak'),
(11, 'Kerusakan pada program atau sistem'),
(12, 'Virus'),
(13, 'Keyboard belum terpasang dengan\r\nbenar'),
(14, 'Keyboard rusak'),
(15, 'Sistem tidak mengenali penambahan hardware'),
(16, 'Port yang rusak'),
(17, 'Baterai CMOS sudah tidak berfungsi dengan baik'),
(18, 'RAM tidak kompitabel dengan motherboard'),
(19, 'RAM mungkin rusak'),
(20, 'Kabel power belum terpasang'),
(21, 'Kabel VGA belum terpasang'),
(22, 'VGA card rusak'),
(23, 'Flasdisk belum terpasang dengan benar'),
(24, 'Flasdisk rusak'),
(25, 'Port yang rusak'),
(26, 'Mouse belum terpasang dengan benar'),
(27, 'Mouse rusak'),
(28, 'Port yang rusak'),
(29, 'Suhu pada VGA card panas'),
(30, 'Fan VGA card tidak hidup');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `isi`
--
ALTER TABLE `isi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `isi`
--
ALTER TABLE `isi`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
