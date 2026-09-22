#!/bin/bash

# funcion division entera

divisionEntera() { 
echo $(($1 / $2))
} 

divisionEntera $1 $2


# funcion area circulo

areaCirculo() { 
numeroPi=3.1416
area=$( echo "$numeroPi * ($1 * $1)" | bc -l)
echo $area
} 

areaCirculo $1


# funcion perimetro circulo

perimetroCuadrado() { 
perimetro=$( echo "4 * $1" | bc -l)
echo $perimetro
} 

perimetroCuadrado $1

# funcion volumen esfera

volumenEsfera() { 
numeroPi=3.1416
volumen=$( echo "(4 / 3) * $numeroPi * ($1 * $1 * $1)" | bc -l)
echo $volumen
} 

volumenEsfera $1


# funcion area rectangulo

areaRectangulo() { 
area=$( echo "$1 * $2" | bc -l)
echo $area
} 

areaRectangulo $1 $2

# NOTA: bash calculator (bc) permite decimales. Calculando sin bash calculator hará que NO se calculen decimales