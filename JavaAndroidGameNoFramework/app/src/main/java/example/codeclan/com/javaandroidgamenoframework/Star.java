package example.codeclan.com.javaandroidgamenoframework;

import java.util.Random;

/**
 * Created by user on 09/07/2017.
 */

public class Star {

    private int x;
    private int y;
    private int speed;

    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    public Star(int screenX, int screenY){
        maxX = screenX;
        maxY = screenY;
        minX = 0;
        minY = 0;
        Random generator = new Random();
        speed = generator.nextInt(10);
//        generate a random co-ordinate with the screen bounds
        x = generator.nextInt(maxX);
        y = generator.nextInt(maxY);
    }

    public void update(int playerSpeed){
//        animated star horizontal left by decreasing the x
//        in line with player speed.
        x -= playerSpeed;
        x -= speed;
//        when star reaches left edge start again on right.
        if(x < 0){
            x = maxX;
            Random generator = new Random();
            y = generator.nextInt(maxY);
            speed = generator.nextInt(15);
        }
    }

    public float getStarWidth(){
//        Make star width random
        float minX = 1.0f;
        float maxX = 4.0f;
        Random rand = new Random();
        float finalX = rand.nextFloat() * (maxX - minX) + minX;
        return finalX;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
