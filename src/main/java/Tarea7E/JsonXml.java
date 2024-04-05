/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7E;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author adam
 */
public class JsonXml {

    public static void guardarXml(List<App> listaApp, String ruta) {
        // Creamos un contenedor de aplicaciones
        CatalogoApps catalogo = new CatalogoApps();
        catalogo.setLista(listaApp);
        catalogo.setDescripcion("Mi catalogo");
        

        try {
            // Creamos el contexto JAXB para el tipo App
            JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);

            // Creamos un objeto Marshaller para serializar objetos Java a XML
            Marshaller serializador = contexto.createMarshaller();

            // Especificamos que la salida sea formateada con indentación y saltos de línea
            serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Serializamos y mostramos por consola
            serializador.marshal(catalogo, System.out);

            // Guardamos la serialización en un archivo XML en el directorio "appsxml" con el nombre "aplicacionesxml.xml"
            serializador.marshal(catalogo, new File(ruta));

        } catch (JAXBException e) {
            System.out.println("Error al guardar el archivo XML");
        }
    }

    public static void guardarJson(List<App> listaApp, String ruta) {
        // Crear un objeto ObjectMapper, que permite mapear objetos Java a JSON y viceversa
        ObjectMapper mapeador = new ObjectMapper();

        // Registrar el módulo JavaTimeModule para manejar las fechas según Java Time API
        mapeador.registerModule(new JavaTimeModule());

        // Configurar el mapeador para producir un JSON bien formateado (con indentación)
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            mapeador.writeValue(new File(ruta), listaApp);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo JSON");
        }
    }
}
