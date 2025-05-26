package ec.edu.ups.poo.ventanasProducto;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.clases.ProductoAlimento;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaProductoAlimento extends Frame {

    private Button btnAgregar, btnVolver;
    private TextField textFieldID, textFieldNombre, textFieldPrecio, textFieldPeso,
            textFieldProveedorID, textFieldEstado;
    private List<ProductoAlimento> productosAlimento;
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private Proveedor proveedorSeleccionado;
    private Frame ventanaAnterior;

    public VentanaProductoAlimento(Frame ventanaAnterior, List<Proveedor> proveedores, List<ProductoAlimento> productosAlimento,
                                   List<Producto> productos) {
        this.ventanaAnterior = ventanaAnterior;
        this.proveedores = proveedores; // Inicializa la lista de proveedores
        this.productosAlimento = productosAlimento; // Inicializa la lista de productos de alimentos
        this.productos = productos; // Inicializa la lista de productos

        Color azul = new Color(87, 124, 178);

        setTitle("Productos");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("PRODUCTOS ALIMENTOS", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        Panel panelSuperior = new Panel(new GridLayout(2,1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        panelSuperior2.setBackground(Color.white);
        panelSuperior.add(panelSuperior2);

        // Panel Central con GridLayout (organiza los paneles verticalmente)
        Panel panelCentral = new Panel(new GridLayout(6, 1, 10, 10));;

        // Panel ID
        Panel panelID = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaID = new Label("Ingrese el ID del producto:");
        etiquetaID.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaID.setPreferredSize(new Dimension(400, 30));
        textFieldID = new TextField();
        textFieldID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldID.setPreferredSize(new Dimension(400, 30));
        panelID.add(etiquetaID);
        panelID.add(textFieldID);

        // Panel Nombre
        Panel panelNombre = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaNombre = new Label("Ingrese el nombre del producto:");
        etiquetaNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaNombre.setPreferredSize(new Dimension(400, 30));
        textFieldNombre = new TextField();
        textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldNombre.setPreferredSize(new Dimension(400, 30));
        panelNombre.add(etiquetaNombre);
        panelNombre.add(textFieldNombre);

        // Panel Precio
        Panel panelPrecio = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaPrecio = new Label("Ingrese el precio del producto:");
        etiquetaPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaPrecio.setPreferredSize(new Dimension(400, 30));
        textFieldPrecio = new TextField();
        textFieldPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldPrecio.setPreferredSize(new Dimension(400, 30));
        panelPrecio.add(etiquetaPrecio);
        panelPrecio.add(textFieldPrecio);

        // Panel Peso
        Panel panelPeso = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaPeso = new Label("Ingrese el peso del producto:");
        etiquetaPeso.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaPeso.setPreferredSize(new Dimension(400, 30));
        textFieldPeso = new TextField();
        textFieldPeso.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldPeso.setPreferredSize(new Dimension(400, 30));
        panelPeso.add(etiquetaPeso);
        panelPeso.add(textFieldPeso);

        // Panel Proveedor ID
        Panel panelProveedorID = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label etiquetaProveedorID = new Label("Ingrese el ID del proveedor:");
        etiquetaProveedorID.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaProveedorID.setPreferredSize(new Dimension(400, 30));
        textFieldProveedorID = new TextField();
        textFieldProveedorID.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldProveedorID.setPreferredSize(new Dimension(400, 30));
        panelProveedorID.add(etiquetaProveedorID);
        panelProveedorID.add(textFieldProveedorID);

        // Panel inferior con botones de acción
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


        // ActionListener para el botón "Agregar Producto"
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = textFieldID.getText().trim();
                String nombre = textFieldNombre.getText().trim();
                String precioStr = textFieldPrecio.getText().trim();
                String pesoStr = textFieldPeso.getText().trim();
                String proveedorID = textFieldProveedorID.getText().trim();

                // Validación: verificar que no haya campos vacíos
                if (codigo.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || pesoStr.isEmpty() || proveedorID.isEmpty()) {
                    System.out.println("Por favor, complete todos los campos.");
                    textFieldEstado.setText("Complete todos los campos.");
                    return;
                }

                // Conversión
                double precioUnitario = Double.parseDouble(precioStr);
                double peso = Double.parseDouble(pesoStr);

                // Buscar proveedor con idPersona igual al ingresado
                Proveedor proveedor = null;
                for (Proveedor p : proveedores) {
                    if (p.getIdPersona().equals(proveedorID)) {
                        proveedor = p;
                        break;
                    }
                }

                if (proveedor != null) {
                    ProductoAlimento nuevoProducto = new ProductoAlimento(codigo, nombre, precioUnitario, proveedor, peso);
                    productosAlimento.add(nuevoProducto);
                    productos.add(nuevoProducto);
                    proveedor.agregarProducto(nuevoProducto);

                    // Limpiar campos
                    textFieldID.setText("");
                    textFieldNombre.setText("");
                    textFieldPrecio.setText("");
                    textFieldPeso.setText("");
                    textFieldProveedorID.setText("");

                    textFieldEstado.setText("Producto agregado correctamente.");
                    System.out.println("Producto agregado correctamente.");
                } else {
                    System.out.println("Proveedor no encontrado.");
                    textFieldEstado.setText("Proveedor no encontrado.");
                }
            }
        });

        // ActionListener para el botón "Volver"
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });

        // Agregar los paneles al panelCentral
        panelCentral.add(panelID);
        panelCentral.add(panelNombre);
        panelCentral.add(panelPrecio);
        panelCentral.add(panelPeso);
        panelCentral.add(panelProveedorID);

        // Agregar el panel central a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Mostrar la ventana
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });
    }
}