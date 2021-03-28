create database Storefront;

show databases;

use storefront;

show tables;

create table Categories(category_id int NOT NULL Auto_increment,
                          category_title varchar(50) not null,
                            parent_id int,
                            primary key(category_id),
                            FOREIGN KEY (parent_id) REFERENCES Categories(category_id));
                            
                            
create table products(product_id int not null Auto_increment,
			product_title varchar(50) not null,
			category_id int not null,
			product_price int not null,
			product_quantity int not null,
			primary key(product_id));


create table images(image_id int not null auto_increment,
			image longblob,
			product_id int not null,
			primary key(image_id),
			foreign key (product_id) REFERENCES products (product_id));
            

create table shopper(shopper_id int not null auto_increment,
			user_name varchar(50) not null,
			primary key(shopper_id));
            

create table address(address_id int not null auto_increment,
			area varchar(50) not null,
			city varchar(50) not null,
			state varchar(50) not null,
			country varchar(50) not null,
			shopper_id int not null,
			primary key(address_id),
			foreign key (shopper_id) References shopper(shopper_id));


create table orders(order_id int not null auto_increment,
			order_date date not null,
			order_total int not null,
			order_status varchar(30) not null,
			primary key(order_id));
            

create table orderdetails(id int not null auto_increment,
			product_id int not null,
			order_id int not null,
			quantity int not null,
			total int not null,
			primary key(id),
			foreign key(product_id) References products(product_id),
			foreign key(order_id) References orders(order_id));
            

 desc products;
 
drop table products;


create table products(product_id int not null Auto_increment,
			product_title varchar(50) not null,
			category_id int not null,
			product_price int not null,
			product_quantity int not null,
			primary key(product_id),
			FOREIGN KEY (category_id) REFERENCES Categories (category_id));