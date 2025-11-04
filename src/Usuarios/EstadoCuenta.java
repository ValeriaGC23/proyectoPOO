package Usuarios;

public enum EstadoCuenta {

    ACTIVA ("Su cuenta está activa"),
    INACTIVA ("Su cuenta esta inactiva");

    private final String mensaje;

    EstadoCuenta(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getMensaje() {
        return mensaje;
    }
}
