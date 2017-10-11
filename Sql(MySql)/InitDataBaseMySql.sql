drop database gimnasio;

create database if not exists gimnasio;

use gimnasio;

create table if not exists config(nombre_gimnasio varchar(50) not null);

insert into config(nombre_gimnasio) values("Lo de Betty");

create table if not exists cliente(id_cliente varchar(5) not null
		, nombres varchar(50) not null
		, apellido varchar(30) not null
		, nacionalidad varchar(50) not null
		, tipo_doc varchar(10) not null
		, num_documento varchar(16) not null
		, fecha_nacimiento date
		, ciudad varchar(30) not null
		, localidad varchar(30) not null
		, primary key (id_cliente));
		
insert into cliente(id_cliente, nombres, apellido, nacionalidad, tipo_doc, num_documento, fecha_nacimiento, ciudad, localidad)
values('13254', 'Nicolas Daniel', 'Fernandez', 'Argentino', 'DNI', '20-34179142-2', STR_TO_DATE('02-11-1988','%d-%m-%Y'), 'Moreno', 'Moreno');