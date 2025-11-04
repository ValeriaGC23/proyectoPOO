package SubsistemaComercial.Carrito;

import SubsistemaComercial.Producto.Producto;
import Usuarios.Cliente.Cliente;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carrito {

    private UUID id = UUID.randomUUID();
    private Cliente cliente;
    private final LocalDateTime fechaCreacion;
    private List<LineaCarrito> lineas;

    public Carrito(Cliente cliente) {
        this.fechaCreacion = LocalDateTime.now();
        this.lineas = new ArrayList<>();
        this.cliente = cliente;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void agregarProducto (Producto producto, int cantidad) {
        LineaCarrito linea = new LineaCarrito(producto, cantidad);
        if (linea.getProducto().getId() == producto.getId()) {
            linea.setCantidad(linea.getCantidad() + cantidad);
        } else if (producto == null) {
            throw new IllegalArgumentException("No agregaste ningun producto");
        } else if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad inválida");
        } else if (producto.getStock() < cantidad) {
            throw new IllegalArgumentException("Stock insuficiente");
        } else {
            lineas.add(linea);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaCarrito l : lineas) {
            total += l.getSubtotal();
        }
        return total;
    }

    public void mostrarCarrito() {

        if (lineas.isEmpty()) {
            System.out.println("El carrito esta vacio");
        } else {
            System.out.println("\n=== CARRITO DE COMPRAS ===");
            for (LineaCarrito linea : lineas) {
                Producto p = linea.getProducto();
                System.out.println("- " + p.getNombre() + " x" + linea.getCantidad() +
                        " = $" + linea.getSubtotal());
            }
            System.out.println("Total: $" + calcularTotal());
        }
    }

    public void vaciarCarrito(){
        lineas.clear();
    }

    public void eliminarProducto(int idProducto) {
        try {
            if (idProducto >= 0 && idProducto < lineas.size()) {
                lineas.remove(idProducto);
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Elige un numero valido");
        }
    }

    public boolean estaVacio() {
        return lineas.isEmpty();
    }

    public List<LineaCarrito> getLineas() {
        return lineas;
    }
}