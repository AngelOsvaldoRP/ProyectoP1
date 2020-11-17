package logico;

//Import library
import java.util.ArrayList;



public class Liga {
	//Variables
	private ArrayList<Torneo> torneos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> jugadores;
	private ArrayList<Personal> managers;
	private ArrayList<Personal> lesionados;

	
	//Constructor
	public Liga(ArrayList<Torneo> torneos, ArrayList<Equipo> equipos, ArrayList<Personal> jugadores,
			ArrayList<Personal> managers, ArrayList<Personal> lesionados) {
		super();
		this.torneos = torneos;
		this.equipos = equipos;
		this.jugadores = jugadores;
		this.managers = managers;
		this.lesionados = lesionados;
	}

	
	//Getters and setters
	public ArrayList<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(ArrayList<Torneo> torneos) {
		this.torneos = torneos;
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


	public ArrayList<Personal> getLesionados() {
		return lesionados;
	}


	public void setLesionados(ArrayList<Personal> lesionados) {
		this.lesionados = lesionados;
	}
	
}
