import java.util.Random;

public class MinRandom {
    Random random = new Random();

    public int nextNumber(int lower, int upper) {
       int max = upper - lower;
       int result = random.nextInt(max);
       return result + lower;
    }

    public double nextDecimal(double lower, double upper) {
        double randomDecimal = random.nextDouble();
        double max = upper - lower;
        double result = lower + (max * randomDecimal);
        return result;
    }
}

class Testing {
    public static void main(String[] args) {
        MinRandom randomNumber = new MinRandom();

        System.out.println("Random whole number between 1 and 5: " + randomNumber.nextNumber(1,5));
        System.out.println("Random decimal number between 1 and 5: " + randomNumber.nextDecimal(1,5));
    }
}