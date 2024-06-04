package cmd;
import java.util.Scanner;
//TypeRacer Word/Character Count, by ViveTheModder
public class MainApp 
{
	public static int getWordOrCharCount(String input, boolean arg)
	{
		int cnt=0;
		String[] words = input.split(" ");
		for (int i=0; i<words.length; i++)
		{
			if (words[i].length()>4)
			{
				if (arg==false) cnt++; //count words
				else cnt+=words[i].length(); //count characters
			}
		}
		return cnt;
	}
	public static void main(String[] args)
	{
		boolean isWordOrChar=false; //-w arg (default case)
		if (args.length!=1)
		{
			System.out.println("Invalid number of arguments ("+args.length+"). Only one argument is required.");
			System.exit(1);
		}
		if (!args[0].equals("-w"))
		{
			if (args[0].equals("-c")) isWordOrChar=true; //-c arg
			else System.exit(2); //termination due to invalid argument
		}
		
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter a quote:");
			String input = sc.nextLine();
			int cnt = getWordOrCharCount(input, isWordOrChar);
			if (cnt==0) break;
			
			String wordOrChar="Words";
			if (isWordOrChar==true) wordOrChar="Chars";
			System.out.println("Number of TypeRacer "+wordOrChar+": "+cnt);
		}
		sc.close(); System.exit(0);
	}
}