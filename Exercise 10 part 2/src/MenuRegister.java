import java.util.ArrayList;

public class MenuRegister {
    public ArrayList<Menu> menus = new ArrayList<Menu>();
    public ArrayList<Dish> dishes = new ArrayList<Dish>();

    public void registerDish(String name, String type, int price, String recipe) {
        int id = dishes.size() + 1;
        Dish newDish = new Dish(id, name, type, price, recipe);
        dishes.add(newDish);
    }

    public void registerMenu(ArrayList<Dish> dishes) {
        Menu newMenu = new Menu(dishes);
        menus.add(newMenu);
    }

    public ArrayList<Dish> findDishOfName(String name) {
        ArrayList<Dish> dishArray = new ArrayList<Dish>();

        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getName().equals(name)) {
                dishArray.add(dishes.get(i));
                return dishArray;
            }
        }

        return dishArray;
    }

    public ArrayList<Dish> findDishesOfType(String type) {
        ArrayList<Dish> dishArray = new ArrayList<Dish>();

        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getType().equals(type)) {
                dishArray.add(dishes.get(i));
                return dishArray;
            }
        }

        return dishArray;
    }

    public ArrayList<Menu> findAllMenusBasedOnPriceRange(int from, int to) {
        ArrayList<Menu> menusInPriceRange = new ArrayList<Menu>();

        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getTotalPrice() >= from && menus.get(i).getTotalPrice() <= to) {
                menusInPriceRange.add(menus.get(i));
            }
        }

        return menusInPriceRange;
    }

    public void showAllDishes() {
        for (Dish dish : dishes) {
            System.out.println(dish.getId() + "." + dish.getName());
        }
    }
}
