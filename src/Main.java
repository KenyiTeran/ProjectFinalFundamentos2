import java.util.InputMismatchException; // Importa la excepción para manejar entradas inválidas de datos
import java.util.Scanner; // Importa la clase Scanner para recibir entrada de datos del usuario

public class Main {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Crea una instancia de la clase Empresa, que manejará los productos y usuarios
        Empresa empresa = new Empresa();

        // Agrega productos predeterminados al inventario de la empresa.
        try {
            empresa.agregarProducto(new Telas(50.0, "T001", "Tela A", "Rojo", "Alta", "Algodón", "Liso", "Baja"));
            empresa.agregarProducto(new Telas(60.0, "T002", "Tela B", "Azul", "Media", "Poliéster", "Tejido", "Media"));
            empresa.agregarProducto(new Telas(70.0, "T003", "Tela C", "Verde", "Alta", "Seda", "Estampado", "Alta"));
            empresa.agregarProducto(new Telas(80.0, "T004", "Tela D", "Amarillo", "Baja", "Lana", "Cuadros", "Baja"));
            empresa.agregarProducto(new Telas(90.0, "T005", "Tela E", "Negro", "Media", "Lino", "Liso", "Media"));

            empresa.agregarProducto(new Lana(100.0, "L001", "Lana A", "Blanco", "Alta", 200.0, "Oveja", "Suave"));
            empresa.agregarProducto(new Lana(110.0, "L002", "Lana B", "Gris", "Media", 250.0, "Alpaca", "Media"));
            empresa.agregarProducto(new Lana(120.0, "L003", "Lana C", "Marrón", "Baja", 300.0, "Vicuña", "Rústica"));
            empresa.agregarProducto(new Lana(130.0, "L004", "Lana D", "Azul", "Alta", 150.0, "Cachemira", "Extra Suave"));
            empresa.agregarProducto(new Lana(140.0, "L005", "Lana E", "Verde", "Media", 180.0, "Conejo Angora", "Suave"));

            empresa.agregarProducto(new Hilos(20.0, "H001", "Hilo A", "Rojo", "Alta", 1.5, "Algodón"));
            empresa.agregarProducto(new Hilos(30.0, "H002", "Hilo B", "Azul", "Media", 2.0, "Poliéster"));
            empresa.agregarProducto(new Hilos(25.0, "H003", "Hilo C", "Verde", "Baja", 1.0, "Seda"));
            empresa.agregarProducto(new Hilos(35.0, "H004", "Hilo D", "Amarillo", "Alta", 2.5, "Lana"));
            empresa.agregarProducto(new Hilos(40.0, "H005", "Hilo E", "Negro", "Media", 3.0, "Nylon"));
        } catch (Exception e) {
            // Muestra un mensaje de error si ocurre una excepción al agregar productos
            System.out.println("Error al agregar productos predeterminados: " + e.getMessage());
        }


        // Registra un usuario predeterminado para pruebas
        empresa.registrarUsuario(new Usuario("admin", "1234"));

        // Muestra un mensaje de bienvenida
        System.out.println("==================================");
        System.out.println("     TEXTILES JULIACA S.A.        ");
        System.out.println("==================================");
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();  // Espera a que el usuario presione Enter

        // Proceso de inicio de sesión
        boolean loginExitoso = false;
        while (!loginExitoso) {
            try {
                System.out.println("==================================");
                System.out.println("            Iniciar Sesión        ");
                System.out.println("==================================");
                System.out.print("Número de Usuario: ");
                String nombreUsuario = scanner.nextLine();
                System.out.print("Contraseña: ");
                String contraseña = scanner.nextLine();

                // Valida el inicio de sesión con los datos ingresados
                loginExitoso = empresa.iniciarSesion(nombreUsuario, contraseña);
                if (!loginExitoso) {
                    System.out.println("Usuario o contraseña incorrectos. Inténtelo de nuevo.");
                }
            } catch (Exception e) {
                // Muestra un mensaje de error si ocurre una excepción durante el inicio de sesión
                System.out.println("Error durante el inicio de sesión: " + e.getMessage());
            }
        }

