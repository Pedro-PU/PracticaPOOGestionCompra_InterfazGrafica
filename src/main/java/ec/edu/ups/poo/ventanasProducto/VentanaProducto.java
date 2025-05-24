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
    }
}