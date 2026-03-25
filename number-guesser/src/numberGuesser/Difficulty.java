package numberGuesser;

public class Difficulty {
    Difficulty.Easy(50, 10),
    Difficulty.Medium(100, 7),
    Difficulty.Hard(200, 5);
    int maxRange;
    int maxChances;

    Difficulty(int maxRange, int maxChances){
        this.maxRange = maxRange;
        this. maxChances = maxChances;
    }

    public int getMaxRange(){
        return this.maxRange;
    }
    public int getMaxChances(){
        return this.maxChances;
    }
}
