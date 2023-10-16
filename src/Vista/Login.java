package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Vista/img/icons8-usuario-16.png")));
		setTitle("INICIAR SESION");
		setBounds(100, 100, 307, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 11, 70, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Vista/img/icons8-usuario-16.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 73, 195, 21);
		contentPane.add(lblNewLabel_1);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(50, 91, 195, 20);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/Vista/img/icons8-llave-16.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(50, 122, 195, 21);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(50, 141, 195, 21);
		contentPane.add(passwordField);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(Login.class.getResource("/Vista/img/icons8-entrar-16.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vo = new VentanaPrincipal();	
				vo.setVisible(false);
				try {
					Conexion cn = new Conexion();
					String user = textFieldUser.getText();
					String passw = passwordField.getText();
					cn.ConectarBasedeDatos();
					
					String SQL = "SELECT ID_USUARIO, USER_NAME FROM usuarios "
							+ "WHERE user_name='"+user+"' AND user_pass='"+passw+"'";
					cn.resultado = cn.sentencia.executeQuery(SQL);
					
					if (cn.resultado.next()) {
						setVisible(false);
						MenuForm menu = new MenuForm();
						menu.textFieldUserNom.setText(""+cn.resultado.getString("user_name"));
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);	
						
					}else {
						JOptionPane.showMessageDialog(null, "Usuario o Contraseña no coinciden!");
						
					}
					
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				textFieldUser.setText(null);
				passwordField.setText(null);
				

			}
		});
		btnIngresar.setBounds(50, 183, 195, 25);
		contentPane.add(btnIngresar);
	}
}
