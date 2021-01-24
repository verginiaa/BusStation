import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class GuiRound extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
		customer currentCustomer=new customer();
		String source;
			String destination;
			Trip selected;
			Trip selected2;
			String tripNum2;
ArrayList<Trip> foundedRound=new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRound frame = new GuiRound();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GuiRound() {
		
	}

	/**
	 * Create the frame.
	 */
	public GuiRound(String source,String destination,customer currentCustomer,Trip selected) {
		this.source=source;
		this.destination=destination;
		this.currentCustomer=currentCustomer;
		this.selected=selected;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				foundedRound=currentCustomer.listTrips(source, destination, true);

				DefaultListModel dlm=new DefaultListModel();
				for(int i = 0; i<foundedRound.size();i++) {
					dlm.addElement(foundedRound.get(i).getTripNum()+"  "+foundedRound.get(i).getSource()+"  "+foundedRound.get(i).getDestination()+"  "+foundedRound.get(i).getTypeOfvehichles()+"  "+foundedRound.get(i).getTicketPrice()+"  "+foundedRound.get(i).getNumOfStops()+"  "+foundedRound.get(i).getTypeOfTrip()+"  "+foundedRound.get(i).getDate()+"  "+foundedRound.get(i).getTime()+"  ");
				list.setModel(dlm);	
			}
				}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		list.setBounds(10, 23, 414, 87);
		contentPane.add(list);
		JLabel lblEnterNumberOf = new JLabel("Enter number of trip you want to reserve :");
		lblEnterNumberOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterNumberOf.setBounds(10, 168, 250, 31);
		contentPane.add(lblEnterNumberOf);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tripNum2=textField.getText();
			int flag=0;
				for(int i=0;i<foundedRound.size();i++) {
					if(tripNum2.equalsIgnoreCase(foundedRound.get(i).getTripNum()))
				{
						flag=1;
						selected2=foundedRound.get(i);
				}
					}
				if (flag==0) {
					JOptionPane.showMessageDialog(null," you entered an invalid trip number", "error", JOptionPane.PLAIN_MESSAGE);

				}
				else {
					String str;
					str = JOptionPane.showInputDialog("Enter number of seats you want to reserve:");
					if(str.equalsIgnoreCase(""))
						str=null;
					boolean x= currentCustomer.checkAvailability(selected, selected2, str);
					if(x)
					{
						   String price;
							price=currentCustomer.reserve(selected, selected2);
							int y =JOptionPane.showConfirmDialog(null,"The price is:"+price+"  "+ "Are you sure you want to reserve the Trip ?");
								if(y==0) {
										currentCustomer.updateArrays(currentCustomer);
										JOptionPane.showMessageDialog(null,"Your trip has been successfully added,Have a nice tirp.", "Done", JOptionPane.PLAIN_MESSAGE);

									}
					}
				
				}

				System.out.println(foundedRound.get(0).getDate());
			}
		});
		textField.setBounds(307, 174, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
