package audelaurent.schottentotten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import audelaurent.schottentotten.Controler.BoardAdapter;
import audelaurent.schottentotten.Controler.HandAdapter;
import audelaurent.schottentotten.Model.ClanCard;
import audelaurent.schottentotten.Model.Game;
import audelaurent.schottentotten.Model.Hand;
import audelaurent.schottentotten.Model.Stack;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";
    private RecyclerView rvBoard;
    private BoardAdapter adaptBoard;
    private RecyclerView rvHand;
    private HandAdapter adaptHand;
    private TextView etStack;
    private Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        game = new Game("player1" , "player2");

        rvBoard = (RecyclerView) findViewById(R.id.recycler_board);
        adaptBoard = new BoardAdapter(game, this);
        rvBoard.setAdapter(adaptBoard);
        rvBoard.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        rvHand = (RecyclerView) findViewById(R.id.recycler_hand);
        adaptHand = new HandAdapter(game);
        rvHand.setAdapter(adaptHand);
        rvHand.setLayoutManager(new LinearLayoutManager(this));

        etStack = (TextView) findViewById(R.id.stack);
        etStack.setText(""+game.getStack().getClanStack().size());

    }

    public void addCardToBoard(int stone, int pos){
        if( game.getThisPlayer().getPlayerBoard().getStones().get(stone).getCombin().size() < 3) {
            ClanCard movedCard = game.getThisPlayer().getPlayerHand().getHand().get(pos);
            game.getThisPlayer().getPlayerBoard().getStones().get(stone).addCard(movedCard);
            game.getThisPlayer().getPlayerHand().removeCard(pos);
            adaptBoard.notifyItemChanged(stone);
            //adaptBoard.notifyDataSetChanged();
            adaptHand.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "This Stone is full", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickStack(View v){
        Log.d(TAG, "Stack clicked");
        Stack stack = game.getStack();
        Hand hand = game.getThisPlayer().getPlayerHand();

        if(stack.getClanStack().size() > 0) {
            int res = hand.addCard(stack.pickCard());
            if(res == 0) {
                adaptHand.notifyDataSetChanged();
                etStack.setText(""+game.getStack().getClanStack().size());
            } else {
                Toast.makeText(this, "Your Hand is full", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
