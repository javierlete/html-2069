'use strict';

document.addEventListener('DOMContentLoaded', () => {
    // Pensar el número
    const numero = Math.floor(Math.random() * 100) + 1; // Entre 1 y 100

    // Introducir un número
    const button = document.querySelector('button');
    const input = document.querySelector('input');

    button.addEventListener('click', () => {
        // Obtener el número
        const valor = +input.value;

        // ¿Es igual?
        if (valor === numero) {
            // ¡Felicidades!
            alert('¡Felicidades!');
        } else {
            if (numero > valor) {
                alert('Es mayor');
            } else {
                alert('Es menor');
            }
        }
    });
});
