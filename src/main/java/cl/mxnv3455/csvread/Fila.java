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
    private String clase;

    public Fila(String clase, String[] campos, String[] nombres) {
        this.campos = campos;
        this.nombres = nombres;
        this.clase=clase;
    }

    private String makeRelCypher(String claseRel, String claveRel, String nombreRel) {
        String respuesta= "WITH node \n";
        respuesta += "MATCH (n:"+claseRel+") WHERE n."+claveRel+"= \""+this.getCampo(claveRel)+"\" \n";
        respuesta += "CREATE(n)-[:"+nombreRel+"]->(node)\n ";
        //MATCH (n:Caso) WHERE n.idcaso='3453534'
        return respuesta;
    }
    private String makeRelCypher(String claseRel, String claveRel, String nombreRel,String datoRel) {
        String respuesta= "WITH node \n";
        respuesta += "MATCH (n:"+claseRel+") WHERE n."+claveRel+"= \""+this.getCampo(claveRel)+"\" \n";
        respuesta += "CREATE(n)-[:"+nombreRel+"{fecha:[\""+this.getCampo(datoRel)+"\"]}]->(node)\n ";
        //MATCH (n:Caso) WHERE n.idcaso='3453534'
        return respuesta;
    }
    private String makeCreateCypher() {
        String respuesta = "CREATE(node:" + this.clase + "{";
        for (int i = 0; i < campos.length; i++) {
            respuesta += this.nombres[i] + ":\"" + this.campos[i] + "\",";
        }
        respuesta = respuesta.substring(0, respuesta.length() - 1);
        respuesta += "})";
        return respuesta;
    }

    public String toCypherCreateStatement() {
        String respuesta = makeCreateCypher();
        return respuesta;
    }

    public String toCypherCreateStatement(String claseRel, String claveRel,String nombreRel) {
        String respuesta = makeCreateCypher();
        respuesta+="\n"+makeRelCypher(claseRel, claveRel, nombreRel);
        return respuesta;

    }
    public String toCypherCreateStatement(String claseRel, String claveRel,String nombreRel,String datoRel) {
        String respuesta = makeCreateCypher();
        respuesta+="\n"+makeRelCypher(claseRel, claveRel, nombreRel,datoRel);
        return respuesta;

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

    @Override
    public String toString() {
        return Arrays.toString(campos);
    }

}
