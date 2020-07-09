
function agregarPizza(){
    var datos = new FormData();
    
    var refTamano = document.getElementById("tamano");
    var refPasta = document.getElementById("pasta");
    var refNom = document.getElementById("nombre");
    var refIngre = document.getElementById("ingre");
    var refPrecio = document.getElementById("precio");
    
    if(refTamano && refPasta && refNom && refIngre && refPrecio){
        var tamano = refTamano.options[refTamano.selectedIndex].value;
        var pasta = refPasta.options[refPasta.selectedIndex].value;
        var nombre = refNom.value;
        var ingredientes = refIngre.value;
        var precio = refPrecio.value;
        
        if(tamano && pasta && nombre && ingredientes && precio){
            datos.append("tamano", tamano);
            datos.append("pasta", pasta);
            datos.append("nombre", nombre);
            datos.append("ingredientes", ingredientes);
            datos.append("precio", precio);
            
            getJSON('ServicioCrearPizza', datos, procesarRespuesta);
            
        } else{
            alert("Debe completar todos los campos");
        }
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

function procesarRespuesta(datos){
    console.log(datos);
    if(datos.result === 'ok'){
        window.location.assign('paginaAdmin.jsp');
    } else{
        alert('Error inesperado');
    }
}


