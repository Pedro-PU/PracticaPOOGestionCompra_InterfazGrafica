package ec.edu.ups.poo.main;

import ec.edu.ups.poo.clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Proveedor> proveedores = new ArrayList<>();
    private static List<ProductoAlimento> productosAlimento = new ArrayList<>();
    private static List<ProductoTecnologia> productosTecnologia = new ArrayList<>();
    public static void main(String[] args) {
        Departamento departamentoSolicitudes = new Departamento("Dep001", "Solicitudes");
        Departamento departamentoGerencia = new Departamento("Dep002", "Gerencia");

        Empleado empleadoSolicitudes = new Empleado("Emp001", "Juan Perez", "juanperez@gmail.com",
                "010101010", "Analista de Compras", departamentoSolicitudes);
        Empleado empleadoGerencia = new Empleado("Emp002", "Maria Sanchez", "mariasanchez@gmail.com",
                "020202020", "Gerente Compras", departamentoGerencia);

        // Crear Proveedores
        Proveedor proveedorFrutas = new Proveedor("Prov001", "Frutas del Valle", "frutas@gmail.com", "0999999999", "Alimentos");
        Proveedor proveedorElectronica = new Proveedor("Prov002", "ElectroTech", "electrotech@gmail.com", "0888888888", "Tecnología");

        // Crear Productos de Alimentos
        ProductoAlimento manzana = new ProductoAlimento("Prod001", "Manzana", 0.50, proveedorFrutas, 1.2);
        ProductoAlimento naranja = new ProductoAlimento("Prod002", "Naranja", 0.40, proveedorFrutas, 1.5);

        // Crear Productos de Tecnología
        ProductoTecnologia laptop = new ProductoTecnologia("Prod003", "Laptop", 800.00, proveedorElectronica, "Alta");
        ProductoTecnologia smartphone = new ProductoTecnologia("Prod004", "Smartphone", 600.00, proveedorElectronica, "Media");

        // Asociar Productos con los Proveedores
        proveedorFrutas.agregarProducto(manzana);
        proveedorFrutas.agregarProducto(naranja);
        proveedorElectronica.agregarProducto(laptop);
        proveedorElectronica.agregarProducto(smartphone);

        // Agregar Proveedores a la Lista Global
        proveedores.add(proveedorFrutas);
        proveedores.add(proveedorElectronica);

        productosAlimento.add(manzana);
        productosAlimento.add(naranja);
        productosTecnologia.add(laptop);
        productosTecnologia.add(smartphone);

        MenuSeleccionar mS = new MenuSeleccionar(proveedores, productosAlimento, productosTecnologia);

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====\n");
            System.out.println("Seleccione un empleado:");
            System.out.println("1. Juan Perez - Analista de Compras");
            System.out.println("2. Maria Sanchez - Gerente de Compras");
            System.out.print("Opción: ");
            int opcionUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcionUsuario) {
                case 1:
                    mS.menuAnalistaSolicitud(empleadoSolicitudes);
                    break;
                case 2:
                    mS.menuGerenteCompras(empleadoGerencia);
                    break;
            }
            String respuesta;
            do {
                System.out.println("¿Desea continuar? (S/N)");
                respuesta = sc.nextLine().trim();
            } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

            if (respuesta.equalsIgnoreCase("N")) {
                System.out.println("Gracias por usar el sistema.");
                continuar = false;
            }
        }
    }
}