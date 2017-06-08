package audelaurent.schottentotten.Controler;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Typeface;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import audelaurent.schottentotten.GameActivity;

/**
 * Created by Aude on 05/06/2017.
 */

public class HandClickListener implements View.OnClickListener, View.OnLongClickListener {
    private static final String TAG = "HandClickListener";

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean onLongClick(View v) {
        //Start a drag
        ClipData.Item item = new ClipData.Item(v.getTag().toString());
        ClipData dragData = new ClipData((CharSequence)v.getTag().toString(), new String[]{ ClipDescription.MIMETYPE_TEXT_PLAIN } , item);
        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(v);
        v.startDrag(dragData,  myShadow,  null,  0 );
        return false;
    }



}