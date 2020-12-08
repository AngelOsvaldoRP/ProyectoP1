package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Juego;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCarrerasGanador;
	private JTextField textHitsGanador;
	private JTextField textErroresGanador;
	private JTextField textCarrerasPerdedor;
	private JTextField textHitsPerdedor;
	private JTextField textErroresPerdedor;
	private JTextField textFecha;
	private JTextField textEstado;
	private JTextField textHora;
	private JTextField textEstadio;
	private JTextField textVisitante;
	private JTextField textLocal;

	/**
	 * Launch the application.
	 *

	/**
	 * Create the dialog.
	 */
	public InformacionJuego(Juego juego) {
		setTitle("Informacion Juego");
		setBounds(100, 100, 421, 477);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelResultadosJuego = new JPanel();
				panelResultadosJuego.setBorder(new TitledBorder(null, "Resultados Partido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelResultadosJuego.setBounds(10, 207, 362, 177);
				panel.add(panelResultadosJuego);
				panelResultadosJuego.setLayout(null);
				{
					JPanel panel_1_1 = new JPanel();
					panel_1_1.setBounds(10, 20, 161, 146);
					panelResultadosJuego.add(panel_1_1);
					panel_1_1.setLayout(null);
					panel_1_1.setBorder(new TitledBorder(null, "Equipo Ganador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					{
						JLabel label = new JLabel((String) null);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							label.setText(juego.getEquipoganador());
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							label.setText("No determinado");
						}
						
						label.setBounds(10, 21, 141, 14);
						panel_1_1.add(label);
					}
					{
						JLabel label = new JLabel("Carreras:");
						label.setBounds(10, 46, 63, 14);
						panel_1_1.add(label);
					}
					{
						textCarrerasGanador = new JTextField();
						textCarrerasGanador.setEditable(false);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							if(juego.getGanador().equalsIgnoreCase("Local")) {
								textCarrerasGanador.setText(""+juego.getCarrerasLocal());
							}
							if(juego.getGanador().equalsIgnoreCase("Visitante")) {
								textCarrerasGanador.setText(""+juego.getCarrerasVisitante());
							}
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							textCarrerasGanador.setText("");
						}
						textCarrerasGanador.setColumns(10);
						textCarrerasGanador.setBounds(70, 43, 37, 23);
						panel_1_1.add(textCarrerasGanador);
					}
					{
						JLabel label = new JLabel("Hits:");
						label.setBounds(10, 76, 63, 14);
						panel_1_1.add(label);
					}
					{
						textHitsGanador = new JTextField();
						textHitsGanador.setEditable(false);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							if(juego.getGanador().equalsIgnoreCase("Local")) {
								textHitsGanador.setText(""+juego.getHitsLocal());
							}
							if(juego.getGanador().equalsIgnoreCase("Visitante")) {
								textHitsGanador.setText(""+juego.getHitsVisitante());
							}
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							textHitsGanador.setText("");
						}
						textHitsGanador.setColumns(10);
						textHitsGanador.setBounds(70, 73, 37, 23);
						panel_1_1.add(textHitsGanador);
					}
					{
						JLabel label = new JLabel("Errores:");
						label.setBounds(10, 104, 63, 14);
						panel_1_1.add(label);
					}
					{
						textErroresGanador = new JTextField();
						textErroresGanador.setEditable(false);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							if(juego.getGanador().equalsIgnoreCase("Local")) {
								textErroresGanador.setText(""+juego.getErroresLocal());
							}
							if(juego.getGanador().equalsIgnoreCase("Visitante")) {
								textErroresGanador.setText(""+juego.getErroresVisitante());
							}
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							textErroresGanador.setText("");
						}
						textErroresGanador.setColumns(10);
						textErroresGanador.setBounds(70, 101, 37, 23);
						panel_1_1.add(textErroresGanador);
					}
					{
						JLabel labelGanador = new JLabel((String) null);
						labelGanador.setBounds(10, 21, 141, 14);
						panel_1_1.add(labelGanador);
					}
				}
				{
					JPanel panel_1_1 = new JPanel();
					panel_1_1.setBounds(191, 20, 161, 146);
					panelResultadosJuego.add(panel_1_1);
					panel_1_1.setLayout(null);
					panel_1_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipo Perdedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					{
						JLabel label = new JLabel((String) null);
						label.setBounds(10, 21, 141, 14);
						panel_1_1.add(label);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							label.setText(juego.getEquipoPerdedor());
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							label.setText("No determinado");
						}
					}
					{
						JLabel label = new JLabel("Carreras:");
						label.setBounds(10, 46, 63, 14);
						panel_1_1.add(label);
					}
					{
						textCarrerasPerdedor = new JTextField();
						textCarrerasPerdedor.setEditable(false);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							if(juego.getPerdedor().equalsIgnoreCase("Local")) {
								textCarrerasPerdedor.setText(""+juego.getCarrerasLocal());
							}
							if(juego.getPerdedor().equalsIgnoreCase("Visitante")) {
								textCarrerasPerdedor.setText(""+juego.getCarrerasVisitante());
							}
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							textCarrerasPerdedor.setText("");
						}
						textCarrerasPerdedor.setColumns(10);
						textCarrerasPerdedor.setBounds(70, 43, 37, 23);
						panel_1_1.add(textCarrerasPerdedor);
					}
					{
						JLabel label = new JLabel("Hits:");
						label.setBounds(10, 76, 63, 14);
						panel_1_1.add(label);
					}
					{
						textHitsPerdedor = new JTextField();
						textHitsPerdedor.setEditable(false);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							if(juego.getPerdedor().equalsIgnoreCase("Local")) {
								textHitsPerdedor.setText(""+juego.getHitsLocal());
							}
							if(juego.getPerdedor().equalsIgnoreCase("Visitante")) {
								textHitsPerdedor.setText(""+juego.getHitsVisitante());
							}
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							textHitsPerdedor.setText("");
						}
						textHitsPerdedor.setColumns(10);
						textHitsPerdedor.setBounds(70, 73, 37, 23);
						panel_1_1.add(textHitsPerdedor);
					}
					{
						JLabel label = new JLabel("Errores:");
						label.setBounds(10, 104, 63, 14);
						panel_1_1.add(label);
					}
					{
						textErroresPerdedor = new JTextField();
						textErroresPerdedor.setEditable(false);
						if(juego.getEstado().equalsIgnoreCase("Jugado")) {
							if(juego.getPerdedor().equalsIgnoreCase("Local")) {
								textErroresPerdedor.setText(""+juego.getErroresLocal());
							}
							if(juego.getGanador().equalsIgnoreCase("Visitante")) {
								textErroresPerdedor.setText(""+juego.getErroresVisitante());
							}
						}
						if(juego.getEstado().equalsIgnoreCase("En espera")) {
							textErroresPerdedor.setText("");
						}
						textErroresPerdedor.setColumns(10);
						textErroresPerdedor.setBounds(70, 101, 37, 23);
						panel_1_1.add(textErroresPerdedor);
					}
					{
						JLabel labelPerdedor = new JLabel((String) null);
						labelPerdedor.setBounds(10, 21, 141, 14);
						panel_1_1.add(labelPerdedor);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 11, 375, 177);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Fecha:");
					lblNewLabel.setBounds(10, 11, 85, 23);
					panel_1.add(lblNewLabel);
				}
				{
					JLabel lblEquipoVisitante = new JLabel("Equipo Visitante:");
					lblEquipoVisitante.setBounds(10, 79, 108, 23);
					panel_1.add(lblEquipoVisitante);
				}
				{
					JLabel lblEquipoLocal = new JLabel("Equipo Local:");
					lblEquipoLocal.setBounds(10, 113, 108, 23);
					panel_1.add(lblEquipoLocal);
				}
				{
					JLabel lblHora = new JLabel("Hora:");
					lblHora.setBounds(184, 11, 51, 23);
					panel_1.add(lblHora);
				}
				{
					JLabel lblEstado = new JLabel("Estado:");
					lblEstado.setBounds(10, 45, 51, 23);
					panel_1.add(lblEstado);
				}
				{
					JLabel lblEstadio = new JLabel("Estadio:");
					lblEstadio.setBounds(184, 45, 51, 23);
					panel_1.add(lblEstadio);
				}
				{
					textFecha = new JTextField();
					textFecha.setEditable(false);
					textFecha.setText(juego.getFecha());
					textFecha.setColumns(10);
					textFecha.setBounds(81, 11, 93, 23);
					panel_1.add(textFecha);
				}
				{
					textEstado = new JTextField();
					textEstado.setEditable(false);
					textEstado.setText(juego.getEstado());
					textEstado.setColumns(10);
					textEstado.setBounds(81, 45, 93, 23);
					panel_1.add(textEstado);
				}
				{
					textHora = new JTextField();
					textHora.setEditable(false);
					textHora.setText(juego.getHora());
					textHora.setColumns(10);
					textHora.setBounds(237, 11, 64, 23);
					panel_1.add(textHora);
				}
				{
					textEstadio = new JTextField();
					textEstadio.setEditable(false);
					textEstadio.setText(juego.getEstadio());
					textEstadio.setColumns(10);
					textEstadio.setBounds(237, 45, 125, 23);
					panel_1.add(textEstadio);
				}
				{
					textVisitante = new JTextField();
					textVisitante.setEditable(false);
					textVisitante.setText(juego.getEquipoVisitante());
					textVisitante.setColumns(10);
					textVisitante.setBounds(108, 80, 244, 23);
					panel_1.add(textVisitante);
				}
				{
					textLocal = new JTextField();
					textLocal.setEditable(false);
					textLocal.setText(juego.getEquipoLocal());
					textLocal.setColumns(10);
					textLocal.setBounds(108, 113, 244, 23);
					panel_1.add(textLocal);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
