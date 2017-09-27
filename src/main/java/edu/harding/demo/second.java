package edu.harding.demo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class second extends AppCompatActivity {

    private ImageView mAndroidGuy;
    private ViewGroup mTransitionsContainer;
    private boolean mAndroidVisible = false;
    public ImageView mGoogleLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mAndroidGuy = (ImageView) findViewById(R.id.androidDude);
        mTransitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);
        mGoogleLogo = (ImageView) findViewById(R.id.googleLogo);
    }

    public void onRevealPhoto(View view){
        //Options for second param of beginDelayedTransition:
        //ChangeBounds
        //Fade
        //TransitionSet
        //AutoTransition

        TransitionManager.beginDelayedTransition(mTransitionsContainer);
        mAndroidVisible = !mAndroidVisible;
        mAndroidGuy.setVisibility(mAndroidVisible ? View.VISIBLE : View.GONE);
    }

    public void moveTopLeft(View view){
        mAndroidGuy.animate().translationX(-400).translationY(-100).setDuration(1500);
    }

    public void moveTopRight(View view){
        mAndroidGuy.animate().translationX(400).translationY(-100).setDuration(1500);
    }

    public void moveBottomLeft(View view){
        mAndroidGuy.animate().translationX(-400).translationY(1500).setDuration(1500);
    }

    public void moveBottomRight(View view){
        mAndroidGuy.animate().translationX(400).translationY(1500).setDuration(1500);
    }

    public void startFinalActivity (View view){
        Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
