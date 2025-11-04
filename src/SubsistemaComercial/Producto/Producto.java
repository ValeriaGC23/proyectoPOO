package SubsistemaComercial.Producto;

import Excepciones.invalidNumberException;

import java.time.LocalDate;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private final LocalDate fechaLanzamiento;
    private CategoriaProducto categoria;

    public Producto(int id, String nombre, String descripcion, double precio, int stock, LocalDate fechaLanzamiento, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.fechaLanzamiento = fechaLanzamiento;
        this.categoria = categoria;
        categoria.agregarProductos(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public void mostrarDisponibilidad(){
        if (getStock() >= 1){
            System.out.println("Disponibles en inventario: " + getStock());
        } else if (getStock() == 0){
            System.out.println("Producto agotado");
        } else {
            throw new invalidNumberException("Numero de stock no válido");
        }
    }

    public void mostrarPrecio(){
        System.out.println("Precio: $" + getPrecio());
    }

    public void reducirStock(int cantidad){
        this.setStock(this.getStock() - cantidad);
    }

    public void aumentarStock(int cantidad){
        this.setStock(this.getStock() + cantidad);
    }

}
