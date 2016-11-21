/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mxnv3455.csvread;

import java.util.Arrays;

/**
 *
 * @author martin
 */
public class Fila {

    private String[] campos;
    private String[] nombres;

    public Fila(String[] campos, String[] nombres) {
        this.campos = campos;
        this.nombres = nombres;
    }

    public String getCampo(String campo) {
        int indice = Arrays.asList(this.nombres).indexOf(campo);
        if (indice == -1) {
            return null;
        }
        try {
            return this.campos[indice];
        } catch (Exception e) {
            return null;
        }
    }
    public String getRelasionesNodos(){
        return "";
    }
    public String getInsercion(String tabla) {
        if (tabla.equals("caso")) {
            String insert="CREATE(caso1:Caso{"+this.nombres[0]+":"+this.campos[0]+","+this.nombres[1]+":'"+this.nombres[1]+","+this.nombres[6]+":'"+this.nombres[6]+"})";
        } else if(tabla.equals("caso_por_motivo")) {
        } else if(tabla.equals("caso_por_estado")) {
        } else if(tabla.equals("reclamante")) {
        } else if(tabla.equals("reclamado")) {

        }

        return "";
    }

    @Override
    public String toString() {
        return Arrays.toString(campos);
    }

}
