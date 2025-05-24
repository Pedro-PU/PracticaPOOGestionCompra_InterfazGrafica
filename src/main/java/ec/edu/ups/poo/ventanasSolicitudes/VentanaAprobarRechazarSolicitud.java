package ec.edu.ups.poo.ventanasSolicitudes;

import ec.edu.ups.poo.clases.*;
import ec.edu.ups.poo.enums.EstadoSolicitud;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaAprobarRechazarSolicitud extends Frame {

    private List<SolicitudCompra> solicitudes;
    private Empleado gerente;
    private Frame ventanaAnterior;

    private Choice listaSolicitudes;
    private TextArea areaDetalle;

    public VentanaAprobarRechazarSolicitud(List<SolicitudCompra> solicitudes, Empleado gerente, Frame ventanaAnterior) {
        this.solicitudes = solicitudes;
        this.gerente = gerente;
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Aprobar o Rechazar Solicitudes");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        // PANEL TITULO
        Label titulo = new Label("Seleccione una solicitud para aprobar o rechazar", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.white);

        Panel panelTitulo = new Panel(new GridLayout(2, 1));
        panelTitulo.setBackground(azul);
        panelTitulo.setPreferredSize(new Dimension(1500, 120));
        panelTitulo.add(titulo);

        Panel espacioTitulo = new Panel();
        espacioTitulo.setBackground(azul);
        panelTitulo.add(espacioTitulo);

        add(panelTitulo, BorderLayout.NORTH);

        // PANEL CENTRAL
        Panel panelCentro = new Panel(new BorderLayout(10, 10));
        panelCentro.setBackground(Color.white);
        panelCentro.setPreferredSize(new Dimension(1500, 600));

        // Choice
        listaSolicitudes = new Choice();
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getEstado().equals(EstadoSolicitud.PENDIENTE)) {
                listaSolicitudes.add("Solicitud ID: " + solicitud.getIdSolicitud());
            }
        }
        listaSolicitudes.setFont(new Font("Arial", Font.PLAIN, 18));
        listaSolicitudes.setPreferredSize(new Dimension(500, 50));
        listaSolicitudes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                mostrarDetalleSolicitud();
            }
        });

        Panel panelChoice = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelChoice.add(listaSolicitudes);
        panelChoice.setBackground(Color.white);
        panelCentro.add(panelChoice, BorderLayout.NORTH);

        // TextArea
        areaDetalle = new TextArea("Seleccione una solicitud para ver detalles.", 15, 60, TextArea.SCROLLBARS_VERTICAL_ONLY);
        areaDetalle.setFont(new Font("Monospaced", Font.PLAIN, 16));
        areaDetalle.setEditable(false);
        areaDetalle.setBackground(Color.lightGray);

        Panel panelAreaDetalle = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelAreaDetalle.add(areaDetalle);
        panelAreaDetalle.setBackground(Color.white);
        panelCentro.add(panelAreaDetalle, BorderLayout.CENTER);

        add(panelCentro, BorderLayout.CENTER);

        // PANEL BOTONES
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        panelBotones.setBackground(Color.lightGray);
        panelBotones.setPreferredSize(new Dimension(1500, 80));

        Button btnAprobar = new Button("Aprobar");
        btnAprobar.setFont(new Font("Arial", Font.PLAIN, 18));

        Button btnRechazar = new Button("Rechazar");
        btnRechazar.setFont(new Font("Arial", Font.PLAIN, 18));

        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));

        panelBotones.add(btnAprobar);
        panelBotones.add(btnRechazar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);

        // Listeners
        btnAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aprobarSolicitud();
            }
        });

        btnRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rechazarSolicitud();
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        setVisible(true);

        if (listaSolicitudes.getItemCount() > 0) {
            listaSolicitudes.select(0);
            mostrarDetalleSolicitud();
        } else {
            areaDetalle.setText("No hay solicitudes pendientes.");
        }
    }

    private void mostrarDetalleSolicitud() {
        String seleccion = listaSolicitudes.getSelectedItem();
        if (seleccion == null) return;

        String idSeleccionado = seleccion.split(":")[1].trim();
        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getIdSolicitud().equals(idSeleccionado)) {
                areaDetalle.setText(solicitud.toString());
                break;
            }
        }
    }

    private void aprobarSolicitud() {
        cambiarEstadoSolicitud(EstadoSolicitud.APROBADA);
    }

    private void rechazarSolicitud() {
        cambiarEstadoSolicitud(EstadoSolicitud.RECHAZADA);
    }

    private void cambiarEstadoSolicitud(EstadoSolicitud nuevoEstado) {
        String seleccion = listaSolicitudes.getSelectedItem();
        if (seleccion == null) return;

        String idSeleccionado = seleccion.split(":")[1].trim();

        for (int i = 0; i < solicitudes.size(); i++) {
            SolicitudCompra solicitud = solicitudes.get(i);
            if (solicitud.getIdSolicitud().equals(idSeleccionado)) {
                if (nuevoEstado == EstadoSolicitud.APROBADA) {
                    solicitud.aprobar(gerente);
                } else {
                    solicitud.rechazar(gerente);
                }

                solicitudes.remove(i);
                listaSolicitudes.remove(listaSolicitudes.getSelectedIndex());

                if (listaSolicitudes.getItemCount() > 0) {
                    listaSolicitudes.select(0);
                    mostrarDetalleSolicitud();
                } else {
                    areaDetalle.setText("No hay solicitudes pendientes.");
                }

                return;
            }
        }
    }
}

