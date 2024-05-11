package modelo;

public class PokemonFromDex {	
	
	int		id;
	String 	nombre;
	String	tipo1;
	String 	tipo2;
	int		nivel;
	
	public PokemonFromDex(
		int		id,
		String 	nombre,
		String	tipo1,
		String 	tipo2,
		int		nivel) {
		this.id = id;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.nivel = nivel;				
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getTipo1() {
		return tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public int getNivel() {
		return nivel;
	}
	
	
}
