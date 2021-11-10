import java.util.*;
import java.lang.System;

public class ClientProgram {

    Scanner input = new Scanner(System.in);

    EventRegister Events = new EventRegister();

    boolean hasStarted = false;

    private void showMenu() {
        if (!hasStarted) {
            testData();
            hasStarted = true;
        }

        System.out.println("Type 1 to register new event.");
        System.out.println("Type 2 to find all events from specific location.");
        System.out.println("Type 3 to find all events on specific day.");
        System.out.println("Type 4 to find all events in the interval of two dates.");
        System.out.println("Type 5 to list all events sorted.");
        System.out.println("Type 6 to quit.");

        int menuInput = input.nextInt();

        switch (menuInput) {
            case 1:
                registerEvent();
                break;

            case 2:
                getEventsBasedOnLocation();
                break;
            case 3:
                getEventsBasedOnDate();
                break;
            case 4:
                getEventsFromInterval();
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input number, choose number from the list above.");

        }
    }

    private void registerEvent() {

        System.out.println("Welcome, please register your new event:");

        System.out.print("Name of the event: ");
        String name = input.next();

        System.out.print("Location: ");
        String location = input.next();

        System.out.print("Organizer: ");
        String organizer = input.next();

        System.out.print("Type of the event: ");
        String type = input.next();

        System.out.print("Date of the event in the following format yyyy.mm.dd: ");
        String date = input.next();
        date = date.replace(".", "");


        System.out.print("Time of the event separated with colon \":\" : ");
        String time = input.next();
        time = time.replace(":", "");

        date = date + time;

        Events.register(name, location, organizer, type, date);
        System.out.println(Events.eventList.get(Events.eventList.size() - 1));
        System.out.println(Events.eventList);

    }

    private void showEvents(ArrayList<Event> events) {
        if (events.size() > 0) {
            System.out.println("Found " + events.size() + " events in search results: ");
            for (int i = 0; i < events.size(); i++) {
                System.out.println(events.get(i).toString());
            }
        } else {
            System.out.println("No events to show");
        }
    }

    private void getEventsBasedOnLocation() {
        System.out.print("Location: ");
        String location = input.next();
        showEvents(Events.findBasedOnLocation(location));
    }

    private void getEventsBasedOnDate() {
        System.out.print("Date in following format yyyy.mm.dd : ");
        String date = input.next().replace(".", "");
        showEvents(Events.findBasedOnDate(date));
    }

    private void getEventsFromInterval() {
        System.out.print("Start date in following format yyyy.mm.dd : ");
        String startDate = input.next().replace(".", "");

        System.out.print("End date in following format yyyy.mm.dd : ");
        String endDate = input.next().replace(".", "");

        showEvents(Events.findBasedOnInterval(startDate, endDate));
    }


    public void testData() {
        Events.register("Trondheim Rocks", "Trondheim", "Trondheim Kommune", "Konsert", "202206261000");
        Events.register("Kurs i swing", "Trondheim", "Danseri AS", "Kurs", "202112101200");
        Events.register("VM i sjakk", "Oslo", "Sjakkfolk", "VM", "202112011700");
    }

    public static void main(String[] args) {

        ClientProgram ClientProgram = new ClientProgram();

        while(true) {
            ClientProgram.showMenu();
        }

    }
}
