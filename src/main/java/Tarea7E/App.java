/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7E;

import java.util.Objects;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adam
 */
// Anotación @XmlRootElement, nombre de la etiqueta XML raíz.
@XmlRootElement(name = "mueble")
// Anotación @XmlAccesorType define el elemento que usará JAXB durante el 
// procesamiento de datos (en este caso por atributo)
@XmlAccessorType(XmlAccessType.FIELD)
public class App {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private double tamañoKb;
    private int numDesc;
    private static int contador = 0;
    @XmlTransient
    private String[] descripciones = {"Mensajería instantánea con amigos. " ,
                          "Redes sociales para compartir momentos. " ,
                          "Navegación y tráfico en tiempo real. " ,
                          "Organizador de tareas diarias. " ,
                          "Streaming de películas y series. " ,
                          "Reservas de viajes y alojamiento. " ,
                          "Juego de rompecabezas adictivo. " ,
                          "Seguimiento de salud y bienestar. " ,
                          "Plataforma de aprendizaje en línea. " ,
                          "Entrega de comida a domicilio."};

    public App() {
        Random rd = new Random();
        int num = rd.nextInt(10);
        
        this.codigo = contador++;
        
        char letra = (char) (rd.nextInt(26) + 'a');
        this.nombre = "app"+codigo+letra;
        
        this.descripcion = descripciones[num];
        
        DoubleStream tamañoKbStream = rd.doubles(1, 100.0, 1024.0);
        this.tamañoKb = tamañoKbStream.findFirst().getAsDouble();
        
        IntStream numDescStream = rd.ints(1, 0, 5000);
        this.numDesc = numDescStream.findFirst().getAsInt();
    }

    public App(int codigo, String nombre, String descripcion, double tamañoKb, int numDesc) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamañoKb = tamañoKb;
        this.numDesc = numDesc;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamañoKb() {
        return tamañoKb;
    }

    public void setTamañoKb(double tamañoKb) {
        this.tamañoKb = tamañoKb;
    }

    public int getNumDesc() {
        return numDesc;
    }

    public void setNumDesc(int numDesc) {
        this.numDesc = numDesc;
    }
    
    @Override
    public String toString() {
        return  codigo + ";" + nombre + 
                ";" + descripcion + ";" + tamañoKb + 
                ";" + numDesc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.codigo;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.descripcion);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.tamañoKb) ^ (Double.doubleToLongBits(this.tamañoKb) >>> 32));
        hash = 13 * hash + this.numDesc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final App other = (App) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.tamañoKb) != Double.doubleToLongBits(other.tamañoKb)) {
            return false;
        }
        if (this.numDesc != other.numDesc) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }
}
