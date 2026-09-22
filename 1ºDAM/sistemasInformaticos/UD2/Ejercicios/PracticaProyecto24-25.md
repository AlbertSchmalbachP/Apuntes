# Implementación de la Infraestructura TI para la Empresa TechCorp

## Tarea inicial

1. Creación de usuarios y directorios:

* a. Crear 5 usuarios (usuario1, usuario2, usuario3, usuario4, usuario5) y sus respectivos directorios personales en /home/.
* b. Crear los siguientes directorios compartidos dentro de /home/compartido:
i. /home/compartido/documentos
ii. /home/compartido/proyectos
iii. /home/compartido/backup

2. Creación de archivos y asignación de permisos:

* a. Crear un archivo informe_general.txt dentro de /home/compartido/documentos, con permisos de lectura y escritura solo para el grupo staff.
* b. Crear un archivo plan_proyecto.txt en /home/compartido/proyectos, permitiendo escritura solo a los usuarios usuario1 y usuario2, y lectura para el resto.
* c. En el directorio personal de cada usuario (/home/usuarioX), crear un archivo notas_personales.txt con permisos de lectura y escritura solo para el propietario.

3. Automatización:

* a. Crear un script en Bash que realice la creación de los usuarios, la estructura de directorios y archivos, y asigne los permisos correspondientes.

## Comandos utilizados

### Tarea Inicial

```bash
<--- Ejercicio 1 --->
<- a ->
sudo adduser usuario1
sudo adduser usuario2
sudo adduser usuario3
sudo adduser usuario4
sudo adduser usuario5

<- b ->
sudo mkdir /home/compartido
sudo mkdir /home/compartido/documentos
sudo mkdir /home/compartido/proyectos
sudo mkdir /home/compartido/backup

<--- Ejercicio 2 --->
<- a ->
sudo touch /home/compartido/documentos/informe_general.txt
sudo chmod 060 /home/compartido/documentos/informe_general.txt
sudo chown usuario1:staff /home/compartido/documentos/informe_general.txt

<- b ->
sudo touch /home/compartido/proyectos/plan_proyecto.txt
sudo groupadd grupopaleto
sudo usermod -aG grupopaleto usuario1
sudo usermod -aG grupopaleto usuario2
sudo chown usuario1:grupopaleto /home/compartido/proyectos/plan_proyecto.txt
sudo chmod 224 /home/compartido/proyectos/plan_proyecto.txt

<- c ->
sudo touch /home/usuario1/notas_personales.txt
sudo chmod 600 /home/{usuario1, usuario2, usuario3, usuario4, usuario5}/notas_personales.txt

<--- Ejercicio 3 --->
#!/bin/bash

```

### Primer incremento

```bash
<--- Ejercicio 1 --->
sudo groupadd admin
sudo groupadd colaboradores
sudo usermod -aG admin usuario1
sudo usermod -aG admin usuario2
sudo usermod -aG colaboradores usuario3
sudo usermod -aG colaboradores usuario4
sudo usermod -aG colaboradores usuario5

<--- Ejercicio 2 --->
<- a ->
sudo chown staff:admin /home/compartido/documentos/informe_general.txt
sudo chmod 400 /home/compartido/documentos/informe_general.txt

<- b ->
sudo chown admin:colaboradores /home/compartido/proyectos/plan_proyecto.txt
sudo chmod 420 /home/compartido/proyectos/plan_proyecto.txt

<--- Ejercicio 3 --->
```