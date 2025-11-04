package SubsistemaComercial.Producto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaProducto {

    int id;
    String nombre;
    String descripcion;
    private List<Producto> productosCategoria = new ArrayList<>();

    public CategoriaProducto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarProductos(Producto producto) {
        productosCategoria.add(producto);
    }

    public List<Producto> listarProductos() {
        return productosCategoria;
    }

    public void mostrarProductos() {
        System.out.println("\nProductos en la categoría " + nombre + ":\n");
        for (Producto p : productosCategoria) {
            System.out.println("- " + p.getNombre() + " - " + p.getDescripcion() + " - " + p.getPrecio());
        }
    }

}
