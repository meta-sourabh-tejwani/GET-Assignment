use storefront;

show tables;


insert into shopper(user_name)
values ('sourabh'),
('mohit'),('avi');


insert into shopper(user_name)
values ('rahul'),
('monu'),
('ramesh'),
('ravi'),
('yatish'),
('mehul'),
('bob'),
('alice'),
('methew'),
('rajesh'),
('ayush'),
('aman');


select * from shopper;

alter table orders add address_id int;

alter table orders add Foreign Key (address_id) REFERENCES address(address_id) ;

insert into address(area,city,state,country,shopper_id)values('16a','udaipur','rajasthan','india',1);

insert into orders (order_date,order_total,order_status,address_id)values('2021-01-23',400,'shipped',1);
select * from orders;

insert into orderdetails(product_id,order_id,quantity,total)values(1,2,2,400);


insert into address(area,city,state,country,shopper_id)values('16a','jaipur','rajasthan','india',2);

insert into address(area,city,state,country,shopper_id)values('16a hiran magri','bhilwara','rajasthan','india',3);

insert into address(area,city,state,country,shopper_id)values('1ch13','ahemdabad','gujarat','india',4);

insert into address(area,city,state,country,shopper_id)values('1ch 18 sec11','hyderabad','hyderabad','india',5);

insert into address(area,city,state,country,shopper_id)values('sec6','udaipur','rajasthan','india',6);

insert into address(area,city,state,country,shopper_id)values('SEc26','delhi','delhi','india',7);

insert into address(area,city,state,country,shopper_id)values('20a','bombay','bombay','india',8);

insert into address(area,city,state,country,shopper_id)values('16a pratap nagar','jaipur','rajasthan','india',9);

insert into address(area,city,state,country,shopper_id)values('55A','rajsamand','rajasthan','india',10);

insert into address(area,city,state,country,shopper_id)values('18a','ajmer','rajasthan','india',11);

insert into address(area,city,state,country,shopper_id)values('16A housing board colony','udaipur','rajasthan','india',12);

insert into address(area,city,state,country,shopper_id)values('20 C','surat','gujarat','india',13);

insert into address(area,city,state,country,shopper_id)values('16a sindhi colony','ghandidham','gujarat','india',14);

insert into address(area,city,state,country,shopper_id)values('hiran magri','udaipur','rajasthan','india',15);


select * from address;


select * from orders;

select * from products;
insert into orders (order_date,order_total,order_status,address_id)values('2021-02-21',1000,'canceled',2);

insert into orderdetails(product_id,order_id,quantity,total)values(20,5,1,1000),(8,5,1,400),(7,5,1,100);




insert into orders (order_date,order_total,order_status,address_id)values('2020-12-12',1500,'complete',3);

insert into orderdetails(product_id,order_id,quantity,total)values(10,4,1,700),(11,4,1,300);



insert into orders (order_date,order_total,order_status,address_id)values('2020-03-18',1400,'shipped',4);

insert into orderdetails(product_id,order_id,quantity,total)values(21,6,1,14000);



insert into orders (order_date,order_total,order_status,address_id)values('2021-02-18',60000,'shipped',5);

insert into orderdetails(product_id,order_id,quantity,total)values(23,7,1,60000);



insert into orders (order_date,order_total,order_status,address_id)values('2021-01-15',70000,'complete',6);

insert into orderdetails(product_id,order_id,quantity,total)values(24,8,1,70000);


insert into orders (order_date,order_total,order_status,address_id)values('2018-03-21',1200,'canceled',7);

insert into orderdetails(product_id,order_id,quantity,total)values(25,9,1,1200);


insert into orders (order_date,order_total,order_status,address_id)values('2020-09-09',550,'shipped',8);

insert into orderdetails(product_id,order_id,quantity,total)values(4,10,1,550);


insert into orders (order_date,order_total,order_status,address_id)values('2021-02-03',1100,'complete',9);
insert into orderdetails(product_id,order_id,quantity,total)values(9,11,1,400),(10,11,1,700);


insert into orders (order_date,order_total,order_status,address_id)values('2020-05-01',1400,'complete',10);

insert into orderdetails(product_id,order_id,quantity,total)values(13,12,2,1400);


insert into orders (order_date,order_total,order_status,address_id)values('2021-02-07',25000,'shipped',11);

insert into orderdetails(product_id,order_id,quantity,total)values(22,13,1,25000);



