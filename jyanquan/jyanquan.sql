# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.5.16
# Server OS:                    Win32
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2013-12-27 21:09:03
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for jysecurity
DROP DATABASE IF EXISTS `jysecurity`;
CREATE DATABASE IF NOT EXISTS `jysecurity` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jysecurity`;


# Dumping structure for table jysecurity.badbehavior
DROP TABLE IF EXISTS `badbehavior`;
CREATE TABLE IF NOT EXISTS `badbehavior` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `incident_date` date DEFAULT NULL COMMENT '时间',
  `incident_location` varchar(255) DEFAULT NULL COMMENT '地点',
  `description` varchar(500) DEFAULT NULL COMMENT '经过',
  `result` varchar(500) DEFAULT NULL COMMENT '结果',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.badbehavior: ~1 rows (approximately)
DELETE FROM `badbehavior`;
/*!40000 ALTER TABLE `badbehavior` DISABLE KEYS */;
INSERT INTO `badbehavior` (`id`, `idcard`, `name`, `incident_date`, `incident_location`, `description`, `result`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(3, '1', NULL, '2013-12-12', '122', '21', '12', '2013-12-22 13:59:34', '2013-12-22 13:59:42', '1', '1', 0);
/*!40000 ALTER TABLE `badbehavior` ENABLE KEYS */;


# Dumping structure for table jysecurity.behavior
DROP TABLE IF EXISTS `behavior`;
CREATE TABLE IF NOT EXISTS `behavior` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `incident_date` date DEFAULT NULL COMMENT '时间',
  `incident_location` varchar(255) DEFAULT NULL COMMENT '地点',
  `description` varchar(500) DEFAULT NULL COMMENT '经过',
  `result` varchar(500) DEFAULT NULL COMMENT '结果',
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.behavior: ~2 rows (approximately)
DELETE FROM `behavior`;
/*!40000 ALTER TABLE `behavior` DISABLE KEYS */;
INSERT INTO `behavior` (`id`, `idcard`, `name`, `incident_date`, `incident_location`, `description`, `result`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '2', NULL, '2013-12-04', '21', '21', '21', '2013-12-12 21:50:59', '2013-12-12 21:50:59', '1', '1', 0),
	(2, '1', NULL, '2013-12-11', '1', '1', '1', '2013-12-21 01:40:19', '2013-12-21 01:40:19', '1', '1', 0);
/*!40000 ALTER TABLE `behavior` ENABLE KEYS */;


# Dumping structure for table jysecurity.discipline
DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcard` varchar(20) DEFAULT NULL COMMENT '身份证',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `discipline_date` date DEFAULT NULL COMMENT '违章违纪时间',
  `description` varchar(500) DEFAULT NULL COMMENT '事由',
  `gist` varchar(500) DEFAULT NULL COMMENT '处罚依据',
  `fine` varchar(50) DEFAULT NULL COMMENT '罚款单号',
  `fine_number` varchar(50) DEFAULT NULL,
  `create_datetime` datetime DEFAULT NULL,
  `modifi_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  `modifi_user_id` varchar(20) DEFAULT NULL,
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除：1删除，0未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.discipline: ~2 rows (approximately)
DELETE FROM `discipline`;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` (`id`, `idcard`, `position`, `discipline_date`, `description`, `gist`, `fine`, `fine_number`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '2', '231', '2013-12-12', '2313213', '213321321', '13232132.00', NULL, '2013-12-12 21:51:17', '2013-12-12 21:51:17', '1', '1', 0),
	(2, '1', '1', '2013-12-11', '1', '1', '1.00', NULL, '2013-12-21 01:40:06', '2013-12-21 01:40:06', '1', '1', 0);
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;


# Dumping structure for table jysecurity.drivers
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
  `home_phone` varchar(200) NOT NULL COMMENT '家庭住址',
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340;

