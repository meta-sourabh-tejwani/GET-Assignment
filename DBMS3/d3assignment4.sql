select * from address;

alter table address add zipcode int;

update address set zipcode=313002 where city like 'udaipur';

update address set zipcode=302028 where city like 'jaipur';

update address set zipcode=303002 where city like 'bhilwara';

update address set zipcode=313202 where city like 'delhi';

update address set zipcode=123102 where city like 'bombay';

update address set zipcode=311102 where city like 'ahemdabad';

update address set zipcode=313442 where city like 'surat';

update address set zipcode=423702 where city like 'rajsamand';

/*Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/
select zipcode,city,state from address order by state,city;
