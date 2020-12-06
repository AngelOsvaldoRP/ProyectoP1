package logico;

//Import library
import java.util.ArrayList;

public class Torneo {
	//Variables
	private ArrayList<Juego> juegos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Lesion> lesiones;
	private static Torneo torneo = null;
	private int autoJuegoCode;
	
	
	
	//Constructor
	private Torneo() {
		super();
		this.juegos =new ArrayList<Juego>();
		this.equipos = new ArrayList<Equipo>();
		this.jugadores = new ArrayList<Jugador>();
		this.lesiones  = new ArrayList<Lesion>();
		this.setAutoJuegoCode(1);
		
	}
	 
	public static Torneo getInstance() {
		if(torneo==null) {
			torneo = new Torneo();
		}
		return torneo;
	}
	
	public ArrayList<Lesion> getLesiones() {
		return lesiones;
	}

	public void setLesiones(ArrayList<Lesion> lesiones) {
		this.lesiones = lesiones;
	}

	public static Torneo getTorneo() {
		return torneo;
	}

	public static void setTorneo(Torneo torneo) {
		Torneo.torneo = torneo;
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

	public int getAutoJuegoCode() {
		return autoJuegoCode;
	}

	public void setAutoJuegoCode(int autoJuegoCode) {
		this.autoJuegoCode = autoJuegoCode;
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
		autoJuegoCode++;
		juegos.add(juego);
	}
	
	public void eliminarJugador(Jugador jugador) {
		jugadores.remove(jugador);
	}
	
	public void insertarLesion(Lesion lesion) {
		lesiones.add(lesion);
	}
	
	public void eliminarLesion(Lesion lesion) {
		lesiones.remove(lesion);
	}
	
	public void insertarJugador(Jugador jugador) {
		jugadores.add(jugador);
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

	public Juego buscarJuegoPorCodigo(String identificador) {
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

	public void eliminarJuego(String identificador) {
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
