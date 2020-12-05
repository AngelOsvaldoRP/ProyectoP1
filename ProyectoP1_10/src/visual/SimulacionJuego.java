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
	private JTable tableBV;
	public static DefaultTableModel modeloBV;
	public static Object[] filasBV;
	private JTable tableLV;
	public static DefaultTableModel modeloLV;
	public static Object[] filasLV;
	private JTable tableBL;
	public static DefaultTableModel modeloBL;
	public static Object[] filasBL;
	private JTable tableLL;
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
		local = Torneo.getInstance().buscarEquiporNombre(juego.getEquipoVisitante());
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
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					panelBV.add(scrollPane);
					{
						modeloBV = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "Pos.", "H", "2B", "3B", "HR", "K", "HBP", "TB", "BB", "CA", "CI", "ES", "BR"};
						modeloBV.setColumnIdentifiers(headers);
						tableBV = new JTable();
						tableBV.setModel(modeloBV);
						tableBV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableBV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(tableBV);
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
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					panelLV.add(scrollPane);
					{
						modeloLV = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "IL", "H", "HR", "K", "HBP", "BB", "CL", "A", "JS", "TBE", "HOLD"};
						modeloLV.setColumnIdentifiers(headers);
						tableLV = new JTable();
						tableLV.setModel(modeloLV);
						tableLV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableLV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(tableLV);
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
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane.setBounds(6, 16, 438, 183);
					panelBL.add(scrollPane);
					{
						modeloBL = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "Pos.", "H", "2B", "3B", "HR", "K", "HBP", "TB", "BB", "CA", "CI", "ES", "BR"};
						modeloBL.setColumnIdentifiers(headers);
						tableBL = new JTable();
						tableBL.setModel(modeloBL);
						tableBL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableBL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(tableBL);
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
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
					scrollPane.setBounds(6, 16, 438, 183);
					panelLL.add(scrollPane);
					{
						modeloLL = new DefaultTableModel();
						String[] headers = {"No.","Nombre", "IL", "H", "HR", "K", "HBP", "BB", "CL", "A", "JS", "TBE", "HOLD"};
						modeloLL.setColumnIdentifiers(headers);
						tableLL = new JTable();
						tableLL.setModel(modeloLL);
						tableLL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						tableLL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(tableLL);
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
	}
	
	private void actualizarBV() {

		for (int i = 0; i < filasBV.length; i++) {
			//Jugador jugador = visitante.buscarJugadorByNumero((Integer)modelo2.getValueAt(seleccion, 0));
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
				filasBV[3] = "";
				filasBV[4] = "";
				filasBV[5] = "";
				filasBV[6] = "";
				filasBV[7] = "";
				filasBV[8] = "";
				filasBV[9] = "";
				filasBV[10] = "";
				filasBV[11] = "";
				filasBV[12] = "";
				filasBV[13] = "";
				filasBV[14] = "";
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
				filasLV[2] = "";
				filasLV[3] = "";
				filasLV[4] = "";
				filasLV[5] = "";
				filasLV[6] = "";
				filasLV[7] = "";
				filasLV[8] = "";
				filasLV[9] = "";
				filasLV[10] = "";
				filasLV[11] = "";
				filasLV[12] = "";
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
				filasBL[3] = "";
				filasBL[4] = "";
				filasBL[5] = "";
				filasBL[6] = "";
				filasBL[7] = "";
				filasBL[8] = "";
				filasBL[9] = "";
				filasBL[10] = "";
				filasBL[11] = "";
				filasBL[12] = "";
				filasBL[13] = "";
				filasBL[14] = "";
				modeloBV.addRow(filasBL);
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
				filasLL[2] = "";
				filasLL[3] = "";
				filasLL[4] = "";
				filasLL[5] = "";
				filasLL[6] = "";
				filasLL[7] = "";
				filasLL[8] = "";
				filasLL[9] = "";
				filasLL[10] = "";
				filasLL[11] = "";
				filasLL[12] = "";
				modeloLV.addRow(filasLL);
			}
		}
		
	}

}
