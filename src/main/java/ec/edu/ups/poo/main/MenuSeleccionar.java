package ec.edu.ups.poo.main;

import ec.edu.ups.poo.clases.*;
import ec.edu.ups.poo.enums.EstadoSolicitud;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class MenuSeleccionar {
    private List<Proveedor> proveedores;
    private List<ProductoAlimento> productosAlimento;
    private List<ProductoTecnologia> productosTecnologia;
    private List<SolicitudCompra> solicitudes = new ArrayList<>();
    private Scanner sc;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public MenuSeleccionar(List<Proveedor> proveedores, List<ProductoAlimento> productosAlimento,
                           List<ProductoTecnologia> productosTecnologia) {
        this.proveedores = proveedores;
        this.productosAlimento = productosAlimento;
        this.productosTecnologia = productosTecnologia;
        this.sc = new Scanner(System.in);
    }

    public void menuGerenteCompras(Empleado empleadoGerencia) {
        System.out.println("-".repeat(37));
        System.out.println("--Departamento de Gerencia--");
        System.out.println("1. Registrar Proveedor");
        System.out.println("2. Registrar Producto");
        System.out.println("3. Ver lista de proveedores");
        System.out.println("4. Ver lista de productos");
        System.out.println("5. Buscar Proveedor por ID");
        System.out.println("6. Buscar Producto Alimento por Nombre");
        System.out.println("7. Buscar Producto Tecnología por Nombre");
        System.out.println("8. Buscar Solicitud por Número");
        System.out.println("9. Aprobar/Rechazar Solicitud");
        System.out.print("Opción: ");
        int opcionGerencia = sc.nextInt();
        sc.nextLine();

        switch (opcionGerencia) {
            case 1:
                registrarProveedor();
                break;
            case 2:
                registrarProducto();
                break;
            case 3:
                imprimirProveedores();
                break;
            case 4:
                imprimirProductos();
                break;
            case 5:
                buscarProveedorId();
                break;
            case 6:
                buscarProductoAlimentoNombre();
                break;
            case 7:
                buscarProductoTecnologíaNombre();
                break;
            case 8:
                buscarSolicitudPorNum();
                break;
            case 9:
                aprobarRechazarSolicitud(empleadoGerencia);
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }

    private void registrarProveedor() {
        System.out.println("-".repeat(37));
        System.out.println("--Sistema de Creación de Proveedores--");
        System.out.println("¿Cuántos proveedores desea registrar?");
        System.out.print("Opción: ");
        int nProveedores = sc.nextInt();
        sc.nextLine();
        System.out.println("-".repeat(37));

        for (int i = 0; i < nProveedores; i++) {
            Proveedor nP = new Proveedor();
            System.out.println("REGISTRO DE PROVEEDOR " + (i + 1));
            System.out.print("Ingrese el ID del proveedor: "); nP.setIdPersona(sc.nextLine());
            System.out.print("Nombre del proveedor: "); nP.setNombre(sc.nextLine());
            System.out.print("Ingrese el correo del proveedor: "); nP.setCorreo(sc.nextLine());
            System.out.print("Ingrese el RUC del proveedor: "); nP.setRuc(sc.nextLine());
            System.out.print("Ingrese el rubro del proveedor: "); nP.setRubro(sc.nextLine());
            System.out.println("-".repeat(37));
            proveedores.add(nP);
        }
    }

    private void registrarProducto() {
        System.out.println("-".repeat(37));
        System.out.println("--Sistema de Creación de Productos--");
        System.out.println("1. Crear Producto Alimento");
        System.out.println("2. Crear Producto Tecnología");
        System.out.print("Opción: ");
        int opcionProducto = sc.nextInt();
        sc.nextLine();

        if (opcionProducto == 1) {
            registrarProductoAlimento();
        } else if (opcionProducto == 2) {
            registrarProductoTecnologia();
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private void registrarProductoAlimento() {
        System.out.println("-".repeat(37));
        System.out.println("--Sistema de Creación de Productos Alimento--");
        System.out.println("¿Cuántos productos desea registrar?");
        System.out.print("Opción: ");
        int nProductos = sc.nextInt();
        sc.nextLine();
        System.out.println("-".repeat(37));

        for (int i = 0; i < nProductos; i++) {
            ProductoAlimento pA = new ProductoAlimento();
            System.out.println("REGISTRO DE PRODUCTO ALIMENTO " + (i + 1));
            System.out.print("Ingrese el ID del producto: "); pA.setCodigo(sc.nextLine());
            System.out.print("Ingrese el nombre del producto: "); pA.setNombre(sc.nextLine());
            System.out.print("Ingrese el precio del producto: "); pA.setPrecioUnitario(sc.nextDouble());
            System.out.print("Ingrese el peso del alimento: "); pA.setPeso(sc.nextDouble());
            sc.nextLine();
            System.out.println("-".repeat(37));

            Proveedor proveedorSeleccionado = buscarProveedor();
            if (proveedorSeleccionado != null) {
                pA.setProveedor(proveedorSeleccionado);
                proveedorSeleccionado.agregarProducto(pA);
                System.out.println("Producto agregado al proveedor: " + proveedorSeleccionado.getNombre());
            }
            productosAlimento.add(pA);
        }
    }

    private void registrarProductoTecnologia() {
        System.out.println("-".repeat(37));
        System.out.println("--Sistema de Creación de Productos Tecnología--");
        System.out.print("Cuántos productos desea registrar: ");
        int nProductosTecnologia = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nProductosTecnologia; i++) {
            ProductoTecnologia pT = new ProductoTecnologia();
            System.out.print("Ingrese el ID del producto: "); pT.setCodigo(sc.nextLine());
            System.out.print("Ingrese el nombre del producto: "); pT.setNombre(sc.nextLine());
            System.out.print("Ingrese el precio del producto: "); pT.setPrecioUnitario(sc.nextDouble());
            System.out.print("Ingrese la gama del producto: "); sc.nextLine();
            pT.setGama(sc.nextLine());
            System.out.println("-".repeat(37));

            Proveedor proveedorSeleccionado = buscarProveedor();
            if (proveedorSeleccionado != null) {
                pT.setProveedor(proveedorSeleccionado);
                proveedorSeleccionado.agregarProducto(pT);
                System.out.println("Producto agregado al proveedor: " + proveedorSeleccionado.getNombre());
            }

            productosTecnologia.add(pT);
        }
    }

    private Proveedor buscarProveedor() {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados. Registre uno primero.");
            return null;
        }

        Proveedor instanciaProveedor = new Proveedor();
        instanciaProveedor.imprimirProveedores(proveedores);

        Proveedor proveedorSeleccionado = null;

        while (proveedorSeleccionado == null) {
            System.out.print("Ingrese el ID del proveedor: ");
            String idProveedor = sc.nextLine();

            for (Proveedor p : proveedores) {
                if (p.getIdPersona().equals(idProveedor)) {
                    proveedorSeleccionado = p;
                    break;
                }
            }

            if (proveedorSeleccionado == null) {
                System.out.println("Proveedor no encontrado. Inténtelo nuevamente.");
            }
        }
        return proveedorSeleccionado;
    }

    private Proveedor buscarProveedorId() {
        System.out.println("-".repeat(37));
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados. Registre uno primero.");
            return null;
        }

        Proveedor proveedorSeleccionado = null;

        while (proveedorSeleccionado == null) {
            System.out.print("Ingrese el ID del proveedor: ");
            String idProveedor = sc.nextLine();

            for (Proveedor p : proveedores) {
                if (p.getIdPersona().trim().equals(idProveedor.trim())) {
                    proveedorSeleccionado = p;
                    break;
                }
            }

            if (proveedorSeleccionado == null) {
                System.out.println("Proveedor no encontrado. Inténtelo nuevamente.");
            } else {
                System.out.println("Proveedor encontrado: " + proveedorSeleccionado.getNombre() + " | " +
                        "RUC: " + proveedorSeleccionado.getRuc() + " | " +
                        "Rubro: " + proveedorSeleccionado.getRubro() + " | " +
                        "Correo: " + proveedorSeleccionado.getCorreo());
            }
        }
        return proveedorSeleccionado;
    }

    private void buscarSolicitudPorNum() {

        System.out.println("\n--- BUSCAR SOLICITUD POR NÚMERO ---");
        System.out.print("Ingrese el ID de la solicitud: ");
        String idSolicitud = sc.nextLine();

        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getIdSolicitud().equals(idSolicitud)) {
                System.out.println("\nSolicitud encontrada:");
                System.out.println("ID: " + solicitud.getIdSolicitud());
                System.out.println("Fecha: " + formatoFecha.format(solicitud.getFecha().getTime()));
                System.out.println("Solicitante: " + solicitud.getSolicitante().getNombre());
                System.out.println("Estado: " + solicitud.getEstado());
                System.out.println("Items:");

                for (ItemSolicitud item : solicitud.getItems()) {
                    System.out.println("- " + item.getProducto().getNombre() +
                            " | Cantidad: " + item.getCantidad() +
                            " | Subtotal: $" + item.calcularTotal());
                }
                System.out.println("Total: $" + solicitud.calcularTotal());
                return;
            }
        }
        System.out.println("¡Solicitud no encontrada!");
    }

    private Producto buscarProductoAlimentoNombre() {
        System.out.println("-".repeat(37));
        if (productosAlimento.isEmpty()) {
            System.out.println("No hay productos registrados. Registre uno primero.");
            return null;
        }

        ProductoAlimento productoSeleccionado = null;

        while (productoSeleccionado == null) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = sc.nextLine();

            for (ProductoAlimento p : productosAlimento) {
                if (p.getNombre().trim().equals(nombreProducto.trim())) {
                    productoSeleccionado = p;
                    break;
                }
            }

            if (productoSeleccionado == null) {
                System.out.println("Producto no encontrado. Inténtelo nuevamente.");
            } else {
                System.out.println("Producto encontrado: NOMBRE: " + productoSeleccionado.getNombre() + " | " +
                        "PRECIO UNITARIO: " + productoSeleccionado.getPrecioUnitario() + " | " +
                        "PROVEEDOR: " + productoSeleccionado.getProveedor().getNombre());
            }
        }
        return productoSeleccionado;
    }

    private Producto buscarProductoTecnologíaNombre() {
        System.out.println("-".repeat(37));
        if (productosTecnologia.isEmpty()) {
            System.out.println("No hay productos registrados. Registre uno primero.");
            return null;
        }

        ProductoTecnologia productoSeleccionado = null;

        while (productoSeleccionado == null) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = sc.nextLine();

            for (ProductoTecnologia p : productosTecnologia) {
                if (p.getNombre().trim().equals(nombreProducto.trim())) {
                    productoSeleccionado = p;
                    break;
                }
            }

            if (productoSeleccionado == null) {
                System.out.println("Producto no encontrado. Inténtelo nuevamente.");
            } else {
                System.out.println("Producto encontrado: " + productoSeleccionado.getNombre() + " | " +
                        "PRECIO UNITARIO: " + productoSeleccionado.getPrecioUnitario() + " | " +
                        "PROVEEDOR: " + productoSeleccionado.getProveedor().getNombre());
            }
        }
        return productoSeleccionado;
    }

    private void imprimirProveedores() {
        System.out.println("-".repeat(37));
        System.out.println("--Lista de Proveedores--");
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            Proveedor instanciaProveedor = new Proveedor();
            instanciaProveedor.imprimirProveedores(proveedores);
        }
    }

    private void imprimirProductos() {
        System.out.println("-".repeat(37));
        System.out.println("--Lista de Productos Alimenticios--");
        if (productosAlimento.isEmpty()) {
            System.out.println("No hay productos alimenticios registrados.");
        } else {
            ProductoAlimento instanciaProductoAlimento = new ProductoAlimento();
            instanciaProductoAlimento.imprimirProductoAlimento(productosAlimento);
            System.out.println();
        }

        System.out.println("--Lista de Productos de Tecnología--");
        if (productosTecnologia.isEmpty()) {
            System.out.println("No hay productos de tecnología registrados.");
        } else {
            ProductoTecnologia instanciaProductoTecnologia = new ProductoTecnologia();
            instanciaProductoTecnologia.imprimirProductoTecnologia(productosTecnologia);
        }
    }

    private SolicitudCompra buscarSolicitud(String idSolicitud) {
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getIdSolicitud().equals(idSolicitud)) {
                return solicitud;
            }
        }
        return null;
    }

    private void aprobarRechazarSolicitud(Empleado empleado) {
        if (solicitudes == null || solicitudes.isEmpty()) {
            System.out.println("\nNo hay solicitudes registradas.");
            return;
        }


        System.out.println("\n--- SOLICITUDES PENDIENTES ---");
        for (SolicitudCompra sc : solicitudes) {
            if (sc.getEstado() == EstadoSolicitud.PENDIENTE) {
                System.out.println("ID: " + sc.getIdSolicitud() + " | Solicitante: " +
                        sc.getSolicitante().getNombre() + " | Total: $" + sc.calcularTotal());
            }
        }

        System.out.print("\nIngrese el ID de la solicitud: ");
        String idSolicitud = sc.nextLine();

        SolicitudCompra solicitud = buscarSolicitud(idSolicitud);
        if (solicitud == null || solicitud.getEstado() != EstadoSolicitud.PENDIENTE) {
            System.out.println("Solicitud no válida o ya procesada.");
            return;
        }

        System.out.println("1. Aprobar");
        System.out.println("2. Rechazar");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            empleado.aceptaSolicitud(solicitud);
            System.out.println("Solicitud aprobada.");
        } else {
            empleado.rechazarSolicitud(solicitud);
            System.out.println("Solicitud rechazada.");
        }
    }

