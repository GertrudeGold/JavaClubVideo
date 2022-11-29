package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Pojo.Player;
import Pojo.User;
import javax.swing.JPasswordField;

public class RegisterWindow {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}
	private JFrame frame;
	private JTextField name;
	private JTextField firstname;
	private JTextField adresse;
	private JTextField birthdayDate;
	private JTextField email;
	private JPasswordField passWord;
	private JPasswordField confirmPassword;
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
					RegisterWindow window = new RegisterWindow();
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
	public RegisterWindow() {
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

		name = new JTextField();
		name.setBounds(87, 33, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);

		firstname = new JTextField();
		firstname.setBounds(87, 75, 86, 20);
		frame.getContentPane().add(firstname);
		firstname.setColumns(10);

		JLabel lblNewLabel = new JLabel("Lastname :");
		lblNewLabel.setBounds(10, 36, 63, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Firstname :");
		lblNewLabel_1.setBounds(10, 78, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Adresse :");
		lblNewLabel_3.setBounds(10, 114, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		adresse = new JTextField();
		adresse.setBounds(87, 111, 86, 20);
		frame.getContentPane().add(adresse);
		adresse.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password : ");
		lblNewLabel_4.setBounds(10, 155, 63, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ConfirmPassword : ");
		lblNewLabel_5.setBounds(10, 199, 107, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Email : ");
		lblNewLabel_6.setBounds(223, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);

		email = new JTextField();
		email.setBounds(290, 33, 86, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Anniversaire");
		lblNewLabel_7.setBounds(223, 78, 79, 14);
		frame.getContentPane().add(lblNewLabel_7);
		 MaskFormatter mask = null;
	        try {
	            mask = new MaskFormatter("##/##/####");
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	    birthdayDate = new JFormattedTextField(mask);
		birthdayDate.setBounds(312, 75, 86, 20);
		frame.getContentPane().add(birthdayDate);
		birthdayDate.setColumns(10);

		JButton returnButton = new JButton("Return");
		returnButton.setBounds(287, 227, 89, 23);
		frame.getContentPane().add(returnButton);
		returnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				LoginWindow loginWindow = new LoginWindow();
				JFrame LoginFrame =  loginWindow.getFrame();
				LoginFrame.setVisible(true);
				frame.dispose();

			}
			});

		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(287, 195, 89, 23);
		frame.getContentPane().add(confirmButton);

		JLabel Error = new JLabel("");
		Error.setBounds(196, 155, 228, 14);
		frame.getContentPane().add(Error);

		passWord = new JPasswordField();
		passWord.setBounds(87, 152, 86, 20);
		frame.getContentPane().add(passWord);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(110, 196, 79, 20);
		frame.getContentPane().add(confirmPassword);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("") || firstname.getText().equals("")  || 
						adresse.getText().equals("") || passWord.getText().equals("")  
						|| confirmPassword.getText().equals("")  || birthdayDate.getText().equals(""))
				{
					Error.setText("all must be done ");
				}
				else if(validate(email.getText())==false) {
					Error.setText("Email invalide");
				}
				else if(!passWord.getText().equals(confirmPassword.getText()) )
				{
					Error.setText("password dont match");	
				}
				else if(User.checkIfEmailExist(email.getText()) )
				{
					Error.setText("Email already exist");	
				}
				else
				{

				    LocalDate now = LocalDate.now();  
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate date1 = LocalDate.parse(birthdayDate.getText(),formatter);
					LocalDate defaultDateGain = LocalDate.of(1999,12,31);
					User user = new Player(firstname.getText(),name.getText(),0,adresse.getText(),10,date1,now,email.getText(),passWord.getText(),defaultDateGain);
					user.Register(user);
					LoginWindow loginWindow = new LoginWindow();
					JFrame LoginFrame =  loginWindow.getFrame();
					LoginFrame.setVisible(true);
					frame.dispose();

				}





			}
			});
	}
}
