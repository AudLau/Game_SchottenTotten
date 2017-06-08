package audelaurent.schottentotten.Model;

/**
 * Created by Aude on 01/06/2017.
 */

public class Game {
    public Player thisPlayer;
    public Player otherPlayer;
    public Stack stack;

    public Game(String thisPlayerName, String otherPlayerName) {
        thisPlayer = new Player(thisPlayerName);
        otherPlayer = new Player(otherPlayerName);

        stack = new Stack();

        for(int i = 0; i<thisPlayer.getPlayerHand().getMaxCard(); i++){
            thisPlayer.getPlayerHand().addCard(stack.pickCard());
            otherPlayer.getPlayerHand().addCard(stack.pickCard());
        }
    }

    public Player getThisPlayer() {
        return thisPlayer;
    }

    public void setThisPlayer(Player thisPlayer) {
        this.thisPlayer = thisPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
