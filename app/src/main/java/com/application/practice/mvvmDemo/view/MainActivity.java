package com.application.practice.mvvmDemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;


import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.application.practice.mvvmDemo.adapter.DataAdapter;
import com.application.practice.databinding.ActivityMainBinding;
import com.application.practice.mvvmDemo.model.DataResponse;
import com.application.practice.mvvmDemo.services.DisposableManager;
import com.application.practice.mvvmDemo.viewmodel.MainActivityViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements LifecycleOwner{

    MainActivity context;
    ActivityMainBinding activityMainBinding;
    MainActivityViewModel mainActivityViewModel;
    DataAdapter dataAdapter;
    List<String> one ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        dataAdapter = new DataAdapter(context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        activityMainBinding.mainRecyclerview.setLayoutManager(layoutManager);
        activityMainBinding.mainRecyclerview.setAdapter(dataAdapter);

        mainActivityViewModel = ViewModelProviders.of(context).get(MainActivityViewModel.class);
        mainActivityViewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);


        DisposableManager.addAll(
                mainActivityViewModel.getAllValues()
                        .filter(strings -> {
                            return true;
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(strings -> {
                            if (strings.size() > 0) {
                                one = strings;
                            }
                        }),
                mainActivityViewModel.getAllValues()
                        .filter(strings -> {
                            return true;
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(strings -> {
                            if (strings.size() > 0) {
                                one = strings;
                            }
                        }),
                mainActivityViewModel.getAllValues()
                        .filter(strings -> {
                            return true;
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(strings -> {
                            if (strings.size() > 0) {
                                one = strings;
                            }
                        })

        );


    }

    /*Observe the live data from the view model*/
    Observer<DataResponse> userListUpdateObserver = new Observer<DataResponse>() {
        @Override
        public void onChanged(DataResponse dataResponse) {
            dataAdapter.setDataResponse(dataResponse);
        }
    };
}