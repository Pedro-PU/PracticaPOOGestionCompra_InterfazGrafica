# Práctica de Laboratorio 02: Sistema de Gestión de Compras ERP CON INTERFAZ GRÁFICA

## 📌 Información General

- **Título:** Sistema de Gestión de Compras ERP
- **Asignatura:** Programación Orientada a Objetos
- **Carrera:** Computación
- **Integrantes:** Jonnathan Saavedra, Pedro Pesántez y Mathias Añazco
- **Profesor:** PhD. Gabriel A. León Paredes

---

## 🛠️ Descripción del Proyecto

Esta aplicación simula un módulo de gestión de compras de un sistema ERP, implementando:

- Registro de proveedores y productos
- Gestión de solicitudes de compra
- Control de estados (Pendiente/Aprobada/Rechazada)
- Cálculo automático de totales
- Interfaz gráfica para una mejor experiencia de usuario

---

## 🖼️ Diagrama de Clases
![Diagrama UML de clases](https://github.com/user-attachments/assets/a1792413-743f-4a0a-acd9-0690e0c4fca1)

---
## 📂 Estructura del Proyecto

Esta aplicación esta compuesta por 11 paquetes que separan las ventanas de una manera más ordenada.
De los cuales los paquetes más importantes son main y ventanasMain. Dentro del paquete main se encuentra la clase App.java que es la clase principal del proyecto, y dentro del paquete ventanasMain se encuentran las ventanas de la aplicación.

---

## 💡 Información general del funcionamiento dentro del proyecto

El sistema permite a los usuarios gestionar proveedores y productos, así como realizar solicitudes de compra que pueden ser aprobadas o rechazadas por un gerente. 

Para esto tenemos dos tipos de usuarios: Analista de Compras y Gerente de Compras. El analista puede registrar solicitudes, buscarlas solicitudes por ID o listarlas mientras que el gerente puede registrar proveedores, productos aprobar o rechazar solicitudes y listas con información de los mismos.

Al momento de registrar un proveedor, se solicita el ID, nombre, correo, RUC y rubro del proveedor. Para los productos, se solicita el ID, nombre, precio y tipo (Alimento o Tecnología). Las solicitudes incluyen un número de solicitud, fecha, proveedor y productos solicitados.

Además, tenemos que saber que podemos registrar varios productos y varios proveedores, pero el sistema solo acepta un proveedor por producto. Sin embargo, un proveedor puede tener varios productos registrados.

---
## 📄 Convenciones de Nomenclatura
El sistema ya cuenta con varios datos generados por defecto, por lo que al momento de ejecutar el programa no es necesario ingresar datos, pero si se desea ingresar nuevos datos, se puede hacer sin problemas.

Para generar un proveedor según la convención del proyecto se espera que se genere un ID de proveedor que comience con las siglas "Prov" seguida de un número, por ejemplo: Prov001, Prov002, etc.

Para los productos, el ID debe comenzar con las siglas "Prod" seguida de un número, por ejemplo: Prod001, Prod002, etc.

Y finalemnte, para las solicitudes de compra, el ID debe comenzar con la letra "S" seguida de un número, por ejemplo: S001, S002, etc.

---

## 🚀 Ejecución

Para ejecutar el proyecto:

1. Compila el código:
    ```bash
    javac App.java
    ```
2. Ejecuta la aplicación:
    ```bash
    java App
    ```

---

## 🧑‍💻 Previsualización de la Aplicación
### Pantalla de Inicio
![Pantalla de Inicio](https://github.com/user-attachments/assets/5563fbf1-4d8e-4e80-a5ec-8765890f1cb6)
### Ventana de Proveedores
![Ventana de Proveedores](https://github.com/user-attachments/assets/df34674e-ffb7-48fd-9a76-3e33f5d2310b)
### Ventana de Productos
![Ventana de Productos](https://github.com/user-attachments/assets/4bd4aaf5-722c-4f9a-9fdb-52351a2968ee)
### Ventana de Solicitudes
![Ventana de Solicitudes](https://github.com/user-attachments/assets/3eea15ea-e3dc-435a-b578-551c090e13d6)

---
## 👥 Créditos

- Desarrollado por: Jonnathan Saavedra, Pedro Pesántez y Mathias Añazco
- Carrera: Computación
- Curso: Programación Orientada a Objetos
- Docente: PhD. Gabriel A. León Paredes
---

