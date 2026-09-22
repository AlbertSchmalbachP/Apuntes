const noticias = document.getElementsByClassName("noticia")
for (let i = 0; i < noticias.length; i++) {
    noticias[i].textContent = "🔥 " + noticias[i].textContent
    if (i % 2 == 0) {
        noticias[i].style.backgroundColor = "lightgray"
    } else {
        noticias[i].style.color = "blue"
    }
}