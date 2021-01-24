import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class GuiCustomerAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
ArrayList <Trip> foundedTrips=new ArrayList<Trip>();
private customer currentCustomer;
private String tripNum;
String numOfSeats;
String kindOfTrip;
Trip selected= new Trip();
private JTextField textField_1;
//writer obj2 = new writer ();
reader obj1 = new reader ();
String source;
String destination;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCustomerAdd frame = new GuiCustomerAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public GuiCustomerAdd() {
	
}
	/**
	 * Create the frame.
	 */
	public GuiCustomerAdd(customer currentCustomer, ArrayList <Trip> foundedTrips,String source,String destination) {
		this.currentCustomer=currentCustomer;
		obj1.readCustomers();
		try {
			obj1.readTrips();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		currentCustomer.setReader(obj1);
		this.source=source;
		this.destination=destination;

		for(int i=0 ; i<foundedTrips.size();i++) {
			this.foundedTrips.add(foundedTrips.get(i));
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DefaultListModel dlm=new DefaultListModel();
			for(int i = 0; i<foundedTrips.size();i++) {
				dlm.addElement(foundedTrips.get(i).getTripNum()+"  "+foundedTrips.get(i).getSource()+"  "+foundedTrips.get(i).getDestination()+"  "+foundedTrips.get(i).getTypeOfvehichles()+"  "+foundedTrips.get(i).getTicketPrice()+"  "+foundedTrips.get(i).getNumOfStops()+"  "+foundedTrips.get(i).getTypeOfTrip()+"  "+foundedTrips.get(i).getDate()+"  "+foundedTrips.get(i).getTime()+"  ");
			list.setModel(dlm);	
			}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
	
		list.setBounds(22, 28, 402, 117);
		contentPane.add(list);
		
		
		JLabel lblNewLabel = new JLabel("Enter number of the trip you want to add :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 183, 260, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
	
		textField.setBounds(316, 184, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter kind of trip (oneway/round) :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 225, 248, 20);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(316, 226, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					tripNum=textField.getText();
					kindOfTrip=textField_1.getText();
					e.getSource();
					int flag=0;
					for(int i=0;i<foundedTrips.size();i++) {
						if(tripNum.equalsIgnoreCase(foundedTrips.get(i).getTripNum()))
					{
							flag=1;
							selected=foundedTrips.get(i);
					}
						}
					if (flag==0) {
						JOptionPane.showMessageDialog(null," you entered an invalid trip number", "error", JOptionPane.PLAIN_MESSAGE);

					}
					else {

					
					if (kindOfTrip.equalsIgnoreCase("oneway"))
					{
						String str;
						str = JOptionPane.showInputDialog("Enter number of seats you want to reserve:");
						if(str.equalsIgnoreCase(""))
						{
							str=null;
						}
						boolean x = currentCustomer.checkAvailability(selected, null, str);
						if(x)
						{
								    String price;
									price=currentCustomer.reserve(selected, null);
									int y =JOptionPane.showConfirmDialog(null,"The price is:"+price+"  "+ "Are you sure you want to reserve the Trip ?");
										if(y==0) {
												currentCustomer.updateArrays(currentCustomer);
												JOptionPane.showMessageDialog(null,"Your trip has been successfully added,Have a nice tirp.", "Done", JOptionPane.PLAIN_MESSAGE);

												
											}
								
								}
						else {
							JOptionPane.showMessageDialog(null,"No avaiable seats in this trip", "error", JOptionPane.PLAIN_MESSAGE);

						}
					
					}
					else if(kindOfTrip.equalsIgnoreCase("round")){
						if(source.equalsIgnoreCase("")||destination.equalsIgnoreCase(""))
						{
						JOptionPane.showMessageDialog(null,"You cannot choose round without entering source and destination", "error", JOptionPane.PLAIN_MESSAGE);

						}
						else {
						GuiRound obj=new GuiRound(source,destination,currentCustomer,selected);
						obj.setVisible(true);
						}
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"you entered wrong data", "error", JOptionPane.PLAIN_MESSAGE);

					}
				}
				}
				
			}
		});
		btnNewButton.setBounds(366, 267, 89, 23);
		contentPane.add(btnNewButton);
	}

}
