package numberGuesser;

import java.util.Scanner;

public class UserInterface {

    Scanner scan;
    Logic logic;
    Difficulty difficulty;



    public UserInterface(Scanner scan) {
        this.scan = scan;
        this.logic = new Logic();
    }

    public void startGame() {
        String newGame = "";
        do {
            printDifficulty();
            int input = getWhichDifficulty();
            if(input == 4){
                break;
            }else{
                getDifficulty(input);
            }

            System.out.println("You've chosen Difficulty: " + difficulty.name());
            logic.difficulty(difficulty);
            String playon = "";
            do {
                guesses();
                System.out.println("Want to play on, new Game or quit?, Y/G/N?");
                playon = scan.nextLine();
            } while (playon.equals("Y"));
            newGame = playon;
        } while (newGame.equals("G"));
        System.out.println("Game Over!!");

    }

    public void printDifficulty() {
        System.out.println("Enter Difficulty:");
        System.out.println("1: Easy (1-50)");
        System.out.println("2: Moderate (1 -100)");
        System.out.println("3: Hard (1 -200)");
        System.out.println("4: Exit");
    }

    public int getInput() {
        int input = 0;
        int bound = difficulty.maxRange;

        boolean run = true;
        while (run) {
            try {
                while (!(input > 0 && input < bound)) {
                    input = Integer.parseInt(scan.nextLine());
                    if (!(input > 0 && input < bound)) {
                        System.out.println("Please enter a valid selection!");
                        continue;
                    }
                    run = false;
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number.");
            }
        }
        return input;
    }

    public int getWhichDifficulty(){
        int input = 0;
        boolean run = true;
        while (run) {
            try {
                while (!(input > 0 && input < 5)) {
                    input = Integer.parseInt(scan.nextLine());
                    if (!(input > 0 && input < 5)) {
                        System.out.println("Please enter a valid selection!");
                        continue;
                    }
                    run = false;
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number.");
            }
        }
        return input;
    }

    public void guesses() {
        int chances = difficulty.maxChances;
        do {
            System.out.println("Take a guess. You have " + chances + " tries.");
            System.out.println("Choose number between 1 and "+ difficulty.maxRange);
            int input = getInput();
            if (logic.takeGuess(input)) {
                System.out.println("Right Guess.");
                break;
            }
            closeness(input);
            chances--;
        } while (chances != 0);

    }

    public void closeness(int guess) {
        int toGuess = logic.getToGuess();
        int closeness = guess - toGuess;
        if (Math.abs(closeness) <= 5) {
            System.out.println("***You are less than or about 5 steps away.***");
        } else {
            System.out.printf((closeness < 0) ? "Try a bit higher. " : "Try a bit lower. ");
        }
    }

    public void getDifficulty(int input){
        switch (input){
            case 1 -> difficulty = Difficulty.Easy;
            case 2 -> difficulty = Difficulty.Medium;
            case 3 -> difficulty = Difficulty.Hard;
            default -> throw new ArithmeticException("Enter a valid number.");
        };

    }

}