package modelo;

import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class ListaPokemon {
	
	
	Pokemon[] pokemons;
	Pokemon[] equipo;
	Pokemon[] pc;
		
	public ListaPokemon(Pokemon[] lista) {
		this.setPokemons(lista);
	}

	public Pokemon[] getPokemons() {
		return pokemons;
	}

	public void setPokemons(Pokemon[] pokemons) {
		
		this.pokemons = pokemons;
		
		// Busco los del equipo
		ArrayList<Pokemon> equipo = new ArrayList();
		for (int i=0; i<pokemons.length; i++) {
			if (pokemons[i].getCaja() == 0) {
				equipo.add(pokemons[i]);
			}
		}			
		this.equipo = new Pokemon[equipo.size()];
		this.equipo = equipo.toArray(this.equipo);

		// Busco los del PC
		ArrayList<Pokemon> pc = new ArrayList();
		for (int i=0; i<pokemons.length; i++) {
			if (pokemons[i].getCaja() == 1) {
				pc.add(pokemons[i]);
			}
		}
		this.pc = new Pokemon[pc.size()];
		this.pc = pc.toArray(this.pc);
	}

	public Pokemon[] getEquipo() {
		return equipo;
	}

	public void setEquipo(Pokemon[] equipo) {
		this.equipo = equipo;
	}

	public Pokemon[] getPc() {
		return pc;
	}

	public void setPc(Pokemon[] pc) {
		this.pc = pc;
	}
	
	
	

	
}
