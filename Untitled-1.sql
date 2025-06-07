CREATE TABLE Vendedor (
    vendedor_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Propietario (
    propietario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Propiedad (
    propiedad_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50),
    direccion VARCHAR(255),
    m2_totales INT,
    m2_cubiertos INT,
    antigüedad INT,
    estado VARCHAR(50),
    habitaciones INT,
    baños INT,
    vendedor_id INT,
    propietario_id INT,
    FOREIGN KEY (vendedor_id) REFERENCES Vendedor(vendedor_id),
    FOREIGN KEY (propietario_id) REFERENCES Propietario(propietario_id)
);

-- insertar vendedor
INSERT INTO Vendedor (nombre) VALUES ('Facundo Chilotegui'), ('Ramiro Hugo');

-- insertar propietario
INSERT INTO Propietario (nombre) VALUES ('Facundo Vauloni'), ('Omar Perez');

-- insertar propiedad
INSERT INTO Propiedad (tipo, direccion, m2_totales, m2_cubiertos, antigüedad, estado, habitaciones, baños, vendedor_id, propietario_id)
VALUES 
('Casa', 'Calle x 123, Roldán', 200, 150, 10, 'Disponible', 4, 2, 1, 1),
('Departamento', 'Av. x 456, Funes', 80, 75, 5, 'Reservado', 2, 1, 2, 2);

SELECT 
    p.propiedad_id,
    p.tipo,
    p.direccion,
    p.estado,
    u.nombre AS vendedor,
    pr.nombre AS propietario
FROM 
    Propiedad p
JOIN Vendedor u ON p.vendedor_id = u.vendedor_id
JOIN Propietario pr ON p.propietario_id = pr.propietario_id;

SELECT * FROM Propiedad WHERE estado = 'Disponible';

SELECT * FROM Propiedad WHERE vendedor_id = 1; --en este ej el vendedor es Facundo Chilotegui

SELECT pr.nombre, COUNT(*) AS cantidad_propiedades
FROM Propiedad p
JOIN Propietario pr ON p.propietario_id = pr.propietario_id
GROUP BY pr.nombre;

DELETE FROM Propiedad WHERE propiedad_id = 1;


DELETE FROM Propietario WHERE propietario_id = 1;