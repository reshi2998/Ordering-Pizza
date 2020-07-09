<!--
comentarios.jsp

EIF209 - Programación 4 - Proyecto #2
Junio 2020

Autores:
    - 207950788     Sara Moraga Alfaro
    - 116980485     Scarleth Villarreal Jiménez
    - 117250099     Josué Víquez Campos
-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/editarCuenta.css" rel="stylesheet" type="text/css"/>
        <title>Comentarios</title>
        <link href="css/comentStyle.css" rel="stylesheet" type="text/css"/>
        <%
            if (request.getSession(true).getAttribute("usuario") == null) {
                response.sendRedirect("index.jsp");
            }
        %>
    </head>
    <body>
        <h1>Para Enau's Pizza es muy importante conocer tu opinión.</h1>
        <form id="datosComentarios" method="POST" action="ServiciosComentarios">
            <table class="tablaComentario">
                <tr>
                    <td class="etiqueta">
                        <label for="comentario">Comentario: </label>
                    </td>
                    <td class="etiqueta">
                        <textarea class="comentario" name="comentario"
                                  cols="65" rows="10" ></textarea>
                    </td>
                <tr>
                    <td class='etiqueta'>
                        <button type="submit" class="enviarComen" >Enviar</button>
                    </td>
                </tr>
            </table>
        </form>
        <h3>¡Gracias por tu comentario!</h3>
    </body>
</html>
