package numberGuesser;

import java.util.ArrayList;
import java.util.Random;

public class Logic {

    ArrayList<Integer> history;
    Random rand = new Random();
    int toGuess;

    public Logic(){
        history = new ArrayList<>();
    }

    public void difficulty(int difficulty){

        if(difficulty<0 || difficulty > 3){
            throw new ArithmeticException("Choose the difficulty properly.");
        }

        switch (difficulty){
            case 1 :
                toGuess = rand.nextInt(50);
                System.out.println(toGuess);
                break;
            case 2:
                toGuess = rand.nextInt(100);
                break;
            case 3:
                toGuess = rand.nextInt(200);
                break;
        }

    }

    public boolean takeGuess(int guess){
        return guess == toGuess;
    }








}
