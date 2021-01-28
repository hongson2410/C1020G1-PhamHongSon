drop database if exists `demo`;

CREATE DATABASE `demo`;
USE demo;

create table user (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into user(`name`, email, country) values 
('Minh','minh@codegym.vn','Viet Nam'),
('Son','son@son.son','Tay Ninh'),
('Tuan','tuan@tuan.tuan','Da Nang'),
('Cao','cao@cao.cao','Hue'),
('Thanh','thanh@thanh.thanh','Quang Nam');