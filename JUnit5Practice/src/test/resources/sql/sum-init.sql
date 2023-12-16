CREATE DATABASE IF NOT EXISTS `junit5_data` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `junit5_data`;
--
-- 表 add_numbers 的表结构
--
DROP TABLE IF EXISTS `add_numbers`;
SET @saved_cs_client = @@character_set_client ;
SET character_set_client = utf8mb4 ;
CREATE TABLE `add_numbers` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `numbers`varchar(50) NOT NULL COMMENT '加数',
    `expect` varchar(50) NOT NULL COMMENT '期望值',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
SET character_set_client = @saved_cs_client ;

LOCK TABLES `add_numbers` WRITE;
ALTER TABLE `add_numbers` DISABLE KEYS;
INSERT INTO `add_numbers` (`numbers`, `expect`) VALUES
    ('[-99,0,99]',0),
    ('[-99,66,99]',66),
    ('[-100,0,99]','请输入范围内的整数！'),
    ('[-100,0,99]','请输入范围内的整数！'),
    ('[99,20,-100]','请输入范围内的整数！'),
    ('[99,-20,-100]','请输入范围内的整数！');
ALTER TABLE `add_numbers` ENABLE KEYS;
UNLOCK TABLES;
