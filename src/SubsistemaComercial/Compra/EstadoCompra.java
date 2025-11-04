package SubsistemaComercial.Compra;

public enum EstadoCompra {

    CREADA ("Compra creada con exito"),
    PAGADA ("Gracias por su compra"),
    CANCELADA ("Compra cancelada");

    private final String mensaje;
    EstadoCompra(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }

}
