package edu.harding.demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTestAnimation;
    private TextView mOtherView;
    private ImageView mGoogleLogo;
    private int mShortAnimationDuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("something", "Project start up?");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestAnimation = (TextView) findViewById(R.id.TestAnimation);
        mOtherView = (TextView) findViewById(R.id.OtherView);
        mGoogleLogo = (ImageView) findViewById(R.id.googleLogo);

        mTestAnimation.setVisibility(View.INVISIBLE);
        mOtherView.setVisibility(View.INVISIBLE);

        mOtherView.setVisibility(View.GONE);

        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_longAnimTime);
    }

    public void revealAffect(View view){
        int cx = mTestAnimation.getWidth() / 2;
        int cy = mTestAnimation.getHeight() / 2;

        float finalRadius = (float) Math.hypot(cx, cy);

        Animator anim =
                ViewAnimationUtils.createCircularReveal(mTestAnimation, cx, cy, 0, finalRadius);

        mTestAnimation.setVisibility(View.VISIBLE);
        anim.start();
    }

    public void onCrossfadeClick(View view){
        Log.d("test", "On click");
        crossfade();

    }


    private void crossfade() {
        mOtherView.setAlpha(0);
        mOtherView.setVisibility(View.VISIBLE);

        mOtherView.animate()
                .alpha(1)
                .setDuration(mShortAnimationDuration)
                .setListener(null);


        mTestAnimation.animate()
                .alpha(0)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mTestAnimation.setVisibility(View.GONE);
                    }
                });
    }

    public void startActivity (View view){
        Intent intent = new Intent(this, second.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,mGoogleLogo, getString(R.string.transitionName)).toBundle());
    }
}
