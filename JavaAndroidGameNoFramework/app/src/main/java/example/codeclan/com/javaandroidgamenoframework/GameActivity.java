package example.codeclan.com.javaandroidgamenoframework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 06/07/2017.
 */

public class GameActivity extends AppCompatActivity {

//    declare game view
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        initialize gameview
        gameView = new GameView(this);

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
