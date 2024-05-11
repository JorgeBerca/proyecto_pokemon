package modelo;

import java.util.Random;

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
	private int ataqueEspecial;
    private int defensaEspecial;
    private int nivel;
    private int fertilidad;
    private String sexo;
    private int experiencia;
    private String estado;
    private String tipo1;
	private String tipo2;
    private Objeto objeto; 
	private Movimiento movimientosActivos[];
	private Movimiento movimientosAprendidos[];

    // (NUM_POKEDEX,ID_ENTRENADOR, CAJA, NOMBRE, MOTE, SALUD, ATAQUE, DEFENSA, 
    // VELOCIDAD, AT_ESPECIAL, DEF_ESPECIAL, NIVEL, FERTILIDAD, SEXO, EXPERIENCIA

	// Constructor vacío
	public Pokemon() {
	    this.idPokemon=0;
	    this.numPokedex=0;
	    this.idEntrenador=0;
	    this.caja=0;
	    this.nombre="";
	    this.mote="";
	    this.salud=1;
	    this.ataque=1;
	    this.defensa=1;
	    this.velocidad=1;
	    this.ataqueEspecial=1;
	    this.defensaEspecial=1;
	    this.nivel=1;
	    this.fertilidad=5;
	    this.sexo="H";
	    this.experiencia=1;
	    this.estado="";
	    this.objeto=null;
	    this.tipo1="";
	    this.tipo2="";
	    this.movimientosActivos=null;
	    this.movimientosAprendidos=null;
	}
	
    
	// Constructor básico 
    public Pokemon(int idPokemon, int numPokedex, int idEntrenador, int caja, String nombre, String mote) {
        this.idPokemon = idPokemon;
        this.numPokedex = numPokedex;
        this.idEntrenador = idEntrenador;
        this.caja = caja;
        this.nombre = nombre;
        this.mote = mote;
    }

    // Constructor completo BD
    public Pokemon(int idPokemon, int numPokedex, int idEntrenador, int caja, String nombre, String mote,
    		       int salud, int ataque, int defensa, int velocidad, int ataqueEspecial, int defensaEspecial,
    		       int nivel, int fertilidad, String sexo, int estado, String tipo1, String tipo2) {
        this.idPokemon = idPokemon;
        this.numPokedex = numPokedex;
        this.idEntrenador = idEntrenador;
        this.caja = caja;
        this.nombre = nombre;
        this.mote = mote;
	    this.salud=salud;
	    this.ataque=ataque;
	    this.defensa=defensa;
	    this.velocidad=velocidad;
	    this.ataqueEspecial=ataqueEspecial;
	    this.defensaEspecial=defensaEspecial;
	    this.nivel=nivel;
	    this.fertilidad=fertilidad;
	    this.sexo=sexo;
	    this.experiencia=1;
	    this.estado="";
	    this.objeto=null;
	    this.tipo1=tipo1;
	    this.tipo2=tipo2;        
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
		return ataqueEspecial;
	}

	public void setAtEspecial(int atEspecial) {
		this.ataqueEspecial = atEspecial;
	}

	public int getDefEspecial() {
		return defensaEspecial;
	}

	public void setDefEspecial(int defEspecial) {
		this.defensaEspecial = defEspecial;
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


	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto idObjeto) {
		this.objeto = idObjeto;
		// TODO: falta aplicar aumeta y disminuye
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

	public Movimiento[] getMovimientosAprendidos() {
		return movimientosAprendidos;
	}

	public void setMovimientosAprendidos(Movimiento[] movimientosAprendidos) {
		this.movimientosAprendidos = movimientosAprendidos;
	}
	
	// Comprueba si puede subir de nivel y lo sube 
	public void subirNivel() {
		Random rnd = new Random();
		while ( experiencia >= 10*nivel ) {
			salud = salud + rnd.nextInt(5)+1;
			ataque = ataque + rnd.nextInt(5)+1;
			defensa = defensa + rnd.nextInt(5)+1;
			ataqueEspecial = ataqueEspecial + rnd.nextInt(5)+1;
			defensaEspecial = defensaEspecial + rnd.nextInt(5)+1;
			velocidad = velocidad + rnd.nextInt(5)+1;
			nivel++;
			// TODO: Cada tres niveles puede aprender un ataque nuevo
		}
	}
	
	// TODO: Atacar a otro pokemon, falta ataque y actualizar
	public void atacar(Pokemon rival) {
		
	}
	
	// TODO: Comprueba ventaja según tipos con el rival (NEUTRO / VENTAJA / DOBLE_VENTAJA / DESVENTAJA)
	public String ventaja(Pokemon rival) {
		return null;
	}
	
	// TODO: Aprender un movimiento de los posibles lo debe poner en la lista activa si hay sitio si no en los aprendidos
	public void aprenderMovimiento() {
		
	}
	
	// TODO: Mover movimientos
	
	
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
                ", atEspecial=" + ataqueEspecial +
                ", defEspecial=" + defensaEspecial +
                ", nivel=" + nivel +
                ", fertilidad=" + fertilidad +
                ", sexo=" + sexo +
                ", estado='" + estado + '\'' +
                ", experiencia=" + experiencia +
                //", idObjeto=" + idObjeto +
                '}';
    }
    
   
}
