-- Ejercicios de MySQL - Semana Santa de Granada
-- Este archivo contiene la estructura de la base de datos y los ejercicios para practicar consultas SQL.

-- Estructura de la Base de Datos

-- Tabla procesion

CREATE DATABASE semana_santa;
USE semana_santa;
CREATE TABLE procesion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dia_semana VARCHAR(20) NOT NULL,
    hora_inicio TIME NOT NULL,
    barrio VARCHAR(50) NOT NULL
);

-- Tabla hermandad
CREATE TABLE hermandad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    antiguedad INT NOT NULL,
    numero_costaleros INT NOT NULL
);

-- Tabla paso
CREATE TABLE paso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    estilo VARCHAR(50) NOT NULL,
    peso INT NOT NULL
);

-- Tabla itinerario
CREATE TABLE itinerario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_procesion INT NOT NULL,
    punto VARCHAR(100) NOT NULL,
    hora_paso TIME NOT NULL,
    FOREIGN KEY (id_procesion) REFERENCES procesion(id)
);

-- Inserciones de Datos Iniciales

-- Inserciones en la tabla procesion
INSERT INTO procesion (nombre, dia_semana, hora_inicio, barrio) VALUES
('La Esperanza', 'Lunes Santo', '18:30:00', 'Realejo'),
('El Silencio', 'Miércoles Santo', '23:00:00', 'Centro'),
('La Aurora', 'Domingo de Ramos', '17:00:00', 'Albaicín'),
('La Soledad', 'Viernes Santo', '19:30:00', 'Sacromonte');

-- Inserciones en la tabla hermandad
INSERT INTO hermandad (nombre, antiguedad, numero_costaleros) VALUES
('Hermandad del Silencio', 1578, 90),
('Hermandad de la Aurora', 1635, 120),
('Hermandad de la Esperanza', 1945, 80),
('Hermandad de la Soledad', 1500, 100);

-- Inserciones en la tabla paso
INSERT INTO paso (nombre, estilo, peso) VALUES
('Paso del Cristo del Silencio', 'Barroco', 2000),
('Paso de la Virgen de la Aurora', 'Renacentista', 1800),
('Paso de Jesús de la Esperanza', 'Gótico', 2200),
('Paso de la Virgen de la Soledad', 'Neoclásico', 1900);

-- Inserciones en la tabla itinerario
INSERT INTO itinerario (id_procesion, punto, hora_paso) VALUES
(1, 'Plaza Nueva', '19:00:00'),
(1, 'Catedral', '20:30:00'),
(2, 'Puerta Real', '23:30:00'),
(2, 'Gran Vía', '00:15:00'),
(3, 'Carrera del Darro', '17:30:00'),
(3, 'Plaza de San Nicolás', '18:15:00'),
(4, 'Paseo de los Tristes', '20:00:00'),
(4, 'Abadía del Sacromonte', '21:30:00');

-- Soluciones a los ejercicios

-- 1. Listar todos los nombres de las procesiones.
-- SELECT nombre FROM procesion;

-- 2. Mostrar los barrios donde se realizan las procesiones, sin repetir.
-- SELECT DISTINCT barrio FROM procesion;

-- 3. Obtener el nombre y la hora de inicio de todas las procesiones que comienzan después de las 18:00.
-- SELECT nombre, hora_inicio FROM procesion WHERE hora_inicio > "18:30:00";

-- 4. Seleccionar el nombre y estilo de todos los pasos.
-- SELECT nombre, estilo FROM paso;

-- 5. Mostrar el nombre de las hermandades que tienen más de 100 costaleros.
-- SELECT nombre FROM hermandad WHERE numero_costaleros > 100;

-- 6. Listar las procesiones que ocurren el Viernes Santo.
-- SELECT nombre FROM procesion WHERE dia_semana = "Viernes Santo";

-- 7. Mostrar los puntos de paso de las procesiones que pasan por 'Catedral'.
-- SELECT id_procesion, punto FROM itinerario WHERE id_procesion IN (SELECT id_procesion FROM itinerario WHERE punto = "Catedral");

-- 8. Obtener las procesiones que tienen lugar en el barrio 'Centro'.
-- SELECT nombre FROM procesion WHERE barrio = "Centro";

-- 9. Listar los estilos de pasos únicos.
-- SELECT DISTINCT estilo FROM paso; 

-- 10. Mostrar los nombres de los pasos que pesan más de 1900 kg.
-- SELECT nombre FROM paso WHERE peso > 1900;

-- 11. Listar los pasos cuyo peso esté entre 1800 y 2200 kg.
-- SELECT nombre FROM paso WHERE peso > 1900;

-- 12. Mostrar las hermandades fundadas antes del año 1600.
-- SELECT nombre FROM hermandad WHERE antiguedad < 1600;

-- 13. Seleccionar las procesiones que comienzan después de las 19:00 y están en el barrio 'Realejo'.
-- SELECT nombre FROM procesion WHERE hora_inicio > "19:00:00" AND barrio = "Realejo";

-- 14. Listar las hermandades que tienen más de 80 costaleros o fueron fundadas después de 1900.
-- SELECT nombre, antiguedad, numero_costaleros FROM hermandad WHERE numero_costaleros > 80 OR antiguedad > 1900;

