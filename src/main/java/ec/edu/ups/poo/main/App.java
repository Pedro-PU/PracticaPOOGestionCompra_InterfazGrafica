package ec.edu.ups.poo.main;

import ec.edu.ups.poo.enums.EstadoSolicitud;
import ec.edu.ups.poo.ventanasMain.VentanaPrincipal;
import ec.edu.ups.poo.clases.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<ProductoAlimento> productosAlimento = new ArrayList<>();
    private static List<ProductoTecnologia> productosTecnologia = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    private static List<SolicitudCompra> solicitudes = new ArrayList<>();

    public static void main(String[] args) {
        // Crear departamentos
        Departamento departamentoSolicitudes = new Departamento("Dep001", "Solicitudes");
        Departamento departamentoGerencia = new Departamento("Dep002", "Gerencia");

        // Crear empleados
        Empleado empleadoSolicitudes = new Empleado("Emp001", "Juan Perez", "juanperez@gmail.com",
                "010101010", "Analista de Compras", departamentoSolicitudes);
        Empleado empleadoGerencia = new Empleado("Emp002", "Maria Sanchez", "mariasanchez@gmail.com",
                "020202020", "Gerente Compras", departamentoGerencia);

        // Crear proveedores
        Proveedor proveedorFrutas = new Proveedor("Prov001", "Frutas del Valle", "frutas@gmail.com", "0999999999", "Alimentos");
        Proveedor proveedorElectronica = new Proveedor("Prov002", "ElectroTech", "electrotech@gmail.com", "0888888888", "Tecnología");

        // Crear productos
        ProductoAlimento manzana = new ProductoAlimento("Prod001", "Manzana", 0.50, proveedorFrutas, 1.2);
        ProductoAlimento naranja = new ProductoAlimento("Prod002", "Naranja", 0.40, proveedorFrutas, 1.5);
        ProductoTecnologia laptop = new ProductoTecnologia("Prod003", "Laptop", 800.00, proveedorElectronica, "Alta");
        ProductoTecnologia smartphone = new ProductoTecnologia("Prod004", "Smartphone", 600.00, proveedorElectronica, "Media");

        // Asociar productos a proveedores
        proveedorFrutas.agregarProducto(manzana);
        proveedorFrutas.agregarProducto(naranja);
        proveedorElectronica.agregarProducto(laptop);
        proveedorElectronica.agregarProducto(smartphone);

        // Agregar proveedores a lista global
        proveedores.add(proveedorFrutas);
        proveedores.add(proveedorElectronica);

        // Agregar productos a listas globales y a lista compartida
        productosAlimento.add(manzana);
        productosAlimento.add(naranja);
        productosTecnologia.add(laptop);
        productosTecnologia.add(smartphone);

        productos.add(manzana);
        productos.add(naranja);
        productos.add(laptop);
        productos.add(smartphone);

        // Crear solicitudes de compra
        SolicitudCompra solicitud1 = new SolicitudCompra("S001", new GregorianCalendar(2025, 0, 1), empleadoSolicitudes);
        solicitud1.agregarItem(manzana, 2);
        solicitud1.agregarItem(laptop, 1);
        solicitudes.add(solicitud1);

        SolicitudCompra solicitud2 = new SolicitudCompra("S002", new GregorianCalendar(2025, 0, 15), empleadoSolicitudes);
        solicitud2.agregarItem(naranja, 5);
        solicitud2.agregarItem(smartphone, 2);
        solicitudes.add(solicitud2);


        // Lanzar ventana principal
        new VentanaPrincipal(empleadoSolicitudes, empleadoGerencia, productos, solicitudes, proveedores, productosAlimento,
                productosTecnologia);
    }
}