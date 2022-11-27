package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;

import Pojo.Administrator;
import Pojo.Player;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PlayerWindow {

	private JFrame frame;
	private Player connectPerson;
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
					PlayerWindow window = new PlayerWindow();
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
	public PlayerWindow() {
		initialize();
	}

	public PlayerWindow(Player connectPerson) {
		this.connectPerson = connectPerson;
				
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 747, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//for anniversary
		LocalDate now = LocalDate.now();  
		if(connectPerson.getAnniversary().getDayOfMonth() == now.getDayOfMonth() && connectPerson.getAnniversary().getMonth() == now.getMonth())
		{
		    if(connectPerson.getLastGainForAnniversary().getYear() != now.getYear()){
			connectPerson.setCredit(connectPerson.getCredit()+2);
			connectPerson.setLastGainForAnniversary(now);
			connectPerson.Update(connectPerson);
			}
		}
		JLabel lblNewLabel = new JLabel("Hello player : "+connectPerson.getFirstName());
		lblNewLabel.setBounds(10, 11, 243, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton addCopyButton = new JButton("Add a copy");
		addCopyButton.setBounds(10, 51, 141, 23);
		frame.getContentPane().add(addCopyButton);
		
		JButton Reservebutton = new JButton("Loan a game");
		Reservebutton.setBounds(10, 85, 141, 23);
		frame.getContentPane().add(Reservebutton);
		
		JButton seeLoanButton = new JButton("See loan");
		seeLoanButton.setBounds(10, 119, 141, 23);
		frame.getContentPane().add(seeLoanButton);
		
		JButton bookingButton = new JButton("Book a game");
		bookingButton.setBounds(10, 153, 141, 23);
		frame.getContentPane().add(bookingButton);
		bookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MakeABookingWindow makeABookingWindow = new MakeABookingWindow(connectPerson);
				JFrame makeABookingFrame =  makeABookingWindow.getFrame();
				makeABookingFrame.setVisible(true);
				frame.dispose();

				}
				});
		seeLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WatchLoanWindow watchLoanWindow = new WatchLoanWindow(connectPerson);
				JFrame WatchLoanFrame =  watchLoanWindow.getFrame();
				WatchLoanFrame.setVisible(true);
				frame.dispose();

				}
				});
		
		
		
		Reservebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WatchListCopyWindow watchListCopyWindow = new WatchListCopyWindow(connectPerson);
				JFrame watchListCopyFrame =  watchListCopyWindow.getFrame();
				watchListCopyFrame.setVisible(true);
				frame.dispose();

				}
				});
		addCopyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AddCopyWindow addCopyWindow = new AddCopyWindow(connectPerson);
					JFrame addCopyframe =  addCopyWindow.getFrame();
					addCopyframe.setVisible(true);
					frame.dispose();

				}
				});
	}
}
