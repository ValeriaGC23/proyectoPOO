package SubsistemaComercial.Compra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

import SubsistemaComercial.Carrito.Carrito;
import SubsistemaComercial.Carrito.LineaCarrito;
import SubsistemaComercial.Producto.Producto;
import Usuarios.Cliente.Cliente;

public class Compra {
    private static int idCompra = 0;
    private Cliente cliente;
    private final LocalDateTime fechaCompra;
    private double total;
    private EstadoCompra estado;
    private List<LineaCompra> lineas;

    public Compra(Cliente cliente) {
        this.fechaCompra = LocalDateTime.now();
        this.total = 0.0;
        this.estado = estado;
        this.lineas = new ArrayList<LineaCompra>();
        idCompra++;
    }

    public static int getIdCompra() {
        return idCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void agregarLinea(LineaCompra linea) {
        this.lineas.add(linea);
        total = total + linea.subtotal();
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public List<LineaCompra> getLineas() {
        return lineas;
    }

    public void copiarDesdeCarrito(Carrito carrito) {
        if (carrito.estaVacio()) {
            throw  new IllegalArgumentException("No se puede crear una compra: El carrito está  vacio");
        } else {
            for (int i = 0; i < carrito.getLineas().size(); i++) {
                LineaCarrito linea = carrito.getLineas().get(i);
                LineaCompra nuevaLinea = new LineaCompra(linea);
                agregarLinea(nuevaLinea);
            }
        }
    }
    public void confirmarCompra() {
        this.estado = EstadoCompra.PAGADA;
    }
    public void cancelarCompra() {
        this.estado = EstadoCompra.CANCELADA;
        lineas.clear();
    }

    public double getTotal() {
        return total;
    }

    public void mostrarCompra() {
        System.out.println("\n=== FACTURA ===");
        System.out.println("ID: " + idCompra);
        System.out.println("Fecha de Compra: " + fechaCompra);

        for (LineaCompra linea : lineas) {
            System.out.println(" - " + lineas.toString());
        }

        System.out.println("Total: $" + total);
    }
}
