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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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

    public static void guardarJsonGenrar50(App app, String ruta) {
        ObjectMapper mapeador = new ObjectMapper();

        // Configurar el mapeador para producir un JSON bien formateado (con indentación)
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            mapeador.writeValue(new File(ruta), app);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo JSON");
        }
    }

    public static List<App> leerXml(String ruta) {
        List<App> listaApp = new ArrayList();

        try {

            JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);

            Unmarshaller um = contexto.createUnmarshaller();

            CatalogoApps catalogo = (CatalogoApps) um.unmarshal(new File(ruta));

            listaApp = catalogo.getListaApps();

        } catch (JAXBException e) {
            System.out.println("Error al leer el archivo XML");
        }

        return listaApp;
    }

    public static List<App> leerJson(String ruta) {
        List<App> lista = new ArrayList();
        try {
            // Crea un objeto ObjectMapper
            ObjectMapper mapeador = new ObjectMapper();

            // Lee el archivo JSON y mapea su contenido a una lista de objetos App
            lista = mapeador.readValue(new File(ruta), mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));

        } catch (IOException e) {
            // Maneja cualquier excepción de E/S
            System.out.println("Error al leer el archivo JSON");
        }
        // Devuelve el catálogo leído del JSON
        return lista;
    }
    
    public static App buscarJson(String file) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        return mapeador.readValue(new File(file), App.class);
    }

}
