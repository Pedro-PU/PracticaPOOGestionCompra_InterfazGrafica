package ec.edu.ups.poo.ventanaBusquedas;

import ec.edu.ups.poo.clases.ProductoTecnologia;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaBusquedaTecnologia extends Frame {

    private Frame ventanaAnterior;
    private List<ProductoTecnologia> productosTecnologia;
    private TextField textFieldID;
    private Button btnBuscar;
    private TextArea textAreaProductos;

    public VentanaBusquedaTecnologia(Frame ventanaAnterior, List<ProductoTecnologia> productosTecnologia) {
        this.ventanaAnterior = ventanaAnterior;
        this.productosTecnologia = productosTecnologia;

        setTitle("Buscar Producto de Tecnología");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        // Panel Superior
        Panel panelTitulo = new Panel(new GridLayout(2, 1));
        Panel panelTitulo2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo2.setBackground(Color.white);
        panelTitulo.setBackground(azul);
        panelTitulo.setPreferredSize(new Dimension(1500, 230));
        Label titulo = new Label("BUSCAR PRODUCTO DE TECNOLOGÍA", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        panelTitulo.add(titulo);
        panelTitulo.add(panelTitulo2);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel Principal
        Panel panelPrincipal = new Panel(new GridLayout(2, 1));

        // Panel Búsqueda
        Panel panelBusqueda = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaID = new Label("Ingrese el ID del producto de tecnología:");
        etiquetaID.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaID.setPreferredSize(new Dimension(400, 30));
        textFieldID = new TextField();
        textFieldID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldID.setPreferredSize(new Dimension(400, 30));
        panelBusqueda.add(etiquetaID);
        panelBusqueda.add(textFieldID);

        // Panel TextArea
        Panel panelResultados = new Panel(new FlowLayout(FlowLayout.CENTER));
        textAreaProductos = new TextArea("Esperando búsqueda...", 10, 100);
        textAreaProductos.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaProductos.setEditable(false);
        panelResultados.add(textAreaProductos);

        panelPrincipal.add(panelBusqueda);
        panelPrincipal.add(panelResultados);

        add(panelPrincipal, BorderLayout.CENTER);

        // Panel Inferior
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 18));
        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        panelInferior.setBackground(Color.lightGray);
        panelInferior.add(btnBuscar);
        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoId();
            }
        });

        // Cerrar ventana con la X
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    // Método para buscar producto tecnología por ID
    private void buscarProductoId() {
        if (productosTecnologia.isEmpty()) {
            textAreaProductos.setText("No hay productos de tecnología registrados.");
            return;
        }

        String buscarID = textFieldID.getText().trim();
        ProductoTecnologia productoBuscado = null;

        for (ProductoTecnologia producto : productosTecnologia) {
            if (producto.getCodigo().equalsIgnoreCase(buscarID)) {
                productoBuscado = producto;
                break;
            }
        }

        StringBuilder resultado = new StringBuilder();

        if (productoBuscado != null) {
            resultado.append("Producto encontrado:\n");
            resultado.append(" - ID: ").append(productoBuscado.getCodigo()).append("\n");
            resultado.append(" - Nombre: ").append(productoBuscado.getNombre()).append("\n");
            resultado.append(" - Marca: ").append(productoBuscado.getGama()).append("\n");
        } else {
            resultado.append("No se encontró el producto con ID: ").append(buscarID);
        }

        textAreaProductos.setText(resultado.toString());
    }
}
