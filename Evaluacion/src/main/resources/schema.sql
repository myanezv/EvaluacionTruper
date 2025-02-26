CREATE TABLE Sucursal (
sucursal_id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL
);

CREATE TABLE OrdenesCompra (
orden_id INT PRIMARY KEY AUTO_INCREMENT,
sucursal_id INT NOT NULL,
producto_id INT NOT NULL,
fecha date,
total decimal
);

CREATE TABLE Productos (
producto_id INT PRIMARY KEY AUTO_INCREMENT,
orden_id INT NOT NULL,
codigo VARCHAR(20),
descripcion VARCHAR(200),
precio decimal
);