package ec.edu.ups.poo.ventanaBusquedas;

import ec.edu.ups.poo.clases.ProductoAlimento;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaBusquedaAlimento extends Frame {

    private Frame ventanaAnterior;
    private List<ProductoAlimento> productosAlimento;
    private TextField textFieldID;
    private Button btnBuscar;
    private TextArea textAreaProductos;

    public VentanaBusquedaAlimento(Frame ventanaAnterior, List<ProductoAlimento> productosAlimento) {
        this.ventanaAnterior = ventanaAnterior;
        this.productosAlimento = productosAlimento;

        setTitle("Buscar Alimento por ID");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Importante: usar BorderLayout para organizar bien los paneles
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        // Panel Superior - Título
        Panel panelSuperior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label titulo = new Label("BUSQUEDA DE ALIMENTO", Label.CENTER);
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

        // Panel Central que contiene el campo de texto y el área de resultados
        Panel panelCentro = new Panel(new GridLayout(2, 1));

        // Subpanel con campo de búsqueda
        Panel panelBusqueda = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaID = new Label("Ingrese el ID del producto:");
        etiquetaID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldID = new TextField();
        textFieldID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldID.setPreferredSize(new Dimension(400, 30));
        panelBusqueda.add(etiquetaID);
        panelBusqueda.add(textFieldID);

        // Subpanel con resultados
        Panel panelResultados = new Panel(new FlowLayout(FlowLayout.CENTER));
        textAreaProductos = new TextArea("Esperando búsqueda...", 10, 100);
        textAreaProductos.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaProductos.setEditable(false);
        panelResultados.add(textAreaProductos);

        panelCentro.add(panelBusqueda);
        panelCentro.add(panelResultados);
        add(panelCentro, BorderLayout.CENTER);

        // Panel Inferior con botones
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        panelInferior.add(btnBuscar);
        panelInferior.add(btnVolver);
        panelInferior.setBackground(Color.lightGray);
        add(panelInferior, BorderLayout.SOUTH);

        // Acción del botón Volver

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        // Acción del botón Buscar

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                buscarAlimentoId();
            }
        });

        setVisible(true);
    }

    // Método para buscar el producto por ID
    public void buscarAlimentoId() {
        if (productosAlimento.isEmpty()) {
            textAreaProductos.setText("No hay productos de alimento registrados.");
            return;
        }

        String buscarID = textFieldID.getText().trim();
        StringBuilder lista = new StringBuilder();

        ProductoAlimento productoBuscado = null;
        for (ProductoAlimento producto : productosAlimento) {
            if (producto.getCodigo().equalsIgnoreCase(buscarID)) {
                productoBuscado = producto;
                break;
            }
        }

        if (productoBuscado != null) {
            lista.append("Producto encontrado:\n");
            lista.append(" - ID: ").append(productoBuscado.getCodigo()).append("\n");
            lista.append(" - Nombre: ").append(productoBuscado.getNombre()).append("\n");
            lista.append(" - Peso: ").append(productoBuscado.getPeso()).append(" Kg\n");
        } else {
            lista.append("No se encontró el producto con ID: ").append(buscarID);
        }

        textAreaProductos.setText(lista.toString());
    }
}
