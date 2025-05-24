package ec.edu.ups.poo.ventanasProducto;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ProductoTecnologia;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.ventanasListar.VentanaListaProveedores;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class VentanaProductoTecnologia extends Frame {

    private Button btnAgregar, btnVolver, btnMostrarProveedores;
    private TextField textFieldID, textFieldNombre, textFieldPrecio, textFieldGama, textFieldProveedorID, textFieldEstado;
    private Frame ventanaAnterior;
    private List<Proveedor> proveedores;
    private List<ProductoTecnologia> productosTecnologia;
    private List<Producto> productos;

    public VentanaProductoTecnologia(Frame ventanaAnterior, List<Proveedor> proveedores, List<ProductoTecnologia> productosTecnologia,
                                     List<Producto> productos) {
    }
}