package example.codeclan.com.javaandroidgamenoframework;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View.OnTouchListener;

import static android.R.attr.data;
import static android.R.attr.x;
import static android.R.attr.y;
import static android.app.PendingIntent.getActivity;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by user on 18/07/2017.
 */

public class GameActivity extends AppCompatActivity {

    //    declare game view
    private GameView gameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        getting display object
        Display display = getWindowManager().getDefaultDisplay();
//        getting the screen resolution into point object
        Point size = new Point();
        display.getSize(size);
//        Capture specific gameView in activity_game.
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);

        ImageView imageViewUp = (ImageView) this.findViewById(R.id.up);
        ImageView imageViewDown = (ImageView) this.findViewById(R.id.down);
        ImageView imageViewLeft = (ImageView) this.findViewById(R.id.left);
        ImageView imageViewRight = (ImageView) this.findViewById(R.id.right);


//      Construct the gameView
        gameView = new GameView(this, size.x, size.y, surfaceView);
//      Run the gameView.
        gameView.run();
    }

    public boolean onTouchEvent(MotionEvent event) {
//        Toast.makeText(GameActivity.this, "onTouch Triggered", Toast.LENGTH_SHORT).show();
        int x = (int) event.getX();
        int y = (int) event.getY();

//        Check up button pushed.
        if(x >= 0 && x <= 100 && y >= 830 && y <= 930) {
            if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                gameView.movePlayer("up");
            }
            else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                gameView.stopMovePlayer("up");
            }
        }
//        Check down button pushed.
        if(x >= 0 && x <= 100 && y >= 1010 && y <= 1110) {
            if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                gameView.movePlayer("down");
            }
            else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                gameView.stopMovePlayer("down");
            }
        }
//        Check left button pushed.
        if(x >= 1670 && x <= 1720 && y >= 1010 && y <= 1110) {
            if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                gameView.movePlayer("left");
            }
            else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                gameView.stopMovePlayer("left");
            }
        }
//        Check right button pushed.
        if(x >= 1820 && x <= 1920 && y >= 1010 && y <= 1110) {
            if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
                gameView.movePlayer("right");
            }
            else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                gameView.stopMovePlayer("right");
            }
        }
        return super.onTouchEvent(event);
    }

    //    Pause the game when activity is paused.
    @Override
    public void onPause(){
        super.onPause();
        gameView.pause();
    }

    //    Run the game when the game is resumed.
    @Override
    public void onResume(){
        super.onResume();
        gameView.resume();
    }
}
