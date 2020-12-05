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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegJugadorLesionado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcion;
	private JTextField txtNombre;
	private JDateChooser txtCantDias;
	private JComboBox cbxCausa;
	private JTextField textFieldCodLesion;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegJugadorLesionado(Jugador jugador) {
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
				
				txtNombre.setText(jugador.getNombre()+", "+jugador.getApellido());

				txtNombre.setText(jugador.getNombre()+" "+jugador.getApellido());

				txtNombre.setEditable(false);
				txtNombre.setBounds(86, 30, 362, 22);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtCantDias = new JDateChooser();
				txtCantDias.setEnabled(false);
				txtCantDias.getCalendarButton().setEnabled(true);
				txtCantDias.setBounds(122, 143, 182, 22);
				panel.add(txtCantDias);
				
			}
			{
				cbxCausa = new JComboBox();
				cbxCausa.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Fractura", "Molestias", "Desgarre", "Enfermedad", "Esguince"}));
				cbxCausa.setBounds(86, 66, 114, 22);
				panel.add(cbxCausa);
			}
			
			JLabel lblCodigoLesin = new JLabel("Codigo Lesi\u00F3n:");
			lblCodigoLesin.setBounds(210, 69, 94, 14);
			panel.add(lblCodigoLesin);
			
			textFieldCodLesion = new JTextField();
			textFieldCodLesion.setText("L-"+ (Torneo.getInstance().getAutoLesionCode()));
			textFieldCodLesion.setEditable(false);
			textFieldCodLesion.setColumns(10);
			textFieldCodLesion.setBackground(Color.WHITE);
			textFieldCodLesion.setBounds(320, 65, 77, 22);
			panel.add(textFieldCodLesion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Lesionar");
				okButton.setIcon(new ImageIcon(RegJugadorLesionado.class.getResource("/assets/round_flaky_white_18dp.png")));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(0, 128, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cbxCausa.getSelectedIndex() !=0 && !txtDescripcion.getText().equalsIgnoreCase("") &&
								txtCantDias.getCalendar()!=null){
							
							Date fechaActual = StringToDate(getFechaActual());
							Date fechaElegida = txtCantDias.getDate();
							
							if(diferenciasDeFechas(fechaActual, fechaElegida)<0){
								
								JOptionPane.showMessageDialog(null, "La fecha para la cantidad de dias no puede ser pasada", null, JOptionPane.ERROR_MESSAGE, null);
							
							}else{
								Equipo team= Torneo.getInstance().buscarEquiporNombre(jugador.getEquipoActual());
								Lesion lesion = null;
								String causa = cbxCausa.getSelectedItem().toString();
								String descripcion = txtDescripcion.getText();
								String dia = Integer.toString(txtCantDias.getCalendar().get(Calendar.DAY_OF_MONTH));
								String mes = Integer.toString(txtCantDias.getCalendar().get(Calendar.MONTH)+1);
								String anno = Integer.toString(txtCantDias.getCalendar().get(Calendar.YEAR));
								String fecha =(dia+"-"+mes+"-"+anno);
								String estado= "Activa";
								String lesionCod = "L-" + Torneo.getInstance().getAutoLesionCode();
								lesion = new Lesion(lesionCod, causa, descripcion, jugador, estado, fecha);

								team.insertarLesion(lesion);
								jugador.setEstado("Lesionado");
								
								JOptionPane.showMessageDialog(null, "El jugador ya esta lesionado.", null, JOptionPane.INFORMATION_MESSAGE, null);
								dispose();
								ListJugador list = new ListJugador(team);
								list.setModal(true);
								list.setLocationRelativeTo(null);
								list.setVisible(true);
							}
							
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
				cancelButton.setIcon(new ImageIcon(RegJugadorLesionado.class.getResource("/assets/round_clear_white_18dp.png")));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(128, 0, 0));
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
	
	//Metodo usado para obtener la fecha actual
    //Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"
	
	public static String getFechaActual() {
        Date FechaA = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(FechaA);
    }
	
	//Metodo para opbtener la diferencia entre las fechas. Retorna el numero de dias entre dos fechas
	
    public static synchronized int diferenciasDeFechas(Date fechaActual, Date fechaElegida){

        DateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
        
        String fechaActualString = dateFormat.format(fechaActual);
        try {
        	fechaActual = dateFormat.parse(fechaActualString);
        } catch (ParseException ex) {
        }

        String fechaElegidaString = dateFormat.format(fechaElegida);
        try {
        	fechaElegida = dateFormat.parse(fechaElegidaString);
        } catch (ParseException ex) {
        }
  
        long diferencia = fechaElegida.getTime() - fechaActual.getTime();
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
	
	
	//Metodo para devolver un java.util.Date desde un String en formato dd-MM-yyyy
  
    public static synchronized java.util.Date StringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        } 
    }
}
