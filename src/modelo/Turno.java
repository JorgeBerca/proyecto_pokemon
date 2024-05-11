package modelo;

public class Turno {
	
	int idCombate;
	int numTurno;
	Movimiento accionEntrenador;
	Movimiento accionRival;
	
	public Turno(int idCombate, int numero, Movimiento accionEntrenador, Movimiento accionRival) {
		this.numTurno = numero;
		this.accionEntrenador = accionEntrenador;
		this.accionRival = accionRival;
	}

	public int getIdCombate() {
		return idCombate;
	}

	public void setIdCombate(int idCombate) {
		this.idCombate = idCombate;
	}

	public int getNumTurno() {
		return numTurno;
	}

	public void setNumTurno(int numTurno) {
		this.numTurno = numTurno;
	}

	public Movimiento getAccionEntrenador() {
		return accionEntrenador;
	}

	public void setAccionEntrenador(Movimiento accionEntrenador) {
		this.accionEntrenador = accionEntrenador;
	}

	public Movimiento getAccionRival() {
		return accionRival;
	}

	public void setAccionRival(Movimiento accionRival) {
		this.accionRival = accionRival;
	}
	

}
