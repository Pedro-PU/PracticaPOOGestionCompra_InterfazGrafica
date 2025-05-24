package ec.edu.ups.poo.ventanasMain;

import ec.edu.ups.poo.ventanaBusquedas.VentanaBuscarSolicitud;
import ec.edu.ups.poo.ventanasSolicitudes.VentanaSolicitudCompra;
import ec.edu.ups.poo.clases.*;
import ec.edu.ups.poo.ventanasListar.VentanaListarSolicitudes;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaAnalistaCompras extends Frame {
    private Empleado empleadoActual;
    private List<Producto> productos;
    private List<SolicitudCompra> solicitudes;
    private Frame ventanaAnterior;

    public VentanaAnalistaCompras(Frame ventanaAnterior, Empleado empleadoActual, List<Producto> productos, List<SolicitudCompra> solicitudes) {
        this.ventanaAnterior = ventanaAnterior;
        this.empleadoActual = empleadoActual;
        this.productos = productos;
        this.solicitudes = solicitudes;

        Color azul = new Color(87, 124, 178);// Asignar un color

        setTitle("Analista de Compras");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Panel panelTitulo = new Panel(new GridLayout(2,1));
        Label titulo = new Label("MENÚ DE SOLICITUDES", Label.CENTER);
        panelTitulo.setPreferredSize(new Dimension(1500, 230));
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        panelTitulo.setBackground(azul);
        Panel panelTitulo2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo2.setBackground(Color.white);
        panelTitulo.add(titulo);
        panelTitulo.add(panelTitulo2);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel central
        Panel panelCentral = new Panel(new GridLayout(3, 1, 5, 5));
        panelCentral.setBackground(Color.WHITE);

        // Opciones
        String[] descripciones = {
                "Crear solicitud de compra",
                "Listar solicitudes de compra",
                "Buscar solicitud por número"
        };

        for (int i = 0; i < descripciones.length; i++) {
            String texto = descripciones[i];

            Panel fila = new Panel(new FlowLayout(FlowLayout.CENTER, 30, 10));

            Label etiqueta = new Label(texto);
            etiqueta.setFont(new Font("Arial", Font.PLAIN, 18));
            etiqueta.setPreferredSize(new Dimension(400, 30));

            Button boton = new Button("Seleccionar");
            boton.setFont(new Font("Arial", Font.PLAIN, 14));

            // ActionListener tradicional
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (texto.equals("Crear solicitud de compra")) {
                        crearSolicitud();
                    } else if (texto.equals("Listar solicitudes de compra")) {
                        listarSolicitudes();
                    } else if (texto.equals("Buscar solicitud por número")) {
                        buscarSolicitud();
                    }
                }
            });

            fila.add(etiqueta);
            fila.add(boton);
            panelCentral.add(fila);
        }

        // Botón Volver
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBackground(Color.lightGray);
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true); // Regresar a la anterior
                dispose();
            }
        });
        panelInferior.add(btnVolver);

        // Agregar todo
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Cierre correcto
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true); // Regresar a la anterior
                dispose();
            }
        });

        setVisible(true);
    }

    // Métodos para acciones
    private void crearSolicitud() {
        System.out.println(">> Acción: Crear solicitud de compra");

        setVisible(false);
        new VentanaSolicitudCompra(empleadoActual, productos, solicitudes, this);
    }

    private void listarSolicitudes() {
        System.out.println(">> Acción: Listar solicitudes de compra");
        setVisible(false);
        new VentanaListarSolicitudes(solicitudes, this);
    }

    private void buscarSolicitud() {
        System.out.println(">> Acción: Buscar solicitud por número");
        setVisible(false);
        new VentanaBuscarSolicitud(solicitudes, this);
    }

    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }
}
