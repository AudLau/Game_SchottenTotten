package audelaurent.schottentotten.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

import static audelaurent.schottentotten.R.id.stack;

/**
 * Created by Aude on 28/05/2017.
 */

public class Stack {

    private static final String TAG = "Stack";
    ArrayList<ClanCard> clanStack = new ArrayList<>();


    public Stack() {
        initializeStacks();
    }

    public ArrayList<ClanCard> getClanStack() {
        return clanStack;
    }

    public void setClanStack(ArrayList<ClanCard> clanStack) {
        this.clanStack = clanStack;
    }

    /**
     * Add all the cards to the stack and shuffle them
     */
    public void initializeStacks(){
        for(Color col: Color.values()){
            for (int i=0; i<9; i++){
                clanStack.add(new ClanCard(col, i+1));
            }
        }
        Collections.shuffle(clanStack);
        Log.d(TAG, "stack shuffled" + clanStack);
    }

    /**
     * Return the first card on the stack and delete it from the stack
     * @return the card picked i.e. the first card on the stack
     */
    public ClanCard pickCard(){
        if(!clanStack.isEmpty()){
            ClanCard temp = clanStack.get(0);
            clanStack.remove(0);
            Log.d(TAG, "card removed:" + temp);
            return temp;
        } else {
            return null;
        }
    }

}
