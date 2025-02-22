-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 19, 2021 at 10:35 PM
-- Server version: 8.0.23-0ubuntu0.20.04.1
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `GeoCaches`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cache`
--

CREATE TABLE `Cache` (
  `idCache` char(36) NOT NULL,
  `GPS` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `type` enum('traditionnelle','piste','objet','voyageur') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nature` enum('physique','virtuelle') NOT NULL,
  `etat` enum('active','activation','fermee','suspendue') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Utilisateur_idUtilisateur` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `idUtilisateur` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login` varchar(45) NOT NULL,
  `photo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Visite`
--

CREATE TABLE `Visite` (
  `idVisite` char(36) NOT NULL,
  `date` date NOT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `decouverte` int NOT NULL DEFAULT '0',
  `commentaire` varchar(1000) DEFAULT NULL,
  `Utilisateur_idUtilisateur` char(36) NOT NULL,
  `Cache_idCache` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cache`
--
ALTER TABLE `Cache`
  ADD PRIMARY KEY (`idCache`),
  ADD KEY `fk_Cache_Utilisateur1_idx` (`Utilisateur_idUtilisateur`);

--
-- Indexes for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- Indexes for table `Visite`
--
ALTER TABLE `Visite`
  ADD PRIMARY KEY (`idVisite`),
  ADD KEY `fk_Visite_Utilisateur_idx` (`Utilisateur_idUtilisateur`),
  ADD KEY `fk_Visite_Cache1_idx` (`Cache_idCache`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Cache`
--
ALTER TABLE `Cache`
  ADD CONSTRAINT `fk_Cache_Utilisateur1` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE;

--
-- Constraints for table `Visite`
--
ALTER TABLE `Visite`
  ADD CONSTRAINT `fk_Visite_Cache1` FOREIGN KEY (`Cache_idCache`) REFERENCES `Cache` (`idCache`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_Visite_Utilisateur` FOREIGN KEY (`Utilisateur_idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
