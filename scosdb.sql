/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : scosdb

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-11-12 21:57:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `coldfood`
-- ----------------------------
DROP TABLE IF EXISTS `coldfood`;
CREATE TABLE `coldfood` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `foodCategory` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodPrice` int(10) NOT NULL,
  `foodStackNum` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of coldfood
-- ----------------------------
INSERT INTO `coldfood` VALUES ('1', '凉菜', '凉拌黄瓜', '6', '100');
INSERT INTO `coldfood` VALUES ('2', '凉菜', '凉皮', '11', '200');

-- ----------------------------
-- Table structure for `hotfood`
-- ----------------------------
DROP TABLE IF EXISTS `hotfood`;
CREATE TABLE `hotfood` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `foodCategory` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodPrice` int(10) NOT NULL,
  `foodStackNum` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hotfood
-- ----------------------------
INSERT INTO `hotfood` VALUES ('1', '热菜', '炒黄瓜', '10', '100');
INSERT INTO `hotfood` VALUES ('2', '热菜', '炒冬瓜', '10', '100');
INSERT INTO `hotfood` VALUES ('3', '热菜', '炒南瓜', '8', '100');

-- ----------------------------
-- Table structure for `seafood`
-- ----------------------------
DROP TABLE IF EXISTS `seafood`;
CREATE TABLE `seafood` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `foodCategory` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodPrice` int(10) NOT NULL,
  `foodStackNum` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seafood
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'liu', '1234');
INSERT INTO `user` VALUES ('6', 'lfx', '1234');
INSERT INTO `user` VALUES ('7', 'du', '1234');
INSERT INTO `user` VALUES ('8', 'fu', '1234');
INSERT INTO `user` VALUES ('9', 'xiang', '1234');
INSERT INTO `user` VALUES ('10', 'lf', '1234');
INSERT INTO `user` VALUES ('11', 'iu', '1234');
INSERT INTO `user` VALUES ('12', 'yu', 'qwe');
INSERT INTO `user` VALUES ('13', 'liuf', '1234');
INSERT INTO `user` VALUES ('14', 'ty', '1234');
INSERT INTO `user` VALUES ('15', 'Op', 'qwe');
INSERT INTO `user` VALUES ('16', 'io', '1234');
INSERT INTO `user` VALUES ('17', 'sd', '1234');
INSERT INTO `user` VALUES ('18', 'We', '1234');
INSERT INTO `user` VALUES ('19', 'Bn', '1234');
INSERT INTO `user` VALUES ('20', 'Rt', '1234');
INSERT INTO `user` VALUES ('21', 'Yt', '1234');
INSERT INTO `user` VALUES ('22', 'Re', '1234');
INSERT INTO `user` VALUES ('23', 'Cv', '1234');
INSERT INTO `user` VALUES ('24', 'Vb', '1234');
INSERT INTO `user` VALUES ('25', 'Qy', '1234');
INSERT INTO `user` VALUES ('26', 'Jk', '1234');
INSERT INTO `user` VALUES ('27', 'Bv', '1234');
INSERT INTO `user` VALUES ('28', 'Er', '1234');
INSERT INTO `user` VALUES ('29', 'Vg', '1234');
INSERT INTO `user` VALUES ('30', 'Lk', '1234');
INSERT INTO `user` VALUES ('31', 'Mn', '1234');
INSERT INTO `user` VALUES ('32', 'Jh', '1234');
INSERT INTO `user` VALUES ('33', 'Hb', '1234');
INSERT INTO `user` VALUES ('34', 'Cx', '1234');
INSERT INTO `user` VALUES ('35', 'Hg', '1234');
INSERT INTO `user` VALUES ('36', 'Vxc', '1234');
INSERT INTO `user` VALUES ('37', 'Nnhj', '1234');
INSERT INTO `user` VALUES ('38', 'Kiuy', '1234');
INSERT INTO `user` VALUES ('39', 'Hhjgf', '1234');
INSERT INTO `user` VALUES ('40', 'Hjjjkk', '1234');
INSERT INTO `user` VALUES ('41', 'Ijvg', '1234');
INSERT INTO `user` VALUES ('42', 'Fjfuhg', '1234');
INSERT INTO `user` VALUES ('43', 'Rtguugg', '1234');
INSERT INTO `user` VALUES ('44', 'Yghj', '1234');
INSERT INTO `user` VALUES ('45', 'Ybbgf', '1234');
INSERT INTO `user` VALUES ('46', 'Hhfjk', '1234');
INSERT INTO `user` VALUES ('47', 'Hjjkk', '1234');
INSERT INTO `user` VALUES ('48', 'Bkjhh', '1234');
INSERT INTO `user` VALUES ('49', 'Dfff', '1234');
INSERT INTO `user` VALUES ('50', 'Fvbfd', '1234');
INSERT INTO `user` VALUES ('51', 'Jhvjkk', '1234');
INSERT INTO `user` VALUES ('52', 'Tffnht', '1234');
INSERT INTO `user` VALUES ('53', 'Hjbkd', '1234');
INSERT INTO `user` VALUES ('54', 'jbchinbs', '1234');
INSERT INTO `user` VALUES ('55', 'Jcuv', '1234');
INSERT INTO `user` VALUES ('56', 'Hjggh', '1234');
INSERT INTO `user` VALUES ('57', 'Dhgvkc', '1234');
INSERT INTO `user` VALUES ('58', 'Fvfd', '1234');
INSERT INTO `user` VALUES ('59', 'Gjiinjid', '1234');
INSERT INTO `user` VALUES ('60', 'Ujjndkld', '1234');
INSERT INTO `user` VALUES ('61', 'Fhbjjv', '1234');
INSERT INTO `user` VALUES ('62', 'Fhvgkn', '1234');
INSERT INTO `user` VALUES ('63', 'Hckhc', '1234');

-- ----------------------------
-- Table structure for `userfoodaccount`
-- ----------------------------
DROP TABLE IF EXISTS `userfoodaccount`;
CREATE TABLE `userfoodaccount` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `number` int(10) NOT NULL,
  `date` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `remarks` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userfoodaccount
-- ----------------------------

-- ----------------------------
-- Table structure for `wine`
-- ----------------------------
DROP TABLE IF EXISTS `wine`;
CREATE TABLE `wine` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `foodCategory` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodName` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `foodPrice` int(10) NOT NULL,
  `foodStackNum` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of wine
-- ----------------------------
