package logico;
//Import library
import java.util.ArrayList;

public class Jugador extends Personal {
	//Variables
	private int numeroCamiseta;
	private String equipoActual;
	private String estado;
	private ArrayList<Equipo> equipos;
	private ArrayList<Performance> misPerformance;
	private Performance performancePorVida;
	private String posicion;
	private int cantTemporadas;
	
	//Constructor
	public Jugador(String nombre, String apellido, String identificacion, String tipoIdentificacion, int numeroCamiseta,
			String equipoActual, String estado, ArrayList<Equipo> equipos, ArrayList<Performance> misPerformance,
			Performance performancePorVida, String posicion, int cantTemporadas) {
		super(nombre, apellido, identificacion, tipoIdentificacion);
		this.numeroCamiseta = numeroCamiseta;
		this.equipoActual = equipoActual;
		this.estado = estado;
		this.equipos = equipos;
		this.misPerformance = misPerformance;
		this.performancePorVida = performancePorVida;
		this.posicion = posicion;
		this.cantTemporadas = cantTemporadas;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public ArrayList<Performance> getMisPerformance() {
		return misPerformance;
	}

	public void setMisPerformance(ArrayList<Performance> misPerformance) {
		this.misPerformance = misPerformance;
	}

	public Performance getPerformancePorVida() {
		return performancePorVida;
	}

	public void setPerformancePorVida(Performance performancePorVida) {
		this.performancePorVida = performancePorVida;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getCantTemporadas() {
		return cantTemporadas;
	}

	public void setCantTemporadas(int cantTemporadas) {
		this.cantTemporadas = cantTemporadas;
	}

}
