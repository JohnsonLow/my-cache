
CREATE TABLE `sys_config` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `key` varchar(50) DEFAULT NULL COMMENT 'key',
                            `value` varchar(2000) DEFAULT NULL COMMENT 'value',
                            `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
                            `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';


insert INTO sys_config (`key`, `value`, `status`, remark) VALUES('key_a', 'value_a', 0, 'this is a test a'),
                                                                ('key_b', 'value_b', 0, 'this is a test b'),
                                                                ('key_c', 'value_c', 0, 'this is a test c');