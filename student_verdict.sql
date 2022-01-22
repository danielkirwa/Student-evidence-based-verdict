-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 17, 2021 at 09:09 AM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `student_verdict`
--

-- --------------------------------------------------------

--
-- Table structure for table `evidence`
--

CREATE TABLE IF NOT EXISTS `evidence` (
  `evidenceID` int(3) NOT NULL,
  `evidencetype` varchar(30) NOT NULL,
  `evidencedescription` varchar(50) NOT NULL,
  `evidencemedia` varchar(256) NOT NULL,
  `evidencedocument` varchar(256) NOT NULL,
  `violationID` int(3) NOT NULL,
  `studentREG` varchar(12) NOT NULL,
  `evidenceDOA` date NOT NULL,
  PRIMARY KEY (`evidenceID`),
  KEY `fk-evidence-student` (`studentREG`),
  KEY `fk-evidence-violation` (`violationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `judgement`
--

CREATE TABLE IF NOT EXISTS `judgement` (
  `judgementID` int(3) NOT NULL,
  `judgementtype` varchar(30) NOT NULL,
  `judgementdescription` varchar(50) NOT NULL,
  `addeddate` date NOT NULL,
  PRIMARY KEY (`judgementID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `search`
--

CREATE TABLE IF NOT EXISTS `search` (
  `searchid` int(1) NOT NULL,
  `searchitem` varchar(250) NOT NULL,
  PRIMARY KEY (`searchid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 MAX_ROWS=1;

--
-- Dumping data for table `search`
--

INSERT INTO `search` (`searchid`, `searchitem`) VALUES
(1, 'BIT/0034/18');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `staffID` int(3) NOT NULL,
  `staffsurname` varchar(30) NOT NULL,
  `staffothername` varchar(30) NOT NULL,
  `staffIDnumber` int(10) NOT NULL,
  `staffgender` varchar(6) NOT NULL,
  `staffphone` int(10) NOT NULL,
  `staffemail` varchar(50) NOT NULL,
  `staffDOB` date NOT NULL,
  `staffrole` varchar(30) NOT NULL,
  `staffimage` varchar(256) NOT NULL,
  PRIMARY KEY (`staffID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `staffsurname`, `staffothername`, `staffIDnumber`, `staffgender`, `staffphone`, `staffemail`, `staffDOB`, `staffrole`, `staffimage`) VALUES
(123, 'Jane', 'Marry', 12345676, 'FEMALE', 787654321, 'janemary@gmail.com', '2021-11-17', 'Judge', 'images/studentavatar.png');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `studentREG` varchar(12) NOT NULL,
  `studentsurname` varchar(30) NOT NULL,
  `studentothername` varchar(30) NOT NULL,
  `studentIDnumber` int(10) NOT NULL,
  `studentphone` int(10) NOT NULL,
  `studentemail` varchar(50) NOT NULL,
  `studentgender` varchar(6) NOT NULL,
  `studentDOB` date NOT NULL,
  `studentimage` varchar(256) NOT NULL,
  PRIMARY KEY (`studentREG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userusername` varchar(30) NOT NULL,
  `userpassword` varchar(62) NOT NULL,
  `userprivilege` varchar(30) NOT NULL,
  PRIMARY KEY (`userusername`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userusername`, `userpassword`, `userprivilege`) VALUES
('username', '5f4dcc3b5aa765d61d8327deb882cf99', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `verdict`
--

CREATE TABLE IF NOT EXISTS `verdict` (
  `verdictID` int(3) NOT NULL,
  `violationID` int(3) NOT NULL,
  `studentREG` varchar(12) NOT NULL,
  `verdictDOV` date NOT NULL,
  `staffID` int(3) NOT NULL,
  PRIMARY KEY (`verdictID`),
  KEY `fk-verdict-violation` (`violationID`),
  KEY `fk-verdict-student` (`studentREG`),
  KEY `fk-verdict-staff` (`staffID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `violation`
--

CREATE TABLE IF NOT EXISTS `violation` (
  `violationID` int(3) NOT NULL,
  `violationtype` varchar(30) NOT NULL,
  `violationDOA` date NOT NULL,
  `violationdescription` varchar(50) NOT NULL,
  `judgementID` int(3) NOT NULL,
  `violationname` varchar(50) NOT NULL,
  PRIMARY KEY (`violationID`),
  KEY `fk-violation-judgement` (`judgementID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `evidence`
--
ALTER TABLE `evidence`
  ADD CONSTRAINT `fk-evidence-student` FOREIGN KEY (`studentREG`) REFERENCES `student` (`studentREG`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk-evidence-violation` FOREIGN KEY (`violationID`) REFERENCES `violation` (`violationID`) ON UPDATE CASCADE;

--
-- Constraints for table `verdict`
--
ALTER TABLE `verdict`
  ADD CONSTRAINT `fk-verdict-staff` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk-verdict-student` FOREIGN KEY (`studentREG`) REFERENCES `student` (`studentREG`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk-verdict-violation` FOREIGN KEY (`violationID`) REFERENCES `violation` (`violationID`) ON UPDATE CASCADE;

--
-- Constraints for table `violation`
--
ALTER TABLE `violation`
  ADD CONSTRAINT `fk-violation-judgement` FOREIGN KEY (`judgementID`) REFERENCES `judgement` (`judgementID`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
