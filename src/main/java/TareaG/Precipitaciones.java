/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TareaG;

import java.time.LocalDate;

/**
 *
 * @author adam
 */
public class Precipitaciones {
    
    private LocalDate fecha;
    private String estacionMeteorologica;
    private String provincia;
    private double precipitacion;

    public Precipitaciones(LocalDate fecha, String estacionMeteorologica, String provincia, double precipitacion) {
        this.fecha = fecha;
        this.estacionMeteorologica = estacionMeteorologica;
        this.provincia = provincia;
        this.precipitacion = precipitacion;
    }

    public Precipitaciones() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstacionMeteorologica() {
        return estacionMeteorologica;
    }

    public void setEstacionMeteorologica(String estacionMeteorologica) {
        this.estacionMeteorologica = estacionMeteorologica;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(double precipitacion) {
        this.precipitacion = precipitacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Precipitaciones{");
        sb.append("fecha=").append(fecha);
        sb.append(", estacionMeteorologica=").append(estacionMeteorologica);
        sb.append(", provincia=").append(provincia);
        sb.append(", precipitacion=").append(precipitacion);
        sb.append('}');
        return sb.toString();
    }
}
