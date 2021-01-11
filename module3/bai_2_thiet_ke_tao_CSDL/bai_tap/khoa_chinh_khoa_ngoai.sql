create database account_customers;

use account_customers;

create table customers (
customer_number int,
fullname varchar(30),
address varchar(50),
email varchar(30),
phone varchar(12),
primary key (customer_number)
);

create table accounts (
account_number varchar(12),
account_type varchar(20),
`date` date,
balance decimal(12,3),
customer_number int unique,
primary key (account_number),
foreign key (customer_number) references customers(customer_number)
);

create table transactions (
tran_number varchar(10),
account_number varchar(12),
`date` date,
amounts decimal(12,3),
descriptions varchar(12),
primary key (tran_number),
foreign key (account_number) references accounts(account_number)
);

