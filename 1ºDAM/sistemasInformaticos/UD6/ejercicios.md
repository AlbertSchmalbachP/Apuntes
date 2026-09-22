# Ejercicios peticiones http

1. Crea una base de datos en json con 2 personas, que tenga como datos sus coches. Ahora sí podemos apuntar una persona y sus coches, y no id dueño en cada coche. Fijate en profes y asignaturas.
{
  "personas": [
    {
      "id": 1,
      "nombre": "Ana",
      "edad": 28,
      "coches": [
        { "marca": "Seat", "modelo": "Ibiza" }
      ]
    },
    {
      "id": 2,
      "nombre": "Luis",
      "edad": 35,
      "coches": [
        { "marca": "Ford", "modelo": "Focus" },
        { "marca": "Renault", "modelo": "Clio" }
      ]
    }
  ]
}

2. Enciende un servidor usando json-server que aloje esta base de datos.
json-server --watch db.json --port 3000

A partir de aquí, dejamos esa terminal abierta y abrimos otra terminal

3. Realiza una peticion GET para ver todas las personas
curl -X GET http://localhost:3000/personas

4. Realiza una petición GET para ver a la segunda persona que aparece en la base de datos.
curl -X GET http://localhost:3000/personas/2

5. Añade una nueva persona
curl -X POST -d '{ "id": 3, "nombre": "Carlos", "edad": 40, "coches": [] }' http://localhost:3000/personas

6. Modifica la edad a la tercera persona.
curl -X PATCH -d '{ "nombre": "Albert" }' http://localhost:3000/personas/3

7. Muestra todas las personas de más de 30 años
curl -X GET http://localhost:3000/personas 2> /dev/null | jq '.[] | select(.edad > 30)'

8. Muestra todos los coches de una persona. solo los coches.
curl -X GET http://localhost:3000/personas/1 2> /dev/null | jq '.coches'
