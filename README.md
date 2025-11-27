# Agencia de Viaje

**Proyecto del Taller de Panel Administrativo**  
Tecnología de Desarrollos de Sistemas Informáticos  
📅 III Semestre 2025  
👨‍🏫 Profesor: Mag. Carlos Adolfo Beltrán Castro  
👨‍💻 Estudiantes: Francy Paola Barrera Martinez-108765887
                Albert Jair Jaime Pedraza-
                Zharick Galviz Vargas-

imagen de inicio de sesión
 <img width="1275" height="662" alt="image" src="https://github.com/user-attachments/assets/6fc425f2-9fca-4fa3-aae7-add14be1ee9a" />

Imagen de Pantalla Inicial con Menú del Proyecto         
<img width="1914" height="632" alt="image" src="https://github.com/user-attachments/assets/007da1b1-08ec-473c-8d67-67c59ea8a4d0" />

              
## 🚀 Descripción del Proyecto

Agencia de Viajes – Sistema de Gestión Web

La Agencia de Viajes es una aplicación web desarrollada en Spring Boot, Thymeleaf y Bootstrap, diseñada para facilitar la administración de una empresa turística.
El sistema permite gestionar de forma eficiente los destinos turísticos, clientes y usuarios del sistema, brindando una experiencia visual moderna e intuitiva.

A través de su panel de administración, los usuarios pueden registrar, actualizar y eliminar información clave, optimizando los procesos internos de la agencia.
Este proyecto combina una arquitectura limpia basada en MVC (Modelo–Vista–Controlador), una interfaz adaptable y efectos visuales modernos, ofreciendo una plataforma sólida, escalable y atractiva.

El sistema permite administrar:

- Destinos turísticos  
- Clientes  
- Usuarios  
- Paquetes turísticos  
- Reservas (módulo en desarrollo) 

## 📂 Estructura del Proyecto
<img width="413" height="777" alt="image" src="https://github.com/user-attachments/assets/69f78c65-db69-4139-bbd7-0aed485ed795" />




---

## ⚙️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Thymeleaf**
- **Bootstrap 5**
- **HTML5 / CSS3**
- **Maven**
- **Spring Data JPA**
- **MySQL**
- **Spring Security (en proceso)**

---

## 🚀 Instrucciones de Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/francybarrera02/agencia-viajes-spring-thyl.git

✨ Funcionalidades Principales

Gestión de Destinos: creación, edición, listado y eliminación de destinos turísticos.
Gestión de Usuarios: administración de cuentas internas para el sistema.
Gestión de Clientes: registro, actualización y eliminación de clientes.
Gestión de Paquetes: módulo para administrar paquetes turísticos.
Gestión de Reservas: registro y control de reservas realizadas.
Interfaz Moderna: diseño visual con tarjetas de colores, transparencias y fondo institucional.
Sección “Acerca de”: visualización de información del sistema, créditos y derechos reservados.

Futuras Mejoras

Implementación avanzada del módulo de reservas de paquetes turísticos.
Sistema de roles y autenticación (administrador, agente y cliente).
Generación de reportes PDF y estadísticas de destinos más visitados.
Integración con pasarelas de pago.
Dashboard con gráficas dinámicas e interactivas.


# Agencia de Viajes - Proyecto Spring Boot

Proyecto académico desarrollado con:
- Spring Boot
- Thymeleaf
- MySQL
- Bootstrap 5
- pring Security (en proceso)


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
  id_destino CHAR(36),
  disponibilidad INT DEFAULT 0,
  FOREIGN KEY (id_destino) REFERENCES destinos(id) ON DELETE SET NULL
);

-- ==============================================
-- DATOS DE EJEMPLO
-- ==============================================

INSERT INTO usuarios (nombre, email, password_hash, rol) VALUES
('Admin Demo', 'admin@demo.com', 'hash_demo_admin', 'ADMIN'),
('Agente Demo', 'agente@demo.com', 'hash_demo_agente', 'AGENTE'),
('Cliente Demo', 'cliente@demo.com', 'hash_demo_cliente', 'CLIENTE');

-- Insertar cliente asociado al usuario 'cliente@demo.com'
INSERT INTO clientes (usuario_id, dni, telefono, direccion)
SELECT id, '12345678', '‪+57-300-0000000‬', 'Calle Falsa 123'
FROM usuarios WHERE email = 'cliente@demo.com';

-- Insertar destinos
INSERT INTO destinos (nombre, pais, descripcion) VALUES
('Cartagena', 'Colombia', 'Destino turístico en la costa caribeña'),
('Quito', 'Ecuador', 'Capital histórica andina');

-- Insertar paquetes
INSERT INTO paquetes (titulo, descripcion, precio, id_destino, disponibilidad)
SELECT 'Cartagena 3 noches', 'Paquete todo incluido a Cartagena', 450.00, d.id, 20
FROM destinos d WHERE d.nombre = 'Cartagena';

INSERT INTO paquetes (titulo, descripcion, precio, id_destino, disponibilidad)
SELECT 'Quito City Break', 'Escapada de 2 noches en Quito', 300.00, d.id, 15
FROM destinos d WHERE d.nombre = 'Quito';


INSERT INTO reservas 
(id, cliente_id, paquete_id, fecha_reserva, fecha_viaje, estado, cantidad_personas)
VALUES
(UUID(), 
 '1a2b3c4d-5678-90ef-abcd-123456789000', 
 '9f8e7d6c-5432-10ab-cdef-001122334455',
 NOW(),
 '2025-02-15',
 'CONFIRMADA',
 2);

select * from usuarios u ;
select * from reservas;

ALTER TABLE reservas
ADD COLUMN total DECIMAL(10,2) NOT NULL DEFAULT 0;

DROP TABLE IF EXISTS reservas;

CREATE TABLE reservas (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  
  -- 1. id del usuario (vinculado a clientes)
  cliente_id CHAR(36) NOT NULL, 
  
  -- 2. Paquete
  paquete_id CHAR(36) NOT NULL, 
  
  fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  fecha_viaje DATE, -- Campo opcional para especificar la fecha del viaje
  
  -- Estado ajustado para la compra inmediata
  -- El estado por defecto será 'PAGADA' ya que es un módulo de "Compra"
  estado ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA', 'PAGADA') DEFAULT 'PAGADA', 
  
  -- 3. Cantidad de personas (para descuento y cálculo)
  cantidad_personas INT NOT NULL DEFAULT 1, 
  
  -- 4. Total a pagar (Precio * Personas)
  total DECIMAL(10,2) NOT NULL, 
  
  -- Foreign Keys
  FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE,
  FOREIGN KEY (paquete_id) REFERENCES paquetes(id) ON DELETE RESTRICT -- Recomendado: no permitir eliminar un paquete si tiene ventas
);
<img width="680" height="494" alt="image" src="https://github.com/user-attachments/assets/40e1ab43-0935-44b6-8824-7bda41309202" />




COMMIT;
