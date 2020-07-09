//Para los extras
var catalogo = null;
var productoSeleccionado = null;
var tablaFactura = [];

//Para los acompanamientos
var catalogoAcomp = null;
var AcompSeleccionado = null;
var tablaAcomp = [];

//==============================================================================
//                        FUNCIONES PARA LOS EXTRAS
//==============================================================================
function init() {

    // La función inicializarDatos() ya ha cargado la variable
    // con el catálogo de producos antes de ejecutar la inicialización.
    // Esto garantiza que los datos estén cargados correctamente antes de
    // ejecutar cualquier otro código.

    actualizarMenu();
    actualizarMenuAcomp();
    
    actualizarCodigo();
    actualizarCodigoAcomp();

    console.log("Aplicación inicializada..");
}

function inicializarDatos(nuevosDatos) {

    // Esta función se ejecuta cuando se carga la hoja de scripts.
    // NO se ejecuta como respuesta a un evento de la página.
    // Observe que es posible cargar los datos de manera asíncrona
    // y actualizar el menú de productos cuando el servidor envíe la
    // respuesta a la petición.

    catalogo = nuevosDatos;
    console.log("Datos cargados..");
}

// ---------------------------------------------------------------------

function actualizarMenu() {

    var refMenu = document.getElementById("menuExtras");
    if (refMenu) {
        refMenu.options.length = 0;
        {
            var opc = document.createElement("OPTION");
            opc.setAttribute("value", "null");
            opc.appendChild(document.createTextNode("(Seleccione su extra)"));
            refMenu.appendChild(opc);
        }

        var extraslist = catalogo["lista-extras"];

        extraslist.forEach(
                function (extras, i)
                {
                    // Solamente se muestran los productos disponibles, es decir,
                    // aquellos que no han sido aún agregados a la factura.

                    if (extras.disponible) {
                        var opc = document.createElement("OPTION");
                        opc.setAttribute("value", extras.nombre);
                        opc.appendChild(document.createTextNode(extras.nombre));
                        refMenu.appendChild(opc);
                    }
                }
        );

        refMenu.selectedIndex = 0;
        productoSeleccionado = null;
        //actualizarFormulario();
    }
}

function seleccionarProducto() {
    var refMenu = document.getElementById("menuExtras");
    if (refMenu) {
        var idExtra = refMenu.value;
        if (idExtra !== "null") {
            console.log("Seleccionando extras: " + idExtra);
            productoSeleccionado = obtenerProducto(idExtra);
        } else {
            productoSeleccionado = null;
            console.error("No se ha seleccionado ningun extra.");
        }

        // Una vez que se ha seleccionado el producto, se muestra
        // la información en el formulario.
        // El producto no se agrega a la factura hasta que el usuario
        // haga clic en el botón correspondiente.

        //actualizarFormulario();
    }
}


function obtenerProducto(id) {
    var r = null;
    var extras = catalogo["lista-extras"];
    for (var i = 0; i < extras.length; i++) {
        var ext = extras[i];
        if (ext.nombre === id) {
            r = ext;
            break;
        }
    }
    return r;
}

function cambiarDisponibilidad(idExt, disponibilidad) {
    var extra = obtenerProducto(idExt);
    if (extra) {
        extra.disponible = disponibilidad;
    }
}

// ---------------------------------------------------------------------

function agregarProducto() {
    agregar(productoSeleccionado);
}

function agregar(nuevaExtras) {
    var refTabla = document.getElementById("cuerpoTablaExtras");

    if (refTabla && nuevaExtras) {

        nuevaExtras.disponible = false;

        var datosExtras = {
            codigo: nuevaExtras.nombre,
            precio: nuevaExtras.precio,
            cantidad: 1,
            subtotal: nuevaExtras.precio
        };

        tablaFactura.push(datosExtras);
        console.log("Agregando producto: " + JSON.stringify(nuevaExtras));

        // Se agrega una fila a la tabla con la información del nuevo producto
        // seleccionado, y se recalculan los totales de la factura.

        var indice = refTabla.rows.length;
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerText = nuevaExtras.idExtras;
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerText = nuevaExtras["nombre"];

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.className = "c2";
        nuevaCelda.innerText = formatoMoneda(datosExtras.precio);

        // El valor del subtotal debe tener un atributo 'id', para poder
        // referenciarlo cuando se actualiza la cantidad.

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "totalE" + String(indice);
        nuevaCelda.className = "c2";
        nuevaCelda.innerText = formatoMoneda(datosExtras.subtotal);

        // Por último, se coloca un botón para indicar cuando una fila
        // debe eliminarse. Observe que el atributo 'indice' es asignado
        // al botón, pero el evento es manejado por el icono asignado.

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.className = "c2";

        var btn = document.createElement("BUTTON");
        btn.className = "btn";
        btn.setAttribute("indice", indice);
        btn.innerHTML = "<i class='fas fa-trash-alt' onclick='eliminarFila();'></i>";

        nuevaCelda.appendChild(btn);

        // Ya se ha incluido el producto, por lo que hay que recalcular
        // los subtotales y el total general.

        actualizarTabla();

        actualizarMenu();
    }
}

