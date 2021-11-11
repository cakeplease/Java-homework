import java.util.*;
import java.lang.System;
import java.lang.Integer;

public class ClientProgram {
    Scanner input = new Scanner(System.in);

    MenuRegister MenuRegister = new MenuRegister();

    boolean hasStarted = false;

    public void showMenu() {

        if (!hasStarted) {
            testData();
            hasStarted = true;
        }

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
            System.out.println("Found " + menus.size() + " menu/menus in search results: ");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(menus.get(i).toString());
            }
        } else {
            System.out.println("No menus to show");
        }
    }

    private void showDishes(ArrayList<Dish> dishes) {
        if (dishes.size() > 0) {
            System.out.println("\n Found " + dishes.size() + " dish/dishes in search results: ");
            for (int i = 0; i < dishes.size(); i++) {
                System.out.println(dishes.get(i).toString());
            }
        } else {
            System.out.println("No dishes to show");
        }
    }

    private void registerDish() {
        System.out.print("Name: ");
        String name = input.next();

        System.out.print("Type: ");
        String type = input.next();

        System.out.print("Price: ");
        int price = input.nextInt();

        System.out.print("Recipe: ");
        String recipe = input.next();
        input.nextLine();

        MenuRegister.registerDish(name, type, price, recipe);
    }

    private void findDishOfName() {
        System.out.print("Name: ");
        String name = input.next();

        showDishes(MenuRegister.findDishOfName(name));
    }

    private void findDishesOfType() {
        System.out.print("Type: ");
        String type = input.next();

        showDishes(MenuRegister.findDishesOfType(type));
    }

    private void registerMenu() {

        ArrayList<Integer> dishIds = new ArrayList<Integer>();
        ArrayList<Dish> dishesToAdd = new ArrayList<Dish>();

        boolean isFinished = false;

        while(!isFinished) {
            MenuRegister.showAllDishes();
            System.out.println("Type in ID of the dish you would like to add to the menu and then 0 to register the menu when you're finished:");
            int dishId = input.nextInt();
            dishIds.add(dishId);
            System.out.println("Added to the menu.");

            if (dishId == 0) {
                for (int i = 0; i < dishIds.size(); i++) {
                    for (int j = 0; j < MenuRegister.getDishes().size(); j++) {
                        if (dishIds.get(i) == MenuRegister.getDishes().get(j).getId()) {
                            dishesToAdd.add(MenuRegister.getDishes().get(j));
                        }
                    }
                }

                MenuRegister.registerMenu(dishesToAdd);
                System.out.println("Menu registered.");
                isFinished = true;
            }
        }
    }

    private void findMenusInPriceRange() {
        System.out.print("From: ");
        int from = input.nextInt();

        System.out.print("To: ");
        int to = input.nextInt();

        showMenus(MenuRegister.findAllMenusBasedOnPriceRange(from, to));
    }

    private void testData() {
        MenuRegister.registerDish("Tomatsuppe", "Forrett", 70, "Tilsett tomatpurre, hakkatomater, buljong og løk.");
        MenuRegister.registerDish("Tacosuppe", "Middag", 209, "Tilsett bønner, hakkatomater, buljong.");
        MenuRegister.registerDish("Oreokrem", "Dessert", 105, "Tilsett philadelphia ost, oreo kjeks, vaniljesukker, kremfløte.");
        MenuRegister.registerDish("Jordbær milkshake", "Dessert", 89, "Tilsett jordbær, melk, vaniljeis og fløte på toppen.");
    }

    public static void main(String[] args) {
        ClientProgram ClientProgram = new ClientProgram();

        while (true) {
            ClientProgram.showMenu();
        }
    }

}
