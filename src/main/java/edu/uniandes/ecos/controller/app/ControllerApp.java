package edu.uniandes.ecos.controller.app;
import ecos.uniandes.edu.model.ListaPar;
import ecos.uniandes.edu.model.Rango;
import ecos.uniandes.edu.model.RegresionLineal;
import ecos.uniandes.edu.model.Resultado;
import ecos.uniandes.edu.model.Significancia;
import ecos.uniandes.edu.model.UtilCalculo;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Clase principal funciona como controllador frontal
 * @author fbenavides
 */
public class ControllerApp {
    /**
     * Clase que orquesta el calculo y empaqueta las respuestas en un objecto resultado
     * @param rutaArchivo path de la ruta en src del la fuente de datos
     * @return Resultado objecto con metodos set y get
     * @throws IOException 
     */
    public Resultado calcular( String rutaArchivo ) throws IOException{
        rutaArchivo = "src/" + rutaArchivo;
        Resultado resultado = new Resultado();
        ArrayList<ListaPar> arrayListaPar = UtilCalculo.LeerArchivoListaPar(rutaArchivo);
        RegresionLineal regresionLineal = new RegresionLineal();
        double proxy = UtilCalculo.LeerArchivoBuscarProxy(rutaArchivo);
        double sumaXY = UtilCalculo.sumaXY(arrayListaPar); 
        double sumaX = UtilCalculo.sumaX(arrayListaPar); 
        double sumaY = UtilCalculo.sumaY(arrayListaPar); 
        double sumaX2 = UtilCalculo.sumaX2(arrayListaPar);  
        double sumaY2 = UtilCalculo.sumaY2(arrayListaPar);
        double promedioX = sumaX / arrayListaPar.size();
        double promedioY = sumaY / arrayListaPar.size();
        double r = regresionLineal.calcularR(arrayListaPar.size(),sumaXY, sumaX, sumaY, sumaX2, sumaY2);
        double r2 = r*r;
        double b1 = regresionLineal.calcularB1(arrayListaPar.size(),sumaXY, promedioX, promedioY, sumaX2);
        double b0 = regresionLineal.calcularB0(promedioY, b1, promedioX);
        double yk = regresionLineal.calcularProxyMejorado(b1, b0, proxy);
        Significancia significancia = new Significancia();
        double significanciaValor = significancia.calcular(arrayListaPar.size(), r, r2);
        Rango rango = new Rango();
        double rango70 = rango.CalcularRango70( arrayListaPar.size(), arrayListaPar, proxy, promedioX, b0, b1 );
        double rango70Upi = rango.CalcularRango70Upi(yk);
        double rango70Lpi = rango.CalcularRango70Lpi(yk);
        resultado.setProxy(proxy);
        resultado.setR(r);
        resultado.setR2(r2);
        resultado.setB0(b0);
        resultado.setB1(b1);
        resultado.setProxyMejorado(yk);
        resultado.setSignificancia(significanciaValor);
        resultado.setRango(rango70);
        resultado.setRangoUpi(rango70Upi);
        resultado.setRangoLpi(rango70Lpi);
        return resultado;
    }
    
}
