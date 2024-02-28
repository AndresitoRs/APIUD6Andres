cargarListaJuegos()

function cargarListaJuegos(){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/juego", requestOptions)
        .then((response) => response.json())
        .then((result) => rellenaCombo(result))
        .catch((error) => console.error(error));
}

function rellenaCombo(resultado){
    selector = document.getElementById("comboJuegos")
    for (let juego of resultado) {
        opcion = document.createElement("option");
        opcion.text=juego.nombre;
        opcion.value=juego.id;
        selector.appendChild(opcion);
    }
}

function mostrarPuntuaciones(id){
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("http://localhost:8080/api/puntuacion/categoria/" + id, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}