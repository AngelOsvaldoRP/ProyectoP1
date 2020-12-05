package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Juego;
import logico.Torneo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static DefaultTableModel modelo;
	public static Object[] filas;
	private String identificador;
	private JButton btnJugar;
	private JButton btnInformacion;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListJuego dialog = new ListJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListJuego() {
		setBounds(100, 100, 658, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Calendario de Juegos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 622, 258);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 24, 602, 223);
			panel.add(scrollPane);
			
			modelo = new DefaultTableModel();
			String[] headers = {"No.","Equipo Local","Equipo Visitante","Estadio","Fecha","Hora","Estado"};
			modelo.setColumnIdentifiers(headers);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int seleccion= table.getSelectedRow();
					if(seleccion!=-1) {
						btnEliminar.setEnabled(true);
						btnJugar.setEnabled(true);
						btnInformacion.setEnabled(true);
						identificador = (String)table.getModel().getValueAt(seleccion, 0);
					}
				}
			});
			llenarCalendariodeJuegos();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnJugar = new JButton("Jugar");
				btnJugar.setEnabled(false);
				btnJugar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SimulacionJuego jugando = new SimulacionJuego(Torneo.getInstance().buscarJuegoPorCodigo(identificador));
						jugando.setModal(true);
						jugando.setLocationRelativeTo(null);
						jugando.setVisible(true);
					}
				});
				buttonPane.add(btnJugar);
			}
			{
				btnInformacion = new JButton("Informacion");
				btnInformacion.setEnabled(false);
				btnInformacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				buttonPane.add(btnInformacion);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Juego juego = Torneo.getInstance().buscarJuegoPorCodigo(identificador);
						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar el juego numero: " + juego.getJuegoCod() , null, JOptionPane.YES_NO_OPTION);
							if (delete == JOptionPane.YES_OPTION) {
							    Torneo.getInstance().eliminarJuego(identificador);
							    llenarCalendariodeJuegos();
							    btnEliminar.setEnabled(false);
							}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
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
	
	public static void llenarCalendariodeJuegos() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for (Juego game : Torneo.getInstance().getJuegos()) 	
		{
			filas[0] = game.getJuegoCod();
			filas[1] = game.getEquipoLocal();
			filas[2] = game.getEquipoVisitante();
			filas[3] = game.getEstadio();
			filas[4] = game.getFecha();
			filas[5] = game.getHora();
			filas[6] = game.getEstado();
			
			modelo.addRow(filas);
	
		}	
		table.setModel(modelo);
		
	}
	
	
}
