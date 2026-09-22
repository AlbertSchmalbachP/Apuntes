# Ejercicio tamaño cabeceras

**1- Un sistema tiene una jerarquía de protocolos de n capas. Las aplicaciones generan mensajes de M bytes de longitud. En cada capa se añade una cabecera de h bytes. ¿Qué fracción del ancho de banda de la red se llena con información de la capa de aplicación? Aplique el resultado a una conexión a 400 Kbps con tamaño de datos de 1000 Bytes y 7 capas, cada una de las cuales añade 64 Bytes de cabecera.**

n capas
mensajes M bytes
cabezera h bytes (por cada capa)

La fracción de ancho de banda que nos piden es: datos útiles / datos totales transmitidos

Por tanto -> h*n+M = datos totales y M = datos utiles
fracción del ancho de banda = M / (h*n+M)

Sustituyendo los valores -> 1000 / (7*64+1000) = 69.06% = 69%
Ahora, de esos 400kbps calculamos el tamaño de los datos útiles de aplicación 400*0.69 = **276kbps**

**2- Queremos enviar un archivo de 2000 bytes usando paquetes de 1000 bytes por un enlace de 120 Mbps entre dos torres situadas a 15 Km de distancia. Teniendo en cuenta que las cabeceras ocupan 50 bytes también por tanto los paquetes de confirmación, ¿Cuánto tiempo tardaremos en enviar el primer paquete? ¿Cúanto tiempo tardaremos (desde que comienza el primer envío, si no hay errores) en recibir la confirmación del correcto envío de todos los paquetes?**

archivo completo: 2000 bytes -> paquetes 1000 bytes
enlace 120Mbps (megabits por seg) = 120 000 000 bits por seg (*10^6) = 15 000 000 bytes por segundo
cabezeras = 50 bytes
primer paquete = 1000+50 = 1050 bytes -> 1050 / 15 000 000 = 0.00007 segundos = 0.07 ms
primer paquete de confirmación = 50 bytes -> 50 / 15 000 000 = 0.000003 segundos = 0.003 ms
segundo paquete = 1000+50  1050 bytes -> 1050 / 15 000 000 = 0.00007 segundos = 0.07 ms
primer paquete de confirmación = 50 bytes -> 50 / 15 000 000 = 0.000003 segundos = 0.003 ms
total -> 0.07 + 0.07 + 0.003 + 0.003 = 0.146 ms

d = v * t -> tiempo = distancia / velocidad = 15 000 m / 2*10^8 = 0.000075 s = 0.075 ms (tiempo de propagación)

Por tanto, el tiempo total será -> el tiempo de transmisión del primer paquete + el tiempo de transmision del segundo + el tiempo de propagacion del segundo paquete + el tiempo de transmisión de la confirmación del segundo paquete + el tiempo de propagación de la confirmación del segundo paquete (ya que los paquetes se enevian uno detras del otro, sin esperar uno a recibir la confirmacion de que el otro ha llegado) = 0.07 ms + 0.07 ms + 0.075 ms + 0.075 ms + 0.003 ms + 0.075 ms = **0.293 ms**

**3- Tengo una red 192.170.0.0 /24 y quiero hacer 3 subredes lo más grandes posible. (minima mascara de red que puedas hacer). Dentro de cada subred que hayas creado, asigna una ip a 3 dispositivos diferentes (9 en total) en una de las 3 subredes que has creado, la que tú quieras, define 2 subredes más.**

La red 192.170.0.0 tiene 32 bits y la máscara original es /24, lo que significa que se reservan 24 bits para la red y 8 bits para los hosts. Con 8 bits para hosts, la red tiene 2^8 = 256 direcciones totales (254 utilizables para hosts).

