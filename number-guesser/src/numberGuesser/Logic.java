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

    public void getNumber(Difficulty difficulty){
        history.clear();
        toGuess = rand.nextInt(difficulty.maxRange)+1;

    }

    public boolean takeGuess(int guess){
        history.add(guess);
        return guess == toGuess;
    }

    public int getToGuess(){
        return toGuess;
    }

    public ArrayList<Integer> getHistory(){
        return history;
    }








}
