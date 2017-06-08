package audelaurent.schottentotten.Controler;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;

import audelaurent.schottentotten.GameActivity;

/**
 * Created by Aude on 05/06/2017.
 */

public class BoardClickListener implements  View.OnDragListener {
    private static final String TAG = "BoardClickListener";
    private GameActivity gameActivity;

    public BoardClickListener (GameActivity ga) {
        this.gameActivity = ga;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DROP:
                int stonePos = (int) v.getTag();
                int handPos = Integer.valueOf(String.valueOf(event.getClipData().getDescription().getLabel() ) );
                Log.d("OndragListener", "--- DROPPED ---  with tag " + stonePos + "and source " + handPos);
                gameActivity.addCardToBoard(stonePos, handPos );
                break;
        }
        return true;
    }

}
