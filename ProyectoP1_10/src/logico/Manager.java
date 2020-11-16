package logico;

//Import library
import java.util.ArrayList;

public class Manager extends Personal {
	//Variables
	private int numeroCamiseta;
	private String equipoActual;
	private ArrayList<Equipo> equipos;
	private int cantTemporadas;
	private ArrayList<PerformanceManager> misPM;
	
	
	//Constructor
	public Manager(String nombre, String apellido, String identificacion, String tipoIdentificacion, int numeroCamiseta,
			String equipoActual, ArrayList<Equipo> equipos, int cantTemporadas, ArrayList<PerformanceManager> misPM) {
		super(nombre, apellido, identificacion, tipoIdentificacion);
		this.numeroCamiseta = numeroCamiseta;
		this.equipoActual = equipoActual;
		this.equipos = equipos;
		this.cantTemporadas = cantTemporadas;
		this.misPM = misPM;
	}
	
	//Getters and Setters
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	public String getEquipoActual() {
		return equipoActual;
	}

	public void setEquipoActual(String equipoActual) {
		this.equipoActual = equipoActual;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public int getCantTemporadas() {
		return cantTemporadas;
	}

	public void setCantTemporadas(int cantTemporadas) {
		this.cantTemporadas = cantTemporadas;
	}

	public ArrayList<PerformanceManager> getMisPM() {
		return misPM;
	}

	public void setMisPM(ArrayList<PerformanceManager> misPM) {
		this.misPM = misPM;
	}
}
