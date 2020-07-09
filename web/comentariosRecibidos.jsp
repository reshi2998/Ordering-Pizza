<!--
comentariosRecibidos.jsp

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
        <title>Comentarios</title>
        <script src="scripts/scriptComen.js" type="text/javascript"></script>
        <link href="css/paginaClienteStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 class="titulo">Comentarios y Observaciones</h1>
        <div id="contents">
            <section id="sec4"> 
                <table class="tablaPizzas">
                    <caption>Comentarios</caption>
                    <thead>
                        <tr>
                            <th colspan="1">Comentario</th>
                            <th colspan="1">Fecha</th>
                        </tr>
                    </thead>    
                    <tbody id="tableBody"></tbody>
                </table>                
            </section>
        </div>
    </body>
</html>

