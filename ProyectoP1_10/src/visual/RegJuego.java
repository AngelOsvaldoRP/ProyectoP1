package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import logico.Juego;
import logico.Torneo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;

public class RegJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtEstadio;
	private JFormattedTextField txtHora;
	private JComboBox cbxEquipoV;
	private JComboBox cbxEquipoL;
	private JDateChooser txtFecha;
	
	
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
		setBounds(100, 100, 525, 288);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion para el Juego:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 488, 204);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipo Visitante:");
		lblNewLabel.setBounds(10, 42, 102, 14);
		panel.add(lblNewLabel);
		
		cbxEquipoV = new JComboBox();
		cbxEquipoV.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
		for (int i = 0; i < Torneo.getInstance().getEquipos().size(); i++) {
			cbxEquipoV.addItem(Torneo.getInstance().getEquipos().get(i).getNombre());
			
		}
		cbxEquipoV.setBounds(121, 38, 131, 22);
		panel.add(cbxEquipoV);
		
		JLabel lblNewLabel_1 = new JLabel("Equipo Local:");
		lblNewLabel_1.setBounds(264, 42, 84, 14);
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
		cbxEquipoL.setBounds(347, 38, 131, 22);
		panel.add(cbxEquipoL);
		
		JLabel lblNewLabel_2 = new JLabel("Estadio:");
		lblNewLabel_2.setBounds(219, 84, 68, 14);
		panel.add(lblNewLabel_2);
		
		txtEstadio = new JTextField();
		txtEstadio.setBackground(Color.WHITE);
		txtEstadio.setEditable(false);
		txtEstadio.setBounds(169, 109, 150, 22);
		panel.add(txtEstadio);
		txtEstadio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha del encuentro:");
		lblNewLabel_3.setBounds(10, 167, 140, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hora:");
		lblNewLabel_4.setBounds(315, 167, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtFecha = new JDateChooser();
		txtFecha.getCalendarButton().setForeground(Color.RED);
		txtFecha.setForeground(Color.RED);
		txtFecha.setEnabled(false);
		txtFecha.getCalendarButton().setEnabled(true);
		txtFecha.getCalendarButton().setBackground(Color.WHITE);
		txtFecha.setBackground(Color.BLACK);
		txtFecha.setBounds(138, 167, 167, 22);
		panel.add(txtFecha);
		
		
		try{
			MaskFormatter Hora= new MaskFormatter("##:##");
			txtHora =new JFormattedTextField(Hora);
		} catch(Exception e){}
		
		txtHora.setBounds(371, 167, 46, 22);
		panel.add(txtHora);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cbxEquipoV.getSelectedIndex()!=0 && cbxEquipoV.getSelectedIndex()!=0 && !txtEstadio.getText().equalsIgnoreCase("") &&
						!txtHora.getText().equalsIgnoreCase("  :  ") && txtFecha.getCalendar()!=null ){
							
							Date fechaActual = StringToDate(getFechaActual());
							Date fechaElegida = txtFecha.getDate();
						
							if(diferenciasDeFechas(fechaActual, fechaElegida)<0){
								
								JOptionPane.showMessageDialog(null, "EL juego no puede ser registrado con una fecha pasada", null, JOptionPane.ERROR_MESSAGE, null);
							
							}else{
								
								if (cbxEquipoV.getSelectedIndex()== cbxEquipoL.getSelectedIndex()){
									JOptionPane.showMessageDialog(null, "Los Equipos no pueden ser iguales", null, JOptionPane.ERROR_MESSAGE, null);
			
								}else{
									Juego juego = null;
									String local = cbxEquipoL.getSelectedItem().toString();
									String visitante = cbxEquipoV.getSelectedItem().toString();
									String estadio = txtEstadio.getText();
									String dia = Integer.toString(txtFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
									String mes = Integer.toString(txtFecha.getCalendar().get(Calendar.MONTH)+1);
									String anno = Integer.toString(txtFecha.getCalendar().get(Calendar.YEAR));
									String fecha =(dia+"-"+mes+"-"+anno);
									String hora = txtHora.getText();
									String estado = "En espera";
								
									juego = new Juego(estado, fecha, hora, local, visitante, estadio);
									Torneo.getInstance().insertarJuego(juego);
								
									JOptionPane.showMessageDialog(null, "El juego se registró sastifactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
									clear();
									
								}
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
	public void clear(){
		txtHora.setText("");
		
	}
	
}
