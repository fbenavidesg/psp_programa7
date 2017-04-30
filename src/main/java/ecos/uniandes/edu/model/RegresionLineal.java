/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecos.uniandes.edu.model;
/**
 *
 * @author fbenavides
 */
public class RegresionLineal {
    
    /**
     * metodo de apoyo que calcula r
     * @param n
     * @param sumXY
     * @param sumX
     * @param sumY
     * @param sumX2
     * @param sumY2
     * @return 
     */
    public double calcularR( int n, double sumXY, double sumX, double sumY, double sumX2, double sumY2 ){
        double result;
        result = ((n*sumXY) - (sumX*sumY)) / 
                Math.sqrt( ((n*sumX2) - Math.pow(sumX, 2)) * ( (n * sumY2) - Math.pow(sumY, 2) ));
        return result;
    }
    /**
     * metodo de apoyo que calcula B1
     * @param n
     * @param sumXY
     * @param promedioSumaX
     * @param promedioSumaY
     * @param sumX2
     * @return 
     */
    public double calcularB1( int n, double sumXY, double promedioSumaX, double promedioSumaY,double sumX2 ){
        double result;
        result = (sumXY - (n*promedioSumaX*promedioSumaY)) / (sumX2 - (n* Math.pow(promedioSumaX, 2)));
        return result;
    }
    /**
     * metodo de apoyo que calcula B0
     * @param promedioSumaY
     * @param b1
     * @param promedioSumaX
     * @return 
     */
    public double calcularB0(double promedioSumaY, double b1, double promedioSumaX){
        double result;
        result = promedioSumaY - (b1*promedioSumaX);
        return result;
    }
    
    /**
     * metodo calcula el prox mejorado
     * @param b1
     * @param b0
     * @param proxy
     * @return 
     */
    public double calcularProxyMejorado( double b1, double b0, double proxy ){
        double proxMejorado;
        return b0 + b1*proxy;
    }
}
