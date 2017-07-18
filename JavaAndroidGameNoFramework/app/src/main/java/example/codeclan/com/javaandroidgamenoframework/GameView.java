package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by user on 18/07/2017.
 */

public class GameView extends SurfaceView implements Runnable{

    //boolean variable to track if the game is playing or not
    volatile boolean playing;

    //the game thread
    private Thread gameThread = null;
    //    add player
    private Player player;
    private Button btn_up, btn_down, btn_left, btn_right;
    private Bitmap btn_upBitmap;
    private Bitmap btn_downBitmap;
    private Bitmap btn_leftBitmap;
    private Bitmap btn_rightBitmap;
    //    Add objects used for drawing.
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    //   New arrayList of stars
    private ArrayList<Star> stars = new ArrayList<Star>();



    //Class constructor
    public GameView(Context context, int screenX, int screenY) {
        super(context);
//        player = new Player(context, screenX, screenY);
//        btn_upBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.up_white);
//        btn_downBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.down_white);
//        btn_leftBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.left_white);
//        btn_rightBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.right_white);

//        btn_up = new Button(context, 75, 950, btn_upBitmap);
//        btn_down = new Button(context, 75, 750, btn_downBitmap);
//        btn_left = new Button(context, 1500, 950, btn_leftBitmap);
//        btn_right = new Button(context, 1700, 950, btn_rightBitmap);

//        paint = new Paint();
//        surfaceHolder = getHolder();
////        add stars to arrayList
//        int numStars = 100;
//        for(int i = 0; i < numStars; i++){
//            Star s = new Star(screenX, screenY);
//            stars.add(s);
        }



    @Override
    public void run() {
//        while (playing) {
//            //to update the frame
//            update();
//            //to draw the frame
//            draw();
//            //to control
//            control();
//        }
    }
}


