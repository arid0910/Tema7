/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7D;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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

        listaApp.forEach(System.out::println);
    }

    public static List guardarCsv(List<App> listaApp) {
        List<String> lista = new ArrayList<>();
        
        for (App app : listaApp) {
            String csvString = app.toString(); // Assuming App has a method toCsvString() that returns a CSV representation
            String[] array = csvString.split(";");
            lista.add(array[1]);
        }
        
        try {
            Files.write(Paths.get("generos.txt"), lista, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }

        return lista;
    }
}
