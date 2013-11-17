-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.16 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 jysecurity 的数据库结构
CREATE DATABASE IF NOT EXISTS `jysecurity` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jysecurity`;


-- 导出  表 jysecurity.behavior 结构
DROP TABLE IF EXISTS `behavior`;
CREATE TABLE IF NOT EXISTS `behavior` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `incident_date` date DEFAULT NULL COMMENT '时间',
  `incident_location` varchar(255) DEFAULT NULL COMMENT '地点',
  `description` varchar(500) DEFAULT NULL COMMENT '经过',
  `result` varchar(500) DEFAULT NULL COMMENT '结果',
  `type` int(2) DEFAULT NULL COMMENT '行为类型：1良好行为，2不良行为',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  jysecurity.behavior 的数据：~2 rows (大约)
DELETE FROM `behavior`;
/*!40000 ALTER TABLE `behavior` DISABLE KEYS */;
INSERT INTO `behavior` (`id`, `idcard`, `name`, `incident_date`, `incident_location`, `description`, `result`, `type`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '3', NULL, '2013-11-14', '市北区十五中', '归还失主物品', '表彰', 1, '2013-11-17 11:57:39', '2013-11-17 11:57:39', '1', '1', 0),
	(2, '3', NULL, '2013-11-06', '等等', '等等', '等等', 2, '2013-11-17 12:18:47', '2013-11-17 17:42:41', '1', '1', 0);
/*!40000 ALTER TABLE `behavior` ENABLE KEYS */;


-- 导出  表 jysecurity.discipline 结构
DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `discipline_date` date DEFAULT NULL COMMENT '违章违纪时间',
  `description` varchar(500) DEFAULT NULL COMMENT '事由',
  `gist` varchar(500) DEFAULT NULL COMMENT '处罚依据',
  `fine` double(10,2) DEFAULT NULL COMMENT '罚款单号',
  `fine_number` varchar(20) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  jysecurity.discipline 的数据：~0 rows (大约)
DELETE FROM `discipline`;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` (`id`, `idcard`, `position`, `discipline_date`, `description`, `gist`, `fine`, `fine_number`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '3', '11', '2013-11-20', '11', '11', 12.00, NULL, '2013-11-17 21:47:33', '2013-11-17 21:50:21', '1', '1', 0),
	(2, '3', '11', '2013-11-20', '11', '11', 11.00, NULL, '2013-11-17 21:49:08', '2013-11-17 21:49:08', '1', '1', 1),
	(3, '3', '宿舍', '2013-11-27', '1', '1', 1.00, NULL, '2013-11-17 21:49:27', '2013-11-17 21:49:27', '1', '1', 0);
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;


-- 导出  表 jysecurity.drivers 结构
DROP TABLE IF EXISTS `drivers`;
CREATE TABLE IF NOT EXISTS `drivers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffid` varchar(20) NOT NULL COMMENT '工号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `idcard` varchar(25) NOT NULL COMMENT '身份证',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  `birth` varchar(25) DEFAULT NULL COMMENT '生日',
  `driver_id` varchar(30) DEFAULT NULL COMMENT '驾驶证号',
  `mobile_phone` varchar(20) NOT NULL COMMENT '手机',
  `home_phone` varchar(20) NOT NULL COMMENT '家庭电话',
  `line_number` varchar(20) NOT NULL COMMENT '线路',
  `bus_number` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `driving_type` varchar(255) DEFAULT NULL COMMENT '准驾车型',
  `pass_time` varchar(25) DEFAULT NULL COMMENT '取得A3或A1资格时间',
  `company` varchar(30) NOT NULL COMMENT '所在分公司',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) NOT NULL DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340;

