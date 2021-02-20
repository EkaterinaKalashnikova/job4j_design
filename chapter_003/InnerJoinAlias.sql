create table owner(
	id serial primary key,
	name varchar(255),
	phone int
);

create table horse(
	id serial primary key,
	name varchar(255),
	color text,
	age int,
	owner_id int references owner(id)
);

insert into owner(name, phone) values('Белецкий Евгений','11525');
insert into owner(name, phone) values('Угрюмов Виктор','22232');
insert into owner(name, phone) values('Громова Нина','55555');

insert into horse(name, color, age, owner_id) values('Аспен', 'вороной', '9', '1');
insert into horse(name, color, age, owner_id) values('Шквал', 'рыжий', '11', '2');
insert into horse(name, color, age, owner_id) values('Дида', 'гнедая', '6', '3');
insert into horse(name, color, age) values('Бакс', 'серый', '2');
insert into horse(name, color, age) values('Афина', 'вороная', '1');

select*from horse inner join owner o on horse.owner_id = o.id;

select h.name, o.name, o.phone from horse as h join owner as o on h.owner_id = o.id;
select h.name, h.color, h.age, o.name from horse as h join owner as o on h.owner_id = o.id;
select h.name as Имя, o.name as Имя from horse as h join owner as o on h.owner_id = o.id;

select h.name from horse as h;
select h.name as Кличка, h.age as Возраст, o.name as владелец, o.phone as Телефон from horse as h join owner as o on h.owner_id = o.id;