// scriptPagAdmin.js
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

var tablaPizzas = [];
function init() {

    fetch('ServicioTablaPizzas').then(function (resultado) {
        return resultado.json();
    }).then(function (datos) {
        cargarTabla(datos['datos_pizza'], 'tableBody');
    });

    console.log("Aplicación inicializada..");
}

function cargarTabla(datos, e) {
    var refTabla = document.getElementById(e);
    
    if (refTabla) {
        
        tablaPizzas.length = 0;

        datos.forEach(function (fila, i, arreglo) {

            var indice = refTabla.rows.length;
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.id_pizza;
            nuevaCelda.setAttribute('class', 'd1');

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.nombre_pizza;
            nuevaCelda.setAttribute('class', 'd2');

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.tipo_pasta;
            nuevaCelda.setAttribute('class', 'd3');

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.tamano;
            nuevaCelda.setAttribute('class', 'd4');

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = fila.ingredientes;
            nuevaCelda.setAttribute('class', 'd5');

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.textContent = formatoMoneda(fila.precio);
            nuevaCelda.setAttribute('class', 'd6');

            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.setAttribute('class', 'd7');
            var btn = document.createElement("BUTTON");
            btn.className = "btn";
            btn.setAttribute("indice", indice);
            btn.innerHTML = "<i class='fas fa-trash-alt'  onclick='eliminarFila();'></i>";
            nuevaCelda.appendChild(btn);
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.setAttribute('class', 'd7');
            var btn = document.createElement("BUTTON");
            btn.className = "btn";
            btn.setAttribute("indice", indice);
            btn.innerHTML = "<i class='far fa-edit' onclick='editarPizza();'></i>";
            nuevaCelda.appendChild(btn);
            
             var datosPizza = {
                id: fila.id_pizza,
                nombre: fila.nombre_pizza,
                pasta: fila.tipo_pasta,
                tamano: fila.tamano,
                ingred: fila.ingredientes,
                precio: fila.precio
            };        
            
            tablaPizzas.push(datosPizza);
        });
    }
}

function eliminarFila() {
    eliminar(JSON.parse(event.target.parentNode.getAttribute("indice")));
}
function eliminar(fila) {
    console.log("Eliminando fila: " + fila);
    var datos = new FormData();
    var refTabla = document.getElementById("tableBody");
    
    if (refTabla) {
        
        var id = tablaPizzas[fila].id;
        datos.append('id_pizza', id);
        getJSON('ServicioEliminaPizza', datos);
        
        tablaPizzas.splice(fila, 1);
        refTabla.deleteRow(fila);
        
        for (var i = fila; i < refTabla.rows.length; i++) {
            var refFila = refTabla.rows[i];
//            
//            var campo = refFila.getElementsByTagName("INPUT")[0];
//            campo.setAttribute("indice", i);
//            
//            var refSubtotal = document.getElementById("total" + String(i + 1));
//            refSubtotal.id = "total" + String(i);
            
            var btn = refFila.getElementsByTagName("I")[0].parentNode;
            btn.setAttribute("indice", i);
        }
    }
}

function editarPizza() {
    editar(JSON.parse(event.target.parentNode.getAttribute("indice")));
    redireccionar();
}
function editar(fila) {
//    var datos = new FormData();

    var refTabla = document.getElementById("tableBody");
    
    if (refTabla) {
        
        var id = tablaPizzas[fila].id;
        var nombre = tablaPizzas[fila].nombre;
        var pasta = tablaPizzas[fila].pasta;
        var tamano = tablaPizzas[fila].tamano;
        var ingred = tablaPizzas[fila].ingred;
        var precio = tablaPizzas[fila].precio;
        
        localStorage.setItem("id", id);
        localStorage.setItem("nombre", nombre);
        localStorage.setItem("ingred", ingred);
        localStorage.setItem("precio", precio);
        
//        datos.append('id', id);
//        datos.append('nombre', nombre);
//        datos.append('pasta', pasta);
//        datos.append('tamano', tamano);
//        datos.append('ingred', ingred);
//        datos.append('precio', precio);
//        
//        getJSON('ServicioLlenarEditar', datos, procesarRespuesta);

    }
}

function redireccionar(){
        window.location.assign('editarPizza.jsp');
}

function getJSON(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}

function formatoMoneda(valor) {
    return String.fromCharCode(8353) + numeral(valor).format(" 0,0.00");
}

window.onload = init;