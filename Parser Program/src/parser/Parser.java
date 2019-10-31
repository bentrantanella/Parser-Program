package parser;

public class Parser {
	
	public int findSpaces(char[] exp) {
		int counter = 0;
		for(int x = 0; x < exp.length; x++) {
			if (exp[x] != ' ')
				counter++;
		}
		return counter;
	}
	
	public char[] removeSpaces(char[] expression, int spcounter) {

		int counter = 0;
		char[] newexp = new char[spcounter];
		for(int y = 0; y < expression.length; y++) {
			if (expression[y] != ' ') {
				newexp[counter] = expression[y];
				counter++;
			}
		}
		
		return newexp;
	}
	
	

}

