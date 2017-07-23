//package example.codeclan.com.javaandroidgamenoframework;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.drawable.AnimationDrawable;
//import android.view.View;
//import android.widget.ImageView;
//
///**
// * Created by user on 08/07/2017.
// */
//
//public class Laser {
//
//    //    Bitmap to get player image
//    private Bitmap bitmap;
//    //    Co-ordinates
//    private int x;
//    private int y;
//    //    motion speed
//    private int speed;
//    //    boolean to track whether player is 'boosting (increasing y position, or not).
//    private boolean boosting;
//    private boolean movingUp;
//    private boolean movingDown;
//    private boolean movingLeft;
//    private boolean movingRight;
//
//    //    Ensure player does not leave the screen.
//    private int maxX;
//    private int minX;
//    private int maxY;
//    private int minY;
//
//    //    limit ship speed
//    private final int MIN_SPEED = 1;
//    private final int MAX_SPEED = 20;
//
//    private ImageView laserView;
//    private AnimationDrawable laserAnimation;
//
//    //    constructor
//    public Laser(Context context, int screenX, int screenY, ImageView playerView) {
//
//        this.laserView = playerView;
////        Get bitmap from drawable resource
////        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
////        setup player animation
//
//        laserView.setBackgroundResource(R.drawable.laser_anim);
//        laserAnimation = (AnimationDrawable) laserView.getBackground();
//        laserAnimation.start();
//        playerView.setX(600);
//        playerView.setY(600);
//
//
////        initially set boosting to false.
////        calculating max screen Y
//        maxY = screenY - 240;
//
//        minY = 60;
//        maxX = screenX - 120;
//
//        minX = 60;
//        boosting = false;
//    }
//
//    public void update(){
//        if(this.on)
//    }


    //    update co-ordinate of character.
//    public void update() {
////        increase speed if boosting.
//        if (movingUp) {
//            if (laserView.getY() > minY) {
//                float currentPosition = laserView.getY();
//                laserView.setY(currentPosition -= speed);
//            }
//        }
//    }
//}
