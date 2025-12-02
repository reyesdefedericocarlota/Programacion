-- CREACIÓN DE TABLAS DEL MODELO FÍSICO
-- Tabla Miembro UGR
CREATE TABLE Miembro_UGR (
        -- PRIMARY KEY sirve para indicar la clave primaria. CHAR(n) es un tipo de dato de longitud fija
        id_DNI CHAR(9) NOT NULL PRIMARY KEY,
        -- CHECK permite imponer condiciones que deben cumplirse antes de insertar un dato.
        -- En este caso se usa con REGEXP para asegurarse de que el DNI tenga exactamente el formato válido
        CHECK (id_DNI REGEXP '^[0-9]{8}[A-Z]$'),
        -- DATE es un tipo de dato usado para almacenar fechas con formato estándar: YYYY-MM-DD
        fecha_nacimiento DATE NOT NULL,
        localidad VARCHAR(50),
        provincia VARCHAR(50),
        pais VARCHAR(50) NOT NULL
    );

-- Tabla Centro
CREATE TABLE Centro (
      id_centro INT NOT NULL PRIMARY KEY,
      nombre VARCHAR(100) NOT NULL,
      anio_apertura YEAR NOT NULL,
      direccion VARCHAR(100) NOT NULL,
      tipo ENUM('facultad', 'colegio_mayor') NOT NULL,
      CONSTRAINT tipo_por_centro UNIQUE (id_centro, tipo)
    );

-- Tabla Facultad
CREATE TABLE Facultad (
      id_facultad INT NOT NULL PRIMARY KEY,
      id_centro_facultad INT NOT NULL,
     -- FOREIGN KEY sirve para indicar la clave externa.
      FOREIGN KEY (id_centro_facultad) REFERENCES Centro (id_centro)
    );

-- Tabla ColegioMayor
CREATE TABLE Colegio_Mayor (
      id_colegio_mayor INT NOT NULL PRIMARY KEY,
      id_centro_colegio_mayor INT NOT NULL,
      FOREIGN KEY (id_centro_colegio_mayor) REFERENCES Centro(id_centro)
    );

-- Tabla Estudiante
CREATE TABLE Estudiante (
      id_TUI VARCHAR(15) PRIMARY KEY,
      nombre VARCHAR(50) NOT NULL,
      id_DNI_estudiante CHAR(9) NOT NULL UNIQUE,
      id_facultad INT NOT NULL,
      id_colegio_mayor INT NULL,
      FOREIGN KEY (id_DNI_estudiante) REFERENCES Miembro_UGR (id_DNI), 
      FOREIGN KEY (id_facultad) REFERENCES Facultad (id_facultad), 
      FOREIGN KEY (id_colegio_mayor) REFERENCES Colegio_Mayor (id_colegio_mayor)
    );

-- Tabla Profesor
CREATE TABLE Profesor (
      id_profesor INT NOT NULL PRIMARY KEY,
      contrato VARCHAR(50) NOT NULL,
      -- DECIMAL(M,D) es un tipo de dato numérico que se usa para valores con decimales. M = número total de dígitos (enteros + decimales) y D = número de dígitos decimales
      sueldo DECIMAL(10,2) NOT NULL,
      departamento VARCHAR (50) NOT NULL,
      id_DNI_profesor CHAR(9) NOT NULL UNIQUE,
      FOREIGN KEY (id_DNI_profesor) REFERENCES Miembro_UGR(id_DNI)
    );

-- Tabla Staff
CREATE TABLE Staff (
      id_staff INT NOT NULL PRIMARY KEY,
      tipo_contrato VARCHAR(50) NOT NULL,
      sueldo DECIMAL(10,2) NOT NULL,
      id_DNI_staff CHAR(9) NOT NULL UNIQUE,
      FOREIGN KEY (id_DNI_staff) REFERENCES Miembro_UGR(id_DNI)
    );

-- Tabla Deporte
CREATE TABLE Deporte (
      id_deporte INT NOT NULL PRIMARY KEY,
      nombre VARCHAR(50) NOT NULL,
      min_jugadores INT NOT NULL,
      max_jugadores INT NOT NULL
    );

-- Tabla Torneo
CREATE TABLE Torneo (
      id_torneo INT NOT NULL PRIMARY KEY,
      anio YEAR NOT NULL,
      max_equipos INT NOT NULL,
      min_equipos INT NOT NULL,
      ganador INT NULL,
      id_deporte INT NOT NULL,
      FOREIGN KEY (id_deporte) REFERENCES Deporte(id_deporte)
    );

