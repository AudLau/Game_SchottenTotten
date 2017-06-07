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

    public BoardAdapter(Game game) {
        this.boardUp = game.getOtherPlayer().getPlayerBoard();
        this.boardDown = game.getThisPlayer().getPlayerBoard();
    }

    @Override
    public BoardViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(board_list, parent, false);
        BoardClickListener bcl = new BoardClickListener();
        itemView.setOnClickListener(bcl);
        itemView.setOnLongClickListener(bcl);
        itemView.setOnDragListener(bcl);
        return new BoardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BoardViewHolder holder, int position) {
        Log.d(TAG, "up combination size " + boardUp.getStones().get(position).getCombin().size());
        Log.d(TAG, "down combination size " + boardDown.getStones().get(position).getCombin().size());

        Context cont = holder.cardup1.getContext();
        ClanCard card;

        int size = boardUp.getStones().get(position).getCombin().size();
        if(size>=3){
            card = boardUp.getStones().get(position).getCombin().get(2);
            holder.cardup3.setText(""+card.getValue());
            Drawable background = holder.cardup3.getBackground();
            ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));
        }else{
            holder.cardup3.setVisibility(View.INVISIBLE);
        }
        if(size>=2){
            card = boardUp.getStones().get(position).getCombin().get(1);
            holder.cardup2.setText(""+card.getValue());
            Drawable background = holder.cardup2.getBackground();
            ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));
        }else{
            holder.cardup2.setVisibility(View.INVISIBLE);
        }
        if(size>=1){
            card = boardUp.getStones().get(position).getCombin().get(0);
            holder.cardup1.setText(""+card.getValue());
            Drawable background = holder.cardup1.getBackground();
            ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));
        }else{
            holder.cardup1.setVisibility(View.INVISIBLE);
        }

        size = boardDown.getStones().get(position).getCombin().size();
        if(size>=3){
            card = boardDown.getStones().get(position).getCombin().get(2);
            holder.carddown3.setText(""+card.getValue());
            Drawable background = holder.carddown3.getBackground();
            ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));
        }else{
            holder.carddown3.setVisibility(View.INVISIBLE);
        }
        if(size>=2){
            card = boardDown.getStones().get(position).getCombin().get(1);
            holder.carddown2.setText(""+card.getValue());
            Drawable background = holder.carddown2.getBackground();
            ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));
        }else{
            holder.carddown2.setVisibility(View.INVISIBLE);
        }
        if(size>=1){
            card = boardDown.getStones().get(position).getCombin().get(0);
            holder.carddown1.setText(""+card.getValue());
            Drawable background = holder.carddown1.getBackground();
            ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, colorEnum2Int(card.getColor())));
        }else{
            holder.carddown1.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return boardUp.getStones().size();
    }

    private int colorEnum2Int(Color c){
        switch(c){
            case YELLOW:
                return R.color.card_yellow;
            case GRAY:
                return R.color.card_gray;
            case GREEN:
                return R.color.card_green;
            case RED:
                return R.color.card_red;
            case BLUE:
                return R.color.card_blue;
            case PURPLE:
                return R.color.card_purple;
        }
        return R.color.card_default;
    }


}


