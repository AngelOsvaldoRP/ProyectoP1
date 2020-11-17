package logico;
//Import library

public class Lesion {
	//Variables
	private String lesionCod;
	private String tipo;
	private String Descripcion;
	private Jugador jugador;
	private String estado;
	private int cantDias;
	
	//Constructor
	public Lesion(String lesionCod, String tipo, String descripcion, Jugador jugador, String estado, int cantDias) {
		super();
		this.lesionCod = lesionCod;
		this.tipo = tipo;
		Descripcion = descripcion;
		this.jugador = jugador;
		this.estado = estado;
		this.cantDias = cantDias;
	}

	//Getters and setters
	
	public String getLesionCod() {
		return lesionCod;
	}

	public void setLesionCod(String lesionCod) {
		this.lesionCod = lesionCod;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
}
