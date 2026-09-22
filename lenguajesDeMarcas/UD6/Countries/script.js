const apiUrl = "https://restcountries.com/v3.1/";
const endpointNombre = "name/"
const endpointRegion = "region/"
const endpointCapital = "capital/"
const endpointCodigo = "alpha/"
const endpointListaRapida = "all?fields=name,flags,capital,population"
let mensajeError = ""

// Función para obtener datos de un pais por un valor de busqueda
async function obtenerPais(valorBusqueda, filtrarPor) {
    mensajeError = ""
    let endpoint = ""
    if (filtrarPor == "nombre") {
        endpoint = endpointNombre
    } else if (filtrarPor == "region") {
        endpoint = endpointRegion
    } else if (filtrarPor == "capital") {
        endpoint = endpointCapital
    } else if (filtrarPor == "codigo") {
        endpoint = endpointCodigo
    } else if (filtrarPor == "todos") {
        endpoint = endpointListaRapida
    } else {
        console.log("Error: El filtro seleccionado no está definido. Arregla el código.")
    }
    if (filtrarPor === "region") {
        document.getElementById("resultado-region").innerHTML = "";
    }
    try {
        const respuesta = await fetch(`${apiUrl}${endpoint}${valorBusqueda}`);
        if (!respuesta.ok) {
            mensajeError = "¡No se encontró el país que estás intentando buscar!"
        }
        let datos = await respuesta.json();
        if (filtrarPor === "todos") {
            document.getElementById("resultado-todos").innerHTML = ""
        }
        for (let dato of datos) {
            mostrarPais(dato, filtrarPor);
        }
    } catch (error) {
        if (mensajeError == "") {
            alert("¡Algo ha fallado! Revisa tu conexión o prueba de nuevo más tarde.")
        } else {
            alert(mensajeError)
        }
    }
}

