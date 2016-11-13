/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mxnv3455.csvread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.csv.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author martin
 */
public class DocumentoCSV {

    private String[] columnas;
    private String ruta;
    private List<Fila> filas;
    private MyIterator it;

    public DocumentoCSV(String[] columnas, String ruta) {
        this.columnas = columnas;
        this.ruta = ruta;
        this.filas = new LinkedList<>();
        this.cargarDocumento();
        this.it= new MyIterator<Fila>(this.filas.listIterator());

    }

    private void cargarDocumento() {
        File csvData = new File(this.ruta);
        BufferedReader entrada;
        int cont=0;
        try {
            entrada = new BufferedReader(new FileReader(csvData));
            CSVParser parser = CSVParser.parse(csvData, java.nio.charset.Charset.forName("utf-8"), CSVFormat.RFC4180.withDelimiter(';').withHeader());
            for (CSVRecord csvRecord : parser) {
                //System.out.println(csvRecord.get(0));
                cont++;
                String[] campos = new String[this.columnas.length];
                for (int i = 0; i < columnas.length; i++) {
                    try {
                        campos[i] = csvRecord.get(i);
                        
                    } catch (Exception e) {
                        System.err.println("fallo "+i);
                    }
                    
                }
                Fila f = new Fila(campos, this.columnas);
                this.filas.add(f);
            }
            entrada.close();
        } catch (Exception e) {
            System.err.println(cont);
            //e.printStackTrace();
        }
        System.err.println("documento cargado: "+this.ruta);
    }
    public Fila getFilaSiguiente(){
        return  (Fila)this.it.next();
        
    }
    public static class MyIterator<T> {

        private final ListIterator<T> listIterator;

        private boolean nextWasCalled = false;
        private boolean previousWasCalled = false;

        public MyIterator(ListIterator<T> listIterator) {
            this.listIterator = listIterator;
        }

        public T next() {
            nextWasCalled = true;
            if (previousWasCalled) {
                previousWasCalled = false;
                listIterator.next ();
            }
            return listIterator.next ();
        }

        public T previous() {
            if (nextWasCalled) {
                listIterator.previous();
                nextWasCalled = false;
            }
            previousWasCalled = true;
            return listIterator.previous();
        }

    }   
}
