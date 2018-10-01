package bingo;

import java.util.Observable;

/**
 *
 * @author 92019337 Callum Bartle
 */
public class GameData extends Observable {

    private int currentNumberCall;

    public GameData() {
    }

    public void updateCallNumber(int number) {
        this.currentNumberCall = number;
        setChanged();
        notifyObservers();
    }

    public int getCurrentNumber() {
        return currentNumberCall;
    }
}
