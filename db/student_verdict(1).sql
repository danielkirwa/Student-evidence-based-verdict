-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 18, 2022 at 11:27 AM
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

--
-- Dumping data for table `evidence`
--

INSERT INTO `evidence` (`evidenceID`, `evidencetype`, `evidencedescription`, `evidencemedia`, `evidencedocument`, `violationID`, `studentREG`, `evidenceDOA`) VALUES
(1, 'Media', 'Caputred photage', '', 'CCTV ', 2, 'BIT/0010/18', '2021-11-26'),
(2, '456yui', 'drfghj', '', 'fghjk', 2, 'COM/0542/33', '2021-11-27'),
(3, 'photo', 'wsedfghjik', 'C:ProjectsStudentVerdictimages/potrait.png', 'esrtyuiouydfgh', 2, 'BIT/0010/18', '2021-12-16'),
(4, 'photo', 'srtyui', 'C:ProjectsStudentVerdictimages/studentavatar.png', 'dfghjk', 2, 'BIT/0001/20', '2021-12-02'),
(5, 'photo', 'dfgh', 'C:ProjectsStudentVerdictimages/studentavatar.png', 'dfghj', 3, 'BIT/0001/20', '2021-12-16'),
(6, 'exam irregularities', '', 'C:ProjectsStudentVerdictimages/studentavatar.png', 'copyimg in exams', 2, 'BIT/0001/20', '2022-09-12');

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

--
-- Dumping data for table `judgement`
--

INSERT INTO `judgement` (`judgementID`, `judgementtype`, `judgementdescription`, `addeddate`) VALUES
(1, 'Suspension', '1 academic year', '2021-11-26'),
(2, 'suspesion', 'suspension 1 acdemic year', '2021-12-16');

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
(1, 'BIT/0001/20');

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
(2, 'frank', 'erty', 23456, 'MALE', 345678, 'weeee@gmail.com', '1991-12-19', 'Admin', 'images/studentavatar.png'),
(3, 'ty', 'sdfg', 23456, 'FEMALE', 123456, 'ert', '2021-12-16', 'Admin', 'images/studentavatar.png'),
(4, 'sdf', 'asdfgh', 123456, 'FEMALE', 12345, 'sdfg', '2021-12-16', 'Admin', 'images/studentavatar.png'),
(5, 'brian', 'brien', 36785954, 'MALE', 748849881, 'emomugebrian@gmail.com', '1998-09-11', 'Admin', 'images/studentavatar.png'),
(123, 'Jane', 'Marry', 12, 'FEMALE', 787654321, 'janemary@gmail.com', '2021-11-17', 'Judge', 'images/studentavatar.png');

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

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentREG`, `studentsurname`, `studentothername`, `studentIDnumber`, `studentphone`, `studentemail`, `studentgender`, `studentDOB`, `studentimage`) VALUES
('BCH/0001/20', 'sdfgh', 'sdfgh', 57890677, 74323456, 'bch@gmail.com', 'MALE', '1999-12-08', 'images/studentavatar.png'),
('BIT/0001/20', 'erick', 'mark', 36785953, 748849881, 'abnd@gmail.com', 'MALE', '2000-12-07', 'images/studentavatar.png'),
('BIT/0001/22', 'Ben', 'Benson', 123456, 789562314, 'benson@gmail.com', 'MALE', '1998-01-09', 'C:ProjectsStudentVerdictimages/potrait.png'),
('BIT/0010/18', 'Daniel', 'Kipchirchir kirwa', 12345678, 79876543, 'kirwa@gmail.com', 'MALE', '1997-11-21', 'images/studentavatar.png'),
('BIT/0033/33', 'sad', 'asdf', 2345, 2345678, 'sfgg@gmail.com', 'FEMALE', '2021-11-29', 'images/studentavatar.png'),
('COM/0542/33', 'asd', 'asdc', 12345, 7895432, 'asdfvb@gmail.com', 'FEMALE', '2021-11-26', 'images/studentavatar.png');

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
('emomugebrian@gmail.com', '5f4dcc3b5aa765d61d8327deb882cf99', 'Admin'),
('username', '5f4dcc3b5aa765d61d8327deb882cf99', 'Admin'),
('username1', '7c6a180b36896a0a8c02787eeafb0e4c', 'Admin');

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

--
-- Dumping data for table `verdict`
--

INSERT INTO `verdict` (`verdictID`, `violationID`, `studentREG`, `verdictDOV`, `staffID`) VALUES
(1, 2, 'COM/0542/33', '2021-11-26', 123),
(2, 2, 'BIT/0010/18', '2021-11-27', 123),
(3, 2, 'COM/0542/33', '2021-12-16', 4),
(4, 2, 'bit/0001/20', '2021-12-07', 2),
(5, 2, 'BIT/0001/20', '2022-09-12', 5);

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
-- Dumping data for table `violation`
--

INSERT INTO `violation` (`violationID`, `violationtype`, `violationDOA`, `violationdescription`, `judgementID`, `violationname`) VALUES
(2, 'Case A', '2021-11-26', 'Exam copping', 1, 'Exam'),
(3, 'exams', '2021-12-02', 'asdfgh', 1, 'copying');

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
