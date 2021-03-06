package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.widget.ImageView;

import static android.R.attr.max;
import static android.R.attr.min;
import static android.R.attr.width;

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

    private int width, height;
    private Rect detectCollision;

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
        int width = 240;
        int height = 240;
        playerView.setBackgroundResource(R.drawable.player_anim);
        playerAnimation = (AnimationDrawable) playerView.getBackground();
        playerAnimation.start();
        playerView.setX(120);
        playerView.setY(120);



//        initially set boosting to false.
//        calculating max screen Y
        maxY = screenY - 240;
        minY = 60;
        maxX = screenX - 120;
        minX = 60;
        boosting = false;

        detectCollision = new Rect((int) playerView.getX(), (int) playerView.getY(), 240, 240);
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
        }

        //        increase speed if boosting.
        if (movingDown) {
            if (playerView.getY() < maxY) {
                float currentPosition = playerView.getY();
                playerView.setY(currentPosition += speed);
            }
        }

        //        increase speed if boosting.
        if (movingLeft) {
            if (playerView.getX() > minX) {
                float currentPosition = playerView.getX();
                playerView.setX(currentPosition -= speed);
            }
        }
        //        increase speed if boosting.
        if (movingRight) {
            if (playerView.getX() < maxX) {
                float currentPosition = playerView.getX();
                playerView.setX(currentPosition += 15);
            }
        }
        //adding top, left, bottom and right to the rect object
        detectCollision.left = (int) playerView.getX();
        detectCollision.top = (int) playerView.getY();
        detectCollision.right = (int) playerView.getX() + 240;
        detectCollision.bottom = (int) playerView.getY() + 240;
    }

    //one more getter for getting the rect object
    public Rect getDetectCollision() {
        return detectCollision;
    }

    public int getSpeed() {
        return speed;
    }
}
