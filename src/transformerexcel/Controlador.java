package transformerexcel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador
{
    public static List<String>leerColumna(String rutaArchivo, int columna , String caracterSeparador)
    {
        List<String> arrSaliente = new ArrayList<String>();
        
        List<String> arrLineasArchivoLeido = readFile(rutaArchivo);
        for(String lineaLoop : arrLineasArchivoLeido)
        {
            String[] lineaTotal = lineaLoop.split(caracterSeparador);
            
            if(lineaTotal != null)
            {
                String valor = lineaTotal[columna];
                if(valor != null)
                {
                    arrSaliente.add(valor);
                    //System.out.println(valor);
                }
            }
        }
             
        
        return arrSaliente;
    }
    public static String convertirUTF(String entrada)
    {
        entrada = Normalizer.normalize(entrada, Normalizer.Form.NFD);
        entrada = entrada.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return entrada;
        /*
        String salida = "";
        byte[] bytesEntrada = entrada.getBytes(StandardCharsets.ISO_8859_1);
        salida = new String(bytesEntrada, StandardCharsets.UTF_8);
        return salida;*/
    }
    
    public static List<String> readFile(String rutaArchivo)
    {
        List<String> arrSalida = new ArrayList<String>();
        
        BufferedReader br = null;
        try 
        {
            if(rutaArchivo != null)
            {
                File file = new File(rutaArchivo);
                
                if(file != null)
                {
                    if(file.exists())
                    {
                        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            
                        //br = new BufferedReader(new FileReader(rutaArchivo));
                        StringBuilder sb = new StringBuilder();
                        String linea = in.readLine();


                        while (linea != null) 
                        {
                            arrSalida.add(linea);
                            //salida += linea + "\n";
                            linea = in.readLine();
                            /*sb.append(linea);
                            sb.append(System.lineSeparator());*/

                        }
                        String everything = sb.toString();
                    }
                }
            }
            
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        } 
        
        return arrSalida;
    }
    public static void writeFile(String rutaArchivoSaliente , String contenido)
    {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter(new FileWriter(new File(rutaArchivoSaliente)));
            
            
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaArchivoSaliente), "ISO-8859-1"));
            out.write(contenido);
            out.close();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static String dameStrFromListString(List<String> listaLineas)
    {
        String salida = "";
        
        for(String stringLoop: listaLineas)
        {
            salida += stringLoop;
        }
        
        return salida;
    }
}