-- 15. Mostrar las procesiones que no se realizan el Domingo de Ramos.
-- SELECT nombre FROM procesion WHERE dia_semana != "Domingo de Ramos";

-- 16. Mostrar todas las procesiones ordenadas por la hora de inicio en orden ascendente.
-- SELECT nombre, hora_inicio FROM procesion ORDER BY hora_inicio;

-- 17. Listar las hermandades ordenadas por antigüedad de forma descendente.
-- SELECT nombre, antiguedad FROM hermandad ORDER BY antiguedad DESC;

-- 18. Seleccionar los pasos ordenados por peso y, en caso de empate, por estilo alfabético.
-- SELECT nombre, peso, estilo FROM paso ORDER BY peso, estilo;

-- 19. Ordenar las procesiones por día de la semana (Lunes primero).
-- SELECT nombre, dia_semana FROM procesion ORDER BY FIELD(dia_semana, "Lunes_Santo", "Martes Santo", "Miércoles Santo", "Jueves Santo", "Viernes Santo", "Sábado Santo", "Domingo de Ramos");

-- 20. Mostrar los puntos de paso de las procesiones ordenados por hora de paso en orden descendente.
-- SELECT id_procesion, punto FROM itinerario ORDER BY hora_paso DESC;

-- 21. Contar cuántas procesiones hay en total.
-- SELECT COUNT(*) AS total_procesiones FROM procesion;

-- 22. Obtener el peso promedio de todos los pasos.
-- SELECT AVG(peso) AS peso_promedio_pasos FROM paso;

-- 23. Calcular el número máximo de costaleros en una hermandad.
-- SELECT MAX(numero_costaleros) AS numero_maximo_costaleros FROM hermandad;

-- 24. Obtener el número de procesiones que se realizan en el barrio 'Albaicín'.
-- SELECT count(*) AS numero_procesiones_albaicin FROM procesion WHERE barrio = "Albaicín";

-- 25. Sumar el peso de todos los pasos.
-- SELECT SUM(peso) FROM paso;

-- 26. Agrupar las procesiones por barrio y contar cuántas procesiones hay en cada uno.
-- SELECT COUNT(nombre), barrio FROM procesion GROUP BY barrio;

-- 27. Calcular el peso total de los pasos agrupados por estilo.
-- SELECT estilo, SUM(peso) FROM paso GROUP BY estilo;

-- 28. Mostrar las hermandades agrupadas por número de costaleros, filtrando aquellas con más de 100 costaleros.
-- SELECT count(nombre), numero_costaleros FROM hermandad WHERE numero_costaleros > 100 GROUP BY numero_costaleros;

-- 29. Obtener el número de procesiones que tienen puntos de paso después de las 20:00.
-- SELECT COUNT(*) FROM (SELECT COUNT(*) FROM itinerario WHERE hora_paso > "20:00:00" GROUP BY id_procesion) p;

-- 30. Agrupar las hermandades por antigüedad y contar cuántas hay en cada rango.
-- SELECT count(*) FROM hermandad GROUP BY antiguedad;

-- 31. Concatenar el nombre y barrio de cada procesión en un único campo, separados por un guion.
-- SELECT CONCAT(nombre, " - ", barrio) FROM procesion;

-- 32. Mostrar las procesiones cuyos nombres contienen más de 10 caracteres.
-- SELECT nombre FROM procesion WHERE CHAR_LENGTH(nombre) > 10;

-- 33. Seleccionar los nombres de las procesiones que contienen la palabra 'Soledad'.
-- SELECT nombre FROM procesion WHERE  nombre LIKE "%Soledad%";

-- 34. Mostrar las hermandades ordenadas por el número de costaleros en orden ascendente.
-- SELECT nombre, numero_costaleros FROM hermandad ORDER BY numero_costaleros;

-- 35. Listar los nombres de los pasos en los que la palabra 'Virgen' no aparece.
-- SELECT nombre FROM paso WHERE nombre NOT LIKE "%Virgen%";

-- 36. Calcular la diferencia entre el peso máximo y mínimo de los pasos.
-- SELECT (MAX(peso) - MIN(peso)) AS diferencia_peso FROM paso;

-- 37. Mostrar solo las procesiones cuyo nombre no empieza con 'La'.
-- SELECT * FROM procesion WHERE nombre NOT LIKE "La%";

-- 38. Formatear la hora de inicio de las procesiones en formato de 12 horas con AM/PM.
-- SELECT nombre, dia_semana, DATE_FORMAT(hora_inicio, "%h-%i-%s") AS hora_inicio , barrio FROM procesion;

-- 39. Mostrar solo la hora (sin minutos ni segundos) del paso por cada punto del itinerario.
-- SELECT id_procesion, punto, DATE_FORMAT(hora_paso, "%H") AS hora_paso FROM itinerario;

-- 40. Seleccionar las procesiones que tienen su inicio en las próximas 6 horas a partir de la fecha y hora actual.
-- 



-- EXTRAS
-- 41. Redondear el peso de los pasos a la centena más cercana.
-- SELECT nombre, estilo, CEIL(peso/100) AS peso FROM paso;

-- 42. Mostrar el peso de los pasos dividido entre 1000, con dos decimales.
-- SELECT nombre, estilo, ROUND(peso/1000,2) AS peso FROM paso;

-- 43. Generar un número aleatorio entre 1 y 100.
-- SELECT FLOOR(1 + (RAND() * 100));