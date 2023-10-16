package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MenuForm extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldUserNom;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MenuForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuForm.class.getResource("/Vista/img/WhatsApp Image 2023-09-15 at 1.55.50 PM.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Perfil");
		mntmNewMenuItem.setIcon(new ImageIcon(MenuForm.class.getResource("/Vista/img/icons8-usuario-masculino-en-círculo-16.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Crear Cuenta");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuForm.class.getResource("/Vista/img/icons8-añadir-usuario-masculino-16.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCuenta cc = new CrearCuenta();
				cc.setVisible(true);
				cc.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnNewMenu.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Ir a");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Perfil 1");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuForm.class.getResource("/Vista/img/icons8-usuario-masculino-en-círculo-16.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Perfil 2");
		mntmNewMenuItem_4.setIcon(new ImageIcon(MenuForm.class.getResource("/Vista/img/icons8-usuario-masculino-en-círculo-16.png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Salir");
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuForm.class.getResource("/Vista/img/icons8-salida-de-emergencia-16.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        setVisible(false);
		        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		        ventanaPrincipal.setVisible(true);
		        ventanaPrincipal .setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 12, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBE DE USUARIO REGISTRADO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(82, 11, 291, 19);
		contentPane.add(lblNewLabel);
		
		textFieldUserNom = new JTextField();
		textFieldUserNom.setBackground(new Color(255, 255, 255));
		textFieldUserNom.setEditable(false);
		textFieldUserNom.setToolTipText("");
		textFieldUserNom.setBorder(null);
		textFieldUserNom.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldUserNom.setBounds(124, 65, 180, 20);
		contentPane.add(textFieldUserNom);
		textFieldUserNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Sea Bienvienido Sr(a)");
		lblNewLabel_1.setBounds(124, 41, 180, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEliminarCuenta = new JButton("Eliminar Cuenta");
		btnEliminarCuenta.setIcon(new ImageIcon(MenuForm.class.getResource("/Vista/img/icons8-eliminar-papelera-16.png")));
		btnEliminarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar tu cuenta?", "Confirmación", JOptionPane.YES_NO_OPTION);
		        
		        if (confirmacion == JOptionPane.YES_OPTION) {
		            String usuarioAEliminar = textFieldUserNom.getText();
		            
		            Conexion cn = new Conexion();
		            cn.ConectarBasedeDatos();
		            
		            try {
		                String SQL = "DELETE FROM usuarios WHERE USER_NAME = ?";
		                PreparedStatement preparedStatement = cn.conexion.prepareStatement(SQL);
		                preparedStatement.setString(1, usuarioAEliminar);
		                
		                int rowsAffected = preparedStatement.executeUpdate();
		                
		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(null, "Cuenta eliminada exitosamente");
		                    setVisible(false);
		                    VentanaPrincipal ventanaInicioSesion = new VentanaPrincipal();
		                    //ventanaInicioSesion.setVisible(true);
		                } else {
		                    JOptionPane.showMessageDialog(null, "Error al eliminar la cuenta");
		                }
		            } catch (SQLException e2) {
		                JOptionPane.showMessageDialog(null, e2.getMessage());
		            }
		        }
			}
		});
		btnEliminarCuenta.setBounds(279, 203, 145, 25);
		contentPane.add(btnEliminarCuenta);
		
		
	}

}