-- 正在导出表  jysecurity.drivers 的数据：~14 rows (大约)
DELETE FROM `drivers`;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` (`id`, `staffid`, `name`, `idcard`, `sex`, `birth`, `driver_id`, `mobile_phone`, `home_phone`, `line_number`, `bus_number`, `driving_type`, `pass_time`, `company`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '', '徐涛', '37020219870628541X', '男', '', '123', '13668866295', '', '623', '', '', '', '公司本部', '2013-10-26 17:23:30', '2013-10-27 18:13:07', NULL, '', 0),
	(2, '', '张立刚', '370202198612345678', '男', '', '456', '123456789010', '', '623', '', '', '', '公司本部', '2013-10-26 17:23:33', '2013-10-27 18:14:37', NULL, '', 0),
	(3, '', '史秀群', '370201198212345678', '女', '1982-08-19', '1234', '1357951598451', '', '632', '', '', '2002-10-10', '兴达分公司', '2013-10-26 17:23:35', '2013-10-27 22:30:07', NULL, '', 0),
	(4, '', '周琦', '370201567801654640', '女', '', '12345', '16154981516', '', '609', '', '', '', '公司本部', '2013-10-26 17:23:36', '2013-10-27 18:15:47', NULL, '', 0),
	(5, '', '5', '123456', '', NULL, '123456', '', '', '', NULL, NULL, '2013-10-26', '', '2013-10-26 17:23:38', '2013-10-26 17:23:51', NULL, NULL, 0),
	(6, '', '6', '1234567', '', NULL, '1234567', '', '', '', NULL, NULL, '2013-10-26', '', '2013-10-26 17:23:40', '2013-10-26 17:23:53', NULL, NULL, 0),
	(7, '1001', '7', '333333333', '', '2013-10-10', '', '123123123', '', '110', 'b0102', 'A1', '2013-10-16', '温馨巴士', '2013-10-27 18:11:11', '2013-10-28 09:52:16', NULL, '', 0),
	(8, '', '8', '', '', NULL, '', '', '', '', NULL, NULL, NULL, '', '2013-10-27 18:11:14', '2013-10-27 18:11:21', NULL, NULL, 0),
	(9, '', '9', '', '', NULL, '', '', '', '', NULL, NULL, NULL, '', '2013-10-27 18:11:16', '2013-10-27 18:11:23', NULL, NULL, 1),
	(10, '', '1', '1', '1', '2013-10-09', NULL, '123', '', '2', '', '', '2013-10-16', '1', '2013-10-27 18:04:24', '2013-10-27 18:08:05', '', '', 1),
	(11, '', '了', '111', '飞', '', NULL, '2323', '', '5', '', '', '', '', '2013-10-27 18:10:34', '2013-10-27 18:10:34', '', '', 1),
	(12, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-10-27 18:14:59', '2013-10-27 18:14:59', '', '', 1),
	(13, '', '2', '233', '2', '', NULL, '2', '', '2', '', '', '', '2', '2013-10-27 22:34:53', '2013-10-27 22:35:14', '', '', 0),
	(14, '', 'zhaotj', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-10-27 22:58:44', '2013-10-27 22:58:44', '', '', 1);
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;


-- 导出  表 jysecurity.safety_distance 结构
DROP TABLE IF EXISTS `safety_distance`;
CREATE TABLE IF NOT EXISTS `safety_distance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `bus_number` varchar(20) DEFAULT NULL COMMENT '车号',
  `year` int(5) DEFAULT NULL COMMENT '年份',
  `month` int(2) DEFAULT NULL COMMENT '月份',
  `mileage_month` double(7,2) DEFAULT NULL COMMENT '本月安全里程',
  `mileage_year` double(10,2) DEFAULT NULL COMMENT '年度安全里程',
  `mileage` double(10,2) DEFAULT NULL COMMENT '累计安全里程',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  jysecurity.safety_distance 的数据：~0 rows (大约)
DELETE FROM `safety_distance`;
/*!40000 ALTER TABLE `safety_distance` DISABLE KEYS */;
/*!40000 ALTER TABLE `safety_distance` ENABLE KEYS */;


