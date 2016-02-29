package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Testa1 extends JFrame {

	private JPanel contentPane;
	private JTextField textStation;
	private JTextArea textResultStation;
	private JTextArea textResultJourney;
	
	//Skapa ny ArrayList med Stationer
	ArrayList<Station> searchStations = new ArrayList<Station>();
	private JTextField textStationFrom;
	private JTextField textStationTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testa1 frame = new Testa1();
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
	public Testa1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 514, 420);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Hållplats", null, panel, null);
		panel.setLayout(null);
		
		textStation = new JTextField();
		textStation.setBounds(6, 6, 319, 26);
		panel.add(textStation);
		textStation.setColumns(10);
		
		JButton btnStation = new JButton("Sök");
		btnStation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStation searchStation = new SearchStation();
				searchStation.start();
			}
		});
		btnStation.setBounds(337, 6, 117, 29);
		panel.add(btnStation);
		
		textResultStation = new JTextArea();
		textResultStation.setBounds(6, 44, 481, 324);
		panel.add(textResultStation);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Resa", null, panel_1, null);
		panel_1.setLayout(null);
		
		textStationFrom = new JTextField();
		textStationFrom.setText("67063");
		textStationFrom.setBounds(6, 6, 221, 26);
		panel_1.add(textStationFrom);
		textStationFrom.setColumns(10);
		
		textStationTo = new JTextField();
		textStationTo.setText("45006");
		textStationTo.setColumns(10);
		textStationTo.setBounds(276, 6, 211, 26);
		panel_1.add(textStationTo);
		
		JLabel label = new JLabel("-->");
		label.setBounds(239, 11, 38, 16);
		panel_1.add(label);
		
		JButton btnResa = new JButton("Sök resa");
		btnResa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchJourney searchJourney = new SearchJourney();
				searchJourney.start();
			}
		});
		btnResa.setBounds(370, 35, 117, 29);
		panel_1.add(btnResa);
		
		textResultJourney = new JTextArea();
		textResultJourney.setBounds(6, 66, 481, 302);
		panel_1.add(textResultJourney);
	}
	
	private class SearchStation extends Thread {
		public void run() {
			textResultStation.setText("Searching....");
			searchStations.clear();
			//Gör anrop till Skånetrafikens API och sök efter stationer,
			//lägg till resultaten i ArrayListen
			searchStations.addAll(Parser.getStationsFromURL(textStation.getText()));
			textResultStation.setText("");
			for (Station s: searchStations){
				textResultStation.append(s.getStationName() + " [" + s.getStationNbr() + "] (x: " + s.getLatitude() + " y: " + s.getLongitude() + ")\n");
			}
		}
	}
	
	private class SearchJourney extends Thread {
		public void run() {
			String result = new String();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			textResultJourney.setText("Searching....");
			
			//Skapa querystring för resa mellan Malmö C och Lund C, max 20 resultat
			String searchURL = Constants.getURL(textStationFrom.getText(), textStationTo.getText(), 1);
			System.out.println(searchURL);
			
			//Gör anrop till Skånetrafikens API och spara resorna i journeys
			Journeys journeys = Parser.getJourneys(searchURL);
			for (Journey j : journeys.getJourneys()) {
				Object[] data = {
						j.getStartStation(), //blir fel??
						j.getEndStation(),
						sdf.format(j.getDepDateTime().getTime()),
						j.getTimeToDeparture(),
						j.getTravelMinutes(),
						j.getNoOfChanges(),
						j.getNoOfZones(),
						j.getLineTypeName(),
						j.getLineOnFirstJourney()
						
				};
				result = String.format("Från %s till %s, avgår %s (om %s minuter)\nResan tar %s minuter, har %s byten och sträcker sig över %s zoner.\nResan börjar med %s (linje %s)", data);
			}
			textResultJourney.setText(result);
		}
	}
}
