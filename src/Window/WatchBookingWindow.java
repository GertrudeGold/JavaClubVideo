package Window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Pojo.Booking;
import Pojo.Copy;
import Pojo.Player;

public class WatchBookingWindow {

	private JFrame frame;
	private Player connectPerson;
	private JTable table;
	private Booking bookingSelected;
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WatchBookingWindow window = new WatchBookingWindow();
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
	public WatchBookingWindow() {
		initialize();
	}
	public WatchBookingWindow(Player connectPerson) {
		this.connectPerson = connectPerson;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton Backbutton = new JButton("Back");
		Backbutton.setBounds(708, 423, 130, 23);
		frame.getContentPane().add(Backbutton);
		//create a table with informations for select it
		ArrayList<Booking> BookingToShow = Booking.findAllOfAnUser(connectPerson);
		String[] colums={"Date","Game","Console","Ready/not ready","Id"};
		Object data[][]=new Object[BookingToShow.size()+1][5];
		data[0][0]=colums[0];
		data[0][1]=colums[1];
		data[0][2]=colums[2];
		data[0][3]=colums[3];
		data[0][4]=colums[4];
		int cpt=1;
		for (Booking booking : BookingToShow) {
			data[cpt][0]=booking.getDateReservation();
			data[cpt][1]=booking.getVideoGame().getGameName();
			data[cpt][2]=booking.getConsole().getNameConsole();
			if(booking.getIsReady()==0) {
				data[cpt][3]="Not ready";
			}
			else
			{
				data[cpt][3]="Ready";
			}
			data[cpt][4]=booking.getId();
			cpt++;
		}
		table = new JTable();

		table.setModel(new DefaultTableModel(data,colums));




		table.setBounds(0, 0, 581, 446);
		table.setFont(new Font("Courier New", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		frame.getContentPane().add(table);
		Backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					PlayerWindow playerWindow = new PlayerWindow(connectPerson);
					JFrame playerFrame =  playerWindow.getFrame();
					playerFrame.setVisible(true);
					frame.dispose();
				}
				});
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				try {
				if (e.getClickCount() == 1) {
				
					for(Booking booking : BookingToShow) {
				
						if(booking.getId() == (int)table.getModel().getValueAt(table.rowAtPoint(e.getPoint()),4))
						{
							bookingSelected = booking;
						}
					}
					
					
					ManageBookingWindow manageBookingWindow = new ManageBookingWindow(connectPerson,bookingSelected);
					JFrame manageBookingFrame =  manageBookingWindow.getFrame();
					manageBookingFrame.setVisible(true);
					frame.dispose();
					}
					
				}
				
				catch (Exception e1){
					e1.getMessage();
				}
				
			}
		
	});
			
	}
}
