class CalculateCheapestPrice {
    public static void main(String[] args) {
        //kjøttdeig 1
        double aPrice = 35.90;
        double aWeight = 450;

        //kjøttdeig 2
        double bPrice = 39.50;
        double bWeight = 500;

        double aPricePer100grams = (aPrice / aWeight) * 100;
        double bPricePer100grams = (bPrice / bWeight) * 100;

        System.out.println("Price a per 100 gram: " + aPricePer100grams);
        System.out.println("Price b per 100 gram: " + bPricePer100grams);
        
        if (aPricePer100grams > bPricePer100grams) {
            System.out.println("Kjøttdeig B er billigere.");
        } else {
            System.out.println("Kjøttdeig A er billigere.");
        }
    }
}