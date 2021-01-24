import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;

public class GuiCustomerReview extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	customer currentCustomer = new customer ();
	reader obj1 = new reader ();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCustomerReview frame = new GuiCustomerReview();
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
public GuiCustomerReview() {
		
}
	public GuiCustomerReview(customer currentCustomer) {
		getContentPane().setLayout(null);
		this.currentCustomer=currentCustomer;

		//System.out.println(this.currentCustomer.reservedTrips.get(0));
		getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("trip");
		scrollPane.setBounds(10, 52, 774, 230);
		getContentPane().add(scrollPane);
		
		
		table_1 = new JTable(currentCustomer.reservedTrips.size()+6,9);
		table_1.setValueAt("Trip number", 0, 0);
		table_1.setValueAt("Source", 0, 1);
		table_1.setValueAt("Destination", 0, 2);
		table_1.setValueAt("Vechile", 0, 3);
		table_1.setValueAt("Seats num", 0, 4);
		table_1.setValueAt("Type of trip", 0, 5);
		table_1.setValueAt("Stops num", 0, 6);
		table_1.setValueAt("Date", 0, 7);
		table_1.setValueAt("Time", 0, 8);
		try {
			obj1.readTrips();
			obj1.readCustomers();

			currentCustomer.setReader(obj1);
			//obj1.readCustomers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

int l=1;				
int j =0;
for (int i=0; i<obj1.customers.size();i++) {
	if (currentCustomer.getPassword().equalsIgnoreCase(obj1.customers.get(i).getPassword()))
	{
		this.currentCustomer=obj1.customers.get(i);
	}
		
		
}
		for (int i = 1 ; i<(this.currentCustomer.reservedTrips.size()+1);i++) {
			
			
			 
				String[] result= this.currentCustomer.reservedTrips.get(i-1).split(" ",2);
				System.out.println(result[0]);
				for(int k = 0 ; k < obj1.trips.size();k++) {


					if(obj1.trips.get(k).getTripNum().equalsIgnoreCase(result[0]))
					{


						table_1.setValueAt(result[0],l,j++);
						
						table_1.setValueAt(obj1.trips.get(k).getSource(), l, j++);
						table_1.setValueAt(obj1.trips.get(k).getDestination(),l, j++);
						table_1.setValueAt(obj1.trips.get(k).getTypeOfvehichles(),l, j++);
						table_1.setValueAt(result[1], l, j++);

						table_1.setValueAt(obj1.trips.get(k).getTypeOfTrip(), l, j++);
						table_1.setValueAt(obj1.trips.get(k).getNumOfStops(), l, j++);

						table_1.setValueAt(obj1.trips.get(k).getDate(), l, j++);
						table_1.setValueAt(obj1.trips.get(k).getTime(), l, j++);


j=0;
l++;


					}
						
				}
				


				
		}
		getContentPane().add(table_1);

	
		scrollPane.setViewportView(table_1);
		scrollPane.setColumnHeader(null);
		
		

	}

}
