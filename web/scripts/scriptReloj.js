// scriptReloj.js
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jiménez
//    - 117250099     Josué Víquez Campos

 


function init() {
    var fiveMinutes = 60 * 5,
            display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
}

 

function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

 

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

 

        display.textContent = minutes + ":" + seconds;

 

        if (--timer < 0) {
            timer = duration;
        }
    }, 1000);
}

window.onload = init;


