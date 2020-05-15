create database products;
use products;
#drop database products;

SET GLOBAL time_zone = '+3:00';

create table products(
	id_product int auto_increment,
    name_product varchar(40),
    price double,
    brand varchar(40),
    unit int,
    quantity int,
    discount double,
    constraint pk_id_product primary key (id_product)
);
#drop table products;

select * from products;