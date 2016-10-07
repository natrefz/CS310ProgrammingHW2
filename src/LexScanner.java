import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LexScanner {

	final private String[] keywords = {"endif","then","else","if",")", "(", "!=","=","/","*","-","+","end","begin","procedue"};
	private String current;
	private Scanner s;
	public LexScanner(File f) throws FileNotFoundException {
		current = "";
		s = new Scanner(f);
	}
	public int lex(){
		char c = s.next(".").charAt(0);
		return 0;
	}
	public String getCurrentToken() {
		return current;
	}

	public boolean endOfFile() {
		return true;
	}
}
