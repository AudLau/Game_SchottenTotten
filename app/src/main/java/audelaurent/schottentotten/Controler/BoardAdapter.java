package audelaurent.schottentotten.Controler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import audelaurent.schottentotten.GameActivity;
import audelaurent.schottentotten.Model.Board;
import audelaurent.schottentotten.Model.ClanCard;
import audelaurent.schottentotten.Model.Color;
import audelaurent.schottentotten.Model.Game;
import audelaurent.schottentotten.R;

import static audelaurent.schottentotten.R.layout.board_list;

/**
 * Created by Aude on 04/06/2017.
 */

public class BoardAdapter extends RecyclerView.Adapter<BoardViewHolder> {
    private static final String TAG = "BoardAdapter";
    private Board boardUp;
    private Board boardDown;
    private GameActivity gameActivity;

    public BoardAdapter(Game game, GameActivity ga) {
        this.boardUp = game.getOtherPlayer().getPlayerBoard();
        this.boardDown = game.getThisPlayer().getPlayerBoard();
        gameActivity = ga;

    }

    @Override
    public BoardViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(board_list, parent, false);
        return new BoardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BoardViewHolder holder, int position) {
        Log.d(TAG, "up combination" + position +" size " + boardUp.getStones().get(position).getCombin().size());
        Log.d(TAG, "down combination" + position +" size " + boardDown.getStones().get(position).getCombin().size());

        BoardClickListener bcl = new BoardClickListener(gameActivity);
        holder.myLayout.setOnDragListener(bcl);
        holder.myLayout.setTag(position);

        final Context cont = holder.cardup1.getContext();
        ClanCard card;


        int size = boardUp.getStones().get(position).getCombin().size();
        if(size>=3){
            card = boardUp.getStones().get(position).getCombin().get(2);
            holder.cardup3.setText(String.valueOf(card.getValue()));
            Drawable background = holder.cardup3.getBackground();
            holder.cardup3.setBackground(cont.getDrawable(Color.colorEnum2Int(card.getColor())));
            holder.cardup3.setBackground(background);
        }else{
//            holder.cardup3.setVisibility(View.INVISIBLE);
        }
        if(size>=2){
            card = boardUp.getStones().get(position).getCombin().get(1);
            holder.cardup2.setText(String.valueOf(card.getValue()));
            Drawable background = holder.cardup2.getBackground();
            holder.cardup2.setBackground(cont.getDrawable(Color.colorEnum2Int(card.getColor())));
        }else{
//            holder.cardup2.setVisibility(View.INVISIBLE);
        }
        if(size>=1){
            card = boardUp.getStones().get(position).getCombin().get(0);
            holder.cardup1.setText(String.valueOf(card.getValue()));
            holder.cardup1.setBackground(cont.getDrawable(Color.colorEnum2Int(card.getColor())));
        }else{
//            holder.cardup1.setVisibility(View.INVISIBLE);
        }

        size = boardDown.getStones().get(position).getCombin().size();
        if(size>=3){
            card = boardDown.getStones().get(position).getCombin().get(2);
            holder.carddown3.setText(String.valueOf(card.getValue()));
            holder.carddown3.setBackground(cont.getDrawable(Color.colorEnum2Int(card.getColor())));
        }else{
//            holder.carddown3.setVisibility(View.INVISIBLE);
        }
        if(size>=2){
            card = boardDown.getStones().get(position).getCombin().get(1);
            holder.carddown2.setText(String.valueOf(card.getValue()));
            holder.carddown2.setBackground(cont.getDrawable(Color.colorEnum2Int(card.getColor())));
        }else{
//            holder.carddown2.setVisibility(View.INVISIBLE);
        }
        if(size>=1){
            card = boardDown.getStones().get(position).getCombin().get(0);
            holder.carddown1.setText(String.valueOf(card.getValue()));
            holder.carddown1.setBackground(cont.getDrawable(Color.colorEnum2Int(card.getColor())));

        }else{
//            holder.carddown1.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return boardUp.getStones().size();
    }



}


