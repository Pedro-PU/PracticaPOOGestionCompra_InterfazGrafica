package ec.edu.ups.poo.clases;

public abstract class Producto {
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private Proveedor proveedor;//quitar

    //Constructores
    public Producto() {}
    public Producto(String codigo, String nombre, double precioUnitario, Proveedor proveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.proveedor = proveedor;
    }

    //Getters y Setter
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    //Método abstracto
    public abstract double calcularCostoEspecial();
}

