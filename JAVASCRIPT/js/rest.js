'use strict';

document.addEventListener('DOMContentLoaded', async () => {
    const tbody = document.querySelector('tbody');
    
    const respuesta = await fetch('json/datos.json');
    const productos = await respuesta.json();

    for (const producto of productos) {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>`;

        tbody.appendChild(tr);
    }
});
