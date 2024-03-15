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

public class Ipasen {
    public static void main(String[] args) {
        final String regex = "^[a-z]{7,8}\\d{3,4}$";
        final String string = "adamridi0910";
        
        boolean isValidString = string.matches(regex);
        System.out.println(isValidString);
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        
        System.out.println("Patrones encontrados en la cadena dni");
        while (matcher.find()) {
            System.out.println("Patrón encontrado: " + matcher.group());
        }
    }
}
