

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalci extends JFrame implements ActionListener {

	JTextField display;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bequal, bminus, bplus, delete, clear;

	int num1 = 0, num2 = 0, total = 0, operator = 0;

	public MyCalci() {

		setTitle("Simple Calculator");
		setSize(350, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));

		display = new JTextField();
		display.setFont(new Font("Arial", Font.BOLD, 28));
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		display.setBackground(Color.WHITE);
		add(display, BorderLayout.NORTH);

		// Button panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 5, 5));

		String[] buttons = {
			"7", "8", "9", "/",
			"4", "5", "6", "*",
			"1", "2", "3", "-",
			"C", "0", "DEL", "+",
			"=" 
		};

		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.PLAIN, 20));
			button.setFocusPainted(false);
			button.addActionListener(this);
			panel.add(button);

			// Assign the newly created button to its matching field
			switch (text) {
				case "1": b1 = button; break;
				case "2": b2 = button; break;
				case "3": b3 = button; break;
				case "4": b4 = button; break;
				case "5": b5 = button; break;
				case "6": b6 = button; break;
				case "7": b7 = button; break;
				case "8": b8 = button; break;
				case "9": b9 = button; break;
				case "0": b0 = button; break;
				case "+": bplus = button; break;
				case "-": bminus = button; break;
				case "=": bequal = button; break;
				case "C": clear = button; break;
				case "DEL": delete = button; break;
			}
		}

		add(panel, BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		new MyCalci().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clear) {
			display.setText("");
			num1 = 0;
			num2 = 0;
			total = 0;
			operator = 0;
		}

		if (e.getSource() == delete) {
			String str = display.getText();
			if (str.length() > 0) {
				str = str.substring(0, str.length() - 1);
				display.setText(str);
			}
		}

		if (e.getSource() == bplus) {
			operator = 1;
			num1 = Integer.parseInt(display.getText().isEmpty() ? "0" : display.getText());
			display.setText("");
		}

		if (e.getSource() == bminus) {
			operator = 2;
			num1 = Integer.parseInt(display.getText().isEmpty() ? "0" : display.getText());
			display.setText("");
		}

		if (e.getSource() == bequal) {
			num2 = Integer.parseInt(display.getText().isEmpty() ? "0" : display.getText());

			if (operator == 1) {
				total = num1 + num2;
			}
			if (operator == 2) {
				total = num1 - num2;
			}

			display.setText("" + total);
		}

		if (e.getSource() == b1) {
			display.setText(display.getText() + "1");
		}
		if (e.getSource() == b2) {
			display.setText(display.getText() + "2");
		}
		if (e.getSource() == b3) {
			display.setText(display.getText() + "3");
		}
		if (e.getSource() == b4) {
			display.setText(display.getText() + "4");
		}
		if (e.getSource() == b5) {
			display.setText(display.getText() + "5");
		}
		if (e.getSource() == b6) {
			display.setText(display.getText() + "6");
		}
		if (e.getSource() == b7) {
			display.setText(display.getText() + "7");
		}
		if (e.getSource() == b8) {
			display.setText(display.getText() + "8");
		}
		if (e.getSource() == b9) {
			display.setText(display.getText() + "9");
		}
		if (e.getSource() == b0) {
			display.setText(display.getText() + "0");
		}
	}
}