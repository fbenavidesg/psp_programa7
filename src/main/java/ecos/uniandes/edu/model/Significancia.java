package ecos.uniandes.edu.model;
/**
 * Clase que calcula la significancia
 * @author fbenavides
 */
public class Significancia {
    
    /**
     * 
     * @param n
     * @param r
     * @param r2
     * @return 
     */
    public double calcular(int n, double r, double r2){
        double resultado;
        double x = this.calcularX(n, r, r2);
        CalcularSimpson calculateSimpson = new CalcularSimpson();
        double p = calculateSimpson.calculate(x, n-2);
        resultado = 1 - 2*p;
        return resultado;
    }
    
    /**
     * metodo de apoyo para el calculo de la significancia, encuentra parte de la formula
     * @param n
     * @param r
     * @param r2
     * @return 
     */
    private double calcularX(int n, double r, double r2){
        double resultado = (r * Math.sqrt(n-2))/ Math.sqrt(1-r2);
        return resultado;
    }
}
