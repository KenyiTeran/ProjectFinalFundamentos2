public class Telas extends Producto {
    private String materialTipo;
    private String tejido;
    private String elasticidad;

    public Telas(double precio, String codigo, String nombre, String color, String calidad, String materialTipo, String tejido, String elasticidad) {
        super(precio, codigo, nombre, color, calidad);
        this.materialTipo = materialTipo;
        this.tejido = tejido;
        this.elasticidad = elasticidad;
    }

    public Telas(double precio, String codigo, String color, String calidad, String materialTipo, String tejido, String elasticidad) {
        super();
    }

    @Override
    public double calcularPrecio() {
        // Lógica para calcular el precio específico de Telas
        return getPrecio(); // Ajustar la lógica según la necesidad
    }
}
