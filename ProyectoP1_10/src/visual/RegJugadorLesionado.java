package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import logico.Equipo;
import logico.Jugador;
import logico.Lesion;
import logico.Torneo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class RegJugadorLesionado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcion;
	private JTextField txtNombre;
	private JDateChooser txtCantDias;
	private JComboBox cbxCausa;
	private Equipo equip;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegJugadorLesionado(Equipo team) {
		this.equip=team;
		setTitle("Lesionar Jugador");
		setResizable(false);
		setBounds(100, 100, 493, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion Requerida:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 458, 183);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(10, 33, 57, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Causa:");
				lblNewLabel_1.setBounds(10, 69, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Descripcion:");
				lblNewLabel_2.setBounds(10, 108, 77, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Cantidad de Dias:");
				lblNewLabel_3.setBounds(10, 146, 102, 14);
				panel.add(lblNewLabel_3);
			}
			{
				txtDescripcion = new JTextField();
				txtDescripcion.setBounds(86, 104, 362, 22);
				panel.add(txtDescripcion);
				txtDescripcion.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBackground(Color.WHITE);
				
				Jugador aux= Torneo.getInstance().buscarJugadorNombreEJ(Torneo.nombreE, Torneo.nombreJ);
				txtNombre.setText(aux.getNombre()+", "+aux.getApellido());
				txtNombre.setEditable(false);
				txtNombre.setBounds(86, 30, 362, 22);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtCantDias = new JDateChooser();
				txtCantDias.setEnabled(false);
				txtCantDias.getCalendarButton().setEnabled(true);
				txtCantDias.setBounds(122, 143, 86, 22);
				panel.add(txtCantDias);
				
			}
			{
				cbxCausa = new JComboBox();
				cbxCausa.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
				cbxCausa.setBounds(86, 66, 114, 22);
				panel.add(cbxCausa);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Lesionar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cbxCausa.getSelectedIndex() !=0 && !txtDescripcion.getText().equalsIgnoreCase("") &&
								txtCantDias.getCalendar()!=null){
							
							Equipo team= Torneo.getInstance().buscarEquiporNombre(equip.getNombre());
							Lesion lesion = null;
							
							String causa = cbxCausa.getSelectedItem().toString();
							String descripcion = txtDescripcion.getText();
							String dia = Integer.toString(txtCantDias.getCalendar().get(Calendar.DAY_OF_MONTH));
							String mes = Integer.toString(txtCantDias.getCalendar().get(Calendar.MONTH)+1);
							String anno = Integer.toString(txtCantDias.getCalendar().get(Calendar.YEAR));
							String fecha =(dia+"-"+mes+"-"+anno);
							Jugador player= Torneo.getInstance().buscarJugadorNombreEJ(Torneo.nombreE, Torneo.nombreJ);
							String estado= "Activa";
							lesion = new Lesion(causa, descripcion, player, estado, fecha);
							
							team.insertarLesion(lesion);
							player.setEstado("Lesionado");
							
							JOptionPane.showMessageDialog(null, "El jugador ya esta lesionado.", null, JOptionPane.INFORMATION_MESSAGE, null);
							dispose();
							ListJugador list = new ListJugador(team);
							list.setModal(true);
							list.setLocationRelativeTo(null);
							list.setVisible(true);
							
						}else{
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos est�n llenos", null, JOptionPane.INFORMATION_MESSAGE, null);
						
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