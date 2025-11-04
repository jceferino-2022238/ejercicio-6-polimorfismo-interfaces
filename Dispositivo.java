public abstract class Dispositivo{
    protected String id;
    protected String nombre;
    protected String fabricante;
    protected double consumoElectrico;
    protected String estado;

    // Constructor por defecto
    public Dispositivo() {
        this.id = "";
        this.nombre = "";
        this.fabricante = "";
        this.consumoElectrico = 0.0;
        this.estado = "inactivo";
    }

    // Constructor sobrecargado
    public Dispositivo(String id, String nombre, String fabricante, double consumoElectrico, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.consumoElectrico = consumoElectrico;
        this.estado = estado;
    }

    // Getters / setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public double getConsumoElectrico() { return consumoElectrico; }
    public void setConsumoElectrico(double consumoElectrico) { this.consumoElectrico = consumoElectrico; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Método toString . Público para que la vista pueda llamarlo.
    @Override
    public String toString() {
        return String.format("ID: %s | Nombre: %s | Fabricante: %s | Consumo: %.2fW | Estado: %s",
                id, nombre, fabricante, consumoElectrico, estado);
    }

    // Sobrecarga de toString
    public String toString(boolean full) {
        if (!full) return toString();
        return toString();
    }
    
}