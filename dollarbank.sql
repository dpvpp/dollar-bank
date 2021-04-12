create database if not exists dollar_bank;
use dollar_bank;

create table if not exists customer (
	username varchar(100) primary key,
    cust_pw varchar(100) not null,
    firstname varchar(100),
    lastname varchar(100),
    phone varchar(20)
);

create table if not exists cust_account (
	account_id int auto_increment primary key,
    balance double not null default 0,
    username varchar(100) not null unique,
    foreign key(username) references customer(username)
);

create table if not exists transaction (
	trans_id int auto_increment primary key,
    trans_type varchar(100),
    amount double not null default 0,
    trans_date timestamp,
    account_id int not null,
	foreign key(account_id) references cust_account(account_id)
);

-- drop table transaction;
-- drop table cust_account;
-- drop table customer;
