DROP DATABASE IF EXISTS INSTAGRAM;
CREATE DATABASE INSTAGRAM;
USE INSTAGRAM;

CREATE TABLE USUARIO(
	usuario				varchar(20),
    dni					char(9)			not null	unique,
    nombre_completo		varchar(50)		not null,
    correo				varchar(50)		not null,
    telefono			integer(9)		not null,
    fecha_nac			date			not null,
    numSeguidores		integer			not null,
    numSeguidos			integer			not null,
    verificado			boolean			not null,
    
    constraint fk_usuario primary key (usuario)
);

CREATE TABLE PUBLICACION(
	id_publicacion		char(4), 
    numLikes			integer			not null,
    numComentarios		integer			not null,
    fecha_subida		date			not null,
    ubicacion			varchar(50)		not null,	
    usuario				varchar(20)		not null,
    id_cancion			char(4)			not null,
    
    constraint fk_publicacion primary key(id_publicacion)
);

CREATE TABLE FOTO(
	etiquetados		varchar(20),
	id_publicacion	char(4),
    
    constraint pk_foto foreign key (id_publicacion) references publicacion(id_publicacion)
);
CREATE TABLE REEL(
	id_publicacion	char(4),
    
    constraint pk_foto foreign key (id_publicacion) references publicacion(id_publicacion)
);

CREATE TABLE HISTORIA(
	id_publicacion	char(4),
    
    constraint pk_foto foreign key (id_publicacion) references publicacion(id_publicacion));
CREATE TABLE TIPOHISTORIA();
CREATE TABLE CANCION();
CREATE TABLE GENERO();
CREATE TABLE ARTICULO();
CREATE TABLE COMPRA();
CREATE TABLE CONVERSA();
CREATE TABLE MENSAJE();
CREATE TABLE MEJORAMIGO();
CREATE TABLE SIGUE();