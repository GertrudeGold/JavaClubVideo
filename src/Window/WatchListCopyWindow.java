package Window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Pojo.Copy;
import Pojo.Player;

import javax.swing.JTextArea;

public class WatchListCopyWindow {

	private JFrame frame;
	private Player connectPerson;
	private JTable table;
	private Copy copySelected;
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
					WatchListCopyWindow window = new WatchListCopyWindow();
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
	public WatchListCopyWindow() {
		initialize();
	}
	public WatchListCopyWindow(Player connectPerson) {
		this.connectPerson = connectPerson;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Backbutton = new JButton("Back");
		Backbutton.setBounds(576, 500, 130, 23);
		frame.getContentPane().add(Backbutton);
		
		JButton Reservebutton = new JButton("Reservation");
		Reservebutton.setBounds(576, 466, 130, 23);
		frame.getContentPane().add(Reservebutton);
		
		JTextArea txtrIfYourGame = new JTextArea();
		txtrIfYourGame.setEditable(false);
		txtrIfYourGame.setLineWrap(true);
		txtrIfYourGame.setText("If your game is not on the list, pls make a reservation");
		txtrIfYourGame.setBounds(548, 381, 168, 74);
		frame.getContentPane().add(txtrIfYourGame);
		
		ArrayList<Copy> copyToShow = Copy.findall();
		String[] colums={"Game","Owner","Credit","Console","Id"};
		Object data[][]=new Object[copyToShow.size()+1][5];
		data[0][0]=colums[0];
		data[0][1]=colums[1];
		data[0][2]=colums[2];
		data[0][3]=colums[3];
		data[0][4]=colums[4];
		int cpt=1;
		for (Copy copy : copyToShow) {
			data[cpt][0]=copy.getVideoGame().getGameName();
			data[cpt][1]=copy.getPlayer().getFirstName();
			data[cpt][2]=copy.getVideoGame().getCreditPrice();
			data[cpt][3]=copy.getConsole().getNameConsole();
			data[cpt][4]=copy.getId();
			cpt++;
		}
		table = new JTable();

		table.setModel(new DefaultTableModel(data,colums));




		table.setBounds(10, 11, 506, 491);
		table.setFont(new Font("Courier New", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		frame.getContentPane().add(table);
		Backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					PlayerWindow playerWindow = new PlayerWindow(connectPerson);
					JFrame playerFrame =  playerWindow.getFrame();
					playerFrame.setVisible(true);
					frame.dispose();
				}
				});
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					for(Copy copy : copyToShow) {
						
						if(copy.getId() == (int)table.getModel().getValueAt(table.rowAtPoint(e.getPoint()),4)
								&& copy.getPlayer().getId() != connectPerson.getId())
						{
							copySelected = copy;
						}
						
					}
					
					LoanWindow loanWindow = new LoanWindow(connectPerson,copySelected);
					JFrame loanFrame =  loanWindow.getFrame();
					loanFrame.setVisible(true);
					frame.dispose();
					
				}
				
				
				
			}
		
	});
			
	}
}
