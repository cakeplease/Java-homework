import java.util.*;

public class DiceGame {
    public static void main(String[] args) {
        int roundNumber = 1;
        Player A_Player = new Player();
        Player B_Player = new Player();
        Scanner input = new Scanner(System.in);
        String command;

        while(!A_Player.isFinished() || !B_Player.isFinished()) {
            System.out.println("Round: " + roundNumber);
            System.out.println("Player A score: "+ A_Player.getScore());
            System.out.println("Player B score: "+ B_Player.getScore());

            System.out.println("Player A, press R to roll the dice.");
            command = input.next();

            if (command.equals("R")) {
                int rolled = A_Player.rollDice();
                if (rolled == 1) {
                    A_Player.setScore(0);
                    System.out.println("You rolled 1, your score is set to 0.");
                } else {
                    if (A_Player.getScore() > 100) {
                        A_Player.setScore(-rolled);
                    } else {
                        A_Player.setScore(rolled);
                    }
                    
                    if (A_Player.isFinished()) {
                        System.out.println("You rolled "+ rolled +", your score is now " + A_Player.getScore()+". Congratulations, you won!");
                        break;
                    } else {
                        System.out.println("You rolled "+ rolled +", your score is now " + A_Player.getScore()+".");
                    }
                }
            }


            
            System.out.println("Player B, press R to roll the dice.");
            command = input.next();

            if (command.equals("R")) {
                int rolled = B_Player.rollDice();
                if (rolled == 1) {
                    B_Player.setScore(0);
                    System.out.println("You rolled 1, your score is set to 0.");
                } else {
                    if (B_Player.getScore() > 100) {
                        B_Player.setScore(-rolled);
                    } else {
                        B_Player.setScore(rolled);
                    }
                    if (B_Player.isFinished()) {
                        System.out.println("You rolled "+ rolled +", your score is now " + B_Player.getScore()+". Congratulations, you won!");
                        break;
                    } else {
                        System.out.println("You rolled "+ rolled +", your score is now " + B_Player.getScore()+".");
                    }
                }
            }

            roundNumber++;
            System.out.println("--------------------------------------");
        }

    }
   
}

class Player {
    int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int points) {
        if (points == 0) {
            score = 0;
        } else {
            score = score + (points);
        }
       
    }

    public int rollDice() {
        java.util.Random dice = new java.util.Random();
        int diceRolled = dice.nextInt(6) + 1;
        return diceRolled;
    }

    public boolean isFinished() {
        if (score == 100) {
            return true;
        } else {
            return false;
        }
    }

}

