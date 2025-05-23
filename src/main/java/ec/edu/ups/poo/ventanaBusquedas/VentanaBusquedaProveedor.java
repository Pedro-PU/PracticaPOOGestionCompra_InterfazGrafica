package ec.edu.ups.poo.ventanaBusquedas;

import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class VentanaBusquedaProveedor extends Frame{
    private Frame ventanaAnterior;
    private List<Proveedor> proveedores;
    private Proveedor proveedorSeleccionado;
    private Button btnBuscar;
    private TextField textFieldID;
    private TextArea textAreaProveedores;

    public VentanaBusquedaProveedor(Frame ventanaAnterior, List<Proveedor> proveedores) {
        this.ventanaAnterior = ventanaAnterior;
        this.proveedores = proveedores;

        setTitle("Buscar Proveedor");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);

        Color azul = new Color(87, 124, 178);

        // Título
        Label titulo = new Label("BUSCAR PROVEEDOR", Label.CENTER);
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

        // Panel Principal
        Panel panelPrincipal = new Panel(new GridLayout(2, 1));

        // Panel Central
        Panel panelCentral = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaID = new Label("Ingrese el ID del proveedor:");
        etiquetaID.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaID.setPreferredSize(new Dimension(400, 30));
        textFieldID = new TextField();
        textFieldID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldID.setPreferredSize(new Dimension(400, 30));
        panelCentral.add(etiquetaID);
        panelCentral.add(textFieldID);
        panelPrincipal.add(panelCentral);
        add(panelPrincipal, BorderLayout.CENTER);

        // Panel Central Inferior
        Panel panelCentralInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        textAreaProveedores = new TextArea("Esperando búsqueda...");
        textAreaProveedores.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaProveedores.setEditable(false);
        textAreaProveedores.setPreferredSize(new Dimension(1200, 200));
        panelPrincipal.add(panelCentralInferior);
        panelCentralInferior.add(textAreaProveedores);

        // Panel Inferior
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnVolver = new Button("Volver");
        panelInferior.setBackground(Color.lightGray);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        btnBuscar = new Button("Buscar Proveedor");
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProveedores();
            }
        });

        panelInferior.add(btnBuscar);
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public void mostrarProveedores() {
        if (proveedores.isEmpty()) {
            textAreaProveedores.setText("No hay proveedores registrados.");
        }
        StringBuilder lista = new StringBuilder();

        String buscarID = textFieldID.getText();
        Proveedor proveedorBuscado = null;

        for (Proveedor proveedor : proveedores) {
            if (proveedor.getIdPersona().equals(buscarID)) {
                proveedorBuscado = proveedor;
                break;
            }
        }

        if (proveedorBuscado != null) {
            lista.append("Proveedor encontrado:\n ")
                    .append(" - ID: ").append(proveedorBuscado.getIdPersona() + "\n")
                    .append(" - Nombre: ").append(proveedorBuscado.getNombre() + "\n")
                    .append(" - RUC: ").append(proveedorBuscado.getRuc() + "\n")
                    .append(" - Rubro: ").append(proveedorBuscado.getRubro());
        } else {
            lista.append("No se encontró el proveedor con ID: ").append(buscarID).append("\n");
        }
        textAreaProveedores.setText(lista.toString());
    }
}

