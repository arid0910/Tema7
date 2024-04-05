/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7E;

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

        System.out.println(listaApp);
    }
}
