use storefront;

select * from products;

select * from products where product_title like 'clock';

select * from categories;
/*Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.*/
select product_id,product_title,count(category_id) from products group by product_title having count(category_id);

/*Display Count of products as per below price range:*/
/*0-50*/
select count(product_id) as total from products where product_price>=0 and product_price<=50;

/*101-500*/
select count(product_id) as total from products where product_price>=101 and product_price<=500;

/*above 500*/
select count(product_id) as total from products where product_price>500;

/*Display the categories along with number of products under each category*/
select c.category_title ,count(p.category_id) as total_product from categories c Inner join products p where p.category_id
=c.category_id group by p.category_id;
