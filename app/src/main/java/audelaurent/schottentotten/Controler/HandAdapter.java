package audelaurent.schottentotten.Controler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import audelaurent.schottentotten.GameActivity;
import audelaurent.schottentotten.Model.ClanCard;
import audelaurent.schottentotten.Model.Color;
import audelaurent.schottentotten.Model.Game;
import audelaurent.schottentotten.Model.Hand;
import audelaurent.schottentotten.R;

import static audelaurent.schottentotten.Model.Color.colorEnum2Int;
import static audelaurent.schottentotten.R.layout.hand_list;


/**
 * Created by Aude on 05/06/2017.
 */

public class HandAdapter extends RecyclerView.Adapter<HandViewHolder>  {
    private Hand hand;

    public HandAdapter(Game game) {
        this.hand = game.getThisPlayer().getPlayerHand();
    }

    @Override
    public HandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(hand_list, parent, false);
        return new HandViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HandViewHolder holder, int position) {
        Context cont = holder.cardhand.getContext();
        ClanCard card = hand.getHand().get(position);
        holder.cardhand.setText(""+card.getValue());
        holder.cardhand.setTag(position);
        HandClickListener hcl = new HandClickListener();
        holder.cardhand.setOnClickListener(hcl);
        holder.cardhand.setOnLongClickListener(hcl);

        Drawable background = holder.cardhand.getBackground();
        ((GradientDrawable)background).setColor(ContextCompat.getColor(cont, Color.colorEnum2Int(card.getColor())));

    }

    @Override
    public int getItemCount() {
        return hand.getHand().size();
    }


}
