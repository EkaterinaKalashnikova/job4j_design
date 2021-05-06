CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values ('1','Дуплекс');
insert into company(id, name) values ('2','Витсервис');
insert into company(id, name) values ('3','Интелком');
insert into company(id, name) values ('4','Кама');
insert into company(id, name) values ('5','Альфаком');
insert into company(id, name) values ('6','КемТрансСтрой');
insert into company(id, name) values ('7','Айсервис23');

insert into person(id, name, company_id) values ('1','Маша', '1');
insert into person(id, name, company_id) values ('2','Даша', '1');
insert into person(id, name, company_id) values ('3','Виктор', '1');

insert into person(id, name, company_id) values ('4','Сергей', '2');
insert into person(id, name, company_id) values ('5','Михаил', '2');
insert into person(id, name, company_id) values ('6','Юлия', '2');
insert into person(id, name, company_id) values ('7','Айдар', '2');

insert into person(id, name, company_id) values ('8','Ильнур', '3');
insert into person(id, name, company_id) values ('9','Камилла', '3');
insert into person(id, name, company_id) values ('10','Данил', '3');
insert into person(id, name, company_id) values ('11','Никита', '3');
insert into person(id, name, company_id) values ('12','Алексей', '3');

insert into person(id, name, company_id) values ('13','Татьяна', '4');
insert into person(id, name, company_id) values ('14','Евгений', '4');
insert into person(id, name, company_id) values ('15','Ирина', '4');
insert into person(id, name, company_id) values ('16','Тимофей', '4');

insert into person(id, name, company_id) values ('17','Валера', '5');
insert into person(id, name, company_id) values ('18','Петр', '5');
insert into person(id, name, company_id) values ('19','Раиль', '5');
insert into person(id, name, company_id) values ('20','Рамиль', '5');
insert into person(id, name, company_id) values ('21','Лилия', '5');

insert into person(id, name, company_id) values ('22','Ландыш', '6');
insert into person(id, name, company_id) values ('23','Диана', '6');
insert into person(id, name, company_id) values ('24','Марина', '6');
insert into person(id, name, company_id) values ('25','Арина', '6');

insert into person(id, name, company_id) values ('26','Нина', '7');
insert into person(id, name, company_id) values ('27','Ильяс', '7');
insert into person(id, name, company_id) values ('28','Егор', '7');
insert into person(id, name, company_id) values ('29','Илья', '7');

1. select p.name, c.name, p.company_id
from person p left join company c on p.company_id = c.id
where company_id != 5


2.1. select subtable.nam, subtable.count  from (select c.name nam, count(p.name) count
                                           from person p left join company c on p.company_id = c.id
                                           group by c.name) subtable
where subtable.count in(select max(subtable.count) from (select c.name nam, count(p.name) count
                                                         from person p left join company c on p.company_id = c.id
                                                         group by c.name) subtable)


2.2 select subtable.nam, subtable.count from (select c.name nam, count(p.name) count
                                           from person p left join company c on p.company_id = c.id
                                           group by c.name) subtable
inner join
(select max(subte.count) max1 from (select c.name nam, count(p.name) count
                                                         from person p left join company c on p.company_id = c.id
                                                         group by c.name) subte) subte2 on subtable.count = subte2.max1