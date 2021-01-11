drop database if exists product_manager;

create database product_manager;

use product_manager;

CREATE TABLE offices (
   office_code VARCHAR(10) PRIMARY KEY not null,
   city VARCHAR(50) not null,
   phone VARCHAR(50) not null,
   address_line_1 VARCHAR(50) not null,
   address_line_2 varchar(50) not null,
   state varchar(50) not null,
   country varchar(50) not null,
   postal_code varchar(15) not null
);

CREATE TABLE employees (
   employee_number int PRIMARY KEY not null,
   last_name VARCHAR(50) not null,
   first_name VARCHAR(50) not null,
   email VARCHAR(100) not null,
   job_title VARCHAR(50) not null,
   office_code VARCHAR(10) not null unique,
   foreign key (office_code) references offices(office_code)
);

CREATE TABLE customers (
   customer_number INT PRIMARY KEY not null,
   customer_name VARCHAR(50) not null,
   contact_last_name VARCHAR(50) not null,
   contact_first_name VARCHAR(50) not null,
   phone VARCHAR(50) not null,
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

CREATE TABLE productlines (
   product_line VARCHAR(50) PRIMARY KEY not null,
   text_description text not null,
   image text not null
);

CREATE TABLE products (
   product_code VARCHAR(15) PRIMARY KEY not null,
   product_name VARCHAR(70) not null,
   product_scale VARCHAR(10) not null,
   product_vendor VARCHAR(50) not null,
   product_description text not null,
   quantity_in_stock int not null,
   buy_price double not null,
   msrp double not null,
   product_line VARCHAR(50) not null unique,
   foreign key (product_line) references productlines(product_line)
);

CREATE TABLE orders (
   order_number INT PRIMARY KEY not null,
   order_date date not null,
   required_date date not null,
   shipped_date date,
   `status` VARCHAR(15) not null,
   comments text,
   quantity_ordered int not null,
   price_each double not null,
   customer_number INT not null unique,
   foreign key (customer_number) references customers(customer_number),
   product_code VARCHAR(15) not null unique,
   foreign key (product_code) references products(product_code)
);

CREATE TABLE payments (
   check_number VARCHAR(50) not null,
   payment_date date not null,
   amount double not null,
   customer_number INT not null unique,
   foreign key (customer_number) references customers(customer_number)
);

CREATE TABLE order_details (
order_number INT,
product_code VARCHAR(15),
PRIMARY KEY (order_number,product_code),
FOREIGN KEY (order_number) REFERENCES orders(order_number),
FOREIGN KEY (product_code) REFERENCES products(product_code)
);
