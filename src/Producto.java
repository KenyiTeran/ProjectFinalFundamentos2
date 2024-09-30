public abstract class Producto {
    private double precio;
    private String codigo;
    private String nombre;
    private String color;
    private String calidad;

    // Constructor principal que inicializa los atributos comunes
    public Producto(double precio, String codigo, String nombre, String color, String calidad) {
        this.precio = precio;
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.calidad = calidad;
    }

    public Producto(double precio, String codigo, String color, String calidad, double gramaje, String animal, String suavidad) {
    }

    public Producto(double precio, String codigo, String color, String calidad, double grosor, String materialHilo) {
    }

    public Producto() {

    }

    // Elimina los otros constructores innecesarios

    // Getters para los atributos
    public double getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getCalidad() {
        return calidad;
    }

    // Método abstracto que debe ser implementado por las clases hijas
    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Código: " + codigo + ", Precio: " + precio;
    }
}
