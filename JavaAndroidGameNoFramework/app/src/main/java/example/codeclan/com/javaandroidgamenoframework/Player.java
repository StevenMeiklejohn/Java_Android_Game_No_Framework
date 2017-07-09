package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by user on 08/07/2017.
 */

public class Player {

//    Bitmap to get player image
    private Bitmap bitmap;
//    Co-ordinates
    private int x;
    private int y;
//    motion speed
    private int speed;

//    constructor
    public Player(Context context){
        x = 75;
        y = 50;
        speed = 1;
//        Get bitmap from drawable resource
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
    }

//    update co-ordinate of character.
    public void update(){
        x++;
        y++;
    }

//    getters


    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}
