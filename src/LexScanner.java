import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class LexScanner {

	final private String[] keywords = {"endif","then","else","if","end","begin","procedue", "integer", "variable",")", "(", "!=","=","/","*","-","+"};
	private String current;
	private Scanner s;
	public LexScanner(File f) throws FileNotFoundException {
		current = "";
		s = new Scanner(f);
	}
	public int lex(){
		char c = s.next(".").charAt(0);
		if(c==' '||c=='\n'){
			lex();
		}
		else if(c=='('){
			current = ""+c;
			return Arrays.asList(keywords).indexOf('(');
		}
		else if(c==')'){
			current = ""+c;
			return Arrays.asList(keywords).indexOf(')');
		}
		else if(c=='='){
			current = ""+c;
			return Arrays.asList(keywords).indexOf('=');
		}
		else if(c=='!'){
			if(s.next(".").charAt(0)=='='){
				current = "!=";
				return Arrays.asList(keywords).indexOf("!=");
			}
		}
		else if(c=='/'){
			current = ""+c;
			return Arrays.asList(keywords).indexOf('/');
		}
		else if(c=='+'){
			current = ""+c;
			return Arrays.asList(keywords).indexOf('+');
		}
		else if(c=='-'){
			current = ""+c;
			return Arrays.asList(keywords).indexOf('-');
		}
		else if(c=='*'){
			current = ""+c;
			return Arrays.asList(keywords).indexOf('*');
		}
		else if(c==';'){
			current = ""+c;
			return Arrays.asList(keywords).indexOf(';');
		}
		else if(c==':'){
			if(s.next(".").charAt(0)=='='){	
				current = ":=";
				return Arrays.asList(keywords).indexOf(":=");
			}
		}
		else if(current.isEmpty() && Character.isDigit(c)){
			Scanner s2 = new Scanner(System.in);
			while(Character.isDigit(c)){
				current = current +c;
				s2 = s;
				c = s.next(".").charAt(0);
			}
			s=s2;
			return Arrays.asList(keywords).indexOf("integer");
		}
		else if(Character.isAlphabetic(c)){
			current = current+ c;
			c = s.next(".").charAt(0);
			Scanner s4 = new Scanner(System.in);
			while(Character.isLetterOrDigit(c)){
				current = current +c;
				for(int i =0;i<7;i++){
					Scanner s3 = new Scanner(System.in);
					s3 = s;
					if(keywords[i].equals(current) && !Character.isLetterOrDigit(s.next(".").charAt(0))){
						s = s3;
						return i;
					}
				}
				s4 = s;
				c = s.next(".").charAt(0);
			}
			s = s4;
			return Arrays.asList(keywords).indexOf("variable"); 
		}
		return -1;
	}
	public String getCurrentToken() {
		return current;
	}

	public boolean endOfFile() {
		return true;
	}
}
