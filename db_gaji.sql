-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2021 at 06:30 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gaji`
--

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `nama` varchar(100) NOT NULL,
  `no_pegawai` int(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `jabatan` char(100) NOT NULL,
  `jumlah_hari_kerja` int(2) NOT NULL,
  `gaji_pokok` int(100) NOT NULL,
  `potongan_gaji` int(100) NOT NULL,
  `total_gaji` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`nama`, `no_pegawai`, `email`, `jabatan`, `jumlah_hari_kerja`, `gaji_pokok`, `potongan_gaji`, `total_gaji`) VALUES
('Choi', 2006, 'choiung@yahoo.co.id', 'Cleaning Service', 15, 3000000, 1500000, 1500000),
('Asnawi', 2009, 'asnawi9090@gmail.com', 'Direktur Utama', 29, 12000000, 100000, 11900000),
('Shin', 2223, 'shintaeyong12@gmail.com', 'Direktur Utama', 30, 12000000, 0, 12000000),
('Arhan', 2299, 'arhan552gmail.co.id', 'Bagian Produksi', 30, 5000000, 0, 5000000),
('Ernando', 2664, 'ernandoo@yahoo.com', 'Bagian Produksi', 20, 5000000, 1000000, 4000000),
('Nadeo', 2735, 'nadeoo@yahoo.com', 'Direktur Keuangan', 28, 10000000, 200000, 9800000),
('Elkan Baggot', 2011522026, 'elkan123@yahoo.com', 'Manajer Pemasaran', 29, 8000000, 100000, 7900000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`no_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
