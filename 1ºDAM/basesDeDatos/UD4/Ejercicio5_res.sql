-- Crear la base de datos
DROP DATABASE IF EXISTS Gobierno;
CREATE DATABASE Gobierno;
USE Gobierno;

-- Tabla 1: Ministerio
CREATE TABLE Ministerio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    presupuesto DECIMAL(15, 2) NOT NULL,
    fecha_creacion DATE NOT NULL
);

-- Tabla 2: Ciudadano
CREATE TABLE Ciudadano (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    ciudad VARCHAR(50),
    ocupacion VARCHAR(50),
    ingresos_anuales DECIMAL(10, 2)
);

-- Tabla 3: Actividad
CREATE TABLE Actividad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    id_ministerio INT,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    presupuesto_asignado DECIMAL(15, 2),
    FOREIGN KEY (id_ministerio) REFERENCES Ministerio(id)
);

-- Insertar datos en Ministerio
INSERT INTO Ministerio (nombre, presupuesto, fecha_creacion)
VALUES
('           Ministerio de Educación', 150000000.00, '1990-01-15'),
('Ministerio de Salud', 250000000.00, '1985-06-30'),
('           Ministerio de Transporte', 120000000.00, '2000-03-12');

-- Insertar datos en Ciudadano
INSERT INTO Ciudadano (nombre, apellido, fecha_nacimiento, ciudad, ocupacion, ingresos_anuales)
VALUES
('Juan', 'Pérez', '1980-02-14', 'Madrid', 'Profesor', 35000.00),
('Laura', 'Gómez', '1992-07-21', 'Barcelona', 'Médico', 45000.00),
('Carlos', 'Sánchez', '1975-09-10', 'Sevilla', 'Ingeniero', 60000.00),
('Ana', 'Fernández', '1985-03-25', 'Bilbao', 'Abogada', 55000.00),
('Mario', 'López', '1990-05-05', 'Valencia', 'Desempleado', 0.00);

-- Insertar datos en Actividad
INSERT INTO Actividad (descripcion, id_ministerio, fecha_inicio, fecha_fin, presupuesto_asignado)
VALUES
('Construcción de hospitales', 2, '2023-01-01', '2025-12-31', 50000000.00),
('Reparación de carreteras', 3, '2023-04-01', '2025-09-30', 30000000.00),
('Capacitación docente', 1, '2023-06-01', '2025-11-30', 10000000.00);

-- Ejercicios de Funciones de Texto
-- 1. Concatenar nombres y apellidos de los ciudadanos en un único campo "nombre_completo".
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo 
FROM Ciudadano;
-- 2. Obtener las primeras 3 letras de los nombres de los ciudadanos.
SELECT SUBSTRING(nombre, 1, 3)
 FROM ciudadano;
-- 3. Calcular la longitud de los nombres de los ciudadanos.
SELECT nombre, CHAR_LENGTH(nombre) as longitud 
FROM Ciudadano;
-- 4. Reemplazar la palabra "hospitales" por "clínicas" en las descripciones de actividades.
SELECT REPLACE(descripcion, 'hospitales', 'clínicas') 
FROM Actividad;
-- 5. Eliminar espacios al inicio y al final de los nombres de los ministerios.
SELECT TRIM(nombre) AS nombre_sin_espacios
FROM Ministerio;

-- Ejercicios de Funciones NuEXTRACTméricas
-- 6. Redondear el presupuesto de las actividades a millones.
SELECT ROUND(presupuesto_asignado / 1000000,2) AS REDONDEO 
FROM Actividad;
-- 7. Calcular la diferencia entre los ingresos anuales de cada ciudadano y el promedio de ingresos.
SELECT AVG(ingresos_anuales) FROM Ciudadano;

SELECT 
    nombre, 
    apellido,
    ingresos_anuales,
    (ingresos_anuales - (SELECT AVG(ingresos_anuales) FROM Ciudadano)) AS DIFERENCIA
FROM Ciudadano;
-- 8. Obtener el entero más cercano hacia abajo y hacia arriba de los presupuestos de los ministerios.
SELECT id, presupuesto, FLOOR(presupuesto), CEIL(presupuesto)
FROM Ministerio;
-- 9. Generar un número aleatorio para asignar un identificador único temporal a cada actividad.
SELECT id, descripcion, FLOOR(RAND() * 1000000) AS id_temportal_unico
FROM Actividad;
-- Ejercicios de Funciones de Fecha y Hora
-- 10. Calcular la antigüedad de cada ministerio en años.
SELECT nombre, EXTRACT(YEAR FROM NOW()) - EXTRACT(YEAR FROM fecha_creacion) as Antiguedad
FROM Ministerio;
-- Para mi esta es la mejor:
SELECT nombre, YEAR(NOW()) - YEAR(fecha_creacion) as Antiguedad
FROM Ministerio;
-- 11. Formatear las fechas de inicio y fin de las actividades en formato "DD-MM-YYYY".
SELECT descripcion, DATE_FORMAT(fecha_inicio, '%d-%m-%Y') AS fecha_inicio, DATE_FORMAT(fecha_fin, '%d-%m-%Y') as fecha_fin
FROM ACTIVIDAD;
-- 12. Calcular cuántos días faltan para que termine cada actividad.
SELECT id, DATEDIFF(fecha_fin, Now()) as dias_faltantes
FROM Actividad;
-- 13. Extraer el mes y el año de las fechas de nacimiento de los ciudadanos.
SELECT nombre, EXTRACT(MONTH FROM fecha_nacimiento) as mes, EXTRACT(YEAR FROM fecha_nacimiento) as Nacimiento
From Ciudadano;
-- Para mi la mejor es:
SELECT nombre, MONTH(fecha_nacimiento) as mes,  YEAR(fecha_nacimiento) as Nacimiento
From Ciudadano;
-- 14. Filtrar ciudadanos nacidos después del año 1990.
select nombre
FROM Ciudadano
WHERE YEAR(fecha_nacimiento) > 1990;

-- 15. Calcular el tiempo total en días que dura cada actividad gubernamental.

SELECT descripcion, DATEDIFF(fecha_fin, fecha_inicio) as duracion_dias
FROM actividad;