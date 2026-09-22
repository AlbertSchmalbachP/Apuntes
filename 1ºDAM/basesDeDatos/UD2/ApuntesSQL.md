# Apuntes SQL

Ejemplos de como escribir SQL

## A tener en cuenta

### Tipos de datos

* **int: Almacena números enteros (sin decimales), positivos o negativos.**
Ejemplo: int edad = 25

* **varchar: Almacena cadenas de texto de longitud variable.**
Ejemplo: varchar(50) puede guardar hasta 50 caracteres.

* **date: Almacena fechas en formato AAAA-MM-DD.**
Ejemplo: 2025-10-28

* **time: Almacena horas en formato HH:MM:SS.**
Ejemplo: 14:35:00

* **decimal: Almacena números con decimales, útil para valores precisos (como dinero).**
Ejemplo: decimal(10,2) guarda hasta 10 dígitos, con 2 decimales.

### Enteros: bigint, int, smallint y tinyint

Normalmente usaremos int para los enteros, aunque a veces, para optimizar la tabla al máximo valor, usaremos otros tipos de int:

* **bigint**: Ocupa 8 bytes. Admite un rango desde -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807
* **int**: Ocupa 4 bytes. Admite un rango desde -2.147.483.648 a 2.147.483.647
* **smallint**: Ocupa 2 bytes. Admite un rango desde -32 768 a 32 767
* **tinyint**: Ocupa 1 byte. Admite un rango desde 0 a 255

## Ejemplos

### Crear una tabla

El siguiente ejemplo muestra como crear dos tablas. Una llamada Clientes y otra llamada Reservas.
La tabla Reservas incluye **5 columnas propias** y **una columna (llave) de la otra tabla**, clientes.

```SQL
create table Clientes (id int primary key, nombre varchar(12), direccion varchar(30), telefono varchar(9));

create table Reservas (codigo int primary key, fecha date, hora time, duracion smallint, idCliente int, foreign key (idCliente) references Clientes (id));
```