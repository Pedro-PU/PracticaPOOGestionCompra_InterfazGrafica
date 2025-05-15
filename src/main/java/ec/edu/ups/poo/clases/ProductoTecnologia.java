package ec.edu.ups.poo.clases;

import java.util.List;

public class ProductoTecnologia extends Producto{
    private String gama;

    //Constructores
    public ProductoTecnologia() {
    }
    public ProductoTecnologia(String codigo, String nombre, double precioUnitario, Proveedor proveedor, String gama) {
        super(codigo, nombre, precioUnitario, proveedor);
        this.gama = gama;
    }
    
    //Getters y Setters
    public String getGama() {
        return gama;
    }
    public void setGama(String gama) {
        this.gama = gama;
    }

    //Método para imprimir los productos de tecnología
    public void imprimirProductoTecnologia(List<ProductoTecnologia> productoTecnologia) {
        if (productoTecnologia.isEmpty()) {
            System.out.println("No hay productos de tecnologícos registrados.");
            return;
        }
        for (int i = 0; i < productoTecnologia.size(); i++) {
            if (productoTecnologia.get(i) != null) {
                System.out.println("ID: " + productoTecnologia.get(i).getCodigo()
                        + " | Nombre: " + productoTecnologia.get(i).getNombre()
                        + " | Precio Unitario: " + productoTecnologia.get(i).getPrecioUnitario()
                        + " | Gama: " + productoTecnologia.get(i).getGama());
            } else {
                System.out.println("No hay productos de tecnología registrados.");
            }
        }
    }


    @Override
    public double calcularCostoEspecial() {
        switch (gama) {
            case "Baja":
                return getPrecioUnitario() * 1.05;
            case "Media":
                return getPrecioUnitario() * 1.10;
            case "Alta":
                return getPrecioUnitario() * 1.15;
            default:
                return getPrecioUnitario();
        }
    }

    //toString
    @Override
    public String toString() {
        return "ProductoTecnologia {codigo='" + getCodigo() + "', nombre='" + getNombre() +
                "', precioUnitario=" + getPrecioUnitario() + ", gama='" + gama + "'}";
    }

}
