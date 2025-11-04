package Usuarios.Cliente;

import Excepciones.noCarritoException;
import SubsistemaComercial.Compra.Compra;
import SubsistemaComercial.Producto.Producto;
import Usuarios.EstadoCuenta;
import Usuarios.Usuario;
import SubsistemaComercial.Carrito.Carrito;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String direccion;
    private String telefono;
    private List<MetodoPago> metodoPagos;
    private Carrito carrito;
    private List<Compra> historialCompras;

    public Cliente(String id, String nombre, String email, String password, String direccion, String telefono) {
        super(id, nombre, email, password);
        this.direccion = direccion;
        this.telefono = telefono;
        this.metodoPagos = new ArrayList<MetodoPago>();
        this.carrito = new Carrito(this);
        this.historialCompras = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<MetodoPago> getMetodoPagos() {
        return metodoPagos;
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        this.metodoPagos.add(metodoPago);
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }

    public void agregarHistorialCompras(Compra compra) {
        historialCompras.add(compra);
    }
}
