package transformerexcel;

import java.util.List;

public class Main
{
    public static void main(String args[])
    {
        System.out.println("Iniciando..");
        String rutaCarpeta = "C:\\test\\";
        String nombreArchivoEntrada = rutaCarpeta + "entrada.csv";
        String nombreArchivoIntermedio =  rutaCarpeta + "intermedio.csv";
        String nombreArchivoSalida =  rutaCarpeta + "salida.csv";
        
        /*
        // 1 - LEER ARCHIVO ENTRADA:
        /String strArchivoLeido = Controlador.readFile(nombreArchivoEntrada);
        
        
        // 2 - GENERAR ARCHIVO INTERMEDIO CAMBIANDO , POR ;
        System.out.println("leido: " + strArchivoLeido);
        strArchivoLeido = strArchivoLeido.replace(",", ";");
        Controlador.writeFile(nombreArchivoIntermedio , strArchivoLeido);
        */
        
        // 3 - PROCESAR ARCHIVO INTERMEDIO Y ESCRIBIR ARCHIVO FINAL:
       String strProcesado = leerArchivoIntermedioProcesarYGuardarArchivoFinal(nombreArchivoIntermedio);
       Controlador.writeFile(nombreArchivoSalida, strProcesado);
        
       
    }
    public static String leerArchivoIntermedioProcesarYGuardarArchivoFinal(String nombreArchivoIntermedio)
    {
        String respuesta = "";
        
        List<String> arrNombres = Controlador.leerColumna(nombreArchivoIntermedio, 0 , ";");
        List<String> arrApellidos = Controlador.leerColumna(nombreArchivoIntermedio, 1, ";");
        List<String> arrApodos = Controlador.leerColumna(nombreArchivoIntermedio, 2, ";");
        List<String> arrEmails = Controlador.leerColumna(nombreArchivoIntermedio, 4, ";");
        
        System.out.println("arrNombres.size():" + arrNombres.size());
        for(int i = 1 ; i < arrNombres.size(); i++)
        {
            String salida = "";
            //String salida = "" + i + " - ";
            
            String nombreLoop = arrNombres.get(i);
            String apellidoLoop = arrApellidos.get(i);
            String apodoLoop = arrApodos.get(i);
            String emailLoop = arrEmails.get(i);
            
            if(nombreLoop != null && nombreLoop.length() > 0)
            {
                salida += nombreLoop + " ";
            }
            if(apellidoLoop != null && apellidoLoop.length() > 0)
            {
                salida += apellidoLoop + " ";
            }
            if(nombreLoop.length() > 0 || apellidoLoop.length() > 0)
            {
                //SI TENGO NOMBRE O APELLIDO , NO BUSCO PONER EL APODO
            }
            else if(apodoLoop != null && apodoLoop.length() > 0)
            {
                salida += apodoLoop + " ";
            }
            
            salida += ";" + emailLoop + "";
           
            
            if(nombreLoop.length() > 0 || apellidoLoop.length() > 0 || apodoLoop.length() > 0)
            {
                respuesta += salida + "\n";
                System.out.println(salida);
            }
            
        }
        return respuesta;
    }
}
