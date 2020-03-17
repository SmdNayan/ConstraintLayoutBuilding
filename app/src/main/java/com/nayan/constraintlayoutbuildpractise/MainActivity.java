package com.nayan.constraintlayoutbuildpractise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private ConstraintSet constraintSetOne = new ConstraintSet();
    private ConstraintSet constraintSetTwo = new ConstraintSet();
    private boolean altLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        constraintSetOne.clone(layout);
        constraintSetTwo.clone(this, R.layout.alter_activity);
    }

    public void swapView(View v){
        Transition changeTrans = new ChangeBounds();
        changeTrans.setInterpolator(new OvershootInterpolator());

        TransitionManager.beginDelayedTransition(layout, changeTrans);
        if (!altLayout){
            constraintSetTwo.applyTo(layout);
            altLayout = true;
        } else {
            constraintSetOne.applyTo(layout);
            altLayout = false;
        }
    }
}
