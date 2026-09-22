# Apuntes UD2

## Metadatos de un directorio

### Explicación de los metadatos

* **leer**(read; r)
* **escribir** (write; w)
* **ejecutar** (execute; x)

```bash
drwxr-x--- 2 comercialJefe comercial 4096 feb 21 12:40 Gestion
```

En este ejemplo, *comercialJefe* tiene permiso de **lectura**(read; r), **escritura** (write; w) y **ejecución** (execution; x).
Los del grupo *comercial* tienen permisos de **lectura** (read; r) y **ejecución** (execution; x), pero **NO** tienen de escritura.
Todos los usuarios que NO son ni el propietario (comercialJefe) ni miembros del grupo comercial, **no tienen permisos**. Por tanto, **no puede acceder al directorio** nadie más que los anteriormente mencionados.

Otros metadatos:

* **2** (HARD LINKS) - Este número representa **la cantidad de enlaces duros (hard links)** que apuntan al inodo de este archivo o directorio.

* **4096** (TAMAÑO) - Indica **el tamaño del directorio en bytes**. Este es el tamaño típico para un directorio en sistemas de archivos Linux.

* **feb 21 12:40** (DATE) - **Muestra la fecha y hora de la última modificación realizada** en el directorio (por ejemplo, al añadir o eliminar un archivo dentro de él).

* **Gestion** (NAME) - Este es el **nombre** del archivo o directorio en cuestión

### Cambiar los permisos

Para cambiar los permisos de un directorio, deberemos ejecutar el comando ```sudo chmod``` seguido de tres cifras del 0 al 7, que corresponderán a que permisos se concede al **propietario (1ª cifra)**, **grupo (2ª cifra)** y **otros usuarios (3ª cifra)**.
Cada permiso corresponde con un valor numérico:

* Lectura (r) = 4
* Escritura (w) = 2
* Ejecución (x) = 1

Sumar estos valores según los permisos de cada tipo de usuario (propietario, grupo y otros) permitirá obtener ese número del 0 al 7.
Por ejemplo:

* Lectura + escritura + ejecución (4 + 2 + 1 = 7)
* Lectura + escritura (4 + 2 = 6)
* Lectura + ejecución (4 + 1 = 5)

En este caso, la combinación de los anteriores ejemplos correspondería al comando ```sudo chmod 765```, y resultaría en una estructura de permisos ```drwxrw-r-x```.