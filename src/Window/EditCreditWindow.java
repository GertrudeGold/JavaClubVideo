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
import javax.swing.table.DefaultTableModel;


import Pojo.VideoGame;

import javax.swing.JButton;

public class EditCreditWindow {

	private JFrame frame;
	private JTable table;
	private VideoGame videoGame;
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
					EditCreditWindow window = new EditCreditWindow();
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
	public EditCreditWindow() {
		initialize();
	}

	
	 
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 787, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//create a table with informations for edit
			ArrayList<VideoGame> videoGames= VideoGame.findAll();
		int size= videoGames.size();
		String[] colums={"Name","Credit cost","Id"};

		Object data[][]=new Object[size+1][3];
		data[0][0]=colums[0];
		data[0][1]=colums[1];
		data[0][2]=colums[2];
		int cpt=1;
		for(VideoGame videoGame : videoGames) {
			data[cpt][0]=videoGame.getGameName();
			data[cpt][1]=videoGame.getCreditPrice();
			data[cpt][2]=videoGame.getId();
			cpt++;
		} 
		table = new JTable();

		table.setModel(new DefaultTableModel(data,colums));
		table.setBounds(10, 11, 561, 518);
		table.setFont(new Font("Courier New", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		frame.getContentPane().add(table);
		
		
		JButton BackButton = new JButton("Back");
		BackButton.setBounds(672, 506, 89, 23);
		frame.getContentPane().add(BackButton);
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AdministratorWindow administratorWindow = new AdministratorWindow();
					JFrame administratorFrame =  administratorWindow.getFrame();
					administratorFrame.setVisible(true);
					frame.dispose();
				}
				});
		JButton validate = new JButton("Validate");
		validate.setBounds(672, 461, 89, 23);
		frame.getContentPane().add(validate);
		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			for(int i=1;i<data.length;i++) {
				
			int id = (int) table.getModel().getValueAt(i, 2);
			int newCreditPrice =Integer.valueOf(table.getModel().getValueAt(i,1).toString()) ;
			String videoName = (String)table.getModel().getValueAt(i, 0);
			videoGame = new VideoGame(newCreditPrice,videoName,id);
			videoGame.update(videoGame);
			
			}	
				
			}
			});
	
		
	}
}

		
						
					
						
					 
								
							
						
						
					
	


