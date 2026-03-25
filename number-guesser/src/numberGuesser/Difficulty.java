package numberGuesser;

public enum Difficulty {
    Easy(50, 10),
    Medium(100, 7),
    Hard(200, 5);
    public final int maxRange;
    public final int maxChances;

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
