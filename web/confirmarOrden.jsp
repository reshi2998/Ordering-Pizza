<%--
confirmarOrden.jsp

EIF209 - Programación 4 - Proyecto #2
Junio 2020

Autores:
    - 207950788     Sara Moraga Alfaro
    - 116980485     Scarleth Villarreal Jímenez
    - 117250099     Josué Víquez Campos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        String user = (String) session.getAttribute("usuario");
        if (user == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    } catch (Exception e) {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Completar Compra</title>
        <link href="css/confirmarOrden.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/confirmarOrden.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            HttpSession sesionCliente = request.getSession(true);
            String usuario = String.valueOf(sesionCliente.getAttribute("usuario"));
        %>
        <div class="wrapper">
            <h1> Orden de usuario <strong><%= usuario%></strong></h1>
            <table class="tablaOrden">
                <tr>
                    <td class="etiqueta">
                        <label for="idOrd">No. de orden:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="idOrden" name="idOrden" readonly size="15" />
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="idC">Id cliente:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="idC" name="idC" readonly size="15" />
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="idPizz">Pizza:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="idPiz" name="idPiz" readonly size="15" />
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="acom">Acompañamientos:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="acomp" name="acomp" readonly size="15" />
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="ex">Extras:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="ext" name="ext" readonly size="15" />
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="uPizz">Unidad pizza:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="uPizz" name="uPizz" readonly size="15" />
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="pTotal">Precio total:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="pTotal" name="pTotal" readonly size="15" />
                    </td>
                </tr>
            </table>
            <h2> Desea confirmar su orden? </h2>
            <button type="button" id='cancel' class="cancel" onclick="cancelar();" >Cancelar</button>
            <button type="submit" id='aceptar' class="aceptar" >Aceptar</button>
            <script type="text/javascript">
                document.getElementById("aceptar").onclick = function () {
                    location.href = "pago.jsp";
                };
            </script>
        </div>
    </body>
</html>
