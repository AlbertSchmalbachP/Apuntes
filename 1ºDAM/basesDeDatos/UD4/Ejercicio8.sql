DROP DATABASE IF EXISTS andalucia_db;

CREATE DATABASE IF NOT EXISTS andalucia_db CHARACTER
SET
    utf8mb4 COLLATE utf8mb4_unicode_ci;

USE andalucia_db;

-- Crear la tabla personas con estructura adecuada
CREATE TABLE personas (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    sexo ENUM ('M', 'H') NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    municipio VARCHAR(150) NOT NULL,
    nivel_estudios VARCHAR(50),
    situacion_laboral VARCHAR(50),
    ingresos_anuales INT,
    estado_civil VARCHAR(20),
    num_hijos INT,
    nivel_socioeconomico VARCHAR(20),
    ocupacion VARCHAR(50)
);

SET FOREIGN_KEY_CHECKS=0;
INSERT INTO personas VALUES
(1091,'Margarita','Romero','M','1978-06-10','Cádiz','Jerez','Primarios','Desempleada',7200,'Divorciada',1,'Bajo','Limpieza'),
(1092,'Crisostomo','Rosales','H','1950-02-15','Almería','Roquetas','Secundarios','Jubilado',14500,'Casado',2,'Medio','Ex-agricultor'),
(1093,'Natividad','Rossi','M','1959-08-23','Almería','Roquetas','Universitarios','Profesora',22000,'Casada',1,'Medio','Docente'),
(1094,'Demóstenes','Roza','H','1948-04-07','Huelva','Huelva','Primarios','Jubilado',8200,'Viudo',3,'Bajo','Obrero'),
(1095,'Octavia','Rubio','M','1952-10-14','Huelva','Huelva','Primarios','Pensionista',5400,'Viuda',2,'Bajo','Costurera'),
(1096,'Donaciano','Rueda','H','1982-07-29','Sevilla','Dos Hermanas','Secundarios','Autónomo',18500,'Casado',1,'Medio','Fontanero'),
(1097,'Perpetua','Ruelas','M','1981-01-06','Sevilla','Dos Hermanas','Secundarios','Empleada',14800,'Casada',1,'Medio','Administrativa'),
(1098,'Doroteo','Ruiz','H','1984-11-18','Málaga','Marbella','Universitarios','Jubilado',21000,'Casado',0,'Alto','Arquitecto'),
(1099,'Prudencia','Salas','M','1973-05-25','Málaga','Marbella','Universitarios','Autónoma',19500,'Casada',0,'Alto','Gestora'),
(1100,'Egidio','Salazar','H','1970-03-11','Cádiz','Cádiz','Primarios','Jubilado',9800,'Casado',3,'Bajo','Marinero'),
(1101,'Quiteria','Salcedo','M','1961-09-19','Cádiz','Cádiz','Primarios','Empleada',12600,'Casada',3,'Medio','Cocinera'),
(1102,'Eligio','Salinas','H','1948-07-02','Granada','Motril','Secundarios','Jubilado',11200,'Casado',2,'Medio','Transportista'),
(1103,'Rafaela','Saltara','M','1952-01-08','Granada','Motril','Sin estudios','Pensionista',4600,'Viuda',4,'Bajo','—'),
(1104,'Epifanio','Samaniego','H','1960-11-14','Jaén','Úbeda','Primarios','Desempleado',0,'Casado',3,'Bajo','Albañil'),
(1105,'Sabina','Sampedro','M','1990-06-22','Jaén','Úbeda','Secundarios','Empleada',13800,'Casada',2,'Medio','Dependienta'),
(1106,'Estanislao','Sánchez','H','1981-09-03','Córdoba','Lucena','Universitarios','Funcionario',24500,'Casado',1,'Alto','Inspector'),
(1107,'Tecla','Sandoval','M','1976-03-11','Córdoba','Lucena','Universitarios','Profesora',23000,'Casada',1,'Alto','Docente'),
(1108,'Eusebio','Santamaría','H','1955-12-27','Sevilla','Alcalá','Secundarios','Jubilado',13200,'Casado',2,'Medio','Mecánico'),
(1109,'Ursulina','Santana','M','1969-04-05','Sevilla','Alcalá','Primarios','Empleada',10400,'Casada',2,'Bajo','Limpieza'),
(1110,'José','Sarmiento','H','1950-08-19','Málaga','Fuengirola','Universitarios','Jubilado',22500,'Divorciado',1,'Alto','Ingeniero'),
(1111,'Valeriana','Satauste','M','1952-02-26','Málaga','Fuengirola','Universitarios','Pensionista',15800,'Divorciada',1,'Medio','Abogada'),
(1112,'Evaristo','Saucedo','H','1981-06-04','Huelva','Lepe','Primarios','Autónomo',16200,'Casado',2,'Medio','Pescador'),
(1113,'Walburga','Saudo','M','1979-12-12','Huelva','Lepe','Secundarios','Empleada',13400,'Casada',2,'Medio','Auxiliar'),
(1114,'Fabiano','Sauz','H','1987-04-18','Almería','El Ejido','Secundarios','Agricultor',17800,'Casado',3,'Medio','Agricultor'),
(1115,'Xenia','Sayas','M','1956-09-26','Almería','El Ejido','Secundarios','Autónoma',16400,'Casada',2,'Medio','Comerciante'),
(1116,'Paco','Saynos','H','1950-07-08','Cádiz','San Fernando','Primarios','Jubilado',9900,'Casado',2,'Bajo','Militar'),
(1117,'Yanira','Saza','M','1972-01-15','Cádiz','San Fernando','Universitarios','Funcionaria',23800,'Casada',1,'Alto','Gestión pública'),
(1118,'Fulgencio','Scheid','H','1948-10-29','Sevilla','Coria','Universitarios','Jubilado',20500,'Viudo',2,'Alto','Economista'),
(1119,'Zenaida','Seco','M','1955-03-07','Sevilla','Coria','Primarios','Pensionista',5200,'Viuda',3,'Bajo','—'),
(1120,'Gerasimo','Secreto','H','1990-08-13','Sevilla','Sevilla','Universitarios','Directivo',42000,'Casado',0,'Alto','Gerente'),
(1121,'Abigaíl','Segovia','M','2000-04-21','Sevilla','Sevilla','Universitarios','Consultora',31500,'Soltera',0,'Alto','Consultoría'),
(1122,'Gildardo','Seis','H','1994-01-05','Málaga','Málaga','Secundarios','Autónomo',18800,'Casado',1,'Medio','Reparaciones'),
(1123,'Blanca','Seisdos','M','1973-07-11','Málaga','Málaga','Universitarios','Empleada',21200,'Casada',1,'Alto','RRHH'),
(1124,'Gislerio','Selma','H','1950-11-17','Córdoba','Córdoba','Secundarios','Jubilado',11800,'Casado',2,'Medio','Carpintero'),
(1125,'Cristina','Semence','M','1983-05-24','Córdoba','Córdoba','Universitarios','Psicóloga',26500,'Divorciada',1,'Alto','Sanidad'),
(1126,'Godofredo','Semeno','H','1948-02-08','Granada','Granada','Primarios','Jubilado',8700,'Casado',4,'Bajo','Peón'),
(1127,'Dionisia','Sencillo','M','1941-08-16','Granada','Granada','Primarios','Pensionista',4800,'Viuda',4,'Bajo','—'),
(1128,'Gómez','Senén','H','1977-04-24','Jaén','Linares','Secundarios','Autónomo',19200,'Casado',2,'Medio','Taller'),
(1129,'Emilia','Senís','M','1980-10-02','Jaén','Linares','Universitarios','Enfermera',26800,'Casada',2,'Alto','Sanidad'),
(1130,'Graciano','Seno','H','1952-09-11','Cádiz','Jerez','Secundarios','Jubilado',10400,'Casado',1,'Medio','Bodega'),
(1131,'Fabiana','Senra','M','1986-02-19','Cádiz','Jerez','Secundarios','Autónoma',17600,'Casada',1,'Medio','Estética'),
(1132,'Graciliano','Senta','H','1970-06-27','Almería','Adra','Primarios','Jubilado',8200,'Casado',1,'Bajo','Pesca'),
(1133,'Gabriela','Sentana','M','1987-12-05','Almería','Adra','Universitarios','Gestora',24800,'Divorciada',1,'Alto','Administración'),
(1134,'Jaime','Velázquez','M','1979-03-15','Granada','Armilla','Universitarios','Desempleado',0,'Casado',0,'Medio','—');

