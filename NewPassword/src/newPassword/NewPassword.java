package newPassword;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// Author Nathan Schaffner
import javax.swing.*;
import javax.swing.JOptionPane;

public class NewPassword
{
	public static boolean tooShort(String s)
	// return true if s is too short; false otherwise
	{
		if (s.length() < 8)
			return true;
		else
			return false;
	}// end boolean tooShort

	public static boolean noSpecialCharacters(String s)
	// return true if there are no special characters in the string
	{
		if (s.contains("!"))
			return false;
		else if (s.contains("@"))
			return false;
		else if (s.contains("$"))
			return false;
		else
			return true;
	}// end boolean noSpecialCharacters

	public static boolean space(String s)
	// returns true if the string has a space
	{
		if (s.contains(" "))
			return true;
		else
			return false;

	}// end boolean space

	public static boolean badStart(String s)
	// returns true if the string starts with an ! or a ?
	{
		if (s.charAt(0) == '!')
			return true;
		if (s.charAt(0) == '?')
			return true;
		else
			return false;
	}// end boolean badStart

	public static boolean sameFirstThree(String s)
	// returns true if the first three are the same
	{
		if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2))
			return true;
		else
			return false;
	}// end boolean sameFirstThree

	public static boolean sameLastThree(String s)
	// returns true if the last three are the same
	{
		if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)
				&& s.charAt(s.length() - 2) == s.charAt(s.length() - 3))
			return true;
		else
			return false;
	}// end boolean sameLastThree

	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		File inputFile = new File("NewPassword2.txt");
		Scanner file = new Scanner(inputFile);

		int wordcount = 0;
		int passcount = 0;
		boolean passbad = false;
		boolean passstrength = false;

		while (file.hasNextLine())
		{
			file.nextLine();
			wordcount++;
		}// while
		file.close();
		inputFile = new File("NewPassword2.txt");
		file = new Scanner(inputFile);

		String[] word = new String[wordcount];
		for (int i = 0; i < wordcount; i++)
		{
			word[i] = file.nextLine();
		}// for

		String[] passwords = { "123456", "123456789", "qwerty", "12345678", "111111", "1234567890", "1234567",
				"password", "123123", "987654321", "qwetyuiop", "mynoob", "123321", "666666", " 18atcskd2w", "7777777",
				"1q2w3e4r", "654321", "555555", "3rjs1la7qe", "google", "iq2w3e4r5t", "123qwe", "zxcvbnm", "1q2w3e" };
		
		{
		String pw = " ";
		for (int i = 0; i < 4; i++)
		{	
			pw = JOptionPane.showInputDialog("Please create a password \n"
					+ "1	...The password must be at least 8 characters long \n"
					+ "2	...The password must contain at least one special character chosen from '!', '@', or '$'. \n"
					+ "3	...The password must NOT contain spaces or begin with an exclamation [!] or a question mark [?]. \n"
					+ "4	...The first 3 characters cannot be the same. \n"
					+ "5	...The last 3 characters cannot be the same. \n"
					+ "6	...You only have 4 tries to input a valid password. \n");
			
				if (pw.length() < 8)
				{	
					passcount++;
					JOptionPane.showMessageDialog(null, "Reject. Password is too short. " );
					passbad = true;
				}//if
				else if (noSpecialCharacters(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null, "Reject. No Special Characters. ");
					passbad = true;
				}//else if
				else if (space(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null, "Reject. There is a space in the password. ");
					passbad = true;
				}//else if
				else if (badStart(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null, "Reject. Password starts with an ! or ?. ");
					passbad = true;
				}//else if
				else if (sameFirstThree(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null, "Reject. Firs three characters are the same. ");
					passbad = true;
				}//else if
				else if (sameLastThree(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null, "Reject. Last three characters are the same. ");
					passbad = true;
				}
				else
				{
				//JOptionPane.showMessageDialog(null, "Accepted, thank you.");
				i = 4;
				}//else
		// end main
			for (int j = 0; j < word.length; j++) 
			{
				if (word[j].equals(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null,
							"Password strength is weak. Try again.");
					passbad = true;
				}//if
			}//for

			for (int x = 0; x < passwords.length; x++)
			{
				if (passwords[x].equals(pw))
				{
					passcount++;
					JOptionPane.showMessageDialog(null,
							"Password is lazy.");
					passbad = true;
				}//if
			}//for
		}
		if ((passbad == false))
		{
			JOptionPane.showMessageDialog(null, "Password Accepted, thank you");
		}//if
		else 
		{
			JOptionPane.showMessageDialog(null, "Your Account has been locked. come back later. ");
		}//else
		
		}
	} // end main
}// end class