//----------------------------------------------------------------------------------

    public void menuAnalistaSolicitud(Empleado empleadoSolicitudes) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n-- Departamento de Solicitudes --");
            System.out.println("1. Crear solicitud de compra");
            System.out.println("2. Listar solicitudes de compra");
            System.out.println("3. Buscar solicitud por número");
            System.out.println("4. Volver al menú principal");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearSolicitudCompra(empleadoSolicitudes);
                    break;
                case 2:
                    listarSolicitudes();
                    break;
                case 3:
                    buscarSolicitudPorNumero();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida!");
            }
        }
    }

    private void crearSolicitudCompra(Empleado empleado) {
        System.out.println("\n--- CREAR SOLICITUD DE COMPRA ---");
        System.out.print("Ingrese el ID de la solicitud: ");
        String idSolicitud = sc.nextLine();

        // Solicitar la fecha de la solicitud al usuario
        System.out.println("Ingrese la fecha de la solicitud (yyyy-mm-dd)");
        System.out.print("Ingrese el día: ");
        int dia = sc.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = sc.nextInt() - 1;
        System.out.print("Ingrese el año: ");
        int anio = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        GregorianCalendar fechaSolicitud = new GregorianCalendar(anio, mes, dia);

        List<ItemSolicitud> items = new ArrayList<>();
        boolean agregarMasItems = true;

        while (agregarMasItems) {
            System.out.println("\nProductos disponibles:");
            listarProductos(); // Muestra lista de productos registrados

            System.out.print("\nIngrese el código del producto: ");
            String codigoProducto = sc.nextLine();

            Producto producto = buscarProducto(codigoProducto);
            if (producto == null) {
                System.out.println("¡Producto no encontrado!");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            items.add(new ItemSolicitud(producto, cantidad));

            System.out.print("¿Desea agregar otro producto? (S/N): ");
            agregarMasItems = sc.nextLine().equalsIgnoreCase("S");
        }

        // ✅ Ahora usamos el método del Empleado para crear la solicitud
        SolicitudCompra solicitud = empleado.crearSolicitud(idSolicitud, fechaSolicitud, items);

        solicitudes.add(solicitud); // Agregamos la solicitud a la lista general
        System.out.println("\n¡Solicitud creada exitosamente!");
        System.out.println("Total: $" + solicitud.calcularTotal());
    }


    private void listarSolicitudes() {
        if (solicitudes == null || solicitudes.isEmpty()) {
            System.out.println("\nNo hay solicitudes registradas.");
            return;
        }


        System.out.println("\n--- LISTA DE SOLICITUDES ---");
        for (SolicitudCompra solicitud : solicitudes) {
            System.out.println("ID: " + solicitud.getIdSolicitud());
            System.out.println("Fecha: " + solicitud.getFecha().getTime());
            System.out.println("Solicitante: " + solicitud.getSolicitante().getNombre());
            System.out.println("Estado: " + solicitud.getEstado());
            System.out.println("Total: $" + solicitud.calcularTotal());
            System.out.println("--------------------------");
        }
    }

    private void buscarSolicitudPorNumero() {
        System.out.println("\n--- BUSCAR SOLICITUD POR NÚMERO ---");
        System.out.print("Ingrese el ID de la solicitud: ");
        String idSolicitud = sc.nextLine();

        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getIdSolicitud().equals(idSolicitud)) {
                System.out.println("\nSolicitud encontrada:");
                System.out.println("ID: " + solicitud.getIdSolicitud());
                System.out.println("Fecha: " + formatoFecha.format(solicitud.getFecha().getTime()));
                System.out.println("Solicitante: " + solicitud.getSolicitante().getNombre());
                System.out.println("Estado: " + solicitud.getEstado());
                System.out.println("Items:");

                for (ItemSolicitud item : solicitud.getItems()) {
                    System.out.println("- " + item.getProducto().getNombre() +
                            " | Cantidad: " + item.getCantidad() +
                            " | Subtotal: $" + item.calcularTotal());
                }
                System.out.println("Total: $" + solicitud.calcularTotal());
                return;
            }
        }
        System.out.println("¡Solicitud no encontrada!");
    }

    // Método auxiliar para buscar productos (usado en crearSolicitudCompra)
    private Producto buscarProducto(String codigo) {
        for (ProductoAlimento pa : productosAlimento) {
            if (pa.getCodigo().equals(codigo)) {
                return pa;
            }
        }
        for (ProductoTecnologia pt : productosTecnologia) {
            if (pt.getCodigo().equals(codigo)) {
                return pt;
            }
        }
        return null;
    }

    // Método auxiliar para listar productos (usado en crearSolicitudCompra)
    private void listarProductos() {
        System.out.println("\n--- PRODUCTOS ALIMENTICIOS ---");
        if (productosAlimento.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (ProductoAlimento pa : productosAlimento) {
                System.out.println("Código: " + pa.getCodigo() + " | Nombre: " + pa.getNombre() +
                        " | Precio: $" + pa.getPrecioUnitario());
            }
        }

        System.out.println("\n--- PRODUCTOS TECNOLÓGICOS ---");
        if (productosTecnologia.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (ProductoTecnologia pt : productosTecnologia) {
                System.out.println("Código: " + pt.getCodigo() + " | Nombre: " + pt.getNombre() +
                        " | Precio: $" + pt.getPrecioUnitario());
            }
        }
    }

    //GGs
}
