import java.util.LocalDateTime;

public class Reserva {
	
	//Atributos 
	
	/**
	 * @param Número de pistas 
	 */
    private int idPista;
    
    /**
     * @param Guarda la fecha de la reserva 
     */
    private LocalDateTime fecha;
    
    /**
     * @param Guarda la duración de la reserva 
     */
    private int duracion;

    /**
     * Constructor con 3 parámetros 
     * @param idPista
     * @param fecha
     * @param duracion
     */
    public Reserva(int idPista, LocalDateTime fecha, int duracion) {
        this.idPista = idPista;
        this.LocalDateTime = fecha;
        this.duracion = duracion;
    }

    /**
     *@return Devuelve el número de pistas 
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * @return La fecha de la reserva  
     */
    public LocalDateTime getFecha() {
        return LocalDateTime;
    }

    /**
     * @return La duración de la reserva 
     */
    public int getDuracion() {
        return duracion;
    }
    
}