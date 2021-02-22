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

