drop database if exists gimnasio;

create database if not exists gimnasio;

use gimnasio;

/* Records of data base information. */
create table if not exists recod(nombre varchar(10), descr varchar(30));

create table if not exists field(nombre varchar(20), descr varchar(30));
/*
cliente
	id_cliente (y)
	nombre
	apellido 
	nacionalidad
	tipo_doc
	num_documento
	fecha_nacimiento
	ciudad
	localidad
		
plan
	plan	(Y)
	descripcion

plan_precio
	plan		(Y)
	dt_to date	(Y)
	diasAlMes
	precio

cliente_plan
	id_cliente		(Y)
	plan			(Y)
	fecha_inscripcion	(Y)
		
cliente_presentismo
	id_cliente varchar(5) 	(Y)
	effdt date not null 	(Y)
*/

/* records configuration. */
create table if not exists config(nombre_gimnasio varchar(50) not null);

insert into config(nombre_gimnasio) values("Lo de Betty");

/* Records of app. */
create table if not exists cliente(id_cliente varchar(5) not null
		, nombre varchar(50) not null
		, apellido varchar(30) not null
		, nacionalidad varchar(50) not null
		, tipo_doc varchar(10) not null
		, num_documento varchar(16) not null
		, fecha_nacimiento date
		, ciudad varchar(30) not null
		, localidad varchar(30) not null
		, primary key (id_cliente));
		
insert into cliente(id_cliente, nombre, apellido, nacionalidad, tipo_doc, num_documento, fecha_nacimiento, ciudad, localidad)
values
('13254', 'Nicolas Daniel', 'Fernandez', 'Argentino', 'DNI', '20-34179142-2', STR_TO_DATE('02-11-1988','%d-%m-%Y'), 'Moreno', 'Moreno'),
('13255', 'Ignacio Damian', 'Fernandez', 'Argentino', 'DNI', '20-42142179-2', STR_TO_DATE('16-06-1993','%d-%m-%Y'), 'Moreno', 'Moreno');

create table if not exists plan_hdr(plan varchar(12) not null
		, descripcion varchar(30)
		, primary key (plan));

create table if not exists plan_line(plan varchar(12) not null
		,effdt date
		,tipoPlan varchar(20)
		,durabilityOfPlan int
		,diasDelPlan int
		,precio int
		,primary key (plan, effdt));
		
insert into plan_hdr(plan, descripcion) 
values('FULL', 'Incluye todas las rutinas');

insert into plan_line(plan, effdt, tipoPlan, durabilityOfPlan, diasDelPlan, precio) 
values('FULL', STR_TO_DATE('12-05-2017', '%d-%m-%Y'), 'MENSUAL', 0, 12, 550);

create table if not exists cliente_plan(id_cliente varchar(5) not null
		, plan varchar(12) not null
		, fecha_inscripcion date not null
		, primary key (id_cliente, plan, fecha_inscripcion));
		
insert into cliente_plan(id_cliente, plan, fecha_inscripcion) values
('13254', 'FULL', adddate(curdate(), -2)),
('13255', 'FULL', STR_TO_DATE('01-01-1900','%d-%m-%Y'));

create table if not exists cliente_presentismo(id_cliente varchar(5) not null
		, effdt date not null
		, primary key(id_cliente, effdt));
		
insert into cliente_presentismo (id_cliente, effdt) 
values
('13254','2017-11-01'),
('13254','2017-11-02');