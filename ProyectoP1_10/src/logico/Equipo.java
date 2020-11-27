package logico;
//Import library
import java.util.ArrayList;


public class Equipo {
	//Variables
	private String nombre;
	private int yearFundation;
	private String manager;
	private String ciudad;
	private String estadio;
	private int cantJJ;
	private int cantJG;
	private int cantJP;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Lesion> lesiones;
	
	//Constructor
	public Equipo(String nombre, int yearFundation, String manager, String ciudad, String estadio) {
		super();
		this.nombre = nombre;
		this.yearFundation = yearFundation;
		this.manager = manager;
		this.ciudad = ciudad;
		this.estadio = estadio;
		this.cantJJ = 0;
		this.cantJG = 0;
		this.cantJP = 0;
		this.jugadores = new ArrayList<>();
		this.lesiones = new ArrayList<>();
	}
	
	//Getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getYearFundation() {
		return yearFundation;
	}

	public void setYearFundation(int yearFundation) {
		this.yearFundation = yearFundation;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
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

	public Jugador findJugadorByNombre(String nombre) {
		Jugador aux = null;
		boolean buscar = false;
		int i=0;
		while (i<jugadores.size()&&!buscar) {
			if(jugadores.get(i).getNombre().equalsIgnoreCase(nombre)){
				aux = jugadores.get(i);
				buscar = true;
			}
			i++;
		}
		return aux;
	}
	
	public Jugador buscarJugadorByNumero(int numero) {
		Jugador aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<jugadores.size()){
			if(jugadores.get(i).getNumeroCamiseta() == numero) {
					aux = jugadores.get(i);
					encontrado = true;	
			}
			i++;
		}
		return aux;
	}
	
	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}

	public void insertarLesion(Lesion lesion) {
		lesiones.add(lesion);
		
	}

	public void insertarJugador(Jugador player) {
		jugadores.add(player);
		
	}
}
