import java.util.*;
import java.lang.System;
import java.lang.Integer;

public class ClientProgram {
    Scanner input = new Scanner(System.in);

    MenuRegister MenuRegister = new MenuRegister();

    boolean hasStarted = false;

    public void showMenu() {
        System.out.println("Type 1 to register new dish.");
        System.out.println("Type 2 to find dish based on name.");
        System.out.println("Type 3 to find dishes of specific type.");
        System.out.println("Type 4 to register new menu");
        System.out.println("Type 5 to find all menus in a price range.");
        System.out.println("Type 6 to quit.");

        int menuInput = input.nextInt();

        switch (menuInput) {
            case 1:
                registerDish();
                break;
            case 2:
                findDishOfName();
                break;
            case 3:
                findDishesOfType();
                break;
            case 4:
                registerMenu();
                break;
            case 5:
                findMenusInPriceRange();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input number.");
        }
    }

    private void showMenus(ArrayList<Menu> menus) {
        if (menus.size() > 0) {
            System.out.println("Found " + menus.size() + " menus in search results: ");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(menus.get(i).toString());
            }
        } else {
            System.out.println("No events to show");
        }
    }

    private void showDishes(ArrayList<Dish> dishes) {
        if (dishes.size() > 0) {
            System.out.println("Found " + dishes.size() + " dishes in search results: ");
            for (int i = 0; i < dishes.size(); i++) {
                System.out.println(dishes.get(i).toString());
            }
        } else {
            System.out.println("No events to show");
        }
    }

    public void registerDish() {
        System.out.print("Name: ");
        String name = input.next();

        System.out.print("Type: ");
        String type = input.next();

        System.out.print("Price: ");
        int price = input.nextInt();

        System.out.print("Recipe: ");
        String recipe = input.next();

        MenuRegister.registerDish(name, type, price, recipe);
    }

    public void findDishOfName() {
        System.out.print("Name: ");
        String name = input.next();

        showDishes(MenuRegister.findDishOfName(name));
    }

    public void findDishesOfType() {
        System.out.print("Type: ");
        String type = input.next();

        showDishes(MenuRegister.findDishesOfType(type));
    }

    public void registerMenu() {

        ArrayList<Integer> dishIds = new ArrayList<Integer>();
        ArrayList<Dish> dishesToAdd = new ArrayList<Dish>();

        boolean isFinished = false;

        while(!isFinished) {
            MenuRegister.showAllDishes();
            System.out.println("Type in ID of the dish you would like to add to the menu and then 0 to register the menu when you're finished:");
            int dishId = input.nextInt();
            dishIds.add(dishId);

            if (dishId == 0) {
                for (int i = 0; i < dishIds.size(); i++) {
                    for (int j = 0; j < MenuRegister.dishes.size(); j++) {
                        if (dishIds.get(i) == MenuRegister.dishes.get(j).getId()) {
                            dishesToAdd.add(MenuRegister.dishes.get(j));
                        }
                    }
                }

                MenuRegister.registerMenu(dishesToAdd);
                isFinished = true;
            }
        }
    }

    public void findMenusInPriceRange() {
        System.out.print("From: ");
        int from = input.nextInt();

        System.out.print("To: ");
        int to = input.nextInt();

        showMenus(MenuRegister.findAllMenusBasedOnPriceRange(from, to));
    }


}
