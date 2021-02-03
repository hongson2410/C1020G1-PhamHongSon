drop database if exists furama2;

create database furama2;

use furama2;

create table position (
	position_id int primary key,
    position_name varchar(50)
);

insert into position values (1,"Lễ tân");
insert into position values (2,"Phục vụ");
insert into position values (3,"Chuyên viên");
insert into position values (4,"Giám sát");
insert into position values (5,"Quản lý");
insert into position values (6,"Giám đốc");

create table customer_type(
	customer_type_id int primary key,
    customer_type_name varchar(45)
);



insert into customer_type values (1,"Diamond");
insert into customer_type values (2,"Platinum");
insert into customer_type values (3,"Gold");
insert into customer_type values (4,"Silver");
insert into customer_type values (5,"Member");

create table service_type (
	service_type_id int primary key,
    service_type_name varchar(45) not null
);

insert into service_type values(1,"Villa");
insert into service_type values(2,"House");
insert into service_type values(3,"Room");


create table employee (
	employee_id int primary key,
    employee_name varchar(45) not null,
    employee_birthday varchar(45) not null,
    employee_gender varchar(30) not null,
    employee_id_card varchar(45) unique not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int,
    foreign key (position_id) references position (position_id)
    ON DELETE CASCADE
);

create table customer (
	customer_id varchar(30) primary key,
    customer_type int,
    customer_name varchar(45) not null,
    customer_birthday date,
    customer_gender int(1),
    customer_id_card varchar(45) not null unique,
    customer_phone varchar(45) not null,
    customer_email varchar(45),
    customer_address varchar(45),
    foreign key (customer_type) references customer_type(customer_type_id)
    ON DELETE CASCADE
);

create table service (
	service_id varchar(20) primary key,
    service_name varchar(45) not null,
    service_area double not null,
    service_cost double not null,
    service_max_people int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    service_type_id int,
    foreign key (service_type_id) references service_type(service_type_id)
    ON DELETE CASCADE
);

create table contract (
	contract_id int primary key auto_increment,
    contract_start_date date,
    contract_end_date date,
    contract_deposit double,
    contract_total_money double,
    employee_id int,
    customer_id varchar(20),
    service_id varchar(20),
    foreign key (employee_id) references employee(employee_id)
    ON DELETE CASCADE,
    foreign key (customer_id) references customer(customer_id)
    ON DELETE CASCADE,
    foreign key (service_id) references service(service_id)
    ON DELETE CASCADE
);

create table attach_service (
	attach_service_id int primary key,
    attach_service_name varchar(50) not null,
    attach_service_cost double,
    attach_service_unit int
);

create table contract_detail (
	contract_detail_id int primary key,
    contract_id int,
    attach_service_id int,
    foreign key (contract_id) references contract(contract_id)
    ON DELETE CASCADE,
    foreign key (attach_service_id) references attach_service(attach_service_id)
    ON DELETE CASCADE
);