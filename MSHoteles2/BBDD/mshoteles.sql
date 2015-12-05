CREATE TABLE Cliente (
	Nombre VARCHAR(30) NOT NULL,
	Apellidos VARCHAR (60) NOT NULL,
	DNI VARCHAR(9) NOT NULL UNIQUE,
	ID_Cliente INTEGER NOT NULL,
	flag INTEGER NOT NULL
);

ALTER TABLE Cliente
	ADD PRIMARY KEY (ID_Cliente);
	

CREATE TABLE ClienteVip(
	ID_Cliente INTEGER NOT NULL,
	Descuento INTEGER NOT NULL
);

ALTER TABLE ClienteVip
	ADD (
		PRIMARY KEY (ID_Cliente)
		FOREIGN KEY (ID_Cliente) REFERENCES Cliente ON DELETE CASCADE,
		CHECK(Descuento BETWEEN 0 AND 100)
	);

CREATE TABLE ClienteEstandar (
	ID_Cliente INTEGER NOT NULL,
	PuntosACumulados INTEGER NOT NULL
);

ALTER TABLE ClienteEstandar 
	ADD (
		PRIMARY KEY (ID_Cliente)
		FOREIGN KEY (ID_Cliente) REFERENCES Cliente ON DELETE CASCADE
	);

CREATE TABLE Habitacion (
	Piso INTEGER NOT NULL,
	Ocupado BOOLEAN NOT NULL,
	Numero INTEGER NOT NULL,
	Tipo INTEGER NOT NULL,
	ID_Habitacion INTEGER NOT NULL,
	flag INTEGER NOT NULL
);

ALTER TABLE Habitacion
	ADD(
		PRIMARY KEY (ID_Habitacion)
	);

CREATE TABLE Reserva (
	Precio FLOAT NOT NULL,
	FechaEntrada DATE NOT NULL,
	FechaSalida DATE NOT NULL,
	ID_Cliente INTEGER NOT NULL,
	ID_Habitacion INTEGER NOT NULL,
	NumeroOcupantes INTEGER NOT NULL,
	ID_Reserva INTEGER NOT NULL,
	flag INTEGER NOT NULL
);

ALTER TABLE Reserva
	ADD(
		PRIMARY KEY (ID_Reserva),
		FOREIGN KEY (ID_Cliente) REFERENCES Cliente ON DELETE CASCADE,
	);












