package tt;

import javax.swing.JOptionPane;
import java.util.Random;

public class TicTac
{
	
	public static void main(String[]args)
	{
		GameBoard board = new GameBoard();
		Random rand = new Random();
		int row;
		int column;
		String input;
		
		boolean humanGo = true;
		boolean gameOver = false;
		
		board.showBoard();
		
		while(gameOver != true)
		{
			if(humanGo == true)
			{
				input = JOptionPane.showInputDialog("Player 1 Please input the coordinates of your move. ");
				row = Integer.parseInt(input.substring(0,1));
				column = Integer.parseInt(input.substring(2,3));
				
				
				while (!board.play(humanGo, row, column))
				{
					input = JOptionPane.showInputDialog("Please input the coordinates of your move. ");
					row = Integer.parseInt(input.substring(0,1));
					column = Integer.parseInt(input.substring(2,3)); 
				}
				humanGo = false;
			}
			else
			{
				input = JOptionPane.showInputDialog("Player 2 please input the coordinates of your move.");
				row = Integer.parseInt(input.substring(0,1));
				column = Integer.parseInt(input.substring(2,3)); 
				while(!board.play(humanGo, row, column))
				{
					row = Integer.parseInt(input.substring(0,1));
					column = Integer.parseInt(input.substring(2,3)); 
				}
				humanGo = true;
			}
			
			board.showBoard();
			
			if(board.checkWin()=='X')
			{
				JOptionPane.showInputDialog("Player 1 has won");
				JOptionPane.showInputDialog("The number of plays were: " + board.validPlayCount());
				gameOver = true;
			}

			else if(board.checkWin()=='O')
			{
				JOptionPane.showInputDialog("Player 2 has won. ");
				JOptionPane.showInputDialog("The number of plays were: " + board.validPlayCount());
				gameOver = true;
			}

			else if(board.checkWin()=='T')
			{
				JOptionPane.showInputDialog("None of the players have won it's a tie");
				JOptionPane.showInputDialog("The number of plays were: " + board.validPlayCount());
				gameOver = true;
			}
			
		}//while
	}//main
}//class
		
