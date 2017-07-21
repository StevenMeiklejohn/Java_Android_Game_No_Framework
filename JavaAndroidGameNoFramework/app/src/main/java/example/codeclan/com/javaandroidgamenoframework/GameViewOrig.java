//package example.codeclan.com.javaandroidgamenoframework;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//import android.widget.ImageView;
//
//import java.util.ArrayList;
//
////Game view provides a dedicated drawing surface.
//
//public class GameViewOrig extends SurfaceView implements Runnable {
//
//    //boolean variable to track if the game is playing or not
//    volatile boolean playing;
//
//    //the game thread
//    private Thread gameThread = null;
////    add player
//    private Player player;
//    private Button btn_up, btn_down, btn_left, btn_right;
//    private Bitmap btn_upBitmap;
//    private Bitmap btn_downBitmap;
//    private Bitmap btn_leftBitmap;
//    private Bitmap btn_rightBitmap;
//    //    Add objects used for drawing.
//    private Paint paint;
//    private Canvas canvas;
//    private SurfaceHolder surfaceHolder;
////   New arrayList of stars
//    private ArrayList<Star> stars = new ArrayList<Star>();
//
//
//    //Class constructor
//    public GameViewOrig(Context context, int screenX, int screenY) {
//        super(context);
//        player = new Player(context, screenX, screenY);
//        btn_upBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.up_white);
//        btn_downBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.down_white);
//        btn_leftBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.left_white);
//        btn_rightBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.right_white);
//
//        btn_up = new Button(context, 75, 950, btn_upBitmap);
//        btn_down = new Button(context, 75, 750, btn_downBitmap);
//        btn_left = new Button(context, 1500, 950, btn_leftBitmap);
//        btn_right = new Button(context, 1700, 950, btn_rightBitmap);
//
//        paint = new Paint();
//        surfaceHolder = getHolder();
////        add stars to arrayList
//        int numStars = 100;
//        for(int i = 0; i < numStars; i++){
//            Star s = new Star(screenX, screenY);
//            stars.add(s);
//        }
//
//    }
//
//    @Override
//    public void run() {
//        while (playing) {
//            //to update the frame
//            update();
//            //to draw the frame
//            draw();
//            //to control
//            control();
//        }
//    }
//
////    update the co-ords of characters
//    private void update() {
//        player.update();
////        update stars with player speed
//        for(Star s: stars){
//            s.update(player.getSpeed());
//        }
//
//    }
////    draw characters to canvas
//
//    private void draw() {
////        check if surface is valid
//        if(surfaceHolder.getSurface().isValid()){
////            lock the canvas
//            canvas = surfaceHolder.lockCanvas();
////            draw canvas background colour.
//            canvas.drawColor(Color.BLACK);
////            paint stars in white
//            paint.setColor(Color.WHITE);
////            draw all stars
//            for(Star s: stars){
//                paint.setStrokeWidth(s.getStarWidth());
//                canvas.drawPoint(s.getX(), s.getY(), paint);
//            }
////            Draw the player
//            canvas.drawBitmap(
//                    player.getBitmap(),
//                    player.getX(),
//                    player.getY(),
//                    paint);
////            Draw the button up
//            canvas.drawBitmap(
//                    btn_up.getBitmap(),
//                    btn_up.getX(),
//                    btn_up.getY(),
//                    paint);
////            unlock the canvas
//            //            Draw the button down
//            canvas.drawBitmap(
//                    btn_down.getBitmap(),
//                    btn_down.getX(),
//                    btn_down.getY(),
//                    paint);
////            unlock the canvas
//
//            //            Draw the button left
//            canvas.drawBitmap(
//                    btn_left.getBitmap(),
//                    btn_left.getX(),
//                    btn_left.getY(),
//                    paint);
////            unlock the canvas
//
//            //            Draw the button right
//            canvas.drawBitmap(
//                    btn_right.getBitmap(),
//                    btn_right.getX(),
//                    btn_right.getY(),
//                    paint);
////            unlock the canvas
//            surfaceHolder.unlockCanvasAndPost(canvas);
//        }
//    }
//
////    This method will control the frames per seconds drawn.
////    Here we are calling the delay method of Thread.
////    And this is actually setting our frame rate to around 60fps.
//    private void control() {
//        try {
//            gameThread.sleep(17);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void pause() {
//        //when the game is paused
//        //setting the variable to false
//        playing = false;
//        try {
//            //stopping the thread
//            gameThread.join();
//        } catch (InterruptedException e) {
//        }
//    }
//
//    public void resume() {
//        //when the game is resumed
//        //starting the thread again
//        playing = true;
//        gameThread = new Thread(this);
//        gameThread.start();
//    }
//
//    //Control of player sprite
//    @Override
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
//            case MotionEvent.ACTION_UP:
////stop boosting when player releases button.
//                player.stopBoosting();
//                break;
//
//            case MotionEvent.ACTION_DOWN:
////boost when screen pressed.
//                player.setBoosting();
//                break;
//        }
//        return true;
//    }
//
//    ////control button presses
//////    ImageView img = (ImageView) findViewById(R.id.imageView1);
//    public void setupButtonListeners() {
//
//    }
//
//}
