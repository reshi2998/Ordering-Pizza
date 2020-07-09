<%--
reporteFechas.jsp

EIF209 - Programación 4 - Proyecto #2
Junio 2020

Autores:
    - 207950788     Sara Moraga Alfaro
    - 116980485     Scarleth Villarreal Jímenez
    - 117250099     Josué Víquez Campos
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="proyecto2.modelo.Ordenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Ventas</title>
        <link href="css/ReportesStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <h2>Ingrese un rango de Fechas:</h2>
            <div class = "fechas">
                <form method="POST" action="ServicioFechas">
                    <input type="text" placeholder="yyyy-mm-dd" id="fecI" name="fecI" size="25"/>
                    <input type="text" id="fecF" placeholder="yyyy-mm-dd" name="fecF" size="25"/>
                    <input type="submit" id="boton" name="boton" value="Buscar"/>
                </form> 
            </div>
        </header>
        </br></br>
        <%ArrayList<Ordenes> list = (ArrayList<Ordenes>) request.getAttribute("consultaOrden");%> 
        <h1 class="titulo">Ventas realizadas</h1>
        <div id="contents">
            <section id="sec4">
                <table class="tablaPizzas">
                    <thead>
                        <tr>
                            <th colspan="1">ID Orden</th>
                            <th colspan="1">Pizza</th>
                            <th colspan="1">Acompañamiento</th>
                            <th colspan="1">Extras</th>
                            <th colspan="1">Cliente</th>
                            <th colspan="1">Unidad Pizza</th>
                            <th colspan="1">Precio Total</th>
                            <th colspan="1">Fecha de Compra</th>
                        </tr>
                    </thead>
                    <%
                        if (list != null) {
                            for (Ordenes e : list) {

                    %>
                    <tr>
                        <td><%= e.getNumeroOrden()%></td>
                        <td><%= e.getIdPizza()%></td>
                        <td><%= e.getAcompanamiento()%></td>
                        <td><%= e.getExtras()%></td>
                        <td><%= e.getIdCliente()%></td>
                        <td><%= e.getUnidadPizza()%></td>
                        <td><%= e.getPrecioTotal()%></td>
                        <td><%= e.getFecha()%></td>
                    </tr>
                    <%
                        }
                    } else {
                        String fei = request.getParameter("fechaI");
                        String fef = request.getParameter("fechaF");

                        if ((fei != null) && (fef != null)) {
                    %>
                    <tbody id="tableBody"></tbody>
                </table>
            </section>
            <p class="mensajeError">
                No se encuentra el registro de ordenes para el rango ingresado: <strong><%= fei%></strong>.
            </p>
            <%
            } else {
            %>  
            <p class="mensajeError">
                 . <%--No se indicó un rango de fechas a consultar.--%>
            </p>
            <%
                    }
                }
            %> 
        </div>
    </div>
</div>
</body>
</html>

