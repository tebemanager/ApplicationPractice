package com.application.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practice.coinToss.PractiseActivity;
import com.application.practice.databinding.BaseActivityBinding;

/**
 * Created by Charles Raj I on 07/05/22.
 *
 * @author Charles Raj I
 */
public class BaseActivity extends AppCompatActivity {

    Activity activity;
    BaseActivityBinding baseActivityBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = BaseActivity.this;
        baseActivityBinding = BaseActivityBinding.inflate(getLayoutInflater());
        setContentView(baseActivityBinding.getRoot());


        baseActivityBinding.coinToss.setOnClickListener(view -> {
            Intent tossIntent = new Intent(activity, PractiseActivity.class);
            startActivity(tossIntent);
        });

    }
}
