# Agencia de Viajes - Proyecto Spring Boot

Proyecto académico desarrollado con:
- Spring Boot
- Thymeleaf
- MySQL
- Bootstrap 5

## Configuración
1. Crea la base de datos en MySQL:
 -- Crear base de datos
CREATE DATABASE agencia_viajes CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE agencia_viajes;

-- ==============================================
-- TABLA: usuarios
-- ==============================================
CREATE TABLE usuarios (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  nombre VARCHAR(150) NOT NULL,
  email VARCHAR(200) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  rol ENUM('ADMIN', 'AGENTE', 'CLIENTE') NOT NULL,
  creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==============================================
-- TABLA: clientes
-- ==============================================
CREATE TABLE clientes (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  usuario_id CHAR(36),
  dni VARCHAR(50),
  telefono VARCHAR(50),
  direccion VARCHAR(255),
  FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL
);

-- ==============================================
-- TABLA: destinos
-- ==============================================
CREATE TABLE destinos (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  nombre VARCHAR(150) NOT NULL,
  pais VARCHAR(100),
  descripcion TEXT
);

-- ==============================================
-- TABLA: paquetes
-- ==============================================
CREATE TABLE paquetes (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  titulo VARCHAR(200) NOT NULL,
  descripcion TEXT,
  precio DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  destino_id CHAR(36),
  disponibilidad INT DEFAULT 0,
  FOREIGN KEY (destino_id) REFERENCES destinos(id) ON DELETE SET NULL
);

-- ==============================================
-- TABLA: reservas
-- ==============================================
CREATE TABLE reservas (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  cliente_id CHAR(36),
  paquete_id CHAR(36),
  fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') DEFAULT 'PENDIENTE',
  cantidad_personas INT DEFAULT 1,
  FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE,
  FOREIGN KEY (paquete_id) REFERENCES paquetes(id) ON DELETE SET NULL
);

-- ==============================================
-- DATOS DE EJEMPLO
-- ==============================================
select * from usuarios u ;
INSERT INTO usuarios (nombre, email, password_hash, rol) VALUES
('Admin Demo', 'admin@demo.com', 'hash_demo_admin', 'ADMIN'),
('Agente Demo', 'agente@demo.com', 'hash_demo_agente', 'AGENTE'),
('Cliente Demo', 'cliente@demo.com', 'hash_demo_cliente', 'CLIENTE');

-- Insertar cliente asociado al usuario 'cliente@demo.com'
INSERT INTO clientes (usuario_id, dni, telefono, direccion)
SELECT id, '12345678', '+57-300-0000000', 'Calle Falsa 123'
FROM usuarios WHERE email = 'cliente@demo.com';

-- Insertar destinos
INSERT INTO destinos (nombre, pais, descripcion) VALUES
('Cartagena', 'Colombia', 'Destino turístico en la costa caribeña'),
('Quito', 'Ecuador', 'Capital histórica andina');

-- Insertar paquetes
INSERT INTO paquetes (titulo, descripcion, precio, destino_id, disponibilidad)
SELECT 'Cartagena 3 noches', 'Paquete todo incluido a Cartagena', 450.00, d.id, 20
FROM destinos d WHERE d.nombre = 'Cartagena';

INSERT INTO paquetes (titulo, descripcion, precio, destino_id, disponibilidad)
SELECT 'Quito City Break', 'Escapada de 2 noches en Quito', 300.00, d.id, 15
FROM destinos d WHERE d.nombre = 'Quito';

-- Insertar reserva asociada al cliente y paquete
INSERT INTO reservas (cliente_id, paquete_id, estado, cantidad_personas)
SELECT c.id, p.id, 'CONFIRMADA', 2
FROM clientes c
JOIN paquetes p ON p.titulo = 'Cartagena 3 noches'
WHERE c.dni = '12345678';

COMMIT;
