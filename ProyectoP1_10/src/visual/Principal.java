package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	private JPanel contentPane;
	private JTextField fecha_textfield;
	private JTable table;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
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
		setResizable(false);
		setAutoRequestFocus(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\assets\\Logo-AC.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1397, 744);
		dim = getToolkit().getScreenSize();
		super.setSize(dim.width, dim.height-50);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Buscar Jugador");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				BuscarEstadisticasJugador bej = new BuscarEstadisticasJugador();
				bej.setVisible(true);
				bej.setModal(true);
				bej.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Visita Nuestro sitio web");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(5, 5, 1381, 684);
		panel.setSize(dim.width, dim.height-50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_position = new JPanel();
		panel_position.setBorder(new TitledBorder(null, "Tabla de posiciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_position.setBounds(1032, 94, 310, 237);
		panel.add(panel_position);
		panel_position.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		panel_position.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_juegosdeldia = new JPanel();
		panel_juegosdeldia.setBorder(new TitledBorder(null, "Juegos del dia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_juegosdeldia.setBounds(1032, 358, 310, 278);
		panel.add(panel_juegosdeldia);
		panel_juegosdeldia.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		panel_juegosdeldia.add(scrollPane_1);
		
		JPanel equipos = new JPanel();
		equipos.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(171, 173, 179)), new EmptyBorder(2, 2, 2, 2)), "Equipos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		equipos.setBounds(10, 454, 919, 182);
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
				JOptionPane.showMessageDialog(null, "El cliente existe", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		Logo_aguilas_campeon.setToolTipText("Ver equipo");
		Logo_aguilas_campeon.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-AC.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_2);
		
		JLabel logo_babosos_del_licey = new JLabel("");
		panel_2.add(logo_babosos_del_licey);
		logo_babosos_del_licey.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-TL.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_3);
		
		JLabel logo_toros = new JLabel("");
		panel_3.add(logo_toros);
		logo_toros.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-TE.png")));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_4);
		
		JLabel logo_estrellas = new JLabel("");
		panel_4.add(logo_estrellas);
		logo_estrellas.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-ES.png")));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_5);
		
		JLabel logo_gigantes = new JLabel("");
		panel_5.add(logo_gigantes);
		logo_gigantes.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-GC.png")));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		equipos.add(panel_6);
		
		JLabel logo_escojido = new JLabel("");
		panel_6.add(logo_escojido);
		logo_escojido.setIcon(new ImageIcon(Principal.class.getResource("/assets/Logo-EC.png")));
		logo_escojido.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel LogoLidom = new JLabel("");
		LogoLidom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		LogoLidom.setIcon(new ImageIcon(Principal.class.getResource("/assets/logo lidom.png")));
		LogoLidom.setBounds(259, 83, 381, 313);
		panel.add(LogoLidom);
		
		JLabel fecha_label = new JLabel("Fecha Actual:");
		fecha_label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fecha_label.setBounds(1152, 66, 102, 14);
		panel.add(fecha_label);
		
	
		Calendar fecha = new GregorianCalendar();                                 
	    int year = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    
		fecha_textfield = new JTextField();
		fecha_textfield.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		fecha_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		fecha_textfield.setEditable(false);
		fecha_textfield.setBounds(1256, 63, 86, 20);
		panel.add(fecha_textfield);
		fecha_textfield.setColumns(10);
		fecha_textfield.setText(dia+"/"+mes+"/"+year);
		
		
		
	}
}


