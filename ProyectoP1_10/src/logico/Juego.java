package logico;

public class Juego {
	//Variables
	private String juegoCod;
	private String estado;
	private String fecha;
	private String hora;
	private String equipoLocal;
	private String equipoVisitante;
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
	
	public Juego(String juegoCod, String estado, String fecha, String hora, String equipoLocal, String equipoVisitante,
			String estadio) {
		super();
		this.juegoCod = juegoCod;
		this.estado = estado;
		this.fecha = fecha;
		this.hora = hora;
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
	
	public String getJuegoCod() {
		return juegoCod;
	}
	
	public void setJuegoCod(String juegoCod) {
		this.juegoCod = juegoCod;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String equipoVisitante) {
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