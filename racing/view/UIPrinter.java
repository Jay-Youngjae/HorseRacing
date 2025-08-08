package dev.racing2.view;

import dev.racing2.settings.RaceSettings;

public class UIPrinter {
	public static String buildTrack(int distance) {
	    StringBuilder sb = new StringBuilder();
	    int finishLine = RaceSettings.TRACK_LENGTH;


	    for (int i = 0; i <= finishLine; i++) {
	        if (i == distance) {
	            sb.append("🐎");
	        } else {
	            sb.append("-");
	        }
	    }
	    sb.append("🏁");
	    return sb.toString();
	}
	
	// ANSI escape code로 콘솔 클리어
	public static void clearConsole() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}
}