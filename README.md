# Agencia de Viaje

**Proyecto del Taller de Panel Administrativo**  
Tecnología de Desarrollos de Sistemas Informáticos  
📅 II Semestre 2025  
👨‍🏫 Profesor: Mag. Carlos Adolfo Beltrán Castro  
👨‍💻 Estudiantes: Francy Paola Barrera Martinez-108765887
                Albert Jair Jaime Pedraza-
                Zharick Galviz Vargas-
                
  ![menuprincipal](https://github.com/user-attachments/assets/c1d8dfdf-a1ce-4e4d-8bbe-2e6cddd84397)
              
Imagen de Pantalla Inicial con Menú del Proyecto
## 🚀 Descripción del Proyecto

Agencia de Viajes – Sistema de Gestión Web

La Agencia de Viajes es una aplicación web desarrollada en Spring Boot, Thymeleaf y Bootstrap, diseñada para facilitar la administración de una empresa turística.
El sistema permite gestionar de forma eficiente los destinos turísticos, clientes y usuarios del sistema, brindando una experiencia visual moderna e intuitiva.

A través de su panel de administración, los usuarios pueden registrar, actualizar y eliminar información clave, optimizando los procesos internos de la agencia.
Este proyecto combina una arquitectura limpia basada en MVC (Modelo–Vista–Controlador), una interfaz adaptable y efectos visuales modernos, ofreciendo una plataforma sólida, escalable y atractiva.


## 📂 Estructura del Proyecto

AgenciaViajes
│
├── src
│ ├── main
│ │ ├── java
│ │ │ └── uts.edu.java.agencia
│ │ │ ├── AgenciaViajesApplication.java
│ │ │ ├── controlador
│ │ │ │ ├── AcercaDeControlador.java
│ │ │ │ ├── AppController.java
│ │ │ │ ├── ClienteControlador.java
│ │ │ │ ├── DestinoControlador.java
│ │ │ │ ├── PaqueteControlador.java
│ │ │ │ └── UsuarioControlador.java
│ │ │ ├── modelo
│ │ │ │ ├── Cliente.java
│ │ │ │ ├── Destino.java
│ │ │ │ ├── Paquete.java
│ │ │ │ └── Usuario.java
│ │ │ ├── repositorio
│ │ │ │ ├── ClienteRepositorio.java
│ │ │ │ ├── DestinoRepositorio.java
│ │ │ │ ├── PaqueteRepositorio.java
│ │ │ │ └── UsuarioRepositorio.java
│ │ │ └── servicio
│ │ │ ├── ClienteServicio.java
│ │ │ ├── DestinoServicio.java
│ │ │ ├── IClienteServicio.java
│ │ │ ├── IDestinoServicio.java
│ │ │ ├── IPaqueteServicio.java
│ │ │ ├── IUsuarioServicio.java
│ │ │ ├── PaqueteServicio.java
│ │ │ └── UsuarioServicio.java
│ │ └── resources
│ │ ├── static
│ │ │ └── img
│ │ │ ├── agencia.png
│ │ │ └── fondo_home.png
│ │ └── templates
│ │ └── views
│ │ ├── acercade
│ │ │ └── acercade.html
│ │ ├── clientes
│ │ │ ├── clientes.html
│ │ │ ├── editar_cliente.html
│ │ │ └── nuevo_cliente.html
│ │ ├── destinos
│ │ │ ├── destinos.html
│ │ │ ├── editar_destino.html
│ │ │ └── nuevo_destino.html
│ │ ├── paquetes
│ │ └── usuarios
│ │ ├── editar_usuario.html
│ │ ├── nuevo_usuario.html
│ │ └── usuarios.html
│ │ └── home.html
│ └── test
│
├── pom.xml


---

## ⚙️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Thymeleaf**
- **Bootstrap 5**
- **HTML5 / CSS3**
- **Maven**
- **Spring Data JPA**

---

## 🚀 Instrucciones de Ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/francybarrera02/agencia-viajes-spring-thyl.git

✨ Funcionalidades Principales

Gestión de Clientes: registrar, editar y eliminar clientes.
Gestión de Destinos: administrar destinos turísticos con información detallada.
Gestión de Usuarios: control de acceso y mantenimiento de usuarios.
Interfaz moderna: diseño adaptado con imágenes, transparencias y fondo institucional.
Sección "Acerca de": descripción visual del sistema con créditos y derechos reservados.

🔮 Futuras Mejoras

Módulo de reservas de paquetes turísticos.
Autenticación y roles de usuario (administrador, agente, cliente).
Reportes PDF y estadísticas de destinos más visitados.
Integración con pasarelas de pago.
Panel de control con gráficas dinámicas.


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

![diagrama](https://github.com/user-attachments/assets/5dfc4077-266f-4afc-a808-78550ea2943c)



COMMIT;
