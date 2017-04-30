package ecos.uniandes.edu.model;
/**
 * Clase para almacenar el resultado de toda la app
 * @author fbenavides
 */
public class Resultado {
   private double proxy;
   private double r;
   private double r2;
   private double significancia;
   private double b0;
   private double b1;
   private double proxyMejorado;
   private double rango;
   private double rangoUpi;
   private double rangoLpi;

    public double getProxy() {
        return proxy;
    }

    public void setProxy(double proxy) {
        this.proxy = proxy;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public double getSignificancia() {
        return significancia;
    }

    public void setSignificancia(double significancia) {
        this.significancia = significancia;
    }

    public double getB0() {
        return b0;
    }

    public void setB0(double b0) {
        this.b0 = b0;
    }

    public double getB1() {
        return b1;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public double getProxyMejorado() {
        return proxyMejorado;
    }

    public void setProxyMejorado(double proxyMejorado) {
        this.proxyMejorado = proxyMejorado;
    }

    public double getRango() {
        return rango;
    }

    public void setRango(double rango) {
        this.rango = rango;
    }

    public double getRangoUpi() {
        return rangoUpi;
    }

    public void setRangoUpi(double rangoUpi) {
        this.rangoUpi = rangoUpi;
    }

    public double getRangoLpi() {
        return rangoLpi;
    }

    public void setRangoLpi(double rangoLpi) {
        this.rangoLpi = rangoLpi;
    }
}
