package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Pojo.Loan;
import Pojo.Player;

import javax.swing.JButton;

public class GiveBackCopyWindow {

	private JFrame frame;
	private Player connectPerson;
	private Loan loanChoose;
	long numberOfDayLate ; 
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
					GiveBackCopyWindow window = new GiveBackCopyWindow();
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
	public GiveBackCopyWindow() {
		initialize();
	}
	public GiveBackCopyWindow(Player connectPerson, Loan loanChoose) {
		this.connectPerson = connectPerson;
		this.loanChoose = loanChoose;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 705, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date end : ");
		lblNewLabel.setBounds(10, 11, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Owner of copy : ");
		lblNewLabel_1.setBounds(10, 36, 123, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("game : ");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Days late : ");
		lblNewLabel_3.setBounds(10, 86, 86, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton BackButton = new JButton("Back");
		BackButton.setBounds(454, 389, 225, 23);
		frame.getContentPane().add(BackButton);
		
		JButton giveBackButton = new JButton("Give back to the owner ");
		giveBackButton.setBounds(454, 362, 225, 23);
		frame.getContentPane().add(giveBackButton);
		
		JLabel dateEnd = new JLabel(String.valueOf(loanChoose.getDateEndLoan()));
		dateEnd.setBounds(87, 11, 178, 14);
		frame.getContentPane().add(dateEnd);
		
		JLabel owner = new JLabel(loanChoose.getCopy().getPlayer().getFirstName());
		owner.setBounds(119, 36, 146, 14);
		frame.getContentPane().add(owner);
		
		JLabel game = new JLabel(loanChoose.getCopy().getVideoGame().getGameName());
		game.setBounds(67, 61, 135, 14);
		frame.getContentPane().add(game);
		LocalDate now = LocalDate.now();  
		numberOfDayLate = 0;
		if(now.isAfter(loanChoose.getDateEndLoan())) {
			 numberOfDayLate = -ChronoUnit.DAYS.between(now, loanChoose.getDateEndLoan());
		}
		
		JLabel daysLate = new JLabel(String.valueOf(numberOfDayLate));
		daysLate.setBounds(77, 86, 46, 14);
		frame.getContentPane().add(daysLate);
		
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					WatchLoanWindow watchLoanWindow = new WatchLoanWindow(connectPerson);
					JFrame watchLoanFrame =  watchLoanWindow.getFrame();
					watchLoanFrame.setVisible(true);
					frame.dispose();
				}
				});
		giveBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(numberOfDayLate >0) {
					int creditToTake = (int) (numberOfDayLate*5);
					connectPerson.calculateBalance(creditToTake);
					loanChoose.getCopy().getPlayer().calculateBalance(-creditToTake);
				}
				loanChoose.endLoan();
				
					WatchLoanWindow watchLoanWindow = new WatchLoanWindow(connectPerson);
					JFrame watchLoanFrame =  watchLoanWindow.getFrame();
					watchLoanFrame.setVisible(true);
					frame.dispose();
				}
				});
	}
}
