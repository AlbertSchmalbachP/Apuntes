#!/bin/bash
# Ejercicios repaso

promedio_tres_numeros() {
    # control de errores
    if [ $# -lt 3 ]
    then
        echo "No se han introducido valores suficientes!"
    else
        # funcionalidad principal
        promedio=$( echo "($1 + $2 + $3) / $#" | bc -l )
        echo "El promedio es $promedio."
    fi
}

echo "Ej 1:"
promedio_tres_numeros $1 $2 $3

conversor_de_temperaturas() {
    temperaturaCelsius=$1
    temperaturaFarenheit=$( echo "($temperaturaCelsius * 9) / 5 + 32" | bc -l )
    echo "La temperatura introducida (${temperaturaCelsius} celcius) equivale a ${temperaturaFarenheit} farenheits."
}

echo "Ej 2:"
conversor_de_temperaturas $1

tabla_multiplicar() {
    i=0
    mensaje=""
    resultado=0
    limite=10
    while [[ $i -lt $limite ]] 
    do
        ((i++))
        resultado=$( echo "$i * $1" | bc -l )
        mensaje+="${i} x ${1} = ${resultado} | "
    done
    echo "$mensaje"
}

echo "Ej 3:"
tabla_multiplicar $1

calcular_iva() {
precioBase=$1
porcentajeIva=$2
precioAnadido=$( echo "$precioBase * 0.$porcentajeIva" | bc -l )
precioTotal=$( echo "$precioBase + $precioAnadido" | bc -l )
echo "El precio con IVA es $precioTotal"
}

echo "Ej 4:"
calcular_iva $1 $2 

validar_argumentos() {
    numeroDeseado=3
    if [ $# -lt $numeroDeseado ]
    then
        echo "No se han introducido valores suficientes!"
    else
        echo "To bien"
    fi
}

echo "Ej 5:"
validar_argumentos $@