Para crear 3 subredes lo más grandes posibles, necesitamos reservar solo los bits necesarios para numerar las subredes.
Tomando 2 bits para las subredes obtenemos 2^2 = 4 subredes posibles. Esto da la máscara mínima de /26, dejando 6 bits para hosts (2^6 = 64 direcciones por subred, 62 utilizables), que es lo más grande posible para 3 subredes.
Esto nos da:
Subred 1: 192.170.0.0 /26 → hosts: 192.170.0.1 → 192.170.0.62
Subred 2: 192.170.0.64 /26 → hosts: 192.170.0.65 → 192.170.0.126
Subred 3: 192.170.0.128 /26 → hosts: 192.170.0.129 → 192.170.0.190
Sobran: 192.170.0.192 /26 → hosts: 192.170.0.193 → 192.170.0.254
(recuerda que se dejan 2 para red y broadcast, una al principio y otra al final del rango de cada subred)


IPs subred 1: 192.170.0.0 /26
Primer dispositivo → 192.170.0.1
Segundo dispositivo → 192.170.0.2
Tercer dispositivo → 192.170.0.3

IPs subred 2: 192.170.0.64 /26
Primer dispositivo → 192.170.0.65
Segundo dispositivo → 192.170.0.66
Tercer dispositivo → 192.170.0.67

IPs subred 3: 192.170.0.128 /26
Primer dispositivo → 192.170.0.129
Segundo dispositivo → 192.170.0.130
Tercer dispositivo → 192.170.0.131

De forma simialr a antes, asignamos tres subredes mas pequeñas (o sub-subredes), en este caso a la subred 1:
sub-subred 1: 192.170.0.0 /28
sub-subred 2: 192.170.0.16 /28
sub-subred 3: 192.170.0.32 /28
Le hemos asignado una mascara de /28 ya que solo necesitamos 4 sub-subredes posibles

**4- Queremos envíar una foto de resolución HD (1020x1080) con una profundidad de color de 32 bits. El protocolo nos permite hacer paquetes de hasta 4MB. Las cabezeras ocupan 50KB. La velocidad de transferencia es de 1Gbps y la distancia entre torres es de 80 Km. Dime el tiempo que transcurre desde que comenzamos a emitir hasta que llega la última confirmación. ¿Qué tiempo mínimo de confirmación antes de reenviar establecerías para cada paquete?**

Resolución: 1020 × 1080 píxeles
Profundidad: 32 bits → cada píxel ocupa 32 bits = 4 bytes
Tamaño imagen = 1020 x 1080 (resolución) x 32 bits (profundidad color) = 1 101 600 x 32 = 35 251 200 bits = 4 406 400 bytes
Tamaño máximo del paquete: 4 MB = 4 000 000 bytes
Cabecera por paquete: 50 KB = 50 000 bytes
Velocidad: 16 Gbps = 16 × 10⁹ bits/s = 125 000 000 bytes/s
Distancia: 80 km = 80 000 m

Por tanto, el tamaño de la imagen deberá ser dividido en 2 paquetes: Paquete 1 (4 000 000 bytes)(ya que es maximo 4MB INCLUYENDO la cabezera, lo que deja 3 950 000 bytes de datos reales) y paquete 2 (506 400 bytes)

1ER PAQUETE -> tiempo de transmisión = tamaño paquete / velocidad = 4 000 000 / 125 000 000 = 0.032 s = 32 ms | tiempo de propagación = distancia / velocidad = 80 000 m / 2*10^8 = 0.0004 s = 0.4 ms
2º PAQUETE -> tiempo de transmisión = 506 400 / 125 000 000 = 0.00405 s = 4.05 ms | tiempo de propagación = distancia / velocidad = 80 000 m / 2*10^8 = 0.0004 s = 0.4 ms

Confirmación ambos paquetes = 0.4 ms (también)
(el tiempo de transmisión del paquete de confirmación existe pero es despreciable)

Tiempo total = transmisión 1er paquete + transmisión 2º paquete + propagación 2º paquete + confirmación 2º paquete = 32 ms + 4 ms + 0.4 ms + 0.4 ms = **36.8 ms**

También sería ese el tiempo minimo a esperar antes de reenviar
