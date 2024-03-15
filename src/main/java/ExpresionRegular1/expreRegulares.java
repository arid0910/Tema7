/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ExpresionRegular1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author adam
 */
public class expreRegulares {

    public static void main(String[] args) {
        //Todos los archivos que estan en la raiz del pryecto
        //son accecibles directamente por su nombre
        List<String> lista;
        String fichero = "ssh_config";
        System.out.println("Leyendo el fichero " + fichero);
        lista = leerFichero(fichero);
        
        //Mostrar num palabras por linea
        lista.forEach(linea->{
           int numeroPalabras = contarPalabrasPorLinea(linea); 
            System.out.println(linea + " --> " + numeroPalabras);
        });
        
        //Mostrar contar Palabra Concreta Por Linea
        lista.forEach(linea->{
           int numeroPalabras = contarPalabraConcretaPorLinea("is", linea); 
            System.out.println(linea + " --> " + numeroPalabras);
        });

    }

    //Metodo para leer un fichero de texto plano
    //Usa la clase files
    public static List<String> leerFichero(String fichero) {
        
        List<String> lista = new ArrayList<>();
        
        try {
            lista = Files.readAllLines(Paths.get(fichero));
        } catch (IOException ex){
            System.out.println("Error accediendo a " + fichero);
        }
        return lista;
    }
    
    public static int contarPalabrasPorLinea(String linea){
        //En java para escapar la barra invertida hay que añadir otra barra mas
        //Para que funcione \\
        //El + del \\s vale por si hay mas de un espacio lo cuente como uno
        linea = linea.trim(); //quita espacios de delante y atras
        String[] array = linea.split("\\s+");
        
        return array.length;
    }
    
    public static int contarPalabraConcretaPorLinea(String palabra, String linea){
        String regex = "\\b"+palabra+"\\b";
        
        //La clase pattern crea un objeto con la representacion
        //compilada o procesada de la expresion regular, Permite crear un objeto Matcher
        Pattern patron = Pattern.compile(regex);
        
        //Matcher se crea a partir del objecto Pattern
        //Permite hacer operaciones usando el regex sobre el String
        //matches() si cumple patron
        //fint() para encontrar partes del String que cumplen el patron
        Matcher buscador = patron.matcher(linea);
        
        int contador = 0;
        while(buscador.find()){
            contador++;
        }
        
        return contador;
    }

    
}
