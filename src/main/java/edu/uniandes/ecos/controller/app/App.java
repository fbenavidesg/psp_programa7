/******************************************************************************/
/* Programa ID: PSP_TAREA4                                                    */
/* Autor: Fredy Benavides                                                     */
/* Fecha: 30/04/2017                                                          */
/* Descripcion: Programa realiza calculos PSP                                 */
/*                                                                            */
/******************************************************************************/
package edu.uniandes.ecos.controller.app;
import ecos.uniandes.edu.model.Resultado;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;
import spark.template.freemarker.FreeMarkerEngine;
/**
 * Clase principal funciona como controllador frontal
 * @author fbenavides
 */
public class App {
    /**
     * Metodo de entrada de la aplicacion.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        get("/", (req, res) -> {
            String template = "index";
            Map<String, Object> attributes = new HashMap<>();
            String getArchivo = req.queryParams("archivo");
            if (getArchivo == null) {
                attributes.put("uri", req.url());
                template = "err";
            } else {
                ControllerApp controllerApp = new ControllerApp();
                ControllerApp controller = new ControllerApp();
                Resultado resultado = null;
                try {
                    resultado = controller.calcular(getArchivo);
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                attributes.put("resultado", resultado);
            }
            return new ModelAndView(attributes, template + ".ftl");
        }, new FreeMarkerEngine());
    }
}
