public class Lana extends Producto {
    private double gramaje;
    private String animal;
    private String suavidad;

    public Lana(double precio, String codigo, String nombre, String color, String calidad, double gramaje, String animal, String suavidad) {
        super(precio, codigo, nombre, color, calidad); // Llama al constructor de Producto
        this.gramaje = gramaje;
        this.animal = animal;
        this.suavidad = suavidad;
    }

    public Lana(double precio, String codigo, String color, String calidad, double gramaje, String animal, String suavidad) {
        super(precio, codigo, color, calidad, gramaje, animal, suavidad);
    }

    @Override
    public double calcularPrecio() {
        // Lógica para calcular el precio específico de Lana
        return getPrecio() * gramaje;
    }

    // Getters y setters para los atributos adicionales de Lana
    public double getGramaje() {
        return gramaje;
    }

    public void setGramaje(double gramaje) {
        this.gramaje = gramaje;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getSuavidad() {
        return suavidad;
    }

    public void setSuavidad(String suavidad) {
        this.suavidad = suavidad;
    }
}