function actualizarCampo() {
    var indice = event.target.getAttribute("indice");
    var nuevaCantidad = parseFloat(event.target.value);

    var item = tablaFactura[indice];

    if (!isNaN(nuevaCantidad)) {

        // Calcula el nuevo subtotal.
        // El valor de la cantidad es un número en el rango [a..b], y se
        // redondea a dos posiciones decimales.

        var a = 0.1;//valor minimo
        var b = 1000.0;//valor máximo

        item.cantidad = Math.floor(100 * Math.max(a, Math.min(b, nuevaCantidad))) / 100;
        item.subtotal = item.precio * item.cantidad;
    }

    event.target.value = item.cantidad;

    actualizarTabla();
    actualizarCodigo();
}

function actualizarTabla() {
    var refTabla = document.getElementById("cuerpoTablaExtras");
    var refTotal = document.getElementById("totalGeneral");

    if (refTabla && refTotal) {
        var totalGeneral = 0.0;

        tablaFactura.forEach(
                function (item, i) {
                    item.subtotal = item.precio * item.cantidad;

                    var refSubtotal = document.getElementById("totalE" + String(i));
                    refSubtotal.innerText = formatoMoneda(item.subtotal);

                    totalGeneral += item.subtotal;
                }
        );

        refTotal.innerText = formatoMoneda(totalGeneral);
    }
}

// ---------------------------------------------------------------------

function eliminarFila() {
    eliminar(JSON.parse(event.target.parentNode.getAttribute("indice")));
}

function eliminar(fila) {
    console.log("Eliminando fila: " + fila);

    var refTabla = document.getElementById("cuerpoTablaExtras");
    if (refTabla) {

        var codigo = tablaFactura[fila].codigo;

        tablaFactura.splice(fila, 1);
        refTabla.deleteRow(fila);

        for (var i = fila; i < refTabla.rows.length; i++) {
            var refFila = refTabla.rows[i];

            var campo = refFila.getElementsByTagName("INPUT")[0];
            campo.setAttribute("indice", i);

            var refSubtotal = document.getElementById("totalE" + String(i + 1));

            refSubtotal.id = "totalE" + String(i);

            var btn = refFila.getElementsByTagName("I")[0].parentNode;
            btn.setAttribute("indice", i);
        }

        cambiarDisponibilidad(codigo, true);

        actualizarMenu();
        actualizarTabla();
    }
}

function limpiar(obj) {
    console.log("limpiando...");
    eliminar(obj);

}

// ---------------------------------------------------------------------

function formatoMoneda(valor) {
    return String.fromCharCode(8353) + numeral(valor).format(" 0,0.00");
}
//-----------------------------------------------------------------------


//==============================================================================
//                      FUNCIONES PARA LOS ACOMPANAMIENTOS
//==============================================================================


function inicializarDatosAcomp(nuevosDatosAcomp) {

    catalogoAcomp = nuevosDatosAcomp;
    console.log("Datos cargados ACOMPANAMIENTOS..");
}

function actualizarMenuAcomp() {

    var refMenu = document.getElementById("menuProductos");
    if (refMenu) {
        refMenu.options.length = 0;
        {
            var opc = document.createElement("OPTION");
            opc.setAttribute("value", "null");
            opc.appendChild(document.createTextNode("(Seleccione su acompanamiento)"));
            refMenu.appendChild(opc);
        }

        var acomplist = catalogoAcomp["lista-acompanamientos"];

        acomplist.forEach(
                function (acomp, i)
                {
                    // Solamente se muestran los productos disponibles, es decir,
                    // aquellos que no han sido aún agregados a la factura.
                    if (acomp.disponible) {
                        var opc = document.createElement("OPTION");
                        opc.setAttribute("value", acomp.nombre);
                        opc.appendChild(document.createTextNode(acomp.nombre));
                        refMenu.appendChild(opc);
                    }
                }
        );
        refMenu.selectedIndex = 0;
        AcompSeleccionado = null;
        //actualizarFormulario();
    }
}

