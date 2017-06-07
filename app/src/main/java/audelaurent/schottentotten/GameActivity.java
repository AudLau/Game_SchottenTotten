package audelaurent.schottentotten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import audelaurent.schottentotten.Controler.BoardAdapter;
import audelaurent.schottentotten.Controler.HandAdapter;
import audelaurent.schottentotten.Model.Game;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    private RecyclerView RVBoard;
    private BoardAdapter AdaptBoard;
    private RecyclerView RVHand;
    private HandAdapter AdaptHand;
    private Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        game = new Game("player1" , "player2");

        RVBoard = (RecyclerView) findViewById(R.id.recycler_board);
        AdaptBoard = new BoardAdapter(game);
        RVBoard.setAdapter(AdaptBoard);
        RVBoard.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        RVHand = (RecyclerView) findViewById(R.id.recycler_hand);
        AdaptHand = new HandAdapter(game);
        RVHand.setAdapter(AdaptHand);
        RVHand.setLayoutManager(new LinearLayoutManager(this));

    }

    public static void abc(View v){

    }


}
