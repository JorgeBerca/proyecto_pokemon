package modelo;

import java.util.ArrayList;

public class Combate {
	
	Entrenador entrenador;
	Entrenador dominguero; // random

	Pokemon paladin;
	Pokemon rival;
	int numRival;
		
	Entrenador ganador;
	ArrayList<Turno> turnos;
	int numTurno;
	int jugadorKO;
	int rivalKO;
	
	int saludInicialPaladin;
	int saludInicialRival;
	
	
	public Combate(Entrenador entrenador) {
		this.entrenador = entrenador;
		this.dominguero = entrenador.generarOponente();
		this.turnos = new ArrayList<Turno>();
		this.paladin = entrenador.getEquipo()[0];
		this.numRival=0;
		this.rival = dominguero.getEquipo()[numRival];
		this.saludInicialPaladin = this.paladin.getSalud();
		this.saludInicialRival = this.rival.getSalud();
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public Entrenador getDominguero() {
		return dominguero;
	}

	public void setDominguero(Entrenador dominguero) {
		this.dominguero = dominguero;
	}

	public Pokemon getPaladin() {
		return paladin;
	}

	public void setPaladin(Pokemon paladin) {
		System.out.println("Nuevo paladín: "+paladin.getNombre());
		this.paladin = paladin;
	}

	public Pokemon getRival() {
		return rival;
	}

	public void setRival(Pokemon rival) {
		this.rival = rival;
	}

	public int getNumRival() {
		return numRival;
	}

	public void setNumRival(int numRival) {
		this.numRival = numRival;
	}

	public Entrenador getGanador() {
		return ganador;
	}

	public void setGanador(Entrenador ganador) {
		this.ganador = ganador;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}

	public int getNumTurno() {
		return numTurno;
	}

	public void setNumTurno(int numTurno) {
		this.numTurno = numTurno;
	}

	public int getJugadorKO() {
		return jugadorKO;
	}

	public void setJugadorKO(int jugadorKO) {
		this.jugadorKO = jugadorKO;
	}

	public int getRivalKO() {
		return rivalKO;
	}

	public void setRivalKO(int rivalKO) {
		this.rivalKO = rivalKO;
	}

	public int getSaludInicialPaladin() {
		return saludInicialPaladin;
	}

	public void setSaludInicialPaladin(int saludInicialPaladin) {
		this.saludInicialPaladin = saludInicialPaladin;
	}

	public int getSaludInicialRival() {
		return saludInicialRival;
	}

	public void setSaludInicialRival(int saludInicialRival) {
		this.saludInicialRival = saludInicialRival;
	}
	
	public double getPorcentajeSaludEntrenador() {
		double ahora = this.paladin.getSalud();
		double inicial = this.saludInicialPaladin;
		return ahora/inicial;
	}
	
	public double getPorcentajeSaludRival() {
		double ahora = this.rival.getSalud();
		double inicial = this.saludInicialRival;
		return ahora/inicial;
	}
	
	
	
}
