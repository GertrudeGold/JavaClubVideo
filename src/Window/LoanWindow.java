package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;

import Pojo.Copy;
import Pojo.Loan;
import Pojo.Player;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class LoanWindow {

	private JFrame frame;
	private Copy copyChoose;
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
					LoanWindow window = new LoanWindow();
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
	public LoanWindow() {
		initialize();
	}
	public LoanWindow(Player connectPerson,Copy copyChoose) {
		this.connectPerson = connectPerson;
		this.copyChoose = copyChoose;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton validateButton = new JButton("Validate");
		validateButton.setBounds(335, 201, 89, 23);
		frame.getContentPane().add(validateButton);
		
		JLabel lblNewLabel = new JLabel("Game :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel gameDisplay = new JLabel(copyChoose.getVideoGame().getGameName());
		gameDisplay.setBounds(76, 11, 156, 14);
		frame.getContentPane().add(gameDisplay);
		
		JLabel lblNewLabel_1 = new JLabel("Owner : ");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel ownerDisplay = new JLabel(copyChoose.getPlayer().getFirstName());
		ownerDisplay.setBounds(76, 36, 106, 14);
		frame.getContentPane().add(ownerDisplay);
		
		JLabel lblNewLabel_2 = new JLabel("Cost :");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel costDisplay = new JLabel(String.valueOf(copyChoose.getVideoGame().getCreditPrice()));
		costDisplay.setBounds(76, 61, 46, 14);
		frame.getContentPane().add(costDisplay);
		
		JLabel lblNewLabel_3 = new JLabel("Console :");
		lblNewLabel_3.setBounds(10, 86, 64, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel consoleDisplay = new JLabel(copyChoose.getConsole().getNameConsole());
		consoleDisplay.setBounds(76, 86, 138, 14);
		frame.getContentPane().add(consoleDisplay);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(backButton);
		
		JLabel lblNewLabel_4 = new JLabel("Number of week : ");
		lblNewLabel_4.setBounds(10, 118, 95, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JSpinner numberOfWeek = new JSpinner();
		numberOfWeek.setBounds(111, 115, 30, 20);
		frame.getContentPane().add(numberOfWeek);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(10, 205, 283, 14);
		frame.getContentPane().add(lblNewLabel_5);
		if (connectPerson.getId() == copyChoose.getPlayer().getId()) {
			lblNewLabel_5.setText("Cant take your own copy, just back");
		}
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					WatchListCopyWindow watchListCopyWindow = new WatchListCopyWindow(connectPerson);
					JFrame watchListCopyFrame =  watchListCopyWindow.getFrame();
					watchListCopyFrame.setVisible(true);
					frame.dispose();
				}
				});
			validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((int)numberOfWeek.getValue() > 0 ) {
					if(connectPerson.getCredit() >= (copyChoose.getVideoGame().getCreditPrice()*(int)numberOfWeek.getValue())
							&& connectPerson.getId() != copyChoose.getPlayer().getId())
					{
					
					connectPerson.calculateBalance(copyChoose.getVideoGame().getCreditPrice()*(int)numberOfWeek.getValue());
					copyChoose.getPlayer().calculateBalance(-(copyChoose.getVideoGame().getCreditPrice()*(int)numberOfWeek.getValue()));
					LocalDate now = LocalDate.now();  
					LocalDate end = now.plusWeeks((int)numberOfWeek.getValue());
					Loan loan = new Loan(now,end,1,connectPerson,copyChoose);
					copyChoose.setIsLock(1);
					copyChoose.update(copyChoose);
					loan.Create(loan);
					connectPerson.getLoan().add(loan);
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
}
