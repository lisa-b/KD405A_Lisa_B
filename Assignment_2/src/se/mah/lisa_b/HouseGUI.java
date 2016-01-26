package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class HouseGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseGUI frame = new HouseGUI();
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
	public HouseGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		textArea.append("Uppgift 1.2\n");
		House hus1 = new House(1960, 100);
		House hus2 = new House(1988, 350);
		House hus3 = new House(1850, 900);
		
		System.out.println("hus1: " + hus1.getYearBuilt() +" " + hus1.getSize());
		System.out.println("hus2: " + hus2.getYearBuilt() +" " + hus2.getSize());
		System.out.println("hus3: " + hus3.getYearBuilt() +" " + hus3.getSize());
		
		textArea.append("hus1: " + hus1.getYearBuilt() +" " + hus1.getSize() + "\n");
		textArea.append("hus2: " + hus2.getYearBuilt() +" " + hus2.getSize() + "\n");
		textArea.append("hus3: " + hus3.getYearBuilt() +" " + hus3.getSize() + "\n");
		
		textArea.append("Uppgift 1.3\n");
		House[] husLista = new House[10];
		
		husLista[0] = new House(1944, 430);
		husLista[1] = new House(1889, 445);
		husLista[2] = new House(1845, 200);
		husLista[3] = new House(1974, 843);
		husLista[4] = new House(1932, 234);
		husLista[5] = new House(1897, 432);
		husLista[6] = new House(1987, 567);
		husLista[7] = new House(1976, 789);
		husLista[8] = new House(1943, 987);
		husLista[9] = new House(1932, 765);
		
		for(House hus: husLista){
			textArea.append("hus byggt år/kvm: " + hus.getYearBuilt() +" / " + hus.getSize()+"\n");
		}
		Random rand = new Random();
		textArea.append("Uppgift 1.4\n");
		ArrayList<House> husena = new ArrayList<House>();
		for(int i = 0; i < 100; i++){
			husena.add(new House(rand.nextInt(216)+1800, rand.nextInt(990)+10));
		}
		for(House hus: husena){
			textArea.append("hus byggt år/kvm: " + hus.getYearBuilt() +" / " + hus.getSize()+"\n");
		}
	}

}
