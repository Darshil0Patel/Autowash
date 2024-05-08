-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2022 at 07:31 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edustage`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(100) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(100) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `sid` int(100) NOT NULL,
  `erno` varchar(100) NOT NULL,
  `college` varchar(100) NOT NULL,
  `year` int(100) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `present` varchar(50) NOT NULL,
  `absent` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `date`, `time`, `fname`, `lname`, `sid`, `erno`, `college`, `year`, `branch`, `subject`, `present`, `absent`) VALUES
(13, '2022-02-03', '08:45:50', 'Darshil', 'Patel', 1, '190770107135', 'socet', 3, 'cs', 'CN', 'no', 'yes'),
(15, '2022-01-25', '03:20:17', 'Darshil', 'Patel', 1, '190770107135', 'socet', 3, 'cs', 'ADA', 'yes', 'no'),
(16, '2022-02-02', '19:53:51', 'Ashok', 'Kumar', 4, '190770107134', 'socet', 3, 'cs', 'SE', 'yes', 'no'),
(17, '2022-02-03', '09:08:39', 'Ashok', 'Kumar', 4, '190770107134', 'socet', 3, 'cs', 'CN', 'yes', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(50) NOT NULL,
  `question` varchar(300) NOT NULL,
  `answer` varchar(300) NOT NULL,
  `option1` varchar(300) NOT NULL,
  `option2` varchar(300) NOT NULL,
  `option3` varchar(300) NOT NULL,
  `option4` varchar(300) NOT NULL,
  `date` datetime(6) NOT NULL,
  `college` varchar(50) NOT NULL,
  `year` int(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `positivemarks` varchar(50) NOT NULL,
  `negativemarks` varchar(50) NOT NULL,
  `examtype` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id`, `question`, `answer`, `option1`, `option2`, `option3`, `option4`, `date`, `college`, `year`, `subject`, `positivemarks`, `negativemarks`, `examtype`) VALUES
(5, ' Which of the following option leads to the portability and security of Java?', 'Bytecode is executed by JVM', 'Bytecode is executed by JVM', 'The applet makes the Java code secure and portable', 'Use of exception handling', 'Dynamic binding between objects', '2022-01-29 19:36:00.000000', 'socet', 3, 'CN', '2', '-0.5', 'classtest'),
(6, 'Which of the following is not a Java features?', 'Use of pointers', 'Dynamic', 'Architecture Neutral', 'Use of pointers', 'Object-oriented', '2022-01-29 19:36:00.000000', 'socet', 3, 'CN', '2', '-0.5', 'classtest'),
(7, ' _____ is used to find and fix bugs in the Java programs.', 'JDB', 'JVM', 'JRE', 'JDK', 'JDB', '2022-01-29 19:36:00.000000', 'socet', 3, 'CN', '2', '-0.5', 'classtest'),
(8, 'Which of the following is a valid declaration of a char?', 'char ch = \'\\utea\';', 'char ch = \'\\utea\';', 'char ca = \'tea\';', 'char cr = \\u0223;', 'char cc = \'\\itea\';', '2022-01-29 19:36:00.000000', 'socet', 3, 'CN', '2', '-0.5', 'classtest');

-- --------------------------------------------------------

--
-- Table structure for table `examdetail`
--

