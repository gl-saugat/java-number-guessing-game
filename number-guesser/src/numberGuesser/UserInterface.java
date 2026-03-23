package numberGuesser;

import java.util.Scanner;

public class UserInterface {

    Scanner scan;
    Logic logic;
    int difficulty = 0;



    public UserInterface(Scanner scan){
        this.scan = scan;
        this.logic = new Logic();
    }

    public void startGame(){
        String newGame = "";
        do{
            printDifficulty();
            difficulty = getDifficulty();
            logic.difficulty(difficulty);
            System.out.println("You've chosen Difficulty: "+ difficulty);
            String playon = "";
            do{
                guesses();
                System.out.println("Want to play on, new Game or quit?, Y/G/N?");
                playon = scan.nextLine();
            }while(playon.equals("Y"));
            newGame = playon;
        }while(newGame.equals("G"));
        System.out.println("Game Over!!");

    }

    public void printDifficulty(){
        System.out.println("Enter Difficulty:");
        System.out.println("1: Easy (1-50)");
        System.out.println("2: Moderate (1 -100)");
        System.out.println("3: Hard (1 -200");
    }

    public int getDifficulty(){
        boolean run = true;
        while(run){
            try{
                while(!(difficulty>0 && difficulty<4)){
                    difficulty = Integer.parseInt(scan.nextLine());
                    if(!(difficulty>0 && difficulty<4)){
                        System.out.println("Please enter a valid selection!");
                        continue;
                    }
                    run = false;
                }

            }catch (Exception e){
                System.out.println("Enter a valid number.");
            }
        }

        return difficulty;
    }



    public int takeInput(){
        int input = 0;
        boolean run = true;
        while(run){
            try{
                input = Integer.parseInt(scan.nextLine());
                run = false;
            }catch (Exception e){
                System.out.println("Enter a valid number!");
            }
        }
        return input;
    }

    public void guesses(){
        int chances = 8;
        do{
            System.out.println("Take a guess. You have " + chances +" tries.");
            int input = takeInput();
            if(logic.takeGuess(input)){
                System.out.println("Right Guess.");
                break;
            }
            closeness(input);
            chances--;
        }while(chances != 0);

    }

    public void closeness(int guess){
         int toGuess = logic.getToGuess();
         int closeness = guess - toGuess;
         if(Math.abs(closeness) <= 5){
             System.out.println("You are less than or about 5 steps away.");
         }else{
             System.out.println((closeness < 0) ? "Try a bit higher" : "Try a bit lower.");
        }
    }

}
