CREATE TABLE Intencion(
	id_intencion INT PRIMARY KEY,
    fecha_hora char(20),
    inte_alias_cliente char(20),
    inte_id_producto int,
    FOREIGN KEY (inte_alias_cliente) REFERENCES cliente (alias_cliente),
    FOREIGN KEY (inte_id_producto) REFERENCES producto ( id_producto )
);


INSERT INTO Intencion VALUES (1,"2017-10-25 20:00:00","lucky",1);
INSERT INTO Intencion VALUES (2,"2019-03-15 18:30:00", "lucky",2);
INSERT INTO Intencion VALUES (3,"2019-05-20 20:30:00", "lucky",6);
INSERT INTO Intencion VALUES (4, "2018-05-20 20:30:00","malopez",1);
INSERT INTO Intencion VALUES (5,"2020-01-20 20:30:00","malopez",6);
INSERT INTO Intencion VALUES (6,"2019-05-20 20:30:00", "diva",3) ;
INSERT INTO Intencion VALUES (7,"2018-06-22 21:30:00","diva",4);
INSERT INTO Intencion VALUES (8,"2020-03-17 15:30:20","diva",7);
INSERT INTO Intencion VALUES (9,"2020-03-17 15:30:20","dreamer",7);
INSERT INTO Intencion VALUES (10,"2020-04-10 18:30:20","dreamer",8);
INSERT INTO Intencion VALUES (11,"2020-02-17 20:30:20","ninja",9);
INSERT INTO Intencion VALUES (12,"2020-02-20 16:30:20","ninja",6);
INSERT INTO Intencion VALUES (13,"2020-03-27 18:30:20","ninja",10);
INSERT INTO Intencion VALUES (14,"2020-03-20 21:30:20","rose",11);
INSERT INTO Intencion VALUES (15,"2020-01-10 17:30:20","green",3);
INSERT INTO Intencion VALUES (16,"2020-02-15 20:30:20","green",2);
INSERT INTO Intencion VALUES (17,"2020-03-17 18:30:20","green",5);
