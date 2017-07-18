package example.codeclan.com.javaandroidgamenoframework;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

/**
 * Created by user on 06/07/2017.
 */

public class GameActivityOrig extends AppCompatActivity {

//    declare game view
    private GameViewOrig gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getting display object
        Display display = getWindowManager().getDefaultDisplay();
//        getting the screen resolution into point object
        Point size = new Point();
        display.getSize(size);

//        initialize gameview and pass the screen size to the gameview constructor.
        gameView = new GameViewOrig(this, size.x, size.y);

//        Add to content view
        setContentView(gameView);
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
