
<!--
reloj.jsp


EIF209 - Programación 4 - Proyecto #2
Junio 2020


Autores:
    - 207950788     Sara Moraga Alfara
    - 116980485     Scarleth Villarreal Jiménez
    - 117250099     Josué Víquez Campos
-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
        <script src="scripts/scriptReloj.js" type="text/javascript"></script>
        <link href="css/relojStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 class="titulo">¡Gracias por su compra!</h1>
        <div class="wrapper">Tiempo estimado para la entrega de su orden <span id="time" >05:00</span> minutos</div>
        <button type="button" id="btn" class="btn">Inicio</button>
        <script type="text/javascript">
                document.getElementById("btn").onclick = function () {
                    location.href = "paginaCliente.jsp";
                };
            </script>
    </body>
</html>






