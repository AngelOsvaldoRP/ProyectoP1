package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.Juego;
import logico.Torneo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class RegJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEstadio;
	private JTextField txtFecha;
	private JFormattedTextField txtHora;
	private JComboBox cbxEquipoV;
	private JComboBox cbxEquipoL;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public RegJuego() {
		setResizable(false);
		setModal(true);
		setTitle("Registrar Juego");
		setBounds(100, 100, 507, 288);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 477, 194);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipo Visitante:");
		lblNewLabel.setBounds(10, 23, 102, 14);
		panel.add(lblNewLabel);
		
		cbxEquipoV = new JComboBox();
		cbxEquipoV.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		for (int i = 0; i < Torneo.getInstance().getEquipos().size(); i++) {
			cbxEquipoV.addItem(Torneo.getInstance().getEquipos().get(i).getNombre());
			
		}
		cbxEquipoV.setBounds(106, 19, 131, 22);
		panel.add(cbxEquipoV);
		
		JLabel lblNewLabel_1 = new JLabel("Equipo Local:");
		lblNewLabel_1.setBounds(253, 23, 84, 14);
		panel.add(lblNewLabel_1);
		
		cbxEquipoL = new JComboBox();
		cbxEquipoL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEstadio.setText(Torneo.getInstance().buscarEquiporNombre(cbxEquipoL.getSelectedItem().toString()).getEstadio());
			}
		});
		cbxEquipoL.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		
		for (int i = 0; i < Torneo.getInstance().getEquipos().size(); i++) {
			cbxEquipoL.addItem(Torneo.getInstance().getEquipos().get(i).getNombre());
			
		}
		cbxEquipoL.setBounds(333, 19, 131, 22);
		panel.add(cbxEquipoL);
		
		JLabel lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setBounds(216, 59, 68, 14);
		panel.add(lblNewLabel_2);
		
		txtEstadio = new JTextField();
		txtEstadio.setBackground(Color.WHITE);
		txtEstadio.setEditable(false);
		txtEstadio.setBounds(175, 84, 150, 22);
		panel.add(txtEstadio);
		txtEstadio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha del encuentro:");
		lblNewLabel_3.setBounds(10, 138, 119, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setBounds(271, 138, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(121, 135, 140, 22);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		try{
			MaskFormatter Hora= new MaskFormatter("##:##");
			txtHora =new JFormattedTextField(Hora);
		} catch(Exception e){}
		
		txtHora.setBounds(333, 135, 131, 22);
		panel.add(txtHora);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cbxEquipoV.getSelectedIndex()!=0 && cbxEquipoV.getSelectedIndex()!=0 && !txtEstadio.getText().equalsIgnoreCase("") &&
						!txtHora.getText().equalsIgnoreCase("  :  ")){
							if (cbxEquipoV.getSelectedIndex()== cbxEquipoV.getSelectedIndex()){
								JOptionPane.showMessageDialog(null, "Los Equipos no pueden ser iguales", null, JOptionPane.ERROR_MESSAGE, null);
			
							}else{
								Juego juego = null;
								//juego = new Juego(visitante, local, fecha, estadio, hora, true);
								Torneo.getInstance().insertarJuego(juego);
							}
						}else{
						
						JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
