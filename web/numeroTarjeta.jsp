<!-- 
numeroTarjeta.jsp

 

 EIF209 - Programación 4 - Proyecto #2
 Junio 2020

 

 Autores:
    - 207950788     Sara Moraga Alfara
    - 116980485     Scarleth Villarreal Jímenez
    - 117250099     Josué Víquez Campos
-->

 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Numero de Tarjeta</title>
        <script src="scripts/pago.js" type="text/javascript"></script>
        <link href="css/numeroTarjeta.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <h1>Digite el número de la tarjeta</h1>
            <input type="text" id="algo" class="algo" size="15"/>
            <button type="submit" class="butt" onclick="exitoTarjeta();">Aceptar</button>
        </div>
    </body>
</html>
