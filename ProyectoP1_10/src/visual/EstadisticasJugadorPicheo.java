package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Jugador;
import logico.Picheo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EstadisticasJugadorPicheo extends JDialog {

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
	private JTextField txtwhip;
	private JTextField txtp9il;
	private JTextField txtbb9il;
	private JTextField txtxentlanzadas;
	private JTextField txtponches;
	private JTextField txtbb;
	private JTextField txttbe;
	private JTextField txtHits;
	private JTextField txtapertura;
	private JTextField txtjg;
	private JTextField txtjp;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public EstadisticasJugadorPicheo(Jugador miJugador) {
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
				lblNewLabel_5.setBounds(211, 115, 54, 14);
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
				txtNumeroC.setBounds(132, 111, 62, 22);
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
				JLabel lblNewLabel_9 = new JLabel("Whip:");
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
				txtwhip = new JTextField();
				txtwhip.setEditable(false);
				txtwhip.setText(String.valueOf(((Picheo) jugador).whip()));
				txtwhip.setBounds(132, 57, 86, 20);
				panel.add(txtwhip);
				txtwhip.setColumns(10);
			}
			{
				JLabel lblNewLabel_10 = new JLabel("BB 9IL:");
				lblNewLabel_10.setBounds(10, 88, 46, 14);
				panel.add(lblNewLabel_10);
			}
			{
				JLabel lblNewLabel_11 = new JLabel("Entradas Lanzadas:");
				lblNewLabel_11.setBounds(132, 88, 108, 14);
				panel.add(lblNewLabel_11);
			}
			{
				JLabel lblNewLabel_12 = new JLabel("Ponches 9IL:");
				lblNewLabel_12.setBounds(250, 32, 97, 14);
				panel.add(lblNewLabel_12);
			}
			{
				txtp9il = new JTextField();
				txtp9il.setEditable(false);
				txtp9il.setText(String.valueOf(((Picheo) jugador).ponche9IL()));
				txtp9il.setBounds(250, 57, 86, 20);
				panel.add(txtp9il);
				txtp9il.setColumns(10);
			}
			{
				txtbb9il = new JTextField();
				txtbb9il.setEditable(false);
				txtbb9il.setText(String.valueOf(((Picheo) jugador).bb9IL()));
				txtbb9il.setBounds(10, 113, 86, 20);
				panel.add(txtbb9il);
				txtbb9il.setColumns(10);
			}
			{
				JLabel lblNewLabel_13 = new JLabel("BB:");
				lblNewLabel_13.setBounds(10, 144, 46, 14);
				panel.add(lblNewLabel_13);
			}
			{
				JLabel lblNewLabel_14 = new JLabel("Ponches:");
				lblNewLabel_14.setBounds(250, 88, 46, 14);
				panel.add(lblNewLabel_14);
			}
			{
				txtxentlanzadas = new JTextField();
				txtxentlanzadas.setEditable(false);
				txtxentlanzadas.setText(String.valueOf(((Picheo) jugador).bb9IL()));
				txtxentlanzadas.setBounds(132, 113, 86, 20);
				panel.add(txtxentlanzadas);
				txtxentlanzadas.setColumns(10);
			}
			{
				txtponches = new JTextField();
				txtponches.setEditable(false);
				txtponches.setText(String.valueOf(jugador.getCantPonches()));
				txtponches.setBounds(250, 113, 86, 20);
				panel.add(txtponches);
				txtponches.setColumns(10);
			}
			{
				txtbb = new JTextField();
				txtbb.setEditable(false);
				txtbb.setText(String.valueOf(jugador.getCantBB()));
				txtbb.setBounds(10, 169, 86, 20);
				panel.add(txtbb);
				txtbb.setColumns(10);
			}
			{
				JLabel lblNewLabel_15 = new JLabel("TBE:");
				lblNewLabel_15.setBounds(132, 144, 46, 14);
				panel.add(lblNewLabel_15);
			}
			{
				JLabel lblNewLabel_16 = new JLabel("Hits:");
				lblNewLabel_16.setBounds(250, 144, 46, 14);
				panel.add(lblNewLabel_16);
			}
			{
				txttbe = new JTextField();
				txttbe.setEditable(false);
				txttbe.setText(String.valueOf(((Picheo) jugador).getCantTBE()));
				txttbe.setBounds(132, 169, 86, 20);
				panel.add(txttbe);
				txttbe.setColumns(10);
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
				JLabel lblNewLabel_17 = new JLabel("Aperturas:");
				lblNewLabel_17.setBounds(10, 200, 86, 14);
				panel.add(lblNewLabel_17);
			}
			{
				JLabel lblNewLabel_18 = new JLabel("JG:");
				lblNewLabel_18.setBounds(132, 200, 46, 14);
				panel.add(lblNewLabel_18);
			}
			{
				JLabel lblNewLabel_19 = new JLabel("JP:");
				lblNewLabel_19.setBounds(250, 200, 46, 14);
				panel.add(lblNewLabel_19);
			}
			{
				txtapertura = new JTextField();
				txtapertura.setEditable(false);
				txtapertura.setText(String.valueOf(((Picheo) jugador).getCantAperturas()));
				txtapertura.setBounds(10, 225, 86, 20);
				panel.add(txtapertura);
				txtapertura.setColumns(10);
			}
			{
				txtjg = new JTextField();
				txtjg.setEditable(false);
				txtjg.setText(String.valueOf(((Picheo) jugador).getCantJG()));
				txtjg.setBounds(132, 225, 86, 20);
				panel.add(txtjg);
				txtjg.setColumns(10);
			}
			{
				txtjp = new JTextField();
				txtjp.setEditable(false);
				txtjp.setText(String.valueOf(((Picheo) jugador).getCantJP()));
				txtjp.setBounds(250, 225, 86, 20);
				panel.add(txtjp);
				txtjp.setColumns(10);
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
