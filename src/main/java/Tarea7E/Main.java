/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7E;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adam
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<App> listaApp = new ArrayList<>();
        
        for (int i = 0; i < 50; i++) {
            listaApp.add(new App());
        }

        System.out.println(listaApp);
        
        //xml y json en la raiz
        JsonXml.guardarXml(listaApp, "./xml.xml");
        JsonXml.guardarJson(listaApp, "./json.json");
        
        //Genera tantos archivos JSON como aplicaciones haya en la lista en una 
        //carpeta llamada ./aplicacionesJSON. El nombre de cada archivo será el 
        //nombre de la aplicación en cuestión.
        
        for (App app : listaApp) {
            JsonXml.guardarJsonGenrar50(app,"./aplicacionesJson/"+app.getNombre()+".json");
        }
        
        //Realiza una lectura del fichero XML y muestra los datos de todas las apps por consola.
        //Realiza una lectura del fichero JSON y muestra los datos de todas las apps por consola.
        JsonXml.leerXml("./xml.xml").forEach(System.out::println);
        JsonXml.leerJson("./json.json").forEach(System.out::println);
        
        //Muestra un listado de los ficheros que hay en ./aplicacionesJSON. 
        File file = new File("./aplicacionesJson/");
        File[] array = file.listFiles();
        for (File fichero : array) {
            System.out.println(fichero.getName());
        }
        
        //Pregunta al usuario el nombre del fichero json (de los anteriores) que quiere leer. 
        //Una vez leído muestra los datos de esta app por consola.
        Scanner sc = new Scanner(System.in);
        System.out.println("Que archivo quieres leer");
        String archivo = sc.nextLine();
        for (File archi : array) {
            if (archi.getName().equals(archivo)) {
                System.out.println(JsonXml.buscarJson("./aplicacionesJson/" + archivo));
                break;
            }
        }
        
        //Borra el archivo leído y comprueba que ya no está en el directorio ./aplicacionesJSON.
        Directorio.eliminarArchivo("./aplicacionesJson/"+archivo);
    }
}
