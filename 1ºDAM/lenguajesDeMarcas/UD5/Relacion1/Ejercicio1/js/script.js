const resaltarAnimales = document.getElementById("resaltarAnimales")
const animales = document.getElementsByClassName("animal")
for (const animal of animales) {
    animal.style.backgroundColor = "lightyellow";
}
resaltarAnimales.addEventListener("click", function() {
    for (const animal of animales) {
        animal.style.color = "green"
        animal.style.fontSize = "20px";
    }
})
