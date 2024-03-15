/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7A;

/**
 *
 * @author User
 */
public class Vehiculos {
    
    private String marca;
    private String modelo;
    private int anio;
    private String bastidor;
    private String color;
    private String matricula;

    public Vehiculos(String marca, String modelo, int anio, String bastidor, String color, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.bastidor = bastidor;
        this.color = color;
        this.matricula = matricula;
    }

    public Vehiculos() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", bastidor=" + bastidor + ", color=" + color + ", matricula=" + matricula + '}';
    }
}
