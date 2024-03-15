/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Tarea7A;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author adam
 */
public class Main {

    public static void main(String[] args) {
        String fichero = "vehiculos.csv";
        List<String> lista;
        
        //muestra fichero
        lista = leer(fichero);
        lista.forEach(System.out::println);
        
        List<Vehiculos> listaV;
        listaV = cogerDatos(lista);
        
        //mustra vehiculos en lista
        for (Vehiculos vehiculos : listaV) {
            System.out.println(vehiculos);
        }
        
        Map<Integer, Integer> map;
        map = palabras(lista);
        //mostrar map de palabras
        System.out.println(map  );
    }

    public static List<String> leer(String fichero) {
        List<String> lista = new ArrayList<>();

        try {
            lista = Files.readAllLines(Paths.get(fichero));
        } catch (IOException ex) {
            System.out.println("Error");
        }
        lista.remove(0);
        return lista;
    }

    public static List<Vehiculos> cogerDatos(List<String> lista) {
        List<Vehiculos> lista2 = new ArrayList();
        
        for (int i = 0; i < lista.size(); i++) {
            String[] array = lista.get(i).split(",");//Separar por coma
          
            Vehiculos v = new Vehiculos(array[0], array[1], 
                Integer.parseInt(array[2]), array[3], array[4], array[5]);
            lista2.add(v);
        }
        return lista2;
    }
    
    public static Map<Integer, Integer> palabras(List<String> lista) {
        Map<Integer, Integer> map = new HashMap();
        int palabras = 0; 
        int pos = 0;
        
        for (String string : lista) {
            String[] array = string.split(",");
            for (String s : array) {
                String[] arrayP = s.split("\\s+");
                palabras+=arrayP.length;
            }
            map.put(pos, palabras);
            pos++;
            palabras = 0;
        }
        return map;
    }

}
