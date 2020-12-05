package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bateo;
import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		visitante = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoVisitante());
		local = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoLocal());
		setBounds(100, 100, 1137, 767);
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
						String[] headers = {"No.","Nombre", "Pos.", "H", "2B", "3B", "HR", "K", "HBP", "TB", "BB", "CA", "CI", "ES", "BR"};
						modeloBV.setColumnIdentifiers(headers);
						tableBV.setModel(modeloBV);
						tableBV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableBV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane1.setViewportView(tableBV);
					}
				}
			}
			{
				JPanel panelLV = new JPanel();
				panelLV.setLayout(new BorderLayout(0, 0));
				panelLV.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lanzadores ("+visitante.getNombre()+")", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelLV.setBounds(10, 276, 450, 206);
				panel.add(panelLV);
				{
					JScrollPane scrollPane2 = new JScrollPane();
					scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					panelLV.add(scrollPane2);
					{
						modeloLV = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "IL", "H", "HR", "K", "HBP", "BB", "CL", "A", "JS", "TBE", "HOLD"};
						modeloLV.setColumnIdentifiers(headers);
						tableLV = new JTable();
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
						String[] headers = {"No.","Nombre", "Pos.", "H", "2B", "3B", "HR", "K", "HBP", "TB", "BB", "CA", "CI", "ES", "BR"};
						modeloBL.setColumnIdentifiers(headers);
						tableBL = new JTable();
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
						String[] headers = {"No.","Nombre", "IL", "H", "HR", "K", "HBP", "BB", "CL", "A", "JS", "TBE", "HOLD"};
						modeloLL.setColumnIdentifiers(headers);
						tableLL = new JTable();
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
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Finalizar Juego");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actualizarBV();
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
	}
	
	private void actualizarBV() {
		int[] estadistica = new int[12];
		int i = 0;
		for (Jugador jugador : visitante.getJugadores()) {
			if(jugador instanceof Bateo) {
				for (int j = 3; j < filasBV.length; j++) {
					estadistica[j-3] = (int)modeloBV.getValueAt(i, j);
				}
				jugador.setCantHits(jugador.getCantHits()+estadistica[0]);
				((Bateo)jugador).setCant2B(((Bateo)jugador).getCant2B()+estadistica[1]);
				((Bateo)jugador).setCant3B(((Bateo)jugador).getCant3B()+estadistica[2]);
				jugador.setCantHR(jugador.getCantHR()+estadistica[3]);
				jugador.setCantPonches(jugador.getCantPonches()+estadistica[4]);
				jugador.setHbp(jugador.getHbp()+estadistica[5]);
				((Bateo)jugador).setCantTB(((Bateo)jugador).getCantTB()+estadistica[6]);
				jugador.setCantBB(jugador.getCantBB()+estadistica[7]);
				((Bateo)jugador).setCantCA(((Bateo)jugador).getCantCA()+estadistica[8]);
				((Bateo)jugador).setCantCI(((Bateo)jugador).getCantCI()+estadistica[9]);
				((Bateo)jugador).setES(((Bateo)jugador).getES()+estadistica[10]);
				((Bateo)jugador).setCantBR(((Bateo)jugador).getCantBR()+estadistica[11]);
				i++;
			}
			}
			
	}
	
	public static void llenarTablaBV() {
		modeloBV.setRowCount(0);
		filasBV = new Object[modeloBV.getColumnCount()];
		for (Jugador jugador : visitante.getJugadores()) {
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
				modeloBV.addRow(filasBV);
			}
		}
		
	}
	public static void llenarTablaLV() {
		modeloLV.setRowCount(0);
		filasLV = new Object[modeloLV.getColumnCount()];
		for (Jugador jugador : visitante.getJugadores()) {
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
		for (Jugador jugador : local.getJugadores()) {
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
				modeloBL.addRow(filasBL);
			}
		}
		
	}
	public static void llenarTablaLL() {
		modeloLL.setRowCount(0);
		filasLL = new Object[modeloLL.getColumnCount()];
		for (Jugador jugador : local.getJugadores()) {
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

}
