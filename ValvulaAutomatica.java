public class ValvulaAutomatica extends Dispositivo implements Accionable{
    private double presionMaxima;

    public ValvulaAutomatica() {
        super();
        this.presionMaxima = 10.0;
    }

    public ValvulaAutomatica(String id, String nombre, String fabricante, double consumo, String estado, double presionMaxima) {
        super(id, nombre, fabricante, consumo, estado);
        this.presionMaxima = presionMaxima;
    }

    public double getPresionMaxima() { return presionMaxima; }
    public void setPresionMaxima(double p) { this.presionMaxima = p; }
    // Accionable 
    @Override
    public String ejecutarAccion() {
        return String.format("Valvula[%s] abierta (presionMax=%.1f)", id, presionMaxima);
    }

    @Override
    public String detenerAccion() {
        return String.format("Valvula[%s] cerrada", id);
    }



    @Override
    public String toString() {
        return String.format("%s | PresionMaxima: %.2f", super.toString(), presionMaxima);
    }

    @Override
    public String toString(boolean full) {
        if (!full) return super.toString();
        return toString();
    }
}