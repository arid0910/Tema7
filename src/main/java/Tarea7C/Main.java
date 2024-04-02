/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7C;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Date time formater .ofPattern
/**
 *
 * @author adam
 */
public class Main {

    public static void main(String[] args) {
        List<String> listaStr;
        String fichero = "personas.csv";
        listaStr = leer(fichero);
        listaStr.forEach(System.out::println);
        
        List<Persona> listaP;
        listaP = cogerDatos(listaStr);
        listaP.forEach(System.out::println);
        
        Set<String> generos;
        generos = generos(listaStr);
        generos.forEach(System.out::println);
        
        Map<String, Integer> listaM;
        listaM = generosContar(listaStr);
        for (Map.Entry<String, Integer> entry : listaM.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue() + "\n");
        }
    }

    public static List<String> leer(String fichero) {
        List<String> lista = new ArrayList<>();

        try {

            lista = Files.readAllLines(Paths.get(fichero));
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + fichero);
        }
        lista.remove(0);
        return lista;
    }

    public static List<Persona> cogerDatos(List<String> lista) {
        List<Persona> lista2 = new ArrayList<>();

        for (String linea : lista) {
            String[] array = linea.split(",");//Separar por coma

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(array[5], formatter);

            Persona persona = new Persona(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4],
                    date, Boolean.parseBoolean(array[6]), array[7]);
            lista2.add(persona); 
        }
        return lista2;
    }
    
    public static Set<String> generos(List<String> lista){      
        Set<String> generos = new HashSet<>();
        
        for (String linea : lista) {
            String[] array = linea.split(",");//Separar por coma
            generos.add(array[4]);
        }
        
        try {
            Files.write(Paths.get("generos.txt"), generos, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
       
        return generos;
    }
    
    public static Map<String, Integer> generosContar(List<String> lista){
        Map<String, Integer> listaM = new HashMap<>();
        
        for (String linea : lista) {
            String[] array = linea.split(",");
            listaM.put(array[4], listaM.getOrDefault(array[4], 0) + 1);
        }
        
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("generosContar.csv"))) {
            for (Map.Entry<String, Integer> entry : listaM.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Error");
        }
        
         return listaM;
    }
}
