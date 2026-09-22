#!/bin/bash
# Ejercicios funciones Bash 2

crear_directorio() {
    if [ -e $1 ]
    then
        echo "Directorio '$1' ya existe"
    else
        mkdir -p $1
        echo "Directorio '$1' creado"
    fi
}

buscar_archivos_grandes() {
    resultado=$(find "$1" -size +${2}M)
    if [ -z "$resultado" ]
    then
        echo "No se encontraron resultados que tengan un tamaño mayor a $2 MB"
    else
        echo "$resultado"
    fi
}

buscar_por_extension() {
    resultado=$(find $1 -type f -name "*.${2}")
    echo "$resultado"
}

cambiar_permisos() {
    if [ ! -e $2 ] # si no existe...
    then
        echo "El directorio no existe!"
    else
        if [[ $1 =~ ^[0-7]{3,4}$ ]] # el doble corchete en la condición es para que bash no se lie con los corchetes del regex ([0-7])
        then
            chmod $1 $2
            echo "Permisos concedidos al archivo."
        else
            echo "Formato no válido."
        fi
    fi
}

obtener_propietario() {
    if [ ! -e $1 ] # si no existe...
    then
        echo "El directorio no existe!"
    else
        usuario_propietario=$(ls -ld $1 | cut -d" " -f3)
        grupo_propietario=$(ls -ld $1 | cut -d" " -f4)
    fi
    echo "Propietario -> $usuario_propietario | Grupo -> $grupo_propietario"
}

respaldo() {
    fecha_actual=$(date +%Y%m%d_%H%M%S)
    origen=$(basename "$1")
    mkdir -p /home/alumnoT/backups # create if doesn't exist
    if [ ! -e $1 ] # si no existe...
    then
        echo "El fichero no existe!"
    else
        cp -- $1 /home/alumnoT/backups/${origen}.bak-${fecha_actual}
        echo "Respaldo del fichero creado satisfactoriamente."
    fi
}

tamaño_directorio() {
    if [ ! -e $1 ] # si no existe...
    then
        echo "El directorio no existe!"
    else
        echo "$(ls -ld $1 | cut -d" " -f5) bits"
    fi
}

puerto_abierto() {
    conexion_posible=$(nc -z $1 $2 &>/dev/null && echo "true")
    if [ $conexion_posible == "true" 2>/dev/null ]
    then
        echo "Puerto $2 abierto en $1"
    else
        echo "Puerto $2 cerrado en $1"
    fi
}

verificar_conectividad() {
    conexion_posible=$(ping -c 1 $1 &>/dev/null && echo "true")
    if [ $conexion_posible == "true" 2>/dev/null ]
    then
    latencia=$(ping -c 1 $1 | head -2 | tail -1 | cut -d" " -f7 | cut -d"=" -f2)
    echo "$1 responde (latencia: $latencia ms)"
    else
        echo "$1 no responde"
    fi
}

echo "Ej 1:"
crear_directorio $1
echo "Ej 2:"
buscar_archivos_grandes $1 $2
echo "Ej 3:"
buscar_por_extension $1 $2
echo "Ej 4:"
cambiar_permisos $1 $2
echo "Ej 5:"
obtener_propietario $1
echo "Ej 6:"
respaldo $1
echo "Ej 7:"
tamaño_directorio $1
echo "Ej 8:"
puerto_abierto $1 $2
echo "Ej 9:"
verificar_conectividad $1