package logico;

//Import libraire - Init
import java.util.ArrayList;
//Import libraire - End

public class Torneo {
	//Variables - Init
	private String year;
	private String nombre;
	private ArrayList<Fase> fases;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> personales;
	//Variables - End
	public Torneo(String year, String nombre) {
		super();
		this.year = year;
		this.nombre = nombre;
		this.fases = new ArrayList<>();
		this.equipos = new ArrayList<>();
		this.personales = new ArrayList<>();
	}
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
