package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.widget.ImageView;

import static android.R.attr.max;
import static android.R.attr.min;

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
    private boolean movingUp;
    private boolean movingDown;
    private boolean movingLeft;
    private boolean movingRight;

//    Ensure player does not leave the screen.
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;

//    limit ship speed
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    private ImageView playerView;
    private AnimationDrawable playerAnimation;

//    constructor
    public Player(Context context, int screenX, int screenY, ImageView playerView){
//        x = screenX - 120;
//        y = screenY - 120;
        speed = 10;
        this.playerView = playerView;
//        Get bitmap from drawable resource
//        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
//        setup player animation

        playerView.setBackgroundResource(R.drawable.player_anim);
        playerAnimation = (AnimationDrawable) playerView.getBackground();
        playerAnimation.start();
        playerView.setX(120);
        playerView.setY(120);



//        initially set boosting to false.
//        calculating max screen Y
        maxY = screenY - 120;

        minY = 120;
        maxX = screenX - 120;

        minX = 60;
        boosting = false;
    }


    public void setBoosting(){
        boosting = true;
    }

    public void stopBoosting(){
        boosting = false;
    }

    public void setMovingUp(){
        movingUp = true;
    }

    public void stopMovingUp(){
        movingUp = false;
    }

    public void setMovingDown(){
        movingDown = true;
    }

    public void stopMovingDown(){
        movingDown = false;
    }

    public void setMovingLeft(){
        movingLeft = true;
    }

    public void stopMovingLeft(){
        movingLeft = false;
    }

    public void setMovingRight(){
        movingRight = true;
    }

    public void stopMovingRight(){
        movingRight = false;
    }

    public Boolean getMovingRight(){
        return movingRight;
    }

//    update co-ordinate of character.
    public void update() {
//        increase speed if boosting.
        if (movingUp) {
            if (playerView.getY() > minY) {
                float currentPosition = playerView.getY();
                playerView.setY(currentPosition -= speed);
            }
//            y -= speed;

////        controlling top speed
//            if (speed > MAX_SPEED) {
//                speed = MAX_SPEED;
//            }
////        controlling min speed
//            if (speed < MIN_SPEED) {
//                speed = MIN_SPEED;
//            }

//        ensure ship does not leave screen
//            if (playerView.getTop() <= minY) {
//                playerView.setY(minY + playerView.getHeight());
//            }

        }

        //        increase speed if boosting.
        if (movingDown) {
            if (playerView.getY() < maxY) {
                float currentPosition = playerView.getY();
                playerView.setY(currentPosition += speed);
            }

////        controlling top speed
//            if (speed > MAX_SPEED) {
//                speed = MAX_SPEED;
//            }
////        controlling min speed
//            if (speed < MIN_SPEED) {
//                speed = MIN_SPEED;
//            }

//        ensure ship does not leave screen
//            if (playerView.getBottom() >= maxY) {
//                playerView.setY(maxY - playerView.getHeight());
//            }
        }

        //        increase speed if boosting.
        if (movingLeft) {
            if (playerView.getX() > minX) {
                float currentPosition = playerView.getX();
                playerView.setX(currentPosition -= speed);
            }

////        controlling top speed
//            if (speed > MAX_SPEED) {
//                speed = MAX_SPEED;
//            }
////        controlling min speed
//            if (speed < MIN_SPEED) {
//                speed = MIN_SPEED;
//            }
//
////        ensure ship does not leave screen
//            if (playerView.getLeft() <= minX) {
//                playerView.setX(minX + playerView.getWidth());
//            }
        }

        //        increase speed if boosting.
        if (movingRight) {
            if (playerView.getX() < maxX) {
                float currentPosition = playerView.getX();
                playerView.setX(currentPosition += 15);
            }


////        controlling top speed
//            if (speed > MAX_SPEED) {
//                speed = MAX_SPEED;
//            }
////        controlling min speed
//            if (speed < MIN_SPEED) {
//                speed = MIN_SPEED;
//            }

//        ensure ship does not leave screen
//            if (playerView.getX() < minX) {
//                playerView.setX(minX);
//            }
//            if (playerView.getRight() >= maxX) {
//                playerView.setX(maxX - playerView.getWidth());
//            }
        }
    }

//    public Bitmap getBitmap() {
//        return bitmap;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }

    public int getSpeed() {
        return speed;
    }
}
