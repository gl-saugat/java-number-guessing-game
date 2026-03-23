package numberGuesser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        Scanner scanner = new Scanner(System.in);
        logic.difficulty(1);
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println(logic.takeGuess(input));;

    }

}
