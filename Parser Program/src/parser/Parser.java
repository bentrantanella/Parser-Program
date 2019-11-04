package parser;

public class Parser {

	public int findSpaces(char[] exp) {
		int counter = 0;
		for (int x = 0; x < exp.length; x++) {
			if (exp[x] != ' ')
				counter++;
		}
		return counter;
	}

	public char[] removeSpaces(char[] expression, int spcounter) {

		int counter = 0;
		char[] newexp = new char[spcounter];
		for (int y = 0; y < expression.length; y++) {
			if (expression[y] != ' ') {
				newexp[counter] = expression[y];
				counter++;
			}
		}

		return newexp;
	}

	public double findNum1(char[] expression) {
		double num;
		String number = "";
		boolean isnegative = false;
		int start, end;
		
		if (expression[1] == '-')
		{
			isnegative = true;
			start = 2;
		}
		else start = 1;
		
		for(int j = start; j < expression.length; j++)
		{
			if (Character.isDigit(expression[j]) == true)
				number = number.concat(expression[j] + "");
			else break;
		}
		
		
		return num;
	}

	public String findOperator(char[] expression) {
		String type = "";

		for (int j = 0; j < expression.length; j++) {
			if (expression[j] == '+')
				type = "add";
			else if (expression[j] == '*')
				type = "mult";
			else if (expression[j] == '/')
				type = "divi";
			else if (expression[j] == '-')
				type = "subtr";
		}

		if (type == "")
			type = "error";

		return type;
	}

}
