package modelo;

public class Objeto {
	
	private int idObjeto;
	private String nombre;
	private int ataque;
	private int ataqueEspecial;
	private int defensa;
	private int defensaEspecial;
	private int precio; 

	public Objeto(int idObjeto, String nombre, 
			      int ataque, int ataqueEspecial,
			      int defensa, int defensaEspecial) {
		this.idObjeto = idObjeto;
		this.nombre = nombre;
		this.ataque = ataque;
		this.ataqueEspecial = ataqueEspecial;
		this.defensa = defensa;
		this.defensaEspecial = defensaEspecial;
	}
	
	public int getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
