package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Bateo;
import logico.Equipo;
import logico.Jugador;
import logico.Picheo;
import logico.Torneo;
import logico.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField  textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User usuario= new User("admin", "admin");
					Torneo.getInstance().insertarUser(usuario);
					File archivo = new File("Torneo.dat");
					if (archivo.exists()) {
					Torneo.getInstance().leer();
					}
					else {
						
						Torneo.getInstance().escribir();
					    System.out.println("OJO: ¡¡No existe ningun Torneo!!");
					    System.out.println("Se creara el torneo...");
					}
					
					Torneo.getInstance().leer();
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("El archivo se ha creado");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/assets/unnamed.png")));
		setTitle("Iniciar Sesion");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 414);
		contentPane = new FondoPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JPanel panel = new TransPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(27, 151, 101, 14);
		panel.add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(27, 167, 196, 22);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(27, 220, 101, 14);
		panel.add(lblNewLabel_1);
		
		textPass = new JPasswordField();
		textPass.setBounds(27, 236, 196, 22);
		panel.add(textPass);
		textPass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/assets/round_done_outline_white_18dp.png")));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valorPass = new String(textPass.getPassword());
				if(!textUsuario.getText().equalsIgnoreCase("") && !valorPass.equalsIgnoreCase("")) {
					if(Torneo.getInstance().confirmLogin(textUsuario.getText(),valorPass)){
						Principal frame = new Principal();
						dispose();
						frame.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "Usuario incorrecto", null, JOptionPane.ERROR_MESSAGE, null);

					}
				}else{
					JOptionPane.showMessageDialog(null, "Verifique que todos los campos estén llenos", null, JOptionPane.ERROR_MESSAGE, null);

				}
			}
		});
		btnLogin.setBounds(134, 304, 89, 23);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/assets/lidomlogo.png")));
		lblNewLabel_2.setBounds(52, 11, 142, 154);
		panel.add(lblNewLabel_2);
		
		
		
	}
	
	public class FondoPanel extends JPanel{
		public void paint(Graphics g) {
			ImageIcon icon = new ImageIcon(getClass().getResource("/assets/fondologin.png"));
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
