use storefront;

select * from products;
select * from categories;
select * from orders;


/*Identify the columns require indexing in order, product, category tables and create indexes.*/

create index index_product on products (product_id);


create index index_categories on categories(category_id,parent_id);


create index index_orders on orders(order_id,order_date);