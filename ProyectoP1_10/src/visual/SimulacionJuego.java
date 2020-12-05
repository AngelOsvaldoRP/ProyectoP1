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

import logico.Equipo;
import logico.Juego;
import logico.Torneo;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class SimulacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableBV;
	public static DefaultTableModel modeloBV;
	private JTable tableLV;
	public static DefaultTableModel modeloLV;
	private JTable tableBL;
	public static DefaultTableModel modeloBL;
	private JTable tableLL;
	public static DefaultTableModel modeloLL;
	private Equipo visitante;
	private Equipo local;

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
				JButton okButton = new JButton("OK");
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

}
