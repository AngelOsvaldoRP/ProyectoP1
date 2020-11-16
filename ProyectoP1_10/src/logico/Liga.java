package logico;

//Import library
import java.util.ArrayList;



public class Liga {
	//Variables
	private ArrayList<Torneo> torneos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> personales;

	
	
	//Constructor 
	public Liga() {
		super();
		this.torneos = new ArrayList<>();
		this.equipos = new ArrayList<>();
		this.personales = new ArrayList<>();
		
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

	public ArrayList<Personal> getPersonales() {
		return personales;
	}

	public void setPersonales(ArrayList<Personal> personales) {
		this.personales = personales;
	}
	
}
