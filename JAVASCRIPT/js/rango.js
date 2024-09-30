const rango = document.querySelector('input[type=range]');

rango.addEventListener('input', (event) => {
    const valor = event.target.value;

    const span = document.querySelector('input[type=range] + span');

    if (!span) {
        const span = document.createElement('span');
        rango.after(span);
    }

    span.innerText = valor;
});
