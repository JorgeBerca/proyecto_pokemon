package modelo;

public class Entrenador {
	
	private static Entrenador entrenadorActual = null;
	
	public static Entrenador getEntrenadorActual() {
		return entrenadorActual;
	}
	
	public static void setEntrenadorActual(int id, String nombre, int dinero) {
		entrenadorActual = new Entrenador(id, nombre, dinero);		
	}

	
	
	int id;
	String nombre;
	int dinero;

	public Entrenador(int id, String nombre, int dinero) {
		this.id = id;
		this.nombre = nombre;
		this.dinero = dinero;
	}
	
	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public void setDinero(int dinero) {
		this.dinero = dinero;
		
	}

}


