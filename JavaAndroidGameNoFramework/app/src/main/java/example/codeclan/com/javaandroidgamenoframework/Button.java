package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by user on 17/07/2017.
 */

public class Button {

    //    Bitmap to get button image
    private Bitmap originalBitmap;
    private Bitmap resizedBitmap;
    //    Co-ordinates
    private int x;
    private int y;

    public Button(Context context, int positionX, int positionY, Bitmap bitmap){
        x = positionX;
        y = positionY;
        originalBitmap = bitmap;

        resizedBitmap = Bitmap.createScaledBitmap(
                originalBitmap, 120, 120, false);
//        Get bitmap from drawable resource
//        Use this command when instantiating a button.
//        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);

    }

    public Bitmap getBitmap() {
        return resizedBitmap;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
