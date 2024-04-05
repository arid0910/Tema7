/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7E;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoApps {

    // XmLElementWrapper define un contenedor para la lista 
    // de muebles
    @XmlElementWrapper(name = "catalogo")

    // XmlElement establece el nombre de los elementos
    // Cada elemento de la lista llevará esta etiqueta en el fichero xml
    @XmlElement(name = "App")
    private List<App> listaApp;

    private String descripcion;

    public List<App> getListaMuebles() {
        return listaApp;
    }

    public void setLista(List<App> lista) {
        this.listaApp = lista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
