package logico;

//Import library
import java.util.ArrayList;

public class Torneo {
	//Variables
	private String year;
	private String nombre;
	private ArrayList<Fase> fases;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> jugadores;
	private ArrayList<Personal> managers;

	
	//Constructor
	public Torneo(String year, String nombre, ArrayList<Fase> fases, ArrayList<Equipo> equipos,
			ArrayList<Personal> jugadores, ArrayList<Personal> managers) {
		super();
		this.year = year;
		this.nombre = nombre;
		this.fases = fases;
		this.equipos = equipos;
		this.jugadores = jugadores;
		this.managers = managers;
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
	public ArrayList<Fase> getFases() {
		return fases;
	}
	public void setFases(ArrayList<Fase> fases) {
		this.fases = fases;
	}
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public ArrayList<Personal> getJugadores() {
		return jugadores;
	}


	public void setJugadores(ArrayList<Personal> jugadores) {
		this.jugadores = jugadores;
	}


	public ArrayList<Personal> getManagers() {
		return managers;
	}


	public void setManagers(ArrayList<Personal> managers) {
		this.managers = managers;
	}
	
	
	
}
