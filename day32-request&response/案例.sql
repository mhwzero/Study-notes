-- 创建用户表
CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主键
	username VARCHAR(50), -- 用户名
	password VARCHAR(50), -- 密码
	balance FLOAT  -- 余额
);
-- 添加数据
INSERT INTO user (username, password, balance) VALUES ('柯南', 'admin', 100), ('平次', 'admin', 100);


