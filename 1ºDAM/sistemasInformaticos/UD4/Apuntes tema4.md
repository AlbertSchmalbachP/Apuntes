# Capas TCP/IP
El modelo incluye cuatro capas:

## Capa 1 o capa de acceso al medio

En la capa de enlace los protocolos solo actúan como máximo hasta la red local a la que está conectado un host cualquiera. Esto se denomina enlace si usamos el lenguaje propio de TCP/IP. Además esta capa se sitúa en la parte más baja de dicho modelo. Como dijimos esta capa tiene en cuenta todos los hosts accesibles en la red local o dicho de otra manera, todos los hosts que se pueden alcanzar sin tener que pasar por un enrutador. Este modelo está diseñado para que el tipo de hardware usado no importe haciendo que pueda implementarse sobre cualquier tecnología de la capa de enlace. De hecho incluye también capas de los posibles enlaces virtuales que puedan haber ya sea por redes privadas virtuales y túneles de redes.

El uso que tiene la capa de enlace es permitir el paso de paquetes entre las interfaces de la capa de Internet de dos hosts diferentes en el mismo enlace. Los procesos de transmisión y recepción de paquetes en el enlace se pueden controlar en el controlador de dispositivo para la tarjeta de red, incluso en el firmware o haciendo uso de conjuntos de chips especializados.

El modelo TCP/IP incluye especificaciones para traducir los métodos de direccionamiento de red utilizados en el Protocolo de Internet a direcciones de capa de enlace, como direcciones de control de acceso al medio (o direcciones MAC).

## Capa 2 o capa de internet

El proceso de enviar datos desde la red de origen a la red de destino mediante la interconexión de redes es lo que se conoce como enrutamiento y esto es compatible con el direccionamiento e identificación del host mediante el sistema de direccionamiento IP jerárquico. La capa de internet permite una instalación de transmisión de datagramas (así es como se llama a la PDU en la capa de Internet) no confiable entre hosts ubicados en redes IP considerablemente diferentes al reenviar datagramas a un enrutador distinto (produciéndose lo que se conoce como salto) apropiado para su posterior retransmisión a su destino. La capa de Internet es responsable de enviar paquetes de datos a través de múltiples redes. De esta manera, la capa de Internet hace posible la interconexión, el funcionamiento interno de diferentes redes IP y es como Internet se establece.

La capa de Internet no distingue entre los distintos protocolos de la capa de transporte. IP transporta datos para que los protocolos de capas superiores se encarguen de tratarlos de la manera correcta, pues no entiende de otras capas.

El Protocolo de Internet es el componente principal de la capa de Internet y define dos sistemas de direccionamiento para identificar los hosts de la red y ubicarlos en la red. El sistema de direcciones original de ARPANET y su sucesor, Internet, es el Protocolo de Internet versión 4 (IPv4) la cual utiliza una dirección IP de 32 bits y, por lo tanto, es capaz de identificar aproximadamente cuatro mil millones de hosts. Esta limitación fue eliminada en 1998 por la estandarización del Protocolo de Internet versión 6 (IPv6) que usa direcciones de 128 bits. Las implementaciones de producción de IPv6 surgieron aproximadamente en 2006.

## Capa 3 o capa de transporte

En la capa de transporte se establecen canales de datos básicos utilizadas para hacer posible el intercambio de datos. Además establece la conectividad de host a host en forma de servicios de transferencia de mensajes de extremo a extremo independientes de las redes subyacentes e independientes de la estructura de los datos del usuario y la logística del intercambio de información.

La capa de transporte tiene 2 tipos de conexiones y son orientada a la conexión como es el TCP, o no orientado a la conexión como es el UDP. Los protocolos de esta capa pueden proporcionar control de errores, segmentación, control de flujo, control de congestión y direccionamiento de aplicaciones.

Con el objetivo de proporcionar canales de transmisión específicos, la capa de transporte establece el concepto de puerto de red. Esto es una construcción lógica numerada y que es asignada de forma específica para cada uno de los canales de comunicación que necesita una determinada aplicación. Para muchos tipos de servicios, estos números de puerto se han estandarizado para que las computadoras cliente puedan abordar servicios específicos de una computadora servidor sin la participación de servicios de directorio o descubrimiento de servicios.

