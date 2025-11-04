import SubsistemaComercial.Carrito.Carrito;
import SubsistemaComercial.Producto.*;
import Usuarios.Cliente.Cliente;
import Usuarios.Cliente.MetodoPago;
import Usuarios.Cliente.TipoPago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ======== Categorías de productos ========
        CategoriaProducto labiales = new CategoriaProducto(1, "Labiales", "Colores y acabados para labios");
        CategoriaProducto bases = new CategoriaProducto(2, "Bases", "Cobertura y tono uniforme de piel");
        CategoriaProducto cremas = new CategoriaProducto(3, "Cremas", "Hidratación y cuidado facial");
        CategoriaProducto perfumes = new CategoriaProducto(4, "Perfumes", "Fragancias exclusivas Glow Up");


        // ======== Productos ========

        // --- LABIALES ---
        Producto p1 = new Producto(101, "Labial Velvet Kiss",
                "Labial líquido de textura aterciopelada, tono rubí intenso",
                55800, 25, LocalDate.of(2024, 3, 15), labiales);

        Producto p2 = new Producto(102, "Gloss Crystal Shine",
                "Brillo labial con acabado espejo y vitamina E",
                27988, 30, LocalDate.of(2024, 4, 10), labiales);

        // --- BASES ---
        Producto p3 = new Producto(201, "Base Radiant Skin",
                "Base hidratante con acabado luminoso para piel seca",
                89500, 18, LocalDate.of(2024, 5, 22), bases);

        Producto p4 = new Producto(202, "Base Matte Perfect",
                "Base ligera de cobertura completa para piel grasa",
                92000, 15, LocalDate.of(2024, 6, 5), bases);

        // --- CREMAS ---
        Producto p5 = new Producto(301, "Crema HydraLuxe",
                "Crema facial con ácido hialurónico y extracto de té verde",
                120000, 12, LocalDate.of(2024, 1, 30), cremas);

        Producto p6 = new Producto(302, "Crema Night Repair",
                "Tratamiento nocturno regenerador con colágeno",
                135000, 10, LocalDate.of(2024, 2, 18), cremas);

        // --- PERFUMES ---
        Producto p7 = new Producto(401, "Perfume Sakura Essence",
                "Fragancia floral inspirada en los cerezos japoneses",
                210000, 9, LocalDate.of(2024, 3, 5), perfumes);

        Producto p8 = new Producto(402, "Perfume Midnight Bloom",
                "Aroma dulce con notas de vainilla y jazmín",
                150000, 11, LocalDate.of(2024, 5, 1), perfumes);

        // ======== Clientes ========

        Cliente c1 = new Cliente("14379", "María López", "maria@gmail.com", "1234", "Calle Luna 45", "3004567890");
        Cliente c2 = new Cliente("24642", "Carlos Méndez", "Carlos@hotmail.com", "abcd", "Av. del Sol 120", "3105552233");
        Cliente c3 = new Cliente("31234", "Valentina Ríos", "valentina@gmail.com", "pass123", "Cra 12 #8-45", "3157788990");

        // ======== Metodos de pago ========

        MetodoPago m1 = new MetodoPago(74638, TipoPago.TARJETA_CREDITO, c1, 791739123);
        c1.agregarMetodoPago(m1);
        MetodoPago m2 = new MetodoPago(63638, TipoPago.TRANSFERENCIA, c1, 938855885);
        c1.agregarMetodoPago(m2);
        MetodoPago m3 = new MetodoPago(54099, TipoPago.EFECTIVO, c2, 0);
        c2.agregarMetodoPago(m3);
        MetodoPago m4 = new MetodoPago(12397, TipoPago.TARJETA_DEBITO, c3, 333975475);
        c3.agregarMetodoPago(m4);

        List<Producto> productos = new ArrayList<>();
        List<CategoriaProducto> categorias = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        categorias.add(labiales);
        categorias.add(bases);
        categorias.add(cremas);
        categorias.add(perfumes);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);

        //MENU
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n===== MENÚ GLOW UP =====");
            System.out.println("¿Con qué te podemos ayudar el día de hoy?\n");
            System.out.println("1. Ver todos los productos");
            System.out.println("2. Consultar productos por categoría");
            System.out.println("3. Registrarse como cliente");
            System.out.println("4. Iniciar sesión");
            System.out.println("5. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar Scanner

            switch (opcion) {
                case 1:
                    mostrarCatalogo(productos);
                    break;

                case 2:
                    System.out.println("\nCategorias: \n");
                    int contador = 1;
                    for (CategoriaProducto c : categorias) {
                        System.out.print(contador + ". ");
                        System.out.println(c.getNombre() + " - " + c.getDescripcion());
                        contador++;
                    }

                    System.out.print("\nElige una opción: ");
                    int numCategoria = sc.nextInt();
                    sc.nextLine();

                    categorias.get(numCategoria - 1).mostrarProductos();
                    break;

                case 3:
                    System.out.print("\nNumero de identificación: ");
                    String id = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    for (Cliente c : clientes) {
                        if (c.getEmail().equals(email)) {
                            System.out.println("❌ Ya existe una cuenta con ese correo. Inicie sesión");
                            break;
                        }
                    }

                    System.out.print("Contraseña: ");
                    String password = sc.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    Cliente nuevo = new Cliente(id, nombre, email, password, direccion, telefono);
                    clientes.add(nuevo);
                    break;

                case 4:
                   int intentos =  1;

                    while (intentos <= 3) {
                        if (intentos == 3) {
                            System.out.println("Ultimo intento");
                        }

                        boolean correcto = false;

                        System.out.print("Email: ");
                        String correo = sc.nextLine();

                        System.out.print("Contraseña: ");
                        String pass = sc.nextLine();

                        for (Cliente c : clientes) {
                            if (c.getEmail().equals(correo) && c.getPassword().equals(pass)) {
                                intentos = 4;
                                correcto = true;
                                System.out.println("\n-- Bienvenido a Glow Up -- \n  Usuario: " + c.getNombre());
                                submenuCliente(c);
                                break;
                            }
                        }

                        if (correcto == false) {
                            intentos++;
                            if (intentos < 3) {
                                System.out.println("Correo o contraseña inválida, Intente nuevamente");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Gracias por visitar Glow Up");
                    break;

                default:
                    System.out.println("⚠ Opción no válida, intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }

    //MOSTRAR CATALOGO
    private  static void mostrarCatalogo(List<Producto> productos){
        System.out.println("\n=== CATÁLOGO COMPLETO ===\n");

        for (Producto p : productos) {
            System.out.println("ID: " + p.getId() + " - " + p.getNombre() + " - " + p.getDescripcion() + " - $" + p.getPrecio());
        }
    }

    //MENU SECUNDARIO
    private static void submenuCliente(Cliente cliente, List<Producto> productos) {
        Scanner sc2 = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n===== MENÚ CLIENTE =====\n");
            System.out.println("1. Ver carrito");
            System.out.println("2. Limpiar carrito");
            System.out.println("3. Agregar productos al carrito");
            System.out.println("4. Eliminar productos del carrito");
            System.out.println("5. Comprar");
            System.out.println("6. Cancelar compra");
            System.out.println("7. Ver historial de compras");
            System.out.println("8. Configurar mis metodos de pago");
            System.out.println("9. Cerrar sesión");
            System.out.print("\nSeleccione una opción: ");
            op = sc2.nextInt();
            sc2.nextLine(); // limpiar Scanner

            switch (op) {
                case 1:
                    cliente.getCarrito().mostrarCarrito();
                    break;

                case 2:
                    cliente.getCarrito().vaciarCarrito();
                    break;

                case 3:
                    mostrarCatalogo(productos);
                    System.out.println("Ingrese el ID del producto que quiera añadir al carrito");
                    for (Producto p : productos) {

                    }
                    cliente.getCarrito().agregarProducto();

/*

                    System.out.print("ID categoría: ");
                    int idCat = leerInt(sc);
                    System.out.println("\n=== Productos de esa categoría ===");
                    boolean hay = false;
                    for (Producto p : productos) {
                        if (p.getCategoria().getId() == idCat) {
                            System.out.println(p);
                            hay = true;
                        }
                    }
                    if (!hay) System.out.println("(sin productos)");
                }

                case 4 -> {
                    mostrarProductos(productos);
                    System.out.print("ID producto: ");
                    int idProd = leerInt(sc);
                    Producto seleccionado = null;
                    for (Producto p : productos) {
                        if (p.getId() == idProd) { seleccionado = p; break; }
                    }
                    if (seleccionado == null) {
                        System.out.println("❌ Producto no encontrado.");
                        break;
                    }
                    System.out.print("Cantidad: ");
                    int cant = leerInt(sc);
                    try {
                        cliente.agregarAlCarrito(seleccionado, cant);
                        System.out.println("✅ Agregado al carrito.");
                    } catch (Exception e) {
                        System.out.println("⚠ " + e.getMessage());
                    }
                }

                case 5 -> cliente.mostrarCarrito();

                case 6 -> {
                    try {
                        Compra compraPrev = cliente.generarCompraDesdeCarrito();
                        System.out.println("✅ Previsualización de compra:");
                        compraPrev.mostrarCompra();
                    } catch (Exception e) {
                        System.out.println("⚠ " + e.getMessage());
                    }
                }

                case 7 -> {
                    if (cliente.getCarrito().estaVacio()) {
                        System.out.println("❌ Carrito vacío.");
                        break;
                    }
                    // Generamos la compra a pagar
                    Compra compra = cliente.generarCompraDesdeCarrito();
                    System.out.println("Total a pagar: $" + compra.getTotal());

                    // Elegir método de pago: usar guardado o crear uno rápido
                    if (cliente.getMetodos().isEmpty()) {
                        System.out.println("No tienes métodos guardados. Creemos uno rápido:");
                        System.out.print("Titular tarjeta: ");
                        String titular = sc.nextLine();
                        MetodoPago mp = new TarjetaCredito(titular, "**** **** **** 1234", "123");
                        cliente.agregarMetodoPago(mp);
                    }

                    System.out.println("\nElige método de pago:");
                    cliente.mostrarMetodosPago();
                    System.out.print("Número (1..n): ");
                    int idx = Math.max(1, leerInt(sc)) - 1;
                    if (idx < 0 || idx >= cliente.getMetodos().size()) {
                        System.out.println("❌ Opción inválida.");
                        break;
                    }
                    MetodoPago elegido = cliente.getMetodos().get(idx);

                    boolean ok = cliente.pagarCompra(compra, elegido);
                    if (ok) System.out.println("✅ Pago confirmado.");
                    else    System.out.println("❌ Pago rechazado.");
                }

                case 8 -> cliente.mostrarHistorial();

                case 0 -> System.out.println("👋 Sesión cerrada.");

                default -> System.out.println("⚠ Opción inválida.");
            }
*/


            }
        } while (op != 0);

    }
}