SET FOREIGN_KEY_CHECKS=1;

-- Ejercicios

--1. Muestra la media de salario agrupada por ocupación
select round(avg(ingresos_anuales), 2) as media_salario, ocupacion from personas group by ocupacion;

--2. Muestra la media de salarios en cada provincia
select round(avg(ingresos_anuales), 2) as media_salario, provincia from personas group by provincia; -- round() es para que los ingresos (€) no pasen de las centenas (céntimos)

--3. Muestra la media de edad de cada nivel socioeconómico
select round(avg(datediff(now(), fecha_nacimiento) / 365), 1) as edad, nivel_socioeconomico from personas group by nivel_socioeconomico;

--4. Dime la edad de las personas de menos de 60 años ordenadas por situación laboral.
select nombre, apellido, (datediff(now(), fecha_nacimiento) / 365) as edad, situacion_laboral from personas where (datediff(now(), fecha_nacimiento) / 365) < 60 order by situacion_laboral;

--5. Muestra el nombre de la persona parada de más edad.
select nombre from personas where situacion_laboral = "Desempleado" order by (datediff(now(), fecha_nacimiento) / 365) desc limit 1;

--6. Dime la moda de Edad de cada municipio.
select municipio, floor(datediff(now(), fecha_nacimiento) / 365) as edad, count(*) as Frecuencia from personas group by municipio, round((datediff(now(), fecha_nacimiento) / 365), 2) order by count(*) desc;
-- NO

