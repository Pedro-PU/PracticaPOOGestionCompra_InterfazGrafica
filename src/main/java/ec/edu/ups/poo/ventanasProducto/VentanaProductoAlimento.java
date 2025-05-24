package ec.edu.ups.poo.ventanasProducto;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.ventanasListar.VentanaListaProveedores;
import ec.edu.ups.poo.clases.ProductoAlimento;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaProductoAlimento extends Frame {

    private Button btnAgregar, btnVolver, btnMostrarProveedores;
    private TextField textFieldID, textFieldNombre, textFieldPrecio, textFieldPeso,
            textFieldProveedorID, textFieldEstado;
    private List<ProductoAlimento> productosAlimento;
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private Proveedor proveedorSeleccionado;
    private Frame ventanaAnterior;

    public VentanaProductoAlimento(Frame ventanaAnterior, List<Proveedor> proveedores, List<ProductoAlimento> productosAlimento,
                                   List<Producto> productos) {

    }
}