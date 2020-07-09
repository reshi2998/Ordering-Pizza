<!--
index.jsp

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
        <meta charset="UTF-8">
        <title>Login</title>
        <link href="css/indexStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <form action="ServicioLogin" method="post" name="formulario" class="formulario">
                <h1 class="formulario_titulo">Inicie Sesión en Enau Pizza's</h1>
                <input type="text" class="formulario_input" id="username" name="username" autocomplete="off"/>
                <label for="" class="formulario_label">Usuario</label>
                <input type="password" class="formulario_input" id="password" name="password" autocomplete="off"/>
                <label for="" class="formulario_label">Contraseña</label>
                <input type="submit" class="formulario_submit" value="Iniciar Sesión"/>
                <!--<button type="button" onclick="validarUsuario();" class="formulario_submit">Iniciar Sesión</button>
                <button type="submit" class="formulario_submit">Iniciar Sesión</button>-->
            </form>  
            <a class="registro" href="registro.jsp">Regístrate en Enau Pizza's</a>
            <script src="scripts/scriptIndex.js" type="text/javascript"></script>
        </div>
    </body>
</html>