TCP es un protocolo orientado a la conexión que aborda numerosos problemas de confiabilidad al proporcionar un flujo de bytes confiable:

1. Los datos llegan ordenados.
2. Los datos tienen la cantidad mínima de errores.
3. No llegan duplicados.
4. Se asegura que los paquetes llegan a su destino.
5. Incluye control de congestión de tráfico.

El Protocolo de datagramas de usuario (UDP) es un protocolo de datagramas no orientado a conexión. Al igual que IP, es un protocolo poco confiable. La confiabilidad se aborda mediante la detección de errores mediante un algoritmo de checksum. UDP se usa generalmente para aplicaciones como transmisión de medios (audio, video, voz sobre IP, etc.) donde la llegada a tiempo es más importante que la confiabilidad, o para aplicaciones simples de consulta / respuesta como búsquedas de DNS. El Protocolo de transporte en tiempo real (RTP) es un protocolo de datagramas que se utiliza sobre UDP y está diseñado para datos en tiempo real, como medios de transmisión.

## Capa 4 o capa de aplicación

La capa de aplicación incluye los protocolos utilizados por la mayoría de las aplicaciones para proporcionar servicios de usuario o intercambiar datos de aplicaciones a través de las conexiones de red establecidas por los protocolos de las capas inferiores. Esto puede incluir algunos servicios básicos de soporte de red, como protocolos de enrutamiento y configuración de host. Algunos ejemplos de lo que acabamos de comentar son el protocolo HTTP o Protocolo de Transferencia de Hipertexto, el protocolo FTP o Protocolo de Transferencia de Archivos, el protocolo SMTP o protocolo de Transferencia de Correo y el Protocolo DHCP o Protocolo de Configuración Dinámica de Host. Los datos codificados de acuerdo con los protocolos de la capa de aplicación se encapsulan en unidades de protocolo de la capa de transporte (como flujos TCP o datagramas UDP), que a su vez utilizan protocolos de capas inferiores para efectuar la transferencia de datos real.

La capa de aplicación en el modelo TCP/IP corresponde a una combinación de la quinta (sesión), sexta (presentación) y séptima capa (aplicación) del modelo OSI.

En la capa de aplicación, el modelo TCP/IP distingue entre protocolos de usuario y protocolos de soporte. Los protocolos de soporte brindan servicios a un sistema de infraestructura de red. Los protocolos de usuario se utilizan para aplicaciones de usuario reales. Por ejemplo, FTP es un protocolo de usuario y DNS es un protocolo de soporte.

La capa de transporte y las capas de nivel inferior no se preocupan por los detalles de los protocolos de la capa de aplicación. Los enrutadores y conmutadores proporcionan un camino que los datos tomarán para llegar de un sistema final a otro sistema final (los extremos) y normalmente no examinan el tráfico encapsulado. Sin embargo, algunas aplicaciones de cortafuegos y de limitación del ancho de banda utilizan la inspección profunda de paquetes para interpretar los datos de la aplicación.

# Tipos de Redes

## Red punto a punto
Las redes punto a punto son aquellas que responden a un tipo de arquitectura de red en las que cada canal de datos se usa para comunicar únicamente dos computadoras, en clara oposición a las redes multipunto, en las cuales cada canal de datos se puede usar para comunicarse con diversos nodos.

En una red punto a punto, los dispositivos en red actúan como socios iguales, o pares entre sí. Como pares, cada dispositivo puede tomar el rol de emisor o la función de receptor. En un momento, el dispositivo A, por ejemplo, puede hacer una petición de un mensaje / dato del dispositivo B, y este es el que le responde enviando el mensaje / dato al dispositivo A. El dispositivo A funciona como receptor, mientras que B funciona como emisor. Un momento después los dispositivos A y B pueden revertir los roles: B, como receptor, hace una solicitud a A, y A, como emisor, responde a la solicitud de B. A y B permanecen en una relación recíproca o par entre ellos.

