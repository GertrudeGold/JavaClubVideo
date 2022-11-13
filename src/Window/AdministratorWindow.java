package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Pojo.Administrator;
import javax.swing.JButton;
import javax.swing.JLabel;


public class AdministratorWindow {

	private JFrame frame;
	private Administrator connectPerson;
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
					AdministratorWindow window = new AdministratorWindow();
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
	public AdministratorWindow() {
		initialize();
	}

	public AdministratorWindow(Administrator connectPerson) {
		this.connectPerson = connectPerson ;
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
		
		JButton GoToEditCreditButton = new JButton("Edit credit ");
		GoToEditCreditButton.setBounds(10, 79, 89, 23);
		frame.getContentPane().add(GoToEditCreditButton);
		GoToEditCreditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					EditCreditWindow editCreditWindow = new EditCreditWindow();
					JFrame editCreditFrame =  editCreditWindow.getFrame();
					editCreditFrame.setVisible(true);
					frame.dispose();

				}
				});
		
		JLabel lblNewLabel = new JLabel("Hello administrator, Good to see you ! ");
		lblNewLabel.setBounds(10, 32, 304, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
