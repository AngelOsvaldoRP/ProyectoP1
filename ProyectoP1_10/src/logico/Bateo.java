package logico;

public class Bateo extends Performance {

	private int cantHits;
	private int cantJuegos;
	private int cantHR;
	private int cantBB;
	private int cantPonches;
	private int HBP;
	private int cantTB;
	private int cantVP;
	private int cantCA;
	private int cant2B;
	private int cant3B;
	private int cantCI;
	private int cantBR;
	private int ES;
	
	public Bateo(String torneo, String fase, int cantHits, int cantJuegos, int cantHR, int cantBB, int cantPonches,
			int hBP, int cantTB, int cantVP, int cantCA, int cant2b, int cant3b, int cantCI, int cantBR, int eS) {
		super(torneo, fase);
		this.cantHits = cantHits;
		this.cantJuegos = cantJuegos;
		this.cantHR = cantHR;
		this.cantBB = cantBB;
		this.cantPonches = cantPonches;
		HBP = hBP;
		this.cantTB = cantTB;
		this.cantVP = cantVP;
		this.cantCA = cantCA;
		cant2B = cant2b;
		cant3B = cant3b;
		this.cantCI = cantCI;
		this.cantBR = cantBR;
		ES = eS;
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

	public int getHBP() {
		return HBP;
	}

	public void setHBP(int hBP) {
		HBP = hBP;
	}

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
		return cant2B;
	}

	public void setCant2B(int cant2b) {
		cant2B = cant2b;
	}

	public int getCant3B() {
		return cant3B;
	}

	public void setCant3B(int cant3b) {
		cant3B = cant3b;
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
		return ES;
	}

	public void setES(int eS) {
		ES = eS;
	}



	public float avg() {
		return (float)cantHits/cantTB;
	}

}
