const cuadroPassword = document.querySelector('input[type=password]');
const botonMostrar = document.querySelector('button');

botonMostrar.addEventListener('click', () => {
    cuadroPassword.type = 'text';
    // cuadroPassword.style = 'border: 2px solid green;';
    cuadroPassword.className = 'destacado';
});
