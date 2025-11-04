package Usuarios;

import Excepciones.incorrectPasswordException;
import Usuarios.Cliente.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Usuario {

    private String id;
    private String nombre;
    private String email;
    private String password;
    private String rol;
    private final LocalDate fechaRegistro;
    private EstadoCuenta estadoCuenta;

    Scanner sc = new Scanner(System.in);

    public Usuario(String id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaRegistro = LocalDate.now();
        this.estadoCuenta = EstadoCuenta.INACTIVA;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public boolean autenticarPassword(String inputPassword) {
        return inputPassword.equals(getPassword());
    }

    public void cambiarPassword(String actualPassword) {
        while(!autenticarPassword(actualPassword)) {
            throw new incorrectPasswordException("Contraseña incorrecta");
        }
        String newPassword = sc.nextLine();
        setPassword(newPassword);
    }

    public EstadoCuenta revisarEstadoCuenta() {
        return estadoCuenta;
    }

    public void reactivarCuenta(String id) {
        if (id.equals(this.id)) {
            System.out.println("Cuenta Reactivada con Exito");
            estadoCuenta = EstadoCuenta.ACTIVA;
        } else {
            System.out.println("Proceso no aprobado");
        }
    }
}
