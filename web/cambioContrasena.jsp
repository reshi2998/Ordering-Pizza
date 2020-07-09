<!--
cambioContrasena.jsp

EIF209 - Programación 4 - Proyecto #2
Junio 2020

Autores:
    - 207950788     Sara Moraga Alfaro
    - 116980485     Scarleth Villarreal Jímenez
    - 117250099     Josué Víquez Campos
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cambiar contraseña</title>
        <link href="css/cambioContrasena.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <h1>Cambio de clave</h1>
            <form class="formClave" method="POST" action="ServicioCambiarClave">
                <input type="text" name="usuarioId" id="usuarioId" placeholder="Ingrese usuario" autocomplete="off">
                <input type="text" name="claNueva" id="claNueva" placeholder="Ingrese clave nueva" autocomplete="off">
                <input type="submit" name="algo2" value="Cambiar">
            </form>
        </div>
    </body>
</html>
