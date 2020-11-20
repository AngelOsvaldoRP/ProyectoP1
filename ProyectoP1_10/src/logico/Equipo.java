package logico;
//Import library
import java.util.ArrayList;


public class Equipo {
	//Variables
	private String nombre;
	private String yearFundation;
	private String manager;
	private String estadio;
	private int cantTitulos;
	private int cantJJ;
	private int cantJG;
	private int cantJP;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Lesion> lesiones;
	
	//Constructor
	public Equipo(String nombre, String yearFundation, String manager, String estadio, int cantTitulos, int cantJJ,
			int cantJG, int cantJP, ArrayList<Jugador> jugadores, ArrayList<Lesion> lesiones) {
		super();
		this.nombre = nombre;
		this.yearFundation = yearFundation;
		this.manager = manager;
		this.estadio = estadio;
		this.cantTitulos = cantTitulos;
		this.cantJJ = cantJJ;
		this.cantJG = cantJG;
		this.cantJP = cantJP;
		this.jugadores = jugadores;
		this.lesiones = lesiones;
	}
	
	//Getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getYearFundation() {
		return yearFundation;
	}

	public void setYearFundation(String yearFundation) {
		this.yearFundation = yearFundation;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int getCantTitulos() {
		return cantTitulos;
	}

	public void setCantTitulos(int cantTitulos) {
		this.cantTitulos = cantTitulos;
	}

	public int getCantJJ() {
		return cantJJ;
	}

	public void setCantJJ(int cantJJ) {
		this.cantJJ = cantJJ;
	}

	public int getCantJG() {
		return cantJG;
	}

	public void setCantJG(int cantJG) {
		this.cantJG = cantJG;
	}

	public int getCantJP() {
		return cantJP;
	}

	public void setCantJP(int cantJP) {
		this.cantJP = cantJP;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugador(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public ArrayList<Lesion> getLesiones() {
		return lesiones;
	}

	public void setLesiones(ArrayList<Lesion> lesiones) {
		this.lesiones = lesiones;
	}
	
	//Funciones para estadisticas de bateo del equipo
	
	public float avgEquipoBateo() {
		int cantBateadores = 0;
		float sumaAVG= 0;
		float avgEquipo=0;
		for(Jugador player : jugadores) {
			if(player instanceof Bateo) {
				sumaAVG += player.avg();
				cantBateadores++;
			}
		}
		
		avgEquipo =(float) (sumaAVG/ cantBateadores);
		
		return avgEquipo;
	}
	
	public int cantHitsEquipo() {
		int hitsEquipo = 0;
		for(Jugador player : jugadores) {
			if(player instanceof Bateo) {
				hitsEquipo += player.cantHits;
			}
		}
		return hitsEquipo;
	}
	
	public int cantHREquipo() {
		int HREquipo = 0;
		for(Jugador player : jugadores) {
			if(player instanceof Bateo) {
				HREquipo += player.cantHR;
			}
		}
		return HREquipo;
	}

	public int cantCarrerasEquipo() {
		int CarrerasEquipo = 0;
		for(Jugador player : jugadores) {
			if(player instanceof Bateo) {
				CarrerasEquipo += ((Bateo) player).getCantCA();
			}
		}
		return CarrerasEquipo;
	}
	
	
	//Funciones para estadisticas de picheo del equipo
	
	public float avgEquipoPicheo() {
		int cantPiches = 0;
		float sumaAVG= 0;
		float avgEquipo=0;
		for(Jugador player : jugadores) {
			if(player instanceof Picheo) {
				sumaAVG += player.avg();
				cantPiches++;
			}
		}
		
		avgEquipo =(float) (sumaAVG/ cantPiches);
		
		return avgEquipo;
	}
	
	public int cantPonchesEquipo() {
		int ponchesEquipo = 0;
		for(Jugador player : jugadores) {
			if(player instanceof Picheo) {
				ponchesEquipo += player.cantPonches;
			}
		}
		return ponchesEquipo;
	}
	
	public int cantBBEquipo() {
		int BBEquipo = 0;
		for(Jugador player : jugadores) {
			if(player instanceof Picheo) {
				BBEquipo += player.cantBB;
			}
		}
		return BBEquipo;
	}
	
	
	
	
	
	
}
