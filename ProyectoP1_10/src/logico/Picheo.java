package logico;

public class Picheo extends Performance {
	//Variables
	private int cantHits;
	private int cantJuegos;
	private int cantHR;
	private int cantBB;
	private int cantPonches;
	private int hbp;
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
	public Picheo(String torneo, String fase) {
		super(torneo, fase);
		this.cantHits = 0;
		this.cantJuegos = 0;
		this.cantHR = 0;
		this.cantBB = 0;
		this.cantPonches = 0;
		this.hbp = 0;
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
		return hbp;
	}

	public void setHBP(int hBP) {
		this.hbp = hBP;
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
