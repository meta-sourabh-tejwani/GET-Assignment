select * from shopper;
select * from orders;
select * from address;
select * from orderdetails;
select * from categories;
select * from products;

alter table products add status varchar(30);

update products set status='active';

/*Display Shopper’s information along with number of orders he/she placed during last 30 days.*/
select u.shopper_id, u.user_name,count(o.order_id) from shopper u inner join address a inner join orders o
where o.address_id=a.address_id and 
u.shopper_id=a.shopper_id and 
o.order_date>=(CURDATE()-interval 30 day)
group by o.address_id;

/*Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/
select u.shopper_id, u.user_name,o.order_total from shopper u inner join address a inner join orders o
where o.address_id=a.address_id and 
u.shopper_id=a.shopper_id and 
o.order_date>=(CURDATE()-interval 30 day)
group by o.address_id order by o.order_total DESC limit 10;

/*Display top 20 Products which are ordered most in last 60 days along with numbers.*/
select p.product_id,p.product_title from products p inner join orders o inner join orderdetails d
where o.order_id=d.order_id and p.product_id=d.product_id and o.order_date>=(CURDATE()-interval 60 day)
group by d.product_id order by count(d.product_id) DESC limit 20;

select month(order_date) from orders;
/*Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
*/
select MONTH(order_date),sum(order_total) from orders where
order_date>=(CURDATE()-interval 6 month) group by MONTH(order_date) ;



/*Mark the products as Inactive which are not ordered in last 90 days.*/
update products p set p.status='inactive' where p.status='active' and p.product_id not in 
(select d.product_id from orderdetails d inner join orders o where o.order_id=d.order_id and 
o.order_date>=(curdate()-interval 90 day));

/*Given a category search keyword, display all the Products present in this category. */
select p.product_id, p.product_title from products p inner join categories c where p.category_id=c.category_id
and c.category_title like 'shirt';

/*Display top 10 Items which were cancelled most.*/
select p.product_id,p.product_title from products p inner join orderdetails d where d.product_status like 
'canceled' group by p.product_id order by count(p.product_id) DESC limit 10;