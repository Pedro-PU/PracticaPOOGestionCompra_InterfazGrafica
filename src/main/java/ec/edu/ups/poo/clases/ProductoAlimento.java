package ec.edu.ups.poo.clases;

import java.util.List;

public class ProductoAlimento extends Producto {
    private double peso;

    //Constructores
    public ProductoAlimento() {
    }

    public ProductoAlimento(String codigo, String nombre, double precioUnitario, Proveedor proveedor, double peso) {
        super(codigo, nombre, precioUnitario, proveedor);
        this.peso = peso;
    }

    //Getters y Setters
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    @Override
    public double calcularCostoEspecial() {
        return getPrecioUnitario() * peso;
    }

    //Método para imprimir los productos de alimentos
    public void imprimirProductoAlimento(List<ProductoAlimento> productoAlimentos) {
        if (productoAlimentos.isEmpty()) {
            System.out.println("No hay productos de alimentos registrados.");
            return;
        }
        for (int i = 0; i < productoAlimentos.size(); i++) {
            if (productoAlimentos.get(i) != null) {
                System.out.println("ID: " + productoAlimentos.get(i).getCodigo()
                        + " | Nombre: " + productoAlimentos.get(i).getNombre()
                        + " | Precio Unitario: " + productoAlimentos.get(i).getPrecioUnitario()
                        + " | Peso: " + productoAlimentos.get(i).getPeso() + " kg");
            } else {
                System.out.println("No hay productos de alimentos registrados.");
            }
        }
    }


    //toString
    @Override
    public String toString() {
        return "ProductoAlimento {codigo='" + getCodigo() + "', nombre='" + getNombre() +
                "', precioUnitario=" + getPrecioUnitario() + ", peso=" + peso + " kg}";
    }
}
