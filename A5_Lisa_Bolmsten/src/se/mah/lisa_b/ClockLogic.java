package se.mah.lisa_b;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ClockLogic {
	/**
	 * A reference to the GUI
	 */
	DigitalClockGUI digitalClockGUI;
	
	/**
	 * Thread for updating the GUI
	 */
	ClockThread clockThread;
	
	/**
	 * Alarm is active or not (on/off)
	 */
	private boolean alarmActive;
	
	/**
	 * Alarm is currently ringing or not
	 */
	private boolean alarmRinging;
	
	/**
	 * Currently set alarm time.
	 */
	private LocalTime alarm = LocalTime.of(06, 00);

	/**
	 * Constructor for ClockLogic
	 * @param digitalClockGUI
	 */
	public ClockLogic(DigitalClockGUI digitalClockGUI) {
		this.digitalClockGUI = digitalClockGUI;
		this.clockThread = new ClockThread();
		this.clockThread.start();
	}
	
	/**
	 * Set new alarm.
	 * @param hour
	 * @param minute
	 */
	public void setAlarm(int hour, int minute) {
		this.alarm = LocalTime.of(hour, minute);
		this.alarmActive = true;
		updateAlarm();
	}
	
	/**
	 * Clear the alarm.
	 */
	public void clearAlarm() {
		this.alarmActive = false;
		this.alarmRinging = false;
		updateAlarm();
	}
	
	/**
	 * Update the alarm time and the alarm active status in the GUI. 
	 */
	private void updateAlarm() {
		this.digitalClockGUI.setAlarmOnLabel(this.alarm.format(DateTimeFormatter.ISO_LOCAL_TIME));
		this.digitalClockGUI.setAlarmActive(this.alarmActive);
		this.digitalClockGUI.alarmRinging(this.alarmRinging);
	}
	
	/**
	 * Update the time in the GUI. Uses java.time.
	 */
	private void updateClock() {
		this.digitalClockGUI.setTimeOnLabel(
				LocalTime.now()
					.truncatedTo(ChronoUnit.SECONDS)
					.format(DateTimeFormatter.ISO_LOCAL_TIME)
		);
	}
	
	/**
	 * Check if alarm time is on the same minute as now(), set alarmRinging.
	 */
	private void checkAlarm() {
		if (LocalTime.now()
				.truncatedTo(ChronoUnit.MINUTES)
				.equals(alarm.truncatedTo(ChronoUnit.MINUTES))
			&& this.alarmActive) {
			
			this.alarmRinging = true;
		}
	}
	
	/**
	 * Thread for updating clock and checking alarm.
	 */
	private class ClockThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
				
				updateClock();
				checkAlarm();
				updateAlarm();
			}
		}
	}

}
