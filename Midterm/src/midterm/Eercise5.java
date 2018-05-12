package midterm;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Eercise5 {
	public static void main(String[] args) throws IOException

	{
		Scanner scan = new Scanner(System.in);
		File inputFile = new File("NewPassword2.txt");
		Scanner file = new Scanner(inputFile);
		
		int wordcount = 0;
		int passcount = 0;
		boolean passstrength = false;
		boolean passbad = false;
		
		while (file.hasNextLine())
		{
			file.nextLine();
			wordcount++;
		}
		 file.close();
		 inputFile = new File("NewPassword2.txt");
		 file = new Scanner(inputFile);
		 
		String [] word = new String[wordcount];
		for (int i = 0; i < wordcount; i++)
		{
			word[i] = file.nextLine();
		}
		
		String[] passwords = {"123456", "123456789", "qwerty", "12345678", "111111","1234567890", "1234567", "password", "123123", "987654321", "qwetyuiop", "mynoob", "123321", "666666", " 18atcskd2w", "7777777", "1q2w3e4r", "654321", "555555", "3rjs1la7qe", "google", "iq2w3e4r5t", "123qwe", "zxcvbnm", "1q2w3e"};
		System.out.println(word[43489]);
	}

}
