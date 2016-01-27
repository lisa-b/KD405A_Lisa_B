package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Calculator myCalculator;
	private JTextField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CalculatorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(1);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
				
			}
		});
		button_1.setBounds(42, 25, 80, 29);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(2);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_2.setBounds(165, 25, 80, 29);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(3);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_3.setBounds(291, 25, 80, 29);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(4);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_4.setBounds(42, 66, 80, 29);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(5);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_5.setBounds(165, 66, 80, 29);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(6);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_6.setBounds(291, 66, 80, 29);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(7);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_7.setBounds(42, 107, 80, 29);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(8);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_8.setBounds(165, 107, 80, 29);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(9);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_9.setBounds(291, 107, 80, 29);
		contentPane.add(button_9);
		
		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.numberButtonPressed(0);
				textField_1.setText(String.valueOf(myCalculator.getOperand()));
			}
		});
		button_0.setBounds(165, 153, 80, 29);
		contentPane.add(button_0);
		
		JButton button_10 = new JButton("+");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.plus();
				textField_1.setText("+");
			}
		});
		button_10.setBounds(42, 194, 60, 29);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.minus();
				textField_1.setText("-");
			}
		});
		button_11.setBounds(137, 194, 60, 29);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("*");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.mult();
				textField_1.setText("*");
			}
		});
		button_12.setBounds(219, 194, 60, 29);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("=");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.equals();
				textField_1.setText(String.valueOf(myCalculator.getResult()));
			}
		});
		button_13.setBounds(311, 195, 60, 29);
		contentPane.add(button_13);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 273, 212, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.clear();
				textField_1.setText("");
			}
		});
		btnClear.setBounds(154, 327, 117, 29);
		contentPane.add(btnClear);

		myCalculator = new Calculator();



	}
}