        // Menú principal
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("==================================");
                System.out.println("            Menú Principal        ");
                System.out.println("==================================");
                System.out.println("1: Administrador");
                System.out.println("0: Salir");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                // Ejecuta una acción según la opción seleccionada
                switch (opcion) {
                    case 1:
                        mostrarMenuAdministrador(empresa);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Maneja errores de entrada inválida (por ejemplo, si se ingresa texto en lugar de un número)
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine();  // Limpiar el buffer
            } catch (Exception e) {
                // Maneja cualquier otro error que pueda ocurrir
                System.out.println("Error en el menú principal: " + e.getMessage());
            }
        }
        scanner.close();  // Cierra el scanner para liberar recursos
    }

    // Menú de administración
    public static void mostrarMenuAdministrador(Empresa empresa) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            try {
                System.out.println("==================================");
                System.out.println("          Administración          ");
                System.out.println("==================================");
                System.out.println("1: Agregar productos");
                System.out.println("2: Eliminar productos");
                System.out.println("3: Generar cotización");
                System.out.println("4: Visualizar lista de productos del inventario");
                System.out.println("0: Salir");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                // Ejecuta una acción según la opción seleccionada
                switch (opcion) {
                    case 1:
                        // Lógica para agregar productos
                        try {
                            System.out.println("Seleccione el tipo de producto a agregar:");
                            System.out.println("1: Lana");
                            System.out.println("2: Hilo");
                            System.out.println("3: Tela");
                            int tipoProducto = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer

                            // Campos comunes para todos los productos
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese el código del producto: ");
                            String codigo = scanner.nextLine();
                            System.out.print("Ingrese el precio del producto: ");
                            double precio = scanner.nextDouble();
                            scanner.nextLine(); // Limpiar el buffer
                            System.out.print("Ingrese el color del producto: ");
                            String color = scanner.nextLine();
                            System.out.print("Ingrese la calidad del producto: ");
                            String calidad = scanner.nextLine();

                            // Agrega el producto según el tipo seleccionado
                            switch (tipoProducto) {
                                case 1: // Lana
                                    System.out.print("Ingrese el gramaje: ");
                                    double gramaje = scanner.nextDouble();
                                    scanner.nextLine(); // Limpiar el buffer
                                    System.out.print("Ingrese el tipo de animal: ");
                                    String animal = scanner.nextLine();
                                    System.out.print("Ingrese la suavidad: ");
                                    String suavidad = scanner.nextLine();
                                    // Crear y agregar el producto de tipo Lana
                                    empresa.agregarProducto(new Lana(precio, codigo, nombre, color, calidad, gramaje, animal, suavidad));
                                    System.out.println("Producto de tipo Lana agregado exitosamente.");
                                    break;

                                case 2: // Hilo
                                    System.out.print("Ingrese el grosor: ");
                                    double grosor = scanner.nextDouble();
                                    scanner.nextLine(); // Limpiar el buffer
                                    System.out.print("Ingrese el material: ");
                                    String materialHilo = scanner.nextLine();
                                    // Crear y agregar el producto de tipo Hilo
                                    empresa.agregarProducto(new Hilos(precio, codigo, nombre, color, calidad, grosor, materialHilo));
                                    System.out.println("Producto de tipo Hilo agregado exitosamente.");
                                    break;

                                case 3: // Tela
                                    System.out.print("Ingrese el tipo de material: ");
                                    String materialTipo = scanner.nextLine();
                                    System.out.print("Ingrese el tipo de tejido: ");
                                    String tejido = scanner.nextLine();
                                    System.out.print("Ingrese la elasticidad: ");
                                    String elasticidad = scanner.nextLine();
                                    // Crear y agregar el producto de tipo Tela
                                    empresa.agregarProducto(new Telas(precio, codigo, nombre, color, calidad, materialTipo, tejido, elasticidad));
                                    System.out.println("Producto de tipo Tela agregado exitosamente.");
                                    break;

                                default:
                                    System.out.println("Opción inválida. Producto no agregado.");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            // Maneja errores de entrada inválida
                            System.out.println("Entrada no válida. Por favor, ingrese los datos correctamente.");
                            scanner.nextLine(); // Limpiar el buffer
                        } catch (Exception e) {
                            // Maneja cualquier otro error que pueda ocurrir al agregar un producto
                            System.out.println("Error al agregar producto: " + e.getMessage());
                        }
                        break;



                    case 2:
                                    // Lógica para eliminar productos
                                    System.out.println("Seleccione la forma de eliminación:");
                                    System.out.println("1: Eliminar por código de producto");
                                    System.out.println("2: Eliminar seleccionando un tipo de producto");
                                    int metodoEliminacion = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer

                        String codigo;
                        int tipoProducto;
                        if (metodoEliminacion == 1) {
                                        // Primera forma: Eliminar por código
                                        System.out.print("Ingrese el código del producto que desea eliminar: ");
                                        codigo = scanner.nextLine();

                                        Producto producto = empresa.buscarProductoPorCodigo(codigo);
                                        if (producto != null) {
                                            System.out.println("¿Deseas eliminar el producto: " + producto.toString() + "?");
                                            System.out.println("1: Sí");
                                            System.out.println("2: No");
                                            int confirmacion = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer

                                            if (confirmacion == 1) {
                                                if (empresa.eliminarProducto(codigo)) {
                                                    System.out.println("Producto eliminado exitosamente.");
                                                } else {
                                                    System.out.println("Error al eliminar el producto.");
                                                }
                                            } else {
                                                System.out.println("Eliminación cancelada.");
                                            }
                                        } else {
                                            System.out.println("Producto no encontrado.");
                                        }

                                    } else if (metodoEliminacion == 2) {
                                        // Segunda forma: Seleccionar tipo de producto
                                        System.out.println("Seleccione el tipo de producto:");
                                        System.out.println("1: Lana");
                                        System.out.println("2: Hilo");
                                        System.out.println("3: Tela");
                                        tipoProducto = scanner.nextInt();
                                        scanner.nextLine(); // Limpiar el buffer

                                        // Mostrar productos del tipo seleccionado
                                        empresa.visualizarListaProductosPorTipo(tipoProducto);

                                        // Solicitar el código del producto para eliminar
                                        System.out.print("Ingrese el código del producto que desea eliminar: ");
                                        codigo = scanner.nextLine();

                                        Producto producto = empresa.buscarProductoPorCodigo(codigo);
                                        if (producto != null) {
                                            System.out.println("¿Deseas eliminar el producto: " + producto.toString() + "?");
                                            System.out.println("1: Sí");
                                            System.out.println("2: No");
                                            int confirmacion = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer

                                            if (confirmacion == 1) {
                                                if (empresa.eliminarProducto(codigo)) {
                                                    System.out.println("Producto eliminado exitosamente.");
                                                } else {
                                                    System.out.println("Error al eliminar el producto.");
                                                }
                                            } else {
                                                System.out.println("Eliminación cancelada.");
                                            }
                                        } else {
                                            System.out.println("Producto no encontrado.");
                                        }

                                    } else {
                                        System.out.println("Opción inválida. Inténtelo nuevamente.");
                                    }
                                    break;
                                case 3:
                                    // Carrito de compras
                                    double precioTotal = 0.0;
                                    boolean continuarComprando = true;

                                    while (continuarComprando) {
                                        System.out.println("Seleccione el tipo de producto para agregar al carrito:");
                                        System.out.println("1: Lana");
                                        System.out.println("2: Hilo");
                                        System.out.println("3: Tela");
                                        tipoProducto = scanner.nextInt();
                                        scanner.nextLine(); // Limpiar el buffer

                                        // Mostrar productos según el tipo seleccionado
                                        empresa.visualizarListaProductosPorTipo(tipoProducto);

                                        // Solicitar el código del producto para agregar al carrito
                                        System.out.print("Ingrese el código del producto que desea agregar al carrito: ");
                                        codigo = scanner.nextLine();

                                        Producto producto = empresa.buscarProductoPorCodigo(codigo);
                                        if (producto != null) {
                                            System.out.print("Ingrese la cantidad de este producto: ");
                                            int cantidad = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer

                                            // Calcular el precio y sumarlo al total
                                            double precioProducto = producto.getPrecio() * cantidad;
                                            precioTotal += precioProducto;
                                            System.out.println("Se ha agregado al carrito el producto: " + producto.toString() + " por un total de: " + precioProducto);

                                            // Preguntar si desea continuar comprando
                                            System.out.println("¿Desea agregar otro producto?");
                                            System.out.println("1: Sí");
                                            System.out.println("2: No");
                                            int respuesta = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer

                                            if (respuesta != 1) {
                                                continuarComprando = false;
                                            }
                                        } else {
                                            System.out.println("Producto no encontrado.");
                                        }
                                    }

                                    // Mostrar el total de la compra
                                    System.out.println("El total de su compra es: " + precioTotal);
                                    break;

                                case 4:
                                    // Mostrar todo el inventario
                                    System.out.println("Inventario actual de productos:");
                                    empresa.visualizarListaProductos();
                                    break;


                                // Aquí se puede añadir lógica adicional con try-catch para los otros caso


                                case 0:
                                    System.out.println("Saliendo del menú de administración...");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            // Maneja errores de entrada inválida para las opciones del menú de administración
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                            scanner.nextLine();  // Limpiar el buffer
                        } catch (Exception e) {
                            // Maneja cualquier otro error que pueda ocurrir en el menú de administración
                            System.out.println("Error en el menú de administración: " + e.getMessage());
                        }
                }
            }
        }
