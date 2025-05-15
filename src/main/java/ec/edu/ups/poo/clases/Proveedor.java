package ec.edu.ups.poo.clases;

import java.util.List;
import java.util.ArrayList;

public class Proveedor extends Persona {
    private String ruc;
    private String rubro;
    private List<Producto> listaProductos;

    //Constructores
    public Proveedor() {
        this.listaProductos = new ArrayList<>();
    }

    public Proveedor(String idPersona, String nombre, String correo, String ruc, String rubro) {
        super(idPersona, nombre, correo);
        this.ruc = ruc;
        this.rubro = rubro;
        this.listaProductos = new ArrayList<>();
    }

    //Método para agregar productos
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    //Getters y Setters
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRubro() {
        return rubro;
    }
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void imprimirProveedores(List<Proveedor> proveedores) {
        if (proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
            return;
        }
        for (Proveedor proveedor : proveedores) {
            System.out.println();
            System.out.println("ID: " + proveedor.getIdPersona()
                    + " | Nombre: " + proveedor.getNombre()
                    + " | Rubro: " + proveedor.getRubro()
                    + " | Correo: " + proveedor.getCorreo());

            if (proveedor.getListaProductos().isEmpty()) {
                System.out.println("No hay productos registrados.");
            } else {
                System.out.println("Lista Productos: ");
                for (Producto producto : proveedor.getListaProductos()) {
                    System.out.print("[ " + producto.getNombre() + " ] ");
                }
            }
            System.out.println();
        }
    }


    //toString
    @Override
    public String toString() {
        return "Proveedor {" +
                "idPersona='" + getIdPersona() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", ruc='" + ruc + '\'' +
                ", rubro='" + rubro + '\'' +
                ", listaProductos=" + listaProductos +
                '}';
    }
}