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
    

    public neo4j(String user, String pass) {
        this.driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic(user, pass));
        this.session = driver.session();
    }
   
    public boolean consultarNodoExiste(String nombreCampo,String valorCampo){
        return false;
    }
    public void close(){
        this.session.close();
        this.driver.close();
    }
    
}
