package ec.edu.ups.poo.VentanaProveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import ec.edu.ups.poo.clases.Proveedor;

public class VentanaProveedor extends Frame {

    private TextField txtId, txtNombre, txtCorreo, txtRuc, txtRubro, txtEstado;
    private List<Proveedor> proveedores;
    private Frame ventanaAnterior;

    public VentanaProveedor(Frame ventanaAnterior, List<Proveedor> proveedores) {
        this.ventanaAnterior = ventanaAnterior;
        this.proveedores = proveedores;

        setTitle("Gestión de Proveedores");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        // Panel superior (Título)
        Label titulo = new Label("REGISTRO PROVEEDOR", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        Panel panelSuperior = new Panel(new GridLayout(2,1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        panelSuperior2.setBackground(Color.white);
        panelSuperior.add(panelSuperior2);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con los campos de texto
        Panel panelCentral = new Panel(new GridLayout(5, 1, 10, 10));

        Font fuenteLabel = new Font("Arial", Font.PLAIN, 18);
        Font fuenteText = new Font("Arial", Font.PLAIN, 18);
        Dimension dimLabel = new Dimension(400, 30);
        Dimension dimText = new Dimension(400, 30);

        // Panel ID
        Panel panelId = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblId = new Label("ID del proveedor:");
        lblId.setFont(fuenteLabel);
        lblId.setPreferredSize(dimLabel);
        txtId = new TextField();
        txtId.setFont(fuenteText);
        txtId.setPreferredSize(dimText);
        panelId.add(lblId);
        panelId.add(txtId);

        // Panel Nombre
        Panel panelNombre = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblNombre = new Label("Nombre del proveedor:");
        lblNombre.setFont(fuenteLabel);
        lblNombre.setPreferredSize(dimLabel);
        txtNombre = new TextField();
        txtNombre.setFont(fuenteText);
        txtNombre.setPreferredSize(dimText);
        panelNombre.add(lblNombre);
        panelNombre.add(txtNombre);

        // Panel Correo
        Panel panelCorreo = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblCorreo = new Label("Correo:");
        lblCorreo.setFont(fuenteLabel);
        lblCorreo.setPreferredSize(dimLabel);
        txtCorreo = new TextField();
        txtCorreo.setFont(fuenteText);
        txtCorreo.setPreferredSize(dimText);
        panelCorreo.add(lblCorreo);
        panelCorreo.add(txtCorreo);

        // Panel RUC
        Panel panelRuc = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblRuc = new Label("RUC:");
        lblRuc.setFont(fuenteLabel);
        lblRuc.setPreferredSize(dimLabel);
        txtRuc = new TextField();
        txtRuc.setFont(fuenteText);
        txtRuc.setPreferredSize(dimText);
        panelRuc.add(lblRuc);
        panelRuc.add(txtRuc);

        // Panel Rubro
        Panel panelRubro = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblRubro = new Label("Rubro:");
        lblRubro.setFont(fuenteLabel);
        lblRubro.setPreferredSize(dimLabel);
        txtRubro = new TextField();
        txtRubro.setFont(fuenteText);
        txtRubro.setPreferredSize(dimText);
        panelRubro.add(lblRubro);
        panelRubro.add(txtRubro);

        panelCentral.add(panelId);
        panelCentral.add(panelNombre);
        panelCentral.add(panelCorreo);
        panelCentral.add(panelRuc);
        panelCentral.add(panelRubro);

        add(panelCentral, BorderLayout.CENTER);

        // Panel Inferior (botones y estado)
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.setBackground(Color.LIGHT_GRAY);

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setFont(new Font("Arial", Font.PLAIN, 18));

        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));

        Label lblEstado = new Label("Estado de registro:");
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 18));

        txtEstado = new TextField(" En proceso ... ", 20);
        txtEstado.setEditable(false);
        txtEstado.setFont(new Font("Arial", Font.PLAIN, 12));

        panelInferior.add(btnGuardar);
        panelInferior.add(btnVolver);
        panelInferior.add(lblEstado);
        panelInferior.add(txtEstado);

        add(panelInferior, BorderLayout.SOUTH);

        // Listeners
        btnGuardar.addActionListener(e -> registrarProveedor());
        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    private void registrarProveedor() {
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtCorreo.getText().isEmpty() || txtRuc.getText().isEmpty() || txtRubro.getText().isEmpty()) {
            txtEstado.setText("Complete todos los campos.");
            System.out.println("Por favor, llena todos los campos.");
            return;
        }

        Proveedor nuevoProveedor = new Proveedor(
                txtId.getText(),
                txtNombre.getText(),
                txtCorreo.getText(),
                txtRuc.getText(),
                txtRubro.getText()
        );

        proveedores.add(nuevoProveedor);
        System.out.println("Proveedor registrado: " + nuevoProveedor.getNombre());

        // Limpiar campos
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtRuc.setText("");
        txtRubro.setText("");
        txtEstado.setText("Proveedor registrado.");
    }
}
