package logico;
//Import library

public abstract class Jugador {
	
	//Variables
	protected String nombre;
	protected String apellido;
	protected String identificacion;
	protected int numeroCamiseta;
	protected String equipoActual;
	protected String estado;
	protected String posicion;
	protected float peso;
	protected float altura;
	protected String mano;
	
	//EstadisticasGenerales
	protected int cantHits;
	protected int cantJuegos;
	protected int cantHR;
	protected int cantBB;
	protected int cantPonches;
	protected int hbp;
	

	//Constructor
	public Jugador(String nombre, String apellido, String identificacion, int numeroCamiset,
			String equipoActual, String estado, String posicion, float peso, float altura,
			String mano) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.numeroCamiseta = numeroCamiset;
		this.equipoActual = equipoActual;
		this.estado = estado;
		this.posicion = posicion;
		this.peso = peso;
		this.altura = altura;
		this.mano = mano;
		this.cantHits = 0;
		this.cantJuegos = 0;
		this.cantHR = 0;
		this.cantBB = 0;
		this.cantPonches = 0;
		this.hbp = 0;
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

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getMano() {
		return mano;
	}

	public void setMano(String mano) {
		this.mano = mano;
	}
	
	public abstract float avg();

}
