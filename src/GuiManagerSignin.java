import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GuiManagerSignin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
    String username;
    String password;
    reader obj1=new reader ();
    private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiManagerSignin frame = new GuiManagerSignin();
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
	public GuiManagerSignin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(25, 70, 99, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(265, 79, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(25, 158, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 156, 96, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					username=textField.getText();
					password=passwordField.getText();
					if(e.getSource()==btnNewButton) {
					    manager currentManager=new manager();

						username=textField.getText();
						password=passwordField.getText();
					    try {
							obj1.readManagers();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    currentManager.setReader(obj1);
					    currentManager=currentManager.validation(username, password);
					    if(currentManager==null) {
							JOptionPane.showMessageDialog(null," you entered an invalid username or password", "error", JOptionPane.PLAIN_MESSAGE);
							
						}
						else {
						      
							GuiManager obj = new GuiManager(currentManager);
							obj.setVisible(true);
						}
						
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(272, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Please enter your username and password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(63, 25, 295, 23);
		contentPane.add(lblNewLabel_2);
	}
}
