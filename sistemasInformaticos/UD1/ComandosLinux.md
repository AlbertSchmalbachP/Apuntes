

# COMANDOS DE LA TERMINAL DE LINUX

## 🗂️ Gestión de Archivos y Directorios

* **ls** - Muestra las carpetas o archivos por debajo de la posición actual  
---> **-R**: *también tiene en cuenta los subdirectorios*  
---> **-l**: *muestra información más completa*  

* **cd** - Permite moverse entre carpetas  

* **pwd** - Imprime la ruta en la que se encuentra el usuario  

* **mkdir** - Crea un directorio (carpeta)  

* **touch** - Crea un archivo  

* **cp** - Copia un archivo/carpeta  
---> **-R**: *en el caso de una carpeta, también copia los subdirectorios*  

* **mv** - Permite mover un archivo (mv [origen] [destino]) (por defecto mueve recursivamente)  
También renombra archivos:  
---> **mv [nombreAntiguo.txt] [nombreNuevo.txt]**

* **rm** - Elimina archivos  
----> **-r**: *para que lo haga también con el directorio*  

* **rmdir** - Elimina **directorios vacíos**

## 📄 Visualización y Edición de Archivos

* **cat** - Muestra el contenido del archivo  (**less** para mostrarlo de forma interactiva)

* **nano** - Permite editar un archivo  

* **head** - Muestra las primeras líneas de un archivo (por defecto 10)  
---> **-n**: *muestra otro número diferente de líneas, en vez de 10*  

* **tail** - Muestra las últimas líneas de un archivo (por defecto 10)  
---> **-n**: *muestra otro número diferente de líneas, en vez de 10*  

## 🔍 Búsqueda y Conteo

* **grep** - Busca un archivo  

* **find** - Busca y lista archivos y directorios según parámetros  
---> **type**: Busca un tipo específico de archivo (`-d` directorio, `-f` archivo)  
---> **name**: Busca por nombre (se pone entre comillas)  
---> **iname**: Busca por nombre sin distinción entre mayúsculas y minúsculas  
---> **mtime**: Busca por última modificación (**+(numero)**: modificados **anteriores** al número especificado en días | **-(numero)**: modificados **posteriores** al número especificado en días)
---> **size**: Busca por tamaño  

* **wc** - Cuenta el número de líneas, palabras y caracteres  
---> **-l**: *muestra solo el número de líneas que contiene el archivo*  
---> **-w**: *muestra solo el número de palabras que contiene el archivo*  
---> **-m**: *muestra solo el número de caracteres que contiene el archivo*  

## ⚙️ Permisos y Ejecución

* **chmod** - Concede permisos a un programa

* **chown** - Cambia el propietario de un archivo (usuarioPropietario:grupoPropietario) 

* **top** - Muestra los procesos más relevantes de forma interactiva (por defecto ordenados por uso de CPU)

* **sudo /etc/crontab** - Permite crear procesos programables que se ejecuten cada cierto tiempo en segundo plano

## 🖥️ Procesos y automatización

* **top** - Muestra los procesos más relevantes de forma interactiva (Por defecto ordenados por uso de CPU)

* **sudo /etc/crontab** - Permite crear procesos programables que se ejecutan automáticamente cada cierto tiempo en segundo plano
