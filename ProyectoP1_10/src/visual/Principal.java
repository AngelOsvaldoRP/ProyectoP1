package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;

import logico.Equipo;
import logico.Juego;
import logico.Torneo;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Window.Type;
import java.awt.ComponentOrientation;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField fecha_textfield;
	private JTable table;
	private Dimension dim;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JTable table_1;
	public static DefaultTableModel modelo2;
	Equipo aux;
	private Panel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					Equipo e1= new Equipo("Las Aguilas Cibaeñas", 1933,"Félix Fermín", "Santiago", "El Valle de la Muerte");
					Equipo e2= new Equipo("Tigres del Licey", 1907,"Luis Sojo", "Santo Domingo", "Sin Casa");
					Equipo e3= new Equipo("Gigantes del Cibao", 1996,"Pipe Urueta", "San Francisco de Macorís.", "Estadio Julián Javier");
					Equipo e4= new Equipo("Estrellas Orientales", 1910,"José Alguacil", "San Pedro de Macoris", "Estadio Tetelo Vargas");
					Equipo e5= new Equipo("Toros del Este", 1983,"Lino Rivera", "La Romana", "Estadio Francisco Micheli");
					Equipo e6= new Equipo("Leones del Escogido", 1921,"Dave Jauss", "Santo Domingo", "Estadio Quisqueya Juan Marichal");
					
					Torneo.getInstance().insertarEquipo(e1);
					Torneo.getInstance().insertarEquipo(e2);
					Torneo.getInstance().insertarEquipo(e3);
					Torneo.getInstance().insertarEquipo(e4);
					Torneo.getInstance().insertarEquipo(e5);
					Torneo.getInstance().insertarEquipo(e6);
					
					Torneo.getInstance().buscarEquiporNombre("Las Aguilas Cibaeñas").setCantJG(1);
					Torneo.getInstance().buscarEquiporNombre("Tigres del Licey").setCantJG(3);
					Torneo.getInstance().buscarEquiporNombre("Gigantes del Cibao").setCantJG(5);
					Torneo.getInstance().buscarEquiporNombre("Estrellas Orientales").setCantJG(10);
					Torneo.getInstance().buscarEquiporNombre("Toros del Este").setCantJG(9);
					Torneo.getInstance().buscarEquiporNombre("Leones del Escogido").setCantJG(11);

					Principal.llenarTabla();
					Principal.llenarTabla2();
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("AWJ Manage League");
		setResizable(true);
		setAutoRequestFocus(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/assets/lidomlogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1284, 716);
		//dim = getToolkit().getScreenSize();
		//super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFocusTraversalPolicyProvider(true);
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Registro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Equipo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegEquipo re = new RegEquipo("Registrar", null);
				re.setVisible(true);
				re.setModal(true);
				re.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Juegos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RegJuego rj = new RegJuego();
			rj.setVisible(true);
			rj.setModal(true);
			rj.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Lista");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lista de Equipos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEquipo le = new ListEquipo();
				le.setVisible(true);
				le.setModal(true);
				le.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Lista de Juegos");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListJuego lj = new ListJuego();
				lj.setModal(true);
				lj.setLocationRelativeTo(null);
				lj.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Informacion");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem Sitio_web = new JMenuItem("Visita Nuestro sitio web");
		mnNewMenu_2.add(Sitio_web);
		
		JMenu Estadisticas = new JMenu("Estadisticas");
		menuBar.add(Estadisticas);
		
		JMenuItem Graficos = new JMenuItem("Graficos de la liga");
		Estadisticas.add(Graficos);
		
		JMenuItem menuItem = new JMenuItem("Buscar Jugador");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarEstadisticasJugador bej = new BuscarEstadisticasJugador();
				bej.setModal(true);
				bej.setLocationRelativeTo(null);
				bej.setVisible(true);
			}
		});
		Estadisticas.add(menuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Top10 - Bateadores/Pitchers");
		Estadisticas.add(mntmNewMenuItem_4);
		
		
		
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new Panel();
		panel.setBounds(0, 53, 1257, 606);
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setMaximumSize(new Dimension(32767, 30000));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_position = new JPanel();
		panel_position.setBorder(new TitledBorder(null, "Tabla de posiciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_position.setBounds(939, 42, 310, 237);
		panel.add(panel_position);
		panel_position.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(null);
		panel_position.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		String[] headers = {"No.", "Equipo","JJ", "JG", "JP"};
		modelo.setColumnIdentifiers(headers);
		table.setModel(modelo);
		
		JPanel panel_juegosdeldia = new JPanel();
		panel_juegosdeldia.setBorder(new TitledBorder(null, "Juegos del dia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_juegosdeldia.setBounds(939, 306, 310, 278);
		panel.add(panel_juegosdeldia);
		panel_juegosdeldia.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setViewportBorder(null);
		panel_juegosdeldia.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		modelo2 = new DefaultTableModel();
		String[] headers2 = {"Local", "Visitante","Estado", "Hora"};
		modelo2.setColumnIdentifiers(headers2);
		table_1.setModel(modelo2);
		
		JPanel equipos = new JPanel();
		equipos.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(2, 2, 2, 2)), "Equipos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		equipos.setBounds(10, 402, 919, 182);
		panel.add(equipos);
		equipos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_1);
		
		JLabel Logo_aguilas_campeon = new JLabel("");
		panel_1.add(Logo_aguilas_campeon);
		Logo_aguilas_campeon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					aux = Torneo.getInstance().buscarEquiporNombre("Las Aguilas Cibaeñas");
					ListJugador listaJugadores = new ListJugador(aux);
					listaJugadores.setModal(true);
					listaJugadores.setLocationRelativeTo(null);
					listaJugadores.setVisible(true);
				} catch (Exception e) {
					System.out.println("Equipo aun no registrado Error: "+e);
				}
			}
		});
		Logo_aguilas_campeon.setToolTipText("Ver equipo");
		Logo_aguilas_campeon.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-AC.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_2);
		
		JLabel logo_babosos_del_licey = new JLabel("");
		logo_babosos_del_licey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aux = Torneo.getInstance().buscarEquiporNombre("Tigres del Licey");
					ListJugador listaJugadores = new ListJugador(aux);
					listaJugadores.setModal(true);
					listaJugadores.setLocationRelativeTo(null);
					listaJugadores.setVisible(true);
				} catch (Exception e2) {
					System.out.println("Equipo aun no registrado Error: "+e2);
				}
			}
		});
		panel_2.add(logo_babosos_del_licey);
		logo_babosos_del_licey.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-TL.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_3);
		
		JLabel logo_toros = new JLabel("");
		logo_toros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aux = Torneo.getInstance().buscarEquiporNombre("Toros del Este");
					ListJugador listaJugadores = new ListJugador(aux);
					listaJugadores.setModal(true);
					listaJugadores.setLocationRelativeTo(null);
					listaJugadores.setVisible(true);
				} catch (Exception e2) {
					System.out.println("Equipo aun no registrado nError: " + e2);
				}
			}
		});
		panel_3.add(logo_toros);
		logo_toros.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-TE.png")));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_4);
		
		JLabel logo_estrellas = new JLabel("");
		logo_estrellas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aux = Torneo.getInstance().buscarEquiporNombre("Estrellas Orientales");
					ListJugador listaJugadores = new ListJugador(aux);
					listaJugadores.setModal(true);
					listaJugadores.setLocationRelativeTo(null);
					listaJugadores.setVisible(true);
				} catch (Exception e2) {
					System.out.println("Equipo aun no registrado Error: "+e2);
				}
			}
		});
		panel_4.add(logo_estrellas);
		logo_estrellas.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-ES.png")));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_5);
		
		JLabel logo_gigantes = new JLabel("");
		logo_gigantes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aux = Torneo.getInstance().buscarEquiporNombre("Gigantes del Cibao");
					ListJugador listaJugadores = new ListJugador(aux);
					listaJugadores.setModal(true);
					listaJugadores.setLocationRelativeTo(null);
					listaJugadores.setVisible(true);
				} catch (Exception e2) {
					System.out.println("Equipo aun no registrado Error: "+e);
				}
			}
		});
		panel_5.add(logo_gigantes);
		logo_gigantes.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-GC.png")));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_6);
		
		JLabel logo_escojido = new JLabel("");
		logo_escojido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					aux = Torneo.getInstance().buscarEquiporNombre("Leones del Escogido");
					ListJugador listaJugadores = new ListJugador(aux);
					listaJugadores.setModal(true);
					listaJugadores.setLocationRelativeTo(null);
					listaJugadores.setVisible(true);
				} catch (Exception e2) {
					System.out.println("Equipo aun no registrado Error: "+e2);
				}
			}
		});
		panel_6.add(logo_escojido);
		logo_escojido.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-EC.png")));
		logo_escojido.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel LogoLidom = new JLabel("");
		LogoLidom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListEquipo le = new ListEquipo();
				le.setVisible(true);
			}
		});
		LogoLidom.setIcon(new ImageIcon(Principal.class.getResource("/assets/logo lidom.png")));
		LogoLidom.setBounds(259, 31, 381, 313);
		panel.add(LogoLidom);
		
		JLabel fecha_label = new JLabel("Fecha Actual:");
		fecha_label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fecha_label.setBounds(1059, 14, 102, 14);
		panel.add(fecha_label);
		
	
		Calendar fecha = new GregorianCalendar();                                 
	    int year = fecha.get(Calendar.YEAR);
	    int mes = 1+fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
		fecha_textfield = new JTextField();
		fecha_textfield.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fecha_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		fecha_textfield.setEditable(false);
		fecha_textfield.setBounds(1163, 11, 86, 20);
		panel.add(fecha_textfield);
		fecha_textfield.setColumns(10);
		fecha_textfield.setText(dia+"/"+mes+"/"+year);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, table, panel_juegosdeldia, scrollPane_1, table_1, equipos, panel_1, Logo_aguilas_campeon, panel_2, logo_babosos_del_licey, panel_3, logo_toros, panel_4, logo_estrellas, panel_5, logo_gigantes, panel_6, logo_escojido, LogoLidom, fecha_label, fecha_textfield}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar}));
		llenarTabla();
		llenarTabla2();
		
	}
	
	
	
	public static void llenarTabla() {
		ArrayList<Equipo> equp=Torneo.getInstance().getEquipos();
		filas = new Object[modelo.getColumnCount()];
		//Ordenando
		Collections.sort(equp, new Comparator<Equipo>() {
			public int compare(Equipo p1, Equipo p2) {
				return new Integer(p1.getCantJG()).compareTo(new Integer(p2.getCantJG()));
			}
		});
		Collections.reverse(equp);
		//Imprimiendo
		int posicion = 1;
		modelo.setRowCount(0);
		for (Equipo equipo : equp) {
			filas[0] = posicion;
			filas[1] = equipo.getNombre();
			filas[2] = equipo.getCantJJ();
			filas[3] = equipo.getCantJG();
			filas[4] = equipo.getCantJP();
			modelo.addRow(filas);
			posicion++;
		}
	}
	
	public static void llenarTabla2() {
		Calendar fecha = new GregorianCalendar();
		int year = fecha.get(Calendar.YEAR);
		int mes = 1+fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		String actual = dia+"/"+mes+"/"+year;
		//"Local", "Visitante","Local Score", "Visitante Score", "Hora"
		modelo2.setRowCount(0);
		filas = new Object[modelo2.getColumnCount()];
		for (Juego juego : Torneo.getInstance().getJuegos()) {
			if(juego.getFecha().equalsIgnoreCase(actual)) {
			filas[0] = juego.getEquipoLocal();
			filas[1] = juego.getEquipoVisitante();
			filas[2] = juego.getEstado();
			filas[3] = juego.getHora();
			modelo2.addRow(filas);
			}
		}
	}
}