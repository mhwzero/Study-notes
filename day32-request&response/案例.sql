-- �����û���
CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT, -- ����
	username VARCHAR(50), -- �û���
	password VARCHAR(50), -- ����
	balance FLOAT  -- ���
);
-- �������
INSERT INTO user (username, password, balance) VALUES ('����', 'admin', 100), ('ƽ��', 'admin', 100);


