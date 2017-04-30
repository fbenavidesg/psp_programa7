package ecos.uniandes.edu.model;

import java.util.ArrayList;

public class CalcularSimpson {
    private int numSegments = 10;
    private double E = 0.00001;
    private double integral1;
    private double integral2; 
    
    /**
     * realiza la busqueda de f(x) de acuerdo con la comparacion de resultado esperado y el calculado
     * @param dof
     * @param resultExpected
     * @return 
     */
    public double calculateX( double dof, double resultExpected){
        double x = 1;
        double xMin = 0;
        double xSup = 0;
        double aux = 0;
        double resultSimpson;
        do{
            resultSimpson = calculate( x, dof );
            if( resultExpected - resultSimpson < 0 ){
                xSup = x;
                x = x - ((xSup - xMin) / 2);
            }else{
                xMin = x;
                if( xSup == 0 ){
                    x = x + ((xMin*2 - xMin) / 2); 
                }else{
                    x = x + ((xSup - xMin) / 2);
                }
            }
        }while( !(Math.abs(resultExpected - resultSimpson) < this.E) );
        return x;
    }
    
    public double calculate( double x, double dof ){
        do {            
            this.integral1 = this.calculateSegments( x, dof, this.numSegments );
            this.integral2 = this.calculateSegments( x, dof, this.numSegments * 2 );
            this.numSegments = this.numSegments * 2;
        } while ( !(Math.abs(this.integral1 - this.integral2) < this.E) );
        return this.integral2;
    }
    
    public double calculateSegments(double x, double dof, int numSegmentsIteration) {
        double W = x / numSegmentsIteration;
        double distributionTPart1 = this.calculateDistributionT(x, dof);
        double sumIntegral = 0.0;
        for (int i = 0; i <= numSegmentsIteration; i++) {
            Segment segment = new Segment();
            segment.setI(i);
            segment.setXi(W * i);
            double distributionTPart2 = Math.pow(1 + (Math.pow(segment.getXi(), 2) / dof), -((dof + 1) / 2));
            segment.setMultiplier(this.multiplier(segment.getI(), numSegmentsIteration));
            segment.setFx(distributionTPart1 * distributionTPart2);
            double integralSegment = (W/3) * segment.getMultiplier() * segment.getFx();
            sumIntegral += integralSegment;
        }
        return sumIntegral;
    }

    public double calculateDistributionT(double x, double dof) {
        double distributionT = 0.0;
        double part1Gamma = (dof + 1) / 2;
        double factoriaPart1Gamma = 0.0;
        double factoriaPart2Gamma = 0.0;
        if (part1Gamma % 1 == 0) {
            factoriaPart1Gamma = UtilCalculo.factorial(part1Gamma - 1, 1);
        } else {
            factoriaPart1Gamma = UtilCalculo.factorial(part1Gamma - 1, 0.5);
            factoriaPart1Gamma *= Math.sqrt(Math.PI);
        }
        double part2Gamma = dof / 2;
        if (part2Gamma % 1 == 0) {
            factoriaPart2Gamma = UtilCalculo.factorial(part2Gamma - 1, 1);
        } else {
            factoriaPart2Gamma = UtilCalculo.factorial(part2Gamma - 1, 0.5);
            factoriaPart2Gamma *= Math.sqrt(Math.PI);
        }
        distributionT = factoriaPart1Gamma / (Math.pow((dof * Math.PI), 0.5) * factoriaPart2Gamma);
        return distributionT;
    }

    private int multiplier(int key, int size) {
        int result;
        if (key == 0 || key == size) {
            result = 1;
        } else if (key % 2 == 0) {
            result = 2;
        } else {
            result = 4;
        }
        return result;
    }

}
