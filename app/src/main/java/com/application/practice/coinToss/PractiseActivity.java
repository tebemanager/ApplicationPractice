package com.application.practice.coinToss;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practice.R;
import com.application.practice.databinding.ActivityMainBinding;
import com.application.practice.databinding.PractiseActivityBinding;

/**
 * Created by Charles Raj I on 07/05/22.
 *
 * @author Charles Raj I
 */
public class PractiseActivity extends AppCompatActivity {

    PractiseActivityBinding practiseActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        practiseActivityBinding = PractiseActivityBinding.inflate(getLayoutInflater());
        View view = practiseActivityBinding.getRoot();
        setContentView(view);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.buffer_blur);
        practiseActivityBinding.circleCard.startAnimation(animation);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(practiseActivityBinding.circleCard, "rotationX", 0.0f, 360f);
        objectAnimator.setDuration(3600);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();



    }
}
