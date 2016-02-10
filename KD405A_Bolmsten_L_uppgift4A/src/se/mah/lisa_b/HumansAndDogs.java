package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumansAndDogs extends JFrame {

	private JPanel contentPane;
	private JTextField textNameHuman;
	private JTextField textNameDog;
	
	private Human h1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumansAndDogs frame = new HumansAndDogs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HumansAndDogs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Humans and Dogs");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(127, 17, 170, 23);
		contentPane.add(lblNewLabel);
		
		JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setBounds(17, 193, 391, 65);
		contentPane.add(textAreaInfo);
		
		JTextArea textAreaError = new JTextArea();
		textAreaError.setBounds(17, 292, 391, 44);
		contentPane.add(textAreaError);
		
		textNameHuman = new JTextField();
		textNameHuman.setBounds(28, 52, 130, 26);
		contentPane.add(textNameHuman);
		textNameHuman.setColumns(10);
		
		textNameDog = new JTextField();
		textNameDog.setBounds(28, 90, 130, 26);
		contentPane.add(textNameDog);
		textNameDog.setColumns(10);
		
		JButton btnNewButton = new JButton("New Human");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNameHuman.getText().length() > 2){
					h1 = new Human(textNameHuman.getText());
				}
				else {
					textAreaError.setText("Name too short!");
				}
			}
		});
		btnNewButton.setBounds(159, 52, 117, 29);
		contentPane.add(btnNewButton);
	
		
		JButton btnNewButton_1 = new JButton("Buy Dog");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					h1.buyDog(new Dog(textNameDog.getText()));		
				}
				catch(NullPointerException ex){
					textAreaError.setText("Need to create human first!");
				}
			
			}
		});
		btnNewButton_1.setBounds(159, 90, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textAreaInfo.setText(h1.getInfo());
				}
				catch(NullPointerException ex) {
					textAreaError.setText("Need to create human first!");
				}
				
			}
		});
		btnNewButton_2.setBounds(159, 131, 117, 29);
		contentPane.add(btnNewButton_2);
		

		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(17, 176, 61, 16);
		contentPane.add(lblInfo);
		
		JLabel lblError = new JLabel("Error");
		lblError.setBounds(17, 275, 61, 16);
		contentPane.add(lblError);
	}
}
