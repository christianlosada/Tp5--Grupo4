/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Netbook
 */
public class Directorio {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    private TreeMap<Long, Contactos> directorio = new TreeMap();

    public TreeMap<Long, Contactos> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(TreeMap<Long, Contactos> directorio) {
        this.directorio = directorio;
    }

    @Override
    public String toString() {
        return "Directorio{" + "directorio=" + directorio + '}';
    }
    

// A. agregarContacto() que permite registrar un nuevo contacto con su respectivo nro. de
//teléfono. Siendo el nro. del teléfono la clave del mismo.
    public void agregarContacto(Long telefono, Contactos contacto) {
        directorio.putIfAbsent(telefono, contacto); //si esta lo agrega si no , no lo agrega
    }
//B. buscarContacto() que en base al nro. de teléfono retorna el Contacto asociado al mismo.

    public String buscarUnContacto(Long telefono) {
        for (Long t : directorio.keySet()) {
            if (t == telefono) {
                return directorio.ceilingEntry(telefono).toString();
            }

        }
        return "contacto no encontrado";
    }

//C. buscarTeléfono() que en base a un apellido nos devuelve un Set<Long> con los números
//de teléfono asociados a dicho apellido.
    public Set<Long> buscarTelefono(String apellidoBuscado) {
        Set<Long> lista = null;
        for (Contactos p : directorio.values()) {

            if (p.getApellido().equalsIgnoreCase(apellidoBuscado)) {

                lista.add(p.getTelefono());

            }

        }
        return lista;

    }

//D. buscarContactos() que en base a una ciudad nos devuelve un ArrayList con los
//Contactos asociados a dicha ciudad.
    public ArrayList buscarVariosContactos(String ciudadBuscada) {
        ArrayList<String> ciudadesEncontradas = new ArrayList();
        for (Contactos p : directorio.values()) {
            if (p.getCiudad().equalsIgnoreCase(ciudadBuscada)) {
                ciudadesEncontradas.add(ciudadBuscada);

            }

        }
        return ciudadesEncontradas;

    }
//E. borrarContacto() que en base al número de teléfono elimina el contacto del directorio

    public String borrarContacto(Long telefono) {
        for (Long t : directorio.keySet()) {
            if (t == telefono) {
                directorio.remove(t);
                return "removido";

            }
        }
        return "no encontrado";
    }
}
