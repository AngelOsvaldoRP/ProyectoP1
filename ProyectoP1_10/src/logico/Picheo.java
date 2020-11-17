package logico;

public class Picheo extends Jugador {
	//Variables
	private int cantJG;
	private int cantJP;
	private int cantJC;
	private int cantJS;
	private int cantAperturas;
	private int cantCL;
	private int cantCP;
	private int cantTBE;
	private int cantNL;
	private int cantHold;
	private int outConseguidos;
	
	
	
	//Constructor
	public Picheo(String nombre, String apellido, String identificacion, String tipoIdentificacion, int numeroCamiseta,
			String equipoActual, String estado, String equipos, String posicion, int cantTemporadas,
			float peso, float altura, String mano) {
		super(nombre, apellido, identificacion, tipoIdentificacion, numeroCamiseta, equipoActual, estado, equipos,
				posicion, cantTemporadas, peso, altura, mano);
		this.cantJG = 0;
		this.cantJP = 0;
		this.cantJC = 0;
		this.cantJS = 0;
		this.cantAperturas = 0;
		this.cantCL = 0;
		this.cantCP = 0;
		this.cantTBE = 0;
		this.cantNL = 0;
		this.cantHold = 0;
		this.outConseguidos = 0;
	}
	
	
	//Getters and Setters
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

	public int getCantJC() {
		return cantJC;
	}

	public void setCantJC(int cantJC) {
		this.cantJC = cantJC;
	}

	public int getCantJS() {
		return cantJS;
	}

	public void setCantJS(int cantJS) {
		this.cantJS = cantJS;
	}

	public int getCantAperturas() {
		return cantAperturas;
	}

	public void setCantAperturas(int cantAperturas) {
		this.cantAperturas = cantAperturas;
	}

	public int getCantCL() {
		return cantCL;
	}

	public void setCantCL(int cantCL) {
		this.cantCL = cantCL;
	}

	public int getCantCP() {
		return cantCP;
	}

	public void setCantCP(int cantCP) {
		this.cantCP = cantCP;
	}

	public int getCantTBE() {
		return cantTBE;
	}

	public void setCantTBE(int cantTBE) {
		this.cantTBE = cantTBE;
	}

	public int getCantNL() {
		return cantNL;
	}

	public void setCantNL(int cantNL) {
		this.cantNL = cantNL;
	}

	public int getCantHold() {
		return cantHold;
	}

	public void setCantHold(int cantHold) {
		this.cantHold = cantHold;
	}

	public int getOutConseguidos() {
		return outConseguidos;
	}

	public void setOutConseguidos(int outConseguidos) {
		this.outConseguidos = outConseguidos;
	}


	public float avg() {
		return (float)cantHits/cantTBE;
	}

}
