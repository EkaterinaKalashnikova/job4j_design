create table carBody(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table car(
	id serial primary key,
	name varchar(255),
	carBody_id int references carBody(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into carBody(name) values('sedan');
insert into carBody(name) values('cupe');
insert into carBody(name) values('universal');
insert into carBody(name) values('crossover');
insert into carBody(name) values('miniven');
insert into carBody(name) values('pikap');
insert into carBody(name) values('sportcupe');
insert into carBody(name) values('sportcar');

insert into engine(name) values('gasoline');
insert into engine(name) values('diesel');
insert into engine(name) values('gas');

insert into transmission(name) values('automatic');
insert into transmission(name) values('mechanics');
insert into transmission(name) values('variator');
insert into transmission(name) values('robot');

insert into car(name, carBody_id, engine_id, transmission_id) values('mercedes', 1, 1, 1);
insert into car(name, carBody_id, engine_id, transmission_id) values('mercedes', 2, 1, 1);
insert into car(name, carBody_id, engine_id, transmission_id) values('mercedes', 3, 2, 3);
insert into car(name, carBody_id, engine_id, transmission_id) values('jeep', 4, 1, 3);
insert into car(name, carBody_id, engine_id, transmission_id) values('jeep', 5, 2, 1);
insert into car(name, carBody_id, engine_id, transmission_id) values('jeep', 6, 2, 2);
insert into car(name, carBody_id, engine_id, transmission_id) values('hyundai', 1, 1, 1);

1. Вывести список всех машин и все привязанные к ним детали:
select car.name, c.name, e.name, t.name from car car join carbody c on
car.carbody_id = c.id join engine e on car.engine_id = e.id
join transmission t on car.transmission_id = t.id;

2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач:
select car.name, c.name from carbody c left join car car on
car.carbody_id = c.id 
where car.name IS NULL;
select car. name, e.name from engine e left join car car on car.engine_id = e.id
where car.name IS NULL;
select car.name, t.name from transmission t left join car car on car.transmission_id = t.id
where car.name IS NULL;