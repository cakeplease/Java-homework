public class Event {

    private int id;

    private String name;

    private String place;

    private String organizator;

    private String type;

    private String date;

    public Event(int id, String name, String place, String organizator, String type, String date) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.organizator = organizator;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getOrganizator() {
        return organizator;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setOrganizator(String organizator) {
        this.organizator = organizator;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
