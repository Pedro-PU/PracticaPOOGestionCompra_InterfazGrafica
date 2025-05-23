package ec.edu.ups.poo.ventanasMostrar;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ProductoAlimento;
import ec.edu.ups.poo.clases.ProductoTecnologia;
import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaMostrarProveedores extends Frame {

    private Frame ventanaAnterior;
    private TextArea textAreaProvedores;
    private List<Proveedor> proveedores;
    private List<Producto> productos;
    private List<ProductoAlimento> productosAlimento;
    private List<ProductoTecnologia> productosTecnologia;

    public VentanaMostrarProveedores(Frame ventanaAnterior, List<Proveedor> proveedores, List<Producto> productos,
                                     List<ProductoAlimento> productosAlimento, List<ProductoTecnologia> productosTecnologia) {

        this.ventanaAnterior = ventanaAnterior;
        this.proveedores = proveedores;
        this.productos = productos;
        this.productosAlimento = productosAlimento;
        this.productosTecnologia = productosTecnologia;

        Color azul = new Color(87, 124, 178); // Asignar un color

        Label titulo = new Label("LISTADO DE PROVEEDORES", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Panel superior
        Panel panelSuperior = new Panel(new GridLayout(2, 1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior2.setBackground(Color.white);
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        panelSuperior.add(panelSuperior2);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel de proveedores (ajustado para que el TextArea no sea tan grande)
        Panel panelProveedores = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel contenedorTextArea = new Panel(new BorderLayout());

        textAreaProvedores = new TextArea();
        textAreaProvedores.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textAreaProvedores.setEditable(false);
        textAreaProvedores.setPreferredSize(new Dimension(800, 300)); // Tamaño reducido
        mostrarProveedores();

        contenedorTextArea.add(textAreaProvedores, BorderLayout.CENTER);
        panelProveedores.setBackground(Color.white);
        panelProveedores.add(contenedorTextArea);

        // Panel inferior con botón "Volver"
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Button btnVolver = new Button("Volver");
        panelInferior.setBackground(Color.lightGray);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        panelInferior.add(btnVolver);

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        // Agregar paneles a la ventana
        add(panelProveedores, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });
    }

    private void mostrarProveedores() {
        if (proveedores.isEmpty()) {
            textAreaProvedores.setText("No hay proveedores registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder();
        for (Proveedor proveedor : proveedores) {
            lista.append("ID: ").append(proveedor.getIdPersona()).append(" | ")
                    .append("Nombre: ").append(proveedor.getNombre()).append(" | ")
                    .append("RUC: ").append(proveedor.getRuc()).append(" | ")
                    .append("Rubro: ").append(proveedor.getRubro()).append("\n")
                    .append("LISTA DE PRODUCTOS DEL PROVEEDOR: \n[ ");

            List<Producto> listaProductos = proveedor.getListaProductos();
            for (int i = 0; i < listaProductos.size(); i++) {
                lista.append(listaProductos.get(i).getNombre());
                if (i < listaProductos.size() - 1) {
                    lista.append(", ");
                }
            }
            lista.append(" ]\n\n");
        }

        textAreaProvedores.setText(lista.toString());
    }
}
