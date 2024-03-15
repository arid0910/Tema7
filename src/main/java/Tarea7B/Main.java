/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7B;

import java.util.Scanner;

/**
 *
 * @author adam
 */
public class Main {
    public static void main(String[] args) {
        boolean repetir = true;
        Scanner sc = new Scanner(System.in);
        do{
            String menu = """
                          ------------- MENÚ -------------
                          ·1- Patron autopista
                          ·2- Patron cod postal
                          ·3- Patron Matricula
                          ·4- Patron letraNum
                          ·5- Patron Ipasen
                          ·6- Patron noFRK
                          ·7- Patron Hardware Software
                          """;
            System.out.println(menu);
            int opcion = sc.nextInt();
            
        }while(repetir);
    }
}
