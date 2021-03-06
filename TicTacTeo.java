import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicTacTeo implements ActionListener{
	private JFrame window = new JFrame();
	private GridLayout windowGrid = new GridLayout(3,3,5,5);
	private Container windowCon = window.getContentPane();
	private JButton[] button = new JButton[9];
	private JMenuBar menuBar = new JMenuBar();
	private JMenu options = new JMenu("Options");
	
	private boolean playerTurn = true;
	private int playerOWinning = 0;
	private int playerXWinning = 0;
	
	private JMenuItem startMenu = new JMenuItem("Start");
	private JMenuItem stopMenu = new JMenuItem("Stop");
	private JMenuItem resumeMenu = new JMenuItem("Resume");
	
	public TicTacTeo(){
		window.setBounds(450,200,500,500);
		windowCon.setLayout(windowGrid);
		
		menuBar.add(options);
		options.add(startMenu);
		options.add(stopMenu);
		options.add(resumeMenu);
		startMenu.addActionListener(this);
		stopMenu.addActionListener(this);
		resumeMenu.addActionListener(this);
		window.setJMenuBar(menuBar);
		
		for(int i = 0; i < button.length; i++){
			button[i] = new JButton();
			button[i].setBackground(Color.gray);
			button[i].setFont(new Font("Arial",Font.BOLD,75));
			windowCon.add(button[i]);
			button[i].addActionListener(this);
		}
		
		window.setVisible(true);
		window.setTitle("Player O's Turn");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(button[0] == e.getSource()){
			playerMove(button[0]);
		}else if(button[1] == e.getSource()){
			playerMove(button[1]);
		}else if(button[2] == e.getSource()){
			playerMove(button[2]);
		}else if(button[3] == e.getSource()){
			playerMove(button[3]);
		}else if(button[4] == e.getSource()){
			playerMove(button[4]);
		}else if(button[5] == e.getSource()){
			playerMove(button[5]);
		}else if(button[6] == e.getSource()){
			playerMove(button[6]);
		}else if(button[7] == e.getSource()){
			playerMove(button[7]);
		}else if(button[8] == e.getSource()){
			playerMove(button[8]);
		}else if(startMenu == e.getSource()){
			start();
		}else if(stopMenu == e.getSource()){
			stop();
		}else if(resumeMenu == e.getSource()){
			resume();
		}
	}
	
	public void playerMove(JButton button){
		if(playerTurn){
			button.setLabel("O");
			button.setEnabled(false);
			window.setTitle("Player X's Turn");
			playerTurn = false;
			if(hasWon("O")){
				window.setTitle("Player O Won");
				stop();
			}
		}else{
			button.setLabel("X");
			playerTurn = true;
			button.setEnabled(false);
			window.setTitle("Player O's Turn");
			if(hasWon("X")){
				window.setTitle("Player X Won");
				stop();
			}
		}
	}

	public void stop(){
		for(int i = 0; i < button.length; i++){
			button[i].setEnabled(false);
		}
	}
	public void start(){
		for(int i = 0; i < button.length; i++){
			button[i].setEnabled(true);
			button[i].setLabel("");
			button[i].setBackground(Color.gray);
		}
	}
	
	public void resume(){
		for(int i = 0; i < button.length; i++){
			if(button[i].getLabel().equals("")){
				System.out.println("resume : if");
				button[i].setEnabled(true);
			}else{
				button[i].setEnabled(false);
			}
			
		}
	}
	
	
	private boolean hasWon(String label){
		if(isMatched(button[0],button[1],button[2],label)){
			return true;
		}else if(isMatched(button[3],button[4],button[5],label)){
			return true;
		}else if(isMatched(button[6],button[7],button[8],label)){
			return true;
		}else if(isMatched(button[0],button[3],button[6],label)){
			return true;
		}else if(isMatched(button[1],button[4],button[7],label)){
			return true;
		}else if(isMatched(button[2],button[5],button[8],label)){
			return true;
		}else if(isMatched(button[1],button[4],button[8],label)){
			return true;
		}else if(isMatched(button[2],button[4],button[6],label)){
			return true;
		}else if(isMatched(button[0],button[1],button[2],label)){
			return true;
		}
		return false;
	}
	
	private boolean isMatched(JButton b1, JButton b2, JButton b3, String label){
		boolean check = b1.getLabel().equals(label) && b2.getLabel().equals(label) && b3.getLabel().equals(label);
		if(check){
			b1.setBackground(Color.red);
			b2.setBackground(Color.red);
			b3.setBackground(Color.red);
		}
		return check;
	}
	
	
	public static void main(String[] args){
		new TicTacTeo();
	}
}