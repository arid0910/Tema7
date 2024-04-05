/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7E;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author adam
 */
public class Directorio {
        public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("Ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tienes permisos");
        } catch (IOException e) {
            System.out.println("Error creando el directorio");
        }

    }
    
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Error copiando");
            System.out.println(e.toString());
        }
    }
}
