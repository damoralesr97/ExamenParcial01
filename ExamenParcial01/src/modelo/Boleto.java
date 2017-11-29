
package modelo;

 public class Boleto {
     
     private int asientoColumna;
     private char asientoFila;
     private Festival festival; 
     private Asistente asistente;

    public Boleto( Asistente asistente, Festival festival,char asientoFila,int asientoColumna) {
        this.asistente = asistente;
        this.festival = festival;
        this.asientoFila = asientoFila;
        this.asientoColumna=asientoColumna;
    }

    public int getAsientoColumna() {
        return asientoColumna;
    }

    public void setAsientoColumna(int asientoColumna) {
        this.asientoColumna = asientoColumna;
    }

    public char getAsientoFila() {
        return asientoFila;
    }

    public void setAsientoFila(char asientoFila) {
        this.asientoFila = asientoFila;
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
