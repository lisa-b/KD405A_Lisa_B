package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAndersAndersson;
	private JTextField textField;
	private JTextField txtStorgatan;
	private JTextField txtMalm;
	private JTextField txtMalm_1;
	private JTextField textField_1;
	private JTextField txtAndersvintergatanrymden;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		String columnNames[] = {"Medlemmar"};
		String dataValues[][] = 
			{
					{"Anders Andersson"},
					{"Beata Birgersson"},
					{"Claes Carlsson"},
					{"David Danielsson"},
					{"Emilia Eskilsson"},
					{"Fredrik Fredrisksson"},
					{"Gunvor Granlund"},
					{"Hans Hjelte"},
					{"Iris Is"},
					{"Janne Jarl"},
					{"Karin Knutsson"},
					{"Lena Latman"},
				
			};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 622);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArkiv = new JMenu("Arkiv");
		menuBar.add(mnArkiv);
		
		JMenuItem mntmSkrivUt = new JMenuItem("Skriv ut...");
		mnArkiv.add(mntmSkrivUt);
		
		JMenuItem mntmAvsluta = new JMenuItem("Avsluta");
		mnArkiv.add(mntmAvsluta);
		
		JMenu mnNewMenu = new JMenu("Medlem");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNyMedlem = new JMenuItem("Ny medlem");
		mnNewMenu.add(mntmNyMedlem);
		
		JMenuItem mntmHittaMedlem = new JMenuItem("Hitta medlem");
		mnNewMenu.add(mntmHittaMedlem);
		
		JMenu mnHjlp = new JMenu("Hjälp");
		menuBar.add(mnHjlp);
		
		JMenuItem mntmHjlp = new JMenuItem("Hjälp");
		mnHjlp.add(mntmHjlp);
		
		JMenuItem mntmOmProgrammet = new JMenuItem("Om programmet");
		mnHjlp.add(mntmOmProgrammet);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(468, 78, 243, 479);
		contentPane.add(scrollPane);
		
		table = new JTable(dataValues, columnNames);
		scrollPane.setViewportView(table);
	

		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/se/mah/lisa_b/images/AA.png")));
		label.setBounds(37, 18, 343, 48);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 78, 363, 479);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNamn = new JLabel("Namn");
		panel.add(lblNamn, "2, 2, left, default");
		
		txtAndersAndersson = new JTextField();
		txtAndersAndersson.setText("Anders Andersson");
		panel.add(txtAndersAndersson, "4, 2, fill, default");
		txtAndersAndersson.setColumns(10);
		
		JLabel lblPersonnummer = new JLabel("Personnr");
		panel.add(lblPersonnummer, "2, 4, left, default");
		
		textField = new JTextField();
		textField.setText("950314-1541");
		panel.add(textField, "4, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress");
		panel.add(lblAdress, "2, 6, left, default");
		
		txtStorgatan = new JTextField();
		txtStorgatan.setText("Vintergatan 42");
		panel.add(txtStorgatan, "4, 6, fill, default");
		txtStorgatan.setColumns(10);
		
		txtMalm = new JTextField();
		txtMalm.setText("212 28");
		panel.add(txtMalm, "4, 8, fill, default");
		txtMalm.setColumns(10);
		
		txtMalm_1 = new JTextField();
		txtMalm_1.setText("Malmö");
		panel.add(txtMalm_1, "4, 10, fill, default");
		txtMalm_1.setColumns(10);
		
		JLabel lblTelefonnummer = new JLabel("Telefonnr");
		panel.add(lblTelefonnummer, "2, 12, left, default");
		
		textField_1 = new JTextField();
		textField_1.setText("070-123 45 67");
		panel.add(textField_1, "4, 12, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblEpost = new JLabel("E-post");
		panel.add(lblEpost, "2, 14, left, default");
		
		txtAndersvintergatanrymden = new JTextField();
		txtAndersvintergatanrymden.setText("anders@vintergatan.rymden");
		panel.add(txtAndersvintergatanrymden, "4, 14, fill, default");
		txtAndersvintergatanrymden.setColumns(10);
		
		JLabel lblBild = new JLabel("Bild");
		panel.add(lblBild, "2, 16, left, top");
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Main.class.getResource("/se/mah/lisa_b/images/andrew.png")));
		panel.add(label_1, "4, 16");
	}
}
