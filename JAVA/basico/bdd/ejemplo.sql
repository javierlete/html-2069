--
-- Archivo generado con SQLiteStudio v3.4.4 el mi. oct. 23 17:34:13 2024
--
-- Codificación de texto usada: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: productos
CREATE TABLE IF NOT EXISTS productos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, precio NUMERIC (19, 2) NOT NULL);
INSERT INTO productos (id, nombre, precio) VALUES (1, 'Monitor', '123,34');
INSERT INTO productos (id, nombre, precio) VALUES (2, 'Ratón', '12,34');
INSERT INTO productos (id, nombre, precio) VALUES (3, 'Portátil', '1234,56');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
