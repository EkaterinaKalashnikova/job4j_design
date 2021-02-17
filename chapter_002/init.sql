create table users (
	id serial primary key,
	name varchar(255)
);

create table roles(
	id serial primary key,
	name varchar(2000),
	qualification_id text
);

create table rules(
	id serial primary key,
	action_id varchar(2000),
	user_id varchar(255)
);

create table item(
	id serial primary key,
	name varchar(255),
	description_id text
);

create table category(
	id serial primary key,
	kind_id text
);

create table states(
	id serial primary key,
	realisation_id text
);

create table commentses(
	id serial primary key,
	feature varchar(2000)
);

create table attachs(
	id serial primary key,
	scroll varchar(2000)
);

create table users_roles(
	id serial primary key,
	users_id int references users(id)
);

create table roles_rules(
	id serial primary key,
	roles_id int references users(id),
	rules_id int references rules(id)
);

create table item_users(
	id serial primary key,
	item_id int references item(id)
);

create table item_commentses(
	id serial primary key,
	commentses_id int references commentses(id)
);

create table item_attachs(
	id serial primary key,
	attachs_id int references attachs(id)
);

create table item_category(
	id serial primary key,
	item_id int references item(id)
);

create table item_state(
	id serial primary key,
	item_id int references item(id)
);

