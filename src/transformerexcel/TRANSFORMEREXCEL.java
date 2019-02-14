package transformerexcel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import jxl.Sheet;
import jxl.Workbook;
import modelo.OtroDB;
import modelo.SicomModel;

public class TRANSFORMEREXCEL
{
    private final static String archivo1 = "C:\\transformer\\1.xls";
    private final static String archivoSicomDB = "C:\\transformer\\sicom-db.xls";
    private final static String archivoRes = "C:\\transformer\\res.csv";
    
    /*
    public static void main(String[] args)
    {
       
        List<SicomModel> arrSicom = convertirSicomDB();
        List<OtroDB> arrOtro = convertir1();
        
        System.out.println("SICOM DB:"+ arrSicom.size());
        System.out.println("OTRO DB:"+ arrOtro.size());
        for(OtroDB otro : arrOtro)
        {
            for(SicomModel sicom : arrSicom)
            {
                boolean existe = false;
                String str = "Agencia " + otro.getAgencia() + " Sub " + otro.getSubAgencia();
                boolean cumple = sicom.getNombreAgencia().startsWith(str);
                if(cumple)
                {
                   // System.out.println("ACA");
                    existe = true;
                    otro.setExiste(existe);
                    if(existe)
                    {
                        //otro.setDireccion(sicom.getDireccion());
                        otro.setDireccionNueva(sicom.getDireccion());
                    }
                    existe = false;
                    break;
                }
            }
        }
        
        
        //IMPRIMO EL RES:
        System.out.println("COMO QUEDO:");
        int contador = 1;
        for(OtroDB otro : arrOtro)
        {
            System.out.println(contador + " | " + otro);
            contador++;
        }
        
        escribirRes(arrOtro);
    }
    */
    public static List<SicomModel> convertirSicomDB()
    {
        List<SicomModel> arr = new ArrayList<SicomModel>();
        
        try
        {
            Workbook libro = Workbook.getWorkbook(new File(archivoSicomDB));
            Sheet hoja = libro.getSheet(0);

            int filasMax = hoja.getRows();
            int colMax = hoja.getColumns();
            //System.out.println("filas = " + filasMax);
            //System.out.println("columnas = " + colMax );


            int contador = 0 ;
            while(contador < filasMax)
            {
                
                String nombreAgencia = convertirUTF(hoja.getCell(2,contador).getContents());
                String direccion = convertirUTF(hoja.getCell(3,contador).getContents());
                
                //System.out.println(contador + " | " + nombreAgencia + " | " + direccion);
                
                if(nombreAgencia != null && direccion != null)
                {
                    SicomModel sicomModel = new SicomModel(nombreAgencia, direccion);
                    arr.add(sicomModel);
                }
                contador++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arr;
    }
    public static List<OtroDB> convertir1()
    {
        List<OtroDB> arr = new ArrayList<OtroDB>();
        
        try
        {
            Workbook libro = Workbook.getWorkbook(new File(archivo1));
            Sheet hoja = libro.getSheet(0);

            int filasMax = hoja.getRows();
            int colMax = hoja.getColumns();
            //System.out.println("filas = " + filasMax);
            //System.out.println("columnas = " + colMax );


            int contador = 0 ;
            while(contador < filasMax)
            {
                String provincia = convertirUTF(hoja.getCell(0,contador).getContents());
                String localidad = convertirUTF(hoja.getCell(1,contador).getContents());
                String agencia = convertirUTF(hoja.getCell(2,contador).getContents());
                String subAgencia = convertirUTF(hoja.getCell(3,contador).getContents());
                String direccion = convertirUTF(hoja.getCell(4,contador).getContents());
                
                //System.out.println(contador + " | " + agencia + " | " + subAgencia + " | " + direccion);
                
                if(provincia != null && localidad != null &&agencia != null && subAgencia != null && direccion != null)
                {
                    OtroDB otroDB = new OtroDB(provincia, localidad, agencia, subAgencia,direccion, false);
                    arr.add(otroDB);
                }
                contador++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arr;
    }
    
    public static void escribirRes(List<OtroDB> arr)
    {
        try
        {
            File archivoRes = new File(TRANSFORMEREXCEL.archivoRes);
            if(archivoRes != null)
            {
                BufferedWriter bw = null;
                FileWriter fw = null;
                fw = new FileWriter(archivoRes);
                bw = new BufferedWriter(fw);

                String content = "";
                for(OtroDB otroLoop : arr)
                {
                    String strExiste = "";
                    if(otroLoop.isExiste())
                    {
                        strExiste = otroLoop.getDireccionNueva();
                    }
                    else
                    {
                        strExiste = "NO EXISTE";
                    }
                    
                    content += otroLoop.getProvincia()+";"+otroLoop.getLocalidad()+";"+ otroLoop.getAgencia() +";"+ otroLoop.getSubAgencia()+";"+ otroLoop.getDireccion()+";"+ strExiste + " \n";
                }

                bw.write(content);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        /*
        try
        {
            Workbook libro = Workbook.getWorkbook(new File(archivoRes));
            Sheet hoja = libro.getSheet(0);

            int filasMax = hoja.getRows();
            int colMax = hoja.getColumns();
            System.out.println("filas = " + filasMax);
            System.out.println("columnas = " + colMax );


            int contador = 0 ;
            while(contador < filasMax)
            {
                
                hoja.;
                ///String direccion = hoja.getCell(3,contador).getContents();
                //System.out.println(contador + " | " + nombreAgencia + " | " + direccion);
                contador++;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        */
    }
    public static void leer1()
    {
        try
        {
            Workbook libro = Workbook.getWorkbook(new File(archivoSicomDB));
            Sheet hoja = libro.getSheet(0);

            int filasMax = hoja.getRows();
            int colMax = hoja.getColumns();
            System.out.println("filas = " + filasMax);
            System.out.println("columnas = " + colMax );


            int contador = 0 ;
            while(contador < filasMax)
            {
                
                String nombreAgencia = hoja.getCell(2,contador).getContents();
                String direccion = hoja.getCell(3,contador).getContents();
                System.out.println(contador + " | " + nombreAgencia + " | " + direccion);
                contador++;
                /*
                boolean condicion1 = (hoja.getCell(6,filaActual).getContents() != "" && hoja.getCell(12,filaActual).getContents() != "");
                boolean condicion2 = (hoja.getCell(6,filaActual).getContents() != "HOME TEAM");
                if( ! hoja.getCell(6,filaActual).getContents().trim().equalsIgnoreCase("HOME TEAM")   && ! hoja.getCell(6,filaActual).getContents().trim().equalsIgnoreCase(""))
                {
                    String horario = hoja.getCell(2,filaActual).getContents().toString();
                    if(horario.trim().equalsIgnoreCase(""))
                    {
                        horario = ultimoHorario;
                    }
                    else
                    {
                        ultimoHorario = horario;
                    }
                    String numeroPartido = hoja.getCell(3,filaActual).getContents();
                    String local = formateoNombreEquipos(hoja.getCell(6,filaActual).getContents());
                    String visitante = formateoNombreEquipos(hoja.getCell(12,filaActual).getContents());
                    String L = hoja.getCell(8,filaActual).getContents();
                    String E = hoja.getCell(9,filaActual).getContents();
                    String V = hoja.getCell(10,filaActual).getContents();
                    String LoE = hoja.getCell(14,filaActual).getContents();
                    String LoV = hoja.getCell(15,filaActual).getContents();
                    }*/
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static String convertirUTF(String entrada)
    {
        String salida = "";
        byte[] bytesEntrada = entrada.getBytes(StandardCharsets.ISO_8859_1);
        salida = new String(bytesEntrada, StandardCharsets.UTF_8);
        return salida;
    }
}
