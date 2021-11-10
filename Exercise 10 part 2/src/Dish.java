public class Dish {

    private final int id;

    private final String name;

    private final String type;

    private final int price;

    private final String recipe;

    public Dish(int id, String name, String type, int price, String recipe) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.recipe = recipe;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return name + "\n" +
                "Type: " + type + '\n' +
                "Price: " + price + '\n' +
                "Recipe: " + recipe + '\n';
    }
}
