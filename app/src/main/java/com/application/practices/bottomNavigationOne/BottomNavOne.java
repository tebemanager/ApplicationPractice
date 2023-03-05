package com.application.practices.bottomNavigationOne;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.practices.databinding.BottomNavOneBinding;

/**
 * Created by Charles Raj I on 07/05/22.
 *
 * @author Charles Raj I
 */
public class BottomNavOne extends AppCompatActivity {

    Activity activity;
    BottomNavOneBinding bottomNavOneBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = BottomNavOne.this;
        bottomNavOneBinding = BottomNavOneBinding.inflate(getLayoutInflater());
        setContentView(bottomNavOneBinding.getRoot());

    }
}
