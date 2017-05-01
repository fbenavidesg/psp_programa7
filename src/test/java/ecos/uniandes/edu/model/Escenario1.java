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
public class Escenario1 {
    private ArrayList<ListaPar> arrayListaPar;
    private double proxy;
    
    public Escenario1() {
        this.proxy = 386;
        this.arrayListaPar = new ArrayList<>();
        this.arrayListaPar.add(new ListaPar( 130,186 ));
        this.arrayListaPar.add(new ListaPar( 650,699 ));
        this.arrayListaPar.add(new ListaPar( 99,132 ));
        this.arrayListaPar.add(new ListaPar( 150,272 ));
        this.arrayListaPar.add(new ListaPar( 128,291 ));
        this.arrayListaPar.add(new ListaPar( 302,331 ));
        this.arrayListaPar.add(new ListaPar( 95,199 ));
        this.arrayListaPar.add(new ListaPar( 945,1890 ));
        this.arrayListaPar.add(new ListaPar( 368,788 ));
        this.arrayListaPar.add(new ListaPar( 961,1601 ));
    }

    public ArrayList<ListaPar> getArrayListaPar() {
        return arrayListaPar;
    }

    public void setArrayListaPar(ArrayList<ListaPar> arrayListaPar) {
        this.arrayListaPar = arrayListaPar;
    }

    public double getProxy() {
        return proxy;
    }

    public void setProxy(double proxy) {
        this.proxy = proxy;
    }
    
}
