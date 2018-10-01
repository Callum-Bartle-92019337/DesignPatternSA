package bingo;

import java.util.ArrayList;
import static java.util.Arrays.asList;

/**
 *
 * @author 92019337 Callum Bartle
 */
public class BingoGame {

    public static ArrayList<Player> players = new ArrayList();
    public static boolean winner = false;

    public static void addObserversToPlayers(GameData WeeksNumber) {
        players.add(new Player("Tama", asList(3, 4, 1), WeeksNumber));
        players.add(new Player("Amelia", asList(7, 1, 2), WeeksNumber));
        players.add(new Player("Jamal", asList(8, 3, 2), WeeksNumber));
    }

    public static void printTitle() {
        System.out.println("Starting the simple bingo game...");
    }

    public static int genRandomNumber(int n) {
        return (int) (1 + Math.floor(Math.random() * n));
    }

    public static void announceNumber(int num) {
        System.out.println(
                "Calling out a random number between 1 and 10 inclusive.... "
                + "the number is....." + num);
    }

    public static void main(String[] args) {
        GameData observerObject = new GameData();
        int currentNumber;

        printTitle();
        addObserversToPlayers(observerObject);

        while (!winner) {
            currentNumber = genRandomNumber(10);
            announceNumber(currentNumber);
            observerObject.updateCallNumber(currentNumber);
        }

    }
}
