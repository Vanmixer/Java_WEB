drop database if exists car_rental;

create database if not exists car_rental;

use car_rental;

create table car(
    id int auto_increment primary key,
    mark varchar(64) not null,
    name varchar(64) not null,
    car_class varchar(16) not null,
    car_prise decimal(8,2) not null
);

create table user(
	id int auto_increment primary key,
    user_role varchar(32) not null,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    user_count_of_money DECIMAL(10,2) default 0.00,
    is_active boolean not null
);

create table rent(
     id int auto_increment primary key,
     start_date timestamp not null,
     end_date timestamp not null,
     with_driver boolean not null,
     prise DECIMAL(10,2) default 0.00,
     massage varchar(5000),
     is_active boolean not null,
	 user_id int not null,
     car_id int not null,
     foreign key(user_id) references user(id) on delete cascade,
     foreign key(car_id) references car(id) on delete cascade
);