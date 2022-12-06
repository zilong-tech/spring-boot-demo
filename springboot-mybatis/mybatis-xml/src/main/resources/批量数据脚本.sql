CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                         `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
                         `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
                         `user_sex` varchar(32) DEFAULT NULL,
                         `nick_name` varchar(32) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69699 DEFAULT CHARSET=utf8;



delimiter //
DROP PROCEDURE
    IF
    EXISTS proc_batch_insert;
CREATE PROCEDURE proc_batch_insert ()
BEGIN
	DECLARE
pre_name BIGINT;
	DECLARE
ageVal INT;
	DECLARE
i INT;

	SET pre_name = 187635267;

	SET ageVal = 100;

	SET i = 1;
	WHILE
i <= 1000000 DO
			INSERT INTO users ( `userName`, `passWord`)
		VALUES
			(
				CONCAT( pre_name, '@qq.com' ),(
					ageVal + 1
				)% 30
			);

		SET pre_name = pre_name + 100;

		SET i = i + 1;

END WHILE;

END //
delimiter;

CALL proc_batch_insert ();