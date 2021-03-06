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
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ListJugador extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTable table1;
	private JTable table2;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	public static DefaultTableModel modelo2;
	public static Object[] filas2;
	public Jugador aux1 = null;
	public Jugador aux2 = null;
	public static Equipo equipo = null;
	private JButton btnVerJugadores;
	private JButton btnLesionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel;
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 *
	 */
	public ListJugador(Equipo equipo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListJugador.class.getResource("/assets/lidomlogo.png")));
		this.equipo = equipo;
		setTitle("Jugadores de "+equipo.getNombre());
		setModal(true);
		setBounds(100, 100, 1178, 367);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(10, 69, 1142, 206);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bateadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 16, 1130, 183);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"No.", "Estado", "Nombre", "Apellido", "Posicion", "AVG", "H", "HR", "BB", "OBP"};
					modelo.setColumnIdentifiers(headers);
					table1 = new JTable();
					table1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table1.getSelectedRow();
							if(seleccion!=-1) {
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								btnVerJugadores.setEnabled(true);
								btnLesionar.setEnabled(true);
								aux1 = equipo.buscarJugadorByNumero(((Integer)modelo.getValueAt(seleccion, 0)));
							}
						}
					});
					table1.setModel(modelo);
					table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table1);
				}
			}
		}
		{
			panel2 = new JPanel();
			panel2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel2.setBounds(10, 69, 1142, 206);
			contentPanel.add(panel2);
			panel2.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel2.add(scrollPane);
				{
					modelo2 = new DefaultTableModel();
					String[] headers = {"No.", "Estado", "Nombre", "Apellido", "PCL", "JG", "JP", "K", "BB", "IL"};
					modelo2.setColumnIdentifiers(headers);
					table2 = new JTable();
					table2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table2.getSelectedRow();
							if(seleccion!=-1) {
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								btnVerJugadores.setEnabled(true);
								btnLesionar.setEnabled(true);
								aux2 = equipo.buscarJugadorByNumero((Integer)modelo2.getValueAt(seleccion, 0));
							}
						}
					});
					table2.setModel(modelo2);
					table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table2);
				}
			}
		}
		
		JLabel lblTipoDeJugador = new JLabel("Tipo de Jugador:");
		lblTipoDeJugador.setBounds(10, 31, 112, 23);
		contentPanel.add(lblTipoDeJugador);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = comboBox.getSelectedItem().toString();
				if(tipo == "Bateadores") {
					aux2 = null;
					panel.setVisible(true);
					panel2.setVisible(false);
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
					btnVerJugadores.setEnabled(false);
					btnLesionar.setEnabled(false);
				}
				if(tipo == "Lanzadores") {
					llenarTabla2();
					aux1 = null;
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
					btnVerJugadores.setEnabled(false);
					btnLesionar.setEnabled(false);
					panel2.setVisible(true);
					panel.setVisible(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bateadores", "Lanzadores"}));
		comboBox.setBounds(109, 31, 136, 23);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar Jugador");
				btnModificar.setIcon(new ImageIcon(ListJugador.class.getResource("/assets/round_create_white_18dp.png")));
				btnModificar.setBackground(new Color(210, 105, 30));
				btnModificar.setForeground(new Color(255, 255, 255));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux1 instanceof Bateo) {
							dispose();
							ModJugador mod = new ModJugador(equipo, aux1);
							mod.setModal(true);
							mod.setLocationRelativeTo(null);
							mod.setVisible(true);
						}
						if(aux2 instanceof Picheo) {
							dispose();
							ModJugador mod = new ModJugador(equipo, aux2);
							mod.setModal(true);
							mod.setLocationRelativeTo(null);
							mod.setVisible(true);
						}
					}
				});
				{
					btnVerJugadores = new JButton("Ver Jugador");
					btnVerJugadores.setIcon(new ImageIcon(ListJugador.class.getResource("/assets/round_visibility_white_18dp.png")));
					btnVerJugadores.setBackground(new Color(65, 105, 225));
					btnVerJugadores.setForeground(new Color(255, 255, 255));
					btnVerJugadores.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(aux1 instanceof Bateo) {
								EstadisticasJugadorBateo vista = new EstadisticasJugadorBateo(aux1);
								vista.setModal(true);
								vista.setLocationRelativeTo(null);
								vista.setVisible(true);
							}
							if(aux2 instanceof Picheo) {
								EstadisticasJugadorPicheo vista = new EstadisticasJugadorPicheo(aux2);
								vista.setModal(true);
								vista.setLocationRelativeTo(null);
								vista.setVisible(true);
							}
						}
					});
					{
						btnLesionar = new JButton("Lesionar");
						btnLesionar.setIcon(new ImageIcon(ListJugador.class.getResource("/assets/round_flaky_white_18dp.png")));
						btnLesionar.setBackground(new Color(165, 42, 42));
						btnLesionar.setForeground(new Color(255, 255, 255));
						btnLesionar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								if(aux1!=null) {
									if(aux1.getEstado()== "Lesionado"){

										JOptionPane.showMessageDialog(null, "El jugador ya esta lesionado!", null, JOptionPane.ERROR_MESSAGE, null);
									}else {
									RegJugadorLesionado reg = new RegJugadorLesionado(equipo, aux1);
									reg.setModal(true);
									reg.setLocationRelativeTo(null);
									reg.setVisible(true);
									dispose();
									}
									
								}
								
								if(aux2!=null) {
									if(aux2.getEstado()== "Lesionado"){

										JOptionPane.showMessageDialog(null, "El jugador ya esta lesionado!", null, JOptionPane.ERROR_MESSAGE, null);
									}else {
									RegJugadorLesionado reg = new RegJugadorLesionado(equipo, aux2);
									reg.setModal(true);
									reg.setLocationRelativeTo(null);
									reg.setVisible(true);
									dispose();
									}
									
								}
								
							}
						});
						btnLesionar.setEnabled(false);
	 					buttonPane.add(btnLesionar);
					}
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
				btnEliminar.setIcon(new ImageIcon(ListJugador.class.getResource("/assets/round_delete_white_18dp.png")));
				btnEliminar.setBackground(new Color(255, 0, 0));
				btnEliminar.setForeground(new Color(255, 255, 255));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux1!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al jugador: "+aux1.getNombre(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								Torneo.getInstance().eliminarJugador(aux1);
								equipo.eliminarJugador(aux1);
								Torneo.getInstance().escribir();
								llenarTabla();
								llenarTabla2();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
								btnVerJugadores.setEnabled(true);
							}
						}
						if(aux2!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al jugador: "+aux2.getNombre(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								Torneo.getInstance().eliminarJugador(aux2);
								equipo.eliminarJugador(aux2);
								Torneo.getInstance().escribir();
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
				btnCancelar.setIcon(new ImageIcon(ListJugador.class.getResource("/assets/round_clear_white_18dp.png")));
				btnCancelar.setBackground(new Color(178, 34, 34));
				btnCancelar.setForeground(new Color(255, 255, 255));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnAgregarJugador = new JButton("Agregar Jugador");
					btnAgregarJugador.setIcon(new ImageIcon(ListJugador.class.getResource("/assets/round_add_white_18dp.png")));
					btnAgregarJugador.setBackground(new Color(0, 128, 0));
					btnAgregarJugador.setForeground(new Color(255, 255, 255));
					btnAgregarJugador.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegJugador reg = new RegJugador(equipo);
							reg.setModal(true);
							reg.setLocationRelativeTo(null);
							reg.setVisible(true);
							dispose();
						}
					});
					btnAgregarJugador.setActionCommand("OK");
					buttonPane.add(btnAgregarJugador);
				}
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
			if(jugador instanceof Bateo) {
				filas[0] = jugador.getNumeroCamiseta();
				filas[1] = jugador.getEstado();
				filas[2] = jugador.getNombre();
				filas[3] = jugador.getApellido();
				filas[4] = jugador.getPosicion();
				filas[5] = jugador.avg();
				filas[6] = jugador.getCantHits();
				filas[7] = jugador.getCantHR();
				filas[8] = jugador.getCantBB();
				filas[9] = ((Bateo)jugador).obp();
				modelo.addRow(filas);
			}
		}
		
	}
	
	public static void llenarTabla2() {
		modelo2.setRowCount(0);
		filas2 = new Object[modelo2.getColumnCount()];
		for (Jugador jugador : equipo.getJugadores()) {
			if(jugador instanceof Picheo) {
				filas2[0] = jugador.getNumeroCamiseta();
				filas2[1] = jugador.getEstado();
				filas2[2] = jugador.getNombre();
				filas2[3] = jugador.getApellido();
				filas2[4] = jugador.avg();
				filas2[5] = ((Picheo)jugador).getCantJG();
				filas2[6] = ((Picheo)jugador).getCantJP();
				filas2[7] = jugador.getCantPonches();
				filas2[8] = jugador.getCantBB();
				filas2[9] = ((Picheo)jugador).getEntradasLanzada();
				modelo2.addRow(filas2);
			}
		}
		
	}
	
	
}
