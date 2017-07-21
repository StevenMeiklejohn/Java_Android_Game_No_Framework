package example.codeclan.com.javaandroidgamenoframework;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.ImageView;



public class GameActivity extends AppCompatActivity {

    //    declare game view
    private GameView gameView;
    private ImageView playerView;
    private ImageView laserView;


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
//      Construct the gameView
        playerView = (ImageView) findViewById(R.id.player);
        laserView = (ImageView) findViewById(R.id.laser);
        gameView = new GameView(this, size.x, size.y, surfaceView, playerView, laserView);
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
