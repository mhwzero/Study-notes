-- 创建学生表
CREATE TABLE student(
	number VARCHAR(10) UNIQUE,   -- 学号
	NAME VARCHAR(10),            -- 姓名
	birthday DATE,               -- 生日
	address VARCHAR(200)         -- 地址
);
INSERT INTO student VALUES ('hm001','张三','1995-05-05','北京市昌平区');
INSERT INTO student VALUES ('hm002','李四','1996-06-06','北京市海淀区');
INSERT INTO student VALUES ('hm003','王五','1997-07-07','北京市朝阳区');
INSERT INTO student VALUES ('hm004','赵六','1998-08-08','北京市丰台区');
INSERT INTO student VALUES ('hm005','周七','1999-09-09','北京市顺义区');
INSERT INTO student VALUES ('hm006','孙悟空','2000-01-01','花果山水帘洞');
INSERT INTO student VALUES ('hm007','猪八戒','2001-02-02','高老庄翠兰家');
INSERT INTO student VALUES ('hm008','沙和尚','2002-03-03','流沙河河底');
INSERT INTO student VALUES ('hm009','唐玄奘','2003-04-04','东土大唐');