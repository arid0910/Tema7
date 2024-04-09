/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TareaG;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adam
 */
public class Metodos {

    public static List<Precipitaciones> leerJson(String ruta) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        List<Precipitaciones> lista = mapeador.readValue(new File(ruta),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, Precipitaciones.class));
        
        return lista;
    }
}
