package modelo;


public class Objeto {
	
	private int idObjeto;
	private String nombre;
	private int precio;

	public Objeto(int idObjeto, String nombre, int precio) {
		this.idObjeto = idObjeto;
		this.nombre = nombre;
		this.precio = precio;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
}
