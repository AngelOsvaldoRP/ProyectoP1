package logico;
//Import library
import java.util.ArrayList;

public class Fase {
	
	//Variables
	private String tipoFase;
	private int cantJuegos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Juego> juegos;
	
	
	//Constructor
	public Fase(String tipoFase, int cantJuegos) {
		super();
		this.tipoFase = tipoFase;
		this.cantJuegos = cantJuegos;
		this.equipos = new ArrayList<>();
		this.juegos = new ArrayList<>();
	}
	
	//Getters and Setters
	public String getTipoFase() {
		return tipoFase;
	}
	public void setTipoFase(String tipoFase) {
		this.tipoFase = tipoFase;
	}
	public int getCantJuegos() {
		return cantJuegos;
	}
	public void setCantJuegos(int cantJuegos) {
		this.cantJuegos = cantJuegos;
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
	
	
	
}
