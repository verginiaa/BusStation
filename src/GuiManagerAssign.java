import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class GuiManagerAssign extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
reader obj1=new reader();
ArrayList <driver> drivers=new ArrayList<driver>();
String driverName;
String tripNum;
manager manager=new manager();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiManagerAssign frame = new GuiManagerAssign();
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
	public GuiManagerAssign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DefaultListModel dlm=new DefaultListModel();
				try {
					obj1.readDrivers();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<obj1.drivers.size();i++) {
					dlm.addElement("Driver name"+"  "+"  "+obj1.drivers.get(i).getName()+"  "+obj1.drivers.get(i).getAge()+"  "+obj1.drivers.get(i).getSalary()+"  ");
					for(int j=0;j<obj1.drivers.get(i).assignedTrips.size();j++) {
						dlm.addElement(obj1.drivers.get(i).assignedTrips.get(j)+"  ");
					}
					list.setModel(dlm);
					
				}

			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		list.setBounds(21, 44, 391, 87);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("Enter name of the driver :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 169, 184, 17);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(284, 168, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JList list_1 = new JList();
		list_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				DefaultListModel dlm=new DefaultListModel();

				try {
					obj1.readTrips();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<obj1.trips.size();i++) {
					dlm.addElement(obj1.trips.get(i).getTripNum()+"  "+obj1.trips.get(i).getSource()+"  "+obj1.trips.get(i).getDestination()+"  "+obj1.trips.get(i).getTypeOfvehichles()+"  "+obj1.trips.get(i).getTicketPrice()+"  "+obj1.trips.get(i).getNumOfStops()+"  "+obj1.trips.get(i).getTypeOfTrip()+"  "+obj1.trips.get(i).getDate()+"  "+obj1.trips.get(i).getTime()+"  ");
					list_1.setModel(dlm);						

				}

			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		list_1.setBounds(10, 224, 414, 93);
		contentPane.add(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter number of the trip :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 350, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 348, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Assigning the trip ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(129, 11, 151, 34);
		contentPane.add(lblNewLabel_2);
		
		JSlider slider = new JSlider();
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBounds(390, 182, 31, 87);
		list.add(slider);
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					driverName=textField.getText();
					tripNum=textField_1.getText();
					manager.setReader(obj1);
					boolean x=manager.assignTrip(driverName, tripNum);
					if(x) {
						JOptionPane.showMessageDialog(null," The trip has been assigned successfully", "Done", JOptionPane.PLAIN_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null," you entered an invalid trip number or invalid driver's name", "error", JOptionPane.PLAIN_MESSAGE);

					}
					
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(291, 405, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setBounds(10, 44, 414, 93);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollBar);
	}
}
