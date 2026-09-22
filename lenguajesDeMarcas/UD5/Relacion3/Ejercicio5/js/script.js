// declarar variables
let listaAlbumes = document.getElementById("albumes")
let nuevoAlbum1 = document.createElement("li")
let nuevoAlbum2 = document.createElement("li")
let albumQuitado = document.createElement("li")
let albumes = listaAlbumes.getElementsByTagName("li")
// añadir contenido a los nuevos contenidos
albumQuitado.textContent = "\"L'odore Della Morte\" - Talco"
nuevoAlbum1.textContent = "\"Xapomelon\" - La Pegatina"
nuevoAlbum2.textContent = "\"Street Gigs\" - The Locos"
// recorrer el HTMLArray albumes hasta encontrar los deseado y eliminarlo
for (let i = 0; i < albumes.length; i++) {
    if (albumes[i].textContent == "\"L'odore Della Morte\" - Talco") {
        albumes[i].remove()
    }
}
// añadir los albumes en el orden deseado
listaAlbumes.appendChild(nuevoAlbum1)
listaAlbumes.appendChild(albumQuitado)
listaAlbumes.appendChild(nuevoAlbum2)