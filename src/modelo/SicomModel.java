package modelo;

public class SicomModel
{
    private String nombreAgencia;
    private String direccion;

    public SicomModel(String nombreAgencia, String direccion)
    {
        this.nombreAgencia = nombreAgencia;
        this.direccion = direccion;
    }

    public String getNombreAgencia()
    {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia)
    {
        this.nombreAgencia = nombreAgencia;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    @Override
    public String toString()
    {
        return "SicomModel{" + "nombreAgencia=" + nombreAgencia + ", direccion=" + direccion + '}';
    }
    
    
}
