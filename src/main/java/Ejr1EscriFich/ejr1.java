/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejr1EscriFich;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author adam
 */
public class ejr1 {
    public static void main(String[] args) {
        escribirHastaFin();
    }
    
    public static void escribirHastaFin(){
        Scanner sc = new Scanner(System.in);
        String frase;
        List<String> texto = new ArrayList<>();
        
        do{
            System.out.println("Escribe una frase: ");
            frase = sc.nextLine();
            texto.add(frase);
        }while(!frase.contains("fin"));
        
        try {
            Files.write(Paths.get("ejr1.txt"), texto, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
        
    }
}
