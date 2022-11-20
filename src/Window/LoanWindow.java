package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Pojo.Copy;
import Pojo.Player;
import javax.swing.JButton;
import javax.swing.JLabel;

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
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					WatchListCopyWindow watchListCopyWindow = new WatchListCopyWindow(connectPerson);
					JFrame watchListCopyFrame =  watchListCopyWindow.getFrame();
					watchListCopyFrame.setVisible(true);
					frame.dispose();
				}
				});
	}
}
