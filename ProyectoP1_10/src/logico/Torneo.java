package logico;

//Import library
import java.util.ArrayList;

public class Torneo {
	//Variables
	private String year;
	private String nombre;
	private ArrayList<Juego> juegos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Jugador> jugadores;

	
	//Constructor
	public Torneo(String year, String nombre) {
		super();
		this.year = year;
		this.nombre = nombre;
		this.juegos =new ArrayList<Juego>();
		this.equipos = new ArrayList<Equipo>();
		this.jugadores = new ArrayList<Jugador>();
	}


	//Getters and Setters
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
	
	
	
}
