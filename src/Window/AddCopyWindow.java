package Window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import Other.ComboBoxModelConsole;
import Other.ComboBoxModelVideoGame;
import Pojo.Booking;
import Pojo.Console;
import Pojo.Copy;
import Pojo.Player;
import Pojo.VideoGame;

public class AddCopyWindow {

	private JFrame frame;
	VideoGame selectedgame ;
	Console selectedConsole;
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
					AddCopyWindow window = new AddCopyWindow();
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
	public AddCopyWindow() {
		initialize();
	}
	public AddCopyWindow(Player connectPerson) {
		this.connectPerson = connectPerson;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton BackButton = new JButton("Back");
		BackButton.setBounds(553, 364, 89, 23);
		frame.getContentPane().add(BackButton);
		
		JLabel lblNewLabel = new JLabel("Game to propose : ");
		lblNewLabel.setBounds(10, 11, 131, 14);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_2 = new JLabel("");
	    lblNewLabel_2.setBounds(238, 84, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 84, 92, 14);
		frame.getContentPane().add(lblNewLabel_1);
		JButton Validate = new JButton("Validate");
		Validate.setBounds(553, 330, 89, 23);
		frame.getContentPane().add(Validate);
		JComboBox<Console> ConsoleComboBox = new JComboBox<Console>();
		frame.getContentPane().add(ConsoleComboBox);
		
		ArrayList<VideoGame> arrGames = VideoGame.findAll();
		VideoGame[] games = new VideoGame[arrGames.size()];
		games = arrGames.toArray(games);
		ComboBoxModelVideoGame comboBoxModelVideoGame = new ComboBoxModelVideoGame(games);
		JComboBox<VideoGame> gameComboBox = new JComboBox<VideoGame>(comboBoxModelVideoGame);
		gameComboBox.setBounds(131, 11, 224, 22);
		frame.getContentPane().add(gameComboBox);
		gameComboBox.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent event) {
				
				  
				  selectedgame = (VideoGame) gameComboBox.getSelectedItem();
				  ArrayList<Console> arrConsoles = selectedgame.getConsoles();
				  Console[] consoles = new Console[arrConsoles.size()];
				  consoles = arrConsoles.toArray(consoles);
				  ComboBoxModelConsole comboBoxModelConsole = new ComboBoxModelConsole(consoles);
				  ConsoleComboBox.setModel(comboBoxModelConsole);
				  ConsoleComboBox.setBounds(72, 80, 152, 22);
				 
				  lblNewLabel_2.setText("For "+selectedgame.getCreditPrice() +" Credit");  
				  lblNewLabel_1.setText("Console :");
				 
			 }
		});
		ConsoleComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				selectedConsole =(Console) ConsoleComboBox.getSelectedItem();
				
				

			}
		});
		
		
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("If your game is not on the list, many reasons are possible, pls contact Administrator ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(10, 347, 533, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		
				Validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedgame != null && selectedConsole != null) {
					
					ArrayList<Booking> bookingsForThisCopy = new ArrayList<Booking>();
				for(Booking booking : Booking.findAllNotReeady()) {
					if(booking.getVideoGame().getGameName() == selectedgame.getGameName() && booking.getConsole().getNameConsole() == selectedConsole.getNameConsole()) {
						bookingsForThisCopy.add(booking);
					}
				}
				Booking goodBooking = new Booking();
				Copy copy;
				if (bookingsForThisCopy.size()>1 ) {
					
					goodBooking = goodBooking.findPriorityBooking(bookingsForThisCopy);
					goodBooking.setIsReady(1);
					goodBooking.update(goodBooking);
					copy = new Copy(connectPerson, selectedgame,selectedConsole,goodBooking.getId());
					connectPerson.getCopy().add(copy);
				}else if (bookingsForThisCopy.size()==1) {
					goodBooking = bookingsForThisCopy.get(0);
					goodBooking.setIsReady(1);
					goodBooking.update(goodBooking);
					copy = new Copy(connectPerson, selectedgame,selectedConsole,goodBooking.getId());
				}
				else {
					 copy = new Copy(connectPerson, selectedgame,selectedConsole,0);
				}
				connectPerson.getCopy().add(copy);
				copy.Create(copy);
				//update connectPerson
					PlayerWindow playerWindow = new PlayerWindow(connectPerson);
					JFrame playerFrame =  playerWindow.getFrame();
					playerFrame.setVisible(true);
					frame.dispose();
				}
				}
				});
	
		
		
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					PlayerWindow playerWindow = new PlayerWindow(connectPerson);
					JFrame playerFrame =  playerWindow.getFrame();
					playerFrame.setVisible(true);
					frame.dispose();
				}
				});
	}
}
