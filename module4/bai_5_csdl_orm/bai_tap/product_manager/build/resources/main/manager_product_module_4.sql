drop database if exists manager_product_module_4;
create database manager_product_module_4;
use manager_product_module_4;

create table product (
	id int primary key auto_increment,
    `name` varchar(45),
    manufacturer varchar(45),
	productType varchar(45),
    price int
    );
   
insert into product (`name`, manufacturer,productType,price)
value 
('Iphone-6','Apple','Smart-Phone',200),
('Galaxy-note-7','Samsung','Smart-Phone',300),
('Sony Smart TV KDL-40W650D','Sony','Tivi',700),
('LG Smart TV 43UN7290PTF','LG','Tivi',800),
('Iphone-X','Apple','Smart-Phone',500),
('Oppo A15s','Oppo','Smart-Phone',150);