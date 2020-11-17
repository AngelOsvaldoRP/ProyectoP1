package logico;
//Import library
import java.util.ArrayList;


public class Equipo {
	//Variables
	private String nombre;
	private String yearFundation;
	private String manager;
	private String estadio;
	private int cantTitulos;
	private int cantJJ;
	private int cantJG;
	private int cantJP;
	private ArrayList<Jugador> jugador;
	private ArrayList<Lesion> lesiones;
	
	//Constructor
	public Equipo(String nombre, String yearFundation, String manager, String estadio, int cantTitulos, int cantJJ,
			int cantJG, int cantJP, ArrayList<Jugador> jugador, ArrayList<Lesion> lesiones) {
		super();
		this.nombre = nombre;
		this.yearFundation = yearFundation;
		this.manager = manager;
		this.estadio = estadio;
		this.cantTitulos = cantTitulos;
		this.cantJJ = cantJJ;
		this.cantJG = cantJG;
		this.cantJP = cantJP;
		this.jugador = jugador;
		this.lesiones = lesiones;
	}
	
	//Getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getYearFundation() {
		return yearFundation;
	}

	public void setYearFundation(String yearFundation) {
		this.yearFundation = yearFundation;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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

	public ArrayList<Jugador> getJugador() {
		return jugador;
	}

	public void setJugador(ArrayList<Jugador> jugador) {
		this.jugador = jugador;
	}

	public ArrayList<Lesion> getLesiones() {
		return lesiones;
	}

	public void setLesiones(ArrayList<Lesion> lesiones) {
		this.lesiones = lesiones;
	}
	
	
}
