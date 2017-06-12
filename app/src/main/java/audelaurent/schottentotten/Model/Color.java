package audelaurent.schottentotten.Model;

import audelaurent.schottentotten.R;

/**
 * Created by Aude on 28/05/2017.
 */

public enum Color {
    YELLOW, GREEN, PURPLE, BLUE, RED, GRAY;


    public static int colorEnum2Int(Color c) {
        switch (c) {
            case YELLOW:
                return R.drawable.card_shape_yellow;
            case GRAY:
                return R.drawable.card_shape_grey;
            case GREEN:
                return R.drawable.card_shape_green;
            case RED:
                return R.drawable.card_shape_red;
            case BLUE:
                return R.drawable.card_shape_blue;
            case PURPLE:
                return R.drawable.card_shape_purple;
        }
        return R.color.card_default;
    }
}

