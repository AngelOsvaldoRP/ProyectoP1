package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Bateo;
import logico.Equipo;
import logico.Jugador;
import logico.Picheo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JFormattedTextField txtNumero;
	private JFormattedTextField txtAltura;
	private JFormattedTextField txtPeso;
	private JSpinner spnEdad;
	private JComboBox cbxMano;
	private JComboBox cbxPosicion;
	private JTextField txtIdentificacion;
	private Equipo team;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegJugador(Equipo equipo) {
		this.team= equipo;
		setResizable(false);
		setModal(true);
		setTitle("Registrar jugador");
		setBounds(100, 100, 535, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNombre.getText().equalsIgnoreCase("")&& !txtNumero.getText().equalsIgnoreCase("")&&
								!txtIdentificacion.getText().equalsIgnoreCase("")&& cbxMano.getSelectedIndex()!=0 &&
								!txtAltura.getText().equalsIgnoreCase("#.##")&& !txtPeso.getText().equalsIgnoreCase("###")&&
								cbxPosicion.getSelectedIndex()!=0){
							Jugador player = null;
							String nombre = txtNombre.getText();
							String apellido = txtApellido.getText();
							String identificacion = txtIdentificacion.getText();
							int numero = new Integer (txtNumero.getText().toString());
							String estado = "Disponible";
							int edad = new Integer (spnEdad.getValue().toString());
							String posicion = cbxPosicion.getSelectedItem().toString();
							float altura = new Float(txtAltura.getText());
							float peso = new Float(txtPeso.getText());
							String mano = cbxMano.getSelectedItem().toString();
							
							
							if(posicion == "P") {
								player = new Picheo(nombre, apellido, identificacion, numero, edad,
										estado, posicion, peso, altura,
										 mano);
							}else {
								player = new Bateo(nombre, apellido, identificacion, numero, edad,
										estado, posicion, peso, altura,
										 mano);
							}
							player.setEquipoActual(team.getNombre());
							team.insertarJugador(player);
							JOptionPane.showMessageDialog(null, "El jugador ''" + nombre+"'' se agregó sastifactoriamente.", null, JOptionPane.INFORMATION_MESSAGE, null);
							clean();
							
						}else{
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos estén llenos", null, JOptionPane.INFORMATION_MESSAGE, null);

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
						ListJugador list = new ListJugador(team);
						list.setModal(true);
						list.setLocationRelativeTo(null);
						list.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion del Jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 487, 211);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(10, 33, 66, 14);
				panel.add(lblNewLabel);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(86, 30, 143, 22);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Apellido:");
				lblNewLabel_1.setBounds(239, 33, 66, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtApellido = new JTextField();
				txtApellido.setBounds(315, 30, 162, 22);
				panel.add(txtApellido);
				txtApellido.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Edad:");
				lblNewLabel_2.setBounds(10, 72, 46, 14);
				panel.add(lblNewLabel_2);
			}
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(18, 18, 60, 1));
			spnEdad.setBounds(66, 69, 46, 22);
			panel.add(spnEdad);
			
			try{
				MaskFormatter mascaral= new MaskFormatter("##");
				mascaral.setPlaceholderCharacter('-');
				txtNumero =new JFormattedTextField(mascaral);
			} catch(Exception e){}
			txtNumero.setBounds(86, 112, 46, 22);
			panel.add(txtNumero);
			txtNumero.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Numero:");
			lblNewLabel_3.setBounds(10, 116, 66, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Mano:");
			lblNewLabel_4.setBounds(10, 151, 46, 14);
			panel.add(lblNewLabel_4);
			
			cbxMano = new JComboBox();
			cbxMano.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Derecho", "Izquierdo"}));
			cbxMano.setBounds(66, 151, 138, 22);
			panel.add(cbxMano);
			
			JLabel lblNewLabel_5 = new JLabel("Posicion:");
			lblNewLabel_5.setBounds(239, 151, 66, 14);
			panel.add(lblNewLabel_5);
			
			cbxPosicion = new JComboBox();
			cbxPosicion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "P", "C", "1B", "2B", "3B", "SS", "LF", "CF", "RF", "DH"}));
			cbxPosicion.setBounds(315, 148, 130, 22);
			panel.add(cbxPosicion);
			
			JLabel lblNewLabel_6 = new JLabel("Peso:");
			lblNewLabel_6.setBounds(163, 116, 46, 14);
			panel.add(lblNewLabel_6);
			
			try{
				MaskFormatter mascaral= new MaskFormatter("###");
				mascaral.setPlaceholderCharacter('_');
				txtPeso =new JFormattedTextField(mascaral);
			} catch(Exception e){}
			txtPeso.setBounds(219, 113, 38, 22);
			panel.add(txtPeso);
			txtPeso.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("(Lbs)");
			lblNewLabel_7.setBounds(259, 116, 46, 14);
			panel.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Altura:");
			lblNewLabel_8.setBounds(315, 116, 46, 14);
			panel.add(lblNewLabel_8);
			
			try{
				MaskFormatter mascaral= new MaskFormatter("#.##");
				mascaral.setPlaceholderCharacter('_');
				txtAltura =new JFormattedTextField(mascaral);
			} catch(Exception e){}
			txtAltura.setBounds(380, 113, 38, 22);
			panel.add(txtAltura);
			txtAltura.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("(ft)");
			lblNewLabel_9.setBounds(420, 116, 46, 14);
			panel.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("Identificacion:");
			lblNewLabel_10.setBounds(186, 72, 104, 14);
			panel.add(lblNewLabel_10);
			
			txtIdentificacion = new JTextField();
			txtIdentificacion.setBounds(284, 69, 161, 22);
			panel.add(txtIdentificacion);
			txtIdentificacion.setColumns(10);
		}
	}
	public void clean(){
		txtNombre.setText("");
		txtNumero.setText("");
		txtApellido.setText("");
		txtIdentificacion.setText("");
		txtAltura.setText("");
		txtPeso.setText("");
		cbxPosicion.setSelectedIndex(0);
		cbxMano.setSelectedIndex(0);
		spnEdad.setValue(new Integer(18));
		
	}
}
