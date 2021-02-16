insert into users(name) values('Поляков Артем');
insert into users(name) values('Рудный Виталий');
insert into users(name) values('Мироненко Александр');

insert into roles(name, qualification_id)values('сантехник', '1разряд');
insert into roles(name, qualification_id)values('сантехник', '2разряд');
insert into roles(name, qualification_id)values('сантехник', '3разряд');

insert into rules(action_id)values('допуск в ТУ');
insert into rules(action_id)values('допуск к оборудованию');
insert into rules(action_id)values('допуск в ЦТП');

insert into item(name, description_id)values('течь трубопровода', 'по трубе хвс течь из-под вентиля');
insert into item(name, description_id)values('течет радиатор', 'капает со стыка трубы отопления и радиатора');
insert into item(name, description_id)values('вода под домом', 'из ТУ течет канализация');

insert into category(kind_id)values('срочная');
insert into category(kind_id)values('текущая');
insert into category(kind_id)values('профилактика');

insert into states(realisation_id)values('в процессе');
insert into states(realisation_id)values('принята');
insert into states(realisation_id)values('выполнено');

insert into commentses(feature)values('ленинградская система отопления');
insert into commentses(feature)values('недавно заменен трубопровод');
insert into commentses(feature)values('металлопластиковые трубы');

insert into attachs(scroll)values('схема');
insert into attachs(scroll)values('снимок');
insert into attachs(scroll)values('график проведенных работ');



