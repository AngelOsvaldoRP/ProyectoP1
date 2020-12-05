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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Equipo;
import logico.Jugador;
import logico.Lesion;
import logico.Torneo;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class ListLesionado extends JDialog {
	private static DefaultCategoryDataset dataset;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JButton btnReactivar;
	public Lesion aux = null;
	private static Equipo equipoSelected = null;
	static DefaultCategoryDataset data;
	static JPanel panel_stire ;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 *
	 */
	public ListLesionado(Equipo equipo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListLesionado.class.getResource("/assets/logo lidom.png")));
		
		this.equipoSelected = equipo;
		setTitle("Lesionados de "+equipo.getNombre());
		setModal(true);
	        
		setBounds(100, 100, 1159, 383);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(5, 5, 608, 290);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(2, 2, 606, 288);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"Codigo", "Nombre/Apellido", "Tipo Lesion", "Estado", "Cant. Dias"};
					modelo.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1) {
								btnReactivar.setEnabled(true);
								aux = equipoSelected.buscarLesion((String)modelo.getValueAt(seleccion, 0));
								
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
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(623, 5, 510, 290);
			contentPanel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			// Fuente de Datos
			dataset = new DefaultCategoryDataset();
	        JFreeChart chart = ChartFactory.createBarChart3D
	        ("Jugadores lesionados en la temporada","Tipo de Lesion", "Cantidad de jugadores", 
	        dataset, PlotOrientation.VERTICAL, true,true, false);
	        chart.getTitle().setPaint(Color.black); 
	        CategoryPlot p = chart.getCategoryPlot(); 
	        p.setRangeGridlinePaint(Color.RED); 
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel_1.add(chartPanel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnReactivar = new JButton("Reactivar");
				btnReactivar.setForeground(Color.WHITE);
				btnReactivar.setBackground(new Color(0, 128, 0));
				btnReactivar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aux.setEstado("Terminada");
						aux.getJugador().setEstado("Disponible");
						JOptionPane.showMessageDialog(null, "El jugador ya esta disponible", null, JOptionPane.INFORMATION_MESSAGE, null);
						llenarTabla();
					}
				});
				btnReactivar.setEnabled(false);
				buttonPane.add(btnReactivar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setForeground(Color.WHITE);
				btnCancelar.setBackground(new Color(178, 34, 34));
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
	}

	public static void llenarTabla() {
		int de = 0;
		int fr = 0;
		int mo = 0;
		int en = 0;
		int es = 0;
		modelo.setRowCount(0);
		data = new DefaultCategoryDataset();
		filas = new Object[modelo.getColumnCount()];
		for (Lesion lesion : equipoSelected.getLesiones()) {
			filas[0] = lesion.getLesionCod();
			filas[1] = lesion.getJugador().getNombre()+" "+lesion.getJugador().getApellido();
			filas[2] = lesion.getTipo();
			filas[3] = lesion.getEstado();
			filas[4] = lesion.getCantDias();
			modelo.addRow(filas);
			if(lesion.getTipo().equalsIgnoreCase("Fractura"))  {dataset.setValue(++fr,"", "Fractura");}
			if(lesion.getTipo().equalsIgnoreCase("Molestias")) {dataset.setValue(++mo,"", "Molestias");}
			if(lesion.getTipo().equalsIgnoreCase("Desgarre"))  {dataset.setValue(++de,"", "Desgarre");}
			if(lesion.getTipo().equalsIgnoreCase("Enfermedad")){dataset.setValue(++en,"", "Enfermedad");}
			if(lesion.getTipo().equalsIgnoreCase("Esguince"))  {dataset.setValue(++es,"", "Esguince");}
		}	
		
	}
}
