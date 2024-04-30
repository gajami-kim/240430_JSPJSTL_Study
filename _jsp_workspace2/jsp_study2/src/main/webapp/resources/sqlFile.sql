create table comment(
cno int auto_increment,
bno int not null,
writer varchar(100) default “unknown”,
content varchar(100) not null,
regdate datetime default now(),
primary key(cno));