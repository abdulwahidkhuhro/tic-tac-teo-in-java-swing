import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicTacTeo implements ActionListener{
	private JFrame window = new JFrame();
	private GridLayout windowGrid = new GridLayout(3,3,5,5);
	private Container windowCon = window.getContentPane();
	private JButton[] button = new JButton[9];
	private boolean playerTurn = true;
	public TicTacTeo(){
		window.setBounds(0,0,500,500);
		windowCon.setLayout(windowGrid);
		
		for(int i = 0; i < button.length; i++){
			button[i] = new JButton();
			button[i].setBackground(Color.gray);
			button[i].setFont(new Font("Arial",Font.BOLD,25));
			windowCon.add(button[i]);
			
			button[i].addActionListener(this);
		}
		
		
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(button[0] == e.getSource()){
			playerMove(button[0]);
			System.out.println("Button : 0");
		}else if(button[1] == e.getSource()){
			playerMove(button[1]);
			System.out.println("Button : 1");
		}else if(button[2] == e.getSource()){
			playerMove(button[2]);
			System.out.println("Button : 2");
		}else if(button[3] == e.getSource()){
			playerMove(button[3]);
			System.out.println("Button : 3");
		}else if(button[4] == e.getSource()){
			playerMove(button[4]);
			System.out.println("Button : 4");
		}else if(button[5] == e.getSource()){
			playerMove(button[5]);
			System.out.println("Button : 5");
		}else if(button[6] == e.getSource()){
			playerMove(button[6]);
			System.out.println("Button : 6");
		}else if(button[7] == e.getSource()){
			playerMove(button[7]);
			System.out.println("Button : 7");
		}else if(button[8] == e.getSource()){
			playerMove(button[8]);
			System.out.println("Button : 8");
		}
	}
	
	public void playerMove(JButton button){
		if(playerTurn){
			button.setLabel("O");
			playerTurn = false;
		}else{
			button.setLabel("X");
			playerTurn = true;
		}
	}
	
	private boolean hasWon(){
		
	}
	public static void main(String[] args){
		new TicTacTeo();
	}
}