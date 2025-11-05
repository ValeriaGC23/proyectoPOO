package Usuarios.Cliente;

import SubsistemaComercial.Compra.EstadoCompra;

public record MetodoPago(int id, TipoPago tipo, Cliente cliente, int numeroOculto) {
    public void confirmarPago(int numeroConfirmacion) {

        if(numeroConfirmacion != numeroOculto) {
            System.out.println("Pago rechazado: Intente de nuevo");
        }
        else {
            System.out.println(EstadoCompra.PAGADA);
        }
    }
}
