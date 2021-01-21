drop database if exists student_management;

create database student_management;

use student_management;

create table account_james (
	`account` varchar(50) primary key,
    `password` varchar(50)
);

create table type_of_class (
	id int primary key,
    `name` varchar(20)
);

create table class (
	id int auto_increment,
    `name` varchar(7),
    type_of_class_id int,
    
    primary key (id),
    foreign key (type_of_class_id) references type_of_class (id)
);

create table student (
	id int primary key auto_increment,
    `name` varchar(50),
    date_of_birth date,
    account_james_account varchar(50),
    email varchar(100),
    class_id int,
    
    constraint fk_student_to_account_james foreign key (account_james_account) references account_james (`account`),
    foreign key (class_id) references class(id),
    unique (email)
);

create table instructor (
	id int primary key,
    `name` varchar(50),
    date_of_birth date
);

create table instructor_teach_class (
	instructor_id int,
    class_id int,
    
    primary key (instructor_id, class_id),
    foreign key (instructor_id) references instructor (id),
    foreign key (class_id) references class (id)
);

insert into type_of_class
values
(1, 'Full time'),
(2, 'Half time');

insert into class (`name`, type_of_class_id)
values
('C1020G1', 1),
('C0520G1', 1),
('A0720I1', 2);

insert into account_james
values
('tien.nguyen', '12345678'),
('toan.le', '12345678'),
('chuong.kim', '12345678'),
('long.duong', '12345678');

insert into student (name, date_of_birth, account_james_account, email, class_id)
values
('Tien', '2000-07-14', 'tien.nguyen', 'a', 1),
('Toan', '2002-05-03', 'toan.le', 'b',  2),
('Chuong', '2001-04-03', 'chuong.kim', 'c', 2),
('Long', '2002-01-25', 'long.duong', 'd', null);

insert into instructor
values
(1, 'Tien', '2000-07-14'),
(2, 'Trung', '2002-05-03'),
(3, 'Hai', '2003-11-03'),
(4, 'Chanh', '1998-07-09');

insert into instructor_teach_class
values
(1, 1),
(1, 2),
(2, 1);