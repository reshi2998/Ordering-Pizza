<%-- 
    Document   : errorLogin
    Created on : 21/06/2020, 12:40:08 AM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Error Login</title>
        <link href="css/ErrorLoginStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <input type="checkbox" id="cerrar"> <!-- "boton" para cerrar ventana modal -->
            <label for="cerrar" id="btnCerrar"><a href="index.jsp" id="urlCrear">X</a></label> 
            <div class="modal"> <!-- modal y contenido de la ventana modal deben ir seguidos -->
                <div class="contenido">
                    <h2 id="mensajeError">Datos Incorrectos</h2><br>
                    <p class="mensajeInfo">
                        Inténtelo de nuevo.<br><br>
                        Si no posee una cuenta <a href="registro.jsp">regístrese</a>.
                    </p>
                </div>
            </div>
    </body>
</html>