--7. Dime la provincia con la máxima edad media.
select provincia, avg(datediff(now(), fecha_nacimiento) / 365) as edad_media from personas group by provincia order by avg(datediff(now(), fecha_nacimiento) / 365) desc limit 1;

--8. Dime la media de hijos de personas con menos de 30 años.
select avg(num_hijos) from personas where (datediff(now(), fecha_nacimiento) / 365) < 30;

--9. Muestra el valor de numero de hijos que más se repite entre las mujeres. (aka moda)
select num_hijos, count(*) as Frecuencia from personas where sexo = "M" group by num_hijos order by count(*) desc limit 1;

--10. Dime la media de edad de las mujeres sin hijos de Sevilla provincia
select avg(datediff(now(), fecha_nacimiento) / 365) as media_edad from personas where sexo = "M" and num_hijos = 0;

--11. Dime la media de las modas del campo edad.


--12. Dime la provincia con menor edad media de las personas paradas.
select provincia, avg(datediff(now(), fecha_nacimiento) / 365) as edad_media from personas where ocupacion = "Desempleado" group by provincia order by avg(datediff(now(), fecha_nacimiento) / 365) asc limit 1;

--13. Órdename los municipios por numero total de hijos en cada uno.
select municipio, sum(num_hijos) as hijos_totales from personas group by municipio order by sum(num_hijos) desc;

--14. ordena las provincias por mayor número medio de hijos por mujer (tasa de natalidad)
select municipio, round(avg(num_hijos) / count(nombre), 2) as tasa_de_natalidad from personas where sexo = "M" group by municipio order by avg(num_hijos) desc;

--15. Dime los municipios que no superan la tasa de reemplazo (más de 2 hijos por mujer) pero tienen un salario medio mayor a 3000
select municipio, round(avg(num_hijos) / count(nombre), 2) as tasa_de_natalidad from personas where sexo = "M" group by municipio having avg(num_hijos) / count(nombre) < 2 and avg(ingresos_anuales) > 3000;

--16. Dime la provincia con la moda de edad más alta.
