package ec.edu.ups.poo.ventanas;

import java.awt.*;

public class VentanaProductoAlimento extends Frame {

    public VentanaProductoAlimento() {
        setTitle("Productos");
        setSize(1500, 800); // Tamaño más compacto
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("PRODUCTOS ALIMENTOS", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        add(titulo, BorderLayout.NORTH);

        // Panel Central con GridLayout (organiza los paneles verticalmente)
        Panel panelCentral = new Panel(new GridLayout(5, 1, 10, 10));

        // Panel ID
        Panel panelID = new Panel(new GridLayout(1, 1));
        Label etiquetaID = new Label("Ingrese el ID del producto:");
        etiquetaID.setFont(new Font("Arial", Font.PLAIN, 18));
        TextField textFieldID = new TextField(20);
        textFieldID.setFont(new Font("Arial", Font.PLAIN, 18));
        panelID.add(etiquetaID);
        panelID.add(textFieldID);

        // Panel Nombre
        Panel panelNombre = new Panel(new GridLayout(1, 1));
        Label etiquetaNombre = new Label("Ingrese el nombre del producto:");
        etiquetaNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaNombre.setPreferredSize(new Dimension(400, 30));
        TextField textFieldNombre = new TextField(20);
        textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldNombre.setPreferredSize(new Dimension(400, 30));
        panelNombre.add(etiquetaNombre);
        panelNombre.add(textFieldNombre);

        // Panel Precio
        Panel panelPrecio = new Panel(new GridLayout(1, 1));
        Label etiquetaPrecio = new Label("Ingrese el precio del producto:");
        etiquetaPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaPrecio.setPreferredSize(new Dimension(400, 30));
        TextField textFieldPrecio = new TextField(20);
        textFieldPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldPrecio.setPreferredSize(new Dimension(400, 30));
        panelPrecio.add(etiquetaPrecio);
        panelPrecio.add(textFieldPrecio);

        // Panel Cantidad
        Panel panelCantidad = new Panel(new GridLayout(1, 1));
        Label etiquetaCantidad = new Label("Ingrese la cantidad del producto:");
        etiquetaCantidad.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaCantidad.setPreferredSize(new Dimension(400, 30));
        TextField textFieldCantidad = new TextField(20);
        textFieldCantidad.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldCantidad.setPreferredSize(new Dimension(400, 30));
        panelCantidad.add(etiquetaCantidad);
        panelCantidad.add(textFieldCantidad);

        // Panel Peso
        Panel panelPeso = new Panel(new GridLayout(1, 1));
        Label etiquetaPeso = new Label("Ingrese el peso del producto:");
        etiquetaPeso.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaPeso.setPreferredSize(new Dimension(400, 30));
        TextField textFieldPeso = new TextField(20);
        textFieldPeso.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldPeso.setPreferredSize(new Dimension(400, 30));
        panelPeso.add(etiquetaPeso);
        panelPeso.add(textFieldPeso);

        // Agregar los paneles al `panelCentral`
        panelCentral.add(panelID);
        panelCentral.add(panelNombre);
        panelCentral.add(panelPrecio);
        panelCentral.add(panelCantidad);
        panelCentral.add(panelPeso);

        // Agregar el panel central a la ventana
        add(panelCentral, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }
}