Las redes punto a punto son relativamente fáciles de instalar y operar. A medida que las redes crecen, las relaciones punto a punto se vuelven más difíciles de coordinar y operar. Su eficiencia decrece rápidamente a medida que la cantidad de dispositivos en la red aumenta.
Los enlaces que interconectan los nodos de una red punto a punto se pueden clasificar en tres tipos según el sentido de las comunicaciones que transportan:
```
Simplex: la transacción solo se efectúa en un solo sentido.
Semi-dúplex: la transacción se realiza en ambos sentidos, pero de forma alternativa, es decir solo uno puede transmitir en un momento dado, no pudiendo transmitir los dos al mismo tiempo.
Full-Dúplex: la transacción se puede llevar a cabo en ambos sentidos simultáneamente. Cuando la velocidad de los enlaces Semi-dúplex y Dúplex es la misma en ambos sentidos, se dice que es un enlace simétrico, en caso contrario se dice que es un enlace asimétrico.
```

## Red de difusión
Características: 
```
1. En una red multipunto sólo existe una línea de comunicación, cuyo uso está compartido por todas las terminales en la red.
2. La información fluye de forma bidireccional y es discernible para todas las terminales de la red. Lo típico es que en una conexión multipunto las terminales compiten por el uso del medio (línea) de forma que el primero que lo encuentra disponible lo acapara, aunque también puede negociar su uso.
3. Los terminales no tienen que estar necesariamente próximos geográficamente.
4. Tienen un acceso común a la computadora central por medio de una línea a la que están conectados, y que por tanto soporta todo el tráfico de la información.
5. Cada terminal debe poder detectar si el mensaje que envía el host le afecta o no. Para ello, cada mensaje llevará la dirección del terminal al que va dirigido.
6. Su método de acceso al medio es el Polling: técnica por la cual la computadora central hace una pasada por todos los terminales para saber si tienen información a enviar o están disponibles para recibirla.
```

### Tipos de redes de difusión
#### Red tipo Estrella

En este caso existe un host conectado a varias terminales remotas.
#### Red tipo Bus

En las que un medio de comunicación común conectado a muchas estaciones remotas.
#### Anillo

Todas las terminales conectadas a un mismo cable. Si una falla hay problemas con todas.
#### Red de Broadcast

Aquellas redes en las que la transmisión de datos se realiza por un solo canal de comunicación, compartido entonces por todas las máquinas de la red. Cualquier paquete de datos enviado por cualquier máquina es recibido por todas las de la red.
#### Red de punto a punto

Son aquellas en las que existen muchas conexiones entre parejas individuales de máquinas. Para poder transmitir los paquetes desde una máquina a otra a veces es necesario que éstos pasen por máquinas intermedias, siendo obligado en tales casos un trazado de rutas mediante dispositivos
Red de árbol

Esta estructura se utiliza en aplicaciones de televisión por cable, sobre la cual podrían basarse las futuras estructuras de redes que alcancen los hogares. También se ha utilizado en aplicaciones de redes locales analógicas de banda ancha.
#### Red de malla

Es el tipo de conexión utilizado en las centrales telefónicas. Todas las terminales interconectadas entre sí. Involucra o se efectúa a través de redes WAN, una red malla contiene múltiples caminos, si un camino falla o está congestionado el tráfico, un paquete puede utilizar un camino diferente hacia el destino. Los routers se utilizan para interconectar las redes separadas. 

