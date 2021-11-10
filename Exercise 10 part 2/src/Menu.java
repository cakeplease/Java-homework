import java.util.ArrayList;

public class Menu {

    private ArrayList<Dish> dishes = new ArrayList<Dish>();

    public Menu(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Dish dish : dishes) {
            totalPrice += dish.getPrice();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return "Menu \n" +
                "Dishes:" + dishes + "Total price: " + getTotalPrice() + "kr";
    }
}
