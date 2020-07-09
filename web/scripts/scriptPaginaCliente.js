// scriptIndex.js
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

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
            btn.innerHTML = "<i class='fas fa-cart-plus' onclick='agregarPizza();'></i>";
            nuevaCelda.appendChild(btn);
        });
    }
}

function agregarPizza(){
    var indice2 = event.target.parentNode.getAttribute("indice");
    agregar(indice2);
}

function agregar(fila){
    var datos = new FormData();
    
    var refTabla = document.getElementById("tableBody");
    if (refTabla) {
        var id_pizza = refTabla.rows[fila].cells[0].innerHTML;
        var nombre_pizza = refTabla.rows[fila].cells[1].innerHTML;
        var tipo_pasta = refTabla.rows[fila].cells[2].innerHTML;
        var tamano = refTabla.rows[fila].cells[3].innerHTML;
        var ingredientes = refTabla.rows[fila].cells[4].innerHTML;
        var precioSinFormato = numeral(refTabla.rows[fila].cells[5].innerHTML);
        var precio = precioSinFormato._value;
        
        localStorage.setItem('idPizza',id_pizza);
        
        datos.append('id_pizza', id_pizza);
        datos.append('nombre_pizza', nombre_pizza);
        datos.append('tipo_pasta', tipo_pasta);
        datos.append('tamano', tamano);
        datos.append('ingredientes', ingredientes);
        datos.append('precio', precio);
        
        getJSON('ServicioAgregarPizza', datos, callback);
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

function callback(datos) {
    console.log(datos);
    if(datos.result === 'ok'){
        window.location.assign('extrasYacomp.jsp');
    } else{
        alert('Error inesperado');
    }
}

function formatoMoneda(valor) {
    return String.fromCharCode(8353) + numeral(valor).format(" 0,0.00");
}

window.onload = init;