CREATE TABLE `examdetail` (
  `id` int(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `college` varchar(50) NOT NULL,
  `year` int(50) NOT NULL,
  `date` datetime(6) NOT NULL,
  `duration` varchar(50) NOT NULL,
  `maxmarks` int(50) NOT NULL,
  `examtype` varchar(50) NOT NULL,
  `enable` varchar(50) NOT NULL DEFAULT 'no'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examdetail`
--

INSERT INTO `examdetail` (`id`, `subject`, `college`, `year`, `date`, `duration`, `maxmarks`, `examtype`, `enable`) VALUES
(1, 'CN', 'socet', 3, '2022-01-30 10:00:00.000000', '0.5', 12, 'classtest', 'yes'),
(8, 'CN', 'socet', 3, '2022-01-31 22:30:00.000000', '2', 30, 'midexam', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `examresponse`
--

CREATE TABLE `examresponse` (
  `id` int(50) NOT NULL,
  `sid` int(50) NOT NULL,
  `qid` int(50) NOT NULL,
  `erno` varchar(50) NOT NULL,
  `college` varchar(50) NOT NULL,
  `year` int(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `correctanswer` varchar(100) NOT NULL,
  `studentanswer` varchar(100) NOT NULL,
  `positivemarks` int(50) NOT NULL,
  `negativemarks` varchar(50) NOT NULL,
  `date` datetime(6) NOT NULL,
  `examtype` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `examresponse`
--

INSERT INTO `examresponse` (`id`, `sid`, `qid`, `erno`, `college`, `year`, `subject`, `correctanswer`, `studentanswer`, `positivemarks`, `negativemarks`, `date`, `examtype`) VALUES
(10, 1, 5, '190770107135', 'socet', 3, 'CN', 'Bytecode', 'Bytecode', 2, '-0.5', '2022-01-29 00:00:00.000000', 'classtest'),
(11, 1, 6, '190770107135', 'socet', 3, 'CN', 'Use', 'Use', 2, '-0.5', '2022-01-29 00:00:00.000000', 'classtest');

-- --------------------------------------------------------

--
-- Table structure for table `file`
--

CREATE TABLE `file` (
  `id` int(50) NOT NULL,
  `instructorid` int(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `filename` varchar(300) NOT NULL,
  `path` varchar(300) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `year` int(50) NOT NULL,
  `college` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `file`
--

INSERT INTO `file` (`id`, `instructorid`, `name`, `filename`, `path`, `subject`, `year`, `college`) VALUES
(7, 1, 'Syllabus', '3150710.pdf', 'C:\\Users\\HP\\eclipse-workspace\\EducationSite\\WebContent\\files', 'CN', 3, 'socet'),
(8, 1, 'Book', 'Computer_Networking_A_Top-Down_Approach.pdf', 'C:\\Users\\HP\\eclipse-workspace\\EducationSite\\WebContent\\files', 'CN', 3, 'socet'),
(9, 3, 'Syllabus_asoit', '3150710.pdf', 'C:\\Users\\HP\\eclipse-workspace\\EducationSite\\WebContent\\files', 'CN', 3, 'asoit'),
(13, 4, 'Notes', 'Darshan-ADA.pdf', 'C:\\Users\\HP\\eclipse-workspace\\EducationSite\\WebContent\\files', 'ADA', 3, 'socet');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `id` int(100) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `uid` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `college` varchar(50) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `year` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`id`, `fname`, `lname`, `uid`, `email`, `contact`, `college`, `subject`, `password`, `year`) VALUES
(1, 'Trupesh', 'Patel', 'P101', 't@gmail.com', '8443323433', 'socet', 'CN', 'trupesh@123', 3),
(3, 'Joy', 'Pathak', 'P102', 'joy@gmail.com', '8745763446', 'asoit', 'CN', 'joy@123', 3),
(4, 'Mansi', 'Dave', 'P103', 'mansi@gmail.com', '7548747363', 'socet', 'ADA', 'mansi@123', 3),
(6, 'Monali', 'Suthar', 'P104', 'monali@gmail.com', '7635523532', 'asoit', 'SE', 'monali@123', 3);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(100) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `erno` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `college` varchar(50) NOT NULL,
  `year` int(50) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `fname`, `lname`, `erno`, `email`, `contact`, `college`, `year`, `branch`, `password`) VALUES
(1, 'Darshil', 'Patel', '190770107135', 'd@gmail.com', '9723142525', 'socet', 3, 'cs', 'darshil@123'),
(4, 'Ashok', 'Kumar', '190770107134', 'a@gmail.com', '9723114323', 'socet', 3, 'cs', 'ashok@123');

-- --------------------------------------------------------

--
-- Table structure for table `video`
--

CREATE TABLE `video` (
  `id` int(100) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `uid` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `college` varchar(100) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `videolink` varchar(50) NOT NULL,
  `year` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `video`
--

INSERT INTO `video` (`id`, `fname`, `lname`, `uid`, `email`, `contact`, `college`, `subject`, `password`, `videolink`, `year`) VALUES
(5, 'Trupesh', 'Patel', 'P101', 't@gmail.com', '8443323433', 'socet', 'CN', 'trupesh@123', 'https://youtu.be/JFF2vJaN0Cw', 3),
(6, 'Trupesh', 'Patel', 'P101', 't@gmail.com', '8443323433', 'socet', 'CN', 'trupesh@123', 'https://youtu.be/4D55Cmj2t-A', 3),
(7, 'Trupesh', 'Patel', 'P101', 't@gmail.com', '8443323433', 'socet', 'CN', 'trupesh@123', 'https://youtu.be/GfaHdjApnhU', 3),
(8, 'Joy', 'Pathak', 'P102', 'joy@gmail.com', '8745763446', 'asoit', 'CN', 'joy@123', 'https://youtu.be/YxyLN3N5w9s', 3),
(9, 'Joy', 'Pathak', 'P102', 'joy@gmail.com', '8745763446', 'asoit', 'CN', 'joy@123', 'https://youtu.be/YxyLN3N5w9s', 3),
(10, 'Joy', 'Pathak', 'P102', 'joy@gmail.com', '8745763446', 'asoit', 'CN', 'joy@123', 'https://youtu.be/3N5a9cHYzCM', 3),
(12, 'Mansi', 'Dave', 'P103', 'mansi@gmail.com', '7548747363', 'socet', 'ADA', 'mansi@123', 'https://youtu.be/u8JZ9gU5o4g', 3),
(13, 'Mansi', 'Dave', 'P103', 'mansi@gmail.com', '7548747363', 'socet', 'ADA', 'mansi@123', 'https://youtu.be/itbkP50iggM', 3),
(14, 'Mansi', 'Dave', 'P103', 'mansi@gmail.com', '7548747363', 'socet', 'ADA', 'mansi@123', 'https://youtu.be/7dz8Iaf_weM', 3),
(15, 'Mansi', 'Dave', 'P103', 'mansi@gmail.com', '7548747363', 'socet', 'ADA', 'mansi@123', 'https://youtu.be/OLttwv_4Ltw', 3),
(16, 'Monali', 'Suthar', 'P104', 'monali@gmail.com', '7837821433', 'asoit', 'SE', 'monali@123', 'https://youtu.be/uJpQlyT_CK4', 3),
(17, 'Monali', 'Suthar', 'P104', 'monali@gmail.com', '7837821433', 'asoit', 'SE', 'monali@123', 'https://youtu.be/kcvEiMFOcoE', 3),
(19, 'Monali', 'Suthar', 'P104', 'monali@gmail.com', '7837821433', 'asoit', 'SE', 'monali@123', 'https://youtu.be/vl-IWe0DkwU', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `examdetail`
--
ALTER TABLE `examdetail`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `examresponse`
--
ALTER TABLE `examresponse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `qid` (`qid`),
  ADD KEY `sid` (`sid`);

--
-- Indexes for table `file`
--
ALTER TABLE `file`
  ADD PRIMARY KEY (`id`),
  ADD KEY `instructorid` (`instructorid`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `video`
--
ALTER TABLE `video`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `examdetail`
--
ALTER TABLE `examdetail`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `examresponse`
--
ALTER TABLE `examresponse`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `file`
--
ALTER TABLE `file`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `instructor`
--
ALTER TABLE `instructor`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `video`
--
ALTER TABLE `video`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `examresponse`
--
ALTER TABLE `examresponse`
  ADD CONSTRAINT `examresponse_ibfk_1` FOREIGN KEY (`qid`) REFERENCES `exam` (`id`),
  ADD CONSTRAINT `examresponse_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`id`);

--
-- Constraints for table `file`
--
ALTER TABLE `file`
  ADD CONSTRAINT `file_ibfk_1` FOREIGN KEY (`instructorid`) REFERENCES `instructor` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
