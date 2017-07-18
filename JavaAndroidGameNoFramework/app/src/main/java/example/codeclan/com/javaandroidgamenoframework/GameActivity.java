package example.codeclan.com.javaandroidgamenoframework;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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

//      Construct the gameView
        gameView = new GameView(this, size.x, size.y, surfaceView);
//      Run the gameView.
        gameView.run();
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