insert into orders (order_date,order_total,order_status,address_id)values('2021-02-07',25000,'confimed',11);

insert into orderdetails(product_id,order_id,quantity,total)values(22,13,1,25000);



insert into orders (order_date,order_total,order_status,address_id)values('2021-01-11',500,'canceled',12);

insert into orderdetails(product_id,order_id,quantity,total)values(3,14,1,100),(8,14,1,400);


insert into orders (order_date,order_total,order_status,address_id)values('2020-11-09',20000,'complete',13);

insert into orderdetails(product_id,order_id,quantity,total)values(27,15,1,20000);


insert into orders (order_date,order_total,order_status,address_id)values('2020-10-10',1000,'shipped',14);

insert into orderdetails(product_id,order_id,quantity,total)values(10,10,1,700),(11,10,1,300);


insert into orders (order_date,order_total,order_status,address_id)values('2021-01-16',1300,'complete',15);

insert into orderdetails(product_id,order_id,quantity,total)values(15,17,1,600),(19,17,1,700);


insert into orders (order_date,order_total,order_status,address_id)values('2021-03-12',1300,'confirmed',15);

insert into orderdetails(product_id,order_id,quantity,total)values(15,17,1,600),(19,17,1,700);

select * from orders;
select * from orderdetails;

alter table orderdetails add product_status varchar(30) not null;


update orderdetails set product_status='shipped' where id=4;
update orderdetails set product_status='canceled' where id=7;
update orderdetails set product_status='canceled' where id=8;
update orderdetails set product_status='complete' where id=9;
update orderdetails set product_status='complete' where id=10;
update orderdetails set product_status='complete' where id=11;
update orderdetails set product_status='not shipped' where id=12;
update orderdetails set product_status='shipped' where id=13;
update orderdetails set product_status='complete' where id=14;
update orderdetails set product_status='canceled' where id=15;
update orderdetails set product_status='not shipped' where id=17;
update orderdetails set product_status='complete' where id=20;
update orderdetails set product_status='complete' where id=21;
update orderdetails set product_status='complete' where id=22;
update orderdetails set product_status='not shipped' where id=23;
update orderdetails set product_status='canceled' where id=24;
update orderdetails set product_status='canceled' where id=25;
update orderdetails set product_status='complete' where id=27;
update orderdetails set product_status='shipped' where id=28;
update orderdetails set product_status='not shipped' where id=29;
update orderdetails set product_status='complete' where id=30;
update orderdetails set product_status='complete' where id=31;
update orderdetails set product_status='not shipped' where id=32;
update orderdetails set product_status='complete' where id=33;

select * from orders;
insert into orders (order_date,order_total,order_status,address_id)values('2021-03-07',45,'shipped',11);

insert into orderdetails(product_id,order_id,quantity,total,product_status)values(76,20,9,45,'shipped');

insert into orders (order_date,order_total,order_status,address_id)values('2021-03-17',45,'shipped',11);

insert into orderdetails(product_id,order_id,quantity,total,product_status)values(76,20,9,45,'shipped');

/*Display Recent 50 orders placed (id,order date,order total)*/
select order_id,order_date,order_total from orders order by order_date DESC limit 50;



/*Display 10 most expensive orders*/
select * from orders order by order_total DESC limit 10;



/*display all order which are placed more than 10 days old and one or more items from those order are still not placed*/
select * from orderdetails where order_id IN
(select order_id from orders where order_date <=DATE(CURDATE()-interval 10 day)
and order_status like 'shipped') and product_status like 'not shipped';


/*display list of shopper which have not ordered anything since last month*/
select * from shopper where shopper_id IN(
select u.shopper_id from address u where u.address_id IN (
select o.address_id from orders o where order_date<=DATE(CURDATE()-interval 1 month)));

/*display list of shopper along with order placed by them in last 15 days*/
select shopper.user_name, orders.order_id from orders Inner join address Inner join shopper 
where orders.address_id=address.address_id and 
address.shopper_id=shopper.shopper_id and 
orders.order_date >=DATE(CURDATE()-interval 15 day);

/*display list of order item which are in "shipped" state for particular order id 2*/
select * from orderdetails where product_status like 'shipped' and order_id=2;

/*display list of order item along with order placed date which fall between rs 20 to rs 50*/
select orderdetails.product_id,order_date from orders Inner Join orderdetails where 
orderdetails.order_id=orders.order_id and orders.order_total>=20 and orders.order_total<=50;
