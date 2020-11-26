package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Torneo;

public class ListEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JButton btnModificar;
	private JButton btnEliminar;
	public Equipo aux = null;
	private JButton btnVerLesionados;
	private JButton btnVerEstadisticas;
	private JButton btnVerJugadores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEquipo frame = new ListEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the dialog.
	 *
	 */
	public ListEquipo() {
		setTitle("Listado de Equipos en la Liga");
		setModal(true);
		setBounds(100, 100, 747, 379);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"Nombre", "Manager", "Estadio", "Año de Fundación"};
					modelo.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1) {
								btnVerLesionados.setEnabled(true);
								btnVerEstadisticas.setEnabled(true);
								btnVerJugadores.setEnabled(true);
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
								aux = Torneo.getInstance().buscarEquiporNombre((String)modelo.getValueAt(seleccion, 0));
								Torneo.nombreE = (String)modelo.getValueAt(seleccion, 0);
							}
						}
					});
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegEquipo re = new RegEquipo("Modificar", aux);
						re.setVisible(true);
						re.setModal(true);
						re.setLocationRelativeTo(null);
					}
				});
				{
					
					btnVerLesionados = new JButton("Ver Lesionados");
					btnVerLesionados.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListLesionado listaLesionados = new ListLesionado(aux);
							listaLesionados.setModal(true);
							listaLesionados.setLocationRelativeTo(null);
							listaLesionados.setVisible(true);
						}
					});
					btnVerLesionados.setEnabled(false);
					btnVerLesionados.setActionCommand("OK");
					buttonPane.add(btnVerLesionados);
				}
				{
					btnVerEstadisticas = new JButton("Ver Estadisticas");
					btnVerEstadisticas.setEnabled(false);
					btnVerEstadisticas.setActionCommand("OK");
					buttonPane.add(btnVerEstadisticas);
				}
				{
					btnVerJugadores = new JButton("Ver Jugadores");
					btnVerJugadores.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListJugador listaJugadores = new ListJugador(aux);
							listaJugadores.setModal(true);
							listaJugadores.setLocationRelativeTo(null);
							listaJugadores.setVisible(true);
						}
					});
					btnVerJugadores.setEnabled(false);
					btnVerJugadores.setActionCommand("OK");
					buttonPane.add(btnVerJugadores);
				}
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux!=null) {
							int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar al equipo: "+aux.getNombre(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
							if(option == JOptionPane.OK_OPTION) {
								Torneo.getInstance().eliminarEquipo(aux);
								llenarTabla();
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		llenarTabla();
	}

	public static void llenarTabla() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for (Equipo equipo : Torneo.getInstance().getEquipos()) {
			filas[0] = equipo.getNombre();
			filas[1] = equipo.getManager();
			filas[2] = equipo.getEstadio();
			filas[3] = equipo.getYearFundation();
			modelo.addRow(filas);
		}
		
	}

}
