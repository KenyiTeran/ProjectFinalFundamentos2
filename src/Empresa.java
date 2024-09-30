import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Producto> inventario;
    private List<Usuario> usuarios;

    public Empresa() {
        inventario = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    public void calcularPreciosYAgregarCarrito() {
        // Lógica para calcular precios y agregar al carrito
    }

    public boolean eliminarProducto(String codigo) {
        return inventario.removeIf(producto -> producto.getCodigo().equals(codigo));
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : inventario) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void visualizarListaProductos() {
        for (Producto producto : inventario) {
            System.out.println(producto);
        }
    }
    public void visualizarListaProductosPorTipo(int tipoProducto) {
        for (Producto producto : inventario) {
            switch (tipoProducto) {
                case 1: // Lana
                    if (producto instanceof Lana) {
                        System.out.println(producto);
                    }
                    break;
                case 2: // Hilo
                    if (producto instanceof Hilos) {
                        System.out.println(producto);
                    }
                    break;
                case 3: // Tela
                    if (producto instanceof Telas) {
                        System.out.println(producto);
                    }
                    break;
                default:
                    System.out.println("Tipo de producto inválido.");
                    break;
            }
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.validarInicioSesion(nombreUsuario, contraseña)) {
                return true;
            }
        }
        return false;
    }
}