-- Tabla Equipo
CREATE TABLE Equipo (
      id_equipo INT NOT NULL PRIMARY KEY,
      nombre VARCHAR(100) NOT NULL,
      -- YEAR es un tipo de dato que sirve para almacenar exclusivamente años.
      curso_inscripcion YEAR NOT NULL,
      id_centro INT NOT NULL,
      id_torneo INT NOT NULL,
      id_capitan VARCHAR(15) NOT NULL,
      FOREIGN KEY (id_centro) REFERENCES Centro (id_centro),
      FOREIGN KEY (id_torneo) REFERENCES Torneo (id_torneo),
      FOREIGN KEY (id_capitan) REFERENCES Estudiante (id_TUI)
    );

-- Añadimos clave externa de ganador a la tabla torneo
ALTER TABLE Torneo
ADD FOREIGN KEY (ganador) REFERENCES Equipo(id_equipo);

-- Tabla Staff_Arbitra_Torneo
CREATE TABLE Staff_Arbitra_Torneo (
        id_arbitro INT NOT NULL,
        id_torneo INT NOT NULL,
        PRIMARY KEY (id_arbitro, id_torneo),
        FOREIGN KEY (id_arbitro) REFERENCES Staff (id_staff),
        FOREIGN KEY (id_torneo) REFERENCES Torneo (id_torneo)
    );

-- Tabla Partido
CREATE TABLE Partido (
      id_partido INT NOT NULL PRIMARY KEY,
      ubicacion VARCHAR(150) NOT NULL,
      resultado VARCHAR(20),
      id_arbitro INT NOT NULL,
      id_torneo INT NOT NULL,
      id_ganador INT NULL,
        -- Relación compuesta id_arbitro + id_torneo: Se referencia la tabla Staff_Arbitra_Torneo porque un árbitro solo puede arbitrar un partido si está asignado previamente a ese torneo.
      FOREIGN KEY (id_arbitro, id_torneo) REFERENCES Staff_Arbitra_Torneo(id_arbitro, id_torneo),
      FOREIGN KEY (id_ganador) REFERENCES Equipo(id_equipo)
    );

-- Tabla MiembroUGR_Forma_Equipo
CREATE TABLE MiembroUGR_Forma_Equipo (
      id_DNI CHAR(9) NOT NULL,
      id_equipo INT NOT NULL,
      PRIMARY KEY (id_DNI, id_equipo),
      FOREIGN KEY (id_DNI) REFERENCES Miembro_UGR(id_DNI),
      FOREIGN KEY (id_equipo) REFERENCES Equipo(id_equipo)
    );

-- Tabla Equipo_Participa_Partido
CREATE TABLE Equipo_Participa_Partido (
      id_equipo INT NOT NULL,
      id_partido INT NOT NULL,
      PRIMARY KEY (id_equipo, id_partido),
      FOREIGN KEY (id_equipo) REFERENCES Equipo(id_equipo),
      FOREIGN KEY (id_partido) REFERENCES Partido(id_partido)
    );

-- Tabla Profesor_Imparte_Facultad
CREATE TABLE Profesor_Imparte_Facultad (
      id_profesor INT NOT NULL,
      id_facultad INT NOT NULL,
      PRIMARY KEY (id_profesor, id_facultad),
      FOREIGN KEY (id_profesor) REFERENCES Profesor(id_profesor),
      FOREIGN KEY (id_facultad) REFERENCES Facultad(id_facultad)
    );

-- INSERCIÓN DE DATOS DE PRUEBA

-- Miembro_UGR
INSERT INTO Miembro_UGR VALUES
-- Estudiantes
('12345678A','2000-04-12','Granada','Granada','España'),   
('87654321B','1999-11-03','Jaén','Jaén','España'),         
('11223344C','2001-02-20','Málaga','Málaga','España'),     
('44332211D','1998-07-15','Sevilla','Sevilla','España'),    
('55667788E','2002-09-09','Córdoba','Córdoba','España'),    
-- Profesores
('99112233F','1975-03-10','Granada','Granada','España'),    
('77223344G','1980-12-22','Murcia','Murcia','España'),      
('33445566K','1982-05-24','Madrid','Madrid','España'),      
-- Staff
('66114422H','1985-06-18','Almería','Almería','España'),    
('55112233J','1990-01-05','Granada','Granada','España'),    
('77889911L','1995-08-10','Granada','Granada','España');

