import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GuiCustomerCancel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private customer currrentCustomer =new customer();
    private reader obj1 = new reader();
    String tripNum;
    Trip cancelledTrip=new Trip();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCustomerCancel frame = new GuiCustomerCancel();
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
	public GuiCustomerCancel() {
		
	}
	public GuiCustomerCancel(customer currentCustomer) {
		this.currrentCustomer=currentCustomer;
        obj1.readCustomers();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			obj1.readTrips();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JList list = new JList();
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DefaultListModel dlm=new DefaultListModel();
				for(int i = 0; i<currentCustomer.reservedTrips.size();i++) {
					String[] result= currentCustomer.reservedTrips.get(i).split(" ",2);
				
					for(int k = 0 ; k < obj1.trips.size();k++) {
					if(obj1.trips.get(k).getTripNum().equalsIgnoreCase(result[0])) {
						System.out.println(result[0]);
					dlm.addElement(result[0]+"  "+obj1.trips.get(k).getSource()+"  "+obj1.trips.get(k).getDestination()+"  "+result[1]+"  "+obj1.trips.get(k).getTypeOfvehichles()+"  "+obj1.trips.get(k).getNumOfStops()+"  "+obj1.trips.get(k).getTypeOfTrip()+"  "+obj1.trips.get(k).getDate()+"  "+obj1.trips.get(k).getTime()+"  ");
				
				}
					}
					list.setModel(dlm);	
				}
			}
			
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		list.setBounds(10, 55, 414, 102);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Enter trip number you want to cancel :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(39, 203, 227, 17);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				e.getSource();
			tripNum=textField.getText();
			int flag=0;
			for(int i=0;i<currentCustomer.reservedTrips.size();i++) {
				String[] result= currentCustomer.reservedTrips.get(i).split(" ",2);

				if(tripNum.equalsIgnoreCase(result[0]))
			{
					flag=1;
			}
				}
			if (flag==0) {
				JOptionPane.showMessageDialog(null," you entered an invalid trip number", "error", JOptionPane.PLAIN_MESSAGE);

			}
			else {
				for(int i=0;i<obj1.trips.size();i++) {
					if(tripNum.equalsIgnoreCase(obj1.trips.get(i).getTripNum()))
						cancelledTrip=obj1.trips.get(i);
				}
				currentCustomer.setReader(obj1);
				currentCustomer.cancel(currentCustomer, cancelledTrip);
			}
			}
		});
		textField.setBounds(308, 202, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCancellingATrip = new JLabel("Cancelling a trip");
		lblCancellingATrip.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCancellingATrip.setBounds(113, 11, 239, 33);
		contentPane.add(lblCancellingATrip);
	}

}
