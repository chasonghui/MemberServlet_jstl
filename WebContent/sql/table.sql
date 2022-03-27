drop database crudprac2;
create database curdprac;

use curdprac;


create table members(
id varchar(16) primary key not null,
pass varchar(40),
name varchar(10),
phone varchar(100)
);

select * from members;
