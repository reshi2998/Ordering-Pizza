<!--
extrasYacomp.jsp

EIF209 - Programación 4 - Proyecto #2
Junio 2020

Autores:
    - 207950788     Sara Moraga Alfaro
    - 116980485     Scarleth Villarreal Jímenez
    - 117250099     Josué Víquez Campos
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyecto2.servicios.ServicioPrueba"%>
<%@page import="proyecto2.servicios.ServicioPruebAcomp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Extras y Acompañamientos</title>
        <link href="css/extrasYacomp.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/3b6de433d5.js" crossorigin="anonymous"></script>
        <script src="scripts/extrasAcomp.js" type="text/javascript"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
        <script type="text/javascript">
            inicializarDatos(<%= new ServicioPrueba().listaExtrasJSON()%>);
        </script>
        
        <script type="text/javascript">
            inicializarDatosAcomp(<%= new ServicioPruebAcomp().listaAcompanamientosJSON()%>);
        </script>
    </head>
    <body onload="init();">
        <div id="wrapper">
            <div id="arribaIzq">
                <h3 class="titulo">Seleccione extras y acompañamientos deseados, agréguelos a la tabla y dé click en aceptar.</h3>
                <h3 class="titulo">Si no desea, seleccione "sin extras" o "sin acompañamientos", agréguelos a la tabla y dé click en aceptar.</h3>
                <section id="sec1">
                    <form id="formExtras" name="formExtras">
                        <table id="formularioExtras" class="tablaFormulario">
                            <tr>
                                <td class="c1" style="font-weight: bold;">Extra:</td>
                                <td>
                                    <select id="menuExtras" name="menuExtras"
                                            onchange="seleccionarProducto();">
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="f_btn">
                                    <button type="reset">Borrar</button>&nbsp;
                                    <button type="button" onclick="agregarProducto();">Agregar</button>
                                </td>
                            </tr>
                        </table>
                    </form>                  
                </section>
            </div>
            <div id="arribaDer">
                <section id="sec2">
                    <table class="tablaGeneral" id="tablaExtras">
                        <caption>Extras seleccionados</caption>
                        <thead>
                            <tr>
                                <th style="width: 60px;">Código</th>
                                <th style="width: 180px;">Descripción</th>
                                <th style="width: 90px;">Precio</th>
                                <!--<th style="width: 90px;">Cant.</th>-->
                                <th style="width: 120px;">Total</th>
                                <th style="width: 48px;">&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody id="cuerpoTablaExtras"></tbody>
                        <tfoot>
                            <tr>
                                <td>&nbsp;</td>
                                <td colspan="2" class="c2b">Total general:</td>
                                <td id="totalGeneral" class="c2c" />
                                <td>&nbsp;</td>
                            </tr>
                        </tfoot>
                    </table>
                </section>
            </div>
            <div id="abajoIzq">
                <section id="sec3">
                    <form id="formAcomp" name="formAcomp">
                        <table id="formularioAcomp" class="tablaFormulario">
                            <tr>
                                <td class="c1" style="font-weight: bold;">Acompañamiento:</td>
                                <td>
                                    <select id="menuProductos" name="menuProductos"
                                            onchange="seleccionarAcomp();">
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="f_btn">
                                    <button type="reset">Borrar</button>&nbsp;
                                    <button type="button" onclick="agregarAcompanamiento();">Agregar</button>
                                </td>
                            </tr>
                        </table>
                    </form>                  
                </section>
                <button type="button" id="btnAceptar" onclick="obtenerTablas();">ACEPTAR</button>
            </div>
            <div id="abajoDer">
                <section id="sec4">
                    <table class="tablaGeneral" id="tablaAcomp">
                        <caption>Acompañamientos seleccionados</caption>
                        <thead>
                            <tr>
                                <th style="width: 60px;">Código</th>
                                <th style="width: 180px;">Descripción</th>
                                <th style="width: 90px;">Precio</th>
                                <th style="width: 120px;">Total</th>
                                <th style="width: 48px;">&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody id="cuerpoTablaAcomp"></tbody>
                        <tfoot>
                            <tr>
                                <td>&nbsp;</td>
                                <td colspan="2" class="c2d">Total general:</td>
                                <td id="totalGeneralAcomp" class="c2e" />
                                <td>&nbsp;</td>
                            </tr>
                        </tfoot>
                    </table>
                </section>
            </div>
        </div>
    </body>
</html>

