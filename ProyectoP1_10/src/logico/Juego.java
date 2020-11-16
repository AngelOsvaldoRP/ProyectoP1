package logico;

//Import libraire - Init
import java.sql.Date;
import java.util.ArrayList;
//Import libraire - End

public class Juego {
	//Variables - Init
	private Date fechai;
	private Date fechaf;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> personales;
	private int cantCarreras;
	private int cantHits;
	private int cantErrores;
	//Variables - End
	public Juego(Date fechai, Date fechaf, int cantCarreras,
			int cantHits, int cantErrores) {
		super();
		this.fechai = fechai;
		this.fechaf = fechaf;
		this.equipos = new ArrayList<>();
		this.personales = new ArrayList<>();
		this.cantCarreras = cantCarreras;
		this.cantHits = cantHits;
		this.cantErrores = cantErrores;
	}
	public Date getFechai() {
		return fechai;
	}
	public void setFechai(Date fechai) {
		this.fechai = fechai;
	}
	public Date getFechaf() {
		return fechaf;
	}
	public void setFechaf(Date fechaf) {
		this.fechaf = fechaf;
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
	public int getCantCarreras() {
		return cantCarreras;
	}
	public void setCantCarreras(int cantCarreras) {
		this.cantCarreras = cantCarreras;
	}
	public int getCantHits() {
		return cantHits;
	}
	public void setCantHits(int cantHits) {
		this.cantHits = cantHits;
	}
	public int getCantErrores() {
		return cantErrores;
	}
	public void setCantErrores(int cantErrores) {
		this.cantErrores = cantErrores;
	}
	
	
}
