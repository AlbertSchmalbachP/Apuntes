let nuevoIntegrante = document.createElement("li")
let listaIntegrantes = document.getElementById("integrantes")
let integrantes = listaIntegrantes.getElementsByTagName("li")
nuevoIntegrante.textContent = "Trompetista"
listaIntegrantes.appendChild(nuevoIntegrante)
for (let i = 0; i < integrantes.length; i++) {
    if (integrantes[i].textContent == "Batería") {
        integrantes[i].remove()
    }
}