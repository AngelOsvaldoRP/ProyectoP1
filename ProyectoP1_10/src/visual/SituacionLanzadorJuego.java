package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SituacionLanzadorJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCarrerasGanador;
	private JTextField textHitsGanador;
	private JTextField textFErroresGanandor;
	private JTextField textCarrerasPerdedor;
	private JTextField textHitsPerdedor;
	private JTextField textErroresPerdedor;
	public static DefaultTableModel modeloLV;
	public static Object[] filasLV;
	private static JTable tableLV;
	public static DefaultTableModel modeloLL;
	public static Object[] filasLL;
	private static JTable tableLL;
	private static Equipo ganador;
	private static Equipo perdedor;
	private Jugador aux1 = null;
	private Jugador aux2 = null;
	private JButton btnLanzadorGanador;
	private JButton btnLanzadorSalvador;
	private JButton btnPerdedor;
	private int ganadorL = 0;
	private int salvadorL = 0;
	private int perdedorL = 0;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			SituacionLanzadorJuego dialog = new SituacionLanzadorJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SituacionLanzadorJuego(Juego juego) {
		
		ganador = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoganador());
		perdedor = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoPerdedor());
		
		setBounds(100, 100, 695, 426);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelVerificarLanzadores = new JPanel();
			panelVerificarLanzadores.setBorder(new TitledBorder(null, "Informacion Juego", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panelVerificarLanzadores, BorderLayout.CENTER);
			panelVerificarLanzadores.setLayout(null);
			
			{
				JPanel panelLV = new JPanel();
				panelLV.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores ("+ganador.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelLV.setBounds(181, 23, 322, 146);
				panelVerificarLanzadores.add(panelLV);
				panelLV.setLayout(null);
				{
					JScrollPane scrollPane2 = new JScrollPane();
					scrollPane2.setBounds(6, 16, 310, 123);
					scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					panelLV.add(scrollPane2);
					{
						modeloLV = new DefaultTableModel();
						String[] headers = {"No.","Nombre","Apellido"};
						modeloLV.setColumnIdentifiers(headers);
						tableLV = new JTable();
						tableLV.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableLV.setColumnSelectionAllowed(false);
								int seleccion = tableLV.getSelectedRow();
								if(seleccion!=-1) {
									aux2 = null;
									if(ganadorL==0) {
										btnLanzadorGanador.setEnabled(true);
									}
									if(salvadorL==0) {
										btnLanzadorSalvador.setEnabled(true);
									}
									aux1 = ganador.buscarJugadorByNumero((Integer)modeloLV.getValueAt(seleccion, 0));
								}
							}
						});
						tableLV.setModel(modeloLV);
						tableLV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane2.setViewportView(tableLV);
					}
				}
			}
			
			{
				JPanel panelLL = new JPanel();
				panelLL.setLayout(null);
				panelLL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores ("+perdedor.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelLL.setBounds(181, 180, 322, 146);
				panelVerificarLanzadores.add(panelLL);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setBounds(6, 16, 310, 123);
					panelLL.add(scrollPane);
					{
						modeloLL = new DefaultTableModel();
						String[] headers = {"No.","Nombre","Apellido"};
						modeloLL.setColumnIdentifiers(headers);
						tableLL = new JTable();
						tableLL.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableLL.setColumnSelectionAllowed(false);
								int seleccion = tableLL.getSelectedRow();
								if(seleccion!=-1) {
									aux1 = null;
									if(perdedorL==0) {
										btnPerdedor.setEnabled(true);
									}
									aux2 = perdedor.buscarJugadorByNumero((Integer)modeloLL.getValueAt(seleccion, 0));
								}
							}
						});
						tableLL.setModel(modeloLL);
						tableLL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(tableLL);
					}
				}
				
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Equipo Ganador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 23, 161, 146);
			panelVerificarLanzadores.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblEquipoGanador = new JLabel(juego.getEquipoganador());
			lblEquipoGanador.setBounds(10, 21, 141, 14);
			panel_1.add(lblEquipoGanador);
			{
				JLabel lblCarreras = new JLabel("Carreras:");
				lblCarreras.setBounds(10, 46, 63, 14);
				panel_1.add(lblCarreras);
			}
			
			textCarrerasGanador = new JTextField();
			if(juego.getGanador().equalsIgnoreCase("Local")) {
				textCarrerasGanador.setText(""+juego.getCarrerasLocal());
			}
			if(juego.getGanador().equalsIgnoreCase("Visitante")) {
				textCarrerasGanador.setText(""+juego.getCarrerasVisitante());
			}
			textCarrerasGanador.setEnabled(false);
			textCarrerasGanador.setBounds(70, 43, 37, 23);
			panel_1.add(textCarrerasGanador);
			textCarrerasGanador.setColumns(10);
			
			JLabel lblHits = new JLabel("Hits:");
			lblHits.setBounds(10, 76, 63, 14);
			panel_1.add(lblHits);
			
			textHitsGanador = new JTextField();
			if(juego.getGanador().equalsIgnoreCase("Local")) {
				textHitsGanador.setText(""+juego.getHitsLocal());
			}
			if(juego.getGanador().equalsIgnoreCase("Visitante")) {
				textHitsGanador.setText(""+juego.getHitsVisitante());
			}
			textHitsGanador.setEnabled(false);
			textHitsGanador.setColumns(10);
			textHitsGanador.setBounds(70, 73, 37, 23);
			panel_1.add(textHitsGanador);
			
			JLabel lblErrores = new JLabel("Errores:");
			lblErrores.setBounds(10, 104, 63, 14);
			panel_1.add(lblErrores);
			
			textFErroresGanandor = new JTextField();
			if(juego.getGanador().equalsIgnoreCase("Local")) {
				textFErroresGanandor.setText(""+juego.getErroresLocal());
			}
			if(juego.getGanador().equalsIgnoreCase("Visitante")) {
				textFErroresGanandor.setText(""+juego.getErroresVisitante());
			}
			textFErroresGanandor.setEnabled(false);
			textFErroresGanandor.setColumns(10);
			textFErroresGanandor.setBounds(70, 101, 37, 23);
			panel_1.add(textFErroresGanandor);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipo Perdedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(10, 180, 161, 146);
			panelVerificarLanzadores.add(panel_2);
			
			JLabel labelEquipoPerdedor = new JLabel(juego.getEquipoPerdedor());
			labelEquipoPerdedor.setBounds(10, 21, 141, 14);
			panel_2.add(labelEquipoPerdedor);
			
			JLabel label_1 = new JLabel("Carreras:");
			label_1.setBounds(10, 46, 63, 14);
			panel_2.add(label_1);
			
			textCarrerasPerdedor = new JTextField();
			if(juego.getPerdedor().equalsIgnoreCase("Local")) {
				textCarrerasPerdedor.setText(""+juego.getCarrerasLocal());
			}
			if(juego.getPerdedor().equalsIgnoreCase("Visitante")) {
				textCarrerasPerdedor.setText(""+juego.getCarrerasVisitante());
			}
			textCarrerasPerdedor.setEnabled(false);
			textCarrerasPerdedor.setColumns(10);
			textCarrerasPerdedor.setBounds(70, 43, 37, 23);
			panel_2.add(textCarrerasPerdedor);
			
			JLabel label_2 = new JLabel("Hits:");
			label_2.setBounds(10, 76, 63, 14);
			panel_2.add(label_2);
			
			textHitsPerdedor = new JTextField();
			if(juego.getPerdedor().equalsIgnoreCase("Local")) {
				textHitsPerdedor.setText(""+juego.getHitsLocal());
			}
			if(juego.getPerdedor().equalsIgnoreCase("Visitante")) {
				textHitsPerdedor.setText(""+juego.getHitsVisitante());
			}
			textHitsPerdedor.setEnabled(false);
			textHitsPerdedor.setColumns(10);
			textHitsPerdedor.setBounds(70, 73, 37, 23);
			panel_2.add(textHitsPerdedor);
			
			JLabel label_3 = new JLabel("Errores:");
			label_3.setBounds(10, 104, 63, 14);
			panel_2.add(label_3);
			
			textErroresPerdedor = new JTextField();
			if(juego.getPerdedor().equalsIgnoreCase("Local")) {
				textErroresPerdedor.setText(""+juego.getErroresLocal());
			}
			if(juego.getPerdedor().equalsIgnoreCase("Visitante")) {
				textErroresPerdedor.setText(""+juego.getErroresVisitante());
			}
			textErroresPerdedor.setEnabled(false);
			textErroresPerdedor.setColumns(10);
			textErroresPerdedor.setBounds(70, 101, 37, 23);
			panel_2.add(textErroresPerdedor);
			
			btnLanzadorGanador = new JButton("Ganador");
			btnLanzadorGanador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aux2 = null;
					((Picheo)aux1).setCantJG(((Picheo)aux1).getCantJG() + 1);
					llenarTablaLV(aux1.getNumeroCamiseta());
					JOptionPane.showMessageDialog(null, "El Jugador "+aux1.getNombre()+" se agrego como ganador", null, JOptionPane.INFORMATION_MESSAGE, null);
					ganadorL = 1;
					btnLanzadorGanador.setEnabled(false);
					btnLanzadorSalvador.setEnabled(false);
				}
			});
			btnLanzadorGanador.setEnabled(false);
			btnLanzadorGanador.setActionCommand("OK");
			btnLanzadorGanador.setBounds(513, 60, 137, 23);
			panelVerificarLanzadores.add(btnLanzadorGanador);
	
			btnLanzadorSalvador = new JButton("Salvador");
			btnLanzadorSalvador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aux2 = null;
					((Picheo)aux1).setCantJS(((Picheo)aux1).getCantJS() + 1);
					llenarTablaLV(aux1.getNumeroCamiseta());
					JOptionPane.showMessageDialog(null, "El Jugador "+aux1.getNombre()+" se agrego como salvador", null, JOptionPane.INFORMATION_MESSAGE, null);
					salvadorL = 1;
					btnLanzadorGanador.setEnabled(false);
					btnLanzadorSalvador.setEnabled(false);
				}
			});
			btnLanzadorSalvador.setEnabled(false);
			btnLanzadorSalvador.setActionCommand("OK");
			btnLanzadorSalvador.setBounds(513, 97, 137, 23);
			panelVerificarLanzadores.add(btnLanzadorSalvador);
			
			btnPerdedor = new JButton("Perdedor");
			btnPerdedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					aux1 = null;
					((Picheo)aux2).setCantJP(((Picheo)aux2).getCantJP() + 1);
					llenarTablaLL(aux2.getNumeroCamiseta());
					JOptionPane.showMessageDialog(null, "El Jugador "+aux2.getNombre()+" se agrego como perdedor", null, JOptionPane.INFORMATION_MESSAGE, null);
					perdedorL = 1;
					btnPerdedor.setEnabled(false);
				}
			});
			btnPerdedor.setEnabled(false);
			btnPerdedor.setActionCommand("OK");
			btnPerdedor.setBounds(513, 241, 137, 23);
			panelVerificarLanzadores.add(btnPerdedor);

		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(ganadorL==0 || perdedorL==0) {
							JOptionPane.showMessageDialog(null, "Asegurese de asignar agregar al menos un ganador y perdedor", null, JOptionPane.ERROR_MESSAGE, null);
						}
						if(ganadorL==1 && perdedorL==1) {
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
			llenarTablaLV(-1);
			llenarTablaLL(-1);
	}
	
	public static void llenarTablaLL(int numero) {
		modeloLL.setRowCount(0);
		filasLL = new Object[modeloLL.getColumnCount()];
		for (Jugador jugador : perdedor.getJugadores()) {
			if(jugador.getEstado().equalsIgnoreCase("Disponible")) {
			if(jugador.getNumeroCamiseta()!=numero) {
				if(jugador instanceof Picheo) {
					filasLL[0] = jugador.getNumeroCamiseta();
					filasLL[1] = jugador.getNombre();
					filasLL[2] = jugador.getApellido();
					modeloLL.addRow(filasLL);
			}
			}
		}
		}
	}
	
	public static void llenarTablaLV(int numero) {
		modeloLV.setRowCount(0);
		filasLV = new Object[modeloLV.getColumnCount()];
		for (Jugador jugador : ganador.getJugadores()) {
			if(jugador.getEstado().equalsIgnoreCase("Disponible")) {
				if(jugador.getNumeroCamiseta()!=numero) {
					if(jugador instanceof Picheo) {
						filasLV[0] = jugador.getNumeroCamiseta();
						filasLV[1] = jugador.getNombre();
						filasLV[2] = jugador.getApellido();
						modeloLV.addRow(filasLV);
					}	
				}
		}
		}
	}
}
