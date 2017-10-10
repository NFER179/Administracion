drop database gimnasio;

create database if not exists gimnasio;

use gimnasio;

create table if not exists config(nombre_gimnasio varchar(50) not null);

insert into config(nombre_gimnasio) values("Lo de Betty");

create table if not exists usuario(id_usuario varchar(6) not null
		, nombres varchar(50) not null
		, apellido varchar(30) not null
		, nacionalidad varchar(50) not null
		, tipo_doc varchar(10) not null
		, num_documento varchar(16) not null
		, fecha_nacimiento date
		, ciudad varchar(30) not null
		, localidad varchar(30) not null
		, primary key (id_usuario));
		
insert into usuario(id_usuario, nombres, apellido, nacionalidad, tipo_doc, num_documento, fecha_nacimiento, ciudad, localidad)
values('001327', 'Nicolas Daniel', 'Fernandez', 'Argentino', 'DNI', '20-34182304-2', STR_TO_DATE('09-9-1988','%d-%m-%Y'), 'Moreno', 'Moreno');
