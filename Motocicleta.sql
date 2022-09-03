CREATE TABLE Motocicleta(
	id_moto INT PRIMARY KEY,
    autonomia int,
    moto_id_proveedor int,
    moto_id_producto int,
    FOREIGN KEY (id_moto) REFERENCES producto(id_producto),
    FOREIGN KEY (moto_id_producto)  REFERENCES proveedor(prov_id)
);

INSERT INTO Motocicleta VALUES (1, 18 ,101,101);
INSERT INTO Motocicleta VALUES (2, 14 ,102,102);
INSERT INTO Motocicleta VALUES (3, 26 ,103,101);
INSERT INTO Motocicleta VALUES (4, 36 ,104,103);
INSERT INTO Motocicleta VALUES (5, 20, 105,104);
INSERT INTO Motocicleta VALUES (6, 12 ,106,105);