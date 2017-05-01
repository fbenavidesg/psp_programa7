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
public class UtilCalculoTest {
        
    /**
     * Test of sumaXY method, of class UtilCalculo.
     */
    
    @Test
    public void testSumaXY() {
        Escenario1 escenario1 = new Escenario1();
        System.out.println("sumaXY");
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        double expResult = 4303108.0;
        double result = UtilCalculo.sumaXY(arrayListaPar);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of sumaX method, of class UtilCalculo.
     */
    @Test
    public void testSumaX() {
        Escenario1 escenario1 = new Escenario1();
        System.out.println("sumaX");
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        double expResult = 3828.0;
        double result = UtilCalculo.sumaX(arrayListaPar);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of sumaY method, of class UtilCalculo.
     */
    @Test
    public void testSumaY() {
        Escenario1 escenario1 = new Escenario1();
        System.out.println("sumaY");
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        double expResult = 6389.0;
        double result = UtilCalculo.sumaY(arrayListaPar);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of sumaX2 method, of class UtilCalculo.
     */
    @Test
    public void testSumaX2() {
        Escenario1 escenario1 = new Escenario1();
        System.out.println("sumaX2");
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        double expResult = 2540284.0;
        double result = UtilCalculo.sumaX2(arrayListaPar);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of sumaY2 method, of class UtilCalculo.
     */
    @Test
    public void testSumaY2() {
        Escenario1 escenario1 = new Escenario1();
        System.out.println("sumaY2");
        ArrayList<ListaPar> arrayListaPar = escenario1.getArrayListaPar();
        double expResult = 7604693.0;
        double result = UtilCalculo.sumaY2(arrayListaPar);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of factorial method, of class UtilCalculo.
     */
    @Test
    public void testFactorial() {
        System.out.println("factorial");
        double init = 1.0;
        double limit = 2.0;
        double expResult = 2.0;
        double result = UtilCalculo.factorial(init, limit);
        assertEquals(expResult, result, 0.0);
    }
    
}
