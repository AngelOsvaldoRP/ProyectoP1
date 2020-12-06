package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bateo;
import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ListTopPlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTable table_1;
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo2;
	private static final long serialVersionUID = 1L;
	public static Object[] filas;
	/**
	 * Launch the application.
	 */
	private static ArrayList<Jugador> jgp;
	private static ArrayList<Jugador> jgb;

	/**
	 * Create the dialog.
	 */
	public ListTopPlayer() {
		setTitle("Jugadores top");
		setBounds(100, 100, 795, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Bateadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 65, 337, 208);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		modelo2 = new DefaultTableModel();
		String[] headers2 = {"No.", "Equipo", "Nombre", "Apellido", "AVG"};
		modelo2.setColumnIdentifiers(headers2);
		table.setModel(modelo2);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pitchers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(409, 65, 337, 208);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		modelo = new DefaultTableModel();
		String[] headers = {"No.", "Equipo", "Nombre", "Apellido","AVG" };
		modelo.setColumnIdentifiers(headers);
		table_1.setModel(modelo);
		
		JLabel lblNewLabel = new JLabel("Jugadores Top de la temporada ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(21, 11, 725, 43);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenarTabla();
		llenarTabla2();
	}
	
	
	public static void llenarTabla() {
		try {
		jgb = new ArrayList<>();
		ArrayList<Jugador> jgb10= new ArrayList<>(10);
		for(Jugador jugador : Torneo.getInstance().getJugadores() ) {
			if(jugador instanceof Bateo) {
				jgb.add(jugador);
			}
		}
		filas = new Object[modelo.getColumnCount()];
		//Ordenando
		Collections.sort(jgb, new Comparator<Jugador>() {
			public int compare(Jugador p1, Jugador p2) {
					return new Integer(Float.compare(p1.avg(), p2.avg()));
			}
		});
		Collections.reverse(jgb);
		//Imprimiendo
		for (int i = 0; i < 10 && i <jgb.size(); i++) {
			jgb10.add(jgb.get(i));
	}
		int posicion = 1;
		modelo2.setRowCount(0);
		
			for (Jugador jugador : jgb10) {
				if(jugador instanceof Bateo) {
				filas[0] = posicion;
				filas[1] = jugador.getEquipoActual();
				filas[2] = jugador.getNombre();
				filas[3] = jugador.getApellido();
				filas[4] = jugador.avg();
				modelo2.addRow(filas);
				posicion++;
				}
			}
		} catch (Exception e) {
			System.out.println("No hay jugadores ahora mismo: "+ e);
		}
	}
	
	
	public static void llenarTabla2() {
		try {
		jgp = new ArrayList<>();
		ArrayList<Jugador> jgp10= new ArrayList<>(10);
		for(Jugador jugador : Torneo.getInstance().getJugadores() ) {
			if(jugador instanceof Picheo) {
				jgp.add(jugador);
			}
		}

		filas = new Object[modelo.getColumnCount()];
		//Ordenando
		Collections.sort(jgp, new Comparator<Jugador>() {
			public int compare(Jugador p1, Jugador p2) {
					return new Integer(Float.compare(p1.avg(), p2.avg()));
			}
		});
		Collections.reverse(jgp);
		
		for (int i = 0; i < 10 && i <jgp.size(); i++) {
				jgp10.add(jgp.get(i));
		}
			
		//Imprimiendo
		int posicion = 1;
		modelo.setRowCount(0);
		
			for (Jugador jugador : jgp10) {
				if(jugador instanceof Picheo) {
				filas[0] = posicion;
				filas[1] = jugador.getEquipoActual();
				filas[2] = jugador.getNombre();
				filas[3] = jugador.getApellido();
				filas[4] = jugador.avg();
				modelo.addRow(filas);
				posicion++;
				}
			}
		} catch (Exception e) {
			System.out.println("No hay jugadores ahora mismo: "+ e);
		}
	}
}
