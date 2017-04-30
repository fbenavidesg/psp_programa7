package ecos.uniandes.edu.model;
/**
 * Clase para el manejo de la lista encadenada
 * @author fbenavides
 */
public class ListaPar {
    private double valorX;
    private double valorY;

    public ListaPar(double valorX, double valorY) {
        this.valorX = valorX;
        this.valorY = valorY;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }
}
