package logico;

//Import libraire - Init
import java.util.ArrayList;
//Import libraire - End

public class Liga {
	//Variables - Init
	private ArrayList<Torneo> torneos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Personal> personales;
	//Variables - End
	
	public Liga() {
		super();
		this.torneos = new ArrayList<>();
		this.equipos = new ArrayList<>();
		this.personales = new ArrayList<>();
		
	}

	public ArrayList<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(ArrayList<Torneo> torneos) {
		this.torneos = torneos;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public ArrayList<Personal> getPersonales() {
		return personales;
	}

	public void setPersonales(ArrayList<Personal> personales) {
		this.personales = personales;
	}
	
}
