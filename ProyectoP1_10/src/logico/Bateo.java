package logico;

public class Bateo extends Jugador {
	//Variables
	private int cantTB;
	private int cantVP;
	private int cantCA;
	private int cant2b;
	private int cant3b;
	private int cantCI;
	private int cantBR;
	private int es;
	
	//Constructor
	public Bateo(String nombre, String apellido, String identificacion, int numeroCamiseta,
			String equipoActual, String estado, String posicion,
			float peso, float altura, String mano) {
		super(nombre, apellido, identificacion, numeroCamiseta, equipoActual, estado,
				posicion, peso, altura, mano);
		this.cantTB = 0;
		this.cantVP = 0;
		this.cantCA = 0;
		this.cant2b = 0;
		this.cant3b = 0;
		this.cantCI = 0;
		this.cantBR = 0;
		this.es = 0;
	}
	
	//Getters and Setters
	public int getCantTB() {
		return cantTB;
	}

	public void setCantTB(int cantTB) {
		this.cantTB = cantTB;
	}

	public int getCantVP() {
		return cantVP;
	}

	public void setCantVP(int cantVP) {
		this.cantVP = cantVP;
	}

	public int getCantCA() {
		return cantCA;
	}

	public void setCantCA(int cantCA) {
		this.cantCA = cantCA;
	}

	public int getCant2B() {
		return cant2b;
	}

	public void setCant2B(int cant2b) {
		this.cant2b = cant2b;
	}

	public int getCant3B() {
		return cant3b;
	}

	public void setCant3B(int cant3b) {
		this.cant3b = cant3b;
	}

	public int getCantCI() {
		return cantCI;
	}

	public void setCantCI(int cantCI) {
		this.cantCI = cantCI;
	}

	public int getCantBR() {
		return cantBR;
	}

	public void setCantBR(int cantBR) {
		this.cantBR = cantBR;
	}

	public int getES() {
		return es;
	}

	public void setES(int eS) {
		this.es = eS;
	}



	public float avg() {
		return (float)cantHits/cantTB;
	}

}