// Función para mostrar los datos del pais en la página
function mostrarPais(dato, tipoFiltro) {
    const contenedorNombre = document.getElementById("resultado-nombre");
    const contenedorRegion = document.getElementById("resultado-region");
    const contenedorCapital = document.getElementById("resultado-capital");
    const contenedorCodigo = document.getElementById("resultado-codigo");
    const contenedorTodos = document.getElementById("resultado-todos");
    let capitales = ""
    let idiomas = ""
    let monedas = ""
    let poblacion = ""
    let continentes = ""
    let zonasHorarias = ""
    let nombreComunNativo = ""
    let nombreOficialNativo = ""

    if (dato.capital == undefined) {
        capitales = "N/A"
    } else {
        for (let capital of dato.capital) {
            capitales += capital + "\n"
        }
    }

    if (dato.continents == undefined) {
        continentes = "N/A"
    } else {
        for (let continente of dato.continents) {
            continentes += continente + "\n"
        }
    }

    if (dato.timezones == undefined) {
        zonasHorarias = "N/A"
    } else {
        for (let zonaHoraria of dato.timezones) {
            zonasHorarias += zonaHoraria + "\n"
        }
    }

    if (dato.languages == undefined) {
        idiomas = "N/A"
    } else {
        for (let idioma of Object.values(dato.languages)) {
            idiomas += idioma + "\n"
        }
    }

    if (dato.currencies == undefined) {
        monedas = "N/A"
    } else {
        for (let moneda of Object.values(dato.currencies)) {
            monedas += moneda.name + " (" + moneda.symbol + ")" + "\n"
        }
    }

    // formatear la población según la cantidad
    if (dato.population > 1000000) {
        poblacion = (dato.population / 1000000).toFixed(2) + " milliones de habitantes"
    } else if (dato.population > 1000) {
        poblacion = (dato.population / 1000).toFixed(1) + " mil habitantes"
    } else {
        poblacion = dato.population + " habitantes"
    }

    if (Object.values(dato.name.nativeName)[0] == undefined || Object.values(dato.name.nativeName)[0].common == undefined) {
        nombreComunNativo = "N/A"
    } else {
        nombreComunNativo = Object.values(dato.name.nativeName)[0].common
    }

    if (Object.values(dato.name.nativeName)[0] == undefined || Object.values(dato.name.nativeName)[0].official == undefined) {
        nombreOficialNativo = "N/A"
    } else {
        nombreOficialNativo = Object.values(dato.name.nativeName)[0].official
    }

    if (tipoFiltro == "nombre") {
        contenedorNombre.innerHTML = `
            <p>${dato.flag}</p>
            <h3>${dato.name.common} (${nombreComunNativo})</h3>
            <p><strong>Nombre oficial:</strong></p>
            <p>${dato.name.official} (${nombreOficialNativo})</p>
            <p><strong>Capital:</strong></p>
            <p>${capitales}</p>
            <p><strong>Región:</strong></p>
            <p>${dato.region}</p>
            <p><strong>Subregión:</strong></p>
            <p>${dato.subregion}</p>
            <p><strong>Población:</strong></p>
            <p>${poblacion}</p>
            <p><strong>Idiomas:</strong></p>
            <p>${idiomas}</p>
            <p><strong>Monedas:</strong></p>
            <p>${monedas}</p>
        `
    } else if (tipoFiltro == "region") {
        const tarjeta = document.createElement("div")
        tarjeta.innerHTML = `
            <p>${dato.flag}</p>
            <h3>${dato.name.common}</h3>
            <p><strong>Capital:</strong></p>
            <p>${capitales}</p>
            <p><strong>Población:</strong></p>
            <p>${poblacion}</p>
        `
        tarjeta.style.marginBottom = "20px";
        contenedorRegion.appendChild(tarjeta);
    } else if (tipoFiltro == "capital") {
        contenedorCapital.innerHTML = `
            <p>${dato.flag}</p>
            <h3>${dato.name.common} (${nombreComunNativo})</h3>
            <p><strong>Capital:</strong></p>
            <p>${capitales}</p>
            <p><strong>Región:</strong></p>
            <p>${dato.region}</p>
            <p><strong><a target="_blank" href="${dato.maps.googleMaps}">Enlace a Google Maps</a></strong></p>
        `
    } else if (tipoFiltro == "codigo") {
        contenedorCodigo.innerHTML = `
            <p>${dato.flag}</p>
            <h3>${dato.name.common} (${nombreComunNativo})</h3>
            <p><strong>Código cca2:</strong></p>
            <p>${dato.cca2}</p>
            <p><strong>Código cca3:</strong></p>
            <p>${dato.cca3}</p>
            <p><strong>Continente:</strong></p>
            <p>${continentes}</p>
            <p><strong>Zona(s) horaria(s):</strong></p>
            <p>${zonasHorarias}</p>
        `
    } else if (tipoFiltro == "todos") {
        const tarjeta = document.createElement("div")
        tarjeta.innerHTML = `
            <img src="${dato.flags.png}" style="width: 100px; height: auto;"></img>
            <h3>${dato.name.common} (${nombreComunNativo})</h3>
            <p><strong>Capital:</strong></p>
            <p>${capitales}</p>
            <p><strong>Población:</strong></p>
            <p>${poblacion}</p>
        `
        tarjeta.style.marginBottom = "20px";
        contenedorTodos.appendChild(tarjeta);
    } else {
        console.log("Error: El filtro seleccionado no está definido. Arregla el código.")
    }
}

//* Manejo del formulario de búsqueda

// por nombre
document.getElementById("form-nombre").addEventListener("submit", function (event) {
    event.preventDefault();
    const input = document.getElementById("input-nombre").value.trim().toLowerCase();
    if (input) {
        obtenerPais(input, "nombre");
    } else {
        alert("¡Debes introducir un input para buscar!")
    }
});

// por region
const botones = document.getElementsByClassName("btn-region")
for (let boton of botones) {
    boton.addEventListener("click", function () {
        const region = this.dataset.region
        obtenerPais(region, "region")
    })
}

// por capital
document.getElementById("form-capital").addEventListener("submit", function (event) {
    
    event.preventDefault();
    const input = document.getElementById("input-capital").value.trim().toLowerCase();
    if (input) {
        obtenerPais(input, "capital");
    } else {
        alert("¡Debes introducir un input para buscar!")
    }
});

// por codigo
document.getElementById("form-codigo").addEventListener("submit", function (event) {
    
    event.preventDefault();
    const input = document.getElementById("input-codigo").value.trim().toLowerCase();
    if (input) {
        obtenerPais(input, "codigo");
    } else {
        alert("¡Debes introducir un input para buscar!")
    }
});

// lista rapida
document.getElementById("btn-todos").addEventListener("click", function () {
    const input = ""
    obtenerPais(input, "todos")
})