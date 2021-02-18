insert into roles(name, qualification)values('сантехник', '1разряд');
insert into roles(name, qualification)values('сантехник', '2разряд');
insert into roles(name, qualification)values('сантехник', '3разряд');

insert into users(name, roles_id) values('Поляков Артем', '32');
insert into users(name, roles_id) values('Рудный Виталий', '32');
insert into users(name, roles_id) values('Мироненко Александр', '33');

insert into rules(action)values('допуск в ТУ');
insert into rules(action)values('допуск к оборудованию');
insert into rules(action)values('допуск в ЦТП');

insert into states(realisation)values('в процессе');
insert into states(realisation)values('принята');
insert into states(realisation)values('выполнено');

insert into category(kind)values('срочная');
insert into category(kind)values('текущая');
insert into category(kind)values('профилактика');

insert into item(name, description, users_id, category_id, states_id)values('течь трубопровода', 'по трубе хвс течь из-под вентиля', '12', '4', '4');
insert into item(name, description, users_id, category_id, states_id)values('течет радиатор', 'капает со стыка трубы отопления и радиатора', '14', '5', '5');
insert into item(name, description, users_id, category_id, states_id)values('вода под домом', 'из ТУ течет канализация', '13', '6', '6');

insert into commentses(feature, item_id)values('ленинградская система отопления', '12');
insert into commentses(feature, item_id)values('недавно заменен трубопровод', '10');
insert into commentses(feature, item_id)values('металлопластиковые трубы', '11');

insert into attachs(scroll, item_id)values('схема', '12');
insert into attachs(scroll, item_id)values('снимок', '11');
insert into attachs(scroll, item_id)values('график проведенных работ', '10');

insert into roles_rules(roles_id, rules_id) values('31', '4');
insert into roles_rules(roles_id, rules_id) values('32', '5');
insert into roles_rules(roles_id, rules_id) values('33', '6');



