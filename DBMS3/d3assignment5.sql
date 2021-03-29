select * from orders;
select * from shopper;
select * from address;

/*Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
with latest ordered items should be displayed first for last 60 days.*/
create view order_information as select p.product_id,p.product_title,u.user_name,o.order_date,o.order_status
from products p inner join shopper u inner join orders o inner join address a  inner join orderdetails d
where u.shopper_id=a.shopper_id and
a.address_id=o.address_id and o.order_date>=(curdate()-interval 60 day) and o.order_id=d.order_id 
and p.product_id=d.product_id order by o.order_date;

select * from order_information;

/*Use the above view to display the Products(Items) which are in ‘shipped’ state.*/
select * from order_information where order_status like 'shipped';


/*Use the above view to display the top 5 most selling products.*/
select product_title,count(product_title) from order_information group by product_title order by count(product_title) DESC limit 5;