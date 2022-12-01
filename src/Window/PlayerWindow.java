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
import javax.swing.JTextArea;

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
		connectPerson.addBirthdayBonus();
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(442, 50, 181, 132);
		frame.getContentPane().add(textArea);
		JButton addCopyButton = new JButton("Add a copy");
		addCopyButton.setBounds(10, 51, 141, 23);
		frame.getContentPane().add(addCopyButton);
		JButton seeLoanButton = new JButton("See loan");
		seeLoanButton.setBounds(10, 119, 141, 23);
		frame.getContentPane().add(seeLoanButton);
		JButton seeReservationButton = new JButton("See reservation");
		
		seeLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WatchLoanWindow watchLoanWindow = new WatchLoanWindow(connectPerson);
				JFrame WatchLoanFrame =  watchLoanWindow.getFrame();
				WatchLoanFrame.setVisible(true);
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
		//for credit <0 
		if(connectPerson.getCredit() >0) {
			
			
			JButton Reservebutton = new JButton("Loan a game");
			Reservebutton.setBounds(10, 85, 141, 23);
			frame.getContentPane().add(Reservebutton);
			
			textArea.setText("You have 0 or less credits, you can just propose a game to loan or give back a game");
			
			JButton bookingButton = new JButton("Reservation");
			bookingButton.setBounds(10, 153, 141, 23);
			frame.getContentPane().add(bookingButton);
			
			seeReservationButton.setBounds(10, 187, 141, 23);
			frame.getContentPane().add(seeReservationButton);
			seeReservationButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					WatchBookingWindow watchBookingWindow = new WatchBookingWindow(connectPerson);
					JFrame watchBookingFrame =  watchBookingWindow.getFrame();
					watchBookingFrame.setVisible(true);
					frame.dispose();

					}
					});
			
			
			bookingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MakeABookingWindow makeABookingWindow = new MakeABookingWindow(connectPerson);
					JFrame makeABookingFrame =  makeABookingWindow.getFrame();
					makeABookingFrame.setVisible(true);
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
			
		}
		JLabel lblNewLabel = new JLabel("Hello player : "+connectPerson.getFirstName());
		lblNewLabel.setBounds(10, 11, 243, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("You have : ");
		lblNewLabel_1.setBounds(175, 11, 94, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel credit = new JLabel( connectPerson.getCredit() +" credits");
		credit.setBounds(247, 11, 81, 14);
		frame.getContentPane().add(credit);
		
		JButton decoButton = new JButton("Sign out");
		decoButton.setBounds(632, 366, 89, 23);
		frame.getContentPane().add(decoButton);
		
		
		decoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow loginWindow = new LoginWindow();
				JFrame LoginFrame =  loginWindow.getFrame();
				LoginFrame.setVisible(true);
				frame.dispose();

				}
				});
		
		
	}
}
