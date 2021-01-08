create database student_management;

use student_management;

create table student (
	id int,
    name varchar(50),
    date_of_birth date
);

insert into student
values
(1, 'Nguyen Van A', '2021-01-08'),
(2, 'Nguyen Van B', '2021-01-07');

insert into student (id, name)
values
(3, 'Nguyen Van C');


-- Mot so cau lenh them ve DDL

alter table student
add email varchar(5);

drop table student;

drop database student_management;
-- Mot so cau lenh them ve DML

select *
from student;

delete from student 
where id = 1;

update student
set name = 'Nguyen Van C'
where id = 2;