create database TPFINAL;
use TPFINAL;

-- drop database TPFINAL;

create table Usuario (
	e_mail varchar(50),
	nombre varchar(50), 
	contrasena varchar(20),
	constraint pk_Usuario primary key (e_mail)
);

create table Libro(
	idUsuario varchar(50),
	nombreLibro varchar(50), 
	autor_es varchar(20),
    editorial varchar(50),
	genero varchar(50), 
    fecha date,
	puntaje int,
    serie varchar(50),
	pelicula varchar(50), 
	constraint pk_Libro primary key (nombreLibro,fecha,idUsuario),
	foreign key (idUsuario) references Usuario (e_mail)
);
 
create table Serie(
	idUsuario varchar(50),
	nombreSerie varchar(50), 
	temporadas int,
    capitulos int,
	plataforma varchar(20), 
    actor_es varchar (50),
    actriz_es varchar (50),
    libro varchar(50),
    pelicula varchar(50),
    fecha date,
    finalizada bool,
    links varchar(200),
    temporadaActual int,
    capituloActual int,
	puntaje int,
    constraint pk_Serie primary key (nombreSerie,idUsuario),
    foreign key (idUsuario) references Usuario (e_mail)
);

create table Pelicula(
	idUsuario varchar(50),
	nombrePelicula varchar(50), 
	director_a varchar(20), 
    actor_es varchar (50),
    actriz_es varchar (50),
    libro varchar(50),
    serie varchar(50),
    fecha date,
	puntaje int,
    constraint pk_Pelicula primary key (nombrePelicula,idUsuario),
    foreign key (idUsuario) references Usuario (e_mail)
);

create table Mensaje(
	idUsuarioEmisor varchar(50),
	idUsuarioReceptor varchar(50), 
	fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mensaje varchar(500),
    constraint pk_Mensaje primary key (idUsuarioEmisor,idUsuarioReceptor,fecha),
    foreign key (idUsuarioEmisor) references Usuario (e_mail),
    foreign key (idUsuarioReceptor) references Usuario (e_mail)
);

select e_mail from Usuario where e_mail not Like 'profe@gmail.com';
select * from mensaje;

insert into usuario (e_mail,nombre,contrasena) values('profe@gmail.com','profe','profe');
insert into usuario (e_mail,nombre,contrasena) values('sarah@gmail.com','sarah','sarah');
insert into usuario (e_mail,nombre,contrasena) values('federicio@gmail.com','fede','fede');
insert into usuario (e_mail,nombre,contrasena) values('matsi@gmail.com','mati','mati');
insert into usuario (e_mail,nombre,contrasena) values('ivansiyo@gmail.com','ivan','ivan');



insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','El profeta','2018-05-30',8);
insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','El principito','2018-05-29',7);
insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','Harry Potter','2018-05-28',6);
insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','Como hacer minalesas','2018-05-27',5);
insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','Historia de River','2018-05-26',4);
insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','Pero que viva el futbol Pisculichi','2018-05-25',3);
insert into  libro (idUsuario,nombreLibro,fecha,puntaje) values ('profe@gmail.com','Mi planta naranja lima','2018-05-24',1);

insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','Game of thrones','2014-05-30',8);
insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','The walking dead','2017-05-30',3);
insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','Las chicas del cable','2016-12-31',9);
insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','Grays Anathomy','2015-05-30',9);
insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','La casa de papel','2018-05-30',8);
insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','La historia de Ima','2015-01-02',7);
insert into serie (idUsuario,nombreSerie,fecha,puntaje) values ('profe@gmail.com','Friends','2011-05-30',8);

insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','Avengers','2018-05-30',9);
insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','Han Solo','2018-05-30',9);
insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','Hasta que el cuero aguante','2017-05-30',5);
insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','El club de la pelea','2010-05-30',9);
insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','Seven','2001-05-30',8);
insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','Bucando a Dory','2017-05-30',9);
insert into pelicula (idUsuario,nombrePelicula,fecha,puntaje) values ('profe@gmail.com','Rapidos y furiosos','2018-05-30',2);

select * from Libro;
select * from Serie;
select * from Pelicula;


