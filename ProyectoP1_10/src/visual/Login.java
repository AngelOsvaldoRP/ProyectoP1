package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import logico.Torneo;
import logico.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

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
					Torneo.getInstance().escribir();
					Torneo.getInstance().leer();
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 243, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(23, 25, 101, 14);
		panel.add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(23, 50, 178, 22);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(23, 94, 101, 14);
		panel.add(lblNewLabel_1);
		
		textPass = new JPasswordField();
		textPass.setBounds(23, 119, 178, 22);
		panel.add(textPass);
		textPass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/assets/round_done_outline_white_18dp.png")));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 0));
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
		btnLogin.setBounds(112, 163, 89, 23);
		panel.add(btnLogin);
		
		
		
	}
}
