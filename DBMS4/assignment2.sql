use storefront;

/*Create a Stored procedure to retrieve average sales of each product in a month.
Month and year will be input parameter to function*/

create view order_info_date as (select d.product_id,sum(d.total) as total,sum(d.quantity) as quantity ,o.order_date from orderdetails d,orders o
where o.order_id=d.order_id group by d.product_id);

delimiter //
create procedure product(m varchar(2),y varchar(4))
Begin
    
    select p.product_id,p.product_title, ifnull(d.total/d.quantity,0) as average from products p 
    left join order_info_date  d on p.product_id=d.product_id and Month(d.order_date)=m
        and  year(d.order_date)=y;
    
End//


call product('02','2021');//





/*Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.*/

create procedure retriveData(startdate DATE,enddate DATE)
begin
    if startdate>enddate then set startdate=Date.Format(enddate,'01-%M-%Y');
    end if;
    select * from order_info_date where order_date>=startdate and order_date<=enddate;
end//

call retriveData('2020-11-01','2021-11-21');//
