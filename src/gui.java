import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					
					
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
	public gui() {
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
		
		JButton btnNewButton = new JButton("Employee");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiEmployee obj=new GuiEmployee();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(30, 130, 160, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiCustomerSigninn obj = new GuiCustomerSigninn ();
				obj.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(244, 130, 160, 41);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblWelcomeToBusstation = new JLabel("welcome to BusStation");
		lblWelcomeToBusstation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcomeToBusstation.setBounds(131, 24, 174, 56);
		frame.getContentPane().add(lblWelcomeToBusstation);
	}
}
