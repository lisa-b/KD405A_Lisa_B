package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BikeStoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrice;
	private JTextField txtColor;
	private JTextField txtSize;
	
	BikeStore store = new BikeStore();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeStoreGUI frame = new BikeStoreGUI();
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
	public BikeStoreGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrILager = new JTextArea();
		txtrILager.setBounds(33, 86, 316, 297);
		contentPane.add(txtrILager);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(117, 409, 195, 26);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Bike");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.addBike(txtColor.getText(), Integer.parseInt(txtSize.getText()), Integer.parseInt(txtPrice.getText()));
				txtrILager.setText(store.getAllBikes());
			}
		});
		btnNewButton.setBounds(33, 531, 117, 29);
		contentPane.add(btnNewButton);
		
		txtColor = new JTextField();
		txtColor.setBounds(117, 447, 195, 26);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		txtSize = new JTextField();
		txtSize.setBounds(117, 485, 195, 26);
		contentPane.add(txtSize);
		txtSize.setColumns(10);
		
		JLabel lblAffren = new JLabel("Affären");
		lblAffren.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblAffren.setBounds(31, 12, 176, 34);
		contentPane.add(lblAffren);
		
		JLabel lblILager = new JLabel("I lager:");
		lblILager.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblILager.setBounds(33, 58, 78, 26);
		contentPane.add(lblILager);
		
		JLabel lblPris = new JLabel("Pris:");
		lblPris.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPris.setBounds(33, 413, 61, 16);
		contentPane.add(lblPris);
		
		JLabel lblNewLabel = new JLabel("Färg:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 451, 61, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblStorlek = new JLabel("Storlek:");
		lblStorlek.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStorlek.setBounds(33, 489, 61, 16);
		contentPane.add(lblStorlek);
	}
}
