import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GuiCustomerSigninn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	String name;
	String password;
	reader obj1= new reader ();
	//customer currentcustomer = new customer();
	//customer currentcustomervalidate = new customer();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCustomerSigninn frame = new GuiCustomerSigninn();
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
	public GuiCustomerSigninn() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblPleaseEnterYour = new JLabel("Please enter your name and password");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseEnterYour.setBounds(34, 26, 290, 14);
		contentPane.add(lblPleaseEnterYour);
		
		JLabel lblName = new JLabel("User Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(68, 76, 92, 14);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(68, 137, 78, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
	
		textField.setBounds(163, 74, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(163, 135, 96, 20);
		contentPane.add(passwordField);
		
		JButton btnSignIn = new JButton("login");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSignIn) {
					name=textField.getText();
					password=passwordField.getText();
					customer currentcustomer = new customer();

			
					currentcustomer=currentcustomer.validation(name, password);
					if(currentcustomer==null) {
						JOptionPane.showMessageDialog(null," you entered an invalid username or password", "error", JOptionPane.PLAIN_MESSAGE);
						
					}
					else {
						GuiCustomerProfilee obj = new GuiCustomerProfilee(currentcustomer);
						obj.setVisible(true);
					}
					
					
				}
				
			}
		});
		btnSignIn.setBounds(264, 184, 118, 35);
		contentPane.add(btnSignIn);
	}

}
