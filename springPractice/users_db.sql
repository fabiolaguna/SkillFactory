create database users_db;
use users_db;
#drop database users_db;

create table users(
	id_user int auto_increment,
    name varchar(40),
    last_name varchar(40),
    dni varchar(8) unique,
    age int,
    country_code varchar(10),
    constraint pk_id_user primary key (id_user)
);

show tables;
select * from users;