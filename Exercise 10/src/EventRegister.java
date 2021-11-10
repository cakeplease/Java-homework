import java.util.*;
import java.lang.Integer.*;

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

        //eventsBasedOnInterval.sort(Comparator.comparing(Event.getTime()))

        Comparator<Event> sortBasedOnTime = (Event a1, Event a2) -> (int)a1.getTime() - (int)a2.getTime();
        Collections.sort(eventsBasedOnInterval, sortBasedOnTime);

        return eventsBasedOnInterval;

    }


}
