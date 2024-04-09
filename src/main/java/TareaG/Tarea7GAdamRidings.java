/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package TareaG;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author adam
 */
public class Tarea7GAdamRidings {

    public static void main(String[] args) throws IOException {
       
       String fichero = "precipitacionesBadajoz.json";
       List<Precipitaciones> listaPre = Metodos.leerJson(fichero);
       
       //Mostrar lista de objetos precipitacion
       System.out.println(listaPre);
        
       //Obtén una estructura Map donde para cada nombre de estación meteorológica 
       //se pueda consultar la precipitación acumulada de la misma.
       System.out.println("----- Estaciones Meteorologicas/Precipitaciones -----");
       
    }
}
