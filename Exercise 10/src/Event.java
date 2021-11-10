public class Event {

    private final int id;

    private String name;

    private String location;

    private String organizer;

    private String type;

    private int date;

    public Event(int id, String name, String location, String organizer, String type, int date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getType() {
        return type;
    }

    public int getDate() {
        return date;
    }

    //public int getTime() {
      //  return Integer.parseInt(date.substring(8, 12));
    //}

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String location) {
        this.location = location;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(int date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String date = String.format("%.1f", this.getDate());
        String newDate = date.substring(6, 8) + "." + date.substring(4, 6) + "." + date.substring(0, 4) + " kl. " + date.substring(8, 10) + ":" + date.substring(10, 12);
        return "\n" + "Navn: " + name + "\n" +
                "ID-nummer: " + id + "\n" +
                "Sted: " + location + "\n" +
                "Arrangør: " + organizer + "\n" +
                "Type: " + type + "\n" +
                "Dato: " + newDate + "\n";
    }
}
