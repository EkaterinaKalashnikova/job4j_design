create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values('мультиварка', '4500');
insert into devices(name, price) values('чайник', '1500');
insert into devices(name, price) values('кофемашина', '27000');
insert into devices(name, price) values('хлебопечь', '9800');
insert into devices(name, price) values('кухонный комбайн', '11000');

insert into people(name) values('Мила');
insert into people(name) values('Лада');
insert into people(name) values('Валера');
insert into people(name) values('Иван');
insert into people(name) values('Анна');

insert into devices_people(device_id, people_id) values('1', '1');
insert into devices_people(device_id, people_id) values('1', '2');
insert into devices_people(device_id, people_id) values('1', '3');

insert into devices_people(device_id, people_id) values('2', '3');
insert into devices_people(device_id, people_id) values('2', '4');
insert into devices_people(device_id, people_id) values('2', '5');

insert into devices_people(device_id, people_id) values('3', '1');
insert into devices_people(device_id, people_id) values('3', '3');
insert into devices_people(device_id, people_id) values('3', '5');

insert into devices_people(device_id, people_id) values('4', '1');
insert into devices_people(device_id, people_id) values('4', '2');
insert into devices_people(device_id, people_id) values('4', '4');

insert into devices_people(device_id, people_id) values('5', '3');
insert into devices_people(device_id, people_id) values('5', '4');
insert into devices_people(device_id, people_id) values('5', '5');

select avg(price) from devices;
select avg(d.price) from devices d;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id 
join devices d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id 
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id 
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 8000;

