/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecos.uniandes.edu.model;

import java.util.ArrayList;

/**
 *
 * @author fbenavides
 */
public class Rango {
    
    private double range70 = 0.0;
    
    public double CalcularRango70( int n, ArrayList<ListaPar> arrayListaPar, double proxy, double promedioX, double b0, double b1 ){
        //aqui voy
        CalcularSimpson calculateSimpson = new CalcularSimpson();
        double distribucionX = calculateSimpson.calculateX(n-2, 0.35);
        double desviacion = this.desviacion(arrayListaPar.size(), b1, b0, arrayListaPar);
        double rangoSumaX = this.calculoRangoSumatoriaX(arrayListaPar, promedioX);
        double respuesta = distribucionX * desviacion * Math.sqrt( 1.0 + (1.0 / n) + ( Math.pow(proxy - promedioX, 2) / rangoSumaX ) );
        this.range70 = respuesta;
        return respuesta;
    }
    
    public double  CalcularRango70Upi( double proxMejorado ){
        return proxMejorado + this.range70;
    }
    
    public double  CalcularRango70Lpi( double proxMejorado ){
        return proxMejorado - this.range70;
    }
    
    public double desviacion( int n, double b1, double b0, ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        double resultado = 0.0;
        for (ListaPar listaPar : arrayListaPar) {
           suma += Math.pow(listaPar.getValorY() - b0 - (b1*listaPar.getValorX()), 2);
        }
        resultado =  Math.sqrt((1.0/(n - 2.0))*suma);
        return resultado;
    }
    
    private double calculoRangoSumatoriaX(ArrayList<ListaPar> arrayListaPar, double promedioX){
        double respuesta = 0.0;
        for (ListaPar listaPar : arrayListaPar) {
          respuesta +=  Math.pow(listaPar.getValorX() - promedioX, 2);
        }
        return respuesta;
    }
    
}
