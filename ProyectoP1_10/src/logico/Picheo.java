package logico;

public class Picheo extends Performance {
	//Variables
	private int cantHits;
	private int cantJuegos;
	private int cantHR;
	private int cantBB;
	private int cantPonches;
	private int HBP;
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
	public Picheo(String torneo, String fase, int cantHits, int cantJuegos, int cantHR, int cantBB, int cantPonches,
			int hBP, int cantJG, int cantJP, int cantJC, int cantJS, int cantAperturas, int cantCL, int cantCP,
			int cantTBE, int cantNL, int cantHold, int outConseguidos) {
		super(torneo, fase);
		this.cantHits = cantHits;
		this.cantJuegos = cantJuegos;
		this.cantHR = cantHR;
		this.cantBB = cantBB;
		this.cantPonches = cantPonches;
		HBP = hBP;
		this.cantJG = cantJG;
		this.cantJP = cantJP;
		this.cantJC = cantJC;
		this.cantJS = cantJS;
		this.cantAperturas = cantAperturas;
		this.cantCL = cantCL;
		this.cantCP = cantCP;
		this.cantTBE = cantTBE;
		this.cantNL = cantNL;
		this.cantHold = cantHold;
		this.outConseguidos = outConseguidos;
	}
	
	
	//Getters and Setters
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
