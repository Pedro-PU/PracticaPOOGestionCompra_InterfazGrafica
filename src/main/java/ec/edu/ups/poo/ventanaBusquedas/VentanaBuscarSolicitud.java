package ec.edu.ups.poo.ventanaBusquedas;

import ec.edu.ups.poo.clases.SolicitudCompra;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaBuscarSolicitud extends Frame {

    private TextField txtBuscar;
    private TextArea areaResultado;
    private Button btnBuscar;
    private Frame ventanaAnterior;
    private List<SolicitudCompra> solicitudes;

    public VentanaBuscarSolicitud(List<SolicitudCompra> solicitudes, Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        this.solicitudes = solicitudes;

        setTitle("Buscar Solicitud de Compra");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        // Panel Superior
        Label titulo = new Label("BUSCAR SOLICITUD DE COMPRA", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);

        Panel panelTitulo = new Panel(new GridLayout(2, 1));
        Panel panelTitulo2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo2.setBackground(Color.white);
        panelTitulo.setBackground(azul);
        panelTitulo.setPreferredSize(new Dimension(1500, 230));
        panelTitulo.add(titulo);
        panelTitulo.add(panelTitulo2);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel Principal
        Panel panelPrincipal = new Panel(new GridLayout(2, 1));

        // Panel búsqueda
        Panel panelBusqueda = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblBuscar = new Label("Ingrese ID de Solicitud:");
        lblBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        lblBuscar.setPreferredSize(new Dimension(400, 30));

        txtBuscar = new TextField();
        txtBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        txtBuscar.setPreferredSize(new Dimension(400, 30));

        panelBusqueda.add(lblBuscar);
        panelBusqueda.add(txtBuscar);
        panelPrincipal.add(panelBusqueda);

        // Panel resultado
        Panel panelResultado = new Panel(new FlowLayout(FlowLayout.CENTER));
        areaResultado = new TextArea("Esperando búsqueda...");
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);
        areaResultado.setPreferredSize(new Dimension(1200, 200));
        panelResultado.add(areaResultado);
        panelPrincipal.add(panelResultado);

        add(panelPrincipal, BorderLayout.CENTER);

        // Panel inferior con botones Buscar y Volver
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        btnBuscar = new Button("Buscar Solicitud");
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        panelInferior.setBackground(Color.lightGray);

        panelInferior.add(btnBuscar);
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        // Eventos botones
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarSolicitud();
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
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    private void buscarSolicitud() {
        String idBuscado = txtBuscar.getText().trim();
        boolean encontrada = false;

        for (SolicitudCompra solicitud : solicitudes) {
            if (solicitud.getIdSolicitud().equalsIgnoreCase(idBuscado)) {
                areaResultado.setText(solicitud.toString());
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            areaResultado.setText("No se encontró ninguna solicitud con ID: " + idBuscado);
        }
    }
}
