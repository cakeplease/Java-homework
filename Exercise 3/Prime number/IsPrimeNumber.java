import java.util.*;

class IsPrimeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome. Type in number to check if it's a prime number");
        

        boolean continueLoop = true;
        
        while (continueLoop) {
            int number = input.nextInt();
            if (isPrime(number)) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }
    }

    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i+= 1) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }
}