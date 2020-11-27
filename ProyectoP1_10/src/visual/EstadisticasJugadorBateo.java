package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Bateo;
import logico.Jugador;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstadisticasJugadorBateo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Jugador jugador;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtMano;
	private JTextField txtNombreC;
	private JTextField txtIdent;
	private JTextField txtEquipoA;
	private JTextField txtNumeroC;
	private JTextField txtPosicion;
	private JTextField txtavg;
	private JTextField txtobp;
	private JTextField txtslg;
	private JTextField txtops;
	private JTextField txtxbh;
	private JTextField txttb;
	private JTextField txtvp;
	private JTextField txtca;
	private JTextField txtHits;
	private JTextField txthr;
	private JTextField txt2b;
	private JTextField txt3b;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public EstadisticasJugadorBateo(Jugador miJugador) {
		setModal(true);
		setResizable(false);
		setTitle("Estadisticas del jugador:");
		this.jugador= miJugador;
		setBounds(100, 100, 397, 556);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion General del Jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 371, 198);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre completo:");
				lblNewLabel.setBounds(10, 40, 101, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Identificacion:");
				lblNewLabel_1.setBounds(10, 65, 101, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Equipo actual:");
				lblNewLabel_2.setBounds(10, 90, 86, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Numero:");
				lblNewLabel_4.setBounds(10, 115, 116, 14);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Posicion:");
				lblNewLabel_5.setBounds(198, 115, 54, 14);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Peso:");
				lblNewLabel_6.setBounds(10, 140, 46, 14);
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Altura:");
				lblNewLabel_7.setBounds(149, 140, 46, 14);
				panel.add(lblNewLabel_7);
			}
			{
				JLabel lblNewLabel_8 = new JLabel("Mano:");
				lblNewLabel_8.setBounds(275, 140, 46, 14);
				panel.add(lblNewLabel_8);
			}
			{
				txtPeso = new JTextField();
				txtPeso.setEditable(false);
				txtPeso.setText(String.valueOf(jugador.getPeso()));
				txtPeso.setBounds(10, 165, 86, 22);
				panel.add(txtPeso);
				txtPeso.setColumns(10);
			}
			{
				txtAltura = new JTextField();
				txtAltura.setEditable(false);
				txtAltura.setText(String.valueOf(jugador.getAltura()));
				txtAltura.setBounds(149, 165, 86, 22);
				panel.add(txtAltura);
				txtAltura.setColumns(10);
			}
			{
				txtMano = new JTextField();
				txtMano.setEditable(false);
				txtMano.setText(String.valueOf(jugador.getMano()));
				txtMano.setBounds(275, 165, 86, 22);
				panel.add(txtMano);
				txtMano.setColumns(10);
			}
			{
				txtNombreC = new JTextField();
				txtNombreC.setEditable(false);
				txtNombreC.setText(String.valueOf(jugador.getNombre()) +" "+  String.valueOf(jugador.getApellido()));
				txtNombreC.setBounds(132, 36, 229, 22);
				panel.add(txtNombreC);
				txtNombreC.setColumns(10);
			}
			{
				txtIdent = new JTextField();
				txtIdent.setEditable(false);
				txtIdent.setText(String.valueOf(jugador.getIdentificacion()));
				txtIdent.setBounds(132, 61, 229, 22);
				panel.add(txtIdent);
				txtIdent.setColumns(10);
			}
			{
				txtEquipoA = new JTextField();
				txtEquipoA.setEditable(false);
				txtEquipoA.setText(String.valueOf(jugador.getEquipoActual()));
				txtEquipoA.setBounds(132, 86, 229, 22);
				panel.add(txtEquipoA);
				txtEquipoA.setColumns(10);
			}
			{
				txtNumeroC = new JTextField();
				txtNumeroC.setEditable(false);
				txtNumeroC.setText(String.valueOf(jugador.getNumeroCamiseta()));
				txtNumeroC.setBounds(132, 111, 46, 22);
				panel.add(txtNumeroC);
				txtNumeroC.setColumns(10);
			}
			{
				txtPosicion = new JTextField();
				txtPosicion.setEditable(false);
				txtPosicion.setText(String.valueOf(jugador.getPosicion()));
				txtPosicion.setBounds(275, 111, 86, 22);
				panel.add(txtPosicion);
				txtPosicion.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Estadisticas:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 220, 371, 258);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("AVG:");
				lblNewLabel_3.setBounds(10, 32, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_9 = new JLabel("OBP:");
				lblNewLabel_9.setBounds(132, 32, 46, 14);
				panel.add(lblNewLabel_9);
			}
			{
				txtavg = new JTextField();
				txtavg.setEditable(false);
				txtavg.setText(String.valueOf(jugador.avg()));
				txtavg.setBounds(10, 57, 86, 20);
				panel.add(txtavg);
				txtavg.setColumns(10);
			}
			{
				txtobp = new JTextField();
				txtobp.setEditable(false);
				txtobp.setText(String.valueOf(((Bateo) jugador).obp()));
				txtobp.setBounds(132, 57, 86, 20);
				panel.add(txtobp);
				txtobp.setColumns(10);
			}
			{
				JLabel lblNewLabel_10 = new JLabel("OPS:");
				lblNewLabel_10.setBounds(10, 88, 46, 14);
				panel.add(lblNewLabel_10);
			}
			{
				JLabel lblNewLabel_11 = new JLabel("XBH:");
				lblNewLabel_11.setBounds(132, 88, 46, 14);
				panel.add(lblNewLabel_11);
			}
			{
				JLabel lblNewLabel_12 = new JLabel("SLG:");
				lblNewLabel_12.setBounds(250, 32, 46, 14);
				panel.add(lblNewLabel_12);
			}
			{
				txtslg = new JTextField();
				txtslg.setEditable(false);
				txtslg.setText(String.valueOf(((Bateo) jugador).slg()));
				txtslg.setBounds(250, 57, 86, 20);
				panel.add(txtslg);
				txtslg.setColumns(10);
			}
			{
				txtops = new JTextField();
				txtops.setEditable(false);
				txtops.setText(String.valueOf(((Bateo) jugador).ops()));
				txtops.setBounds(10, 113, 86, 20);
				panel.add(txtops);
				txtops.setColumns(10);
			}
			{
				JLabel lblNewLabel_13 = new JLabel("VP:");
				lblNewLabel_13.setBounds(10, 144, 46, 14);
				panel.add(lblNewLabel_13);
			}
			{
				JLabel lblNewLabel_14 = new JLabel("TB:");
				lblNewLabel_14.setBounds(250, 88, 46, 14);
				panel.add(lblNewLabel_14);
			}
			{
				txtxbh = new JTextField();
				txtxbh.setEditable(false);
				txtxbh.setText(String.valueOf(((Bateo) jugador).xbh()));
				txtxbh.setBounds(132, 113, 86, 20);
				panel.add(txtxbh);
				txtxbh.setColumns(10);
			}
			{
				txttb = new JTextField();
				txttb.setEditable(false);
				txttb.setText(String.valueOf(((Bateo) jugador).getCantTB()));
				txttb.setBounds(250, 113, 86, 20);
				panel.add(txttb);
				txttb.setColumns(10);
			}
			{
				txtvp = new JTextField();
				txtvp.setEditable(false);
				txtvp.setText(String.valueOf(((Bateo) jugador).getCantVP()));
				txtvp.setBounds(10, 169, 86, 20);
				panel.add(txtvp);
				txtvp.setColumns(10);
			}
			{
				JLabel lblNewLabel_15 = new JLabel("CA:");
				lblNewLabel_15.setBounds(132, 144, 46, 14);
				panel.add(lblNewLabel_15);
			}
			{
				JLabel lblNewLabel_16 = new JLabel("Hits:");
				lblNewLabel_16.setBounds(250, 144, 46, 14);
				panel.add(lblNewLabel_16);
			}
			{
				txtca = new JTextField();
				txtca.setEditable(false);
				txtca.setText(String.valueOf(((Bateo) jugador).getCantCA()));
				txtca.setBounds(132, 169, 86, 20);
				panel.add(txtca);
				txtca.setColumns(10);
			}
			{
				txtHits = new JTextField();
				txtHits.setEditable(false);
				txtHits.setText(String.valueOf(jugador.getCantHits()));
				txtHits.setBounds(250, 169, 86, 20);
				panel.add(txtHits);
				txtHits.setColumns(10);
			}
			{
				JLabel lblNewLabel_17 = new JLabel("HR:");
				lblNewLabel_17.setBounds(10, 200, 46, 14);
				panel.add(lblNewLabel_17);
			}
			{
				JLabel lblNewLabel_18 = new JLabel("2B:");
				lblNewLabel_18.setBounds(132, 200, 46, 14);
				panel.add(lblNewLabel_18);
			}
			{
				JLabel lblNewLabel_19 = new JLabel("3B:");
				lblNewLabel_19.setBounds(250, 200, 46, 14);
				panel.add(lblNewLabel_19);
			}
			{
				txthr = new JTextField();
				txthr.setEditable(false);
				txthr.setText(String.valueOf(jugador.getCantHR()));
				txthr.setBounds(10, 225, 86, 20);
				panel.add(txthr);
				txthr.setColumns(10);
			}
			{
				txt2b = new JTextField();
				txt2b.setEditable(false);
				txt2b.setText(String.valueOf(((Bateo) jugador).getCant2B()));
				txt2b.setBounds(132, 225, 86, 20);
				panel.add(txt2b);
				txt2b.setColumns(10);
			}
			{
				txt3b = new JTextField();
				txt3b.setEditable(false);
				txt3b.setText(String.valueOf(((Bateo) jugador).getCant3B()));
				txt3b.setBounds(250, 225, 86, 20);
				panel.add(txt3b);
				txt3b.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Aceptar");
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
