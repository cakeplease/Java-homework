import java.util.*;
import java.lang.Integer.*;

public class EventRegister {

    public ArrayList<Event> eventList = new ArrayList<Event>();

    public Event register(String name, String location, String organizer, String type, int date) {
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

    public ArrayList<Event> findBasedOnDate(int date) {
        ArrayList<Event> eventsBasedOnDate = new ArrayList<Event>();

        for (int i = 0; i < this.eventList.size(); i++) {

            int eventDate = this.eventList.get(i).getDate();
            int eventDateWithoutTime = (int)Math.floor(this.eventList.get(i).getDate() / 10000);

            int formattedEventDate = eventDateWithoutTime;
            if (formattedEventDate == date) {
                eventsBasedOnDate.add(this.eventList.get(i));
            }
        }

        return eventsBasedOnDate;

    }

    public ArrayList<Event> findBasedOnInterval(int startDate, int endDate) {
        ArrayList<Event> eventsBasedOnInterval = new ArrayList<Event>();

        for (int i = 0; i < this.eventList.size(); i++) {

            int eventDate = this.eventList.get(i).getDate();
            int eventDateWithoutTime = (int)Math.floor(this.eventList.get(i).getDate() / 10000);

            int formattedEventDate = eventDateWithoutTime;

            if (formattedEventDate >= startDate && formattedEventDate <= endDate) {
                eventsBasedOnInterval.add(this.eventList.get(i));
            }
        }

        //eventsBasedOnInterval.sort(Comparator.comparing(Event.getTime()))

        Comparator<Event> sortBasedOnTime = (Event a1, Event a2) -> a1.getDate().compareTo(a2.getDate());
        Collections.sort(eventsBasedOnInterval, sortBasedOnTime);

        return eventsBasedOnInterval;

    }


}
