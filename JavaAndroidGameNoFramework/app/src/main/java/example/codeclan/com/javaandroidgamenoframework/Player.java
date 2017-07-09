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
//    boolean to track whether player is 'boosting (increasing y position, or not).
    private boolean boosting;

//    Variable to describe how quickly the ship descends when not 'boosting'.
    private final int GRAVITY = -10;

//    Ensure player does not leave the screen.
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;

//    limit ship speed
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

//    constructor
    public Player(Context context, int screenX, int screenY){
        x = 75;
        y = 50;
        speed = 1;
//        Get bitmap from drawable resource
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
//        initially set boosting to false.
//        calculating max screen Y
        maxY = screenY - bitmap.getHeight();
//         top edge's y point is 0 so min y will always be zero
        minY = 0;
        boosting = false;
    }


    public void setBoosting(){
        boosting = true;
    }

    public void stopBoosting(){
        boosting = false;
    }

//    update co-ordinate of character.
    public void update(){
//        increase speed if boosting.
        if(boosting){
            speed += 2;
        }else{
            speed -= 5;
        }
//        controlling top speed
        if(speed > MAX_SPEED){
            speed = MAX_SPEED;
        }
//        controlling min speed
        if(speed < MIN_SPEED){
            speed = MIN_SPEED;
        }
//        move ship down
        y -= speed + GRAVITY;
//        ensure ship does not leave screen
        if(y < minY) {
            y = minY;
        }
        if(y > maxY){
            y = maxY;
        }
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
