package time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Time {

    private LocalTime time;
    private LocalTime newTime;
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private Scanner timeSc;

    public Time() {
        time = LocalTime.now();
    }

    private void setTime(int hour, int minute) {
        newTime = LocalTime.of(hour, minute);
    }

    private void showTime() {
    if(newTime == null) {
        	System.out.println("Time: " + time.format(timeFormatter));
    	} else {
    		System.out.println("Time: " + newTime.format(timeFormatter));
    	}
    }
    
    public void timeMenu() {
    	
    	timeSc = new Scanner(System.in);
    	
    	System.out.println("Alternativ för Tid:");
        System.out.println("1. Visa tid");
        System.out.println("2. Sätt tid");
        String timeInput = timeSc.nextLine().trim();
        
        switch(timeInput) {
        	case "1" : {
        		showTime();
        		System.out.println("------------------");
        		break;
        	}
        	case "2" : {
        		System.out.print("Ange timme: ");
        		int hour = timeSc.nextInt();
        		System.out.print("Ange minut: ");
            	int minute = timeSc.nextInt();
            
            	setTime(hour, minute);
            	timeSc.nextLine();
            	System.out.println("------------------");
            	break;
        	}
        	default: {
        		System.out.println("Ogiltig val.");
        		break;
        	}
        }
    }
}
