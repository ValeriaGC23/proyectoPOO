package SubsistemaComercial.Compra;

import SubsistemaComercial.Carrito.LineaCarrito;
import SubsistemaComercial.Producto.Producto;

public class LineaCompra {

    private Producto producto;
    private int cantidad;

    public LineaCompra(LineaCarrito linea) {
        this.producto = linea.getProducto();
        this.cantidad = linea.getCantidad();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double subtotal() {
        return producto.getPrecio()*cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() + "         Cantidad: " + cantidad;
    }
}
