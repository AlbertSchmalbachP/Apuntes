# PT12 - Gestión de usuarios UNIX/Linux


***

## Hoteles Comiló

La cadena Hoteles Comiló ha solicitado tu ayuda para realizar una serie de tareas relacionadas con la gestión de usuarios y permisos en un entorno Linux.

### 1. Crea los siguientes grupos: 

- **chef**
- **pinche**

```bash
sudo addgroup chef
sudo addgroup pinche

```

### 2. Crea los siguientes usuarios:

- **pinchePrincipal**: Su grupo principal es *pinche*. Tendrá un directorio personal `/home/pinche`. La shell por defecto será *bash* y su contraseña *134679*.  
- **chefJefe**: Su grupo principal es *chef* y su grupo secundario es *pinche*. Tendrá un directorio personal `/home/chefJefe`. La shell por defecto sera *bash* y su contraseña *1470*.   
- **chef1**: Su grupo principal es *chef*. Tendrá un directorio personal `/home/chef1`. La shell por defecto sera *bash*  y su contraseña *qwerty*. 

```bash
<--- Creo los usuarios --->
sudo adduser --allow-bad-names pinchePrincipal
sudo adduser --allow-bad-names chefJefe
sudo adduser --allow-bad-names chef1

<--- Añado los usuarios a los grupos asignados (-g primarios; -aG secundarios) --->
sudo usermod -g pinche pinchePrincipal
sudo usermod -g chef chef1
sudo usermod -g chef chefJefe
sudo usermod -aG pinche chefJefe

<--- Pongo a bash como la shell por defecto (paso innecesario con bash, ya que se pone de forma predeterminada) --->
sudo usermod -s /bin/bash chefJefe
sudo usermod -s /bin/bash chef1
sudo usermod -s /bin/bash pinchePrincipal

<--- Les añado un directorio personal --->
sudo usermod -d /home/pinche -m pinchePrincipal
sudo usermod -d /home/chefJefe -m chefJefe
sudo usermod -d /home/chef1 -m chef1
```

### 3. Dentro del directorio `/opt` crea la siguiente estructura de directorios:  

```bash
/opt$: ls -ltr  
drwxrwxrwx 5 chefJefe chef 4096 feb 21 12:40 HotelesComilo

/opt$: cd HotelesComilo
/opt/HotelesComilos$: ls -ltr  

drwxrwxr-- 2 chefJefe pinche    4096 feb 21 12:39 recetas
drwxrwxr-x 2 chefJefe chef 4096 feb 21 12:39 pinches
drwxr-x--- 2 chefJefe chef 4096 feb 21 12:40 gestion
```

```bash
<--- Creo la estructura de los archivos --->
sudo mkdir /opt/HotelesComilo
sudo mkdir /opt/HotelesComilo/{recetas,pinches,gestion}

<--- Cambio el usuario y grupo prpietario de los directorios --->
sudo chown chefJefe:chef HotelesComilo
sudo chown chefJefe:pinche recetas
sudo chown chefJefe:chef pinches
sudo chown chefJefe:chef gestion

<--- Cambio los permisos de los directorios (guía para los permisos en los apuntes) --->
sudo chmod 777 /opt/HotelesComilo
sudo chmod 774 /opt/HotelesComilo/recetas
sudo chmod 775 /opt/HotelesComilo/pinches
sudo chmod 750 /opt/HotelesComilo/gestion
```

### 4. Preguntas:

1. ¿Puede el usuario *chefJefe* escribir en el directorio *recetas*? ¿Por qué? 

```txt
Sí, ya que el usuario chefJefe es el propiertario del directorio y tiene todos los permisos.
```

2. El *chef1* tiene que entrar en el directorio *recetas* para consultar las recetas disponibles. ¿Cómo modificarías el directorio *recetas* para que los *pinches* puedan seguir accediendo con todos los permisos? 

```txt
Pondría:
sudo chmod 777 /opt/HotelesComilo/recetas
```

3. ¿Puede el usuario *pinchePrincipal* subir su ficha personal (*ficha_personal.pdf*) al directorio *pinches*?

```txt
No, ya que no tiene permisos de escritura.
```