# Dumping data for table jysecurity.drivers: ~27 rows (approximately)
DELETE FROM `drivers`;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` (`id`, `staffid`, `name`, `idcard`, `sex`, `birth`, `driver_id`, `mobile_phone`, `home_phone`, `line_number`, `bus_number`, `driving_type`, `pass_time`, `company`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '', '徐涛', '37020219870628541X', '男', '', '123', '13668866295', '', '623', '', '', '', '公司本部', '2013-10-26 17:23:30', '2013-10-27 18:13:07', NULL, '', 0),
	(2, '', '张立刚', '370202198612345678', '男', '', '456', '123456789010', '', '623', '', '', '', '公司本部', '2013-10-26 17:23:33', '2013-10-27 18:14:37', NULL, '', 0),
	(3, '', '史秀群', '370201198212345678', '女', '1982-08-19', '1234', '1357951598451', '', '632', '', '', '2002-10-10', '兴达分公司', '2013-10-26 17:23:35', '2013-10-27 22:30:07', NULL, '', 0),
	(4, '', '周琦', '370201567801654640', '女', '', '12345', '16154981516', '', '609', '', '', '', '公司本部', '2013-10-26 17:23:36', '2013-12-22 21:36:49', NULL, '', 0),
	(5, '', '5', '123456', '', NULL, '123456', '', '', '', NULL, NULL, '2013-10-26', '', '2013-10-26 17:23:38', '2013-10-26 17:23:51', NULL, NULL, 0),
	(6, '', '6', '1234567', '', NULL, '1234567', '', '', '', NULL, NULL, '2013-10-26', '', '2013-10-26 17:23:40', '2013-10-26 17:23:53', NULL, NULL, 0),
	(7, '1001', '7', '333333333', '', '2013-10-10', '', '123123123', '', '110', 'b0102', 'A1', '2013-10-16', '温馨巴士', '2013-10-27 18:11:11', '2013-10-28 09:52:16', NULL, '', 0),
	(8, '', '8', '', '', NULL, '', '', '', '', NULL, NULL, NULL, '', '2013-10-27 18:11:14', '2013-10-27 18:11:21', NULL, NULL, 0),
	(9, '', '9', '', '', NULL, '', '', '', '', NULL, NULL, NULL, '', '2013-10-27 18:11:16', '2013-10-27 18:11:23', NULL, NULL, 1),
	(10, '', '1', '1', '1', '2013-10-09', NULL, '123', '', '2', '', '', '2013-10-16', '1', '2013-10-27 18:04:24', '2013-10-27 18:08:05', '', '', 1),
	(11, '', '了', '111', '飞', '', NULL, '2323', '', '5', '', '', '', '', '2013-10-27 18:10:34', '2013-10-27 18:10:34', '', '', 1),
	(12, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-10-27 18:14:59', '2013-10-27 18:14:59', '', '', 1),
	(13, '', '2', '233', '2', '', NULL, '2', '', '2', '', '', '', '2', '2013-10-27 22:34:53', '2013-10-27 22:35:14', '', '', 0),
	(14, '', 'zhaotj', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-10-27 22:58:44', '2013-10-27 22:58:44', '', '', 1),
	(15, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-12-12 21:51:44', '2013-12-12 21:51:44', '', '', 0),
	(16, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-12-12 21:51:49', '2013-12-12 21:51:49', '', '', 0),
	(17, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-12-12 21:51:54', '2013-12-12 21:51:54', '', '', 0),
	(18, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-12-12 21:52:02', '2013-12-12 21:52:02', '', '', 0),
	(19, '', '1', '1', '1', '', NULL, '1', '', '1', '', '', '', '1', '2013-12-12 21:52:08', '2013-12-12 21:52:08', '', '', 0),
	(20, '', '2', '2', '2', '', NULL, '2', '', '2', '', '', '', '2', '2013-12-12 21:52:13', '2013-12-12 21:52:13', '', '', 0),
	(21, '', '2', '2', '2', '', NULL, '2', '', '2', '', '', '', '2', '2013-12-12 21:52:37', '2013-12-12 21:52:37', '', '', 0),
	(22, '', '2', '2', '2', '', NULL, '2', '', '2', '', '', '', '2', '2013-12-12 21:52:42', '2013-12-12 21:52:42', '', '', 0),
	(23, '', '2', '2', '2', '', NULL, '2', '', '2', '', '', '', '2', '2013-12-12 21:52:46', '2013-12-12 21:52:46', '', '', 0),
	(24, '', '3', '3', '3', '', NULL, '3', '', '3', '', '', '', '3', '2013-12-12 21:52:52', '2013-12-12 21:52:52', '', '', 0),
	(25, '', '3', '3', '3', '', NULL, '3', '', '3', '', '', '', '3', '2013-12-12 21:53:56', '2013-12-12 21:53:56', '', '', 0),
	(26, '', '4', '4', '4', '', NULL, '4', '', '4', '', '', '', '4', '2013-12-12 21:54:15', '2013-12-12 21:54:15', '', '', 0),
	(27, '', '121', '21', '21', '', NULL, '21', '', '21', '', '', '', '21', '2013-12-14 11:44:08', '2013-12-14 11:44:08', '', '', 0);
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;


# Dumping structure for table jysecurity.mechanical_accident
DROP TABLE IF EXISTS `mechanical_accident`;
CREATE TABLE IF NOT EXISTS `mechanical_accident` (
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.mechanical_accident: ~3 rows (approximately)
DELETE FROM `mechanical_accident`;
/*!40000 ALTER TABLE `mechanical_accident` DISABLE KEYS */;
INSERT INTO `mechanical_accident` (`id`, `idcard`, `company`, `line_number`, `bus_number`, `name`, `accident_date`, `accident_location`, `accident_summary`, `accident_liability`, `result`, `reporter`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '1', '1', '1', '1', NULL, '2013-12-18', '1', '1', '1', '1', '1', '2013-12-14 21:43:11', '2013-12-14 21:43:11', '1', '1', 0),
	(2, '1', '21', '12', '1', NULL, '2013-12-11', '11', '11', '11', '11', '11', '2013-12-14 21:44:10', '2013-12-14 21:44:10', '1', '1', 0),
	(3, '1', '21', '1', '1', NULL, '2013-12-20', '21', '321', '21', '21', '21', '2013-12-14 21:44:22', '2013-12-14 21:44:34', '1', '1', 1);
/*!40000 ALTER TABLE `mechanical_accident` ENABLE KEYS */;


# Dumping structure for table jysecurity.safety_distance
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.safety_distance: ~8 rows (approximately)
DELETE FROM `safety_distance`;
/*!40000 ALTER TABLE `safety_distance` DISABLE KEYS */;
INSERT INTO `safety_distance` (`id`, `idcard`, `bus_number`, `year`, `month`, `mileage_month`, `mileage_year`, `mileage`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '1', '鲁b123', 2013, 3, 1344.98, 0.00, 0.00, '2013-12-14 16:45:52', '2013-12-14 16:57:22', '1', '1', 0),
	(2, '1', '2222', 2013, 1, 22222.00, 0.00, 0.00, '2013-12-14 16:48:44', '2013-12-14 16:48:44', '1', '1', 1),
	(3, '1', 'fdsfds', 2013, 2, 123.00, NULL, NULL, '2013-12-14 20:10:28', '2013-12-14 20:10:28', '1', '1', 0),
	(4, '1', 'ddd', 2013, 4, 32432.00, NULL, NULL, '2013-12-14 20:11:51', '2013-12-14 20:34:51', '1', '1', 0),
	(5, '1', 'sdfa', 2013, 5, 12345.00, NULL, NULL, '2013-12-14 20:16:39', '2013-12-14 20:16:39', '1', '1', 0),
	(6, '1', 'sdffds', 2013, 6, 432.00, NULL, NULL, '2013-12-14 20:19:28', '2013-12-14 20:19:28', '1', '1', 1),
	(7, '1', 'adsadad', 2013, 7, 213.00, NULL, NULL, '2013-12-14 20:31:33', '2013-12-14 20:31:33', '1', '1', 0),
	(8, '1', 'ewrsdf', 2013, 8, 342.00, NULL, NULL, '2013-12-14 20:33:24', '2013-12-14 20:33:24', '1', '1', 0);
/*!40000 ALTER TABLE `safety_distance` ENABLE KEYS */;


# Dumping structure for table jysecurity.sys_role
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL COMMENT '用户dbid',
  `role_name` varchar(30) DEFAULT NULL COMMENT '权限名称',
  `role_value` tinyint(2) DEFAULT NULL COMMENT '权限值1,0有效无效',
  `create_datetime` datetime DEFAULT NULL,
  `create_user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1089 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.sys_role: ~129 rows (approximately)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `user_id`, `role_name`, `role_value`, `create_datetime`, `create_user_id`) VALUES
	(917, '1', 'driver_show', 1, '2013-12-27 00:00:00', ''),
	(918, '1', 'driver_add', 1, '2013-12-27 00:00:00', ''),
	(919, '1', 'driver_edit', 1, '2013-12-27 00:00:00', ''),
	(920, '1', 'driver_del', 1, '2013-12-27 00:00:00', ''),
	(921, '1', 'select_show', 1, '2013-12-27 00:00:00', ''),
	(922, '1', 'select_add', 1, '2013-12-27 00:00:00', ''),
	(923, '1', 'select_edit', 1, '2013-12-27 00:00:00', ''),
	(924, '1', 'select_del', 1, '2013-12-27 00:00:00', ''),
	(925, '1', 'muser_show', 1, '2013-12-27 00:00:00', ''),
	(926, '1', 'muser_add', 1, '2013-12-27 00:00:00', ''),
	(927, '1', 'muser_edit', 1, '2013-12-27 00:00:00', ''),
	(928, '1', 'muser_del', 1, '2013-12-27 00:00:00', ''),
	(929, '1', 'muser_pw', 1, '2013-12-27 00:00:00', ''),
	(930, '1', 'driverinfo_edit', 1, '2013-12-27 00:00:00', ''),
	(931, '1', 'driverinfo_del', 1, '2013-12-27 00:00:00', ''),
	(932, '1', 'accident_show', 1, '2013-12-27 00:00:00', ''),
	(933, '1', 'accident_add', 1, '2013-12-27 00:00:00', ''),
	(934, '1', 'accident_edit', 1, '2013-12-27 00:00:00', ''),
	(935, '1', 'accident_del', 1, '2013-12-27 00:00:00', ''),
	(936, '1', 'violation_show', 1, '2013-12-27 00:00:00', ''),
	(937, '1', 'violation_add', 1, '2013-12-27 00:00:00', ''),
	(938, '1', 'violation_edit', 1, '2013-12-27 00:00:00', ''),
	(939, '1', 'violation_del', 1, '2013-12-27 00:00:00', ''),
	(940, '1', 'mechanical_show', 1, '2013-12-27 00:00:00', ''),
	(941, '1', 'mechanical_add', 1, '2013-12-27 00:00:00', ''),
	(942, '1', 'mechanical_edit', 1, '2013-12-27 00:00:00', ''),
	(943, '1', 'mechanical_del', 1, '2013-12-27 00:00:00', ''),
	(944, '1', 'behavior_show', 1, '2013-12-27 00:00:00', ''),
	(945, '1', 'behavior_add', 1, '2013-12-27 00:00:00', ''),
	(946, '1', 'behavior_edit', 1, '2013-12-27 00:00:00', ''),
	(947, '1', 'behavior_del', 1, '2013-12-27 00:00:00', ''),
	(948, '1', 'badbehavior_show', 1, '2013-12-27 00:00:00', ''),
	(949, '1', 'badbehavior_add', 1, '2013-12-27 00:00:00', ''),
	(950, '1', 'badbehavior_edit', 1, '2013-12-27 00:00:00', ''),
	(951, '1', 'badbehavior_del', 1, '2013-12-27 00:00:00', ''),
	(952, '1', 'discipline_show', 1, '2013-12-27 00:00:00', ''),
	(953, '1', 'discipline_add', 1, '2013-12-27 00:00:00', ''),
	(954, '1', 'discipline_edit', 1, '2013-12-27 00:00:00', ''),
	(955, '1', 'discipline_del', 1, '2013-12-27 00:00:00', ''),
	(956, '1', 'distance_show', 1, '2013-12-27 00:00:00', ''),
	(957, '1', 'distance_add', 1, '2013-12-27 00:00:00', ''),
	(958, '1', 'distance_edit', 1, '2013-12-27 00:00:00', ''),
	(959, '1', 'distance_del', 1, '2013-12-27 00:00:00', ''),
	(1003, '2', 'driver_show', 1, '2013-12-27 00:00:00', ''),
	(1004, '2', 'driver_add', 1, '2013-12-27 00:00:00', ''),
	(1005, '2', 'driver_edit', 0, '2013-12-27 00:00:00', ''),
	(1006, '2', 'driver_del', 0, '2013-12-27 00:00:00', ''),
	(1007, '2', 'select_show', 1, '2013-12-27 00:00:00', ''),
	(1008, '2', 'select_add', 0, '2013-12-27 00:00:00', ''),
	(1009, '2', 'select_edit', 0, '2013-12-27 00:00:00', ''),
	(1010, '2', 'select_del', 0, '2013-12-27 00:00:00', ''),
	(1011, '2', 'muser_show', 0, '2013-12-27 00:00:00', ''),
	(1012, '2', 'muser_add', 0, '2013-12-27 00:00:00', ''),
	(1013, '2', 'muser_edit', 0, '2013-12-27 00:00:00', ''),
	(1014, '2', 'muser_del', 0, '2013-12-27 00:00:00', ''),
	(1015, '2', 'muser_pw', 0, '2013-12-27 00:00:00', ''),
	(1016, '2', 'driverinfo_edit', 0, '2013-12-27 00:00:00', ''),
	(1017, '2', 'driverinfo_del', 0, '2013-12-27 00:00:00', ''),
	(1018, '2', 'accident_show', 0, '2013-12-27 00:00:00', ''),
	(1019, '2', 'accident_add', 0, '2013-12-27 00:00:00', ''),
	(1020, '2', 'accident_edit', 0, '2013-12-27 00:00:00', ''),
	(1021, '2', 'accident_del', 0, '2013-12-27 00:00:00', ''),
	(1022, '2', 'violation_show', 0, '2013-12-27 00:00:00', ''),
	(1023, '2', 'violation_add', 0, '2013-12-27 00:00:00', ''),
	(1024, '2', 'violation_edit', 0, '2013-12-27 00:00:00', ''),
	(1025, '2', 'violation_del', 0, '2013-12-27 00:00:00', ''),
	(1026, '2', 'mechanical_show', 0, '2013-12-27 00:00:00', ''),
	(1027, '2', 'mechanical_add', 0, '2013-12-27 00:00:00', ''),
	(1028, '2', 'mechanical_edit', 0, '2013-12-27 00:00:00', ''),
	(1029, '2', 'mechanical_del', 0, '2013-12-27 00:00:00', ''),
	(1030, '2', 'behavior_show', 0, '2013-12-27 00:00:00', ''),
	(1031, '2', 'behavior_add', 0, '2013-12-27 00:00:00', ''),
	(1032, '2', 'behavior_edit', 0, '2013-12-27 00:00:00', ''),
	(1033, '2', 'behavior_del', 0, '2013-12-27 00:00:00', ''),
	(1034, '2', 'badbehavior_show', 0, '2013-12-27 00:00:00', ''),
	(1035, '2', 'badbehavior_add', 0, '2013-12-27 00:00:00', ''),
	(1036, '2', 'badbehavior_edit', 0, '2013-12-27 00:00:00', ''),
	(1037, '2', 'badbehavior_del', 0, '2013-12-27 00:00:00', ''),
	(1038, '2', 'discipline_show', 0, '2013-12-27 00:00:00', ''),
	(1039, '2', 'discipline_add', 0, '2013-12-27 00:00:00', ''),
	(1040, '2', 'discipline_edit', 0, '2013-12-27 00:00:00', ''),
	(1041, '2', 'discipline_del', 0, '2013-12-27 00:00:00', ''),
	(1042, '2', 'distance_show', 0, '2013-12-27 00:00:00', ''),
	(1043, '2', 'distance_add', 0, '2013-12-27 00:00:00', ''),
	(1044, '2', 'distance_edit', 0, '2013-12-27 00:00:00', ''),
	(1045, '2', 'distance_del', 0, '2013-12-27 00:00:00', ''),
	(1046, '3', 'driver_show', 1, '2013-12-27 00:00:00', ''),
	(1047, '3', 'driver_add', 1, '2013-12-27 00:00:00', ''),
	(1048, '3', 'driver_edit', 1, '2013-12-27 00:00:00', ''),
	(1049, '3', 'driver_del', 0, '2013-12-27 00:00:00', ''),
	(1050, '3', 'select_show', 1, '2013-12-27 00:00:00', ''),
	(1051, '3', 'select_add', 0, '2013-12-27 00:00:00', ''),
	(1052, '3', 'select_edit', 0, '2013-12-27 00:00:00', ''),
	(1053, '3', 'select_del', 0, '2013-12-27 00:00:00', ''),
	(1054, '3', 'muser_show', 0, '2013-12-27 00:00:00', ''),
	(1055, '3', 'muser_add', 0, '2013-12-27 00:00:00', ''),
	(1056, '3', 'muser_edit', 0, '2013-12-27 00:00:00', ''),
	(1057, '3', 'muser_del', 0, '2013-12-27 00:00:00', ''),
	(1058, '3', 'muser_pw', 0, '2013-12-27 00:00:00', ''),
	(1059, '3', 'driverinfo_edit', 1, '2013-12-27 00:00:00', ''),
	(1060, '3', 'driverinfo_del', 1, '2013-12-27 00:00:00', ''),
	(1061, '3', 'accident_show', 0, '2013-12-27 00:00:00', ''),
	(1062, '3', 'accident_add', 1, '2013-12-27 00:00:00', ''),
	(1063, '3', 'accident_edit', 0, '2013-12-27 00:00:00', ''),
	(1064, '3', 'accident_del', 1, '2013-12-27 00:00:00', ''),
	(1065, '3', 'violation_show', 0, '2013-12-27 00:00:00', ''),
	(1066, '3', 'violation_add', 1, '2013-12-27 00:00:00', ''),
	(1067, '3', 'violation_edit', 0, '2013-12-27 00:00:00', ''),
	(1068, '3', 'violation_del', 1, '2013-12-27 00:00:00', ''),
	(1069, '3', 'mechanical_show', 1, '2013-12-27 00:00:00', ''),
	(1070, '3', 'mechanical_add', 1, '2013-12-27 00:00:00', ''),
	(1071, '3', 'mechanical_edit', 0, '2013-12-27 00:00:00', ''),
	(1072, '3', 'mechanical_del', 1, '2013-12-27 00:00:00', ''),
	(1073, '3', 'behavior_show', 1, '2013-12-27 00:00:00', ''),
	(1074, '3', 'behavior_add', 1, '2013-12-27 00:00:00', ''),
	(1075, '3', 'behavior_edit', 1, '2013-12-27 00:00:00', ''),
	(1076, '3', 'behavior_del', 0, '2013-12-27 00:00:00', ''),
	(1077, '3', 'badbehavior_show', 1, '2013-12-27 00:00:00', ''),
	(1078, '3', 'badbehavior_add', 1, '2013-12-27 00:00:00', ''),
	(1079, '3', 'badbehavior_edit', 1, '2013-12-27 00:00:00', ''),
	(1080, '3', 'badbehavior_del', 0, '2013-12-27 00:00:00', ''),
	(1081, '3', 'discipline_show', 1, '2013-12-27 00:00:00', ''),
	(1082, '3', 'discipline_add', 0, '2013-12-27 00:00:00', ''),
	(1083, '3', 'discipline_edit', 0, '2013-12-27 00:00:00', ''),
	(1084, '3', 'discipline_del', 0, '2013-12-27 00:00:00', ''),
	(1085, '3', 'distance_show', 1, '2013-12-27 00:00:00', ''),
	(1086, '3', 'distance_add', 0, '2013-12-27 00:00:00', ''),
	(1087, '3', 'distance_edit', 0, '2013-12-27 00:00:00', ''),
	(1088, '3', 'distance_del', 0, '2013-12-27 00:00:00', '');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;


