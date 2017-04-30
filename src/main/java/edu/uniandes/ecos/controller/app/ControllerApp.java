/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author fbenavides
 */
public class ControllerApp {
    
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
        System.out.println("correlacion:" + r);
        System.out.println("r2:" + r2);
        System.out.println("b1:"+b1);
        System.out.println("b0:"+b0);
        System.out.println("proxM:" + yk);
        
        Significancia significancia = new Significancia();
        double significanciaValor = significancia.calcular(arrayListaPar.size(), r, r2);
        System.out.println("signifcacia:"+significanciaValor);
        
        Rango rango = new Rango();
        double rango70 = rango.CalcularRango70( arrayListaPar.size(), arrayListaPar, proxy, promedioX, b0, b1 );
        double rango70Upi = rango.CalcularRango70Upi(yk);
        double rango70Lpi = rango.CalcularRango70Lpi(yk); 
        System.out.println("rango70:"+rango70);
        System.out.println("rangoUPI:"+rango70Upi);
        System.out.println("rangoLPI:"+rango70Lpi);
        
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
