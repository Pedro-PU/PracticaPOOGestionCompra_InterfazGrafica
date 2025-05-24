package ec.edu.ups.poo.ventanasProducto;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ProductoAlimento;
import ec.edu.ups.poo.clases.ProductoTecnologia;
import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaProducto extends Frame {
    private Frame ventanaAnterior;
    private List<Proveedor> proveedores;
    private List<Producto> productos;
    private List<ProductoAlimento> productosAlimento;
    private List<ProductoTecnologia> productosTecnologia;

    public VentanaProducto(Frame ventanaAnterior, List<Proveedor> proveedores, List<ProductoAlimento> productosAlimento,
                           List<ProductoTecnologia> productosTecnologia, List<Producto> productos) {
        this.ventanaAnterior = ventanaAnterior;
        this.proveedores = proveedores;
        this.productosAlimento = productosAlimento;
        this.productos = productos;

        Color azul = new Color(87, 124, 178);// Asignar un color

        setTitle("Productos");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("PRODUCTOS", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 64));
        titulo.setForeground(Color.white);
        add(titulo, BorderLayout.NORTH);
        Panel panelSuperior = new Panel(new GridLayout(2,1));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        Panel panelSuperio2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperio2.setBackground(Color.white);
        panelSuperior.add(panelSuperio2);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel Central
        Panel panelCentral = new Panel(new GridLayout(2, 1, 5, 0));

        // Panel para la opción "Producto Alimentos"
        Panel panelAlimentos = new Panel(new FlowLayout(FlowLayout.CENTER));

        // Etiqueta Producto Alimentos
        Label etiquetaAlimentos = new Label("Producto Alimentos");
        etiquetaAlimentos.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaAlimentos.setPreferredSize(new Dimension(400, 30));

        // Botón Producto Alimentos
        Button botonAlimentos = new Button("Seleccionar");
        botonAlimentos.setFont(new Font("Arial", Font.PLAIN, 14));

        botonAlimentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Agregar etiqueta y botón al panel
        panelAlimentos.add(etiquetaAlimentos);
        panelAlimentos.add(botonAlimentos);
        panelCentral.add(panelAlimentos);

        // Panel para la opción "Producto Tecnología"
        Panel panelTecnologia = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Etiqueta Producto Tecnología
        Label etiquetaTecnologia = new Label("Producto Tecnología");
        etiquetaTecnologia.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaTecnologia.setPreferredSize(new Dimension(400, 30));

        // Botón Producto Tecnología
        Button botonTecnologia = new Button("Seleccionar");
        botonTecnologia.setFont(new Font("Arial", Font.PLAIN, 14));

        botonTecnologia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Agregar etiqueta y botón al panel
        panelTecnologia.add(etiquetaTecnologia);
        panelTecnologia.add(botonTecnologia);
        panelCentral.add(panelTecnologia);

        // Agregar el panel central
        add(panelCentral, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });


        // Panel inferior con botón "Volver"
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.setBackground(Color.lightGray);
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose(); // Oculta la ventana actual
            }
        });
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        // Mostrar la ventana
        setVisible(true);
    }
}