package logico;

public class Bateo extends Jugador {
	//Variables
	private int cantTB;
	private int cantCA;
	private int cant2b;
	private int cant3b;
	private int cantCI;
	private int cantBR;
	private int es;
	
	//Constructor
	public Bateo(String nombre, String apellido, String identificacion, int numeroCamiseta,
			int edad, String estado, String posicion,
			float peso, float altura, String mano) {
		super(nombre, apellido, identificacion, numeroCamiseta, edad, estado,
				posicion, peso, altura, mano);
		this.cantTB = 0;
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
		cantHits++;
	}

	public int getCant3B() {
		return cant3b;
	}

	public void setCant3B(int cant3b) {
		this.cant3b = cant3b;
		cantHits++;
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
		return (float)(Math.round(((float)cantHits/cantTB) * 1000d) / 1000d);
		
	}
	
	public float obp() {
		return (float)(Math.round(((float)(cantHits+cantBB+hbp)/(cantHits+cantBB+hbp+es)) * 1000d) / 1000d);	
	}
	
	public float slg() {
		return (float)(Math.round(((float)(cantHits+(cant2b*2)+(cant3b*3)+(cantHR*4))/cantTB) * 1000d) / 1000d);	
	}
	
	public float ops() {
		return (float)(Math.round((float)(obp()/slg()) * 1000d) / 1000d);
	}
	
	public int xbh() {
		return cant2b+cant3b+cantHR;
	}

}
