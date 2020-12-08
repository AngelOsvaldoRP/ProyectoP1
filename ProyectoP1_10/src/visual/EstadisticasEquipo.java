package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Equipo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class EstadisticasEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtYear;
	private JTextField txtManager;
	private JTextField txtCiudad;
	private JTextField txtEstadio;
	private JTextField txtJJ;
	private JTextField txtJG;
	private JTextField txtJP;
	private JTextField txtAVGB;
	private JTextField txtAVGP;
	private JTextField txtCA;
	private JTextField txtHits;
	private JTextField txtHR;
	private JTextField txtPonches;
	private JTextField txtBB;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public EstadisticasEquipo(Equipo equipo) {
		setBounds(100, 100, 436, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion General del Equipo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(5, 5, 410, 172);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(10, 33, 97, 14);
				panel.add(lblNewLabel);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBackground(Color.WHITE);
				txtNombre.setEditable(false);
				txtNombre.setText(String.valueOf(equipo.getNombre()));
				txtNombre.setBounds(137, 30, 263, 22);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			
			JLabel lblNewLabel_1 = new JLabel("A\u00F1o de Fundacion:");
			lblNewLabel_1.setBounds(10, 58, 117, 14);
			panel.add(lblNewLabel_1);
			
			txtYear = new JTextField();
			txtYear.setBackground(Color.WHITE);
			txtYear.setEditable(false);
			txtYear.setText(String.valueOf(equipo.getYearFundation()));
			txtYear.setBounds(137, 55, 263, 22);
			panel.add(txtYear);
			txtYear.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Manager:");
			lblNewLabel_2.setBounds(10, 83, 97, 14);
			panel.add(lblNewLabel_2);
			
			txtManager = new JTextField();
			txtManager.setBackground(Color.WHITE);
			txtManager.setEditable(false);
			txtManager.setText(String.valueOf(equipo.getManager()));
			txtManager.setBounds(137, 80, 263, 22);
			panel.add(txtManager);
			txtManager.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Ciudad:");
			lblNewLabel_3.setBounds(10, 108, 97, 14);
			panel.add(lblNewLabel_3);
			
			txtCiudad = new JTextField();
			txtCiudad.setBackground(Color.WHITE);
			txtCiudad.setEditable(false);
			txtCiudad.setText(String.valueOf(equipo.getCiudad()));
			txtCiudad.setBounds(137, 105, 263, 22);
			panel.add(txtCiudad);
			txtCiudad.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Estadio:");
			lblNewLabel_4.setBounds(10, 133, 97, 14);
			panel.add(lblNewLabel_4);
			
			txtEstadio = new JTextField();
			txtEstadio.setBackground(Color.WHITE);
			txtEstadio.setEditable(false);
			txtEstadio.setText(String.valueOf(equipo.getEstadio()));
			txtEstadio.setBounds(137, 130, 263, 22);
			panel.add(txtEstadio);
			txtEstadio.setColumns(10);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Estadisticas del Equipo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 188, 410, 264);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("JJ:");
		lblNewLabel_5.setBounds(10, 27, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("JG:");
		lblNewLabel_6.setBounds(150, 27, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("JP:");
		lblNewLabel_7.setBounds(288, 27, 46, 14);
		panel.add(lblNewLabel_7);
		
		txtJJ = new JTextField();
		txtJJ.setBackground(Color.WHITE);
		txtJJ.setEditable(false);
		txtJJ.setText(String.valueOf(equipo.getCantJJ()));
		txtJJ.setBounds(10, 52, 86, 22);
		panel.add(txtJJ);
		txtJJ.setColumns(10);
		
		txtJG = new JTextField();
		txtJG.setBackground(Color.WHITE);
		txtJG.setEditable(false);
		txtJG.setText(String.valueOf(equipo.getCantJG()));
		txtJG.setBounds(150, 52, 86, 22);
		panel.add(txtJG);
		txtJG.setColumns(10);
		
		txtJP = new JTextField();
		txtJP.setBackground(Color.WHITE);
		txtJP.setEditable(false);
		txtJP.setText(String.valueOf(equipo.getCantJP()));
		txtJP.setBounds(288, 52, 86, 22);
		panel.add(txtJP);
		txtJP.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("AVG Bateo:");
		lblNewLabel_8.setBounds(106, 85, 114, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("AVG Picheo:");
		lblNewLabel_9.setBounds(258, 85, 104, 14);
		panel.add(lblNewLabel_9);
		
		txtAVGB = new JTextField();
		txtAVGB.setBackground(Color.WHITE);
		txtAVGB.setEditable(false);
		txtAVGB.setText(String.valueOf(equipo.avgEquipoBateo()));
		txtAVGB.setBounds(106, 110, 86, 22);
		panel.add(txtAVGB);
		txtAVGB.setColumns(10);
		
		txtAVGP = new JTextField();
		txtAVGP.setBackground(Color.WHITE);
		txtAVGP.setEditable(false);
		txtAVGP.setText(String.valueOf(equipo.avgEquipoPicheo()));
		txtAVGP.setBounds(258, 110, 86, 22);
		panel.add(txtAVGP);
		txtAVGP.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("CA:");
		lblNewLabel_10.setBounds(10, 140, 46, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Hits:");
		lblNewLabel_11.setBounds(150, 141, 46, 14);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("HR:");
		lblNewLabel_12.setBounds(288, 141, 46, 14);
		panel.add(lblNewLabel_12);
		
		txtCA = new JTextField();
		txtCA.setBackground(Color.WHITE);
		txtCA.setEditable(false);
		txtCA.setText(String.valueOf(equipo.cantCarrerasEquipo()));
		txtCA.setBounds(10, 165, 86, 22);
		panel.add(txtCA);
		txtCA.setColumns(10);
		
		txtHits = new JTextField();
		txtHits.setBackground(Color.WHITE);
		txtHits.setEditable(false);
		txtHits.setText(String.valueOf(equipo.cantHitsEquipo()));
		txtHits.setBounds(150, 165, 86, 22);
		panel.add(txtHits);
		txtHits.setColumns(10);
		
		txtHR = new JTextField();
		txtHR.setBackground(Color.WHITE);
		txtHR.setEditable(false);
		txtHR.setText(String.valueOf(equipo.cantHREquipo()));
		txtHR.setBounds(288, 165, 86, 22);
		panel.add(txtHR);
		txtHR.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Ponches:");
		lblNewLabel_13.setBounds(106, 198, 90, 14);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("BB:");
		lblNewLabel_14.setBounds(258, 198, 78, 14);
		panel.add(lblNewLabel_14);
		
		txtPonches = new JTextField();
		txtPonches.setBackground(Color.WHITE);
		txtPonches.setEditable(false);
		txtPonches.setText(String.valueOf(equipo.cantPonchesEquipo()));
		txtPonches.setBounds(106, 223, 86, 22);
		panel.add(txtPonches);
		txtPonches.setColumns(10);
		
		txtBB = new JTextField();
		txtBB.setBackground(Color.WHITE);
		txtBB.setEditable(false);
		txtBB.setText(String.valueOf(equipo.cantBBEquipo()));
		txtBB.setBounds(258, 223, 86, 22);
		panel.add(txtBB);
		txtBB.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(0, 128, 0));
				cancelButton.setIcon(new ImageIcon(EstadisticasEquipo.class.getResource("/assets/round_done_outline_white_18dp.png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
