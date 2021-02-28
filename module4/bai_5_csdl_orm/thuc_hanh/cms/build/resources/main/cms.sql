drop database if exists cms;
create database cms;
use cms;

create table customer (
id int primary key auto_increment,
`name` varchar(45) not null,
email varchar(45) not null,
address varchar(45) not null
);

insert into customer ( `name`, email, address)
value 
('t','t@codegym.vn','Da Nang'),
('Nhat','nhat@codegym.vn','Quang Tri'),
('Trang','trang@codegym.vn','Ha Noi'),
('Nguyen Bình Sơn','son@codegym.vn','Sai Gon'),
('Dang Xuan Hoa','hoa@codegym.vn','Da Nang');