/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7D;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author adam
 */
public class Main {

    public static void main(String[] args) {
        List<App> listaApp = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            listaApp.add(new App());
        }

        System.out.println(listaApp);

//        guardarCsv(listaApp);
//        gurdarCsvIndividual(listaApp);
//        guardarXml(listaApp);
        guardarJson(listaApp);
    }

    public static List guardarCsv(List<App> listaApp) {
        List<String> lista = new ArrayList<>();

        for (App app : listaApp) {
            String csvString = app.toString();
            String[] array = csvString.split(";");
            lista.add(Arrays.toString(array));
        }

        try {
            Files.write(Paths.get("appscsv/aplicacionestxt.csv"), lista, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }

        return lista;
    }

    public static List gurdarCsvIndividual(List<App> listaApp) {
        List<String> lista = new ArrayList<>();

        for (App app : listaApp) {
            String csvString = app.toString();
            String[] array = csvString.split(";");
            lista.add(Arrays.toString(array));
        }

        for (int i = 0; i < lista.size(); i++) {
            String nombre = listaApp.get(i).getNombre();
            try {
                Files.write(Paths.get("appscsv2/" + nombre + ".csv"), lista.get(i).getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException ex) {
                System.out.println("Error creando el fichero");
            }
        }

        return lista;
    }

    public static void guardarXml(List<App> listaApp) {
        // Creamos un contenedor de aplicaciones
        App apps = new App();
        apps.setListaA(listaApp);
        apps.setDescripcion("Mi applicacion");

        try {
            // Creamos el contexto JAXB para el tipo App
            JAXBContext contexto = JAXBContext.newInstance(App.class);

            // Creamos un objeto Marshaller para serializar objetos Java a XML
            Marshaller serializador = contexto.createMarshaller();

            // Especificamos que la salida sea formateada con indentación y saltos de línea
            serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Serializamos y mostramos por consola
            serializador.marshal(apps, System.out);

            // Guardamos la serialización en un archivo XML en el directorio "appsxml" con el nombre "aplicacionesxml.xml"
            serializador.marshal(apps, new File("appsxml/aplicacionesxml.xml"));

        } catch (JAXBException e) {
            System.out.println("Error al guardar el archivo XML");
        }
    }

    public static void guardarJson(List<App> listaApp) {
        // Crear un objeto ObjectMapper, que permite mapear objetos Java a JSON y viceversa
        ObjectMapper mapeador = new ObjectMapper();

        // Registrar el módulo JavaTimeModule para manejar las fechas según Java Time API
        mapeador.registerModule(new JavaTimeModule());

        // Configurar el mapeador para producir un JSON bien formateado (con indentación)
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            mapeador.writeValue(new File("appsjson/aplicaciomesjson.json"), listaApp);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo JSON");
        }
    }

}
