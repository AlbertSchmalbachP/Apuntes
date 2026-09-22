let precios = document.getElementsByClassName("precio")
for (let precio of precios) {
    precio.style.fontWeight = "bold"
    if (precio.textContent > 50) {
        precio.style.color = "red"
    }
}