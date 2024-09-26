function modificarTitulo() {
    // Busca el elemento h1
    const h1 = document.querySelector('h1');

    // Muestra por consola el texto que hay dentro del h1
    console.log(h1.innerText);

    // Modifica el texto del h1 a Hola mundo
    h1.innerText = 'Hola mundo';
}

modificarTitulo();

function sumar(a, b) {
    return a + b;
}

const resultado = sumar(2, 3);

console.log(resultado);

// Busca el elemento input con el id 'nombre'
const inputNombre = document.querySelector('#nombre');

// Busca el elemento button que hay en pantalla
const buttonSaludar = document.querySelector('button');

// Busca el elemento span que tiene el id saludo
const spanSaludo = document.querySelector('#saludo');

// Se queda pendiente de que cuando alguien haga click en el botón...
buttonSaludar.addEventListener('click', () => {
    // ...haga lo que se dice a continuación
    // La alerta es un mensaje que aparece en pantalla y pide aceptar
    // alert('Pulsado');

    // Sustituye el texto del span saludo por el texto del input nombre
    spanSaludo.innerText = 'Hola ' + inputNombre.value;
});

buttonSaludar.addEventListener('click', saludar);

function saludar() {
    spanSaludo.innerText = 'Hola ' + inputNombre.value;
}