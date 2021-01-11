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
	id int primary key,
    `name` varchar(50),
    date_of_birth date,
    account_james_account varchar(50),
    class_id int,
    
    foreign key (account_james_account) references account_james (`account`),
    foreign key (class_id) references class(id)
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

