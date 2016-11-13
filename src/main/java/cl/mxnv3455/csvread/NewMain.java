/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mxnv3455.csvread;

/**
 *
 * @author martin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Archivo de casos
        String rutaCasos = "/home/martin/Descargas/casos_mitad.csv";
        String[] encabezadosCasos = {"idcaso", "ano", "rol", "codigoOR", "NombreOR", "folioSAI", "fechaRecepcionCPLT", "iDLugarIngreso", "lugarIngreso", "iDTipoCaso", "tipoCaso", "fechaSolInstitucion", "fEchaRespuestaInst", "idEstadoWeb", "estado"};
        DocumentoCSV casos;
        
        // Archivo de reclamantes
        String rutaReclamante = "/home/martin/Descargas/reclamantes.csv";
        String[] encabezadosReclamante = {"idcaso", "IDPersona", "Nombre", "ApellidoPaterno", "ApellidoMaterno", "IDTipoPersona", "TipoPersona", "IDComuna", "Comuna", "IDTipoCliente", "TipoCliente"};
        DocumentoCSV reclamantes;
        
        // Archivo de reclamados
        String rutaReclamado = "/home/martin/Descargas/reclamados.csv";
        String[] encabezadosReclamado = {"idcaso", "IDInstitucion,", "Institucion"};
        DocumentoCSV reclamado;
        
        // Cargar archivos
        casos = new DocumentoCSV(encabezadosCasos, rutaCasos);
        //reclamantes = new DocumentoCSV(encabezadosReclamante, rutaReclamante);
        reclamado = new DocumentoCSV(encabezadosReclamado, rutaReclamado);
        
        for (int i = 0; i < 10; i++) {
            Fila f = casos.getFilaSiguiente();
            System.out.println(f);
        }
    }

}
