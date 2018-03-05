drop database if exists gimnasio;

create database if not exists gimnasio;

use gimnasio;

/* Records of data base information. */
create table if not exists record(name varchar(10), descr varchar(30));

create table if not exists field(name varchar(20), descr varchar(30));
/*
cliente
	customer_id (y)
	name
	last_name 
	nacionalidad
	tipo_doc
	num_documento
	birthday
	ciudad
	localidad
		
plan
	plan	(Y)
	description

plan_amount
	plan		(Y)
	dt_to date	(Y)
	diasAlMes
	amount

cliente_plan
	customer_id		(Y)
	plan			(Y)
	fecha_inscripcion	(Y)
		
cliente_presentismo
	customer_id varchar(5) 	(Y)
	effdt date not null 	(Y)
*/

/* records configuration. */
create table if not exists config(name_gimnasio varchar(50) not null
		, showMessage char(1) not null);

insert into config(name_gimnasio, showMessage) values("Gimnasio ADN", 'Y');

create table if not exists language(language varchar(3) not null
		,field varchar(18)
		,text varchar(30)
		,primary key (language, field));
		
insert into language(language, field, text) values
('ARG', 'name', 'Nombre'),
('ENG', 'name', 'Name');

create table if not exists message_tbl(language varchar(3) not null
		, messageNumber integer not null
		, messageText varchar(50)
		,primary key(language, messageNumber));
		
insert into message_tbl(language, messageNumber, messageText) values
('ESP', 1, 'Su numero de asociado es el: /n %1'),
('ENG', 1, 'The number of customer is: /n %1'),
('ESP', 2, 'Por favor completar los campos: %1'),
('ENG', 2, 'Please complete: %1');

/* Records of app. */
create table if not exists customer(customer_id varchar(5) not null
		, name varchar(50) not null
		, last_name varchar(30) not null
		/*, nacionalidad varchar(50) not null
		, tipo_doc varchar(10) not null*/
		, num_documento varchar(16) not null
		, birthday date
		, signon_date date
		/*, ciudad varchar(30) not null
		, localidad varchar(30) not null*/
		, primary key (customer_id));
		
/*insert into cliente(customer_id, name, last_name, nacionalidad, tipo_doc, num_documento, birthday, ciudad, localidad)
values
('13254', 'Nicolas Daniel', 'Fernandez', 'Argentino', 'DNI', '20-34179142-2', STR_TO_DATE('02-11-1988','%d-%m-%Y'), 'Moreno', 'Moreno'),
('13255', 'Ignacio Damian', 'Fernandez', 'Argentino', 'DNI', '20-42142179-2', STR_TO_DATE('16-06-1993','%d-%m-%Y'), 'Moreno', 'Moreno');
*/
insert into customer(customer_id, name, last_name, num_documento, birthday, signon_date)
values
('13254', 'Nicolas Daniel', 'Fernandez', '34179142', STR_TO_DATE('02-11-1988','%d-%m-%Y'), STR_TO_DATE('01-01-2012','%d-%m-%Y')),
('13255', 'Ignacio Damian', 'Fernandez', '42142179', STR_TO_DATE('16-06-1993','%d-%m-%Y'), STR_TO_DATE('01-01-2012','%d-%m-%Y'));


create table if not exists plan_hdr(plan varchar(12) not null
		, description varchar(30)
		, primary key (plan));

create table if not exists plan_line(plan varchar(12) not null
		,effdt date
		,tipo_plan varchar(20)
		,durability_Of_Plan int
		,days_of_plan int
		,amount int
		,primary key (plan, effdt));
		
insert into plan_hdr(plan, description) 
values('FULL', 'Incluye todas las rutinas');

insert into plan_line(plan, effdt, tipo_plan, durability_of_plan, days_of_plan, amount) 
values('FULL', STR_TO_DATE('12-05-2017', '%d-%m-%Y'), 'MENSUAL', 0, 12, 550);

create table if not exists customer_plan(customer_id varchar(5) not null
		, effdt date not null
		, plan varchar(12) not null
		, primary key (customer_id, effdt));
		
insert into customer_plan(customer_id, plan, effdt) values
('13254', 'FULL', adddate(curdate(), -2)),
('13255', 'FULL', STR_TO_DATE('01-01-1900','%d-%m-%Y'));

create table if not exists customer_pay(customer_id varchar(5) not null
		, effdt date not null
		, primary key(customer_id, effdt));
		
insert into customer_pay(customer_id, effdt) 
values
('13254','2017-11-01'),
('13254','2017-11-02');