function seleccionarAcomp() {
    var refMenu = document.getElementById("menuProductos");
    if (refMenu) {
        var idAcomp = refMenu.value;
        if (idAcomp !== "null") {
            console.log("Seleccionando acompanamiento: " + idAcomp);
            AcompSeleccionado = obtenerAcompanamiento(idAcomp);
        } else {
            AcompSeleccionado = null;
            console.error("No se ha seleccionado ningun acompanamiento.");
        }

        //actualizarFormulario();
    }
}

//function actualizarFormulario() {
//    if (productoSeleccionado) {
//        document.getElementById("nombre").value = productoSeleccionado["nombre"];
//        document.getElementById("precio").innerHTML.value = formatoMoneda(productoSeleccionado.precio);
//    }  else {
//        document.getElementById("nombre").value = "(no hay un EXTRA seleccionado)";
//        document.getElementById("precio").value = formatoMoneda(0);
//    }
//}

function obtenerAcompanamiento(id) {
    var r = null;
    var acomp = catalogoAcomp["lista-acompanamientos"];
    for (var i = 0; i < acomp.length; i++) {
        var ext = acomp[i];
        if (ext.nombre === id) {
            r = ext;
            break;
        }
    }
    return r;
}

function cambiarDispon(idAc, disponibilidad) {
    var acopmanamiento = obtenerAcompanamiento(idAc);
    if (acopmanamiento) {
        acopmanamiento.disponible = disponibilidad;
    }
}

// ---------------------------------------------------------------------

function agregarAcompanamiento() {
    agregarAcomp(AcompSeleccionado);
}

function agregarAcomp(nuevoAcompanamiento) {
    var refTabla = document.getElementById("cuerpoTablaAcomp");

    if (refTabla && nuevoAcompanamiento) {

        nuevoAcompanamiento.disponible = false;

        var datosAcomp = {
            idAcompanamiento: nuevoAcompanamiento.nombre,
            precioAcomp: nuevoAcompanamiento.precioAcomp,
            cantidad: 1,
            subtotal: nuevoAcompanamiento.precioAcomp
        };

        tablaAcomp.push(datosAcomp);
        console.log("Agregando acompanamiento: " + JSON.stringify(nuevoAcompanamiento));

        // Se agrega una fila a la tabla con la información del nuevo producto
        // seleccionado, y se recalculan los totales de la factura.

        var indice = refTabla.rows.length;
        var nuevaFila = refTabla.insertRow(-1);
        var nuevaCelda;

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerText = nuevoAcompanamiento.idAcompanamiento;
        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.innerText = nuevoAcompanamiento["nombre"];

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.className = "c3";
        nuevaCelda.innerText = formatoMoneda(datosAcomp.precioAcomp);

        // El valor del subtotal debe tener un atributo 'id', para poder
        // referenciarlo cuando se actualiza la cantidad.

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.id = "totalA" + String(indice);
        nuevaCelda.className = "c3";
        nuevaCelda.innerText = formatoMoneda(datosAcomp.subtotal);

        // Por último, se coloca un botón para indicar cuando una fila
        // debe eliminarse. Observe que el atributo 'indice' es asignado
        // al botón, pero el evento es manejado por el icono asignado.

        nuevaCelda = nuevaFila.insertCell(-1);
        nuevaCelda.className = "c3";

        var btn1 = document.createElement("BUTTON");
        btn1.className = "btn1";
        btn1.setAttribute("indice", indice);
        btn1.innerHTML = "<i class='fas fa-trash-alt' onclick='eliminarFilAcomp();'></i>";

        nuevaCelda.appendChild(btn1);

        // Ya se ha incluido el producto, por lo que hay que recalcular
        // los subtotales y el total general.

        actualizarTablAcomp();

        actualizarMenuAcomp();
    }
}

