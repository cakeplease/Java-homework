import java.util.*;

class calculateTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter hours - ");
        double hours = input.nextDouble() * 3600;
        System.out.print("Enter minutes - ");
        double minutes = input.nextDouble() * 60;
        System.out.print("Enter seconds - ");
        double seconds = input.nextDouble();

        double secondsSum = hours + minutes + seconds;


        System.out.println("Total seconds: "+secondsSum);
    }
}

/*

Enter hours - 0
Enter minutes - 2
Enter seconds - 0
Total seconds: 120.0

Enter hours - 0
Enter minutes - 0
Enter seconds - 60
Total seconds: 60.0


Enter hours - 0
Enter minutes - 0
Enter seconds - 0
Total seconds: 0.0
*/