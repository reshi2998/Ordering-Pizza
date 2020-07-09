<!-- 
editarCuenta.jsp

 EIF209 - Programación 4 - Proyecto #2
 Junio 2020

 Autores:
    - 207950788     Sara Moraga Alfara
    - 116980485     Scarleth Villarreal Jímenez
    - 117250099     Josué Víquez Campos
-->
<%@page import="proyecto2.modelo.Cliente"%>
<%@page import="proyecto2.modelo.dao.GestorCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cuenta</title>
        <% response.setHeader("cache-control", "no-cache, no-store, must-revalidate"); %>
        <link href="css/editarCuenta.css" rel="stylesheet" type="text/css"/>
        <%
            if (request.getSession(true).getAttribute("usuario") == null) {
                response.sendRedirect("index.jsp");
            }
        %>
    </head>
    <body>
        <div class="wrapper">
            <form id="DatosClienteNuevo" method="POST" action="ServicioEditarCuenta" >
                <table class="tablaFormulario">
                    <h4> Datos de registro </h4>
                    <tr>
                        <td class="etiqueta">
                            <label for="cedBus">Identificación:</label>
                        </td>
                        <%  HttpSession sesionActual = request.getSession(true);
                            Object usuario = sesionActual.getAttribute("usuario");
                            GestorCliente g = new GestorCliente();
                            String user = usuario.toString();
                            Cliente c = g.obtenerCliente(user);
                            String id = c.getIdCliente();
                            String usu = c.getUsuarioId();
                            String apell = c.getApellidos();
                            String nom = c.getNombre();
                            String dir = c.getDireccion();
                            String tel = c.getTelefono();
                        %>
                        <td class="campo">
                            <input type="text" id="ced"  name="ced" readonly size="15" value=<%=id%> />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="cedBus">Nombre de usuario:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="usu" name="usu" size="15" readonly value=<%=usu%> />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="apeBus">Apellidos:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="ape" name="ape" size="15" value=<%=apell%> />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="nomBus">Nombre:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="nom" name="nom" size="15" value=<%=nom%> />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="direccion">Dirección:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="dir" name="dir" size="15" value=<%=dir%> />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="telefono">Teléfono:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="tel" name="tel" size="15" value=<%=tel%> />
                        </td>
                    </tr>
                </table>
                <button type="submit" class="enviarInfo" >Crear cliente</button>
            </form>
        </div>
    </body>
</html>