function actualizarCampoAcomp() {
    var indice = event.target.getAttribute("indice");
    var nuevaCantidad = parseFloat(event.target.value);

    var item = tablaAcomp[indice];

    if (!isNaN(nuevaCantidad)) {

        // Calcula el nuevo subtotal.
        // El valor de la cantidad es un número en el rango [a..b], y se
        // redondea a dos posiciones decimales.

        var a = 0.1;//valor minimo
        var b = 1000.0;//valor máximo

        item.cantidad = Math.floor(100 * Math.max(a, Math.min(b, nuevaCantidad))) / 100;
        item.subtotal = item.precio * item.cantidad;
    }

    event.target.value = item.cantidad;

    actualizarTablAcomp();
    actualizarCodigoAcomp();
}

function actualizarTablAcomp() {
    var refTabla = document.getElementById("cuerpoTablaAcomp");
    var refTotal = document.getElementById("totalGeneralAcomp");

    if (refTabla && refTotal) {
        var totalGeneralAcomp = 0.0;

        tablaAcomp.forEach(
                function (item, i) {
                    item.subtotal = item.precioAcomp * item.cantidad;

                    var refSubtotal = document.getElementById("totalA" + String(i));
                    refSubtotal.innerText = formatoMoneda(item.subtotal);

                    totalGeneralAcomp += item.subtotal;
                }
        );

        refTotal.innerText = formatoMoneda(totalGeneralAcomp);
    }
}

// ---------------------------------------------------------------------

function eliminarFilAcomp() {
    eliminarAcomp(JSON.parse(event.target.parentNode.getAttribute("indice")));
}

function eliminarAcomp(fila) {
    console.log("Eliminando fila: " + fila);

    var refTabla = document.getElementById("cuerpoTablaAcomp");
    if (refTabla) {

        var codigoAcomp = tablaAcomp[fila].idAcompanamiento;

        tablaAcomp.splice(fila, 1);
        refTabla.deleteRow(fila);

        for (var i = fila; i < refTabla.rows.length; i++) {
            var refFila = refTabla.rows[i];

            var campo = refFila.getElementsByTagName("INPUT")[0];
            campo.setAttribute("indice", i);

            var refSubtotal = document.getElementById("totalA" + String(i + 1));

            refSubtotal.id = "totalA" + String(i);

            var btn = refFila.getElementsByTagName("I")[0].parentNode;
            btn.setAttribute("indice", i);
        }

        cambiarDispon(codigoAcomp, true);

        actualizarMenuAcomp();
        actualizarTablAcomp();
    }
}

function limpiar(obj) {
    console.log("limpiando...");
    eliminarAcomp(obj);

}

//==============================================================================
//              PARA OBTENER DATOS DE AMBAS TABLAS Y ENVIARLOS
//==============================================================================

function obtenerTablas() {
    console.log("Guardando tablas...");
    
    var datos = new FormData();
    var tblEx = document.getElementById("cuerpoTablaExtras");
    var tblAc = document.getElementById("cuerpoTablaAcomp");
    
    if(tablaFactura.length > 0 && tablaAcomp.length > 0){
        var filasEx = tblEx.rows.length;
        var filasAc = tblAc.rows.length;

        var nombreE = '';
        var nombreA = '';
        
        for (var i = 0; i < filasEx; i++) {
            var descripcion = tblEx.rows[i].cells[1].innerHTML;      
            nombreE += descripcion+',';
        }
        var totalFormatoE = numeral(document.getElementById("totalGeneral").innerHTML);
        var totalGeneralE = totalFormatoE._value;
        datos.append('descripcionE',nombreE);
        datos.append('totalGeneralE', totalGeneralE);
        
        for (var i = 0; i < filasAc; i++){
            var descripcion = tblAc.rows[i].cells[1].innerHTML;
            nombreA += descripcion+',';
        }
        var totalFormatoA = numeral(document.getElementById("totalGeneralAcomp").innerHTML);
        var totalGeneralA = totalFormatoA._value;
        datos.append('descripcionA',nombreA);
        datos.append('totalGeneralA',totalGeneralA);
        
        var idPizza = localStorage.getItem("idPizza");
        datos.append('idPizza',idPizza);
        localStorage.removeItem("idPizza");
        
        getJSON1('ServivcioNuevaOrden', datos, callbackOrden);
        
    } else{
        alert('Si no desea extras o acompañamientos seleccione "Sin extras" o "Sin acompañamientos"');
    }
}

function callbackOrden(datos) {
    console.log(datos);
    if(datos.result === 'ok'){
        window.location.assign('confirmarOrden.jsp');
    } else{
        alert('Error inesperado');
    }
}

function getJSON1(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);
}


 

