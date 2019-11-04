package parser;

import javax.swing.*;
import BreezySwing.*;

public class ParseGUI extends GBFrame {
	public static void main(String[] args) {
		JFrame frm = new ParseGUI();
		frm.setTitle("Longest Non-Decreasing Sequence");
		frm.setSize(300, 300);
		frm.setVisible(true);
	}

	JLabel inputLabel = addLabel("Input an arithmatic expression below:", 1, 1, 2, 1);
	JTextField inputField = addTextField("", 2, 1, 2, 1);
	JLabel outputLabel = addLabel("", 3, 1, 1, 1);
	JButton calculateButton = addButton("Calculate", 4, 1, 1, 1);
	JButton clearButton = addButton("Clear", 4, 2, 1, 1);
	JButton exitButton = addButton("Exit", 4, 3, 1, 1);

	Parser parser = new Parser();
	
	String input = "";
	double output = 0;
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == calculateButton) {
			input = inputField.getText();
			
			char[] expression = new char[input.length()];
			
			expression = input.toCharArray();
			
			int spcounter = parser.findSpaces(expression);

			char[] newexpression = new char[spcounter];
			
			newexpression = parser.removeSpaces(expression, spcounter);
			
			int num1 = parser.findNum1(newexpression);
			int num2 = parser.findNum2(newexpression);
			
			String operator = parser.findOperator(newexpression);
			
			switch(operator) {
			case "add" :
				output = num1 + num2;
				break;
				
			case "mult" :
				output = num1 * num2;
				break;
				
			case "divi" :
				output = (double)num1 / num2;
				break;
				
			case "subtr" :
				output = num1 - num2;
				break;
			
			}
			
			outputLabel.setText(output + "");
			revalidate();
		}
		
		if (buttonObj == clearButton) {
			inputField.setText("");
			outputLabel.setText("");
		}
		
		if (buttonObj == exitButton) {
			System.exit(1);
		}
	}
}