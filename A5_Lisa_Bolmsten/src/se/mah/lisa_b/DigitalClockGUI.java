package se.mah.lisa_b;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private ClockLogic clockLogic = new ClockLogic(this);
	
	private JTextField alarmHourText;
	private JTextField alarmMinuteText;
	private JButton btnClearAlarm;
	private JLabel alarmRingingLabel;
	private JLabel alarmLabel;
	private JLabel alarmLabelDescription;
	private JLabel timeLabel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setTitle("Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		timeLabel = new JLabel("");
		timeLabel.setBounds(6, 6, 143, 43);
		contentPane.add(timeLabel);
		
		alarmLabelDescription = new JLabel("Alarm:");
		alarmLabelDescription.setEnabled(false);
		alarmLabelDescription.setBounds(6, 100, 61, 16);
		contentPane.add(alarmLabelDescription);
		
		alarmLabel = new JLabel("00:00:00");
		alarmLabel.setEnabled(false);
		alarmLabel.setBounds(6, 121, 61, 16);
		contentPane.add(alarmLabel);
		
		alarmHourText = new JTextField();
		alarmHourText.setBounds(113, 95, 54, 26);
		contentPane.add(alarmHourText);
		alarmHourText.setColumns(10);
		
		alarmMinuteText = new JTextField();
		alarmMinuteText.setBounds(179, 95, 54, 26);
		contentPane.add(alarmMinuteText);
		alarmMinuteText.setColumns(10);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.setAlarm(
						Integer.parseInt(alarmHourText.getText()), 
						Integer.parseInt(alarmMinuteText.getText())
				);
			}
		});
		btnSetAlarm.setBounds(245, 95, 117, 29);
		contentPane.add(btnSetAlarm);
		
		btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.clearAlarm();
			}
		});
		btnClearAlarm.setBounds(245, 131, 117, 29);
		contentPane.add(btnClearAlarm);
		
		alarmRingingLabel = new JLabel("ALARM!");
		alarmRingingLabel.setVisible(false);
		alarmRingingLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		alarmRingingLabel.setBounds(55, 190, 61, 16);
		contentPane.add(alarmRingingLabel);
	}
	
	/**
	 * Update label displaying the time.
	 * @param time
	 */
	public void setTimeOnLabel(String time) {
		this.timeLabel.setText(time);
	}
	
	/**
	 * Update label displaying the alarm time.
	 * @param time
	 */
	public void setAlarmOnLabel(String time) {
		this.alarmLabel.setText(time);
	}
	
	/**
	 * Sets the alarm as active/inactive (on/off)
	 * @param active
	 */
	public void setAlarmActive(boolean active) {
		this.alarmLabel.setEnabled(active);
		this.alarmLabelDescription.setEnabled(active);
	}
	
	/**
	 * Alarm! Alarm!
	 * @param ringing
	 */
	public void alarmRinging(boolean ringing) {
		alarmRingingLabel.setVisible(ringing);
	}
}
