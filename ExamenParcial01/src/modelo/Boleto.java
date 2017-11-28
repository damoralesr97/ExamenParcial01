
package modelo;

 class Boleto {
     
     private String asiento;
     private Festival festival; 
     private Asistente asistente;

    public Boleto(String asiento, Festival festival, Asistente asistente) {
        this.asiento = asiento;
        this.festival = festival;
        this.asistente = asistente;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }
     
     //holi
    
}
