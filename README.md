# DESKTOP APPLICATION ----- Hotel Management System 

It is java based Desktop App .
For creating GUI for Hotel Management Application , "SWING" and "AWT" package is used.
For database handling , "Mysql" is used.

For running this application in your Local machine you have to set your lacal environment as follow:-
set root password of MySql = "1234"
create a new databse in root directory of MySql , those are written below

create database hotelmanagementsystem;

show databases;

use hotelmanagementsystem;

create table login(username varchar(25), password varchar(25));

insert into login values('Gumutch', 'Gumutch@mysql');

create table employee(name varchar(25), age varchar(10), gender varchar(10), job varchar(25), salary varchar(15), phone varchar(15), email varchar(40), aadhar varchar(15));

create table room(roomnumber varchar(10), availability varchar(15), cleaning_status varchar(15), price varchar(15), bed_type varchar(15));

create table driver(name varchar(25), age varchar(10), gender varchar(10), 
carCompany varchar(25), carModel varchar(15), availability varchar(15), carLocation varchar(40), carNumber varchar(20), aadhar varchar(15), phone varchar(15));

create table customer(id varchar(25), idNumber varchar(20), name varchar(25), 
gender varchar(10), country varchar(20), allocatedRoomNumber varchar(10), check_in_time varchar(40), deposit varchar(20),  phone varchar(15));


create table department( departmentName varchar(40), budget varchar(20));
insert into department values('Front Office', '200000');
insert into department values('House Keeping', '300000');
insert into department values('Food and Bevarrage', '1000000');
insert into department values('Maintanace', '500000');
insert into department values('Security', '600000');
select * from department;
            
