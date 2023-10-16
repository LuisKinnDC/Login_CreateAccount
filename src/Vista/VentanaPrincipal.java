package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/Vista/img/WhatsApp Image 2023-09-15 at 1.55.50 PM.jpeg")));
		setTitle("VENTANA PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOLA SEA BIENVENIDO!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(110, 11, 198, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Si ya tiene una cuenta puede \"INICIAR SESION\"");
		lblNewLabel_1.setBounds(10, 36, 399, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("y si en caso no, puede \"CREAR UNA CUENTA\"");
		lblNewLabel_2.setBounds(10, 57, 323, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnIngresar = new JButton("INICIAR SESION");
		btnIngresar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Vista/img/icons8-entrar-16.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();	
				lg.setVisible(true);
				lg.setLocationRelativeTo(null);
				
		}
		});
		btnIngresar.setBounds(10, 154, 147, 44);
		contentPane.add(btnIngresar);
		
		JButton btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Vista/img/icons8-añadir-usuario-masculino-16.png")));
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuenta creaC = new CrearCuenta();	
				creaC.setVisible(true);
				creaC.setLocationRelativeTo(null);
				
			}
		});
		btnCrearCuenta.setBounds(262, 154, 147, 44);
		contentPane.add(btnCrearCuenta);
	}

}
