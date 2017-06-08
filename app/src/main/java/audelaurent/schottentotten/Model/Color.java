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

