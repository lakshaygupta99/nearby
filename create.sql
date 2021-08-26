create sequence hibernate_sequence start with 1 increment by 1
create table cart (id bigint not null auto_increment, coupon_ids tinyblob, user_id bigint not null, primary key (id)) engine=InnoDB
create table coupons (id bigint not null auto_increment, area varchar(255) not null, city varchar(255) not null, code varchar(255) not null, count integer not null, description varchar(255), image varchar(255), liked_by tinyblob, name varchar(255) not null, price bigint not null, shop_name varchar(255) not null, primary key (id)) engine=InnoDB
create table my_offers (id bigint not null auto_increment, address varchar(255), coupons tinyblob, email varchar(255) not null, phone varchar(255), transaction_date date, user_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null, address varchar(255), email varchar(255) not null, name varchar(255) not null, password varchar(255) not null, phone varchar(255), username varchar(255) not null, primary key (id)) engine=InnoDB
alter table cart add constraint UK_9emlp6m95v5er2bcqkjsw48he unique (user_id)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
create sequence hibernate_sequence start with 1 increment by 1
create table cart (id bigint not null auto_increment, coupon_ids tinyblob, user_id bigint not null, primary key (id)) engine=InnoDB
create table coupons (id bigint not null auto_increment, area varchar(255) not null, city varchar(255) not null, code varchar(255) not null, count integer not null, description varchar(255), image varchar(255), liked_by tinyblob, name varchar(255) not null, price bigint not null, shop_name varchar(255) not null, primary key (id)) engine=InnoDB
create table my_offers (id bigint not null auto_increment, address varchar(255), coupons tinyblob, email varchar(255) not null, phone varchar(255), transaction_date date, user_id bigint, primary key (id)) engine=InnoDB
create table users (id bigint not null, address varchar(255), email varchar(255) not null, name varchar(255) not null, password varchar(255) not null, phone varchar(255), username varchar(255) not null, primary key (id)) engine=InnoDB
alter table cart add constraint UK_9emlp6m95v5er2bcqkjsw48he unique (user_id)
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
