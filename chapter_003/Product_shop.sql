create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price int
);

insert into type(name) values('Молоко');
insert into type(name) values('Мороженое');
insert into type(name) values('Хлеб');
insert into type(name) values('Сыр');
insert into type(name) values('Колбасы');
insert into type(name) values('Рыба');
insert into type(name) values('Мясо');
insert into type(name) values('Овощи');
insert into type(name) values('Фрукты');
insert into type(name) values('Конфеты');
insert into type(name) values('Соки');

insert into product(name, type_id, expired_date, price) values('молоко', '1', '26.02.2021', '58');
insert into product(name, type_id, expired_date, price) values('кефир', '1', '01.03.2021', '50');
insert into product(name, type_id, expired_date, price) values('сметана', '1', '01.03.2021', '100');
insert into product(name, type_id, expired_date, price) values('магнат', '2', '21.08.2021', '94');
insert into product(name, type_id, expired_date, price) values('пломбир', '2', '21.08.2021', '70');
insert into product(name, type_id, expired_date, price) values('эскимо', '2', '21.08.2021', '120');
insert into product(name, type_id, expired_date, price) values('батон', '3', '24.02.2021', '50');
insert into product(name, type_id, expired_date, price) values('ржаной хлеб', '3', '24.02.2021', '17');
insert into product(name, type_id, expired_date, price) values('булка', '3', '24.02.2021', '24');
insert into product(name, type_id, expired_date, price) values('голландский сыр', '4', '21.05.2021', '350');
insert into product(name, type_id, expired_date, price) values('сыр-гауда', '4', '21.05.2021', '500');
insert into product(name, type_id, expired_date, price) values('российский сыр', '4', '21.05.2021', '150');
insert into product(name, type_id, expired_date, price) values('салями', '5', '21.03.2021', '1300');
insert into product(name, type_id, expired_date, price) values('докторская', '5', '21.03.2021', '230');
insert into product(name, type_id, expired_date, price) values('кровянка', '5', '21.03.2021', '850');
insert into product(name, type_id, expired_date, price) values('муксун', '6', '21.12.2021', '600');
insert into product(name, type_id, expired_date, price) values('нельма', '6', '21.12.2021', '690');
insert into product(name, type_id, expired_date, price) values('пеленгас', '6', '21.12.2021', '298');
insert into product(name, type_id, expired_date, price) values('свинина', '7', '15.03.2021', '430');
insert into product(name, type_id, expired_date, price) values('говядина', '7', '10.03.2021', '345');
insert into product(name, type_id, expired_date, price) values('курица', '7', '07.03.2021', '210');
insert into product(name, type_id, expired_date, price) values('огурцы', '8', '28.02.2021', '45');
insert into product(name, type_id, expired_date, price) values('помидоры', '8', '28.02.2021', '90');
insert into product(name, type_id, expired_date, price) values('капуста', '8', '28.02.2021', '7');
insert into product(name, type_id, expired_date, price) values('киви', '9', '25.02.2021', '179');
insert into product(name, type_id, expired_date, price) values('яблоки', '9', '25.02.2021', '60');
insert into product(name, type_id, expired_date, price) values('бананы', '9', '25.02.2021', '84');
insert into product(name, type_id, expired_date, price) values('ласточка', '10', '21.04.2021', '399');
insert into product(name, type_id, expired_date, price) values('барбарис', '10', '01.01.2022', '249');
insert into product(name, type_id, expired_date, price) values('белочка', '10', '21.04.2021', '559');
insert into product(name, type_id, expired_date, price) values('любимый', '11', '01.01.2022', '75');
insert into product(name, type_id, expired_date, price) values('рич', '11', '01.01.2022', '157');
insert into product(name, type_id, expired_date, price) values('добрый', '11', '01.01.2022', '85');

1. Написать запрос получение всех продуктов с типом "СЫР":
   select id from type where name = 'Сыр';

2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
   select name from product where name like '%Мороженое%';

3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
   select name from product where EXTRACT(MONTH FROM expired_date) = EXTRACT(MONTH FROM now())+1;

4. Написать запрос, который выводит самый дорогой продукт.
   select max(price) from product;
   select name, price from product where price = (select max(price) from product);

5. Написать запрос, который выводит количество всех продуктов определенного типа.
   select count(name) from type;

6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
   select name from product where type_id in ((select id from type where name = 'Сыр'), (select id from type where name = 'Молоко'));

7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
   select name from type where (select count(p.id) from product as p where p.type_id = type.id) < 10;
   
8. Вывести все продукты и их тип.
   select p.name, t.name from product as p left join type as t on t.id = p.type_id;




