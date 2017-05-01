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
public class CalcularSimpsonTest {


    /**
     * Test of calculateX method, of class CalcularSimpson.
     */
    @Test
    public void testCalculateX() {
        double dof = 8;
        double resultExpected = 0.35;
        CalcularSimpson instance = new CalcularSimpson();
        double expResult = 1.1080322265625;
        double result = instance.calculateX(dof, resultExpected);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculate method, of class CalcularSimpson.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        double x = 9.052736157200183;
        double dof = 8;
        CalcularSimpson instance = new CalcularSimpson();
        double expResult = 0.49999112403896456;
        double result = instance.calculate(x, dof);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateSegments method, of class CalcularSimpson.
     */
    @Test
    public void testCalculateSegments() {
        System.out.println("calculateSegments");
        double x = 9.052736157200183;
        double dof = 8;
        int numSegmentsIteration = 10;
        CalcularSimpson instance = new CalcularSimpson();
        double expResult = 0.4969935245458706;
        double result = instance.calculateSegments(x, dof, numSegmentsIteration);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateDistributionT method, of class CalcularSimpson.
     */
    @Test
    public void testCalculateDistributionT() {
        System.out.println("calculateDistributionT");
        double x = 9.052736157200183;
        double dof = 8;
        CalcularSimpson instance = new CalcularSimpson();
        double expResult = 0.3866990209613932;
        double result = instance.calculateDistributionT(x, dof);
        assertEquals(expResult, result, 0.0);
    }
    
}
