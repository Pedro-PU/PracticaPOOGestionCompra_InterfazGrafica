package ec.edu.ups.poo.ventanasMain;

import java.awt.*;
import java.awt.event.*;

public class VentanaGerenteCompras extends Frame {

    public VentanaGerenteCompras() {
        setTitle("Gerencia de Compras");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("MENÚ DE GERENCIA", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        add(titulo, BorderLayout.NORTH);

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
                "Buscar Producto Alimento por Nombre",
                "Buscar Producto Tecnología por Nombre",
                "Buscar Solicitud por Número",
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
                    } else if (texto.equals("Buscar Producto Alimento por Nombre")) {
                        buscarProductoAlimento();
                    } else if (texto.equals("Buscar Producto Tecnología por Nombre")) {
                        buscarProductoTecnologia();
                    } else if (texto.equals("Buscar Solicitud por Número")) {
                        buscarSolicitudPorNumero();
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
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaPrincipal();
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
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                dispose();
            }
        });

        setVisible(true);
    }

    // Métodos vacíos para acciones (implementa tu lógica real aquí)
    private void registrarProveedor() {
        System.out.println(">> Acción: Registrar Proveedor");
        //VentanaProveedor vPro = new VentanaProveedor();
        dispose();
    }

    private void registrarProducto() {
        System.out.println(">> Acción: Registrar Producto");
        //VentanaProducto vProd = new VentanaProducto();
        dispose();
    }

    private void verListaProveedores() {
        System.out.println(">> Acción: Ver lista de proveedores");
    }

    private void verListaProductos() {
        System.out.println(">> Acción: Ver lista de productos");
    }

    private void buscarProveedorPorId() {
        System.out.println(">> Acción: Buscar Proveedor por ID");
    }

    private void buscarProductoAlimento() {
        System.out.println(">> Acción: Buscar Producto Alimento por Nombre");
    }

    private void buscarProductoTecnologia() {
        System.out.println(">> Acción: Buscar Producto Tecnología por Nombre");
    }

    private void buscarSolicitudPorNumero() {
        System.out.println(">> Acción: Buscar Solicitud por Número");
    }

    private void aprobarRechazarSolicitud() {
        System.out.println(">> Acción: Aprobar/Rechazar Solicitud");
    }
}