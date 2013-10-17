create database if not exists REVITAASSIST;

use REVITAASSIST;

grant all on REVITAASSIST.* to 'superuser'@localhost identified by 'RESU#2010_2014';

create table if not exists USER
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(250),
	email VARCHAR(250) UNIQUE,
	password VARCHAR(32), 
	language VARCHAR(2),
	organization VARCHAR(250),
	function VARCHAR(250)
);

create table if not exists ROLE
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(250),
	description VARCHAR(1000)
);

create table if not exists PROJECT
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(250),
	stage VARCHAR(250),
	description VARCHAR(1000),
	archive BOOLEAN DEFAULT false
);

create table if not exists USERPROJECTREL
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	userid INT REFERENCES USER.id,
	projectid INT REFERENCES PROJECT.id
);