package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class AnimalsGUI extends JFrame {

	private JPanel contentPane;
	private ArrayList<Animal> animals = new ArrayList<Animal>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		Animal djuret;
		
		djuret = new Dog("Hundus Storus", 3, false, "Karo");
		animals.add(djuret);
		
		djuret = new Cat("Kattus Lillus", 5, 9);
		djuret.setFriendlyName("Katten Findus");
		animals.add(djuret);
		
		djuret = new Snake("Slangus Longus", true);
		djuret.setFriendlyName("Ormen Orm");
		animals.add(djuret);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		
		for(Animal animal: animals){
			textArea.append(animal.getInfo() + "\n");
		}
	}

}
