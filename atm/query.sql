create database atm;
use atm; 

create table Acc (
	accNo int primary key,
    customerName varchar(50),
    pin int,
    balance int
);

insert into Acc values(1001,'Aathil',2005,50000);

select * from Acc;