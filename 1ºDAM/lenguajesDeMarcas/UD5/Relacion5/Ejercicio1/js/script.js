let listaElementos = document.getElementById("lista")
let numeroElementos = listaElementos.childElementCount
let nuevoElemento

document.getElementById("btnAniadir").addEventListener("click", function() {
    nuevoElemento = document.createElement("li")
    numeroElementos++
    nuevoElemento.textContent = "Elemento " + numeroElementos
    listaElementos.appendChild(nuevoElemento)
})
document.getElementById("btnBorrar").addEventListener("click", function() {
    if (listaElementos.lastElementChild != null) {
        listaElementos.lastElementChild.remove()
        numeroElementos--
    }
})
document.getElementById("btnEditar").addEventListener("click", function() {
    if (listaElementos.lastElementChild != null) {
        listaElementos.lastElementChild.textContent = "Elemento editado!"
    }
})