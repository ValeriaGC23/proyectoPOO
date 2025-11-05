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

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("No agregaste ningún producto.");
        }
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad inválida (debe ser >= 1).");
        }
        if (producto.getStock() <= 0) {
            throw new IllegalArgumentException("No hay stock disponible.");
        }

        for (LineaCarrito l : lineas) {
            if (l.getProducto().getId() == producto.getId()) {
                int nuevaCantidad = l.getCantidad() + cantidad;

                // Validar stock considerando lo que YA hay en el carrito
                if (nuevaCantidad > producto.getStock()) {
                    throw new IllegalArgumentException("Stock insuficiente. " + "Unidades disponibles: " + producto.getStock());
                }

                l.setCantidad(nuevaCantidad);
                return;
            }
        }

        // Si no existía línea previa, validar stock y crearla
        if (cantidad > producto.getStock()) {
            throw new IllegalArgumentException("Stock insuficiente. " + "Unidades disponibles: " + producto.getStock());
        }

        lineas.add(new LineaCarrito(producto, cantidad));
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
                System.out.println("ID: " + p.getId() + " - " + p.getNombre() + " x" + linea.getCantidad() + " = $" + linea.getSubtotal());
            }
            System.out.println("Total: $" + calcularTotal());
        }
    }

    public void vaciarCarrito(){
        lineas.clear();
    }

    public void eliminarProducto(int idProducto) {
        boolean encontrado = false;

        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).getProducto().getId() == idProducto) {
                lineas.remove(i);
                encontrado = true;
                System.out.println("✅ Producto eliminado del carrito.");
            }
        }
        if (encontrado == false) {
            System.out.println("No existe el producto con el id " + idProducto);;
        }
    }

    public boolean estaVacio() {
        return lineas.isEmpty();
    }

    public List<LineaCarrito> getLineas() {
        return lineas;
    }
}