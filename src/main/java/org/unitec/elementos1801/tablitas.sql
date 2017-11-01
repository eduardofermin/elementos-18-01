--creacion de la entidad
create table mensajito(id integer primary key auto_increment,titulo varchar(30),cuerpo varchar(250));

select *from direccion;

create table usuario(cuenta integer primary key, nombre varchar(40), email varchar(40));

create table direccion(id integer primary key auto_increment, calle varchar(100),cp integer, municipio varchar(40), cuenta integer, foreign key (cuenta) references usuario(cuenta));
