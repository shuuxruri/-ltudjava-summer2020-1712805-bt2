package testDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;

public class swing2 {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing2 window = new swing2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public swing2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTiKhon = new JLabel("Tài khoản");
		lblTiKhon.setBounds(74, 104, 54, 17);
		frame.getContentPane().add(lblTiKhon);
		
		username = new JTextField();
		username.setBounds(160, 102, 100, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(74, 135, 54, 17);
		frame.getContentPane().add(lblMtKhu);
		
		password = new JPasswordField();
		password.setBounds(160, 133, 100, 20);
		frame.getContentPane().add(password);
		
		JButton login = new JButton("Đăng nhập");
		login.setBounds(165, 176, 89, 23);
		frame.getContentPane().add(login);
	}
}
