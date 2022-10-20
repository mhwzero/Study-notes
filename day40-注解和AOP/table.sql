create table account(
	aid int primary key auto_increment,
	name varchar(100) not null unique,
	balance float(10,2)
)