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

import logico.Equipo;
import logico.Torneo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtAnno;
	private JTextField txtManager;
	private JTextField txtEstadio;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public RegEquipo() {
		setTitle("Registrar Equipo");
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
			lblNewLabel_2.setBounds(10, 122, 100, 14);
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
			txtAnno.setBounds(120, 119, 178, 22);
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
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNombre.getText().equalsIgnoreCase("") && !txtCiudad.getText().equalsIgnoreCase("") && !txtManager.getText().equalsIgnoreCase("")&& !txtAnno.getText().equalsIgnoreCase("") && !txtEstadio.getText().equalsIgnoreCase("")){
							Equipo team = new Equipo(txtNombre.getText(), Integer.parseInt(txtAnno.getText().toString()), txtManager.getText(), txtCiudad.getText(), txtEstadio.getText());
							//Torneo.estadio = txtEstadio.getText();
							Torneo.getInstance().insertarEquipo(team);
							
							
							JOptionPane.showMessageDialog(null, "Equipo ''"+txtNombre.getText()+"'' fue registrado satisfectoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
							clear();
						}else{
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
	private void clear() {
		txtNombre.setText("");
		txtCiudad.setText("");
		txtManager.setText("");
		txtAnno.setText("");
		txtEstadio.setText("");
	}
}
