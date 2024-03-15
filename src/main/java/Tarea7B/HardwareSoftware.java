/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7B;

/**
 *
 * @author adam
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HardwareSoftware {
    public static void main(String[] args) {
        String[] frases = {"Tengo mucho hardware", "El software da error", "no contiene las palabras"};

        for (String cadena : frases) {
            if (contienePalabras(cadena)) {
                System.out.println("'" + cadena + "' contiene 'Hardware' o 'Software'.");
            } else {
                System.out.println("'" + cadena + "' no contiene 'Hardware' o 'Software'.");
            }
        }
    }

    public static boolean contienePalabras(String cadena) {
        // Patrón para buscar "Hardware" o "Software" en la cadena
        Pattern patron = Pattern.compile("\\b(?:hardware|software)\\b");
        Matcher matcher = patron.matcher(cadena);
        // Verificar si la cadena contiene el patrón
        return matcher.find();
    }
}
