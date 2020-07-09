
function init() {
    cargarTabla();

}

function cargarTabla() {
    var refId = document.getElementById('id');
    var refNombre = document.getElementById('nombre');
    var refIngre = document.getElementById('ingre');
    var refPrecio = document.getElementById('precio');
    
    if (refNombre && refIngre && refPrecio && refId) {

        var id = localStorage.getItem("id");
        var nombre = localStorage.getItem("nombre");
        var ingred = localStorage.getItem("ingred");
        var precio = localStorage.getItem("precio");
            
        refId.value = id;
        refNombre.value = nombre;
        refIngre.value = ingred;
        refPrecio.value = precio;

    }
}

function editarPizza(){
    var datos = new FormData();
    
    var refId = document.getElementById("id");
    var refTamano = document.getElementById("tamano");
    var refPasta = document.getElementById("pasta");
    var refNom = document.getElementById("nombre");
    var refIngre = document.getElementById("ingre");
    var refPrecio = document.getElementById("precio");
    
    if(refId && refTamano && refPasta && refNom && refIngre && refPrecio){
        var id = refId.value;
        var tamano = refTamano.options[refTamano.selectedIndex].value;
        var pasta = refPasta.options[refPasta.selectedIndex].value;
        var nombre = refNom.value;
        var ingredientes = refIngre.value;
        var precio = refPrecio.value;
        
        if(tamano && pasta && nombre && ingredientes && precio){
            datos.append("id", id);
            datos.append("tamano", tamano);
            datos.append("pasta", pasta);
            datos.append("nombre", nombre);
            datos.append("ingredientes", ingredientes);
            datos.append("precio", precio);
            
            getJSON1('ServicioEditarPizza', datos, procesarRespuesta);
            
        } else{
            alert("Debe completar todos los campos");
        }
    } 
}

function procesarRespuesta(datos){
    console.log(datos);
    if(datos.result === 'ok'){
        window.location.assign('paginaAdmin.jsp');
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

window.onload = init;