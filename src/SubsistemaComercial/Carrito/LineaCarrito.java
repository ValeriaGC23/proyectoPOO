package SubsistemaComercial.Carrito;

import SubsistemaComercial.Producto.Producto;
import com.sun.jdi.InvalidLineNumberException;

public class LineaCarrito {

    private Producto producto;
    private int cantidad;

    public LineaCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        if (cantidad <= 0) {
            throw new InvalidLineNumberException("La cantidad de productos a elegir debe ser mayor a 0");
        } else {
            this.cantidad = cantidad;
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new InvalidLineNumberException("La cantidad de productos a elegir debe ser mayor a 0");
        }
        else {
            this.cantidad = cantidad;
        }

    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
