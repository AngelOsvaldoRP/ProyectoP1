package logico;

import java.io.Serializable;

public class Picheo extends Jugador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4017047603544875569L;
	//Variables
	private int cantJG;
	private int cantJP;
	private int cantJJ;
	private int cantJS;
	private int cantCL;
	private int cantTBE;
	private int cantHold;
	private int entradasLanzada;
	private int outConseguidos;
	
	
	
	//Constructor
	public Picheo(String nombre, String apellido, String identificacion, int numeroCamiseta,
			int edad, String estado, String posicion,
			float peso, float altura, String mano) {
		super(nombre, apellido, identificacion, numeroCamiseta, edad, estado,
				posicion, peso, altura, mano);
		this.cantJG = 0;
		this.cantJP = 0;
		this.cantJJ = 0;
		this.cantJS = 0;
		this.cantCL = 0;
		this.cantTBE = 0;
		this.cantHold = 0;
		this.entradasLanzada = 0;
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

	public int getCantJJ() {
		return cantJJ;
	}

	public void setCantJJ(int cantJC) {
		this.cantJJ = cantJC;
	}

	public int getCantJS() {
		return cantJS;
	}

	public void setCantJS(int cantJS) {
		this.cantJS = cantJS;
	}

	public int getCantCL() {
		return cantCL;
	}

	public void setCantCL(int cantCL) {
		this.cantCL = cantCL;
	}

	public int getCantTBE() {
		return cantTBE;
	}

	public void setCantTBE(int cantTBE) {
		this.cantTBE = cantTBE;
	}

	public int getCantHold() {
		return cantHold;
	}

	public void setCantHold(int cantHold) {
		this.cantHold = cantHold;
	}

	public int getEntradasLanzada() {
		return entradasLanzada;
	}

	public void setEntradasLanzada(int entradasLanzada) {
		this.entradasLanzada = entradasLanzada;
	}


	public int getOutConseguidos() {
		return outConseguidos;
	}


	public void setOutConseguidos(int outConseguidos) {
		this.outConseguidos = outConseguidos;
	}


	public float avg() {
		return (float)(Math.round(((float)cantHits/cantTBE) * 1000d) / 1000d);
	}
	
	public float whip() {
		return (float)(Math.round(((float)cantBB/cantHits) * 1000d) / 1000d);
	}
	
	public float ponche9IL() {
		return (float)(Math.round(((float)cantPonches/entradasLanzada) * 1000d) / 1000d);
	}
	
	public float bb9IL() {
		return (float)(Math.round(((float)cantBB/entradasLanzada) * 1000d) / 1000d);
	}

}
