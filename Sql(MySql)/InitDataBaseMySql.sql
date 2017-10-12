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
values
('13254', 'Nicolas Daniel', 'Fernandez', 'Argentino', 'DNI', '20-34179142-2', STR_TO_DATE('02-11-1988','%d-%m-%Y'), 'Moreno', 'Moreno'),
('13255', 'Ignacio Damian', 'Fernandez', 'Argentino', 'DNI', '20-42142179-2', STR_TO_DATE('16-06-1993','%d-%m-%Y'), 'Moreno', 'Moreno');

create table if not exists plan(plan varchar(12) not null
		, descripcion varchar(30)
		, primary key (plan));

create table if not exists plan_precio(plan varchar(12) not null
		,dt_to date
		,diasAlMes int
		,precio int
		,primary key (plan, dt_to));
		
insert into plan(plan, descripcion) values('FULL', 'Incluye todas las rutinas');

insert into plan_precio(plan, dt_to, diasAlMes, precio) values('FULL', STR_TO_DATE('12-05-2017', '%d-%m-%Y'), 12, 550);

create table if not exists cliente_plan(id_cliente varchar(5) not null
		, plan varchar(12) not null
		, fecha_inscripcion date not null
		, primary key (id_cliente, plan, fecha_inscripcion));
		
insert into cliente_plan(id_cliente, plan, fecha_inscripcion) values
('13254', 'FULL', adddate(curdate(), -2)),
('13255', 'FULL', STR_TO_DATE('01-01-1900','%d-%m-%Y'));

create table if not exists cliente_presentismo(id_cliente varchar(5) not null
		, fecha date not null
		, primary key(id_cliente, fecha));