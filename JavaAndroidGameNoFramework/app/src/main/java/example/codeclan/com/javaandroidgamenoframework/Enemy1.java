package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

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

    private ImageView enemy1_view;
    private AnimationDrawable enemy1Animation;

//    constructor
    public Enemy1(Context context, int screenX, int screenY, ImageView enemy1View){
//        x = screenX - 120;
//        y = screenY - 120;
        speed = 10;
        this.enemy1_view = enemy1View;
//        Get bitmap from drawable resource
//        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
//        setup player animation

//        ImageView newEnemy = new ImageView(this);
//        newEnemy.setImageResource(R.drawable.enemy1_anim);
//        picLL.addView(myImage);
//        setContentView(picLL);

//        setContentView(R.id.main);
//        ImageView iv = (ImageView) findViewById(R.id.left);
        int width = 60;
        int height = 60;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
        enemy1_view.setLayoutParams(parms);
        enemy1_view.setBackgroundResource(R.drawable.enemy1_anim);
        enemy1Animation = (AnimationDrawable) enemy1_view.getBackground();
        enemy1Animation.start();
        enemy1_view.setX(400);
        enemy1_view.setY(400);





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

    public Boolean getMovingRight() {
        return movingRight;
    }

//    update co-ordinate of character.

    public void update(int enemySpeed) {
        //decreasing x coordinate so that enemy will move right to left
        x -= enemySpeed;
        x -= speed;
        //if the enemy reaches the left edge
        if (x < minX) {
            //adding the enemy again to the right edge
            Random generator = new Random();
            speed = generator.nextInt(10) + 10;
            x = maxX;
            y = generator.nextInt(maxY);
        }
    }



    public int getSpeed() {
        return speed;
    }
}
