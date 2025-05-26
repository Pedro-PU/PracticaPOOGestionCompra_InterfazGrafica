package ec.edu.ups.poo.ventanasProducto;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ProductoTecnologia;
import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.List;

public class VentanaProductoTecnologia extends Frame {

    private Button btnAgregar, btnVolver;
    private TextField textFieldID, textFieldNombre, textFieldPrecio, textFieldGama, textFieldProveedorID, textFieldEstado;
    private Frame ventanaAnterior;
    private List<Proveedor> proveedores;
    private List<ProductoTecnologia> productosTecnologia;
    private List<Producto> productos;

    public VentanaProductoTecnologia(Frame ventanaAnterior, List<Proveedor> proveedores, List<ProductoTecnologia> productosTecnologia,
                                     List<Producto> productos) {
        this.ventanaAnterior = ventanaAnterior;
        this.proveedores = proveedores;
        this.productosTecnologia = productosTecnologia;
        this.productos = productos;

        setTitle("Productos Tecnología");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        //titulo
        Label titulo = new Label("PRODUCTOS TECNOLOGÍA", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        Panel panelSuperior = new Panel(new GridLayout(2,1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        panelSuperior2.setBackground(Color.white);
        panelSuperior.add(panelSuperior2);

        Panel panelCentral = new Panel(new GridLayout(6, 1, 10, 10));

        // ID
        Panel panelID = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaID = new Label("Ingrese el ID del producto:");
        etiquetaID.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaID.setPreferredSize(new Dimension(400, 30));
        textFieldID = new TextField();
        textFieldID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldID.setPreferredSize(new Dimension(400, 30));
        panelID.add(etiquetaID);
        panelID.add(textFieldID);

        // Nombre
        Panel panelNombre = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaNombre = new Label("Ingrese el nombre del producto:");
        etiquetaNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaNombre.setPreferredSize(new Dimension(400, 30));
        textFieldNombre = new TextField();
        textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldNombre.setPreferredSize(new Dimension(400, 30));
        panelNombre.add(etiquetaNombre);
        panelNombre.add(textFieldNombre);

        // Precio
        Panel panelPrecio = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaPrecio = new Label("Ingrese el precio del producto:");
        etiquetaPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaPrecio.setPreferredSize(new Dimension(400, 30));
        textFieldPrecio = new TextField();
        textFieldPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldPrecio.setPreferredSize(new Dimension(400, 30));
        panelPrecio.add(etiquetaPrecio);
        panelPrecio.add(textFieldPrecio);

        // Gama
        Panel panelGama = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaGama = new Label("Ingrese la gama del producto:");
        etiquetaGama.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaGama.setPreferredSize(new Dimension(400, 30));
        textFieldGama = new TextField();
        textFieldGama.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldGama.setPreferredSize(new Dimension(400, 30));
        panelGama.add(etiquetaGama);
        panelGama.add(textFieldGama);

        // Proveedor ID
        Panel panelProveedorID = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaProveedorID = new Label("Ingrese el ID del proveedor:");
        etiquetaProveedorID.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaProveedorID.setPreferredSize(new Dimension(400, 30));
        textFieldProveedorID = new TextField();
        textFieldProveedorID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldProveedorID.setPreferredSize(new Dimension(400, 30));
        panelProveedorID.add(etiquetaProveedorID);
        panelProveedorID.add(textFieldProveedorID);

        // Inferior
        Panel panelInferior = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelInferior.setBackground(Color.lightGray);
        btnAgregar = new Button("Agregar Producto");
        btnAgregar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        Label etiquetaEstado = new Label("Estado de registro:");
        etiquetaEstado.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldEstado = new TextField(" En proceso ... ", 20);
        textFieldEstado.setEditable(false);
        panelInferior.add(btnAgregar);
        panelInferior.add(btnVolver);
        panelInferior.add(etiquetaEstado);
        panelInferior.add(textFieldEstado);


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textFieldID.getText().trim();
                String nombre = textFieldNombre.getText().trim();
                String precioStr = textFieldPrecio.getText().trim();
                String gama = textFieldGama.getText().trim();
                String proveedorID = textFieldProveedorID.getText().trim();

                if (codigo.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || gama.isEmpty() || proveedorID.isEmpty()) {
                    textFieldEstado.setText("Complete todos los campos.");
                    return;
                }

                double precioUnitario = Double.parseDouble(precioStr);

                Proveedor proveedor = null;
                for (Proveedor p : proveedores) {
                    if (p.getIdPersona().equals(proveedorID)) {
                        proveedor = p;
                        break;
                    }
                }

                if (proveedor != null) {
                    ProductoTecnologia nuevoProducto = new ProductoTecnologia(codigo, nombre, precioUnitario, proveedor, gama);
                    productosTecnologia.add(nuevoProducto);
                    productos.add(nuevoProducto);
                    proveedor.agregarProducto(nuevoProducto);

                    textFieldID.setText("");
                    textFieldNombre.setText("");
                    textFieldPrecio.setText("");
                    textFieldGama.setText("");
                    textFieldProveedorID.setText("");

                    textFieldEstado.setText("Producto agregado correctamente.");
                } else {
                    textFieldEstado.setText("Proveedor no encontrado.");
                }
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        panelCentral.add(panelID);
        panelCentral.add(panelNombre);
        panelCentral.add(panelPrecio);
        panelCentral.add(panelGama);
        panelCentral.add(panelProveedorID);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
        });
    }
}