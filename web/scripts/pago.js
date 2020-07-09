/* 
pago.js

 

EIF209 - Programación 4 - Proyecto #2
Junio 2020

 

Autores:
    - 207950788     Sara Moraga Alfara
    - 116980485     Scarleth Villarreal Jímenez
   - 117250099     Josué Víquez Campos
*/

 

function exitoEfectivo(){
    alert("Método de pago confirmado: Efectivo");
    window.location.assign('reloj.jsp');
}

function ventana(){
    window.location.assign('numeroTarjeta.jsp');
}

function exitoTarjeta(){
    alert("Método de pago confirmado: Tarjeta\nNúmero de tarjeta guardado con éxito");
    window.location.assign('reloj.jsp');
}
