package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

import static example.codeclan.com.javaandroidgamenoframework.R.drawable.enemy;
import static example.codeclan.com.javaandroidgamenoframework.R.drawable.enemy1;

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

    private int width, height;

//    Ensure enemy does not leave the screen.
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;

//    limit ship speed
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    private ImageView enemy1_view;
    private AnimationDrawable enemy1Animation;

    private Rect detectCollision;

//    constructor
    public Enemy1(Context context, int screenX, int screenY, ImageView enemy1View){
//        x = screenX - 120;
//        y = screenY - 120;
        speed = 12;
        this.enemy1_view = enemy1View;
        int width = 240;
        int height = 240;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
        enemy1_view.setLayoutParams(parms);
        enemy1_view.setBackgroundResource(R.drawable.enemy1_anim);
        enemy1Animation = (AnimationDrawable) enemy1_view.getBackground();
        enemy1Animation.start();
        //        initially set boosting to false.
//        calculating max screen Y
        maxY = screenY - 240;
        minY = 60;
        maxX = screenX - 120;
        minX = 60;
        boosting = false;

        enemy1_view.setX(maxX);
        enemy1_view.setY(getRandomYStart());
//      initialize rect object
        detectCollision = new Rect((int) enemy1_view.getX(), (int) enemy1_view.getY(), 240, 240);
    }



    public int getRandomYStart(){
        Random ranGen = new Random();
        int number = ranGen.nextInt(maxY);
        return number;
    }

    public float getX(){
        return enemy1_view.getX();
    }

    public void setX(float num){
        this.enemy1_view.setX(num);
    }

    public float getY(){
        return enemy1_view.getY();
    }

    public Rect getDetectCollision() {
        return detectCollision;
    }

//
//    public void setBoosting(){
//        boosting = true;
//    }
//
//    public void stopBoosting(){
//        boosting = false;
//    }
//
//    public void setMovingUp(){
//        movingUp = true;
//    }
//
//    public void stopMovingUp(){
//        movingUp = false;
//    }
//
//    public void setMovingDown(){
//        movingDown = true;
//    }
//
//    public void stopMovingDown(){
//        movingDown = false;
//    }
//
//    public void setMovingLeft(){
//        movingLeft = true;
//    }
//
//    public void stopMovingLeft(){
//        movingLeft = false;
//    }
//
//    public void setMovingRight(){
//        movingRight = true;
//    }
//
//    public void stopMovingRight(){
//        movingRight = false;
//    }
//
//    public Boolean getMovingRight() {
//        return movingRight;
//    }

//    update co-ordinate of character.

    public void update() {
        //decreasing x coordinate so that enemy will move right to left

        float currentPosition = enemy1_view.getX();
        enemy1_view.setX(currentPosition -= speed);
//        x -= speed;
        //if the enemy reaches the left edge
        if (enemy1_view.getX() < minX - 240) {
            //adding the enemy again to the right edge
            Random generator = new Random();
            speed = generator.nextInt(10) + 10;
            enemy1_view.setX(maxX);
            enemy1_view.setY(generator.nextInt(maxY));
        }
        detectCollision.left = (int) enemy1_view.getX();
        detectCollision.right = (int) enemy1_view.getX() + 240;
        detectCollision.top = (int) enemy1_view.getY();
        detectCollision.bottom = (int) enemy1_view.getY() + 240;
    }



    public int getSpeed() {
        return speed;
    }
}
