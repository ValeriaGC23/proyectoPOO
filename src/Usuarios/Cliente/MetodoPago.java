package Usuarios.Cliente;

import SubsistemaComercial.Compra.Compra;
import SubsistemaComercial.Compra.EstadoCompra;

public record MetodoPago(int id, TipoPago tipo, Cliente cliente, int numeroOculto) {
    public void confirmarPago(int numeroConfirmacion, Compra compra) {

        if(numeroConfirmacion != numeroOculto) {
            System.out.println("Pago rechazado: Intente de nuevo");
        }
        else {
            compra.setEstado(EstadoCompra.PAGADA);
            System.out.println(EstadoCompra.PAGADA);
        }
    }
}
