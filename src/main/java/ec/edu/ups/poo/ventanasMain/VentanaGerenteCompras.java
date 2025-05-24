package ec.edu.ups.poo.ventanasMain;


import ec.edu.ups.poo.VentanaProveedor.VentanaProveedor;
import ec.edu.ups.poo.ventanaBusquedas.VentanaBusquedaAlimento;
import ec.edu.ups.poo.ventanaBusquedas.VentanaBusquedaProveedor;
import ec.edu.ups.poo.ventanaBusquedas.VentanaBusquedaTecnologia;
import ec.edu.ups.poo.ventanasMostrar.VentanaMostrarProductos;
import ec.edu.ups.poo.ventanasMostrar.VentanaMostrarProveedores;


import ec.edu.ups.poo.ventanasProducto.VentanaProducto;
import ec.edu.ups.poo.ventanasSolicitudes.VentanaAprobarRechazarSolicitud;


import java.awt.*;
import java.awt.event.*;
import ec.edu.ups.poo.clases.*;

import java.util.List;

public class VentanaGerenteCompras extends Frame {
    private Frame ventanaAnterior;
    private Empleado empleadoActual;
    private List<Producto> productos;
    private List<SolicitudCompra> solicitudes;
    private List<Proveedor> proveedores;
    private List<ProductoAlimento> productosAlimento;
    private List<ProductoTecnologia> productosTecnologia;

    public VentanaGerenteCompras(Frame ventanaAnterior, Empleado empleadoActual, List<Producto> productos,
                                 List<SolicitudCompra> solicitudes, List<Proveedor> proveedores,
                                 List<ProductoAlimento> productosAlimento, List<ProductoTecnologia> productosTecnologia) {
        this.ventanaAnterior = ventanaAnterior;
        this.empleadoActual = empleadoActual;
        this.productos = productos;
        this.solicitudes = solicitudes;
        this.proveedores = proveedores;
        this.productosAlimento = productosAlimento;
        this.productosTecnologia = productosTecnologia;

        Color azul = new Color(87, 124, 178);// Asignar un color

        setTitle("Gerencia de Compras");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("MENÚ DE GERENCIA", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        Panel panelTitulo = new Panel(new GridLayout(2,1));
        Panel panelTitulo2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo2.setBackground(Color.white);
        panelTitulo.setBackground(azul);
        panelTitulo.setPreferredSize(new Dimension(1500, 230));
        panelTitulo.add(titulo);
        panelTitulo.add(panelTitulo2);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel central
        Panel panelCentral = new Panel(new GridLayout(9, 1, 5, 5));
        panelCentral.setBackground(Color.WHITE);

        // Opciones con botones
        String[] descripciones = {
                "Registrar Proveedor",
                "Registrar Producto",
                "Ver lista de proveedores",
                "Ver lista de productos",
                "Buscar Proveedor por ID",
                "Buscar Producto Alimento por ID",
                "Buscar Producto Tecnología por ID",
                "Aprobar/Rechazar Solicitud"
        };

        for (int i = 0; i < descripciones.length; i++) {
            String texto = descripciones[i];

            Panel fila = new Panel(new FlowLayout(FlowLayout.CENTER, 30, 10));

            Label etiqueta = new Label(texto);
            etiqueta.setFont(new Font("Arial", Font.PLAIN, 18));
            etiqueta.setPreferredSize(new Dimension(400, 30));

            Button boton = new Button("Seleccionar");
            boton.setFont(new Font("Arial", Font.PLAIN, 14));

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (texto.equals("Registrar Proveedor")) {
                        registrarProveedor();
                    } else if (texto.equals("Registrar Producto")) {
                        registrarProducto();
                    } else if (texto.equals("Ver lista de proveedores")) {
                        verListaProveedores();
                    } else if (texto.equals("Ver lista de productos")) {
                        verListaProductos();
                    } else if (texto.equals("Buscar Proveedor por ID")) {
                        buscarProveedorPorId();
                    } else if (texto.equals("Buscar Producto Alimento por ID")) {
                        buscarProductoAlimento();
                    } else if (texto.equals("Buscar Producto Tecnología por ID")) {
                        buscarProductoTecnologia();
                    } else if (texto.equals("Aprobar/Rechazar Solicitud")) {
                        aprobarRechazarSolicitud();
                    }
                }
            });

            fila.add(etiqueta);
            fila.add(boton);

            panelCentral.add(fila);
        }

        // Panel inferior con botón volver
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(Color.lightGray);
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });
        panelInferior.add(btnVolver);

        // Agregar componentes a la ventana
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Cierre
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }


    private void registrarProveedor() {
        System.out.println(">> Acción: Registrar Proveedor");
        new VentanaProveedor(this, proveedores);
        dispose();
    }

    private void registrarProducto() {
        System.out.println(">> Acción: Registrar Producto");
        new VentanaProducto(this, proveedores, productosAlimento, productosTecnologia, productos);
        setVisible(false);
    }

    private void verListaProveedores() {
        System.out.println(">> Acción: Ver lista de proveedores");
        new VentanaMostrarProveedores(this, proveedores, productos,productosAlimento, productosTecnologia);
        setVisible(false);
    }

    private void verListaProductos() {
        System.out.println(">> Acción: Ver lista de productos");
        new VentanaMostrarProductos(this, productosTecnologia, productosAlimento);
        setVisible(false);
    }

    private void buscarProveedorPorId() {
        System.out.println(">> Acción: Buscar Proveedor por ID");
        new VentanaBusquedaProveedor(this, proveedores);
        setVisible(false);
    }

    private void buscarProductoAlimento() {
        System.out.println(">> Acción: Buscar Producto Alimento por Nombre");
        new VentanaBusquedaAlimento(this, productosAlimento);
        setVisible(false);
    }

    private void buscarProductoTecnologia() {
        System.out.println(">> Acción: Buscar Producto Tecnología por Nombre");
        new VentanaBusquedaTecnologia(this, productosTecnologia);
        setVisible(false);
    }

    private void aprobarRechazarSolicitud() {
        System.out.println(">> Acción: Aprobar/Rechazar Solicitud");
        setVisible(false);
        new VentanaAprobarRechazarSolicitud(solicitudes, empleadoActual, this);
    }
}