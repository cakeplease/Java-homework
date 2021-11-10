import java.util.*;

public class EventRegister {

    public ArrayList<Event> eventList = new ArrayList<Event>();

    public Event register(String name, String location, String organizer, String type, String date) {
        int id = eventList.size() + 1;
        Event newEvent = new Event(id, name, location, organizer, type, date);

        eventList.add(newEvent);

        return newEvent;
    }

    public ArrayList<Event> findBasedOnLocation(String location) {
       ArrayList<Event> eventsBasedOnLocation = new ArrayList<Event>();

       for (int i = 0; i < this.eventList.size(); i++) {
           if (this.eventList.get(i).getLocation().equals(location)) {
               eventsBasedOnLocation.add(this.eventList.get(i));
           }
       }

       return eventsBasedOnLocation;
    }

    public ArrayList<Event> findBasedOnDate(String date) {
        ArrayList<Event> eventsBasedOnDate = new ArrayList<Event>();

        for (int i = 0; i < this.eventList.size(); i++) {

            String eventDate = this.eventList.get(i).getDate();
            String eventDateWithoutTime = eventDate.substring(0, eventDate.length() - 4);

            int formattedEventDate = Integer.parseInt(eventDateWithoutTime);
            if (formattedEventDate == Integer.parseInt(date)) {
                eventsBasedOnDate.add(this.eventList.get(i));
            }
        }

        Comparator<Event> sortBasedOnTime = (Event a1, Event a2) -> a1.getTime().compareTo(a2.getTime());
        Collections.sort(eventsBasedOnDate, sortBasedOnTime);

        return eventsBasedOnDate;

    }

    public ArrayList<Event> findBasedOnInterval(String startDate, String endDate) {
        ArrayList<Event> eventsBasedOnInterval = new ArrayList<Event>();

        for (int i = 0; i < this.eventList.size(); i++) {

            String eventDate = this.eventList.get(i).getDate();
            String eventDateWithoutTime = eventDate.substring(0, eventDate.length() - 4);

            int formattedEventDate = Integer.parseInt(eventDateWithoutTime);

            if (formattedEventDate >= Integer.parseInt(startDate) && formattedEventDate <= Integer.parseInt(endDate)) {
                eventsBasedOnInterval.add(this.eventList.get(i));
            }
        }

        Comparator<Event> sortBasedOnTime = (Event a1, Event a2) -> a1.getDate().compareTo(a2.getDate());
        Collections.sort(eventsBasedOnInterval, sortBasedOnTime);

        return eventsBasedOnInterval;

    }

    public void getAllEventsSorted() {
        ArrayList<Event> copy = (ArrayList<Event>)this.eventList.clone();

        if (copy.size() > 0) {
            copy.sort(Comparator.comparing(Event::getLocation).thenComparing(Event::getType).thenComparing(Event::getDate));
            System.out.println("There are " + copy.size() + " events.");
            for (int i = 0; i < copy.size(); i++) {
                System.out.println(copy.get(i).toString());
            }
        } else {
            System.out.println("No events to show.");
        }
    }


}
