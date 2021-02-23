create table departments(
	id serial primary key,
	name varchar(255)
);

create table emploees(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);

insert into departments(name) values('transport');
insert into departments(name) values('education');
insert into departments(name) values('health');
insert into departments(name) values('finance');

insert into emploees(name, departments_id) values('captain', 1);
insert into emploees(name, departments_id) values('pilot', 1);
insert into emploees(name, departments_id) values('conductor', 1);
insert into emploees(name, departments_id) values('teacher', 2);
insert into emploees(name, departments_id) values('professor', 2);
insert into emploees(name, departments_id) values('doctor', 3);
insert into emploees(name, departments_id) values('nurse', 3);

--Выполнить запросы с left, rigth, full, cross соединениями:
1. select * from departments d left join emploees e on e.departments_id = d.id;
1a. select * from emploees e left join departments d on d.id = e.departments_id;
2. select * from emploees e right join departments d on e.departments_id = d.id;
2a. select * from departments d right join emploees e on e.departments_id = d.id;
3. select * from departments d full join emploees e on e.departments_id = d.id;
3a. select * from departments d left join emploees e on e.departments_id = d.id
union
select * from departments d right join emploees e on e.departments_id = d.id;
4. select * from departments d cross join emploees e;

--Используя left join найти департаменты, у которых нет работников:
select d.name, e.name from departments d left join emploees e on d.id = e.departments_id
where e.name IS NULL;

--Используя left и right join написать запросы, которые давали бы одинаковый результат:
 select d.name, e.name from departments d left join emploees e on d.id = e.departments_id
where e.name IS NULL;
 select d.name, e.name from emploees e right join departments d on d.id = e.departments_id
where e.name IS NULL;

 --Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары:
create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(34)
);

insert into teens(name, gender) values('Lisa', 'female');
insert into teens(name, gender) values('Dina', 'female');
insert into teens(name, gender) values('Roman', 'male');
insert into teens(name, gender) values('Lucas', 'male');
insert into teens(name, gender) values('Edvard', 'male');
insert into teens(name, gender) values('Anna', 'female');
insert into teens(name, gender) values('Kira', 'female');

select t1.name as nam, t2.gender as gend from teens t1 cross join teens t2;
