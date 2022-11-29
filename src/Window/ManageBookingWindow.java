package Window;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import Pojo.Booking;
import Pojo.Copy;
import Pojo.Loan;
import Pojo.Player;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ManageBookingWindow {

	private JFrame frame;
	private Player connectPerson;
	private Booking bookingChoose;
	private Copy copyOfBooking;
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
					ManageBookingWindow window = new ManageBookingWindow();
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
	public ManageBookingWindow() {
		initialize();
	}
	public ManageBookingWindow(Player connectPerson , Booking bookingChoose) {
		this.connectPerson = connectPerson;
		this.bookingChoose = bookingChoose;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(419, 278, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(503, 141, 181, 112);
		frame.getContentPane().add(textPane);
		if(bookingChoose.getIsReady() == 1) {
			textPane.setText("If u dont have enought credit to finish your reservation, cancel it or wait"
					+ "to have more credit ! ");
			JButton validateButton = new JButton("Validate");
			validateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			validateButton.setBounds(608, 348, 89, 23);
			frame.getContentPane().add(validateButton);
			
			JLabel lblNewLabel = new JLabel("Game :");
			lblNewLabel.setBounds(10, 11, 46, 14);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel gameDisplay = new JLabel(bookingChoose.getVideoGame().getGameName());
			gameDisplay.setBounds(76, 11, 156, 14);
			frame.getContentPane().add(gameDisplay);
			
			JLabel lblNewLabel_1 = new JLabel("Owner : ");
			lblNewLabel_1.setBounds(10, 36, 46, 14);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel ownerDisplay = new JLabel(bookingChoose.getPlayer().getFirstName());
			ownerDisplay.setBounds(76, 36, 106, 14);
			frame.getContentPane().add(ownerDisplay);
			
			JLabel lblNewLabel_2 = new JLabel("Cost :");
			lblNewLabel_2.setBounds(10, 61, 46, 14);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel costDisplay = new JLabel(String.valueOf(bookingChoose.getVideoGame().getCreditPrice()));
			costDisplay.setBounds(76, 61, 46, 14);
			frame.getContentPane().add(costDisplay);
			
			JLabel lblNewLabel_3 = new JLabel("Console :");
			lblNewLabel_3.setBounds(10, 86, 64, 14);
			frame.getContentPane().add(lblNewLabel_3);
			
			JLabel consoleDisplay = new JLabel(bookingChoose.getConsole().getNameConsole());
			consoleDisplay.setBounds(76, 86, 138, 14);
			frame.getContentPane().add(consoleDisplay);
			
			
			JLabel lblNewLabel_4 = new JLabel("Number of week : ");
			lblNewLabel_4.setBounds(10, 118, 95, 14);
			frame.getContentPane().add(lblNewLabel_4);
			
			JSpinner numberOfWeek = new JSpinner();
			numberOfWeek.setBounds(111, 115, 30, 20);
			frame.getContentPane().add(numberOfWeek);
			
				validateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if((int)numberOfWeek.getValue() > 0 ) {
						copyOfBooking= new Copy();
						copyOfBooking = copyOfBooking.findACopyForAReservation(bookingChoose);
						if(connectPerson.getCredit() >= (copyOfBooking.getVideoGame().getCreditPrice()*(int)numberOfWeek.getValue())
								&& connectPerson.getId() != copyOfBooking.getPlayer().getId())
						{
						
						connectPerson.calculateBalance(copyOfBooking.getVideoGame().getCreditPrice()*(int)numberOfWeek.getValue());
						copyOfBooking.getPlayer().calculateBalance(-(copyOfBooking.getVideoGame().getCreditPrice()*(int)numberOfWeek.getValue()));
						LocalDate now = LocalDate.now();  
						LocalDate end = now.plusWeeks((int)numberOfWeek.getValue());
						Loan loan = new Loan(now,end,1,connectPerson,copyOfBooking);
						copyOfBooking.setIsLock(1);
						copyOfBooking.update(copyOfBooking);
						loan.Create(loan);
						connectPerson.getLoan().add(loan);
						bookingChoose.delete(bookingChoose);
						PlayerWindow playerWindow = new PlayerWindow(connectPerson);
						JFrame playerFrame =  playerWindow.getFrame();
						playerFrame.setVisible(true);
						frame.dispose();
						}
						else {lblNewLabel_5.setText("Not enought credit");}
						}
					}
				});
		}
		else {
			textPane.setText("Your reservation is not ready, be patient");
		}
			JButton backButton = new JButton("Back");
			backButton.setBounds(608, 378, 89, 23);
			frame.getContentPane().add(backButton);
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(509, 348, 89, 23);
			frame.getContentPane().add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bookingChoose.delete(bookingChoose)	;
					PlayerWindow playerWindow = new PlayerWindow(connectPerson);
					JFrame playerFrame =  playerWindow.getFrame();
					playerFrame.setVisible(true);
					frame.dispose();
					}
					});
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
					PlayerWindow playerWindow = new PlayerWindow(connectPerson);
					JFrame playerFrame =  playerWindow.getFrame();
					playerFrame.setVisible(true);
					frame.dispose();
					}
					});
			
	}
}
