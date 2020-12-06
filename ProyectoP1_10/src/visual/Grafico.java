package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import logico.Lesion;
import logico.Torneo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafico extends JDialog {
	private static DefaultCategoryDataset dataset;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Grafico() {
		setBounds(100, 100, 1031, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				dataset = new DefaultCategoryDataset();
		        JFreeChart chart = ChartFactory.createBarChart3D
		        ("Jugadores lesionados en la temporada","Tipo de Lesion", "Cantidad de jugadores", 
		        dataset, PlotOrientation.VERTICAL, true,true, false);
		        chart.getTitle().setPaint(Color.black); 
		        CategoryPlot p = chart.getCategoryPlot(); 
		        p.setRangeGridlinePaint(Color.RED); 
		        // Mostrar Grafico
		        ChartPanel chartPanel = new ChartPanel(chart);
		        panel.add(chartPanel);
			}
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
		for (Lesion lesion : Torneo.getInstance().getLesiones()) {
			if(lesion.getTipo().equalsIgnoreCase("Fractura"))  {dataset.setValue(++fr,"", "Fractura");}
			if(lesion.getTipo().equalsIgnoreCase("Molestias")) {dataset.setValue(++mo,"", "Molestias");}
			if(lesion.getTipo().equalsIgnoreCase("Desgarre"))  {dataset.setValue(++de,"", "Desgarre");}
			if(lesion.getTipo().equalsIgnoreCase("Enfermedad")){dataset.setValue(++en,"", "Enfermedad");}
			if(lesion.getTipo().equalsIgnoreCase("Esguince"))  {dataset.setValue(++es,"", "Esguince");}
		}	
		
	}
}
