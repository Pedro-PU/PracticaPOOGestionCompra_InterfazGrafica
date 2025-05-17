package ec.edu.ups.poo.ventanasMain;

import java.awt.*;
import java.awt.event.*;

public class VentanaAnalistaCompras extends Frame {

    public VentanaAnalistaCompras() {
        setTitle("Analista de Compras");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("MENÚ DE SOLICITUDES", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        add(titulo, BorderLayout.NORTH);

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

        // Agregar todo
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Cierre correcto
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                dispose();
            }
        });

        setVisible(true);
    }

    // Métodos de ejemplo para acciones
    private void crearSolicitud() {
        System.out.println(">> Acción: Crear solicitud de compra");
        // Aquí va la lógica real
    }

    private void listarSolicitudes() {
        System.out.println(">> Acción: Listar solicitudes de compra");
        // Aquí va la lógica real
    }

    private void buscarSolicitud() {
        System.out.println(">> Acción: Buscar solicitud por número");
        // Aquí va la lógica real
    }
}
