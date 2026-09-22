#!/bin/bash
# Ejercicios funciones Bash 2

multiplicar() {
    # control de errores
    if [ $# -lt 2 ]
    then
        echo "No se han introducido valores suficientes!"
    else
        # funcionalidad principal
        resultado=$( echo "$1 * $2" | bc -l)
        echo $resultado
    fi
}

potencia() {
    # control de errores
    if [ $# -lt 2 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $2 -eq 0 ]
    then
        echo "1"
    else
        # funcionalidad principal
        base=$1
        exponente=$2
        i=0
        while [ $i -lt $exponente ]
        do
            resultado=$( echo "$resultado * $base" | bc -l)
            ((i++))
        done
        echo $resultado
    fi
}

volumen_cubo() {
    # control de errores
    if [ $# -eq 0 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $1 -eq 0 ]
    then
        echo "La longitud del lado no puede ser 0!"
    else
        # funcionalidad principal
        resultado=$( echo "$1 * $1 * $1" | bc -l)
        echo $resultado
    fi
}

modulo() {
    # control de errores
    if [ $# -lt 2 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $2 -eq 0 ]
    then
        echo "No se puede dividir entre 0!"
    else
        # funcionalidad principal
        resultado=$(($1 % $2))
        echo $resultado
    fi
}

verificar_par() {
    # control de errores
    if [ $# -eq 0 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $1 -eq 0 ]
    then
        echo "$1 no es ni par ni impar."
    else
        # funcionalidad principal
        if [[ $(($1 % 2)) == 0 ]]
        then
            echo "$1 es par"
        else
            echo "$1 es impar"
        fi
    fi
}

mayor_de_tres() {
    # control de errores
    if [ $# -lt 3 ]
    then
        echo "No se han introducido valores suficientes!"
    else
        # funcionalidad principal
        if [[ $1 -gt $2 && $1 -gt $3 ]]
        then
            echo $1
        elif [[ $2 -gt $1 && $2 -gt $3 ]]
        then
            echo $2
        elif [[ $3 -gt $1 && $3 -gt $2 ]]
        then
            echo $3
        else
            echo "No hay ningún número único que sea el mayor."
        fi
    fi
}

factorial() {
    # control de errores
    if [ $# -eq 0 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $1 -lt 0 ]
    then
        echo "Los números negativos no tienen factorial!"
    else
        # funcionalidad principal
        i=2
        resultado=1
        while [ $i -le $1 ]
        do
            resultado=$((resultado * $i))
            ((i++))
        done
        echo $resultado
    fi
}

es_primo() {
    # control de errores
    if [ $# -eq 0 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $1 -le 1 ]
    then
        echo "Los numeros menores a 2, por definición, no son primos."
    else
        # funcionalidad principal
        divisor_encontrado=0
        i=2
        while [ $i -lt $1 ]
        do
            if [[ $(($1 % $i)) == 0 ]]
            then
                divisor_encontrado=1
            fi
            ((i++))
        done
        if [[ $divisor_encontrado -eq 0 ]]
        then
            echo "$1 es primo"
        else
            echo "$1 no es primo"
        fi
    fi
}

fibonacci() {
    # control de errores
    if [ $# -eq 0 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $1 -le 0 ]
    then
        echo "No se ha introducido un indice correcto! Debe ser un número positivo!"
    else
        # funcionalidad principal
        primer_numero=0
        segundo_numero=1
        i=0
        while [ $i -lt $1 ]
        do
            resultado=$primer_numero
            resultado_parcial=$(($primer_numero + $segundo_numero))
            # Actualizar los numeros para la siguiente iteración
            primer_numero=$segundo_numero
            segundo_numero=$resultado_parcial
            ((i++))
        done
        echo $resultado
    fi
}

sumatorio() {
    # control de errores
    if [ $# -eq 0 ]
    then
        echo "No se han introducido valores suficientes!"
    elif [ $1 -le 0 ]
    then
        echo "No se ha introducido un indice correcto! Debe ser un número positivo!"
    else
        # funcionalidad principal
        numero=$1
        # duplicamos los numeros hasta el numero, haciendo que todas las sumas sean ese numero + 1, y dividimos entre dos ya que tenemos el doble
        resultado=$(( numero * (numero + 1) / 2 ))
        echo $resultado
    fi
}

echo "Ej 4:"
multiplicar $1 $2
echo "Ej 5:"
potencia $1 $2
echo "Ej 7:"
volumen_cubo $1
echo "Ej 8:"
modulo $1 $2
echo "Ej 9:"
verificar_par $1
echo "Ej 10:"
mayor_de_tres $1 $2 $3
echo "Ej 11:"
factorial $1
echo "Ej 12:"
es_primo $1
echo "Ej 13:"
fibonacci $1
echo "Ej 14:"
sumatorio $1