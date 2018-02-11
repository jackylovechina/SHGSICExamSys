/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : shgsic_exam

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-09-14 15:31:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contenttype
-- ----------------------------
DROP TABLE IF EXISTS `contenttype`;
CREATE TABLE `contenttype` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TypeName` (`TypeName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DepartmentName` (`DepartmentName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Role_ID` bigint(20) NOT NULL,
  `Dep_ID` bigint(20) NOT NULL,
  `Name` text NOT NULL,
  `Number` varchar(255) NOT NULL,
  `Sex` text NOT NULL,
  `Password` text NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Number` (`Number`),
  KEY `Role_ID` (`Role_ID`),
  KEY `Dep_ID` (`Dep_ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Role_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`Dep_ID`) REFERENCES `department` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for emp_score
-- ----------------------------
DROP TABLE IF EXISTS `emp_score`;
CREATE TABLE `emp_score` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Pap_Que_ID` bigint(20) DEFAULT NULL,
  `Emp_ID` bigint(20) DEFAULT NULL,
  `Score` int(11) NOT NULL,
  `Answer` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Emp_ID` (`Emp_ID`),
  KEY `Pap_Que_ID` (`Pap_Que_ID`),
  CONSTRAINT `emp_score_ibfk_1` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`ID`),
  CONSTRAINT `emp_score_ibfk_2` FOREIGN KEY (`Pap_Que_ID`) REFERENCES `paper_question` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ExamName` varchar(255) NOT NULL,
  `StartTime` datetime NOT NULL,
  `EndTime` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ExamName` (`ExamName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Exam_ID` bigint(20) DEFAULT NULL,
  `TotalScore` float NOT NULL,
  `SingleChoiceCount` int(11) NOT NULL,
  `MultiChoiceCount` int(11) NOT NULL,
  `BlankCount` int(11) NOT NULL,
  `JudgeCount` int(11) NOT NULL,
  `DescriptionCount` int(11) NOT NULL,
  `SingleChoiceValue` float NOT NULL,
  `MultiChoiceValue` float NOT NULL,
  `BlankValue` float NOT NULL,
  `JudgeValue` float NOT NULL,
  `DescriptionValue` float NOT NULL,
  `Name` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Exam_ID` (`Exam_ID`),
  CONSTRAINT `paper_ibfk_1` FOREIGN KEY (`Exam_ID`) REFERENCES `exam` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paper_question
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Pap_ID` bigint(20) DEFAULT NULL,
  `Que_ID` bigint(20) DEFAULT NULL,
  `Value` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Pap_ID` (`Pap_ID`),
  KEY `Que_ID` (`Que_ID`),
  CONSTRAINT `paper_question_ibfk_1` FOREIGN KEY (`Pap_ID`) REFERENCES `paper` (`ID`),
  CONSTRAINT `paper_question_ibfk_2` FOREIGN KEY (`Que_ID`) REFERENCES `question` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ConType_ID` bigint(20) DEFAULT NULL,
  `QueType_ID` bigint(20) DEFAULT NULL,
  `QuestionContent` text NOT NULL,
  `ChoiceA` text NOT NULL,
  `ChoiceB` text NOT NULL,
  `ChoiceC` text NOT NULL,
  `ChoiceD` text NOT NULL,
  `StandardAnswer` text NOT NULL,
  `Orderly` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ConType_ID` (`ConType_ID`),
  KEY `QueType_ID` (`QueType_ID`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`ConType_ID`) REFERENCES `contenttype` (`ID`),
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`QueType_ID`) REFERENCES `questiontype` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for questiontype
-- ----------------------------
DROP TABLE IF EXISTS `questiontype`;
CREATE TABLE `questiontype` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TypeName` (`TypeName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `RoleName` (`RoleName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
