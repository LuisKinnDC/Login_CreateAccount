package Vista;

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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CrearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserReg;
	private JPasswordField passwordFieldRegister;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CrearCuenta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearCuenta.class.getResource("/Vista/img/icons8-añadir-usuario-masculino-16.png")));
		setTitle("CREAR CUENTA");
		setBounds(100, 100, 297, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCrearCuenta.setBounds(68, 11, 142, 21);
		contentPane.add(lblCrearCuenta);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setIcon(new ImageIcon(CrearCuenta.class.getResource("/Vista/img/icons8-usuario-16.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 73, 195, 21);
		contentPane.add(lblNewLabel_1);
		
		textFieldUserReg = new JTextField();
		textFieldUserReg.setColumns(10);
		textFieldUserReg.setBounds(38, 91, 195, 20);
		contentPane.add(textFieldUserReg);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setIcon(new ImageIcon(CrearCuenta.class.getResource("/Vista/img/icons8-contraseña-16.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(38, 122, 195, 21);
		contentPane.add(lblNewLabel_1_1);
		
		passwordFieldRegister = new JPasswordField();
		passwordFieldRegister.setBounds(38, 141, 195, 21);
		contentPane.add(passwordFieldRegister);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setIcon(new ImageIcon(CrearCuenta.class.getResource("/Vista/img/icons8-añadir-usuario-masculino-16.png")));
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Conexion cn = new Conexion();
				String user = textFieldUserReg.getText();
				String passw = passwordFieldRegister.getText();
				cn.ConectarBasedeDatos();

				if (!user.isEmpty() && !passw.isEmpty()) {

				    try {
				        String SQL = "INSERT INTO usuarios (USER_NAME, user_pass) VALUES (?, ?)";
				        PreparedStatement preparedStatement = cn.conexion.prepareStatement(SQL);
				        preparedStatement.setString(1, user);
				        preparedStatement.setString(2, passw);

				        int rowsAffected = preparedStatement.executeUpdate();

				        if (rowsAffected > 0) {
				            JOptionPane.showMessageDialog(null, "Tu cuenta se creo correctamente");
				        } else {
				            JOptionPane.showMessageDialog(null, "Error al insertar datos");
				        }
				    } catch (SQLException e2) {
				        JOptionPane.showMessageDialog(null, e2.getMessage());
				    }
					/*Login lg = new Login();
					lg.setVisible(true);
					lg.setLocationRelativeTo(null);*/
				} else {
				    JOptionPane.showMessageDialog(null, "Los campos de usuario y contraseña no pueden estar en blanco.");
				}

				textFieldUserReg.setText(null);
				passwordFieldRegister.setText(null);
			}
		});
		btnCrearCuenta.setBounds(38, 183, 195, 21);
		contentPane.add(btnCrearCuenta);
	}

}
