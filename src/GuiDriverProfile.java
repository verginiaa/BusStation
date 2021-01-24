import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

public class GuiDriverProfile extends JFrame {

	private JPanel contentPane;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiDriverProfile frame = new GuiDriverProfile();
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
	public GuiDriverProfile() {
		
	}
	public GuiDriverProfile(driver currentDriver) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String str;
		str=currentDriver.getName();
		
		JList list = new JList();
		DefaultListModel Dlm= new DefaultListModel();
		Dlm.addElement("Salary :"+"  "+currentDriver.getSalary());
		Dlm.addElement("Date of birth:"+"  "+currentDriver.getAge());
		Dlm.addElement("Your assigned trips : ");
		for(int i=0;i<currentDriver.assignedTrips.size();i++) {
			Dlm.addElement("  "+currentDriver.assignedTrips.get(i));
		}
		list.setModel(Dlm);	


		list.setBounds(27, 97, 331, 128);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(107, 22, 93, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(27, 26, 48, 20);
		contentPane.add(lblNewLabel_1);
	}
}
