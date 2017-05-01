/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecos.uniandes.edu.model;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fbenavides
 */
public class RangoTest {

    /**
     * Test of CalcularRango70 method, of class Rango.
     */
    @Test
    public void testCalcularRango70() {
        System.out.println("CalcularRango70");
        Escenario1 escenario1 = new Escenario1();
        int n = 10;
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        double proxy = 386;
        double promedioX = 382.8;
        double b0 = -22.552532752034267;
        double b1 = 1.727932426206986;
        Rango instance = new Rango();
        double expResult = 229.97822068075996;
        double result = instance.CalcularRango70(n, arrayListaPar, proxy, promedioX, b0, b1);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of desviacion method, of class Rango.
     */
    @Test
    public void testDesviacion() {
        System.out.println("desviacion");
        Escenario1 escenario1 = new Escenario1();
        int n = 10;
        double b1 = 1.727932426206986;
        double b0 = -22.552532752034267;
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        Rango instance = new Rango();
        double expResult = 197.89558013067645;
        double result = instance.desviacion(n, b1, b0, arrayListaPar);
        assertEquals(expResult, result, 0.0);
    }
    
}
