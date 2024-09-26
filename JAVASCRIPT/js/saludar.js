const inputNombre = document.querySelector('#nombre');
const btnSaludar = document.querySelector('#btn-saludar');

btnSaludar.addEventListener('click', () => {
    const spanSaludo = document.createElement('span'); // <span></span>
    spanSaludo.innerText = 'Hola ' + inputNombre.value; // <span>Hola nombre</span>

    btnSaludar.after(spanSaludo);
});
