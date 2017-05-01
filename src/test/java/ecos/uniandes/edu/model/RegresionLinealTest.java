/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecos.uniandes.edu.model;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fbenavides
 */
public class RegresionLinealTest {

    /**
     * Test of calcularR method, of class RegresionLineal.
     */
    @Test
    public void testCalcularR() {
        System.out.println("calcularR");
        int n = 10;
        double sumXY = 4303108.0;
        double sumX = 3828.0;
        double sumY = 6389.0;
        double sumX2 = 2540284.0;
        double sumY2 = 7604693.0;
        RegresionLineal instance = new RegresionLineal();
        double expResult = 0.9544965741046826;
        double result = instance.calcularR(n, sumXY, sumX, sumY, sumX2, sumY2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularB1 method, of class RegresionLineal.
     */
    @Test
    public void testCalcularB1() {
        System.out.println("calcularB1");
        int n = 10;
        double sumXY = 4303108.0;
        double promedioSumaX = 382.8;
        double promedioSumaY = 638.9;
        double sumX2 = 2540284.0;
        RegresionLineal instance = new RegresionLineal();
        double expResult = 1.727932426206986;
        double result = instance.calcularB1(n, sumXY, promedioSumaX, promedioSumaY, sumX2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularB0 method, of class RegresionLineal.
     */
    @Test
    public void testCalcularB0() {
        System.out.println("calcularB0");
        double promedioSumaY = 638.9;
        double b1 = 1.727932426206986;
        double promedioSumaX = 382.8;
        RegresionLineal instance = new RegresionLineal();
        double expResult = -22.552532752034267;
        double result = instance.calcularB0(promedioSumaY, b1, promedioSumaX);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularProxyMejorado method, of class RegresionLineal.
     */
    @Test
    public void testCalcularProxyMejorado() {
        System.out.println("calcularProxyMejorado");
        double b1 = 1.727932426206986;
        double b0 = -22.552532752034267;
        double proxy = 386;
        RegresionLineal instance = new RegresionLineal();
        double expResult = 644.4293837638623;
        double result = instance.calcularProxyMejorado(b1, b0, proxy);
        assertEquals(expResult, result, 0.0);
    }
    
}
