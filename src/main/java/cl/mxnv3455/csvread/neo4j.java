/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mxnv3455.csvread;
import java.util.List;
import org.neo4j.driver.v1.*;
/**
 *
 * @author martin
 */
public class neo4j {
    private Driver driver;
    private Session session;
    private int numeroInsercion;

    public neo4j(String user, String pass) {
        this.driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic(user, pass));
        this.session = driver.session();
    }
    public boolean insertarFilaCasosPorMotivo(Fila filaCasoPorMotivo){
        return false;
    }
    public boolean insertarFilaCasosProEstado(Fila filaCasoProEstado){
        return false;
    }
    public boolean insertarFilaReclamantes(Fila filaReclamantes){
        return false;
    }
    public boolean insertarFilaReclamado(Fila filaReclamado){
        return false;
    }
    public boolean insertarFilaCasos(Fila filaCaso){
        String consultanNodoCaso="CREATE(caso2:Caso{"+filaCaso.getNombrePorIndice(0)+":"+filaCaso.getCampoPorIndice(0)+","+filaCaso.getNombrePorIndice(1)+":"+filaCaso.getCampoPorIndice(1)+","+filaCaso.getNombrePorIndice(6)+":"+filaCaso.getCampoPorIndice(6)+"})";
        session.run(consultanNodoCaso);
        return false;
    }
    public boolean consultarNodoExiste(){
        return false;
    }
    public void close(){
        this.session.close();
        this.driver.close();
    }
    
}
