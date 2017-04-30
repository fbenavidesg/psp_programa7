package ecos.uniandes.edu.model;
import java.util.ArrayList;
/**
 * Clase para el calculo de rango 70, UPI, LPI
 * @author fbenavides
 */
public class Rango {
    
    private double range70 = 0.0;
    
    /**
     * metodo calcula el rango 70
     * @param n
     * @param arrayListaPar
     * @param proxy
     * @param promedioX
     * @param b0
     * @param b1
     * @return 
     */
    public double CalcularRango70( int n, ArrayList<ListaPar> arrayListaPar, double proxy, double promedioX, double b0, double b1 ){
        CalcularSimpson calculateSimpson = new CalcularSimpson();
        double distribucionX = calculateSimpson.calculateX(n-2, 0.35);
        double desviacion = this.desviacion(arrayListaPar.size(), b1, b0, arrayListaPar);
        double rangoSumaX = this.calculoRangoSumatoriaX(arrayListaPar, promedioX);
        double respuesta = distribucionX * desviacion * Math.sqrt( 1.0 + (1.0 / n) + ( Math.pow(proxy - promedioX, 2) / rangoSumaX ) );
        this.range70 = respuesta;
        return respuesta;
    }
    
    /**
     * calcula el rango UPI
     * @param proxMejorado
     * @return 
     */
    public double  CalcularRango70Upi( double proxMejorado ){
        return proxMejorado + this.range70;
    }
    
    /**
     * calcula el rango LPI
     * @param proxMejorado
     * @return 
     */
    public double  CalcularRango70Lpi( double proxMejorado ){
        return proxMejorado - this.range70;
    }
    
    /**
     * calcula la desviacion estandar para encontrar los rangos
     * @param n
     * @param b1
     * @param b0
     * @param arrayListaPar
     * @return 
     */
    public double desviacion( int n, double b1, double b0, ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        double resultado = 0.0;
        for (ListaPar listaPar : arrayListaPar) {
           suma += Math.pow(listaPar.getValorY() - b0 - (b1*listaPar.getValorX()), 2);
        }
        resultado =  Math.sqrt((1.0/(n - 2.0))*suma);
        return resultado;
    }
    
    /**
     * metodo de apoyo para calcular la sumatoria parcial para calculo de los tangos
     * @param arrayListaPar
     * @param promedioX
     * @return 
     */
    private double calculoRangoSumatoriaX(ArrayList<ListaPar> arrayListaPar, double promedioX){
        double respuesta = 0.0;
        for (ListaPar listaPar : arrayListaPar) {
          respuesta +=  Math.pow(listaPar.getValorX() - promedioX, 2);
        }
        return respuesta;
    }
}
