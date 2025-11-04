package Usuarios.Cliente;

import SubsistemaComercial.Compra.EstadoCompra;

public record MetodoPago(int id, TipoPago tipo, Cliente cliente, int numeroOculto) {
    public void confirmarPago(int numeroConfirmacion) {
        for (int i = 0; i < 3; i++) {
            if(numeroConfirmacion != numeroOculto) {
                System.out.println("Pago rechazado: Intente de nuevo");
            }
            if (i == 2) {
                System.out.println(EstadoCompra.CANCELADA);
            }
        }
        if (numeroOculto == numeroConfirmacion) {
            System.out.println(EstadoCompra.PAGADA);
        }
    }
}
