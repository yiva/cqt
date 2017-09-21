/*
SQLyog Ultimate v8.32 
MySQL - 5.6.9-rc : Database - db_cqt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_cqt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_cqt`;

/*Table structure for table `t_account_detail` */

DROP TABLE IF EXISTS `t_account_detail`;

CREATE TABLE `t_account_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ac_title` varchar(100) DEFAULT NULL COMMENT '主题',
  `ac_date` date DEFAULT NULL COMMENT '日期',
  `ac_type` int(1) DEFAULT NULL COMMENT '收支类别(1:转入，2：转出，3：收入，4：开支，6：转出)',
  `ac_content` varchar(255) DEFAULT NULL COMMENT '摘要',
  `ac_cost` float DEFAULT NULL COMMENT '收支金额',
  `ac_handler` varchar(255) DEFAULT NULL COMMENT '经手人',
  `ac_comment` varchar(255) DEFAULT NULL COMMENT '备注',
  `ac_category` int(2) DEFAULT NULL COMMENT '台账类型(0：一对一，1:公益金，2：赞赏款，3：奖学金，4：滞留助学金收支，5：其他，6：独立流水，7：微信提现流水，8：微信公众号入账，9：余额宝收益,10:待助)',
  `ac_num` int(7) DEFAULT NULL COMMENT '学生编号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=335 DEFAULT CHARSET=utf8 COMMENT='收支台账';

/*Table structure for table `t_account_student_year` */

DROP TABLE IF EXISTS `t_account_student_year`;

CREATE TABLE `t_account_student_year` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `stu_num` varchar(20) DEFAULT NULL COMMENT '爱心编号',
  `stu_name` varchar(255) DEFAULT NULL COMMENT '受助学生姓名',
  `year` date DEFAULT NULL COMMENT '年份',
  `income` float DEFAULT NULL COMMENT '转入',
  `expense` float DEFAULT NULL COMMENT '转出',
  `surplus` float DEFAULT NULL COMMENT '结余',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `FK_t_asy_num` (`stu_num`),
  CONSTRAINT `FK_t_asy_num` FOREIGN KEY (`stu_num`) REFERENCES `t_student` (`stu_num`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生收支明细账';

/*Table structure for table `t_articles` */

DROP TABLE IF EXISTS `t_articles`;

CREATE TABLE `t_articles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '序号',
  `art_num` int(7) DEFAULT NULL COMMENT '编号',
  `art_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `art_loc` varchar(50) DEFAULT NULL COMMENT '资助地',
  `art_reward` varchar(50) DEFAULT NULL COMMENT '资助人',
  `art_school` varchar(50) DEFAULT NULL COMMENT '就读学校',
  `art_grade` varchar(50) DEFAULT NULL COMMENT '年级',
  `art_mode` varchar(50) DEFAULT NULL COMMENT '采购环节',
  `art_price` float DEFAULT NULL COMMENT '采购单价',
  `art_trans` varchar(50) DEFAULT NULL COMMENT '转运环节',
  `art_trans_cost` float DEFAULT NULL COMMENT '转运费用',
  `art_sender` varchar(50) DEFAULT NULL COMMENT '学习用品转发人',
  `art_time` date DEFAULT NULL COMMENT '转发时间',
  `art_remit_time` date DEFAULT NULL COMMENT '采购款划拨时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学习用品转发情况汇总表';

/*Table structure for table `t_member` */

DROP TABLE IF EXISTS `t_member`;

CREATE TABLE `t_member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `m_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `m_duty` varchar(50) DEFAULT NULL COMMENT '角色',
  `m_dept` varchar(50) DEFAULT NULL COMMENT '所在单位',
  `m_tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `m_qq` varchar(50) DEFAULT NULL COMMENT 'qq',
  `m_wx` varchar(50) DEFAULT NULL COMMENT '微信',
  `m_mail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='团队成员信息';

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `stu_num` varchar(20) NOT NULL COMMENT '爱心编号',
  `stu_name` varchar(50) DEFAULT NULL COMMENT '受助学生姓名',
  `reward_loc` varchar(255) DEFAULT NULL COMMENT '资助地',
  `rewarder` varchar(255) DEFAULT NULL COMMENT '资助人',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `degree` varchar(255) DEFAULT NULL COMMENT '就读阶段',
  `school` varchar(255) DEFAULT NULL COMMENT '就读学校',
  `grade` varchar(255) DEFAULT NULL COMMENT '就读年级',
  `referrer` varchar(50) DEFAULT NULL COMMENT '推荐（把关）老师',
  `follower` varchar(50) DEFAULT NULL COMMENT '成长“跟踪”老师',
  `manager` varchar(50) DEFAULT NULL COMMENT '助学金管理老师',
  `comments` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `stu_num` (`stu_num`)
) ENGINE=InnoDB AUTO_INCREMENT=736 DEFAULT CHARSET=utf8 COMMENT='学生信息';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
