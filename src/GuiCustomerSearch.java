import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GuiCustomerSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

    String source;
    String destination;
    String numberOfSeats;
    String kindOfTrip;
   // customer currentCustomer=new customer();
    ArrayList <Trip> foundedRound=new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCustomerSearch frame = new GuiCustomerSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GuiCustomerSearch() {
		
	}

	/**
	 * Create the frame.
	 */
	public GuiCustomerSearch(customer current) {
		//this.currentCustomer=currentCustomer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the source :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 22, 172, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the destination :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(22, 110, 172, 55);
		contentPane.add(lblNewLabel_1);
		
	
		
		textField = new JTextField();
	
		textField.setBounds(296, 39, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();

		textField_1.setBounds(296, 127, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Search");
		   reader obj1=new reader();
		  

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {

						obj1.readTrips();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				if(e.getSource()==btnNewButton) {
					
					source=textField.getText();
					destination=textField_1.getText();
					ArrayList<Trip> foundedTrips = new ArrayList<>();
					
					customer currentCustomer=new customer();
					currentCustomer=current;
					currentCustomer.setReader(obj1);

					
					if(source.equalsIgnoreCase("") && destination.equalsIgnoreCase("")) {
						foundedTrips=currentCustomer.listTrips();
						
					}
					else if (source.equalsIgnoreCase(""))
					{
						foundedTrips=currentCustomer.listTrips(destination, false);
					}
					else if (destination.equalsIgnoreCase("")) {
						foundedTrips=currentCustomer.listTrips(source, true);

					}
					else  {
						foundedTrips=currentCustomer.listTrips(source,destination);

					}
					if(foundedTrips.size()==0) {
						JOptionPane.showMessageDialog(null,"There is no trips with those entered data ", "error", JOptionPane.PLAIN_MESSAGE);

					}
					else {
					GuiCustomerAdd obj=new GuiCustomerAdd(currentCustomer,foundedTrips,source,destination);
					obj.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setBounds(358, 243, 89, 23);
		contentPane.add(btnNewButton);
		
	

	}
}
