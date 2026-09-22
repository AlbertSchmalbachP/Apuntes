-- 1 Muestra la media de salario agrupada por ocupación
select avg(ingresos_anuales) from personas group by ocupacion;

-- 2 Muestra la media de salarios en cada provincia
select avg(ingresos_anuales) from personas group by provincia;
-- 3 Muestra la media de edad de cada nivel socioeconómico
select avg(datediff(now(), fecha_nacimiento)/365.25) as edad_media from personas group by ocupacion;

-- 4 Dime la edad de las personas de menos de 60 años ordenadas por situación laboral.
select floor(datediff(now(), fecha_nacimiento)/365.25) as edad from personas where floor(datediff(now(), fecha_nacimiento)/365.25) < 60 order by situacion_laboral;

-- 5 Muestra el nombre de la persona jubilada de más edad.
select max(floor(datediff(now(), fecha_nacimiento)/365.25)) from personas where ocupacion is null;

-- 6 Dime la provincia con la máxima edad media.

select provincia
from personas group by provincia 
having round(avg(datediff(now(), fecha_nacimiento)/365.25),3) = (select round(max(edad_media),3) from 
(select avg(datediff(now(), fecha_nacimiento)/365.25) as edad_media, provincia
 from personas group by provincia) m );
 
-- 7 Dime los hijos del ciudadano con id 1190
select * from personas where padre=1190 or madre = 1190;

-- 8  Muestra los nietos del ciudadano con id = 1190
select * from personas where padre in 
(select id from personas where padre=1190 or madre = 1190) -- hijos de 1190;
or madre in (select id from personas where padre=1190 or madre = 1190);

-- 9 Muestra la madre con más hijos
select madre from personas group by madre having count(*) =  
(select max(reps) from 
(select madre, count(*) as reps from personas where madre is not null group by madre) p);

-- 10 Muestra la media de hijos por hombre
select sum(reps)/(select count(id) from personas where sexo='H') p 
from (select padre, count(*) as reps from personas where padre is not null group by padre) m;

-- 11 Dime la media de hijos de personas con menos de 30 años.
select sum(reps)/(select count(id) from personas where floor(datediff(fecha_nacimiento, now())/365.25) < 30) p 
from (select padre, count(*) as reps from personas where floor(datediff(fecha_nacimiento, now())/365.25) < 30 and padre is not null group by padre) m;

-- 12 Muestra el valor de numero de hijos que más se repite entre las mujeres.
select reps from 
(select count(*) as reps_de_reps, reps from 
(select madre, count(*) as reps from personas where madre is not null group by madre) a
group by reps) n
where reps_de_reps = (select max(reps_de_reps) from (select reps, reps_de_reps from 
(select count(*) as reps_de_reps, reps from 
(select madre, count(*) as reps from personas where madre is not null group by madre) p
group by reps) m) s);

-- 13 Dime la media de edad de las mujeres sin hijos de Sevilla provincia
select avg(floor(datediff(now(), fecha_nacimiento)/365.25)) as edad_media 
from personas where provincia = "Sevilla" 
and 
id not in (select distinct madre from personas where madre is not null);

-- 14 Dime la media de las modas del campo edad.
select avg(edad) from 
(select floor(datediff(now(), fecha_nacimiento)/365.25) as edad from personas group by edad having 
count(*) = 
(select max(reps) from
(select 
count(*) as reps,
floor(datediff(now(), fecha_nacimiento)/365.25) as edad
from personas group by edad) p) )m ;

-- 15 Dime la provincia con menor edad media de las personas estudiantes.
(select floor(datediff(now(), fecha_nacimiento)/365.25) as edad
 from personas where ocupacion = "Estudiante") ;



-- 20 Dime los 5 sevillanos (municipio) de más edad ordenados por la longitud de su apellido
select * from 
    (select apellido, floor(datediff(now(),fecha_nacimiento)/365.25) as edad 
    from personas where municipio = "Sevilla" order by edad desc limit 5) m  
order by char_length(apellido);