## Ejemplos
### De punto a punto
1. Conexión por Módem (Dial-up):
```
Tu módem llamaba por la línea telefónica al módem del proveedor de internet (ISP), creando un enlace temporal y exclusivo entre los dos.
```
2. Conexiones PPPoE (usado en muchas FTTH/Fibra Óptica):
```
Aunque físicamente la fibra es compartida, lógicamente se establece una sesión punto a punto cifrada entre tu router y el del proveedor, como un "túnel" privado.
```
3. Redes ATM o Frame Relay (en banca o grandes empresas):
```
Tecnologías WAN antiguas pero muy seguras que establecían circuitos virtuales permanentes (PVC) o conmutados (SVC) entre dos sucursales de una empresa.
```
4. Protocolos de Redes WAN como HDLC o PPP:
```
Son los protocolos que gobiernan la comunicación directa sobre un enlace serial, por ejemplo, entre dos routers en oficinas distintas.
```
5. Conexiones SSH o Telnet a un Servidor:
```
Cuando te conectas desde tu ordenador (cliente) a un servidor remoto, estableces una sesión punto a punto lógica para administrarlo.
```
6. Llamada Telefónica Tradicional (PSTN):
```
El circuito conmutado crea un camino físico dedicado (a nivel eléctrico) entre los dos teléfonos durante la llamada.
```
### De difusión
1. Redes Ethernet Tradicionales (con Hubs):
```
Cuando un ordenador enviaba datos a través de un hub (concentrador), este dispositivo replicaba y retransmitía los paquetes a todos los demás puertos. Solo el ordenador destino respondía.
```

2. Redes Inalámbricas Wi-Fi (en un mismo SSID):
```
El punto de acceso (router) transmite las señales por el aire. Todos los dispositivos dentro del alcance "escuchan" los paquetes, pero solo el dispositivo cuya dirección MAC coincida con la del destino procesará la información. Por eso, en redes abiertas, un "sniffer" puede capturar tráfico ajeno (aunque cifrado).
```

3. Redes de Televisión por Antena o Satélite:
```
La torre de televisión o el satélite emite una señal que es recibida simultáneamente por todas las antenas sintonizadas a esa frecuencia. No hay comunicación bidireccional en el sentido tradicional.
```
4. Radio AM/FM:
```
El ejemplo clásico de difusión unilateral. La estación emite y miles de radios reciben la misma señal al mismo tiempo.
```

### Servicios
1. Orientado a Conexión vs. No Orientado a Conexión:

Orientado a Conexión: Requiere establecer un "canal" o "circuito" dedicado antes de enviar la información. Implica tres fases: establecimiento, transferencia y liberación. La comunicación es secuencial y ordenada por ese canal.

No Orientado a Conexión: Cada unidad de información se envía independientemente, sin un camino preestablecido. Cada envío lleva la dirección de destino completa.

2. Confirmado vs. No Confirmado (o "Fiable" vs. "No Fiable"):

Confirmado (Fiable): El emisor recibe una confirmación explícita (ACK) de que el receptor obtuvo la información correctamente. Si no la recibe, reintenta.

No Confirmado (No Fiable): El emisor "dispara y olvida". No hay garantía de recepción ni mecanismo de notificación por parte del sistema.

#### Cuando se intercambia un fichero entre dos hosts se pueden seguir dos estrategias de confirmación. En la primera, el fichero se divide en paquetes que se confirman individualmente por el receptor, pero el fichero en conjunto no se confirma. En la segunda, los paquetes individuales no se confirman individualmente, es el fichero entero el que se confirma cuando llega completo. Discutir las dos opciones.

**Opción A: Confirmación por Paquete**

Cómo funciona: ACK individual por cada paquete.

Ventajas:

1. Alta fiabilidad (solo se retransmite lo perdido)

2. Control de congestión en tiempo real

3. Progreso visible

**Desventajas:**

1. Más overhead (sobrecarga o gasto adicional es todo lo que «envías» además de los datos útiles). (muchos ACKs)
2. Mayor complejidad

Ejemplo real: TCP (transferencias web, FTP)

**Opción B: Confirmación por Archivo**

Cómo funciona: Solo un ACK al final de todo.

**Ventajas:**

1. Mínimo overhead

2. Sencillo de implementar

**Desventajas:**

1. Muy ineficiente con errores (retransmite TODO)

2. Sin control de congestión

3. Sin visibilidad de progreso

Ejemplo real: TFTP (solo en LANs muy estables)

**Comparación Rápida:**

Para la mayoría de casos → Confirmación por paquete (TCP)

Solo para casos muy específicos → Confirmación por archivo (TFTP en LAN)