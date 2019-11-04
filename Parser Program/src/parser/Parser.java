package parser;

public class Parser {

	int operatorpos = 0;

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

	public int findNum1(char[] expression) {
		int num;
		String number = "";
		int start;

		if (expression[1] == '-') {
			number = number.concat("-");
			start = 2;
		} else
			start = 1;

		for (int j = start; j < expression.length; j++) {
			if (Character.isDigit(expression[j]) == true)
				number = number.concat(expression[j] + "");
			else {
				operatorpos = j;
				break;
			}
				
		}

		num = Integer.parseInt(number);
		return num;
	}

	public int findNum2(char[] expression) {
		int num;
		int start;
		String number = "";
		if (expression[operatorpos + 1] == '-') {
			number = number.concat("-");
			start = operatorpos + 2;
		} else
			start = operatorpos + 1;
		for  (int i = start; i < expression.length; i++)
		{
			number = number.concat(expression[i] + "");
		}
		
		num = Integer.parseInt(number);
		return num;
	}

	public String findOperator(char[] expression) {
		String type = "";

		
		if (expression[operatorpos] == '+') {
			type = "add";
		} else if (expression[operatorpos] == '*') {
			type = "mult";	
		} else if (expression[operatorpos] == '/') {
			type = "divi";
		} else if (expression[operatorpos] == '-') {
			type = "subtr";
		}
		

		if (type == "")
			type = "error";

		return type;
	}

}
