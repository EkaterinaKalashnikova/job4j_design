create table meets(
id serial primary key,
name varchar (255)
);

create table users(
                      id serial primary key,
                      name varchar (255)
);

create table status(
                       id serial primary key,
                       status boolean,
                       meets_id int,
                       users_id int
);

insert into meets(name) values('Семинар');
insert into meets(name) values('Тренинг');
insert into meets(name) values('Выставка');
insert into meets(name) values('Презентация');
insert into meets(name) values('Деловой прием');
insert into meets(name) values('Конференция');
insert into meets(name) values('Форум');

insert into users(name) values('Мария');
insert into users(name) values('Юрий');
insert into users(name) values('Антон');
insert into users(name) values('Дмитрий');
insert into users(name) values('Марк');
insert into users(name) values('Роман');
insert into users(name) values('Дарья');
insert into users(name) values('Ангелина');
insert into users(name) values('Ксения');
insert into users(name) values('Петр');
insert into users(name) values('Илья');
insert into users(name) values('Марат');
insert into users(name) values('Эльвира');

insert into status(status, meets_id, users_id) values('1', '1', '1');
insert into status(status, meets_id, users_id) values('0', '2', '2');
insert into status(status, meets_id, users_id) values('1', '3', '3');
insert into status(status, meets_id, users_id) values('1', '4', '4');
insert into status(status, meets_id, users_id) values('0', '5', '5');
insert into status(status, meets_id, users_id) values('0', '6', '6');
insert into status(status, meets_id, users_id) values('1', '6', '7');
insert into status(status, meets_id, users_id) values('0', '1', '8');
insert into status(status, meets_id, users_id) values('0', '2', '9');
insert into status(status, meets_id, users_id) values('1', '3', '10');
insert into status(status, meets_id, users_id) values('1', '4', '11');
insert into status(status, meets_id, users_id) values('1', '5', '12');
insert into status(status, meets_id, users_id) values('1', '6', '13');

select m.name, u.name, st.status from meets m join status st on m.id = st.meets_id
                                              join users u on st.users_id = u.id
where st.status = true group by m.name, u.name, st.status
order by m.name;

select m.name from meets m left join status st on m.id = st.meets_id
where  st.status IS NULL;

select squery.name from (select m.name as name, min(st.users_id) from meets m left join status st on m.id = st.meets_id
                         group by m.name having min(st.users_id) IS NULL) as squery;