Insert into categories (category_title) values ('home');

Insert into categories (category_title) values ('fashion');

Insert into categories (category_title) values ('electronics');

Insert into categories (category_title) values ('sports');

Insert into categories (category_title) values ('stationary');

Insert into categories (category_title,parent_id) values ('kitchen',1);

Insert into categories (category_title,parent_id) values ('home decore',1);

Insert into categories (category_title,parent_id) values ('light',1);

Insert into categories (category_title,parent_id) values ('cleaning',1);

Insert into categories (category_title,parent_id) values ('men wear',2);

Insert into categories (category_title,parent_id) values ('women wear',2);

Insert into categories (category_title,parent_id) values ('shirt',9);

Insert into categories (category_title,parent_id) values ('Tshirt',9);

Insert into categories (category_title,parent_id) values ('jeans',9);

Insert into categories (category_title,parent_id) values ('tops',10);

Insert into categories (category_title,parent_id) values ('skirt',10);

Insert into categories (category_title,parent_id) values ('jeans',10);

Insert into categories (category_title,parent_id) values ('mobile',3);

Insert into categories (category_title,parent_id) values ('laptop',3);

Insert into categories (category_title,parent_id) values ('headphone',3);

Insert into categories (category_title,parent_id) values ('camera',3);

Insert into categories (category_title,parent_id) values ('footwear',4);

Insert into categories (category_title,parent_id) values ('accessories',4);

Insert into categories (category_title,parent_id) values ('bat',22);

Insert into categories (category_title,parent_id) values ('ball',22);

Insert into categories (category_title,parent_id) values ('pen',50);


select * from categories;

Insert into products(product_title,category_id,product_price,product_quantity) values ('pan',5,200,10);

Insert into products(product_title,category_id,product_price,product_quantity) values ('cooker',5,350,55);

Insert into products(product_title,category_id,product_price,product_quantity) values ('wallpaper',6,100,12);

Insert into products(product_title,category_id,product_price,product_quantity) values ('clock',6,550,30);

Insert into products(product_title,category_id,product_price,product_quantity) values ('bulb',7,90,100);

Insert into products(product_title,category_id,product_price,product_quantity) values ('torch',7,250,15);

Insert into products(product_title,category_id,product_price,product_quantity) values ('mob',8,100,40);

Insert into products(product_title,category_id,product_price,product_quantity) values ('wiper',8,100,20);

Insert into products(product_title,category_id,product_price,product_quantity) values ('casual shirt',11,400,40);

Insert into products(product_title,category_id,product_price,product_quantity) values ('fomal',11,700,50);

Insert into products(product_title,category_id,product_price,product_quantity) values ('round',12,300,60);

Insert into products(product_title,category_id,product_price,product_quantity) values ('vneck',12,450,50);

Insert into products(product_title,category_id,product_price,product_quantity) values ('denim',13,700,40);

Insert into products(product_title,category_id,product_price,product_quantity) values ('formal',13,550,50);



Insert into products(product_title,category_id,product_price,product_quantity) values ('blue pen',51,5,50);



Insert into products(product_title,category_id,product_price,product_quantity) values ('long top',14,600,70);

Insert into products(product_title,category_id,product_price,product_quantity) values ('short top',14,750,50);

Insert into products(product_title,category_id,product_price,product_quantity) values ('pencil',15,200,10);

Insert into products(product_title,category_id,product_price,product_quantity) values ('fly',15,300,15);

Insert into products(product_title,category_id,product_price,product_quantity) values ('skinny',16,700,20);

Insert into products(product_title,category_id,product_price,product_quantity) values ('highwaiest',16,1000,40);

Insert into products(product_title,category_id,product_price,product_quantity) values ('android',17,14000,20);

Insert into products(product_title,category_id,product_price,product_quantity) values ('ios',17,25000,10);

Insert into products(product_title,category_id,product_price,product_quantity) values ('buisness',18,60000,10);

Insert into products(product_title,category_id,product_price,product_quantity) values ('gaming',18,70000,15);

Insert into products(product_title,category_id,product_price,product_quantity) values ('wireless',19,1200,50);

Insert into products(product_title,category_id,product_price,product_quantity) values ('wired',19,450,60);

Insert into products(product_title,category_id,product_price,product_quantity) values ('compact',20,20000,60);

Insert into products(product_title,category_id,product_price,product_quantity) values ('wide',20,50000,40);

Insert into products(product_title,category_id,product_price,product_quantity) values ('nike',21,1000,100);

Insert into products(product_title,category_id,product_price,product_quantity) values ('puma',21,2000,100);

Insert into products(product_title,category_id,product_price,product_quantity) values ('sg',23,7000,50);

Insert into products(product_title,category_id,product_price,product_quantity) values ('mrf',23,5000,50);

Insert into products(product_title,category_id,product_price,product_quantity) values ('tennis',24,50,70);

Insert into products(product_title,category_id,product_price,product_quantity) values ('cosco',24,70,40);

insert into images(product_id) values(24);

insert into images(product_id) values(25);

select * from products;

use storefront;
/*display id, title, category title,price of product which are active and recently added product should at top*/
select p.product_id,p.product_title,c.category_title,p.product_price from products p ,categories c 
where p.category_id=c.category_id and status='active'
Order by p.product_id DESC;


/*display list of product which does not have any images*/
select product_id,product_title from products where product_id NOT IN(select product_id from images);

/*display the list  of products whose quantity on hand(inventory) is under 50*/
select * from products
where product_quantity<=50;

/*display product title,price and description which fall into particular category Title "mobile" */
select p.product_id,p.product_title,p.product_price from products p, categories c
where p.category_id = c.category_id AND c.category_title like 'mobile';

/*Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other
category)   */
select c1.category_id,c1.category_title,c2.category_title as parent_title from 
categories c1 join categories c2
on c1.parent_id=c2.category_id and c1.category_id not In
(select Distinct ifnull(parent_id,0) as category_id from categories);



/*Display all Id, Title and Parent Category Title for all the Categories listed, sorted by
Parent Category Title and then Category Title. (If Category is top category then Parent Category
Title column should display “Top Category” as value.)*/
select c2.category_id,c2.category_title, ifNull(c1.category_title,"Top category") from categories c1  RIGHT JOIN 
categories c2 on c1.category_id=c2.parent_id;


