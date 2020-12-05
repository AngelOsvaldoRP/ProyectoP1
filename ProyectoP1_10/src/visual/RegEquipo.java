package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Bateo;
import logico.Equipo;
import logico.Jugador;
import logico.Torneo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class RegEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtAnno;
	private JTextField txtManager;
	private JTextField txtEstadio;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public RegEquipo(String modo, Equipo equipo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegEquipo.class.getResource("/assets/lidomlogo.png")));
		if(modo.equalsIgnoreCase("Modificar")){
			setTitle("Modificar Equipo");
		}
		if(modo.equalsIgnoreCase("Registrar")){
			setTitle("Registrar Equipo");
		}
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 340, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion Requerida:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 23, 313, 279);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 27, 60, 14);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Ciudad:");
			lblNewLabel_1.setBounds(10, 72, 60, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("A\u00F1o de fundacion:");
			lblNewLabel_2.setBounds(10, 122, 117, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Manager:");
			lblNewLabel_3.setBounds(10, 167, 60, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Estadio:");
			lblNewLabel_4.setBounds(10, 217, 60, 14);
			panel.add(lblNewLabel_4);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(120, 24, 178, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtCiudad = new JTextField();
			txtCiudad.setBounds(120, 69, 178, 22);
			panel.add(txtCiudad);
			txtCiudad.setColumns(10);
			
			try{
				MaskFormatter year= new MaskFormatter("####");
				txtAnno = new JFormattedTextField(year);
			}catch (Exception e) {} 
			txtAnno.setBounds(137, 119, 161, 22);
			panel.add(txtAnno);
			txtAnno.setColumns(10);
			
			txtManager = new JTextField();
			txtManager.setBounds(120, 164, 178, 22);
			panel.add(txtManager);
			txtManager.setColumns(10);
			
			txtEstadio = new JTextField();
			txtEstadio.setBounds(120, 214, 178, 22);
			panel.add(txtEstadio);
			txtEstadio.setColumns(10);
			
			if(modo.equalsIgnoreCase("Modificar")) {
				txtNombre.setText(equipo.getNombre());
				txtCiudad.setText(equipo.getCiudad());
				txtAnno.setText(String.valueOf(equipo.getYearFundation()));
				txtManager.setText(equipo.getManager());
				txtEstadio.setText(equipo.getEstadio());
				
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(modo.equalsIgnoreCase("Modificar")) {
					btnRegistrar = new JButton("Modificar");
					btnRegistrar.setBackground(new Color(0, 128, 0));
					btnRegistrar.setForeground(new Color(255, 255, 255));
					btnRegistrar.setIcon(new ImageIcon(RegEquipo.class.getResource("/assets/round_save_white_18dp.png")));
				}
				if(modo.equalsIgnoreCase("Registrar")) {
					btnRegistrar = new JButton("Registrar");
					btnRegistrar.setBackground(new Color(0, 128, 0));
					btnRegistrar.setForeground(new Color(255, 255, 255));
					btnRegistrar.setIcon(new ImageIcon(RegEquipo.class.getResource("/assets/round_save_white_18dp.png")));
				}
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(modo.equalsIgnoreCase("Modificar")) {
							if(!txtNombre.getText().equalsIgnoreCase("") && !txtCiudad.getText().equalsIgnoreCase("") && !txtManager.getText().equalsIgnoreCase("")&& !txtAnno.getText().equalsIgnoreCase("") && !txtEstadio.getText().equalsIgnoreCase("")){
								equipo.setNombre(txtNombre.getText());
								equipo.setCiudad(txtCiudad.getText());
								equipo.setYearFundation(Integer.valueOf(txtAnno.getText()));
								equipo.setManager(txtManager.getText());
								equipo.setEstadio(txtEstadio.getText());
								JOptionPane.showMessageDialog(null, "Equipo ''"+txtNombre.getText()+"'' fue registrado satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
								dispose();
							}
							else{
								JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
							}
						}
						if(modo.equalsIgnoreCase("Registrar")) {
							if(!txtNombre.getText().equalsIgnoreCase("") && !txtCiudad.getText().equalsIgnoreCase("") && !txtManager.getText().equalsIgnoreCase("")&& !txtAnno.getText().equalsIgnoreCase("") && !txtEstadio.getText().equalsIgnoreCase("")){
								Equipo aux1= Torneo.getInstance().buscarEquiporNombre(txtNombre.getText());
								if(aux1== null) {
									Equipo team = new Equipo(txtNombre.getText(), Integer.parseInt(txtAnno.getText().toString()), txtManager.getText(), txtCiudad.getText(), txtEstadio.getText());
									Torneo.getInstance().insertarEquipo(team);
									JOptionPane.showMessageDialog(null, "Equipo ''"+txtNombre.getText()+"'' fue registrado satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
									Principal.llenarTabla();
									Principal.llenarTabla2();
									clear();
								}else {
									JOptionPane.showMessageDialog(null, "No se pueden registrar dos equipos con el mismo nombre", null, JOptionPane.ERROR_MESSAGE, null);
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
							}
						}
						
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(139, 0, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setIcon(new ImageIcon(RegEquipo.class.getResource("/assets/round_clear_white_18dp.png")));
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
	private void clear() {
		txtNombre.setText("");
		txtCiudad.setText("");
		txtManager.setText("");
		txtAnno.setText("");
		txtEstadio.setText("");
	}
}
