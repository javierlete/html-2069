'use strict';

let form;

document.addEventListener('DOMContentLoaded', async () => {
    const tbody = document.querySelector('tbody');

    form = document.querySelector('form');

    form.style.display = 'none';

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const id = form.id.value;
        const nombre = form.nombre.value;
        const precio = form.precio.value;

        if (id) {
            const respuesta = await fetch(`http://localhost:3000/productos/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id, nombre, precio })
            });
        } else {
            const respuesta = await fetch('http://localhost:3000/productos', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ nombre, precio })
            });
        }

        if (respuesta.ok) {
            alert('Guardado');
            form.reset();
            location.reload();
        }
    });

    const respuesta = await fetch('http://localhost:3000/productos');
    const productos = await respuesta.json();

    for (const producto of productos) {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${producto.id}</td>
            <td>${producto.nombre}</td>
            <td>${producto.precio}</td>
            <td>
                <a class="btn btn-sm btn-primary" href="javascript:editar(${producto.id})">Editar</a>
                <a class="btn btn-sm btn-danger" onclick="return confirm('¿Seguro de que quieres borrar el producto ${producto.id}?')" href="javascript:borrar(${producto.id})">Borrar</a>
            </td>`;

        tbody.appendChild(tr);
    }
});

async function borrar(id) {
    // alert(id);

    const respuesta = await fetch(`http://localhost:3000/productos/${id}`, { method: 'DELETE' });

    if (respuesta.ok) {
        alert('Borrado');
        location.reload();
    }
}

async function editar(id) {
    form.style.display = 'block';

    if (id) {
        const respuesta = await fetch(`http://localhost:3000/productos/${id}`);
        const producto = await respuesta.json();

        form.id.value = id;
        form.nombre.value = producto.nombre;
        form.precio.value = producto.precio;
    } else {
        form.reset();
    }
}