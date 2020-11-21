package logico;

//Import library
import java.sql.Date;


public class Juego {
	//Variables
	private int juegoCod;
	private String estado;
	private Date fecha;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private String estadio;
	private String equipoganador;
	private String equipoPerdedor;
	private int carrerasVisitante;
	private int hitsVisitante;
	private int erroresVisitante;
	private int carrerasLocal;
	private int hitsLocal;
	private int erroresLocal;
	
	//Constructor
	
	public Juego(int juegoCod, String estado, Date fecha, Equipo equipoLocal, Equipo equipoVisitante,
			String estadio) {
		super();
		this.juegoCod = juegoCod;
		this.estado = estado;
		this.fecha = fecha;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.estadio = estadio;
		this.equipoganador = "";
		this.equipoPerdedor = "";
		this.carrerasVisitante = 0;
		this.hitsVisitante = 0;
		this.erroresVisitante = 0;
		this.carrerasLocal = 0;
		this.hitsLocal = 0;
		this.erroresLocal = 0;
	}
	
	public int getJuegoCod() {
		return juegoCod;
	}
	
	public void setJuegoCod(int juegoCod) {
		this.juegoCod = juegoCod;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fechai) {
		this.fecha = fechai;
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getEquipoganador() {
		return equipoganador;
	}
	public void setEquipoganador(String equipoganador) {
		this.equipoganador = equipoganador;
	}
	public String getEquipoPerdedor() {
		return equipoPerdedor;
	}
	public void setEquipoPerdedor(String equipoPerdedor) {
		this.equipoPerdedor = equipoPerdedor;
	}
	public int getCarrerasVisitante() {
		return carrerasVisitante;
	}
	public void setCarrerasVisitante(int carrerasVisitante) {
		this.carrerasVisitante = carrerasVisitante;
	}
	public int getHitsVisitante() {
		return hitsVisitante;
	}
	public void setHitsVisitante(int hitsVisitante) {
		this.hitsVisitante = hitsVisitante;
	}
	public int getErroresVisitante() {
		return erroresVisitante;
	}
	public void setErroresVisitante(int erroresVisitante) {
		this.erroresVisitante = erroresVisitante;
	}
	public int getCarrerasLocal() {
		return carrerasLocal;
	}
	public void setCarrerasLocal(int carrerasLocal) {
		this.carrerasLocal = carrerasLocal;
	}
	public int getHitsLocal() {
		return hitsLocal;
	}
	public void setHitsLocal(int hitsLocal) {
		this.hitsLocal = hitsLocal;
	}
	public int getErroresLocal() {
		return erroresLocal;
	}
	public void setErroresLocal(int erroresLocal) {
		this.erroresLocal = erroresLocal;
	}
	
	
}