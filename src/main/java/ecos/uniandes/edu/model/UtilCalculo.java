package ecos.uniandes.edu.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author fbenavides
 */
public class UtilCalculo {
    
    public static ArrayList<ListaPar> LeerArchivoListaPar( String path ) throws FileNotFoundException, IOException{
        ArrayList<ListaPar> arrayListPair = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader( path ));
        String line;
        while ((line = br.readLine()) != null) {
            String[] valueLineArray = line.split(",");
            if( !valueLineArray[0].equals("proxy") ){
                arrayListPair.add( 
                    new ListaPar(
                            Float.parseFloat(valueLineArray[0]), 
                            Float.parseFloat(valueLineArray[1])
                    )
                );
            }
        }
        return arrayListPair;
    }   
    
    public static double LeerArchivoBuscarProxy( String path ) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader( path ));
        String line;
        double proxy = 0.0;
        while ((line = br.readLine()) != null) {
            String[] valueLineArray = line.split(",");
            if( valueLineArray[0].equals("proxy") ){
                proxy = Double.parseDouble(valueLineArray[1]);
                break;
            }
        }
        return proxy;
    }
    
    /**
     * suma los valores de una lista par multiplicando xy
     * @param arrayListaPar ListaPar datos den entrada xy
     * @return 
     */
    public static double sumaXY( ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        for(ListaPar listaPar :arrayListaPar){
            suma += listaPar.getValorX() * listaPar.getValorY();
        }
        return suma;
    }
    
    /**
     * suma los valores de una lista par x
     * @param arrayListaPar ListaPar datos den entrada xy
     * @return 
     */
    public static double sumaX( ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        for(ListaPar listaPar :arrayListaPar){
            suma += listaPar.getValorX();
        }
        return suma;
    }
    
    /**
     * suma los valores de una lista par y
     * @param arrayListaPar ListaPar datos den entrada xy
     * @return 
     */
    public static double sumaY( ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        for(ListaPar listaPar :arrayListaPar){
            suma += listaPar.getValorY();
        }
        return suma;
    }
    
    /**
     * suma los valores de una lista par x al cuadrado
     * @param arrayListaPar ListaPar datos den entrada xy
     * @return 
     */
    public static double sumaX2( ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        for(ListaPar listaPar :arrayListaPar){
            suma += listaPar.getValorX()*listaPar.getValorX();
        }
        return suma;
    }
    
    /**
     * suma los valores de una lista par y al cuadrado
     * @param arrayListaPar ListaPar datos den entrada xy
     * @return 
     */
    public static double sumaY2( ArrayList<ListaPar> arrayListaPar ){
        double suma = 0.0;
        for(ListaPar listaPar :arrayListaPar){
            suma += listaPar.getValorY()*listaPar.getValorY();
        }
        return suma;
    }
    /**
     * cacula el factorial
     * @param init
     * @param limit
     * @return 
     */
    public static double factorial(double init, double limit) {
        if (init <= limit) {
            return limit;
        } else {
            return init * factorial(init - 1, limit);
        }
    }
}
