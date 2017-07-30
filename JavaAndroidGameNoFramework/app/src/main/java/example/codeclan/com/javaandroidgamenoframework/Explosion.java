package example.codeclan.com.javaandroidgamenoframework;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by user on 25/07/2017.
 */

public class Explosion {

    private ImageView explosion_view;
    private AnimationDrawable explosionAnimation;
    private Enemy1 enemy;

    public Explosion(Context context, ImageView explosionView, Enemy1 enemy){

        this.explosion_view = explosionView;
        this.enemy = enemy;

        int width = 240;
        int height = 240;
        LinearLayout.LayoutParams exp = new LinearLayout.LayoutParams(width,height);
        explosion_view.setLayoutParams(exp);
        explosion_view.setBackgroundResource(R.drawable.explosion_anim);
        explosionAnimation = (AnimationDrawable) explosion_view.getBackground();
        explosionAnimation.start();
        explosion_view.setX(enemy.getX());
        explosion_view.setY(enemy.getY());
    }
}
