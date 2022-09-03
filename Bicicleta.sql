CREATE TABLE Bicicleta(
	id_bicicleta INT PRIMARY KEY,
	anio_construccion INT,
	bici_id_producto int,
    FOREIGN KEY (id_bicicleta) REFERENCES producto(id_producto)
);

INSERT INTO Bicicleta VALUES (1,2020,1);
INSERT INTO Bicicleta VALUES (2,2019,2);
INSERT INTO Bicicleta VALUES (3,2020,3);
INSERT INTO Bicicleta VALUES (4,2021,4);
INSERT INTO Bicicleta VALUES (5,1018,5);