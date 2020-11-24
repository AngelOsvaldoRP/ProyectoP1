package logico;

//Import library
import java.util.ArrayList;

public class Torneo {
	//Variables
	private ArrayList<Juego> juegos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Jugador> jugadores;
	private static Torneo torneo = null;
	
	public static String nombreJ;
	public static String nombreE;
	
	public static int autoGenCode;

	
	//Constructor
	private Torneo() {
		super();
		this.juegos =new ArrayList<Juego>();
		this.equipos = new ArrayList<Equipo>();
		this.jugadores = new ArrayList<Jugador>();
		autoGenCode = 0;
	}
	
	public static Torneo getInstance() {
		if(torneo==null) {
			torneo = new Torneo();
		}
		return torneo;
	}

	//Getters and Setters
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	public ArrayList<Juego> getJuegos() {
		return juegos;
	}


	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}


	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}


	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public void insertarEquipo(Equipo team) {
		equipos.add(team);
		
	}

	public Equipo buscarEquiporNombre(String nombre) {
		Equipo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(i<equipos.size() && !encontrado){
			if(equipos.get(i).getNombre().equalsIgnoreCase(nombre)){
				aux = equipos.get(i);
				encontrado = true;
			}i++;

		}
		return aux;
	}

	public void insertarJuego(Juego juego) {
		autoGenCode = FindCodMayor(juegos);
		autoGenCode++;
		juegos.add(juego);
		juego.setJuegoCod(autoGenCode);
	}

	private int FindCodMayor(ArrayList<Juego> juego) {
		int cod = 0;

		for (int i = 0; i < juegos.size(); i++) {
			if(cod < juegos.get(i).getJuegoCod()){
				cod = juegos.get(i).getJuegoCod();
			}

		}

		return cod;
	}
	
	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}
	
	public void eliminarEquipo(Equipo equipo) {
		equipos.remove(equipo);
	}

	public Jugador buscarJugadorByIdentificacion(String identificacion) {
		Jugador aux = null;
		boolean encontrado = false;
		int i = 0;
		while(i<jugadores.size() && !encontrado){
			if(jugadores.get(i).getIdentificacion().equalsIgnoreCase(identificacion)){
				aux = jugadores.get(i);
				encontrado = true;
			}i++;

		}
		return aux;
	}

	public Jugador buscarJugadorNombreEJ(String nombreEquipo, String nombreJugador) {
		Equipo aux = null;
		Jugador player = null;
		boolean encontrado = false;
		int i = 0;

		while(i<equipos.size() && !encontrado){
			if(equipos.get(i).getNombre().equalsIgnoreCase(nombreEquipo)){
				aux = equipos.get(i);
				player = aux.findJugadorByNombre(nombreJugador);
				encontrado = true;
			}i++;

		}
		return player;
	}

	public Juego buscarJuegoPorCodigo(int identificador) {
		Juego aux = null;
		int i = 0;
		boolean encontrado = false;
		while (i<juegos.size() && !encontrado) {
			if(juegos.get(i).getJuegoCod() == identificador){
				aux = juegos.get(i);
				encontrado = true;
			}
			i++;
		}

		return aux;

	}

	public void eliminarJuego(int identificador) {
		int  i = 0;
		boolean encontrado = false;

		while(i<juegos.size() && !encontrado){
			if (juegos.get(i).getJuegoCod()==identificador)	{
				juegos.remove(juegos.get(i));
				encontrado = true;
			}else {
				i++;
			}
		}
	}
	
	
}
