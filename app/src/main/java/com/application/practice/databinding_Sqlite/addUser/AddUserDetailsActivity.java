package com.application.practice.databinding_Sqlite.addUser;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import com.application.practice.R;
import com.application.practice.databinding.AddUserDetailsBinding;

/**
 * Created by Charles Raj I on 25/07/22.
 *
 * @author Charles Raj I
 */

/*We are going to use MVVM with Live data so we need to implement Lifecycler owner.*/
public class AddUserDetailsActivity extends AppCompatActivity implements LifecycleOwner {

    /*For databinding we need to use the class name with the xml file name and  ending with binding */
    Activity activity;
    AddUserDetailsBinding addUserDetailsBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        /*Layout is binded with the activity.. now create the View model class*/
        addUserDetailsBinding = DataBindingUtil.setContentView(activity, R.layout.add_user_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
