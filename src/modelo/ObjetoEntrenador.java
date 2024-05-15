package modelo;


public class ObjetoEntrenador {
	
	private int idObjeto;
	private String nombre;
	private int cantidad;

	public ObjetoEntrenador(int idObjeto, String nombre,int cantidad) {
		this.idObjeto = idObjeto;
		this.nombre = nombre;
		this.cantidad = cantidad;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
    public boolean equals(Object object) {
    	if (this == object) return true;
    	if (!(object instanceof ObjetoEntrenador)) return false;
    	ObjetoEntrenador obj= (ObjetoEntrenador)object;
    	return (this.idObjeto  == obj.getIdObjeto());
    }
	
}
