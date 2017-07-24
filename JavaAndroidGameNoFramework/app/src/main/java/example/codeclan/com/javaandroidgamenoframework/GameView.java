package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.numStars;
import static example.codeclan.com.javaandroidgamenoframework.R.id.surface_layout;


public class GameView extends SurfaceView implements Runnable{

    //boolean variable to track if the game is playing or not
    volatile boolean playing;
    //the game thread
    private Thread gameThread = null;
    //    add player
    private Player player;
    private ImageView enemy_type1_view;
    private Enemy1 enemy1;
    private LinearLayout surface_layout;
//    private Laser laser;
    //    Add objects used for drawing.
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    //   New arrayList of stars
    private ArrayList<Star> stars = new ArrayList<Star>();


    private AnimationDrawable playerAnimation;
    private AnimationDrawable enemy1rAnimation;






    //Class constructor
    public GameView(Context context, int screenX, int screenY, SurfaceView surfaceView, LinearLayout surfaceLayout, ImageView playerView, ImageView enemyType1View) {
        super(context);
        ImageView player_View = playerView;
        ImageView enemy_type1_view = enemyType1View;
        this.surface_layout = surfaceLayout;


        player = new Player(context, screenX, screenY, player_View);
//        laser = new Laser(context, screenX, screenY, laser_View);
        enemy1 = new Enemy1(context, screenX, screenY, enemy_type1_view);


        surface_layout.addView(enemy_type1_view);


        paint = new Paint();
//    Get surface holder from specified SurfaceView as passed in constructor
        surfaceHolder = surfaceView.getHolder();


//    Add stars to arrayList
        int numStars = 100;
        for (int i = 0; i < numStars; i++) {
            Star s = new Star(screenX, screenY);
            stars.add(s);
        }
    }

        @Override
        public void run(){
            while (playing) {
                //to update the frame
                update();
                //to draw the frame
                draw();
                //to control
                control();
            }
        }


     public void movePlayer(String direction){
         if(direction == "up") {
             player.setMovingUp();
         }
         if(direction == "down"){
             player.setMovingDown();
         }
         if(direction == "left"){
             player.setMovingLeft();
         }
         if(direction == "right"){
             player.setMovingRight();
         }
     }

    public void stopMovePlayer(String direction){
        if(direction == "up") {
            player.stopMovingUp();
        }
         if(direction == "down"){
             player.stopMovingDown();
         }
         if(direction == "left"){
             player.stopMovingLeft();
         }
         if(direction == "right"){
             player.stopMovingRight();
         }
    }

//    update the co-ords of characters
    private void update() {
        player.update();
//        enemy1.update(12);
//        update stars with player speed
        for(Star s: stars){
            if(player.getMovingRight()){
                s.update(20);
            }
            s.update(player.getSpeed());
        }

    }
//    draw characters to canvas
    private void draw() {
//        check if surface is valid
        if(surfaceHolder.getSurface().isValid()){
//            lock the canvas
            canvas = surfaceHolder.lockCanvas();
//            draw canvas background colour.
            canvas.drawColor(Color.BLACK);
//            paint stars in white
            paint.setColor(Color.WHITE);
//            draw all stars
            for(Star s: stars){
                paint.setStrokeWidth(s.getStarWidth());
                canvas.drawPoint(s.getX(), s.getY(), paint);
            }
//            Draw the player
//            canvas.drawBitmap(
//                    player.getBitmap(),
//                    player.getX(),
//                    player.getY(),
//                    paint);
//            unlock the canvas
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

//    This method will control the frames per seconds drawn.
//    Here we are calling the delay method of Thread.
//    And this is actually setting our frame rate to around 60fps.
    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        //when the game is paused
        //setting the variable to false
        playing = false;
        try {
            //stopping the thread
            gameThread.join();
        } catch (InterruptedException e) {
        }
    }

    public void resume() {
        //when the game is resumed
        //starting the thread again
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}




