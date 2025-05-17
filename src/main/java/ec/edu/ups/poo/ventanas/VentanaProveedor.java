package ec.edu.ups.poo.ventanas;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import ec.edu.ups.poo.ventanasMain.VentanaGerenteCompras;
import ec.edu.ups.poo.clases.Proveedor;

public class VentanaProveedor extends Frame {
    private TextField txtId, txtNombre, txtCorreo, txtRuc, txtRubro;
    private List<Proveedor> proveedores;

    //Creamos la ventana para Proveedor
    public VentanaProveedor() {
        this.proveedores = proveedores;
        setTitle("Gestión de Proveedores");
        setSize(1500, 800);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        // Título
        Label titulo = new Label("MENÚ DE PROVEEDORES", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        add(titulo, BorderLayout.NORTH);

        // Panel Central
        Panel panelCentro = new Panel(new GridLayout(5, 2, 10, 10));

        Font fuenteLabels = new Font("Arial", Font.BOLD, 18);
        Font fuenteTextFields = new Font("Arial", Font.PLAIN, 11);

        // Etiquetas y campos de texto
        Label lblId = new Label("ID del proveedor:");
        lblId.setFont(fuenteLabels);
        panelCentro.add(lblId);
        txtId = new TextField(5);
        txtId.setFont(fuenteTextFields);
        panelCentro.add(txtId);

        Label lblNombre = new Label("Nombre del proveedor:");
        lblNombre.setFont(fuenteLabels);
        panelCentro.add(lblNombre);
        txtNombre = new TextField(5);
        txtNombre.setFont(fuenteTextFields);
        panelCentro.add(txtNombre);

        Label lblCorreo = new Label("Correo:");
        lblCorreo.setFont(fuenteLabels);
        panelCentro.add(lblCorreo);
        txtCorreo = new TextField(5);
        txtCorreo.setFont(fuenteTextFields);
        panelCentro.add(txtCorreo);

        Label lblRuc = new Label("RUC:");
        lblRuc.setFont(fuenteLabels);
        panelCentro.add(lblRuc);
        txtRuc = new TextField(5);
        txtRuc.setFont(fuenteTextFields);
        panelCentro.add(txtRuc);

        Label lblRubro = new Label("Rubro:");
        lblRubro.setFont(fuenteLabels);
        panelCentro.add(lblRubro);
        txtRubro = new TextField(5);
        txtRubro.setFont(fuenteTextFields);
        panelCentro.add(txtRubro);

        add(panelCentro, BorderLayout.CENTER); // Agregar los datos en el centro

        // Panel Inferior
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Botones
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 14));
        btnGuardar.addActionListener(e -> registrarProveedor());

        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGerenteCompras ventanaGerente = new VentanaGerenteCompras();
                dispose(); // Cerrar la ventana actual
            }
        });

        // Agregar botones al panel
        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);

        // Cerrar ventana correctamente
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                VentanaGerenteCompras ventanaGerente = new VentanaGerenteCompras();
                dispose();
            }
        });

        // Establecer la visibilidad de la ventana
        setVisible(true);
    }
    // Registramos el proveedor
    private void registrarProveedor() {
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtCorreo.getText().isEmpty() || txtRuc.getText().isEmpty() || txtRubro.getText().isEmpty()) {
            System.out.println("Por favor, llena todos los campos.");
            return;
        }

        // Guardamos en el nuevo proveedor
        Proveedor nuevoProveedor = new Proveedor(txtId.getText(), txtNombre.getText(),
                txtCorreo.getText(), txtRuc.getText(), txtRubro.getText());
        proveedores.add(nuevoProveedor);

        System.out.println("Proveedor registrado: " + nuevoProveedor.getNombre());

        // Limpiamos los campos de texto
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtRuc.setText("");
        txtRubro.setText("");
    }
}