package date;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date {

    private java.time.LocalDate date;
    private java.time.LocalDate newDate;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private Scanner dateSc;

    public Date() {
        date = java.time.LocalDate.now();
    }

    private void setDate(int year, int month, int day) {
    	try {
            newDate = java.time.LocalDate.of(year, month, day);
        } catch (java.time.DateTimeException e) {
            System.out.println("Ogiltig datuminmatning. Försök igen.");
            newDate = null;
        }
    }

    private void showDate() {
    	if(newDate == null) {
    		System.out.println("Date: " + date.format(dateFormatter));
    	} else {
    		System.out.println("Date: " + newDate.format(dateFormatter));
    	}
    }
    
    public void dateMenu() {
    	
    	dateSc = new Scanner(System.in);
    	
    	System.out.println("Alternativ för Datum:");
		System.out.println("1. Visa Datum");
		System.out.println("2. Sätt Datum");
		String dateInput = dateSc.nextLine().trim();
        
		switch(dateInput) {
			case "1" : {
					showDate();
					System.out.println("------------------");
					break;
				}
			case "2" : {
				System.out.print("Ange år: ");
				int year = dateSc.nextInt();
				System.out.print("Ange månad (med siffra): ");
				int month = dateSc.nextInt();
				System.out.print("Ange dagsdatum: ");
				int day = dateSc.nextInt();
				
				setDate(year, month, day);
				dateSc.nextLine();
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
