
package modelo;

/**
 *
 * @author Estudiante
 */
public class Asistente extends Persona{
    
    private int edad; 

    public Asistente(String nombre, String apellido, String cedula,int edad) {
        super(nombre, apellido, cedula);
        this.edad=edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
