package logico;
//Import library

public abstract class Jugador {
	
	//Variables
	protected String nombre;
	protected String apellido;
	protected String identificacion;
	protected int numeroCamiseta;
	protected int edad;
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
	public Jugador(String nombre, String apellido, String identificacion, int numeroCamiset, int edad,
			String estado, String posicion, float peso, float altura,
			String mano) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.numeroCamiseta = numeroCamiset;
		this.edad =edad;
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
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	

	public int getCantHits() {
		return cantHits;
	}


	public void setCantHits(int cantHits) {
		this.cantHits = cantHits;
	}


	public int getCantJuegos() {
		return cantJuegos;
	}


	public void setCantJuegos(int cantJuegos) {
		this.cantJuegos = cantJuegos;
	}


	public int getCantHR() {
		return cantHR;
	}


	public void setCantHR(int cantHR) {
		this.cantHR = cantHR;
		cantHits++;
	}


	public int getCantBB() {
		return cantBB;
	}


	public void setCantBB(int cantBB) {
		this.cantBB = cantBB;
	}


	public int getCantPonches() {
		return cantPonches;
	}


	public void setCantPonches(int cantPonches) {
		this.cantPonches = cantPonches;
	}


	public int getHbp() {
		return hbp;
	}


	public void setHbp(int hbp) {
		this.hbp = hbp;
	}
	public abstract float avg();


}
