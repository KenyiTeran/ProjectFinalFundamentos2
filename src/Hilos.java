public class Hilos extends Producto {
    private double grosor;
    private String material;

    public Hilos(double precio, String codigo, String nombre, String color, String calidad, double grosor, String material) {
        super(precio, codigo, nombre, color, calidad);
        this.grosor = grosor;
        this.material = material;
    }

    public Hilos(double precio, String codigo, String color, String calidad, double grosor, String materialHilo) {
        super(precio, codigo, color, calidad, grosor, materialHilo);
    }

    @Override
    public double calcularPrecio() {
        // Lógica para calcular el precio específico de Hilos
        return getPrecio() * grosor;
    }
}
