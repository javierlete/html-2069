const cuadroPassword = document.querySelector('input[type=password]');
const botonMostrar = document.querySelector('button');

botonMostrar.addEventListener('click', () => {
    if (botonMostrar.innerText === 'Mostrar') {
        cuadroPassword.type = 'text';
        cuadroPassword.className = 'destacado';

        botonMostrar.innerText = 'Ocultar';
    } else {
        cuadroPassword.type = 'password';
        cuadroPassword.className = '';

        botonMostrar.innerText = 'Mostrar';
    }
});
