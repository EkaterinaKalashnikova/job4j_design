create table roles(
	id serial primary key,
	name varchar(2000),
	qualification text
);

create table users (
	id serial primary key,
	name varchar(255),
	roles_id int references roles(id)
);

create table rules(
	id serial primary key,
	action varchar(2000)
);

create table states(
	id serial primary key,
	realisation text
);

create table category(
	id serial primary key,
	kind text
);

create table item(
	id serial primary key,
	name varchar(255),
	description text,
	users_id int references users(id),
	category_id int references category(id),
	states_id int references states(id)
);

create table commentses(
	id serial primary key,
	feature varchar(2000),
	item_id int references item(id)
);

create table attachs(
	id serial primary key,
	scroll varchar(2000),
	item_id int references item(id)
);

create table roles_rules(
	id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
);
