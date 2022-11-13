package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Pojo.Administrator;

import Pojo.Player;

import Pojo.User;


public class LoginWindow {

	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}
	
	private JFrame frame;
	
	private JTextField email;
	private JLabel Error;
	private JPasswordField password;
	private User User;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
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
	public LoginWindow() {
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
		JButton ConnectionButton = new JButton("Se connecter");
		ConnectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String pwd = new String (password.getPassword());
				Object ConnectPerson = login(email.getText(),pwd);
				if(validate(email.getText())==false) {
					Error.setText("Email invalide");
				}
				
				else if(email.getText().equals("")|| pwd.equals("")) {
					
					Error.setText("Ne peux pas etre vide");
				}
				else if(ConnectPerson==null) {
					Error.setText("Information incorrect");
				}
				else {
					if(ConnectPerson instanceof Administrator) {						
						AdministratorWindow memberWindow = new AdministratorWindow((Administrator) ConnectPerson);
						JFrame memberFrame = memberWindow.getFrame();
						memberFrame.setVisible(true);
						frame.dispose();
						
						
					}
					if(ConnectPerson instanceof Player) {
						PlayerWindow treasurerWindow = new PlayerWindow((Player) ConnectPerson);
						JFrame treasurerFrame =  treasurerWindow.getFrame();
						treasurerFrame.setVisible(true);
						frame.dispose();
						
					}
					
				}
			}
			});
		ConnectionButton.setBounds(155, 192, 112, 23);
		frame.getContentPane().add(ConnectionButton);
		
		email = new JTextField();
		email.setBounds(134, 52, 199, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel emailabel = new JLabel("Email :");
		emailabel.setLabelFor(email);
		emailabel.setBounds(34, 55, 57, 14);
		frame.getContentPane().add(emailabel);
		
		JLabel lblNewLabel = new JLabel("mot de passe :");
		lblNewLabel.setBounds(34, 89, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		Error = new JLabel("");
		Error.setBounds(90, 114, 151, 34);
		frame.getContentPane().add(Error);
		
		password = new JPasswordField();
		lblNewLabel.setLabelFor(password);
		password.setBounds(134, 83, 199, 20);
		frame.getContentPane().add(password);
		
	}
	private User login(String email, String password) {
		return User.login(email,password);
	}
}
