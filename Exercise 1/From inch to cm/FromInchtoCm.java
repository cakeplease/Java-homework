import java.util.*;

class FromInchtoCm {
    public static void main(String[] args) {
        Scanner inchesInput = new Scanner(System.in);
        System.out.print("Enter inches - ");
        double inches = inchesInput.nextDouble();

        if (inches > 0.0) {
            double cm = inches * 2.54;
            System.out.println(inches + " inches is " + cm + "cm");
        } else {
            System.out.println("Inches can't be 0 or negative number.");
        }
    }
}

//TESTDATA
// Enter inches - 2
// 2.0 inches is 5.08cm

// Enter inches - 0
// Inches can't be 0 or negative number.

// Enter inches - 10
// 10.0 inches is 25.4cm

// Enter inches - -1
// Inches can't be 0 or negative number.
