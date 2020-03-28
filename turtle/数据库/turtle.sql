/*
 Navicat Premium Data Transfer

 Source Server         : MySQl
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : turtle

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 09/08/2019 15:27:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cus_state
-- ----------------------------
DROP TABLE IF EXISTS `cus_state`;
CREATE TABLE `cus_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户账号状态表',
  `csname` varchar(255) DEFAULT NULL COMMENT '客户状态名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cus_state
-- ----------------------------
BEGIN;
INSERT INTO `cus_state` VALUES (1, '正常');
INSERT INTO `cus_state` VALUES (2, '封禁');
COMMIT;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户表',
  `cnumber` varchar(50) DEFAULT NULL COMMENT '客户编号',
  `cname` varchar(255) DEFAULT NULL COMMENT '客户名字',
  `csex` varchar(255) DEFAULT NULL COMMENT '客户性别',
  `cphone` varchar(255) DEFAULT NULL COMMENT '客户电话',
  `ccard` varchar(255) DEFAULT NULL COMMENT '客户身份证号',
  `cusername` varchar(255) DEFAULT NULL COMMENT '客户用户名',
  `cpassword` varchar(255) DEFAULT NULL COMMENT '客户密码',
  `state` int(11) DEFAULT NULL COMMENT '客户状态',
  `cimg` varchar(255) DEFAULT NULL COMMENT '客户头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES (8, '20190712214', '周某', '1', '18203829214', '411326199702251133', 'nPypcZ', 'ADE934C5A9877A44659A963DAB7F69BF', 1, '../../resources/images/head/20190712214.jpg');
INSERT INTO `customer` VALUES (9, '20190717641', '张某', '2', '15093161128', '411325199301011122', 'NwCIEc', 'E10ADC3949BA59ABBE56E057F20F883E', 1, '../../resources/images/head/20190717641.jpg');
INSERT INTO `customer` VALUES (10, '20190815833', '周火火', '1', '13253518546', '411326199903060035', 'sLrfpS', 'E10ADC3949BA59ABBE56E057F20F883E', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for emp_state
-- ----------------------------
DROP TABLE IF EXISTS `emp_state`;
CREATE TABLE `emp_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工状态表',
  `sname` varchar(255) DEFAULT NULL COMMENT '状态名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of emp_state
-- ----------------------------
BEGIN;
INSERT INTO `emp_state` VALUES (1, '在职');
INSERT INTO `emp_state` VALUES (2, '休假');
INSERT INTO `emp_state` VALUES (3, '离职');
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工表',
  `enumber` int(11) DEFAULT NULL COMMENT '员工编号',
  `ename` varchar(255) NOT NULL COMMENT '员工姓名',
  `ecard` varchar(255) DEFAULT NULL COMMENT '员工身份证号',
  `ephone` varchar(255) DEFAULT NULL COMMENT '员工手机号',
  `state` int(11) DEFAULT NULL COMMENT '员工状态',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  `logoimg` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `eusername` varchar(255) DEFAULT NULL COMMENT '员工后台登录账号',
  `epassword` varchar(999) DEFAULT NULL COMMENT '员工后台登录密码',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `edesc` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `eqq` varchar(255) DEFAULT NULL COMMENT 'qq号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
INSERT INTO `employee` VALUES (3, 1901003, '周铎', '411326199702250038', '18203829214', 1, 1, '../../resources/images/head/zmd.jpg', 'QY98zd', '202CB962AC59075B964B07152D234B70', '572747323@qq.com', '写着写着就凉了，我难受啊！', '572747323');
INSERT INTO `employee` VALUES (6, 1901008, '张巧丽', '411326199701010033', '13253500310', 1, 3, NULL, 'QY98zql', '202CB962AC59075B964B07152D234B70', NULL, NULL, NULL);
INSERT INTO `employee` VALUES (7, 1901009, '乔毫飞', '411324199302051128', '14725836914', 1, 3, NULL, 'QY98qhf', '202CB962AC59075B964B07152D234B70', NULL, NULL, NULL);
INSERT INTO `employee` VALUES (8, 1901010, '张宏永', '411326199401020038', '25836914712', 1, 4, NULL, 'QY98zhy', '202CB962AC59075B964B07152D234B70', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for followhouse
-- ----------------------------
DROP TABLE IF EXISTS `followhouse`;
CREATE TABLE `followhouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关注房源表',
  `cid` int(11) DEFAULT NULL COMMENT '用户ID',
  `houseid` int(11) DEFAULT NULL COMMENT '房源ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of followhouse
-- ----------------------------
BEGIN;
INSERT INTO `followhouse` VALUES (29, 8, 30);
INSERT INTO `followhouse` VALUES (30, 8, 35);
COMMIT;

-- ----------------------------
-- Table structure for furniture
-- ----------------------------
DROP TABLE IF EXISTS `furniture`;
CREATE TABLE `furniture` (
  `id` int(11) NOT NULL COMMENT '房屋家具表',
  `furnitureid` int(11) DEFAULT NULL COMMENT '家具编号',
  `furniturename` varchar(255) DEFAULT NULL COMMENT '家具名字',
  `furniturename1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of furniture
-- ----------------------------
BEGIN;
INSERT INTO `furniture` VALUES (1, 55501, '电视', 'ds');
INSERT INTO `furniture` VALUES (2, 55502, '冰箱', 'bx');
INSERT INTO `furniture` VALUES (3, 55503, '洗衣机', 'xyj');
INSERT INTO `furniture` VALUES (4, 55504, '空调', 'kt');
INSERT INTO `furniture` VALUES (5, 55505, '热水器', 'rsq');
INSERT INTO `furniture` VALUES (6, 55506, '床', 'c');
INSERT INTO `furniture` VALUES (7, 55507, '暖气', 'nq');
INSERT INTO `furniture` VALUES (8, 55508, '宽带', 'kd');
INSERT INTO `furniture` VALUES (9, 55509, '衣柜', 'yg');
INSERT INTO `furniture` VALUES (10, 55510, '天然气', 'trq');
COMMIT;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋信息表',
  `houseid` int(11) DEFAULT NULL COMMENT '房屋编号',
  `landlord` int(11) DEFAULT NULL COMMENT '房东编号',
  `htitle` varchar(255) DEFAULT NULL COMMENT '房屋标题',
  `hadr` varchar(255) DEFAULT NULL COMMENT '房屋地址',
  `hrent` int(11) DEFAULT NULL COMMENT '房屋租金',
  `state` int(11) DEFAULT NULL COMMENT '房屋状态',
  `himg` varchar(255) DEFAULT NULL COMMENT '房屋图片',
  `hfloor` int(11) DEFAULT NULL COMMENT '房屋楼层',
  `hspace` varchar(255) DEFAULT NULL COMMENT '房屋面积',
  `orientation` varchar(255) DEFAULT NULL COMMENT '房屋朝向',
  `releasedate` date DEFAULT NULL COMMENT '房屋发布日期',
  `hdesc` varchar(255) DEFAULT NULL COMMENT '房屋格局',
  `longitude` varchar(255) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) DEFAULT NULL COMMENT '纬度',
  `agentid` int(11) DEFAULT NULL COMMENT '经纪人ID',
  `tenantid` int(11) DEFAULT NULL COMMENT '租客ID',
  `cimg` varchar(255) DEFAULT NULL COMMENT '合同图片',
  `examine` varchar(255) DEFAULT NULL COMMENT '审核信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of house
-- ----------------------------
BEGIN;
INSERT INTO `house` VALUES (30, 11001, 8, '整租·海马公园', '管城区-普惠路99号附近-海马公园', 3000, 1, '../../resources/images/houses/20190805163815海马公园5期 2室2厅 南.png', 10, '93', '南', '2019-08-04', '2室2厅1卫', '113.77', '34.75', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (31, 11102, 8, '整租·曼哈顿', '金水区-金水路与未来大道交汇处-曼哈顿', 4000, 0, '../../resources/images/houses/20190805164654曼哈顿 1室1厅 南1.png', 17, '89', '南', '2019-08-04', '2室1厅1卫', '113.71', '34.76', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (32, 11103, 8, '整租·正弘蓝堡湾', '金水区-东风路28号-正弘蓝堡湾', 4010, 0, '../../resources/images/houses/20190805164918正弘·蓝堡湾Ⅲ 2室1厅 南1.png', 22, '89', '南', '2019-08-04', '2室1厅1卫', '113.68', '34.80', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (33, 11104, 8, '整租万正紫湖公馆', '金水区-博学路龙子湖高校园区紫湖公馆-方正紫湖公馆', 2000, 0, '../../resources/images/houses/20190805165155万正紫湖公馆 1室1厅 LOFT 东南1.png', 13, '60', '东', '2019-08-04', '1室1厅1卫', '113.81', '34.79', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (34, 11105, 9, '整租·金林公馆', '金水区-燕东路-金林公馆', 5000, 0, '../../resources/images/houses/20190805165906金林公馆 2室2厅 东南1.png', 14, '100', '南', '2019-08-04', '2室2厅1卫', '113.71', '34.76', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (35, 11106, 9, '整租万科美景龙堂', '二七区-郑航街21号-万科美景龙堂', 3500, 0, '../../resources/images/houses/20190805170117万科美景龙堂 2室1厅 南1.png', 9, '81', '东', '2019-08-04', '2室1厅1卫', '113.72', '34.72', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (36, 11107, 9, '整租·海悦雅居', '二七区-陇海东路与中州大道交叉口东北角-海悦雅居', 5000, 1, '../../resources/images/houses/20190805170332海悦雅居1.png', 15, '100', '南', '2019-08-04', '3室2厅1卫', '113.65', '34.71', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (37, 11108, 8, '整租·中豪汇景湾', '金水区-金水东路与心仪路交汇处向南500米-中豪汇景湾', 2400, 5, '../../resources/images/houses/20190805170544汇景湾 1室1厅 南1.png', 5, '56', '南', '2019-08-04', '1室1厅1卫', '113.78', '34.77', 3, 9, NULL, NULL);
INSERT INTO `house` VALUES (38, 11109, 9, '整租·建业天筑', '管城区-康宁街58号-建业天筑', 4100, 0, '../../resources/images/houses/20190805170753建业天筑 2室2厅 南1.png', 17, '92', '南', '2019-08-04', '2室2厅1卫', '113.77', '34.75', 3, NULL, NULL, NULL);
INSERT INTO `house` VALUES (45, 11115, 8, '天伦星钻', '金水区-杨金路街道-没有', 5000, 5, '../../resources/images/houses/20190808113857整租·天伦星钻 2室2厅 南1.jpg', 20, '150', '东', '2019-08-07', '三室一厅', NULL, NULL, 7, 8, NULL, NULL);
INSERT INTO `house` VALUES (46, 110214, 8, 'aaaaaa', '二七区-aaaaa-aaaaa', 5000, 5, '../../resources/images/houses/20190808173940banner_2.png', 10, '140', '东', '2019-08-07', '三室一厅', NULL, NULL, 7, 9, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for house_furniture
-- ----------------------------
DROP TABLE IF EXISTS `house_furniture`;
CREATE TABLE `house_furniture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋拥有家具中间表',
  `houseid` int(11) DEFAULT NULL COMMENT '房屋编号',
  `furnitureid` int(11) DEFAULT NULL COMMENT '家具编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of house_furniture
-- ----------------------------
BEGIN;
INSERT INTO `house_furniture` VALUES (129, 11001, 55501);
INSERT INTO `house_furniture` VALUES (130, 11001, 55502);
INSERT INTO `house_furniture` VALUES (131, 11001, 55504);
INSERT INTO `house_furniture` VALUES (132, 11001, 55505);
INSERT INTO `house_furniture` VALUES (133, 11001, 55506);
INSERT INTO `house_furniture` VALUES (134, 11001, 55508);
INSERT INTO `house_furniture` VALUES (135, 11001, 55509);
INSERT INTO `house_furniture` VALUES (136, 11001, 55510);
INSERT INTO `house_furniture` VALUES (137, 11001, 55503);
INSERT INTO `house_furniture` VALUES (138, 11001, 55507);
INSERT INTO `house_furniture` VALUES (139, 11102, 55501);
INSERT INTO `house_furniture` VALUES (140, 11102, 55502);
INSERT INTO `house_furniture` VALUES (141, 11102, 55503);
INSERT INTO `house_furniture` VALUES (142, 11102, 55504);
INSERT INTO `house_furniture` VALUES (143, 11102, 55505);
INSERT INTO `house_furniture` VALUES (144, 11102, 55506);
INSERT INTO `house_furniture` VALUES (145, 11102, 55507);
INSERT INTO `house_furniture` VALUES (146, 11102, 55508);
INSERT INTO `house_furniture` VALUES (147, 11102, 55509);
INSERT INTO `house_furniture` VALUES (148, 11102, 55510);
INSERT INTO `house_furniture` VALUES (149, 11103, 55501);
INSERT INTO `house_furniture` VALUES (150, 11103, 55504);
INSERT INTO `house_furniture` VALUES (151, 11103, 55503);
INSERT INTO `house_furniture` VALUES (152, 11103, 55505);
INSERT INTO `house_furniture` VALUES (153, 11103, 55506);
INSERT INTO `house_furniture` VALUES (154, 11103, 55507);
INSERT INTO `house_furniture` VALUES (155, 11103, 55509);
INSERT INTO `house_furniture` VALUES (156, 11103, 55510);
INSERT INTO `house_furniture` VALUES (157, 11104, 55501);
INSERT INTO `house_furniture` VALUES (158, 11104, 55504);
INSERT INTO `house_furniture` VALUES (159, 11104, 55503);
INSERT INTO `house_furniture` VALUES (160, 11104, 55502);
INSERT INTO `house_furniture` VALUES (161, 11104, 55507);
INSERT INTO `house_furniture` VALUES (162, 11104, 55509);
INSERT INTO `house_furniture` VALUES (163, 11105, 55501);
INSERT INTO `house_furniture` VALUES (164, 11105, 55502);
INSERT INTO `house_furniture` VALUES (165, 11105, 55503);
INSERT INTO `house_furniture` VALUES (166, 11105, 55504);
INSERT INTO `house_furniture` VALUES (167, 11105, 55505);
INSERT INTO `house_furniture` VALUES (168, 11105, 55506);
INSERT INTO `house_furniture` VALUES (169, 11105, 55507);
INSERT INTO `house_furniture` VALUES (170, 11105, 55508);
INSERT INTO `house_furniture` VALUES (171, 11105, 55509);
INSERT INTO `house_furniture` VALUES (172, 11105, 55510);
INSERT INTO `house_furniture` VALUES (173, 11106, 55501);
INSERT INTO `house_furniture` VALUES (174, 11106, 55503);
INSERT INTO `house_furniture` VALUES (175, 11106, 55504);
INSERT INTO `house_furniture` VALUES (176, 11106, 55505);
INSERT INTO `house_furniture` VALUES (177, 11106, 55506);
INSERT INTO `house_furniture` VALUES (178, 11106, 55507);
INSERT INTO `house_furniture` VALUES (179, 11107, 55501);
INSERT INTO `house_furniture` VALUES (180, 11107, 55502);
INSERT INTO `house_furniture` VALUES (181, 11107, 55503);
INSERT INTO `house_furniture` VALUES (182, 11107, 55504);
INSERT INTO `house_furniture` VALUES (183, 11107, 55505);
INSERT INTO `house_furniture` VALUES (184, 11107, 55506);
INSERT INTO `house_furniture` VALUES (185, 11107, 55507);
INSERT INTO `house_furniture` VALUES (186, 11107, 55508);
INSERT INTO `house_furniture` VALUES (187, 11107, 55509);
INSERT INTO `house_furniture` VALUES (188, 11107, 55510);
INSERT INTO `house_furniture` VALUES (189, 11108, 55501);
INSERT INTO `house_furniture` VALUES (190, 11108, 55505);
INSERT INTO `house_furniture` VALUES (191, 11108, 55504);
INSERT INTO `house_furniture` VALUES (192, 11108, 55507);
INSERT INTO `house_furniture` VALUES (193, 11108, 55508);
INSERT INTO `house_furniture` VALUES (194, 11109, 55503);
INSERT INTO `house_furniture` VALUES (195, 11109, 55504);
INSERT INTO `house_furniture` VALUES (196, 11109, 55502);
INSERT INTO `house_furniture` VALUES (197, 11109, 55505);
INSERT INTO `house_furniture` VALUES (198, 11109, 55506);
INSERT INTO `house_furniture` VALUES (199, 11109, 55507);
INSERT INTO `house_furniture` VALUES (200, 11109, 55509);
INSERT INTO `house_furniture` VALUES (201, 2001, 55501);
INSERT INTO `house_furniture` VALUES (202, 2001, 55502);
INSERT INTO `house_furniture` VALUES (203, 2001, 55503);
INSERT INTO `house_furniture` VALUES (204, 2001, 55504);
INSERT INTO `house_furniture` VALUES (205, 2001, 55505);
INSERT INTO `house_furniture` VALUES (206, 2001, 55506);
INSERT INTO `house_furniture` VALUES (207, 10010, 55501);
INSERT INTO `house_furniture` VALUES (208, 10010, 55502);
INSERT INTO `house_furniture` VALUES (209, 10010, 55503);
INSERT INTO `house_furniture` VALUES (210, 110101, 55505);
INSERT INTO `house_furniture` VALUES (211, 110101, 55506);
INSERT INTO `house_furniture` VALUES (212, 11111, 55501);
INSERT INTO `house_furniture` VALUES (213, 11111, 55502);
INSERT INTO `house_furniture` VALUES (214, 11111, 55503);
INSERT INTO `house_furniture` VALUES (215, 11111, 55504);
INSERT INTO `house_furniture` VALUES (216, 11112, 55501);
INSERT INTO `house_furniture` VALUES (217, 11112, 55503);
INSERT INTO `house_furniture` VALUES (218, 11112, 55504);
INSERT INTO `house_furniture` VALUES (219, 11112, 55507);
INSERT INTO `house_furniture` VALUES (220, 11112, 55509);
INSERT INTO `house_furniture` VALUES (221, 11112, 55510);
INSERT INTO `house_furniture` VALUES (222, 11112, 55505);
INSERT INTO `house_furniture` VALUES (223, 11113, 55501);
INSERT INTO `house_furniture` VALUES (224, 11113, 55503);
INSERT INTO `house_furniture` VALUES (225, 11113, 55504);
INSERT INTO `house_furniture` VALUES (226, 11113, 55506);
INSERT INTO `house_furniture` VALUES (227, 11113, 55509);
INSERT INTO `house_furniture` VALUES (228, 11115, 55501);
INSERT INTO `house_furniture` VALUES (229, 11115, 55502);
INSERT INTO `house_furniture` VALUES (230, 11115, 55503);
INSERT INTO `house_furniture` VALUES (231, 11115, 55505);
INSERT INTO `house_furniture` VALUES (232, 11115, 55507);
INSERT INTO `house_furniture` VALUES (233, 11115, 55508);
INSERT INTO `house_furniture` VALUES (234, 110214, 55501);
INSERT INTO `house_furniture` VALUES (235, 110214, 55502);
INSERT INTO `house_furniture` VALUES (236, 110214, 55503);
INSERT INTO `house_furniture` VALUES (237, 110214, 55504);
COMMIT;

-- ----------------------------
-- Table structure for house_label
-- ----------------------------
DROP TABLE IF EXISTS `house_label`;
CREATE TABLE `house_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋拥有标签中间表',
  `houseid` int(11) DEFAULT NULL COMMENT '房屋编号',
  `labelid` int(11) DEFAULT NULL COMMENT '标签编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of house_label
-- ----------------------------
BEGIN;
INSERT INTO `house_label` VALUES (95, 11001, 33303);
INSERT INTO `house_label` VALUES (96, 11001, 33302);
INSERT INTO `house_label` VALUES (97, 11001, 33301);
INSERT INTO `house_label` VALUES (98, 11001, 33307);
INSERT INTO `house_label` VALUES (99, 11001, 33309);
INSERT INTO `house_label` VALUES (100, 11102, 33301);
INSERT INTO `house_label` VALUES (101, 11102, 33307);
INSERT INTO `house_label` VALUES (102, 11102, 33309);
INSERT INTO `house_label` VALUES (103, 11102, 33310);
INSERT INTO `house_label` VALUES (104, 11102, 33311);
INSERT INTO `house_label` VALUES (105, 11103, 33303);
INSERT INTO `house_label` VALUES (106, 11103, 33307);
INSERT INTO `house_label` VALUES (107, 11103, 33308);
INSERT INTO `house_label` VALUES (108, 11103, 33309);
INSERT INTO `house_label` VALUES (109, 11103, 33301);
INSERT INTO `house_label` VALUES (110, 11103, 33311);
INSERT INTO `house_label` VALUES (111, 11104, 33308);
INSERT INTO `house_label` VALUES (112, 11104, 33309);
INSERT INTO `house_label` VALUES (113, 11104, 33301);
INSERT INTO `house_label` VALUES (114, 11104, 33311);
INSERT INTO `house_label` VALUES (115, 11105, 33301);
INSERT INTO `house_label` VALUES (116, 11105, 33306);
INSERT INTO `house_label` VALUES (117, 11105, 33307);
INSERT INTO `house_label` VALUES (118, 11105, 33308);
INSERT INTO `house_label` VALUES (119, 11105, 33309);
INSERT INTO `house_label` VALUES (120, 11105, 33311);
INSERT INTO `house_label` VALUES (121, 11106, 33306);
INSERT INTO `house_label` VALUES (122, 11106, 33301);
INSERT INTO `house_label` VALUES (123, 11106, 33307);
INSERT INTO `house_label` VALUES (124, 11106, 33308);
INSERT INTO `house_label` VALUES (125, 11106, 33311);
INSERT INTO `house_label` VALUES (126, 11107, 33308);
INSERT INTO `house_label` VALUES (127, 11107, 33307);
INSERT INTO `house_label` VALUES (128, 11107, 33302);
INSERT INTO `house_label` VALUES (129, 11107, 33301);
INSERT INTO `house_label` VALUES (130, 11107, 33311);
INSERT INTO `house_label` VALUES (131, 11108, 33305);
INSERT INTO `house_label` VALUES (132, 11108, 33303);
INSERT INTO `house_label` VALUES (133, 11108, 33307);
INSERT INTO `house_label` VALUES (134, 11108, 33306);
INSERT INTO `house_label` VALUES (135, 11108, 33308);
INSERT INTO `house_label` VALUES (136, 11108, 33311);
INSERT INTO `house_label` VALUES (137, 11109, 33302);
INSERT INTO `house_label` VALUES (138, 11109, 33307);
INSERT INTO `house_label` VALUES (139, 11109, 33308);
INSERT INTO `house_label` VALUES (140, 11109, 33309);
INSERT INTO `house_label` VALUES (141, 11109, 33311);
INSERT INTO `house_label` VALUES (142, 2001, 33302);
INSERT INTO `house_label` VALUES (143, 2001, 33305);
INSERT INTO `house_label` VALUES (144, 2001, 33307);
INSERT INTO `house_label` VALUES (145, 10010, 33304);
INSERT INTO `house_label` VALUES (146, 10010, 33307);
INSERT INTO `house_label` VALUES (147, 10010, 33306);
INSERT INTO `house_label` VALUES (148, 110101, 33311);
INSERT INTO `house_label` VALUES (149, 110101, 33305);
INSERT INTO `house_label` VALUES (150, 11111, 33302);
INSERT INTO `house_label` VALUES (151, 11111, 33305);
INSERT INTO `house_label` VALUES (152, 11111, 33307);
INSERT INTO `house_label` VALUES (153, 11112, 33302);
INSERT INTO `house_label` VALUES (154, 11112, 33301);
INSERT INTO `house_label` VALUES (155, 11112, 33307);
INSERT INTO `house_label` VALUES (156, 11112, 33309);
INSERT INTO `house_label` VALUES (157, 11112, 33311);
INSERT INTO `house_label` VALUES (158, 11113, 33303);
INSERT INTO `house_label` VALUES (159, 11113, 33302);
INSERT INTO `house_label` VALUES (160, 11113, 33301);
INSERT INTO `house_label` VALUES (161, 11113, 33307);
INSERT INTO `house_label` VALUES (162, 11113, 33311);
INSERT INTO `house_label` VALUES (163, 11115, 33305);
INSERT INTO `house_label` VALUES (164, 11115, 33303);
INSERT INTO `house_label` VALUES (165, 11115, 33301);
INSERT INTO `house_label` VALUES (166, 11115, 33308);
INSERT INTO `house_label` VALUES (167, 110214, 33305);
INSERT INTO `house_label` VALUES (168, 110214, 33302);
INSERT INTO `house_label` VALUES (169, 110214, 33301);
INSERT INTO `house_label` VALUES (170, 110214, 33312);
COMMIT;

-- ----------------------------
-- Table structure for house_state
-- ----------------------------
DROP TABLE IF EXISTS `house_state`;
CREATE TABLE `house_state` (
  `id` int(11) NOT NULL COMMENT '房屋状态表',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of house_state
-- ----------------------------
BEGIN;
INSERT INTO `house_state` VALUES (0, '已发布');
INSERT INTO `house_state` VALUES (1, '待发布');
INSERT INTO `house_state` VALUES (2, '待审核');
INSERT INTO `house_state` VALUES (3, '未通过');
INSERT INTO `house_state` VALUES (4, '已审核');
INSERT INTO `house_state` VALUES (5, '已出租');
COMMIT;

-- ----------------------------
-- Table structure for houseimgs
-- ----------------------------
DROP TABLE IF EXISTS `houseimgs`;
CREATE TABLE `houseimgs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房屋图片表',
  `houseid` int(11) DEFAULT NULL COMMENT '房屋编号',
  `houseimg` varchar(255) DEFAULT NULL COMMENT '房屋图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of houseimgs
-- ----------------------------
BEGIN;
INSERT INTO `houseimgs` VALUES (45, 11001, '../../resources/images/houses/20190805164456海马公园5期 2室2厅 南.png');
INSERT INTO `houseimgs` VALUES (46, 11001, '../../resources/images/houses/20190805164459海马公园5期 2室2厅 南2.png');
INSERT INTO `houseimgs` VALUES (47, 11001, '../../resources/images/houses/20190805164502海马公园5期 2室2厅 南3.png');
INSERT INTO `houseimgs` VALUES (48, 11102, '../../resources/images/houses/20190805164838曼哈顿 1室1厅 南1.png');
INSERT INTO `houseimgs` VALUES (49, 11102, '../../resources/images/houses/20190805164841曼哈顿 1室1厅 南2.png');
INSERT INTO `houseimgs` VALUES (50, 11102, '../../resources/images/houses/20190805164844曼哈顿 1室1厅 南3.png');
INSERT INTO `houseimgs` VALUES (51, 11103, '../../resources/images/houses/20190805165101正弘·蓝堡湾Ⅲ 2室1厅 南1.png');
INSERT INTO `houseimgs` VALUES (52, 11103, '../../resources/images/houses/20190805165105正弘·蓝堡湾Ⅲ 2室1厅 南2.png');
INSERT INTO `houseimgs` VALUES (53, 11103, '../../resources/images/houses/20190805165109正弘·蓝堡湾Ⅲ 2室1厅 南3.png');
INSERT INTO `houseimgs` VALUES (54, 11104, '../../resources/images/houses/20190805165735万正紫湖公馆 1室1厅 LOFT 东南1.png');
INSERT INTO `houseimgs` VALUES (55, 11104, '../../resources/images/houses/20190805165739万正紫湖公馆 1室1厅 LOFT 东南2.png');
INSERT INTO `houseimgs` VALUES (56, 11104, '../../resources/images/houses/20190805165745万正紫湖公馆 1室1厅 LOFT 东南3.png');
INSERT INTO `houseimgs` VALUES (57, 11105, '../../resources/images/houses/20190805170043金林公馆 2室2厅 东南1.png');
INSERT INTO `houseimgs` VALUES (58, 11105, '../../resources/images/houses/20190805170047金林公馆 2室2厅 东南2.png');
INSERT INTO `houseimgs` VALUES (59, 11105, '../../resources/images/houses/20190805170051金林公馆 2室2厅 东南3.png');
INSERT INTO `houseimgs` VALUES (60, 11106, '../../resources/images/houses/20190805170304万科美景龙堂 2室1厅 南1.png');
INSERT INTO `houseimgs` VALUES (61, 11106, '../../resources/images/houses/20190805170308万科美景龙堂 2室1厅 南2.png');
INSERT INTO `houseimgs` VALUES (62, 11106, '../../resources/images/houses/20190805170313万科美景龙堂 2室1厅 南3.png');
INSERT INTO `houseimgs` VALUES (63, 11107, '../../resources/images/houses/20190805170504海悦雅居1.png');
INSERT INTO `houseimgs` VALUES (64, 11107, '../../resources/images/houses/20190805170507海悦雅居2.png');
INSERT INTO `houseimgs` VALUES (65, 11107, '../../resources/images/houses/20190805170511海悦雅居3.png');
INSERT INTO `houseimgs` VALUES (66, 11108, '../../resources/images/houses/20190805170724汇景湾 1室1厅 南1.png');
INSERT INTO `houseimgs` VALUES (67, 11108, '../../resources/images/houses/20190805170727汇景湾 1室1厅 南2.png');
INSERT INTO `houseimgs` VALUES (68, 11108, '../../resources/images/houses/20190805170730汇景湾 1室1厅 南3.png');
INSERT INTO `houseimgs` VALUES (69, 11109, '../../resources/images/houses/20190805170907建业天筑 2室2厅 南1.png');
INSERT INTO `houseimgs` VALUES (70, 11109, '../../resources/images/houses/20190805170910建业天筑 2室2厅 南2.png');
INSERT INTO `houseimgs` VALUES (71, 11109, '../../resources/images/houses/20190805170913建业天筑 2室2厅 南3.png');
INSERT INTO `houseimgs` VALUES (72, 2001, '../../resources/images/houses/20190807201156整租·龙之梦东苑 3室2厅 南1.jpg');
INSERT INTO `houseimgs` VALUES (73, 2001, '../../resources/images/houses/20190807201159整租·龙之梦东苑 3室2厅 南2.jpg');
INSERT INTO `houseimgs` VALUES (74, 2001, '../../resources/images/houses/20190807201202整租·龙之梦东苑 3室2厅 南3.jpg');
INSERT INTO `houseimgs` VALUES (75, 10010, '../../resources/images/houses/20190807214629banner_1.png');
INSERT INTO `houseimgs` VALUES (76, 110101, '../../resources/images/houses/20190807214808banner_3的副本.png');
INSERT INTO `houseimgs` VALUES (77, 11111, '../../resources/images/houses/20190808095214整租·天伦星钻 2室2厅 南1.jpg');
INSERT INTO `houseimgs` VALUES (78, 11111, '../../resources/images/houses/20190808095216整租·天伦星钻 2室2厅 南2.jpg');
INSERT INTO `houseimgs` VALUES (79, 11111, '../../resources/images/houses/20190808095219整租·天伦星钻 2室2厅 南3.jpg');
INSERT INTO `houseimgs` VALUES (80, 11112, '../../resources/images/houses/20190808102602整租·龙之梦东苑 3室2厅 南2.jpg');
INSERT INTO `houseimgs` VALUES (81, 11112, '../../resources/images/houses/20190808102605整租·龙之梦东苑 3室2厅 南3.jpg');
INSERT INTO `houseimgs` VALUES (82, 11112, '../../resources/images/houses/20190808102608整租·龙之梦东苑 3室2厅 南1.jpg');
INSERT INTO `houseimgs` VALUES (83, 11113, '../../resources/images/houses/20190808104139整租·天伦星钻 2室2厅 南2.jpg');
INSERT INTO `houseimgs` VALUES (84, 11113, '../../resources/images/houses/20190808104142整租·天伦星钻 2室2厅 南3.jpg');
INSERT INTO `houseimgs` VALUES (85, 11113, '../../resources/images/houses/20190808104145整租·天伦星钻 2室2厅 南1.jpg');
INSERT INTO `houseimgs` VALUES (86, 11115, '../../resources/images/houses/20190808114029整租·天伦星钻 2室2厅 南1.jpg');
INSERT INTO `houseimgs` VALUES (87, 11115, '../../resources/images/houses/20190808114033整租·天伦星钻 2室2厅 南2.jpg');
INSERT INTO `houseimgs` VALUES (88, 11115, '../../resources/images/houses/20190808114036整租·天伦星钻 2室2厅 南3.jpg');
INSERT INTO `houseimgs` VALUES (89, 110214, '../../resources/images/houses/20190808174037banner_2的副本.png');
INSERT INTO `houseimgs` VALUES (90, 110214, '../../resources/images/houses/20190808174041bb.jpg');
COMMIT;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL COMMENT '房屋标签表',
  `labelid` varchar(32) DEFAULT NULL COMMENT '房屋标签编号',
  `labelcontent` varchar(255) DEFAULT NULL COMMENT '房屋标签内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of label
-- ----------------------------
BEGIN;
INSERT INTO `label` VALUES (1, '33301', '近地铁');
INSERT INTO `label` VALUES (2, '33302', '随时看房');
INSERT INTO `label` VALUES (3, '33303', '在线签约');
INSERT INTO `label` VALUES (4, '33304', '公寓');
INSERT INTO `label` VALUES (5, '33305', '独立卫生间');
INSERT INTO `label` VALUES (6, '33306', '月租');
INSERT INTO `label` VALUES (7, '33307', '精装');
INSERT INTO `label` VALUES (8, '33308', '独立阳台');
INSERT INTO `label` VALUES (9, '33309', '集中供暖');
INSERT INTO `label` VALUES (10, '33310', '押一付一');
INSERT INTO `label` VALUES (11, '33311', '拎包入住');
INSERT INTO `label` VALUES (12, '33312', '新上');
COMMIT;

-- ----------------------------
-- Table structure for leadhouse
-- ----------------------------
DROP TABLE IF EXISTS `leadhouse`;
CREATE TABLE `leadhouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '前端用户发布房源信息表',
  `ladr` varchar(255) DEFAULT NULL COMMENT '地址',
  `remoney` varchar(255) DEFAULT NULL COMMENT '租金',
  `lname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `lphone` varchar(255) DEFAULT NULL COMMENT '电话',
  `state` int(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of leadhouse
-- ----------------------------
BEGIN;
INSERT INTO `leadhouse` VALUES (19, '金水区-中环路东50米-龙之梦东苑', '6500', '张某', '15093161128', 1);
INSERT INTO `leadhouse` VALUES (20, '金水区-杨金路街道-没有', '5000', '周某', '18203829215', 1);
COMMIT;

-- ----------------------------
-- Table structure for leadhouse_state
-- ----------------------------
DROP TABLE IF EXISTS `leadhouse_state`;
CREATE TABLE `leadhouse_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '与前端发布房源的用户联系的状态表',
  `name` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of leadhouse_state
-- ----------------------------
BEGIN;
INSERT INTO `leadhouse_state` VALUES (1, '已联系');
INSERT INTO `leadhouse_state` VALUES (2, '未联系');
COMMIT;

-- ----------------------------
-- Table structure for paid
-- ----------------------------
DROP TABLE IF EXISTS `paid`;
CREATE TABLE `paid` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '缴纳租金表',
  `houseid` int(11) DEFAULT NULL COMMENT '房源id',
  `tenantid` int(11) NOT NULL COMMENT '租户id',
  `tenant` varchar(255) DEFAULT NULL COMMENT '租户姓名',
  `hadr` varchar(255) DEFAULT NULL COMMENT '房屋地址',
  `hrend` int(11) DEFAULT NULL COMMENT '应缴房屋租金（租金加手续费）',
  `data` date DEFAULT NULL COMMENT '缴纳租金截止日期',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '交租状态',
  `optdata` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paid
-- ----------------------------
BEGIN;
INSERT INTO `paid` VALUES (39, 37, 9, '张某', '金水区-金水东路与心仪路交汇处向南500米-中豪汇景湾', 7440, '2019-08-15', 2, '2019-08-05 17:24:20');
INSERT INTO `paid` VALUES (40, 37, 9, '张某', '金水区-金水东路与心仪路交汇处向南500米-中豪汇景湾', 7440, '2019-08-06', 2, '2019-08-06 09:08:07');
INSERT INTO `paid` VALUES (41, 37, 9, '张某', '金水区-金水东路与心仪路交汇处向南500米-中豪汇景湾', 7440, '2019-08-07', 2, '2019-08-07 18:38:50');
INSERT INTO `paid` VALUES (42, 45, 8, '周某', '金水区-杨金路街道-没有', 15500, '2019-08-08', 2, '2019-08-08 11:48:25');
COMMIT;

-- ----------------------------
-- Table structure for paid_state
-- ----------------------------
DROP TABLE IF EXISTS `paid_state`;
CREATE TABLE `paid_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收租状态',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paid_state
-- ----------------------------
BEGIN;
INSERT INTO `paid_state` VALUES (1, '未交租');
INSERT INTO `paid_state` VALUES (2, '已交租');
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `pnum` int(50) DEFAULT NULL COMMENT '权限编号',
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `title` varchar(255) DEFAULT NULL COMMENT '权限名字',
  `url` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES (100, 10010, 0, '房源管理', '', 'bank');
INSERT INTO `permission` VALUES (101, 10011, 100, '所有房源', 'allhouse.html', NULL);
INSERT INTO `permission` VALUES (102, 10012, 100, '待审核房源', 'unauditedhouse.html', NULL);
INSERT INTO `permission` VALUES (103, 10013, 100, '添加房源', 'houseresource.html', NULL);
INSERT INTO `permission` VALUES (200, 20010, 0, '账户管理', '', 'user');
INSERT INTO `permission` VALUES (201, 20011, 200, '员工管理', 'employee.html', NULL);
INSERT INTO `permission` VALUES (202, 20012, 200, '用户管理', 'customer.html', NULL);
INSERT INTO `permission` VALUES (300, 30010, 0, '统计分析', '', 'profile');
INSERT INTO `permission` VALUES (301, 30011, 300, '月出租量统计', 'charts.html', NULL);
INSERT INTO `permission` VALUES (302, 30012, 300, '月出租金额统计', 'echarts.html', NULL);
INSERT INTO `permission` VALUES (400, 40010, 0, '系统管理', '', 'setting');
INSERT INTO `permission` VALUES (401, 40011, 400, '角色管理', 'role.html', NULL);
INSERT INTO `permission` VALUES (402, 40012, 400, '权限管理', 'permission.html', NULL);
INSERT INTO `permission` VALUES (403, 40013, 400, '菜单管理', 'menu.html', NULL);
INSERT INTO `permission` VALUES (413, 10014, 100, '我的房源', 'myhouselist.html', NULL);
INSERT INTO `permission` VALUES (414, 10015, 100, '房源联系', 'leadhouse.html', NULL);
INSERT INTO `permission` VALUES (415, 10016, 100, '房源出租', 'houselease.html', NULL);
INSERT INTO `permission` VALUES (416, 50010, 0, '我要收租', NULL, 'account-book');
INSERT INTO `permission` VALUES (417, 50011, 416, '已出租房源', 'paidhouse.html', NULL);
INSERT INTO `permission` VALUES (418, 50012, 416, '待交租房源', 'nopaidhouse.html', NULL);
INSERT INTO `permission` VALUES (419, 50013, 416, '已交租房源', 'yetpaidhouse.html', NULL);
INSERT INTO `permission` VALUES (600, 60010, 0, '房屋报修', NULL, 'phone');
INSERT INTO `permission` VALUES (601, 60011, 600, '待处理房源', 'untreated.html', NULL);
INSERT INTO `permission` VALUES (602, 60012, 600, '已处理房源', 'processed.html', NULL);
COMMIT;

-- ----------------------------
-- Table structure for rented
-- ----------------------------
DROP TABLE IF EXISTS `rented`;
CREATE TABLE `rented` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '已出租房屋记录表（合同表）',
  `renter` int(11) DEFAULT NULL COMMENT '租客编号',
  `houseid` int(11) DEFAULT NULL COMMENT '房屋编号',
  `begintime` date DEFAULT NULL COMMENT '租房开始日期',
  `endtime` date DEFAULT NULL COMMENT '租房结束日期',
  `hrend` double(255,2) DEFAULT NULL COMMENT '全部租金',
  `charge` double(255,2) DEFAULT NULL COMMENT '手续费',
  `optdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of rented
-- ----------------------------
BEGIN;
INSERT INTO `rented` VALUES (24, 9, 37, '2019-08-05', '2019-11-04', 7200.00, 240.00, '2019-08-05 17:16:56');
INSERT INTO `rented` VALUES (25, 8, 45, '2019-08-08', '2019-10-01', 15000.00, 500.00, '2019-08-08 11:47:03');
INSERT INTO `rented` VALUES (26, 9, 46, '2019-08-08', '2019-09-28', 15000.00, 500.00, '2019-08-08 17:42:00');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rnum` int(50) DEFAULT NULL COMMENT '角色编号',
  `rname` varchar(255) DEFAULT NULL COMMENT '角色名字',
  `rdesc` varchar(255) DEFAULT NULL COMMENT '角色介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 19040233, '超级管理员', '超管拥有所有权限');
INSERT INTO `role` VALUES (2, 19040181, '经理', '负责房源审核 员工管理');
INSERT INTO `role` VALUES (3, 19040182, '经纪人', '负责添加房源 发布房源 出租房源');
INSERT INTO `role` VALUES (4, 19040301, '维修员', '负责已出租房屋报障问题');
COMMIT;

-- ----------------------------
-- Table structure for role_per
-- ----------------------------
DROP TABLE IF EXISTS `role_per`;
CREATE TABLE `role_per` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限菜单中间表',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `pid` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=413 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role_per
-- ----------------------------
BEGIN;
INSERT INTO `role_per` VALUES (318, 3, 103);
INSERT INTO `role_per` VALUES (319, 3, 413);
INSERT INTO `role_per` VALUES (320, 3, 414);
INSERT INTO `role_per` VALUES (321, 3, 415);
INSERT INTO `role_per` VALUES (322, 3, 300);
INSERT INTO `role_per` VALUES (323, 3, 301);
INSERT INTO `role_per` VALUES (324, 3, 100);
INSERT INTO `role_per` VALUES (348, 4, 600);
INSERT INTO `role_per` VALUES (349, 4, 601);
INSERT INTO `role_per` VALUES (350, 4, 602);
INSERT INTO `role_per` VALUES (374, 1, 100);
INSERT INTO `role_per` VALUES (375, 1, 101);
INSERT INTO `role_per` VALUES (376, 1, 102);
INSERT INTO `role_per` VALUES (377, 1, 103);
INSERT INTO `role_per` VALUES (378, 1, 413);
INSERT INTO `role_per` VALUES (379, 1, 414);
INSERT INTO `role_per` VALUES (380, 1, 415);
INSERT INTO `role_per` VALUES (381, 1, 200);
INSERT INTO `role_per` VALUES (382, 1, 201);
INSERT INTO `role_per` VALUES (383, 1, 202);
INSERT INTO `role_per` VALUES (384, 1, 300);
INSERT INTO `role_per` VALUES (385, 1, 301);
INSERT INTO `role_per` VALUES (386, 1, 302);
INSERT INTO `role_per` VALUES (387, 1, 400);
INSERT INTO `role_per` VALUES (388, 1, 401);
INSERT INTO `role_per` VALUES (389, 1, 402);
INSERT INTO `role_per` VALUES (390, 1, 403);
INSERT INTO `role_per` VALUES (391, 1, 416);
INSERT INTO `role_per` VALUES (392, 1, 417);
INSERT INTO `role_per` VALUES (393, 1, 418);
INSERT INTO `role_per` VALUES (394, 1, 419);
INSERT INTO `role_per` VALUES (395, 1, 600);
INSERT INTO `role_per` VALUES (396, 1, 601);
INSERT INTO `role_per` VALUES (397, 1, 602);
INSERT INTO `role_per` VALUES (405, 2, 101);
INSERT INTO `role_per` VALUES (406, 2, 102);
INSERT INTO `role_per` VALUES (407, 2, 201);
INSERT INTO `role_per` VALUES (408, 2, 300);
INSERT INTO `role_per` VALUES (409, 2, 301);
INSERT INTO `role_per` VALUES (410, 2, 302);
INSERT INTO `role_per` VALUES (411, 2, 100);
INSERT INTO `role_per` VALUES (412, 2, 200);
COMMIT;

-- ----------------------------
-- Table structure for seehistory
-- ----------------------------
DROP TABLE IF EXISTS `seehistory`;
CREATE TABLE `seehistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '看房记录表（预约看房的客户信息表）',
  `renter` int(11) DEFAULT NULL COMMENT '房客编号',
  `houseid` int(11) DEFAULT NULL COMMENT '房屋编号',
  `seetime` date DEFAULT NULL COMMENT '看房日期',
  `cusdesc` varchar(255) DEFAULT NULL COMMENT '房客介绍',
  `state` int(10) DEFAULT NULL COMMENT '预约看房状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of seehistory
-- ----------------------------
BEGIN;
INSERT INTO `seehistory` VALUES (46, 8, 32, '2019-08-07', 'jhklhj ', 3);
INSERT INTO `seehistory` VALUES (47, 8, 35, NULL, NULL, 1);
INSERT INTO `seehistory` VALUES (55, 8, 30, NULL, NULL, 2);
INSERT INTO `seehistory` VALUES (61, 8, 31, NULL, NULL, 1);
INSERT INTO `seehistory` VALUES (64, 10, 38, NULL, NULL, 1);
INSERT INTO `seehistory` VALUES (65, 10, 34, NULL, NULL, 1);
INSERT INTO `seehistory` VALUES (66, 10, 33, NULL, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for seehistory_state
-- ----------------------------
DROP TABLE IF EXISTS `seehistory_state`;
CREATE TABLE `seehistory_state` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '预约看房后客户的意向状态表',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of seehistory_state
-- ----------------------------
BEGIN;
INSERT INTO `seehistory_state` VALUES (1, '未看房');
INSERT INTO `seehistory_state` VALUES (2, '已看房');
INSERT INTO `seehistory_state` VALUES (3, '有意租');
INSERT INTO `seehistory_state` VALUES (4, '无意租');
COMMIT;

-- ----------------------------
-- Table structure for wrong
-- ----------------------------
DROP TABLE IF EXISTS `wrong`;
CREATE TABLE `wrong` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报障表',
  `houseid` int(11) DEFAULT NULL COMMENT '房源id',
  `tenantid` int(11) NOT NULL COMMENT '租户id',
  `tenant` varchar(255) DEFAULT NULL COMMENT '租户姓名',
  `hadr` varchar(255) DEFAULT NULL COMMENT '房屋地址',
  `data` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '报障时间',
  `detail` text COMMENT '报障详情',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '处理状态',
  `optdata` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wrong
-- ----------------------------
BEGIN;
INSERT INTO `wrong` VALUES (5, 11108, 9, '张某', '金水区-金水东路与心仪路交汇处向南500米-中豪汇景湾', '2019-08-05 17:26:04', '房子快塌了', 2, '2019-08-05 17:26:15');
INSERT INTO `wrong` VALUES (6, 11108, 9, '张某', '金水区-金水东路与心仪路交汇处向南500米-中豪汇景湾', '2019-08-08 10:07:49', '赶紧来', 2, '2019-08-08 10:08:12');
INSERT INTO `wrong` VALUES (7, 11115, 8, '周某', '金水区-杨金路街道-没有', '2019-08-08 11:51:42', '房子塌了', 2, '2019-08-08 11:51:56');
COMMIT;

-- ----------------------------
-- Table structure for wrong_state
-- ----------------------------
DROP TABLE IF EXISTS `wrong_state`;
CREATE TABLE `wrong_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报障处理状态表',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wrong_state
-- ----------------------------
BEGIN;
INSERT INTO `wrong_state` VALUES (1, '未处理');
INSERT INTO `wrong_state` VALUES (2, '已处理');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
