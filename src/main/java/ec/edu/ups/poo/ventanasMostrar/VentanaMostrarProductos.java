package ec.edu.ups.poo.ventanasMostrar;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ProductoTecnologia;
import ec.edu.ups.poo.clases.ProductoAlimento;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaMostrarProductos extends Frame {

    private Frame ventanaAnterior;
    private TextArea textAreaTecnologia, textAreaProductosAlimento;
    private List<ProductoTecnologia> productosTecnologia;
    private List<ProductoAlimento> productosAlimento;

    public VentanaMostrarProductos(Frame ventanaAnterior, List<ProductoTecnologia> productosTecnologia,
                                   List<ProductoAlimento> productosAlimento) {
        this.ventanaAnterior = ventanaAnterior;
        this.productosTecnologia = productosTecnologia;
        this.productosAlimento = productosAlimento;

        Color azul = new Color(87, 124, 178);

        setTitle("Lista de Productos");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel general
        Panel panelCentral = new Panel(new GridLayout(2, 1));
        panelCentral.setBackground(Color.white);

        // Productos Tecnología
        Panel panelTecnologia = new Panel(new BorderLayout());
        Label labelTecnologia = new Label("Listado de Productos Tecnología", Label.CENTER);
        labelTecnologia.setFont(new Font("Arial", Font.BOLD, 24));
        labelTecnologia.setForeground(Color.white);
        Panel contenedorTituloTec = new Panel();
        contenedorTituloTec.setBackground(azul);
        contenedorTituloTec.add(labelTecnologia);

        Panel contenedorTextAreaTec = new Panel(new FlowLayout(FlowLayout.CENTER));
        textAreaTecnologia = new TextArea();
        textAreaTecnologia.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaTecnologia.setEditable(false);
        textAreaTecnologia.setPreferredSize(new Dimension(800, 250));
        mostrarProductosTecnologia();
        contenedorTextAreaTec.add(textAreaTecnologia);

        panelTecnologia.add(contenedorTituloTec, BorderLayout.NORTH);
        panelTecnologia.add(contenedorTextAreaTec, BorderLayout.CENTER);

        // Productos Alimento
        Panel panelAlimento = new Panel(new BorderLayout());
        Label labelAlimento = new Label("Listado de Productos Alimentos", Label.CENTER);
        labelAlimento.setFont(new Font("Arial", Font.BOLD, 24));
        labelAlimento.setForeground(Color.white);
        Panel contenedorTituloAli = new Panel();
        contenedorTituloAli.setBackground(azul);
        contenedorTituloAli.add(labelAlimento);

        Panel contenedorTextAreaAli = new Panel(new FlowLayout(FlowLayout.CENTER));
        textAreaProductosAlimento = new TextArea();
        textAreaProductosAlimento.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaProductosAlimento.setEditable(false);
        textAreaProductosAlimento.setPreferredSize(new Dimension(800, 250)); // Ajuste de tamaño
        mostrarProductosAlimento();
        contenedorTextAreaAli.add(textAreaProductosAlimento);

        panelAlimento.add(contenedorTituloAli, BorderLayout.NORTH);
        panelAlimento.add(contenedorTextAreaAli, BorderLayout.CENTER);

        panelCentral.add(panelTecnologia);
        panelCentral.add(panelAlimento);

        // Panel inferior
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        panelInferior.setBackground(Color.lightGray);
        panelInferior.add(btnVolver);

        btnVolver.addActionListener(e -> {
            ventanaAnterior.setVisible(true);
            dispose();
        });

        // Agregar todo a la ventana
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });
    }

    private void mostrarProductosTecnologia() {
        if (productosTecnologia.isEmpty()) {
            textAreaTecnologia.setText("No hay productos registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder();
        for (Producto producto : productosTecnologia) {
            lista.append("ID: ").append(producto.getCodigo()).append(" | ")
                    .append("Nombre: ").append(producto.getNombre()).append(" | ")
                    .append("Precio: $").append(producto.getPrecioUnitario()).append("\n");
        }
        textAreaTecnologia.setText(lista.toString());
    }

    private void mostrarProductosAlimento() {
        if (productosAlimento.isEmpty()) {
            textAreaProductosAlimento.setText("No hay productos registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder();
        for (Producto producto : productosAlimento) {
            lista.append("ID: ").append(producto.getCodigo()).append(" | ")
                    .append("Nombre: ").append(producto.getNombre()).append(" | ")
                    .append("Precio: $").append(producto.getPrecioUnitario()).append("\n");
        }
        textAreaProductosAlimento.setText(lista.toString());
    }
}