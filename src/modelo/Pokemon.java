package modelo;

public class Pokemon {
    private int idPokemon;
    private int numPokedex;
    private int idEntrenador;
    private int caja;
    private String nombre;
    private String mote;
    private int salud;
    private int ataque;
    private int defensa;
    private int velocidad;
	private int atEspecial;
    private int defEspecial;
    private int nivel;
    private int fertilidad;
    private String sexo;
    private int experiencia;
    private String estado;
    private String movimiento1;
    private String movimiento2;
    private String movimiento3;
    private String movimiento4;
    private int idObjeto;
    private String tipo1;
	private String tipo2;
	private Movimiento movimientosActivos[];
	private Movimiento movimientos[];

    // (NUM_POKEDEX,ID_ENTRENADOR, CAJA, NOMBRE, MOTE, SALUD, ATAQUE, DEFENSA, 
    // VELOCIDAD, AT_ESPECIAL, DEF_ESPECIAL, NIVEL, FERTILIDAD, SEXO, EXPERIENCIA

    
	// Constructor
    public Pokemon(int idPokemon, int numPokedex, int idEntrenador, int caja, String nombre, String mote, int salud,
                   int ataque, int defensa, int velocidad, int atEspecial, int defEspecial, int nivel, int fertilidad,
                   String sexo, int experiencia, String tipo1, String tipo2) {
    			   // String estado, String movimiento1, String movimiento2,
                   // String movimiento3, String movimiento4, int idObjeto
        this.idPokemon = idPokemon;
        this.numPokedex = numPokedex;
        this.idEntrenador = idEntrenador;
        this.caja = caja;
        this.nombre = nombre;
        this.mote = mote;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.atEspecial = atEspecial;
        this.defEspecial = defEspecial;
        this.nivel = nivel;
        this.fertilidad = fertilidad;
        this.sexo = sexo;
        this.experiencia = experiencia;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        // this.estado = estado;
        // this.movimiento1 = movimiento1;
        // this.movimiento2 = movimiento2;
        // this.movimiento3 = movimiento3;
        // this.movimiento4 = movimiento4;
        // this.idObjeto = idObjeto;
        // this.enEquipo = enEquipo;
    }

    // Getters and setters
    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }
    
    public int getNumPokedex() {
		return numPokedex;
	}

	public void setNumPokedex(int numPokedex) {
		this.numPokedex = numPokedex;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public int getCaja() {
		return caja;
	}

	public void setCaja(int caja) {
		this.caja = caja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getAtEspecial() {
		return atEspecial;
	}

	public void setAtEspecial(int atEspecial) {
		this.atEspecial = atEspecial;
	}

	public int getDefEspecial() {
		return defEspecial;
	}

	public void setDefEspecial(int defEspecial) {
		this.defEspecial = defEspecial;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getFertilidad() {
		return fertilidad;
	}

	public void setFertilidad(int fertilidad) {
		this.fertilidad = fertilidad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMovimiento1() {
		return movimiento1;
	}

	public void setMovimiento1(String movimiento1) {
		this.movimiento1 = movimiento1;
	}

	public String getMovimiento2() {
		return movimiento2;
	}

	public void setMovimiento2(String movimiento2) {
		this.movimiento2 = movimiento2;
	}

	public String getMovimiento3() {
		return movimiento3;
	}

	public void setMovimiento3(String movimiento3) {
		this.movimiento3 = movimiento3;
	}

	public String getMovimiento4() {
		return movimiento4;
	}

	public void setMovimiento4(String movimiento4) {
		this.movimiento4 = movimiento4;
	}

	public int getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

    
    
    public void meterPC() {
    	this.caja = 1;
    }
    
    public void sacarPC() {
    	this.caja = 0;
    }
    
    public boolean isPC() {
    	return (this.caja == 1);
    }

    public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

	public Movimiento[] getMovimientosActivos() {
		return movimientosActivos;
	}

	public void setMovimientosActivos(Movimiento[] movimientosActivos) {
		this.movimientosActivos = movimientosActivos;
	}

    public Movimiento[] getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Movimiento[] movimientos) {
		this.movimientos = movimientos;
	}

	
    @Override
    public String toString() {
        return "Pokemon{" +
                "idPokemon=" + idPokemon +
                ", numPokedex=" + numPokedex +
                ", idEntrenador=" + idEntrenador +
                ", caja=" + caja +
                ", nombre='" + nombre + '\'' +
                ", mote='" + mote + '\'' +
                ", salud=" + salud +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", velocidad=" + velocidad +
                ", atEspecial=" + atEspecial +
                ", defEspecial=" + defEspecial +
                ", nivel=" + nivel +
                ", fertilidad=" + fertilidad +
                ", sexo=" + sexo +
                ", estado='" + estado + '\'' +
                ", experiencia=" + experiencia +
                ", movimiento1='" + movimiento1 + '\'' +
                ", movimiento2='" + movimiento2 + '\'' +
                ", movimiento3='" + movimiento3 + '\'' +
                ", movimiento4='" + movimiento4 + '\'' +
                ", idObjeto=" + idObjeto +
                '}';
    }
}
