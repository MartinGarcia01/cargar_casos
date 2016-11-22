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
        Neo4j consola = new Neo4j("neo4j", "gabita");
        String rutaCasos = "/home/martin/Escritorio/datos_limpios_casos-master/casos_limpios.csv";
        String[] encabezadosCasos = {"idcaso", "ano", "rol", "codigoOR", "NombreOR", "folioSAI", "fechaRecepcionCPLT", "iDLugarIngreso", "lugarIngreso", "iDTipoCaso", "tipoCaso", "fechaSolInstitucion", "fEchaRespuestaInst", "idEstadoWeb", "estado"};
        DocumentoCSV casos;
        
        // Archivo de reclamantes
        String rutaReclamante = "/home/martin/Escritorio/datos_limpios_casos-master/reclamantes_limpios.csv";
        String[] encabezadosReclamante = {"idcaso", "IDPersona", "Nombre", "ApellidoPaterno", "ApellidoMaterno", "IDTipoPersona", "TipoPersona", "IDComuna", "Comuna", "IDTipoCliente", "TipoCliente"};
        DocumentoCSV reclamantes;
        
        // Archivo de reclamados
        String rutaReclamado = "/home/martin/Escritorio/datos_limpios_casos-master/reclamados_limpios.csv";
        String[] encabezadosReclamado = {"idcaso", "IDInstitucion,", "Institucion"};
        DocumentoCSV reclamado;
        
        // Archivo de estados por casos
        String rutaEstadosPorCasos = "/home/martin/Escritorio/datos_limpios_casos-master/estadosPorCaso_limpios.csv";
        String[] encabezadosEstadosPorCasos = {"idcaso", "fechRegistro", "idEstado", "estado", "activo"};
        DocumentoCSV EstadosPorCasos;
        
        // Archivo de motivos por casos
        String rutaMotivosPorCasos = "/home/martin/Escritorio/datos_limpios_casos-master/motivosPorCaso_limpios.csv";
        String[] encabezadosMotivosPorCasos = {"idCaso", "IdMotivo", "Motivo"};
        DocumentoCSV MotivosPorCasos;
        
        // Cargar archivos
        casos = new DocumentoCSV(encabezadosCasos, rutaCasos,"caso");
        reclamantes = new DocumentoCSV(encabezadosReclamante, rutaReclamante,"reclamante");
        reclamado = new DocumentoCSV(encabezadosReclamado, rutaReclamado,"reclamado");
        MotivosPorCasos = new DocumentoCSV(encabezadosMotivosPorCasos, rutaMotivosPorCasos,"motivo");;
        EstadosPorCasos = new DocumentoCSV(encabezadosEstadosPorCasos, rutaEstadosPorCasos,"estado");
        consola.ejecutarConsulta(casos.getFilaSiguiente().toCypherCreateStatement());
        
        consola.close();
        
    }

}
