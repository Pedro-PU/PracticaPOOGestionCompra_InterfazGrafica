package ec.edu.ups.poo.ventanasListar;

import ec.edu.ups.poo.clases.SolicitudCompra;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.text.SimpleDateFormat;

public class VentanaListarSolicitudes extends Frame {

    private TextArea areaSolicitudes;

    public VentanaListarSolicitudes(List<SolicitudCompra> solicitudes, Frame ventanaAnterior) {

        Color azul = new Color(87, 124, 178);

        // Configuración básica
        setTitle("Lista de Solicitudes de Compra");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel superior con título
        Label titulo = new Label("SOLICITUDES REGISTRADAS", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);

        Panel panelSuperior = new Panel(new GridLayout(2, 1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior2.setBackground(Color.white);
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        panelSuperior.add(panelSuperior2);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con TextArea
        Panel panelCentro = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel contenedorTextArea = new Panel(new BorderLayout());

        areaSolicitudes = new TextArea();
        areaSolicitudes.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaSolicitudes.setEditable(false);
        areaSolicitudes.setPreferredSize(new Dimension(800, 300));

        // Lógica para mostrar solicitudes (sin cambiar)
        if (solicitudes.isEmpty()) {
            areaSolicitudes.setText("No hay solicitudes registradas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (SolicitudCompra s : solicitudes) {
                sb.append(s.toString()).append("\n")
                        .append("------------------------\n");
            }
            areaSolicitudes.setText(sb.toString());
        }

        contenedorTextArea.add(areaSolicitudes, BorderLayout.CENTER);
        panelCentro.setBackground(Color.white);
        panelCentro.add(contenedorTextArea);
        add(panelCentro, BorderLayout.CENTER);

        // Panel inferior con botón "Volver"
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnVolver = new Button("Volver");
        panelInferior.setBackground(Color.lightGray);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}
