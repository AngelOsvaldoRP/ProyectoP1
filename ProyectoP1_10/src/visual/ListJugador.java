package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bateo;
import logico.Equipo;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;
import javax.swing.UIManager;
import java.awt.Color;

public class ListJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	public static DefaultTableModel modelo2;
	public static Object[] filas2;
	private JButton btnModificar;
	private JButton btnEliminar;
	public Jugador aux = null;
	public static Equipo equipo = null;
	private JButton btnVerJugadores;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 *
	 */
	public ListJugador(Equipo equipo) {
		this.equipo = equipo;
		setTitle("Jugadores de "+equipo.getNombre());
		setModal(true);
		setBounds(100, 100, 1178, 536);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 21, 1142, 206);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bateadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"No.", "Nombre/Apellido", "Posicion", "AVG", "H", "HR", "BB", "OBP"};
					modelo.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1) {
								btnEliminar.setEnabled(true);
								btnVerJugadores.setEnabled(true);
								aux = equipo.buscarJugadorByNumero(((Integer)modelo.getValueAt(seleccion, 0)));
							}
						}
					});
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel panel2 = new JPanel();
			panel2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel2.setBounds(10, 238, 1142, 206);
			contentPanel.add(panel2);
			panel2.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel2.add(scrollPane);
				{
					modelo2 = new DefaultTableModel();
					String[] headers = {"No.", "Nombre/Apellido", "JG", "JP", "WHIP", "K", "BB", "IL"};
					modelo2.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1) {
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								btnVerJugadores.setEnabled(true);
								aux = equipo.buscarJugadorByNumero((Integer)modelo.getValueAt(seleccion, 0));
								Torneo.nombreJ= (String)modelo.getValueAt(seleccion, 1);
							}
						}
					});
					table.setModel(modelo2);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar Jugador");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				{
					btnVerJugadores = new JButton("Ver Jugador");
					btnVerJugadores.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(aux instanceof Bateo) {
								EstadisticasJugadorBateo vista = new EstadisticasJugadorBateo(aux);
								vista.setModal(true);
								vista.setLocationRelativeTo(null);
								vista.setVisible(true);
							}
							if(aux instanceof Picheo) {
								EstadisticasJugadorPicheo vista = new EstadisticasJugadorPicheo(aux);
								vista.setModal(true);
								vista.setLocationRelativeTo(null);
								vista.setVisible(true);
							}
						}
					});
					btnVerJugadores.setEnabled(false);
					btnVerJugadores.setActionCommand("OK");
					buttonPane.add(btnVerJugadores);
				}
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al jugador: "+aux.getNombre(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								Torneo.getInstance().eliminarJugador(aux);
								equipo.eliminarJugador(aux);
								llenarTabla();
								llenarTabla2();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								btnVerJugadores.setEnabled(true);
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		llenarTabla();
		llenarTabla2();
	}

	public static void llenarTabla() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for (Jugador jugador : equipo.getJugadores()) {
			filas[0] = jugador.getNumeroCamiseta();
			filas[1] = jugador.getApellido()+","+jugador.getNombre();
			filas[2] = jugador.getPosicion();
			filas[3] = jugador.avg();
			filas[4] = jugador.getCantHits();
			filas[5] = jugador.getCantHR();
			filas[6] = jugador.getCantBB();
			filas[7] = ((Bateo)jugador).obp();
			modelo.addRow(filas);
		}
		
	}
	
	public static void llenarTabla2() {
		modelo2.setRowCount(0);
		filas2 = new Object[modelo2.getColumnCount()];
		for (Jugador jugador : equipo.getJugadores()) {
			filas2[0] = jugador.getNumeroCamiseta();
			filas2[1] = jugador.getApellido()+","+jugador.getNombre();
			filas2[2] = jugador.avg();
			filas2[3] = ((Picheo)jugador).getCantJG();
			filas2[4] = ((Picheo)jugador).getCantJP();
			filas2[5] = ((Picheo)jugador).whip();
			filas2[6] = jugador.getCantPonches();
			filas2[7] = jugador.getCantBB();
			filas2[8] = ((Picheo)jugador).getEntradasLanzada();
			modelo2.addRow(filas2);
		}
		
	}
}
