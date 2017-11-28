
package modelo;


public class Artista extends Persona{
    
    private String genero;

    public Artista(String nombre, String apellido, String cedula,String genero) {
        super(nombre, apellido, cedula);
        this.genero=genero; 
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
 
    
}
