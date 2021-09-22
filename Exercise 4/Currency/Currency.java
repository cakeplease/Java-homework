import java.util.*;

class Currency {

    //instance fields
    private int id;
    private String name;
    private double exchangeRate;

    //constructor
    public Currency(int currencyId, String currencyName, double currencyExchangeRate) {
        this.id = currencyId;
        this.name = currencyName;
        this.exchangeRate = currencyExchangeRate;
    }
    //method to exchange from NOK
    public double fromNOK(double moneyAmount) {
        double chosenCurrency = 0.0;
        chosenCurrency = moneyAmount / this.exchangeRate;
        return chosenCurrency;
    }
    //method to exchange to NOK
    public double toNOK(double moneyAmount) {
        double norwegianCrowns = 0.0;
        norwegianCrowns = moneyAmount * this.exchangeRate;

        return norwegianCrowns;
    }

    public static void main(String[] args) {
        Currency Dollar = new Currency(1, "Dollar", 8.74);
        Currency Euro = new Currency(2, "Euro", 10.25);
        Currency SwedishCrown = new Currency(3, "Svenske kroner", 1.0);

        Scanner input = new Scanner(System.in);

        System.out.print("Velg beløpet: ");
        double amount = input.nextDouble();

        System.out.println("Velg valuta: \n 1: dollar \n 2: euro \n 3: svenske kroner \n 4: hvis du vil avslutte programmet");
        int chosenCurrency = input.nextInt();
        
        double convertedAmount = 0.0;

        switch (chosenCurrency) {
            //dollar
            case 1:
                convertedAmount = Dollar.toNOK(amount);
                break;
            //euro
            case 2:
                convertedAmount = Euro.toNOK(amount);
                break;
            //swedish crowns
            case 3:
                convertedAmount = SwedishCrown.toNOK(amount);
                break;
            //exit
            case 4:
                System.out.println("Farvel.");
                System.exit(0);
                break;
            //bad value
            default:
                System.out.print("Ugyldig valutanummer.");
                System.exit(0);
                break;
        }
        
        System.out.println("Det er " + convertedAmount + " norske kroner.");
    }
}