import java.util.*;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Start of the multiplication table: ");
        int start = input.nextInt();

        System.out.print("End of the multiplication table: ");
        int end = input.nextInt();
        

        if (start == end) {
            //only one table
            for (int i = 0; i<=10; i++) {
                System.out.println(start + " x " + i + " = " + start*i);
            }
        } else {
            //from - to
            int i = end-start;
            System.out.println("Difference is " + i);

            for (int j = 0; j<=i; j++) {
                for (int k = 0; k<=10; k++) {
                    System.out.println((start + j) + " x " + k + " = " + (start + j) *k);
                }
                System.out.print("\n");
            }
        }
    }
}