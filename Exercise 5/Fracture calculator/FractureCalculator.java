import java.util.*;

class FractureCalculator {
    
    private double numerator;

    private double denominator;


    public FractureCalculator(double numerator, double denominator) {
        this.numerator = numerator;
        
        if (denominator == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være null.");
        } else {
            this.denominator = denominator;
        }
    }

    public FractureCalculator(double numerator) {
      this.numerator = numerator;
      this.denominator = 1;
    }

    public double getNumerator() {
        return this.numerator;
    }

    public double getDenominator() {
        return this.denominator;
    }
    
    public void add(double numerator, double denominator) {
        //finn felles nevner = nevner x nevner, teller = teller 1 x nevner 2 + teller 2 x nevner 1
        if (denominator == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være null.");
        }

        if (this.denominator == denominator) {
            this.numerator = this.numerator + numerator;
            this.denominator = denominator;
        } else {
            this.numerator = (this.numerator * denominator) + (this.denominator * numerator);
            this.denominator = this.denominator * denominator;
        }
        
    }

    public void substract(double numerator, double denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være null.");
        }
        if (this.denominator == denominator) {
            this.numerator = this.numerator + numerator;
            this.denominator = denominator;
        } else {
            this.numerator = (this.numerator * denominator) - (this.denominator * numerator);
            this.denominator = this.denominator * denominator;
        }
    }

    public void multiply(double numerator, double denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være null.");
        }
        this.numerator = this.numerator * numerator;
        this.denominator = this.denominator * denominator;
    }

    public void devide(double numerator, double denominator) {
        if (denominator == 0  || numerator == 0) {
            throw new IllegalArgumentException("Hverken teller eller nevner kan  være null.");
        }
        this.numerator = this.numerator * denominator;
        this.denominator = this.denominator * numerator;
    }
}

class TestClass {
    
    public static void main(String[] args) {
        FractureCalculator calculator1 = new FractureCalculator(1,3);
        FractureCalculator calculator2 = new FractureCalculator(2);
        FractureCalculator calculator3 = new FractureCalculator(2,4);
        FractureCalculator calculator4 = new FractureCalculator(10);

        calculator1.add(-1, 3);
        if (calculator1.getNumerator() == 0 && calculator1.getDenominator() == 3) {
            System.out.println("Test 1 (addition) went successfully.");
        } else {
            System.out.println("Something went wrong in test 1.");
        }

        calculator2.substract(1,3);
        if (calculator2.getNumerator() == 5 && calculator2.getDenominator() == 3) {
            System.out.println("Test 2 (substraction) went successfully.");
        } else {
            System.out.println("Something went wrong in test 2.");
        }

        
        calculator3.multiply(-10,-6);

        if (calculator3.getNumerator() == -20 && calculator3.getDenominator() == -24) {
            System.out.println("Test 3 (multiplication) went successfully.");
        } else {
            System.out.println("Something went wrong in test 3.");
        }

        calculator4.devide(5,2);

        if (calculator4.getNumerator() == 20 && calculator4.getDenominator() == 5) {
            System.out.println("Test 4 (division) went successfully.");
        } else {
            System.out.println("Something went wrong in test 4.");
        }

    }
    
}
