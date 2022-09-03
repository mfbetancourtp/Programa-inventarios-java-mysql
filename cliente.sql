CREATE TABLE cliente(
	alias_cliente  char(20) PRIMARY KEY ,
    nombre char(20),
    apellidos char(20),
    email varchar(45),
    celular char(20),
    contrasenia int,
    fecha_de_nacimiento_cliente date
);

INSERT INTO cliente VALUES("lucky", "Pedro", "Perez", "pedrop@gmail.com", "3194633832", 56328987, "1984-09-15");
INSERT INTO cliente VALUES("malopez", "Maria", "Lopez", "mala@gmail.com", "3102182696", 32565487, "1994-06-23");
INSERT INTO cliente VALUES("diva", "Ana", "Diaz", "anadiaz@gmail.com", "312477513", 32125487, "1995-03-12");
INSERT INTO cliente VALUES("dreamer", "Luis", "Rojas", "luis.rojas@gmail.com", "3157280424", 32568987, "1997-04-20");
INSERT INTO cliente VALUES("ninja", "Andres", "Cruz", "ancruz@gmail.com", "3202378152", 42345678, "1996-08-20");
INSERT INTO cliente VALUES("neon", "Nelson", "Ruiz", "nelsomruiz@gmail.com", "3182378152", 54873256, "2000-01-05");
INSERT INTO cliente VALUES("rose", "Claudia", "Mendez", "claumendez@gmail.com", "3169927016", 89541287, "1997-06-11");
INSERT INTO cliente VALUES("green", "Jorge", "Rodriguez", "jorgero@gmail.com", "3194829288", 92387679, "1998-06-30");