drop database if exists product_manager;

create database product_manager;

use product_manager;

create table offices (
   office_code varchar(10) primary key not null,
   city varchar(50) not null,
   phone varchar(50) not null,
   address_line_1 varchar(50) not null,
   address_line_2 varchar(50) not null,
   state varchar(50) not null,
   country varchar(50) not null,
   postal_code varchar(15) not null
);

create table employees (
   employee_number int primary key not null,
   last_name varchar(50) not null,
   first_name varchar(50) not null,
   email varchar(100) not null,
   job_title varchar(50) not null,
   office_code varchar(10) not null unique,
   report_to int not null,
   foreign key (office_code) references offices(office_code),
   foreign key (report_to) references employees(employee_number)
);

create table customers (
   customer_number int primary key not null,
   customer_name varchar(50) not null,
   contact_last_name varchar(50) not null,
   contact_first_name varchar(50) not null,
   phone varchar(50) not null,
   address_line_1 varchar(50) not null,
   address_line_2 varchar(50) not null,
   city varchar(50) not null,
   state varchar(50) not null,
   postal_code varchar(15) not null,
   country varchar(50) not null,
   credit_limit double,
   employee_number int not null unique,
   foreign key (employee_number) references employees(employee_number)
);

create table productlines (
   product_line varchar(50) primary key not null,
   text_description text not null,
   image text not null
);

create table products (
   product_code varchar(15) primary key not null,
   product_name varchar(70) not null,
   product_scale varchar(10) not null,
   product_vendor varchar(50) not null,
   product_description text not null,
   quantity_in_stock int not null,
   buy_price double not null,
   msrp double not null,
   product_line varchar(50) not null unique,
   foreign key (product_line) references productlines(product_line)
);

create table orders (
   order_number int primary key not null,
   order_date date not null,
   required_date date not null,
   shipped_date date,
   `status` varchar(15) not null,
   comments text,
   quantity_ordered int not null,
   price_each double not null,
   customer_number int not null unique,
   foreign key (customer_number) references customers(customer_number),
   product_code varchar(15) not null unique,
   foreign key (product_code) references products(product_code)
);

create table payments (
   check_number varchar(50) not null,
   payment_date date not null,
   amount double not null,
   customer_number int not null unique,
   foreign key (customer_number) references customers(customer_number)
);

create table order_details (
    order_number int,
    product_code varchar(15),
    primary key (order_number , product_code),
    foreign key (order_number)
        references orders (order_number),
    foreign key (product_code)
        references products (product_code)
);
