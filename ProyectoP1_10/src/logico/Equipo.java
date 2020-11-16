package logico;
//Import libraire - Init
import java.util.ArrayList;
//Import libraire - End

public class Equipo {
	//Variables - Init
	private String nombre;
	private String estadio;
	private int cantTitulos;
	private int cantJJ;
	private ArrayList<Personal> personales;
	private ArrayList<Performance> misPerformance;
	//Variables - End
	public Equipo(String nombre, String estadio, int cantTitulos, int cantJJ) {
		super();
		this.nombre = nombre;
		this.estadio = estadio;
		this.cantTitulos = cantTitulos;
		this.cantJJ = cantJJ;
		this.personales = new ArrayList<>();
		this.misPerformance = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public ArrayList<Personal> getPersonales() {
		return personales;
	}
	public void setPersonales(ArrayList<Personal> personales) {
		this.personales = personales;
	}
	public ArrayList<Performance> getMisPerformance() {
		return misPerformance;
	}
	public void setMisPerformance(ArrayList<Performance> misPerformance) {
		this.misPerformance = misPerformance;
	}
		
}
