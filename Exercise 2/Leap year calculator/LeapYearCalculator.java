import java.util.*;

class LeapYearCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome. Type in a year to check if it's a leap year.");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter year - ");
        int year = input.nextInt();

        if (year % 100 == 0 && year % 400 == 0) {
            System.out.println("Year "+ year + " is a leap year");
        } else if ((year % 4) == 0 && year % 100 != 0) {
            System.out.println("Year "+ year + " is a leap year");
        } else {
            System.out.println("Year "+ year + " is not a leap year");
        }
    }
}
//AKTIVITETSDIAGRAM
// 1. Skrive inn et årstall.
// 2. Se om det er ingen rest om man deler på 400 eller 4
// 3. Ingen rest -> skuddår
// 4. Rest -> ikke skuddår


// TESTDATA
// Enter year - 2021
// Year 2021 is not a leap year

// Enter year - 2000
// Year 2000is a leap year

// Enter year - 2024
// Year 2024 is a leap year