-- 导出  表 jysecurity.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  jysecurity.sys_user 的数据：~1 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `user_id`, `password`, `name`, `create_datetime`, `modifi_datetime`, `deleted`) VALUES
	(1, 'admin', 'admin', '徐涛', '2013-10-26 14:20:59', '2013-10-26 14:21:09', 0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


-- 导出  表 jysecurity.traffic_accident 结构
DROP TABLE IF EXISTS `traffic_accident`;
CREATE TABLE IF NOT EXISTS `traffic_accident` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `company` varchar(30) DEFAULT NULL COMMENT '分公司',
  `line_number` varchar(20) DEFAULT NULL COMMENT '线路',
  `bus_number` varchar(20) DEFAULT NULL COMMENT '事故车号',
  `name` varchar(20) DEFAULT NULL COMMENT '驾驶员',
  `accident_date` date DEFAULT NULL COMMENT '事故时间',
  `accident_location` varchar(255) DEFAULT NULL COMMENT '事故地点',
  `accident_summary` varchar(500) DEFAULT NULL COMMENT '事故经过',
  `accident_liability` varchar(500) DEFAULT NULL COMMENT '责任',
  `result` varchar(500) DEFAULT NULL COMMENT '处理情况',
  `reporter` varchar(20) DEFAULT NULL COMMENT '汇报人',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  jysecurity.traffic_accident 的数据：~6 rows (大约)
DELETE FROM `traffic_accident`;
/*!40000 ALTER TABLE `traffic_accident` DISABLE KEYS */;
INSERT INTO `traffic_accident` (`id`, `idcard`, `company`, `line_number`, `bus_number`, `name`, `accident_date`, `accident_location`, `accident_summary`, `accident_liability`, `result`, `reporter`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '1', '1', '1', '1', '1', '2013-10-28', '1', '1', '11', '1', '1', '2013-10-28 11:26:47', '2013-10-28 11:26:49', '1', '1', 0),
	(2, '2', '2', '2', '2', '2', '2013-10-28', '2', '2', '2', '2', '3', '2013-10-28 11:28:19', '2013-10-28 11:28:20', '1', '1', 0),
	(3, '3', '1', '1', '2', NULL, '2010-10-12', '123', '', '123', '123', '123', '2013-10-28 14:20:24', '2013-10-28 14:36:57', '1', '1', 0),
	(4, '3, _empty', '1', '1', '1', NULL, '2013-10-09', '1', '1', '1', '1', '1', '2013-10-28 14:22:55', '2013-10-28 14:22:55', '1', '1', 0),
	(5, '3', '2', '1', '1', NULL, '2013-10-10', '3', '3', '3', '3', '3', '2013-10-28 14:46:07', '2013-10-28 14:46:07', '1', '1', 1),
	(6, '3', '3', '3', '3', NULL, '2013-10-10', '3', '3', '3', '3', '3', '2013-10-28 14:55:00', '2013-10-28 14:55:00', '1', '1', 0);
/*!40000 ALTER TABLE `traffic_accident` ENABLE KEYS */;


-- 导出  表 jysecurity.traffic_violation 结构
DROP TABLE IF EXISTS `traffic_violation`;
CREATE TABLE IF NOT EXISTS `traffic_violation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `bus_number` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `name` varchar(20) DEFAULT NULL COMMENT '驾驶员',
  `company` varchar(20) DEFAULT NULL COMMENT '所属公司',
  `violation_date` date DEFAULT NULL COMMENT '违章时间',
  `violation_location` varchar(255) DEFAULT NULL COMMENT '违章地点',
  `violation_reason` varchar(255) DEFAULT NULL COMMENT '违章原因',
  `points` int(11) DEFAULT NULL COMMENT '扣分',
  `fine` double(7,2) DEFAULT NULL COMMENT '罚款',
  `assessment_date` date DEFAULT NULL COMMENT '绩效考核时间',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  jysecurity.traffic_violation 的数据：~4 rows (大约)
DELETE FROM `traffic_violation`;
/*!40000 ALTER TABLE `traffic_violation` DISABLE KEYS */;
INSERT INTO `traffic_violation` (`id`, `idcard`, `bus_number`, `name`, `company`, `violation_date`, `violation_location`, `violation_reason`, `points`, `fine`, `assessment_date`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '3', '1', NULL, '1', '2013-10-10', '1', '1', 1, 1.00, '2013-10-17', '2013-10-28 16:16:44', '2013-10-28 16:16:44', '1', '1', 0),
	(2, '3', '2', NULL, '2', '2013-10-17', '2', '2', 2, 2.00, '2013-10-16', '2013-10-28 16:16:58', '2013-10-28 16:28:40', '1', '1', 0),
	(3, '3', '21', NULL, '2', '2013-10-16', '12', '21', 21, 21.00, '2013-10-19', '2013-10-28 16:29:18', '2013-10-28 16:29:43', '1', '1', 1),
	(4, '2', '1', NULL, '1', '2013-10-09', '21', '21', 12, 12.00, '2013-10-16', '2013-10-28 16:45:44', '2013-10-28 16:45:44', '1', '1', 0);
/*!40000 ALTER TABLE `traffic_violation` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;