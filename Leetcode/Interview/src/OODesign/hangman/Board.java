package OODesign.hangman;

public class Board 
{

	public static final String[][] HANGMANPICS = new String[][]			
	{
		{
			"  +---+",
			"  |   |",
			"      |",
			"      |",
			"      |",
			"      |",
			"========="
		},
		{
			"  +---+",
			"  |   |",
			"  O   |",
			"      |",
			"      |",
			"      |",
			"========="
		},
		{
			"  +---+",
			"  |   |",
			"  O   |",
			"  |   |",
			"      |",
			"      |",
			"========="
		},
		{
			"  +---+",
			"  |   |",
			"  O   |",
			" /|   |",
			"      |",
			"      |",
			"========="
		},
		{
			"  +---+",
			"  |   |",
			"  O   |",
			" /|\\  |",
			"      |",
			"      |",
			"========="
		},
		{
			"  +---+",
			"  |   |",
			"  O   |",
			" /|\\  |",
			" /    |",
			"      |",
			"========="
		},
		{
			"  +---+",
			"  |   |",
			"  O   |",
			" /|\\  |",
			" / \\  |",
			"      |",
			"========="
		},
	};
	
	public static void displayBoard(int missedLetter)
	{
		String[] board = HANGMANPICS[missedLetter];
		for(int i =0; i < board.length; i++)
		{
			System.out.println(board[i]);
		}
	}
	public static void main(String[] argv)
	{
		for(int i =0; i < HANGMANPICS.length;i++)
		{
			displayBoard(i);
		}
	}
}
