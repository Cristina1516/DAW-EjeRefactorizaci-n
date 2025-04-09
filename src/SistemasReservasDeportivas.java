import java.util.ArrayList;
import java.util.List;
import java.util.LocalDateTime;



/**
 * @author Cristina Clara
 * Fecha : 20/03/2025
 * Clase : SistemaReservaDeportivas
 */

public class SistemasReservasDeportivas {

	//Atributos 
	
	/**
	 * @param Listas de reservas
	 * La lista de reservas guardadas por el programa y solicitadas por el cliente
	 */
    private List<Reserva> reservas;
    
    /**
     * @param Saber si la iluminación está activa o no 
     * Se usa para saber el estado de las luces, true o false, es decir, si están encendidas o no
     */
    private boolean[] iluminacion;
    
    /**
     * @param Máximo reservas
     * El máximo de reservas que puede permit el programa
     */
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Este sistema guarda el número de reservas en una lista y te informa con tru o false dependiendo de 
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Te devuelve false, si esa reserva esta ocupada (la lista de reservas ha llegado al máximo de su capacidad o esa 
     * reserva en esa misma hora y día está ocupada)
     * @param idPista
     * @param fecha
     * @param duracion
     * @return
     */
    public boolean reservarPista(Reserva reserva) {
        int idPista = reserva.getIdPista();
        LocalDateTime fecha = reserva.getFecha();
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && esFechaDisponible(fecha, r)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(reserva);
        return true;
    }
    

    /**
     * Cancela la reserva si da la casualidad de que coincide con otra reserva de otra persona en ese mismo día y esa misma hora 
     * @param idReserva
     * @return
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * Marca la pista de donde va a estar la iluminación encendida
     * Si el número de pistas es menos a 0 o es mayor o igual al nº de pistas, dará como resultado false. 
     * Y sino dará true, es decir, mantendrá las luces encendidas en ese nº de pista
     * @param idPista
     * @return
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Marca la pista de donde va a estar la iluminación apagada
     * @param idPista
     * @return
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Se observa la disponibilidad de la reserva para que no coincida con otra reserva de otra persona 
     * @param idPista
     * @param fecha
     * @param hora
     * @return
     */
    public boolean verificarDisponibilidad(int idPista, LocalDateTime fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && esFechaDisponible(fecha, r)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }

	private void esFechaDisponible(LocalDateTime fecha, Reserva reserva) {
		r.getFecha().equals(fecha);
	}
}