-- Centros
INSERT INTO Centro VALUES
(1, 'Facultad de Ciencias Políticas', 1995, 'Calle Rector López Argüeta 2, Granada'),
(2, 'Facultad de Ciencias', 1996, 'Avenida de Fuente Nueva 4, Granada'),
(3, 'Facultad de Derecho', 2000, 'Plaza de la Universidad 1, Granada'),
(4, 'Facultad de Informática', 2002, 'Avenida Universidad 2, Granada'),
(5, 'Facultad de Bellas Artes', 2001, 'Periodista Eugenio Selles 1, Granada'),
(6, 'Colegio Mayor Cisneros', 1985, 'Calle Rector Marín Ocete 12, Granada'),
(7, 'Colegio Mayor Santa María', 1990, 'Calle Santa Paula 5, Granada'),
(8, 'Colegio Mayor AlSajara', 1998, 'Avenida de Andalucía 23, Granada');

-- Facultad
INSERT INTO Facultad VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

-- Colegio Mayor
INSERT INTO Colegio_Mayor VALUES
(1,6),
(2,7),
(3,8);

-- Estudiantes
INSERT INTO Estudiante VALUES
('TUI001','Ana García','12345678A',5,3),  
('TUI002','Luis Pérez','87654321B',1,1), 
('TUI003','Marta López','11223344C',3,NULL),  
('TUI004','Javier Sánchez','44332211D',2,2),  
('TUI005','Sara Fernández','55667788E',4,NULL);

-- Profesores
INSERT INTO Profesor VALUES
(1,'Indefinido',2500.50,'Derecho Penal','99112233F'),
(2,'Temporal',2200.00,'Matemáticas Aplicadas','77223344G'),
(3,'Indefinido',2400.00,'Ingeniería del Software','33445566K'); 

-- Staff
INSERT INTO Staff VALUES
(1,'Tiempo completo',1500.00,'66114422H'),
(2,'Parcial',1100.00,'55112233J'),
(3,'Tiempo completo',1300.00,'77889911L');

-- Deportes
INSERT INTO Deporte VALUES
(1,'Fútbol',11,11),
(2,'Baloncesto',5,5),
(3,'Atletismo',1,8);

-- Torneos (sin ganador todavía)
INSERT INTO Torneo VALUES
(1,2023,8,2,NULL,1),
(2,2023,6,2,NULL,2),
(3,2023,8,1,NULL,3);

-- Equipos
INSERT INTO Equipo VALUES
(1,'Los Leones',2023,1,2,'TUI002'),
(2,'Los Tigres',2023,2,1,'TUI003'),
(3,'Los Mejores',2023,3,3,'TUI004'),
(4,'Escorpiones',2023,4,1,'TUI005'),
(5,'Los Titanes del Campus',2023,5,2,'TUI001'),
(6,'Rayo Estudiantil',2023,2,3,'TUI004');

-- Actualizar ganador en Torneo
UPDATE Torneo SET ganador=1 WHERE id_torneo=1;
UPDATE Torneo SET ganador=2 WHERE id_torneo=2;
UPDATE Torneo SET ganador=3 WHERE id_torneo=3;

-- Staff_Arbitra_Torneo
INSERT INTO Staff_Arbitra_Torneo VALUES
(1,1),
(2,2),
(3,3);

-- Partidos
INSERT INTO Partido VALUES
(1, 'Pabellón A', '2-1', 1, 1, 2),  
(2, 'Pista Central', '3-3', 2, 2, NULL),  
(3, 'Estadio UGR', '1-4', 3, 3, 6);  

-- MiembroUGR_Forma_Equipo
INSERT INTO MiembroUGR_Forma_Equipo VALUES
('12345678A',5),
('87654321B',2),
('11223344C',3),
('44332211D',4),
('55667788E',1),
('99112233F',1),
('77223344G',2),
('33445566K',3),
('66114422H',1),
('55112233J',4),
('77889911L',6);

-- Equipo_Participa_Partido
INSERT INTO Equipo_Participa_Partido VALUES
-- Partido 1 
(2,1),  
(4,1),  

-- Partido 2
(1,2),  
(5,2),  

-- Partido 3 
(3,3),  
(6,3);  

-- Profesor_Imparte_Facultad
INSERT INTO Profesor_Imparte_Facultad VALUES
(1,3),
(2,2),
(3,4);

SELECT p.id_partido, p.ubicacion, p.resultado, t.id_torneo, t.anio
FROM Partido p
JOIN Torneo t ON p.id_torneo = t.id_torneo;