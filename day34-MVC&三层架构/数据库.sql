create schema user_manage;
use user_manage;

create table user(
    id int primary key auto_increment,
    name varchar(50) unique, -- 唯一
    sex char(2),
    age int,
    address varchar(200),
    qq varchar(200),
    email varchar(30)
);

insert into user values(null,'张三','男',18,'北京顺义','1234567893','zhangsan@163.com');
insert into user values(null,'李四','男',18,'北京顺义','1234567894','lisi@163.com');
insert into user values(null,'王五','女',18,'北京昌平','1234567895','wangwu@163.com');
insert into user values(null,'赵六','男',19,'北京昌平','1234567896','zhaoliu@163.com');
insert into user values(null,'周七','女',18,'北京顺义','1234567897','zhouqi@163.com');
insert into user values(null,'吴八','男',19,'北京顺义','1234567898','wuba@163.com');
insert into user values(null,'郑九','女',18,'北京昌平','1234567899','zhengjiu@163.com');
insert into user values(null,'王十','男',20,'北京顺义','1234567890','wangshi@163.com');