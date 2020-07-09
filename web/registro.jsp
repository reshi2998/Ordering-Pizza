<!-- 
registro.jsp

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
        <title>Registro cliente nuevo</title>
        <link href="css/registro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <form id="DatosClienteNuevo" method="POST" action="ServicioRegistro" >
                <table class="tablaFormulario">
                    <h4> Datos de registro </h4>
                    <tr>
                        <td class="etiqueta">
                            <label for="cedBus">Identificación:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="cedClient" name="cedClient" size="15" />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="cedBus">Nombre de usuario:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="idClient" name="idClient" size="15" />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="cedBus">Clave de acceso:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="clave" name="clave" size="15" />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="apeBus">Apellidos:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="apelli" name="apelli" size="15" />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="nomBus">Nombre:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="nomb" name="nomb" size="15" />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="direccion">Dirección:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="direccion" name="direccion" size="15" />
                        </td>
                    </tr>
                    <tr>
                        <td class="etiqueta">
                            <label for="telefono">Teléfono:</label>
                        </td>
                        <td class="campo">
                            <input type="text" id="telefono" name="telefono" size="15" />
                        </td>
                    </tr>
                </table>
                <button type="submit" class="enviarInfo" >Crear cliente</button>
            </form>
        </div>
    </body>
</html>
