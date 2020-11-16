package logico;

public class PerformanceManager {

	private int cantVictorias;
	private int cantDerrotas;
	private String torneo;
	private String fase;
	
	public PerformanceManager(int cantVictorias, int cantDerrotas, String torneo, String fase) {
		super();
		this.cantVictorias = cantVictorias;
		this.cantDerrotas = cantDerrotas;
		this.torneo = torneo;
		this.fase = fase;
	}

	public int getCantVictorias() {
		return cantVictorias;
	}

	public void setCantVictorias(int cantVictorias) {
		this.cantVictorias = cantVictorias;
	}

	public int getCantDerrotas() {
		return cantDerrotas;
	}

	public void setCantDerrotas(int cantDerrotas) {
		this.cantDerrotas = cantDerrotas;
	}

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
}
