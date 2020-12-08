package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Comparator;
import java.awt.image.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;


import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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


import logico.Bateo;
import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;

import javax.swing.JDialog;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.prism.Image;

import java.awt.image.*;

import java.awt.Component;
import javax.swing.UIManager;

//WilliamMMG
public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField fecha_textfield;
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JTable table_1;
	public static DefaultTableModel modelo2;
	Equipo aux;
	private JPanel panel;
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
					
					Torneo.getInstance().buscarEquiporNombre("Las Aguilas Cibaeñas").setCantJG(15);
					Torneo.getInstance().buscarEquiporNombre("Tigres del Licey").setCantJG(1);
					Torneo.getInstance().buscarEquiporNombre("Gigantes del Cibao").setCantJG(5);
					Torneo.getInstance().buscarEquiporNombre("Estrellas Orientales").setCantJG(10);
					Torneo.getInstance().buscarEquiporNombre("Toros del Este").setCantJG(9);
					Torneo.getInstance().buscarEquiporNombre("Leones del Escogido").setCantJG(11);
					
					//Jugadores de Las Aguilas
					Jugador jacb1 = new Bateo("Luis", "Valenzuela", "11111111", 21, 20, "Disponible", "2B", 176, 6, "Derecho");
					Jugador jacb2 = new Bateo("Ronny", "Rodriguez", "22222222", 32, 25, "Disponible", "3B", 176, 6, "Izquierdo");
					Jugador jacb3 = new Bateo("Victor", "Robles", "33333333", 53, 30, "Disponible", "1B", 176, 6, "Derecho");
					Jugador jacb4 = new Bateo("Deivy", "Grullon", "44444444", 14, 35, "Disponible", "SS", 176, 6, "Derecho");
					Jugador jacb5 = new Bateo("Juan Carlos", "Pérez", "55555555", 15, 32, "Disponible", "LF", 176, 6, "Derecho");
					Jugador jacb6 = new Bateo("Arismendy ", "Alcántara", "66666666", 96, 36, "Disponible", "CF", 176, 6, "Derecho");
					Jugador jacb7 = new Bateo("Francisco", "Peña", "77777777", 87, 27, "Disponible", "RF", 176, 6, "Derecho");
					Jugador jacb8 = new Bateo("Johan ", "Camargo", "88888888", 18, 27, "Disponible", "C", 176, 6, "Derecho");
					Jugador jacb9 = new Bateo("Rangel", "Ravelo", "99999999", 19, 26, "Disponible", "2B", 176, 6, "Derecho");
					
					Jugador jacb10 = new Picheo("Michael", "Ynoa", "11112222", 10, 19, "Disponible", "P", 176, 6, "Izquierdo");
					Jugador jacb11 = new Picheo("Ramón", "Rosso", "11113333", 11, 23, "Disponible", "P", 176, 6, "Derecho");
					Jugador jacb12 = new Picheo("Luis", "Castillo", "11114444", 12, 22, "Disponible", "P", 176, 6, "Izquierdo");
					Jugador jacb13 = new Picheo("Jorge", "Martínez", "11115555", 13, 23, "Disponible", "P", 176, 6, "Derecho");
					
					e1.insertarJugador(jacb1);
					e1.insertarJugador(jacb2);
					e1.insertarJugador(jacb3);
					e1.insertarJugador(jacb4);
					e1.insertarJugador(jacb5);
					e1.insertarJugador(jacb6);
					e1.insertarJugador(jacb7);
					e1.insertarJugador(jacb8);
					e1.insertarJugador(jacb9);
					e1.insertarJugador(jacb10);
					e1.insertarJugador(jacb11);
					e1.insertarJugador(jacb12);
					e1.insertarJugador(jacb13);
					
					jacb1.setEquipoActual(e1.getNombre());
					jacb2.setEquipoActual(e1.getNombre());
					jacb3.setEquipoActual(e1.getNombre());
					jacb4.setEquipoActual(e1.getNombre());
					jacb5.setEquipoActual(e1.getNombre());
					jacb6.setEquipoActual(e1.getNombre());
					jacb7.setEquipoActual(e1.getNombre());
					jacb8.setEquipoActual(e1.getNombre());
					jacb9.setEquipoActual(e1.getNombre());
					jacb10.setEquipoActual(e1.getNombre());
					jacb11.setEquipoActual(e1.getNombre());
					jacb12.setEquipoActual(e1.getNombre());
					jacb13.setEquipoActual(e1.getNombre());
					
					Torneo.getInstance().insertarJugador(jacb1);
					Torneo.getInstance().insertarJugador(jacb2);
					Torneo.getInstance().insertarJugador(jacb3);
					Torneo.getInstance().insertarJugador(jacb4);
					Torneo.getInstance().insertarJugador(jacb5);
					Torneo.getInstance().insertarJugador(jacb6);
					Torneo.getInstance().insertarJugador(jacb7);
					Torneo.getInstance().insertarJugador(jacb8);
					Torneo.getInstance().insertarJugador(jacb9);
					Torneo.getInstance().insertarJugador(jacb10);
					Torneo.getInstance().insertarJugador(jacb11);
					Torneo.getInstance().insertarJugador(jacb12);
					Torneo.getInstance().insertarJugador(jacb13);
					
					
					//Jugadores de los Tigres del Licey
					Jugador jtlb1 = new Bateo("Yermín", "Merdeces", "22221111", 45, 20, "Disponible", "2B", 166, 6, "Derecho");
					Jugador jtlb2 = new Bateo("Welington", "Castillo", "22223333", 72, 25, "Disponible", "3B", 186, 6, "Izquierdo");
					Jugador jtlb3 = new Bateo("Vladimir", "Gutierrez", "33331111", 33, 30, "Disponible", "1B", 206, 6, "Derecho");
					Jugador jtlb4 = new Bateo("Sergio", "Alcántara", "44441111", 44, 35, "Disponible", "SS", 176, 6, "Derecho");
					Jugador jtlb5 = new Bateo("Jorge", "Bonifacio", "55551111", 95, 32, "Disponible", "LF", 179, 6, "Derecho");
					Jugador jtlb6 = new Bateo("Jaime", "Barria", "66661111", 26, 36, "Disponible", "CF", 176, 6, "Derecho");
					Jugador jtlb7 = new Bateo("Emilio", "Bonifacio", "77771111", 37, 27, "Disponible", "RF", 176, 6, "Derecho");
					Jugador jtlb8 = new Bateo("Eric", "Mariñez", "88881111", 18, 27, "Disponible", "C", 176, 6, "Derecho");
					Jugador jtlb9 = new Bateo("Fernando", "Cruz", "99999999", 19, 26, "Disponible", "2B", 176, 6, "Derecho");
					
					Jugador jtlb10 = new Picheo("Alberto", "Abreu", "33332222", 20, 19, "Disponible", "P", 176, 6, "Derecho");
					Jugador jtlb11 = new Picheo("Ervin", "Santana", "44443333", 11, 23, "Disponible", "P", 176, 6, "Derecho");
					Jugador jtlb12 = new Picheo("Yeison", "Asencio", "66664444", 12, 22, "Disponible", "P", 176, 6, "Izquierdo");
					Jugador jtlb13 = new Picheo("Jorge", "Martínez", "77775555", 13, 23, "Disponible", "P", 176, 6, "Derecho");
					
					e2.insertarJugador(jtlb1);
					e2.insertarJugador(jtlb2);
					e2.insertarJugador(jtlb3);
					e2.insertarJugador(jtlb4);
					e2.insertarJugador(jtlb5);
					e2.insertarJugador(jtlb6);
					e2.insertarJugador(jtlb7);
					e2.insertarJugador(jtlb8);
					e2.insertarJugador(jtlb9);
					e2.insertarJugador(jtlb10);
					e2.insertarJugador(jtlb11);
					e2.insertarJugador(jtlb12);
					e2.insertarJugador(jtlb13);
					
					jtlb1.setEquipoActual(e2.getNombre());
					jtlb2.setEquipoActual(e2.getNombre());
					jtlb3.setEquipoActual(e2.getNombre());
					jtlb4.setEquipoActual(e2.getNombre());
					jtlb5.setEquipoActual(e2.getNombre());
					jtlb6.setEquipoActual(e2.getNombre());
					jtlb7.setEquipoActual(e2.getNombre());
					jtlb8.setEquipoActual(e2.getNombre());
					jtlb9.setEquipoActual(e2.getNombre());
					jtlb10.setEquipoActual(e2.getNombre());
					jtlb11.setEquipoActual(e2.getNombre());
					jtlb12.setEquipoActual(e2.getNombre());
					jtlb13.setEquipoActual(e2.getNombre());

					Torneo.getInstance().insertarJugador(jtlb1);
					Torneo.getInstance().insertarJugador(jtlb2);
					Torneo.getInstance().insertarJugador(jtlb3);
					Torneo.getInstance().insertarJugador(jtlb4);
					Torneo.getInstance().insertarJugador(jtlb5);
					Torneo.getInstance().insertarJugador(jtlb6);
					Torneo.getInstance().insertarJugador(jtlb7);
					Torneo.getInstance().insertarJugador(jtlb8);
					Torneo.getInstance().insertarJugador(jtlb9);
					Torneo.getInstance().insertarJugador(jtlb10);
					Torneo.getInstance().insertarJugador(jtlb11);
					Torneo.getInstance().insertarJugador(jtlb12);
					Torneo.getInstance().insertarJugador(jtlb13);
					llenarTabla();
					llenarTabla2();
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
		setResizable(false);
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
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_add_black_18dp.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Equipo");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_add_black_18dp.png")));
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
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_add_black_18dp.png")));
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
		mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_view_list_black_18dp.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lista de Equipos");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_view_list_black_18dp.png")));
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
		mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_view_list_black_18dp.png")));
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
		mnNewMenu_2.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_visibility_black_18dp.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem Sitio_web = new JMenuItem("Visita Nuestro sitio web");
		Sitio_web.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_visibility_black_18dp.png")));
		mnNewMenu_2.add(Sitio_web);
		
		JMenu Estadisticas = new JMenu("Estadisticas");
		Estadisticas.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_leaderboard_black_18dp.png")));
		menuBar.add(Estadisticas);
		
		JMenuItem Graficos = new JMenuItem("Graficos de la liga");
		Graficos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Grafico dialog = new Grafico();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			}
		});
		Graficos.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_leaderboard_black_18dp.png")));
		Estadisticas.add(Graficos);
		
		JMenuItem menuItem = new JMenuItem("Buscar Jugador");
		menuItem.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_search_black_18dp.png")));
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
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListTopPlayer dialog = new ListTopPlayer();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				dialog.setModal(true);
				dialog.setLocationRelativeTo(null);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(Principal.class.getResource("/assets/round_leaderboard_black_18dp.png")));
		Estadisticas.add(mntmNewMenuItem_4);
		
		
		
		
		contentPane = new FondoPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new TransPanel();

		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setMaximumSize(new Dimension(32767, 30000));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_position = new TransPanel();
		panel_position.setBackground(Color.WHITE);
		panel_position.setBorder(new TitledBorder(null, "Tabla de posiciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(35);
		columnModel.getColumn(1).setPreferredWidth(151);
		columnModel.getColumn(2).setPreferredWidth(35);
		columnModel.getColumn(3).setPreferredWidth(35);
		columnModel.getColumn(4).setPreferredWidth(41);
		table.setEnabled(false);
		
		JPanel panel_juegosdeldia = new TransPanel();
		panel_juegosdeldia.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Juegos del dia", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
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
		
		JPanel equipos = new TransPanel();
		equipos.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(2, 2, 2, 2)), "Equipos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		equipos.setBounds(10, 402, 919, 182);
		panel.add(equipos);
		equipos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_aguilas = new TransPanel();
		panel_aguilas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_aguilas);
		
		JLabel Logo_aguilas_campeon = new JLabel("");
		panel_aguilas.add(Logo_aguilas_campeon);
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
		
		JPanel panel_licey = new TransPanel();
		panel_licey.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_licey);
		
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
		panel_licey.add(logo_babosos_del_licey);
		logo_babosos_del_licey.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-TL.png")));
		
		JPanel panel_toros = new TransPanel();
		panel_toros.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_toros);
		
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
		panel_toros.add(logo_toros);
		logo_toros.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-TE.png")));
		
		JPanel panel_estrellas = new TransPanel();
		panel_estrellas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_estrellas);
		
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
		panel_estrellas.add(logo_estrellas);
		logo_estrellas.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-ES.png")));
		
		JPanel panel_gigantes = new TransPanel();
		panel_gigantes.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_gigantes);
		
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
		panel_gigantes.add(logo_gigantes);
		logo_gigantes.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-GC.png")));
		
		JPanel panel_escogido = new TransPanel();
		panel_escogido.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_escogido);
		
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
		panel_escogido.add(logo_escojido);
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
		fecha_label.setForeground(Color.WHITE);
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
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane, table, panel_juegosdeldia, scrollPane_1, table_1, equipos, panel_aguilas, Logo_aguilas_campeon, panel_licey, logo_babosos_del_licey, panel_toros, logo_toros, panel_estrellas, logo_estrellas, panel_gigantes, logo_gigantes, panel_escogido, logo_escojido, LogoLidom, fecha_label, fecha_textfield}));
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
	public class FondoPanel extends JPanel{
		public void paint(Graphics g) {
			ImageIcon icon = new ImageIcon(getClass().getResource("/assets/fondo.jpg"));
			g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
					
		}
		
	}
	public class TransPanel extends JPanel{
		public void paint(Graphics g) {
			setOpaque(false);
			super.paint(g);
			
		}
	}
}