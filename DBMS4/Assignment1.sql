drop function countOrder;


delimiter //
create function countOrder(m varchar(2),y varchar(4)) returns int
begin
    declare total int;
    set total=(select count(order_id) from orders where Month(order_date)=m and year(order_date)=y);
    return total;
end//

select countOrder('03','2021');
//

create function maxOrderMonth(y varchar(4)) returns varchar(2)
begin
    declare mon varchar(2);
    set mon=(select month(order_date) from orders where order_date in  (select order_date from orders where
    year(order_date)= y group by month(order_date) order by count(order_id) desc) limit 1);
    return mon;
end//


select maxOrderMonth('2020')//