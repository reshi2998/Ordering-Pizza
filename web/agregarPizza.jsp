<%-- 
    Document   : agregarPizza
    Created on : 27/06/2020, 05:35:46 PM
    Author     : Josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Pizza</title>
        <link href="css/insertarPizza.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/agregarPizza.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="wrapper">
            <h1>Nueva Pizza</h1>
            <table class="tablaForm">
                <tr>
                    <td class="etiqueta">
                        <label for="idOrd">Tamaño:</label>
                    </td>
                    <td class="campo">
                        <select name="tamano" id="tamano">
                            <option value="Personal">Personal</option>
                            <option value="Grande">Grande</option>
                            <option value="Familiar">Familiar</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="idC">Tipo de pasta:</label>
                    </td>
                    <td class="campo">
                        <select name="pasta" id="pasta">
                            <option value="Delgada">Delgada</option>
                            <option value="Gruesa">Gruesa</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="idPizz">Nombre:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="nombre" name="nombre"/>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="acom">Ingredientes:</label>
                    </td>
                    <td class="campo">
                        <input type="text" id="ingre" name="ingre"/>
                    </td>
                </tr>
                <tr>
                    <td class="etiqueta">
                        <label for="ex">Precio:</label>
                    </td>
                    <td class="campo">
                        <input type="number" id="precio" name="precio"/>
                    </td>
                </tr>
            </table>
            <button type="button" id='agregar' class="agregar" onclick="agregarPizza();" >Agregar nueva Pizza</button>
        </div>
    </body>
</html>
