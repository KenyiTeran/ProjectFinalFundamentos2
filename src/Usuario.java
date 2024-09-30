public class Usuario {
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public boolean validarInicioSesion(String nombreUsuario, String contraseña) {
        return this.nombreUsuario.equals(nombreUsuario) && this.contraseña.equals(contraseña);
    }

    @Override
    public String toString() {
        return "Usuario: " + nombreUsuario;
    }
}
