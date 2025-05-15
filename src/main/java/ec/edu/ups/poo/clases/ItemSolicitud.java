package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.interfaces.Calculable;

public class ItemSolicitud implements Calculable {
    private Producto producto;
    private int cantidad;

    public ItemSolicitud() {}

    public ItemSolicitud(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Implementación del método de la interfaz Calculable
    @Override
    public double calcularTotal() {
        return cantidad * producto.getPrecioUnitario();
    }

    @Override
    public String toString() {
        return "ItemSolicitud{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", total=" + calcularTotal() +
                '}';
    }

}