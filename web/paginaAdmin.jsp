<!--
paginaAdmin.jsp

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
        <title>Administración</title>
        <link href="css/paginaClienteStyle.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/ac25e8402d.js" crossorigin="anonymous"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
        <script src="scripts/ScriptPagAdmin.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            HttpSession sesionCliente = request.getSession(true);
            String usuario = String.valueOf(sesionCliente.getAttribute("usuario"));
        %>
        <header>
            <input type="checkbox" id="btn-menu"/>
            <label for="btn-menu"><img src="css/imagenes/iconoMenu.png" alt=""/></label>
            <nav class="menu" id="menu">
                <ul>
                    <li class="inicio"><a href="agregarPizza.jsp">Agregar Pizza</a></li>
                    <li><a href=""><%= usuario%></a>
                        <ul>
                            <li><a href="ServicioCerrarSesion">Cerrar sesión</a></li>
                        </ul>
                    </li>
                    <li><a href="">Reporte de Ventas</a>
                        <ul>
                            <li><a href="reporteFechas.jsp">Reporte Por Fecha</a></li>
                            <li><a href="reporteProductos.jsp">Reporte por producto</a></li>
                        </ul>
                    </li>
                    <li><a href="comentariosRecibidos.jsp">Comentarios Recibidos</a></li>
                </ul>
            </nav>
        </header>
         <h1 class="titulo">Administración Enau's Pizza</h1>
        <div id="contents">
            <section id="sec4"> 
                <table class="tablaPizzas">
                    <caption>Pizzas en el Menú</caption>
                    <thead>
                        <tr>
                            <th colspan="1">Pizza</th>
                            <th colspan="1">Nombre</th>
                            <th colspan="1">Pasta</th>
                            <th colspan="1">Tamaño</th>
                            <th colspan="1">Ingredientes</th>
                            <th colspan="1">Precio</th>
                            <th colspan="1">&nbsp;</th>
                            <th colspan="1">&nbsp;</th>
                        </tr>
                    </thead>    
                    <tbody id="tableBody"></tbody>
                </table>                
            </section>
        </div>
    </body>
</html>
