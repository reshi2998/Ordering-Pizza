// scriptComen.js
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

function init() {

    fetch('ServicioComenReci').then(function (resultado) {
        return resultado.json();
    }).then(function (datos) {
        cargarTabla(datos['datos_comentarios'], 'tableBody');
    });

    console.log("Aplicación inicializada..");
}

function cargarTabla(datos, e) {
    var refTabla = document.getElementById(e);
    if (refTabla) {

        datos.forEach(function (fila, i, arreglo) {

            var indice = refTabla.rows.length;
            var nuevaFila = refTabla.insertRow(-1); 
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.comentario;
            nuevaCelda.setAttribute('class', 'd1'); 
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.fecha;
            nuevaCelda.setAttribute('class', 'd2');
        });
    }
}

function getJSON(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}

window.onload = init;