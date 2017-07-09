package example.codeclan.com.javaandroidgamenoframework;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Created by user on 09/07/2017.
 */

//public class AnimationView {
//
//
//
////This method adds a new AnimatedSprite to the collection that will be drawn.
//// And it sets to position to the position of where Android detected a Touch event.
////    If you dont want the sprites to loop set the last property of a.Initialize to false
//
//    public void doTouch(MotionEvent event){
//
//        int action = event.getAction();
//        float x = event.getX();  // or getRawX();
//        float y = event.getY();
//
//        switch(action){
//            case MotionEvent.ACTION_DOWN:
//                if(mMode != STATE_RUNNING)
//                    setState(STATE_RUNNING);
//                else if(mMode == STATE_RUNNING){
//
//                    AnimatedSprite a = new AnimatedSprite();
//
//                    if(b == null)
//                        b = BitmapFactory.decodeStream(res.openRawResource(R.drawable.explosion));
//
//                    a.Initialize(b, 120, 160, 24, 20, true);
//
//                    a.setXPos((int)x);
//                    a.setYPos((int)y);
//
//                    synchronized(mSprites){
//                        mSprites.add(a);
//                    }
//                }
//                break;
//        }
//    }
//
//
////My game loop calls 2 methods: doDraw & updatePhysics.
//// The updatePhysics updates the sprites. The other just paints the Sprites.
//
//    private void updatePhysics() {
//        long now = System.currentTimeMillis();
//
//        // Do nothing if mLastTime is in the future.
//        // This allows the game-start to delay the start of the physics
//        // by 100ms or whatever.
//        if (mLastTime > now) return;
//
//        if (mLastTime != 0) {
//            int time = (int) (now - mLastTime);
//            frameSampleTime += time;
//            frameSamplesCollected++;
//            if (frameSamplesCollected == 10) {
//                fps = (int) (10000 / frameSampleTime);
//                frameSampleTime = 0;
//                frameSamplesCollected = 0;
//            }
//        }
//
//        synchronized(mSprites){
//            for( AnimatedSprite a : mSprites){
//                a.Update(now);
//
//                if(a.dispose)
//                    mSpritestoRemove.add(a);
//            }
//        }
//
//        synchronized(mSpritestoRemove){
//            mSprites.removeAll(mSpritestoRemove);
//            mSpritestoRemove.clear();
//        }
//
//        numSprites = mSprites.size();
//        mLastTime = now;
//
//    }
//
//
//    private void doDraw(Canvas canvas) {
//        // Draw the background image. Operations on the Canvas accumulate
//        // so this is like clearing the screen.
//        //canvas.drawBitmap(mBackgroundImage, 0, 0, null);
//        canvas.drawColor(Color.BLACK);
//
//        for( AnimatedSprite a : mSprites){
//            a.draw(canvas);
//        }
//
//        if(mMode == STATE_RUNNING ){
//            canvas.drawText(fps + " fps", getWidth() - 60, getHeight() - 40, textPaint);
//            canvas.drawText(numSprites + " sprites", getWidth() - 60, getHeight() - 20, textPaint);
//        }
//
//        canvas.restore();
//    }
//}
