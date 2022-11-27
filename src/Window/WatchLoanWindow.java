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
import Pojo.Loan;
import Pojo.Player;

import javax.swing.JTextArea;

public class WatchLoanWindow {

	private JFrame frame;
	private Player connectPerson;
	private JTable table;
	private Loan loanSelected;
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
					WatchLoanWindow window = new WatchLoanWindow();
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
	public WatchLoanWindow() {
		initialize();
	}
	public WatchLoanWindow(Player connectPerson) {
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
		txtrIfYourGame.setText("dont give back a game at time cost 5/day credit");
		txtrIfYourGame.setBounds(548, 381, 168, 74);
		frame.getContentPane().add(txtrIfYourGame);
		ArrayList<Loan> LoanToShow = connectPerson.getOnGoingLoan();
		
		
		String[] colums={"DateStart","DateEnd","Owner","Game","Id"};
		Object data[][]=new Object[LoanToShow.size()+1][5];
		data[0][0]=colums[0];
		data[0][1]=colums[1];
		data[0][2]=colums[2];
		data[0][3]=colums[3];
		data[0][4]=colums[4];
		int cpt=1;
		for (Loan loan : LoanToShow) {
			data[cpt][0]=loan.getDateStartLoan();
			data[cpt][1]=loan.getDateEndLoan();
			data[cpt][2]=loan.getPlayer().getFirstName();
			data[cpt][3]=loan.getCopy().getVideoGame().getGameName();
			data[cpt][4]=loan.getId();
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
				
				try {
					if (e.getClickCount() == 1) {
						for(Loan loan : LoanToShow) {
						
							if(loan.getId() == (int)table.getModel().getValueAt(table.rowAtPoint(e.getPoint()),4))
							{
								loanSelected = loan;
							}
						
						}
					
					GiveBackCopyWindow giveBackCopyWindow = new GiveBackCopyWindow(connectPerson,loanSelected);
					JFrame giveBackCopyFrame =  giveBackCopyWindow.getFrame();
					giveBackCopyFrame.setVisible(true);
					frame.dispose();
					
						}
					}
				catch (Exception e1){
					e1.getMessage();
				}
		
			}});
			
	}
}
