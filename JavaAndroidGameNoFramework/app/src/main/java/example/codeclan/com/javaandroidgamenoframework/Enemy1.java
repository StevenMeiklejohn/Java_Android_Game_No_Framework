package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by user on 08/07/2017.
 */

public class Enemy1 {

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

    private ImageView enemy1View;
    private AnimationDrawable enemy1Animation;

//    constructor
    public Enemy1(Context context, int screenX, int screenY, ImageView enemy1View){
//        x = screenX - 120;
//        y = screenY - 120;
        speed = 10;
        this.enemy1View = enemy1View;
//        Get bitmap from drawable resource
//        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
//        setup player animation

        enemy1View.setBackgroundResource(R.drawable.enemy1_anim);
        enemy1Animation = (AnimationDrawable) enemy1View.getBackground();
        enemy1Animation.start();
        enemy1View.setX(300);
        enemy1View.setY(300);



//        initially set boosting to false.
//        calculating max screen Y
        maxY = screenY - 240;

        minY = 60;
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
            if (enemy1View.getY() > minY) {
                float currentPosition = enemy1View.getY();
                enemy1View.setY(currentPosition -= speed);
            }


        }

        //        increase speed if boosting.
        if (movingDown) {
            if (enemy1View.getY() < maxY) {
                float currentPosition = enemy1View.getY();
                enemy1View.setY(currentPosition += speed);
            }


        }

        //        increase speed if boosting.
        if (movingLeft) {
            if (enemy1View.getX() > minX) {
                float currentPosition = enemy1View.getX();
                enemy1View.setX(currentPosition -= speed);
            }

        }

        //        increase speed if boosting.
        if (movingRight) {
            if (enemy1View.getX() < maxX) {
                float currentPosition = enemy1View.getX();
                enemy1View.setX(currentPosition += 15);
            }

        }
    }



    public int getSpeed() {
        return speed;
    }
}
