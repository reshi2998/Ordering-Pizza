
<!-- 
pago.jsp


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
        <title>Método de pago</title>
        <script src="scripts/pago.js" type="text/javascript"></script>
        <link href="css/pago.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <h1>Seleccione el método de pago: </h1>
            <button type="submit" class="tarj" onclick="ventana();">Tarjeta</button>
            <button type="submit" class="efec" onclick="exitoEfectivo();">Efectivo</button>
        </div>
    </body>
</html>
 





