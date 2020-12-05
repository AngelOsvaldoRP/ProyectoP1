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
import logico.Torneo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BuscarEstadisticasJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField txtNJugador;
	private JComboBox cbxNEquipo;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public BuscarEstadisticasJugador() {
		setTitle("Buscar estadisticas de un jugador");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 370, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 332, 100);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre del Equipo:");
				lblNewLabel.setBounds(10, 21, 137, 14);
				panel.add(lblNewLabel);
			}
			{
				cbxNEquipo = new JComboBox();
				cbxNEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
				cbxNEquipo.setBounds(172, 17, 150, 22);
				for (int i = 0; i < Torneo.getInstance().getEquipos().size(); i++) {
					cbxNEquipo.addItem(( Torneo.getInstance().getEquipos().get(i).getNombre()));
					
				}
				panel.add(cbxNEquipo);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Numero del Jugador:");
				lblNewLabel_1.setBounds(10, 65, 137, 14);
				panel.add(lblNewLabel_1);
			}
			{
				try{
					MaskFormatter mascaral= new MaskFormatter("##");
					mascaral.setPlaceholderCharacter('-');
					txtNJugador =new JFormattedTextField(mascaral);
				} catch(Exception e){}
				txtNJugador.setBounds(172, 61, 86, 22);
				panel.add(txtNJugador);
				txtNJugador.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setIcon(new ImageIcon(BuscarEstadisticasJugador.class.getResource("/assets/round_search_white_18dp.png")));
				btnBuscar.setBackground(new Color(65, 105, 225));
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNJugador.getText().equalsIgnoreCase("--") &&  cbxNEquipo.getSelectedIndex()!=0) {
							Equipo equipo = Torneo.getInstance().buscarEquiporNombre(cbxNEquipo.getSelectedItem().toString());
							if(equipo != null){
								Jugador jugador= equipo.buscarJugadorByNumero(new Integer (txtNJugador.getText()));
								if(jugador != null){
									if(jugador instanceof Bateo) {
										EstadisticasJugadorBateo bat = new EstadisticasJugadorBateo(jugador);
										bat.setModal(true);
										bat.setLocationRelativeTo(null);
										bat.setVisible(true);
										
										clear();
									}
									if(jugador instanceof Picheo) {
										EstadisticasJugadorPicheo pich = new EstadisticasJugadorPicheo(jugador);
										pich.setModal(true);
										pich.setLocationRelativeTo(null);
										pich.setVisible(true);
										
										clear();
									}
									
									
									
									
									
								}else {
									JOptionPane.showMessageDialog(null, "Jugador no encontrado en este equipo", null, JOptionPane.ERROR_MESSAGE, null);
								}
							}
						}else {
							
							JOptionPane.showMessageDialog(null, "Verifique que todos los campos esten llenos", null, JOptionPane.ERROR_MESSAGE, null);
						}
						
								
					}
				});
				btnBuscar.setActionCommand("OK");
				buttonPane.add(btnBuscar);
				getRootPane().setDefaultButton(btnBuscar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(128, 0, 0));
				cancelButton.setIcon(new ImageIcon(BuscarEstadisticasJugador.class.getResource("/assets/round_clear_white_18dp.png")));
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
		txtNJugador.setText("");
		
	}

}
