package logico;

//Import library
import java.util.ArrayList;

public class Torneo {
	//Variables
	private String year;
	private String nombre;
	private ArrayList<Fase> fases;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> personales;

	
	
	//Constructor
	public Torneo(String year, String nombre) {
		super();
		this.year = year;
		this.nombre = nombre;
		this.fases = new ArrayList<>();
		this.equipos = new ArrayList<>();
		this.personales = new ArrayList<>();
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
	public ArrayList<Personal> getPersonales() {
		return personales;
	}
	public void setPersonales(ArrayList<Personal> personales) {
		this.personales = personales;
	}
	
	
	
}
