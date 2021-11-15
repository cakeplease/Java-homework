import java.util.Scanner;

public class ClientProgram {

    //Eiendomsregister
    public RealestateRegister RealestateRegister = new RealestateRegister();

    //Scanner
    public Scanner input = new Scanner(System.in);

    // Forskjellige konstanter som representerer valg i menyen
    private final int ADD_PROPERTY = 1;
    private final int LIST_ALL_PROPERTIES = 2;
    private final int FIND_PROPERTY = 3;
    private final int CALCULATE_AVERAGE_AREA = 4;
    private final int REMOVE_PROPERTY = 5;
    private final int EXIT = 9;

    /**
     * Lager ClientProgram objektet, registrerer test data og kjører menyen
     */
    public static void main(String[] args) {
        ClientProgram ClientProgram = new ClientProgram();
        ClientProgram.testData();

        while (true) {
            ClientProgram.showMenu();
        }
    }

    /**
     * Viser menyen for brukeren, tar inn input og kjører de metodene som trengs for å gjøre det brukeren ønsker å gjøre.
     */
    private void showMenu() {
        int menuChoice = 0;

        System.out.println("\n***** Property Register Application v0.1 *****\n");
        System.out.println("1. Add real estate");
        System.out.println("2. List all real estates");
        System.out.println("3. Search real estate");
        System.out.println("4. Calculate average area");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.");

        if (input.hasNextInt()) {
            menuChoice = input.nextInt();
        } else {
            System.out.println("You must enter a number, not text");
        }

        switch (menuChoice) {
            case ADD_PROPERTY:
                registerNewRealestate();
                break;
            case LIST_ALL_PROPERTIES:
                getAllRealestates();
                break;
            case FIND_PROPERTY:
                findRealestate();
                break;
            case CALCULATE_AVERAGE_AREA:
                calculateAverageArea();
                break;
            case REMOVE_PROPERTY:
                removeRealestate();
            case EXIT:
                System.out.println("Thank you for using the Real estate app!\n");
                System.exit(0);
                break;
            default:
                System.out.println("Unrecognized menu selected..");
                break;
        }
    }

    public void testData() {
        RealestateRegister.register(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen");
        RealestateRegister.register(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        RealestateRegister.register(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        RealestateRegister.register(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten");
        RealestateRegister.register(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");
    }

    /**
     * Registrerer ny eiendom basert på input fra brukeren
     */
    public void registerNewRealestate() {
        System.out.print("Enter municipality number: ");
        int municipalityNumber = input.nextInt();

        System.out.print("Enter municipality name: ");
        String municipalityName = input.next();
        input.nextLine();

        System.out.print("Enter lot number: ");
        int lotNumber = input.nextInt();

        System.out.print("Enter section number: ");
        int sectionNumber = input.nextInt();

        System.out.print("Does realestate have a name? y/n: ");
        String hasName = input.next();
        String name = "";

        if (hasName.equals("y")) {
            System.out.print("Enter name: ");
            name = input.next();
            input.nextLine();
        }

        System.out.print("Enter area in m2: ");
        double area = input.nextDouble();

        System.out.print("Enter owner name: ");
        String ownerName = input.next();
        input.nextLine();

        System.out.println(RealestateRegister.register(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, ownerName));
    }

    public void getAllRealestates() {
        System.out.println(RealestateRegister.getAll());
    }

    public void findRealestate() {
        System.out.print("Enter municipality number: ");
        int municipalityNumber = input.nextInt();

        System.out.print("Enter lot number: ");
        int lotNumber = input.nextInt();

        System.out.print("Enter section number: ");
        int sectionNumber = input.nextInt();

        System.out.println(RealestateRegister.find(municipalityNumber, lotNumber, sectionNumber));
    }

    public void calculateAverageArea() {
        System.out.println(RealestateRegister.calculateAverageArea() + "m2");
    }

    public void removeRealestate() {
        System.out.print("Enter municipality number: ");
        int municipalityNumber = input.nextInt();

        System.out.print("Enter lot number: ");
        int lotNumber = input.nextInt();

        System.out.print("Enter section number: ");
        int sectionNumber = input.nextInt();

        boolean isRemoved = RealestateRegister.remove(municipalityNumber, lotNumber, sectionNumber);

        if (isRemoved) {
            System.out.println("Realestate removed.");
        } else {
            System.out.println("Realestate to remove not found.");
        }
    }

}
