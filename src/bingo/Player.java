package bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author 92019337 Callum Bartle
 */
public class Player implements Observer {

    private final String playerName;
    private final List<Object> playersNumbersList;
    private final ArrayList playersNumbersLeft = new ArrayList();

    //Constructor 
    public Player(String name, List<Object> numbers, Observable observable) {
        this.playerName = name;
        this.playersNumbersList = numbers;
        this.playersNumbersLeft.addAll(numbers);
        observable.addObserver(this);
        System.out.println(this.playerName + " has entered the game, their bingo card numbers are "
                + this.playersNumbersList);
    }

    @Override// Create the update for the observer
    public void update(Observable observable, Object arg) {
        GameData currentNumber = (GameData) observable;
        Object numberCalled = currentNumber.getCurrentNumber();
        if (playersNumbersLeft.contains(numberCalled)) {
            System.out.println(this.playerName + " Got a number :" + numberCalled);
            playersNumbersLeft.remove(numberCalled);

        }
        if (playersNumbersLeft.isEmpty()) {
            System.out.println("BINGO! " + this.playerName
                    + " has all his numbers called! "
                    + this.playerName + " is the WINNER!");
            System.out.println("Winning numbers" + this.playersNumbersList);
            BingoGame.winner = true;
        }

    }
}
