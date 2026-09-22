-- 1. dime el nombre y el apellido de los cinco malagueños (provincia) de más edad
select * from (select nombre, apellido, floor(datediff(now(),fecha_nacimiento)/365) as edad from personas where municipio = "Malaga" order by edad desc limit 5) a;
-- 2. dime el maximo de ingresos anuales que tiene una persona con estudios primarios
select nombre, max(ingresos_anuales) from personas where estudios = "Primarios";
-- 3. dime la edad media de las personas cuya ocupacion comience por la letra A

-- 4. dime las tres primeras letras del estado civil de las personas de Dos Hermanas

-- 5. 

-- 6. 