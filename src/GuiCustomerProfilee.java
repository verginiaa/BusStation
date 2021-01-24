import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiCustomerProfilee extends JFrame {
	//private static final Object Name = null;
	customer currentCustomer = new customer() ;
	/*public void setCurrentCustomer (customer currentCustomer) {
		this.currentCustomer=currentCustomer;
		System.out.println(this.currentCustomer.getName());
	}*/

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCustomerProfilee frame = new GuiCustomerProfilee();
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
	public GuiCustomerProfilee() {
		
	}
	
	public GuiCustomerProfilee(customer currentCustomer) {
		this.currentCustomer=currentCustomer;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String str=this.currentCustomer.getName();
		System.out.println(str);
		JLabel lblName = new JLabel(str);
		lblName.setBounds(20, 11, 48, 14);
		contentPane.add(lblName);
		
		JLabel lblSelectWhatYou = new JLabel("Select what you want to do");
		lblSelectWhatYou.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectWhatYou.setBounds(161, 35, 220, 37);
		contentPane.add(lblSelectWhatYou);
		
		JButton btnNewButton = new JButton("Review");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				e.getSource();
				GuiCustomerReview obj = new GuiCustomerReview(currentCustomer);
				obj.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(285, 92, 111, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiCustomerSearch obj=new GuiCustomerSearch(currentCustomer);
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(285, 157, 111, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiCustomerCancel obj=new GuiCustomerCancel(currentCustomer);
				obj.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(285, 213, 111, 37);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Review your profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(83, 96, 111, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add a trip");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(100, 161, 111, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cancel a trip");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(100, 212, 111, 37);
		contentPane.add(lblNewLabel_2);
	}
}
