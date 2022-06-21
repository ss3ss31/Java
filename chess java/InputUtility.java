package il.co.chessgame;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputUtility {
	public static String input()
	{
		try {
			return new BufferedReader(new InputStreamReader(System.in)).readLine();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}

