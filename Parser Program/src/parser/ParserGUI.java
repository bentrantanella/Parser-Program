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
			
			int spcounter = parser.findSpaces(expression);

			char[] newexpression = new char[spcounter];
			
			newexpression = parser.removeSpaces(expression, spcounter);
			
			for(int x = 0; x < newexpression.length; x++)
				output.concat(newexpression[x] + " ");
			
			outputLabel.setText(output);
			revalidate();
		}
		
		if (buttonObj == clearButton) {
			
		}
		
		if (buttonObj == exitButton) {
			System.exit(1);
		}
	}
}
