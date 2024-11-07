--
-- Archivo generado con SQLiteStudio v3.4.4 el ju. nov. 7 16:30:13 2024
--
-- Codificación de texto usada: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: lineas
CREATE TABLE IF NOT EXISTS lineas (
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    pedido_id         REFERENCES pedidos (id) 
                      NOT NULL,
    plato_id          NOT NULL
                      REFERENCES platos (id),
    cantidad  INTEGER NOT NULL
);

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       1,
                       1,
                       2,
                       1
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       2,
                       1,
                       1,
                       4
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       3,
                       2,
                       2,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       4,
                       2,
                       1,
                       2
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       5,
                       3,
                       2,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       6,
                       3,
                       1,
                       2
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       7,
                       4,
                       2,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       8,
                       4,
                       1,
                       2
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       9,
                       5,
                       3,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       10,
                       6,
                       3,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       11,
                       7,
                       3,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       12,
                       8,
                       4,
                       5
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       13,
                       9,
                       2,
                       3
                   );

INSERT INTO lineas (
                       id,
                       pedido_id,
                       plato_id,
                       cantidad
                   )
                   VALUES (
                       14,
                       10,
                       4,
                       3
                   );


-- Tabla: pedidos
CREATE TABLE IF NOT EXISTS pedidos (
    id             INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha                  NOT NULL
                           DEFAULT (DATETIME() ),
    restaurante_id         REFERENCES restaurantes (id) 
                           NOT NULL,
    usuario_id             REFERENCES usuarios (id) 
                           NOT NULL
);

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        1,
                        '2024-11-04T16:25',
                        1,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        2,
                        '2024-11-04T16:58:08.691790300',
                        1,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        3,
                        '2024-11-05T15:21:21.623510200',
                        1,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        4,
                        '2024-11-05T16:49:27.618792300',
                        1,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        5,
                        '2024-11-05T17:04:31.239017500',
                        2,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        6,
                        '2024-11-05T17:05:09.259663500',
                        2,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        7,
                        '2024-11-05T17:06:38.671077300',
                        2,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        8,
                        '2024-11-05T17:13:36.008233900',
                        3,
                        2
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        9,
                        '2024-11-05T17:15:22.776119',
                        1,
                        1
                    );

INSERT INTO pedidos (
                        id,
                        fecha,
                        restaurante_id,
                        usuario_id
                    )
                    VALUES (
                        10,
                        '2024-11-06T15:23:31.190723200',
                        3,
                        1
                    );


-- Tabla: platos
CREATE TABLE IF NOT EXISTS platos (
    id             INTEGER        PRIMARY KEY AUTOINCREMENT,
    nombre         VARCHAR (100)  NOT NULL,
    precio         DECIMAL (5, 2) NOT NULL,
    restaurante_id                REFERENCES restaurantes (id) 
                                  NOT NULL
);

INSERT INTO platos (
                       id,
                       nombre,
                       precio,
                       restaurante_id
                   )
                   VALUES (
                       1,
                       'BigIpartek',
                       4.34,
                       1
                   );

INSERT INTO platos (
                       id,
                       nombre,
                       precio,
                       restaurante_id
                   )
                   VALUES (
                       2,
                       'McIpartek',
                       3.45,
                       1
                   );

INSERT INTO platos (
                       id,
                       nombre,
                       precio,
                       restaurante_id
                   )
                   VALUES (
                       3,
                       'Pizzartek',
                       7.89,
                       2
                   );

INSERT INTO platos (
                       id,
                       nombre,
                       precio,
                       restaurante_id
                   )
                   VALUES (
                       4,
                       'Ipeperoni',
                       8.76,
                       3
                   );


-- Tabla: restaurantes
CREATE TABLE IF NOT EXISTS restaurantes (
    id              INTEGER        PRIMARY KEY AUTOINCREMENT,
    nombre          VARCHAR (100)  NOT NULL,
    tipo            VARCHAR (20)   NOT NULL,
    estrellas       DECIMAL (2, 1),
    minutos_entrega INT,
    precio_entrega  DECIMAL (4, 2) NOT NULL,
    precio_minimo   DECIMAL (4, 2) DEFAULT (0),
    descuento       INT            DEFAULT (0) 
);

INSERT INTO restaurantes (
                             id,
                             nombre,
                             tipo,
                             estrellas,
                             minutos_entrega,
                             precio_entrega,
                             precio_minimo,
                             descuento
                         )
                         VALUES (
                             1,
                             'IparBurger',
                             'Americana',
                             4.5,
                             15,
                             1.23,
                             10,
                             0
                         );

INSERT INTO restaurantes (
                             id,
                             nombre,
                             tipo,
                             estrellas,
                             minutos_entrega,
                             precio_entrega,
                             precio_minimo,
                             descuento
                         )
                         VALUES (
                             2,
                             'Iparizza',
                             'Italiana',
                             5,
                             20,
                             3.21,
                             8,
                             5
                         );

INSERT INTO restaurantes (
                             id,
                             nombre,
                             tipo,
                             estrellas,
                             minutos_entrega,
                             precio_entrega,
                             precio_minimo,
                             descuento
                         )
                         VALUES (
                             3,
                             'Iparomino',
                             'Italiana',
                             2.3,
                             23,
                             1,
                             0,
                             0
                         );


-- Tabla: usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id       INTEGER       PRIMARY KEY AUTOINCREMENT,
    nombre   VARCHAR (100) NOT NULL,
    email    VARCHAR (100) NOT NULL
                           UNIQUE,
    password VARCHAR (100) NOT NULL,
    rol      VARCHAR (20)  NOT NULL
);

INSERT INTO usuarios (
                         id,
                         nombre,
                         email,
                         password,
                         rol
                     )
                     VALUES (
                         1,
                         'Javier Lete',
                         'javier@email.net',
                         '384dac3368de6f658d7bc66e8fd4c8206b91c17a9084498948c7dd6e44d4a055',
                         'ADMIN'
                     );

INSERT INTO usuarios (
                         id,
                         nombre,
                         email,
                         password,
                         rol
                     )
                     VALUES (
                         2,
                         'Pepe Pérez',
                         'pepe@email.net',
                         '7c9e7c1494b2684ab7c19d6aff737e460fa9e98d5a234da1310c97ddf5691834',
                         'USER'
                     );

INSERT INTO usuarios (
                         id,
                         nombre,
                         email,
                         password,
                         rol
                     )
                     VALUES (
                         3,
                         'juan',
                         'juan@email.net',
                         'ed08c290d7e22f7bb324b15cbadce35b0b348564fd2d5f95752388d86d71bcca',
                         'USER'
                     );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
