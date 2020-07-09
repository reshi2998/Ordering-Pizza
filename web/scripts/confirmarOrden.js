// confirmarOrden.js
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

function init() {

    fetch('ServicioMostrarOrden').then(function (resultado) {
        return resultado.json();
    }).then(function (datos) {
        cargarTabla(datos['datos_orden']);
    });

    console.log("Aplicación inicializada..");
}

function cargarTabla(datos) {
    var refIdOrden = document.getElementById('idOrden');
    var refIdClient = document.getElementById('idC');
    var refIdPizza = document.getElementById('idPiz');
    var refAcomp = document.getElementById('acomp');
    var refExtra = document.getElementById('ext');
    var refUnidad = document.getElementById('uPizz');
    var refPrecio = document.getElementById('pTotal');
    
    if (refIdOrden && refIdClient && refIdPizza && refAcomp && refExtra && refUnidad && refPrecio) {

        datos.forEach(function (fila) {
            
            refIdOrden.value = fila.id_orden;
            refIdClient.value = fila.id_cliente;
            refIdPizza.value = fila.pizza;
            refAcomp.value = fila.acomp;
            refExtra.value = fila.extras;
            refUnidad.value = fila.unidadP;
            refPrecio.value = fila.precioTot;
        });
    }
}


// // ============================================================================
//                               BOTON CANCELAR
// ============================================================================

function callbackCancelar(datos) {
    console.log(datos);
    if(datos.result === 'ok'){
        window.location.assign('paginaCliente.jsp');
    } else{
        alert('Error inesperado');
    }
}

function cancelar(){
    var datos = new FormData();
    var refId = document.getElementById("idOrden");
    var id = refId.value;
    datos.append("id",id);
    getJSON1("ServicioEliminarOrden", datos, callbackCancelar);
}

function getJSON1(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}

window.onload = init;


