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

    public String getAllDishesNames() {
        String dishesNames = "";

        for (Dish dish : dishes) {
            dishesNames = dishesNames + "\n" + dish.getName();
        }

        return dishesNames;
    }

    @Override
    public String toString() {

        return "\nMenu\n" +
                "Dishes:" + getAllDishesNames() + "\nTotal price: " + getTotalPrice() + "kr \n";
    }
}
