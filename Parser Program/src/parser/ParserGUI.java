package parser;

import javax.swing.*;
import BreezySwing.*;

public class ParserGUI extends GBFrame {
	public static void main(String[] args) {
		JFrame frm = new ParserGUI();
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
	String output = "";
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == calculateButton) {
			input = inputField.getText();
			char[] expression = new char[input.length()];
			expression = input.toCharArray();
			
			if (expression[0] != '=')
				messageBox("Input must begn with an equals sign");
			else
			{
				int spcounter = parser.findSpaces(expression);
				char[] newexpression = new char[spcounter];
				newexpression = parser.removeSpaces(expression, spcounter);
				
				double num1 = parser.findNum1(newexpression);
				System.out.println(num1);
				String type = parser.findOperator(newexpression);
				
				if (type == "error")
					messageBox("Invalid input");
				
				System.out.println(type);
				outputLabel.setText(output);
				revalidate();
			}
		}
		
		if (buttonObj == clearButton) {
			inputField.setText("");
			outputLabel.setText("");
			output = "";
			input = "";
		}
		
		if (buttonObj == exitButton) {
			System.exit(1);
		}
	}
}
