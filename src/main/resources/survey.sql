/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50634
Source Host           : 127.0.0.1:3306
Source Database       : survey

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-10-20 18:00:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `answer_content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `answer_no` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8frr4bcabmmeyyu60qt7iiblo` (`question_id`),
  CONSTRAINT `FK8frr4bcabmmeyyu60qt7iiblo` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '1', '回答1', 'A');
INSERT INTO `answer` VALUES ('2', '2', '回答2', null);
INSERT INTO `answer` VALUES ('3', '1', '回答3', null);
INSERT INTO `answer` VALUES ('4', '3', '回答4', null);
INSERT INTO `answer` VALUES ('5', '2', '回答5', null);
INSERT INTO `answer` VALUES ('18', '9', '完全达到', null);
INSERT INTO `answer` VALUES ('19', '9', '基本达到', null);
INSERT INTO `answer` VALUES ('20', '9', '未达到', null);
INSERT INTO `answer` VALUES ('21', '9', '差距很大', null);
INSERT INTO `answer` VALUES ('23', '10', '基本达到', null);
INSERT INTO `answer` VALUES ('24', '10', '未达到', null);
INSERT INTO `answer` VALUES ('25', '10', '差距很大', null);
INSERT INTO `answer` VALUES ('26', '11', '知道', null);
INSERT INTO `answer` VALUES ('27', '11', '不知道', null);
INSERT INTO `answer` VALUES ('28', '12', '知道', null);
INSERT INTO `answer` VALUES ('29', '12', '不知道', null);
INSERT INTO `answer` VALUES ('30', '13', '完全达到', null);
INSERT INTO `answer` VALUES ('31', '13', '基本达到', null);
INSERT INTO `answer` VALUES ('32', '13', '未达到', null);
INSERT INTO `answer` VALUES ('33', '13', '差距很大', null);
INSERT INTO `answer` VALUES ('34', '14', '完全达到', null);
INSERT INTO `answer` VALUES ('35', '14', '基本达到', null);
INSERT INTO `answer` VALUES ('36', '14', '未达到', null);
INSERT INTO `answer` VALUES ('37', '14', '差距很大', null);
INSERT INTO `answer` VALUES ('38', '15', '知道', null);
INSERT INTO `answer` VALUES ('39', '15', '不知道', null);
INSERT INTO `answer` VALUES ('40', '16', '知道', null);
INSERT INTO `answer` VALUES ('41', '16', '不知道', null);

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '软件工程');
INSERT INTO `major` VALUES ('2', '计算机科学与技术');
INSERT INTO `major` VALUES ('3', '数字媒体技术');
INSERT INTO `major` VALUES ('4', '电子信息工程');
INSERT INTO `major` VALUES ('5', '物联网工程');
INSERT INTO `major` VALUES ('6', '通信工程');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `major_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'aa111', 'dsasa', '1');
INSERT INTO `manager` VALUES ('2', 'aa111', 'dsasa', '1');
INSERT INTO `manager` VALUES ('3', 'aa111', 'dsasa', '1');
INSERT INTO `manager` VALUES ('4', 'aaa', 'aaa', '1');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `major_id` int(255) DEFAULT NULL,
  `type` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '你好吗？', '1', '1');
INSERT INTO `question` VALUES ('2', 'how are you？', '1', '1');
INSERT INTO `question` VALUES ('3', 'where are you?', '2', '2');
INSERT INTO `question` VALUES ('9', '问题1', '1', '1');
INSERT INTO `question` VALUES ('10', '问题2', '1', '1');
INSERT INTO `question` VALUES ('11', '你为什么要自定义问题啊', '1', '1');
INSERT INTO `question` VALUES ('12', '你为什么要自定义问题2', '1', '1');
INSERT INTO `question` VALUES ('13', '问题1', '1', '1');
INSERT INTO `question` VALUES ('14', '问题2', '1', '1');
INSERT INTO `question` VALUES ('15', '你为什么要自定义问题啊', '1', '1');
INSERT INTO `question` VALUES ('16', '你为什么要自定义问题2', '1', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `major_id` int(255) DEFAULT NULL,
  `klasse` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `answered` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for stu_ans
-- ----------------------------
DROP TABLE IF EXISTS `stu_ans`;
CREATE TABLE `stu_ans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of stu_ans
-- ----------------------------
INSERT INTO `stu_ans` VALUES ('1', '1', '1', '2');
INSERT INTO `stu_ans` VALUES ('2', '1', '3', '4');

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `suggestion_content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4eg7s7y5ppv2c70fc0wijolxp` (`student_id`),
  CONSTRAINT `FK4eg7s7y5ppv2c70fc0wijolxp` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES ('5', '1', 'sadasdasd');
