-- Script utilizado en MYSQL para la creacion de la BD.

create database examenbd;
use examenbd;

CREATE TABLE Banco (
	idBanco int auto_increment primary key,
    nombre VARCHAR(100),
    direccion VARCHAR(100),
    fecRegistro DATETIME
);

CREATE TABLE Sucursal (
	idSucursal int auto_increment primary key,
    nombre VARCHAR(100),
    direccion VARCHAR(100),
    fecRegistro DATETIME,
    idBanco int,
    FOREIGN KEY(idBanco) REFERENCES Banco(idBanco)
);

CREATE TABLE OrdenPago (
	idOrdenPago int auto_increment primary key,
    monto decimal(10, 2),
    moneda CHAR(3),
    codEstado CHAR(2),
    fecPago DATETIME
);

CREATE TABLE SucursalOrdenPago (
	idSucursalOrdenBanco int auto_increment primary key,
    idSucursal int,
    idOrdenPago int,
    FOREIGN KEY(idSucursal) REFERENCES Sucursal(idSucursal),
    FOREIGN KEY(idOrdenPago) REFERENCES OrdenPago(idOrdenPago)
);