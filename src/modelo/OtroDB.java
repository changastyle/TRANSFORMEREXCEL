package modelo;

public class OtroDB
{
    private String provincia;
    private String localidad;
    private String agencia;
    private String subAgencia;
    private String direccion;
    private String direccionNueva;
    private boolean existe;

    public OtroDB(String provincia, String localidad, String agencia, String subAgencia, String direccion, boolean existe)
    {
        this.provincia = provincia;
        this.localidad = localidad;
        this.agencia = agencia;
        this.subAgencia = subAgencia;
        this.direccion = direccion;
        this.existe = existe;
    }
    
    

    public String getAgencia()
    {
        int enteroAgencia = Integer.parseInt(agencia);
        
        if(enteroAgencia < 10)
        {
            agencia = "00" + enteroAgencia;
        }
        else if(enteroAgencia < 100)
        {
            agencia = "0" + enteroAgencia;
        }
        return agencia;
    }

    public void setAgencia(String agencia)
    {
        this.agencia = agencia;
    }

    public String getSubAgencia()
    {
        int enteroSubAgencia = Integer.parseInt(subAgencia);
        
        if(enteroSubAgencia < 10)
        {
            subAgencia = "0" + enteroSubAgencia;
        }
        return subAgencia;
    }

    public void setSubAgencia(String subAgencia)
    {
        this.subAgencia = subAgencia;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getDireccionNueva()
    {
        return direccionNueva;
    }

    public void setDireccionNueva(String direccionNueva)
    {
        this.direccionNueva = direccionNueva;
    }

    
    public boolean isExiste()
    {
        return existe;
    }

    public void setExiste(boolean existe)
    {
        this.existe = existe;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public void setProvincia(String provincia)
    {
        this.provincia = provincia;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    
    @Override
    public String toString()
    {
        return "Agencia " + getAgencia() + " Sub " + getSubAgencia() + " | " + direccion + " | existe " + existe;
    }

    
  
    
    
    
}
