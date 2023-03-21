DROP DATABASE IF EXISTS VIDEOJUEGOS;
CREATE DATABASE VIDEOJUEGOS;
USE VIDEOJUEGOS;

DROP TABLE IF EXISTS JUEGOS;
CREATE TABLE JUEGOS(
	id				int				primary key		auto_increment,
    nombre			varchar(200)	not null		unique,
    jugabilidad		double,
    diseño			double,
    rejugabilidad	double,
    mundo			double,
    graficos 		double,
    historia		double,
    banda_sonora 	double,
    media 			double
);