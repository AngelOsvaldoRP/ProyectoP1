package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import logico.Bateo;
import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SimulacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTable tableBV = new JTable();
	public static DefaultTableModel modeloBV;
	public static Object[] filasBV;
	private static JTable tableLV;
	public static DefaultTableModel modeloLV;
	public static Object[] filasLV;
	private static JTable tableBL;
	public static DefaultTableModel modeloBL;
	public static Object[] filasBL;
	private static JTable tableLL;
	public static DefaultTableModel modeloLL;
	public static Object[] filasLL;
	private static Equipo visitante;
	private static Equipo local;
	public static DefaultTableModel modeloEntradas;
	public static Object[] filasEntradas;
	private static JTable tableEntradas;
	public static DefaultTableModel modeloMarcador;
	public static Object[] filasMarcador;
	private static JTable tableMarcador;
	public int carrerasVisitante = 0;
	public int carrerasLocal = 0;
	public int hitVisitante = 0;
	public int hitLocal = 0;
	public int erroresVisitante = 0;
	public int erroresLocal = 0;
	private static ArrayList<Jugador> jugadoresVisitante;
	private static ArrayList<Jugador> jugadoresLocal;

	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			SimulacionJuego dialog = new SimulacionJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SimulacionJuego(Juego juego) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimulacionJuego.class.getResource("/assets/lidomlogo.png")));
		
		visitante = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoVisitante());
		local = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoLocal());
		jugadoresVisitante = new ArrayList<>();
		jugadoresLocal = new ArrayList<>();
		
		for(Jugador jugador : visitante.getJugadores()) {
			jugadoresVisitante.add(jugador);
		}
		for(Jugador jugador : local.getJugadores()) {
			jugadoresLocal.add(jugador);
		}
		
		setTitle(visitante.getNombre()+" vs "+local.getNombre()+" ("+juego.getFecha()+")");
		setBounds(100, 100, 1137, 720);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelBV = new JPanel();
				panelBV.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bateadores ("+visitante.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelBV.setBounds(10, 57, 450, 206);
				panel.add(panelBV);
				panelBV.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane1 = new JScrollPane();
					scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					panelBV.add(scrollPane1);
					{
						modeloBV = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "Pos.", "H", "2B", "3B", "HR", "K", "HBP", "TB", "BB", "CA", "CI", "ES", "BR", "Errores"};
						modeloBV.setColumnIdentifiers(headers);
						tableBV.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableBV.setColumnSelectionAllowed(false);
								tableBV.setCellSelectionEnabled(false);
							}
						});
						tableBV.setModel(modeloBV);
						tableBV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableBV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane1.setViewportView(tableBV);
					}
				}
			}
			{
				JPanel panelLV = new JPanel();
				panelLV.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores ("+visitante.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelLV.setBounds(10, 276, 450, 206);
				panel.add(panelLV);
				panelLV.setLayout(null);
				{
					JScrollPane scrollPane2 = new JScrollPane();
					scrollPane2.setBounds(6, 16, 438, 183);
					scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					panelLV.add(scrollPane2);
					{
						modeloLV = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "IL", "H", "HR", "K", "HBP", "BB", "CL", "JS", "OUT", "HOLD", "Errores"};
						modeloLV.setColumnIdentifiers(headers);
						tableLV = new JTable();
						tableLV.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableLV.setColumnSelectionAllowed(false);
								tableLV.setCellSelectionEnabled(false);
							}
						});
						tableLV.setModel(modeloLV);
						tableLV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableLV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane2.setViewportView(tableLV);
					}
				}
			}
			{
				JPanel panelBL = new JPanel();
				panelBL.setLayout(new BorderLayout(0, 0));
				panelBL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bateadores ("+local.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelBL.setBounds(639, 57, 450, 206);
				panel.add(panelBL);
				{
					JScrollPane scrollPane3 = new JScrollPane();
					scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane3.setBounds(6, 16, 438, 183);
					panelBL.add(scrollPane3);
					{
						modeloBL = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "Pos.", "H", "2B", "3B", "HR", "K", "HBP", "TB", "BB", "CA", "CI", "ES", "BR", "Errores"};
						modeloBL.setColumnIdentifiers(headers);
						tableBL = new JTable();
						tableBL.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableBL.setColumnSelectionAllowed(false);
								tableBL.setCellSelectionEnabled(false);
							}
						});
						tableBL.setModel(modeloBL);
						tableBL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableBL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane3.setViewportView(tableBL);
					}
				}
			}
			{
				JPanel panelLL = new JPanel();
				panelLL.setLayout(new BorderLayout(0, 0));
				panelLL.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores ("+local.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelLL.setBounds(639, 276, 450, 206);
				panel.add(panelLL);
				{
					JScrollPane scrollPane4 = new JScrollPane();
					scrollPane4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane4.setBounds(6, 16, 438, 183);
					panelLL.add(scrollPane4);
					{
						modeloLL = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "IL", "H", "HR", "K", "HBP", "BB", "CL", "JS", "OUT", "HOLD", "Errores"};
						modeloLL.setColumnIdentifiers(headers);
						tableLL = new JTable();
						tableLL.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableLL.setColumnSelectionAllowed(false);
								tableLL.setCellSelectionEnabled(false);
							}
						});
						tableLL.setModel(modeloLL);
						tableLL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableLL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane4.setViewportView(tableLL);
					}
				}
			}
			{
				JLabel lblVisitante = new JLabel(visitante.getNombre());
				lblVisitante.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
				lblVisitante.setBounds(21, 11, 370, 35);
				panel.add(lblVisitante);
			}
			{
				JLabel lblLocal = new JLabel(local.getNombre());
				lblLocal.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
				lblLocal.setBounds(639, 11, 370, 35);
				panel.add(lblLocal);
			}
			
			JPanel panelEntradas = new JPanel();
			panelEntradas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entradas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelEntradas.setBounds(10, 504, 788, 96);
			panel.add(panelEntradas);
			panelEntradas.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 16, 776, 73);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				panelEntradas.add(scrollPane);
				{
					modeloEntradas = new DefaultTableModel();
					String[] headers = {"Equipo","1", "2", "3", "4", "5", "6", "7", "8", "9"};
					modeloEntradas.setColumnIdentifiers(headers);
					tableEntradas = new JTable();
					tableEntradas.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							tableEntradas.setColumnSelectionAllowed(false);
							tableEntradas.setCellSelectionEnabled(false);
						}
					});
					tableEntradas.setModel(modeloEntradas);
					tableEntradas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(tableEntradas);
				}
			}
			
			{
				JPanel panelMarcador = new JPanel();
				panelMarcador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Marcador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelMarcador.setBounds(808, 504, 181, 96);
				panel.add(panelMarcador);
				panelMarcador.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
					panelMarcador.add(scrollPane_1);
					{
						modeloMarcador = new DefaultTableModel();
						String[] headers = {"C","H","E"};
						modeloMarcador.setColumnIdentifiers(headers);
						tableMarcador = new JTable();
						tableLL.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								tableMarcador.setColumnSelectionAllowed(false);
								tableMarcador.setCellSelectionEnabled(false);
							}
						});
						tableMarcador.setModel(modeloMarcador);
						tableMarcador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane_1.setViewportView(tableMarcador);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar Juego");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenarTablaBV();
		llenarTablaLV();
		llenarTablaBL();
		llenarTablaLL();
		llenarTablaEntradas();
		llenarMarcador();
	}
	
	public static void llenarTablaBV() {
		modeloBV.setRowCount(0);
		filasBV = new Object[modeloBV.getColumnCount()];
		for (Jugador jugador : jugadoresVisitante) {
			if(jugador instanceof Bateo) {
				filasBV[0] = jugador.getNumeroCamiseta();
				filasBV[1] = jugador.getNombre();
				filasBV[2] = jugador.getPosicion();
				filasBV[3] = 0;
				filasBV[4] = 0;
				filasBV[5] = 0;
				filasBV[6] = 0;
				filasBV[7] = 0;
				filasBV[8] = 0;
				filasBV[9] = 0;
				filasBV[10] = 0;
				filasBV[11] = 0;
				filasBV[12] = 0;
				filasBV[13] = 0;
				filasBV[14] = 0;
				filasBV[15] = 0;
				modeloBV.addRow(filasBV);
			}
		}
		
	}
	public static void llenarTablaLV() {
		modeloLV.setRowCount(0);
		filasLV = new Object[modeloLV.getColumnCount()];
		for (Jugador jugador : jugadoresVisitante) {
			if(jugador instanceof Picheo) {
				filasLV[0] = jugador.getNumeroCamiseta();
				filasLV[1] = jugador.getNombre();
				filasLV[2] = 0;
				filasLV[3] = 0;
				filasLV[4] = 0;
				filasLV[5] = 0;
				filasLV[6] = 0;
				filasLV[7] = 0;
				filasLV[8] = 0;
				filasLV[9] = 0;
				filasLV[10] = 0;
				filasLV[11] = 0;
				filasLV[12] = 0;
				modeloLV.addRow(filasLV);
			}
		}
		
	}
	
	public static void llenarTablaBL() {
		modeloBL.setRowCount(0);
		filasBL = new Object[modeloBL.getColumnCount()];
		for (Jugador jugador : jugadoresLocal) {
			if(jugador instanceof Bateo) {
				filasBL[0] = jugador.getNumeroCamiseta();
				filasBL[1] = jugador.getNombre();
				filasBL[2] = jugador.getPosicion();
				filasBL[3] = 0;
				filasBL[4] = 0;
				filasBL[5] = 0;
				filasBL[6] = 0;
				filasBL[7] = 0;
				filasBL[8] = 0;
				filasBL[9] = 0;
				filasBL[10] = 0;
				filasBL[11] = 0;
				filasBL[12] = 0;
				filasBL[13] = 0;
				filasBL[14] = 0;
				filasBL[15] = 0;
				modeloBL.addRow(filasBL);
			}
		}
		
	}
	public static void llenarTablaLL() {
		modeloLL.setRowCount(0);
		filasLL = new Object[modeloLL.getColumnCount()];
		for (Jugador jugador : jugadoresLocal) {
			if(jugador instanceof Picheo) {
				filasLL[0] = jugador.getNumeroCamiseta();
				filasLL[1] = jugador.getNombre();
				filasLL[2] = 0;
				filasLL[3] = 0;
				filasLL[4] = 0;
				filasLL[5] = 0;
				filasLL[6] = 0;
				filasLL[7] = 0;
				filasLL[8] = 0;
				filasLL[9] = 0;
				filasLL[10] = 0;
				filasLL[11] = 0;
				filasLL[12] = 0;
				modeloLL.addRow(filasLL);
			}
		}
		
	}
	public static void llenarTablaEntradas() {
		modeloEntradas.setRowCount(0);
		filasEntradas = new Object[modeloEntradas.getColumnCount()];
		for (int i=0; i < 2 ; i++) {
				filasEntradas[0] = "";
				filasEntradas[1] = 0;
				filasEntradas[2] = 0;
				filasEntradas[3] = 0;
				filasEntradas[4] = 0;
				filasEntradas[5] = 0;
				filasEntradas[6] = 0;
				filasEntradas[7] = 0;
				filasEntradas[8] = 0;
				filasEntradas[9] = 0;
				modeloEntradas.addRow(filasEntradas);
		}
		
		modeloEntradas.setValueAt("Visitante", 0, 0);
		modeloEntradas.setValueAt("Local", 1, 0);
	}
	public static void llenarMarcador() {
		modeloMarcador.setRowCount(0);
		filasMarcador = new Object[modeloMarcador.getColumnCount()];
		for (int i=0; i < 2 ; i++) {
				filasMarcador[0] = 0;
				filasMarcador[1] = 0;
				filasMarcador[2] = 0;
				modeloMarcador.addRow(filasMarcador);
		}
	}
}
