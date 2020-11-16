package logico;

public abstract class Performance {
	//Variables
	protected String torneo;
	protected String fase;
	
	
	//Constructor
	public Performance(String torneo, String fase) {
		super();
		this.torneo = torneo;
		this.fase = fase;
	}
	//Getters and Setters
	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}
	
	public abstract float avg();

}
