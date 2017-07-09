package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//Game view provides a dedicated drawing surface.

public class GameView extends SurfaceView implements Runnable {

    //boolean variable to track if the game is playing or not
    volatile boolean playing;

    //the game thread
    private Thread gameThread = null;
//    add player
    private Player player;
//    Add objects used for drawing.
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;


    //Class constructor
    public GameView(Context context, int screenX, int screenY) {
        super(context);
        player = new Player(context, screenX, screenY);
        paint = new Paint();
        surfaceHolder = getHolder();

    }

    @Override
    public void run() {
        while (playing) {
            //to update the frame
            update();
            //to draw the frame
            draw();
            //to control
            control();
        }
    }

//    update the co-ords of characters
    private void update() {
        player.update();
    }
//    draw characters to canvas

    private void draw() {
//        check if surface is valid
        if(surfaceHolder.getSurface().isValid()){
//            lock the canvas
            canvas = surfaceHolder.lockCanvas();
//            draw canvas background colour.
            canvas.drawColor(Color.BLACK);
//            Draw the player
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);
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

//Control of player sprite
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
//stop boosting when player releases button.
                player.stopBoosting();
                break;

            case MotionEvent.ACTION_DOWN:
//boost when screen pressed.
                player.setBoosting();
                break;
        }
        return true;
    }
}
