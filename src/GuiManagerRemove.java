import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiManagerRemove extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private reader obj1=new reader();
private manager currentManager=new manager();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiManagerRemove frame = new GuiManagerRemove();
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
	public GuiManagerRemove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					obj1.readTrips();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DefaultListModel dlm=new DefaultListModel();
				for(int i=0;i<obj1.trips.size();i++) {
					dlm.addElement(obj1.trips.get(i).getTripNum()+"  "+obj1.trips.get(i).getSource()+"  "+obj1.trips.get(i).getDestination()+"  "+obj1.trips.get(i).getTypeOfvehichles()+"  "+obj1.trips.get(i).getTicketPrice()+"  "+obj1.trips.get(i).getNumOfStops()+"  "+obj1.trips.get(i).getTypeOfTrip()+"  "+obj1.trips.get(i).getDate()+"  "+obj1.trips.get(i).getTime()+"  ");
					list.setModel(dlm);						

				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		list.setBounds(10, 21, 414, 114);
		contentPane.add(list);
		
		JSlider slider = new JSlider();
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBounds(390, 182, 31, 87);
		list.add(slider);
		
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setBounds(15, 21, 400, 114);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollBar);
		
		JLabel lblEnterTheNumber = new JLabel("Enter the number you want to remove :");
		lblEnterTheNumber.setBounds(10, 195, 255, 14);
		contentPane.add(lblEnterTheNumber);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				e.getSource();
				
				boolean x=currentManager.removeTrip(textField.getText());
				if(x) {
					JOptionPane.showMessageDialog(null,"The trip has been removed successfully", "Done", JOptionPane.PLAIN_MESSAGE);

				}
				else
					JOptionPane.showMessageDialog(null," you entered an invalid trip number", "error", JOptionPane.PLAIN_MESSAGE);

			}
		});
		textField.setBounds(292, 192, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}