# Dumping structure for table jysecurity.sys_user
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.sys_user: ~3 rows (approximately)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `user_id`, `password`, `name`, `create_datetime`, `modifi_datetime`, `deleted`) VALUES
	(1, 'admin', 'admin', '徐涛', '2013-10-26 14:20:59', '2013-12-23 22:32:37', 0),
	(2, 'xutao', 'xutao', '徐涛', '2013-12-23 22:33:59', '2013-12-23 22:33:59', 0),
	(3, 'ztj', 'ztj', '赵廷建', '2013-12-23 22:34:54', '2013-12-23 22:34:54', 0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;


# Dumping structure for table jysecurity.traffic_accident
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

# Dumping data for table jysecurity.traffic_accident: ~8 rows (approximately)
DELETE FROM `traffic_accident`;
/*!40000 ALTER TABLE `traffic_accident` DISABLE KEYS */;
INSERT INTO `traffic_accident` (`id`, `idcard`, `company`, `line_number`, `bus_number`, `name`, `accident_date`, `accident_location`, `accident_summary`, `accident_liability`, `result`, `reporter`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '1', '1', '1', '1', '1', '2013-10-28', '1', '1', '11', '1', '1', '2013-10-28 11:26:47', '2013-10-28 11:26:49', '1', '1', 0),
	(2, '2', '2', '2', '2', '2', '2013-10-28', '2', '2', '2', '2', '3', '2013-10-28 11:28:19', '2013-10-28 11:28:20', '1', '1', 0),
	(3, '3', '1', '1', '2', NULL, '2010-10-12', '123', '', '123', '123', '123', '2013-10-28 14:20:24', '2013-10-28 14:36:57', '1', '1', 0),
	(4, '3', NULL, '1', '1', NULL, '2013-10-09', '1', '1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq', '1', '1', '1', '2013-10-28 14:22:55', '2013-12-21 14:16:01', '1', '1', 0),
	(5, '3', '2', '1', '1', NULL, '2013-10-10', '3', '3', '3', '3', '3', '2013-10-28 14:46:07', '2013-10-28 14:46:07', '1', '1', 1),
	(6, '3', '3', '3', '3', NULL, '2013-10-10', '3', '3', '3', '3', '3', '2013-10-28 14:55:00', '2013-10-28 14:55:00', '1', '1', 0),
	(7, '1', '21', '21', '21', NULL, '2013-12-13', '21', '21', '21', '21', '21', '2013-12-14 21:43:30', '2013-12-14 21:43:30', '1', '1', 0),
	(8, '1', '21', '1', '111', NULL, '2013-12-05', '2121', '2121', '2121', '2121', '2121', '2013-12-14 21:43:44', '2013-12-14 21:43:44', '1', '1', 0);
/*!40000 ALTER TABLE `traffic_accident` ENABLE KEYS */;


# Dumping structure for table jysecurity.traffic_violation
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

# Dumping data for table jysecurity.traffic_violation: ~4 rows (approximately)
DELETE FROM `traffic_violation`;
/*!40000 ALTER TABLE `traffic_violation` DISABLE KEYS */;
INSERT INTO `traffic_violation` (`id`, `idcard`, `bus_number`, `name`, `company`, `violation_date`, `violation_location`, `violation_reason`, `points`, `fine`, `assessment_date`, `create_datetime`, `modifi_datetime`, `create_user_id`, `modifi_user_id`, `deleted`) VALUES
	(1, '3', '1', NULL, '1', '2013-10-10', '1', '1', 1, 1.00, '2013-10-17', '2013-10-28 16:16:44', '2013-10-28 16:16:44', '1', '1', 0),
	(2, '3', '2', NULL, '2', '2013-10-17', '2', '2', 2, 2.00, '2013-10-16', '2013-10-28 16:16:58', '2013-10-28 16:28:40', '1', '1', 0),
	(3, '3', '21', NULL, '2', '2013-10-16', '12', '21', 21, 21.00, '2013-10-19', '2013-10-28 16:29:18', '2013-10-28 16:29:43', '1', '1', 1),
	(4, '2', '1', NULL, '1', '2013-10-09', '21', '21', 12, 12.00, '2013-10-16', '2013-10-28 16:45:44', '2013-10-28 16:45:44', '1', '1', 0);
/*!40000 ALTER TABLE `traffic_violation` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
