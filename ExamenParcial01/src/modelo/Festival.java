
package modelo;


public class Festival {
    
    private String nombre;
    private String fecha;
    private String capacidad;
    private String lugar;

    public Festival(String nombre, String fecha, String capacidad, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.lugar = lugar;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    

    @Override
    public String toString() {
        return "Festival{" + "nombre=" + nombre + ", fecha=" + fecha + ", capacidad=" + capacidad + ", lugar=" + lugar + '}';
    }
    
}

